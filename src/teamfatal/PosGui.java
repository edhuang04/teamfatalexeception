package teamfatal; /**
 * Created by Trenton on 3/6/2015.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    private JButton button2;
    private JButton button3;
    private JButton btnAddTable;
    private JButton btnLogin;
    private JPanel FoodItems;
    private JPanel PanelBeverages;
    private JPanel PanelSalads;
    private JPanel PanelSoups;
    private JPanel PanelDessert;
    private JPanel tablePanel;
    private JLabel labelTime;
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
    private JTextField textField1;
    private JTextField textField2;
    private JButton currentOrderButton;
    private JLabel label2;

    //Other items
    private int multiplier = 1;
    List<Category> categories;
    List<FoodItem> foodItems;
    List<TableItem> tableItems;
    Receipt currentReceipt;

    public PosGui() {
        setContentPane(rootPanel);
        setTitle("Restaurant POS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        categories = new ArrayList<Category>();
        foodItems = new ArrayList<FoodItem>();
        setupButtons();
//        loadCategoriesButtons();
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        pack();
        setVisible(true);
        btnSlice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                currentReceipt.addItem(new FoodItem("Pizza", 3));
                model.fireTableDataChanged();
                table5.repaint();
            }
        });
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
    }

    private void tryLogin()
    {
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardTable");
    }

    private void addTable()
    {
        TableItem tableNew = new TableItem();
        tablePanel.add(tableNew);
        tableNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableClicked((TableItem) e.getSource());
            }
        });
        tablePanel.updateUI();
    }

    /**
     * When table is clicked, update the displayable receipt with the chosen table
     * @param myTable
     */
    private void tableClicked(TableItem myTable)
    {
        currentReceipt = myTable.getReceipt();

        List<FoodItem> myFoodItems = currentReceipt.getOrderedItems();

        for (FoodItem myItem : myFoodItems) {
            model.addRow(new Object[]{myItem.getPrice(), myItem.toString()});
        }

        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardOrder");
    }

    /**
     *
     */
    private void logOff()
    {
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardLogin");
    }

    /**lk
     *
     */
    private void exitToTables()
    {
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardTable");
    }

    private void loadFoodItems()
    {

    }

    /**
     * Sets up button action listeners
     */
    private void setupButtons()
    {

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

    DefaultTableModel model;
    private void createUIComponents() {
        // TODO: place custom component creation code here
        model = new DefaultTableModel();
        String headers[] = new String[]{};
        model.setColumnIdentifiers(headers);
        table5 = new JTable();
        model.addRow(new Object[]{"best", "buds"});
        table5.setModel(model);
        table5.repaint();
        table5.updateUI();
        imagePanel1 = new ImagePanel();
    }
}