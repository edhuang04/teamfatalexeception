package teamfatal; /**
 * Created by Trenton on 3/6/2015.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;
import java.util.List;

public class PosGui extends JFrame{
    //GUI Items
    private JPanel rootPanel;
    private JPanel TableMenu;
    private JPanel OrderMenu;
    private JButton btnOrderExit;
    private JPanel LoginMenu;
    private JButton btnTableExit;
    private JButton btnServer;
    private JButton btnManager;
    private JButton btnCheckout;
    private JButton btn9x;
    private JButton btn8x;
    private JButton btn7x;
    private JButton btn6x;
    private JButton btn2x;
    private JButton btn5x;
    private JButton btn4x;
    private JButton btn3x;
    private JButton btn10x;
    private JPanel OrderToolsPanel;
    private JPanel OrderMenuPanel;
    private JButton btnPrintReceipt;
    private JButton btnAddTable;
    private JButton btnLogin;
    private JPanel FoodItems;
    private JPanel PanelBeverages;
    private JPanel PanelSalads;
    private JPanel PanelSoups;
    private JPanel PanelDessert;
    private JPanel tablePanel;
    private JPanel panelTopbar;
    private JTable table5;
    private JButton btnSlice;
    private JButton EXITButton;
    private JButton DINEINButton;
    private JButton CARRYOUTButton;
    private JButton btnPlus;
    private JButton btnMinus;
    private JTextField QuantityCoutn;
    private JButton baconButton;
    private JButton btnMarinara;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton smallButton;
    private JButton extraLargeButton;
    private JButton mediumButton;
    private JButton largeButton;
    private JButton deepDishButton;
    private JButton originalButton;
    private JButton thinCrustButton;
    private JTabbedPane tabbedPane1;
    private ImagePanel imagePanel1;
    private JLabel imageSmoothie;
    private JTextField textFieldUser;
    private JPasswordField passwordFieldUser;
    private JButton loginButton;
    private JButton merge;
    private JButton button1;
    private RightBooth rightBooth1;
    private RightBooth rightBooth2;
    private RightBooth rightBooth3;
    private RightBooth rightBooth4;
    private RightBooth rightBooth5;
    private RightBooth rightBooth6;
    private JLabel labelWarning;
    private JButton toGoButton;
    private JTable receiptTable;
    private JScrollPane scrollPane1;
    private JButton currentOrderButton;
    private JLabel label2;

    //Other items
    List<Category> categories;
    List<FoodItem> foodItems;
    List<Table> tableItems;
    ReceiptModel model;
    Map<String, String> userGroup;
    Map<String, String> adminGroup;
    Table firstMerge;

    int merging = -1;

    public PosGui() {
        categories = new ArrayList<Category>();
        foodItems = new ArrayList<FoodItem>();

        setContentPane(rootPanel);
        setTitle("Restaurant POS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setupButtons();
        loadLogins();
        loadTables();

        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        pack();
        setVisible(true);
        imageSmoothie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Smoothie", 5));
            }
        });
        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                merging = 0;
            }
        });
    }

    private void myRepaint()
    {
        this.repaint();
    }
    /**
     * Loads the users and passwords from Logins.txt into the userGroup HashMap and the adminGroup HashMap
     */
    private void loadLogins()
    {
        userGroup = new HashMap<String, String>();
        adminGroup = new HashMap<String, String>();

        File i = new File("Resources/Data/Logins.txt");
        try {
            Scanner myFile = new Scanner(i);

            while(myFile.hasNext())
            {
                switch(myFile.nextInt())
                {
                    case 1:
                        userGroup.put(myFile.next(), myFile.next());
                        break;
                    case 2:
                        adminGroup.put(myFile.next(), myFile.next());
                        break;
                }
            }

            myFile.close();
        }

        catch(Exception e)
        {

        }
    }

    /**
     * Attempt to login using the username textfield and the password textfield
     */
    private void tryLogin()
    {
        String username = textFieldUser.getText();
        String password = new String(passwordFieldUser.getPassword());

        if(userGroup.containsKey(username))
        {
            if(userGroup.get(username).equals(password))
            {
                CardLayout myLayout = (CardLayout) rootPanel.getLayout();
                myLayout.show(rootPanel, "CardTable");
                labelWarning.setVisible(false);
            }
        }
        else if(adminGroup.containsKey(username))
        {
            if(adminGroup.get(username).equals(password))
            {
                CardLayout myLayout = (CardLayout) rootPanel.getLayout();
                myLayout.show(rootPanel, "CardTable");
                labelWarning.setVisible(false);
            }
        }
        else
        {
            labelWarning.setVisible(true);
        }

        textFieldUser.setText("");
        passwordFieldUser.setText("");
    }

    /**
     *
     */
    private void loadTables()
    {
        try {
            File j = new File("Resources/Data/Tables.txt");
            Scanner in = new Scanner(j);

            int numTables = in.nextInt();
            for(int i = 0; i < numTables; ++i)
                addTable();

            in.close();
        }
        catch(Exception e)
        {

        }
    }

    /**
     * Adds a table to the tablelayout
     */
    private void addTable()
    {
        Table tableNew = new Table();
        tablePanel.add(tableNew);
        tableNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableClicked((Table) e.getSource());
            }
        });
        tablePanel.updateUI();

        try
        {
            File j = new File("Resources/Data/Tables.txt");
            Scanner in = new Scanner(j);

            int numTables = in.nextInt();
            ++numTables;
            FileWriter q = new FileWriter(j);
            q.write(Integer.toString(numTables));
            in.close();
            q.close();
        }
        catch(Exception e)
        {

        }
    }

    /**
     * When table is clicked, update the displayable receipt with the chosen table
     * @param myTable
     */
    private void tableClicked(Table myTable)
    {
        if(merging != -1)
        {
            model.loadTable(myTable);
            CardLayout myLayout = (CardLayout) rootPanel.getLayout();
            myLayout.show(rootPanel, "CardOrder");
        }
        else
        {
            if(merging == 0)
            {
                firstMerge = myTable;
                merging = 1;
            }
            else
            {
                tablePanel.add(new MultiTable(firstMerge, myTable));
                tablePanel.remove(firstMerge);
                tablePanel.remove(myTable);
            }
        }
    }

    /**
     *  Currently switches to the login card
     */
    private void logOff()
    {
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardLogin");
    }

    /**
     * Switch card layout to the tablelayout
     */
    private void exitToTables()
    {
        model.clearReceipt();
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardTable");
    }

    /**
     * Loads the food items for the FoodMenu.txt
     */
    private void loadFoodItems()
    {

    }

    /**
     * Sets up button action listeners
     */
    private void setupButtons()
    {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tryLogin();
            }
        });
//        btnSlice.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                currentReceipt.addItem(new FoodItem("Pizza", 3));
//                model.fireTableDataChanged();
//                table5.repaint();
//            }
//        });
        CARRYOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        btnPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int temp = Integer.parseInt(QuantityCoutn.getText());
                ++temp;
                QuantityCoutn.setText(Integer.toString(temp));

            }
        });

        btnOrderExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                exitToTables();
            }
        });

        btnTableExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                logOff();
            }
        });

        btnAddTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addTable();
            }
        });

//        btnLogin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                tryLogin();
//            }
//        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        paintLoginScreen();
        receiptTable = new JTable();
        model = new ReceiptModel(1, 3);
        receiptTable.setModel(model);
        receiptTable.setShowGrid(false);
        model.setColumnIdentifiers(new Object[] {"Quantity", "Description", "Price"});
    }

    private void paintLoginScreen()
    {
        imagePanel1 = new ImagePanel();
    }
}