package teamfatal; /**
 * Created by Trenton on 3/6/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.text.NumberFormat;
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
    private JPanel tablePanel;
    private JPanel panelTopbar;
    private JTable table5;
    private JButton btnSlice;
    private JButton EXITButton;
    private JButton DINEINButton;
    private JButton CARRYOUTButton;
    private JButton btnPlus;
    private JTextField QuantityCoutn;
    private JTabbedPane tabbedPane1;
    private ImagePanel imagePanel1;
    private JLabel imageSmoothie;
    private JTextField textFieldUser;
    private JPasswordField passwordFieldUser;
    private JButton loginButton;
    private JButton merge;
    private JLabel labelWarning;
    private JButton toGoButton;
    private JTable receiptTable;
    private JScrollPane scrollPane1;
    private JLabel imageSparker;
    private JPanel managerPanel;
    private RightBooth rightBooth1;
    private RightBooth rightBooth2;
    private LeftBooth leftBooth1;
    private LeftBooth leftBooth2;
    private LeftBooth leftBooth3;
    private RightBooth rightBooth3;
    private ImagePanel BackgroundPanel;
    private JPanel LoginInputPanel;
    private JPanel leftBoothPanel;
    private JPanel rightBoothPanel;
    private JPanel RestLayout;
    private JPanel togoPanel;
    private JToggleButton smallToggleButton;
    private JButton btnAddPizza;
    private JToggleButton btnMarinara;
    private JToggleButton toggleOriginal;
    private JToggleButton toggleThin;
    private JToggleButton toggleDeep;
    private JToggleButton mediumToggleButton;
    private JToggleButton largeToggleButton;
    private JToggleButton extraLargeToggleButton;
    private JTextField totalText;
    private JButton addOrderButton;
    private JToggleButton btnBacon;
    private JToggleButton btnMozzarella;
    private JToggleButton btnMushrooms;
    private JToggleButton btnPepperoni;
    private JToggleButton btnBlackOlives;
    private JToggleButton btnItalianSausage;
    private JToggleButton btnTomatoes;
    private JToggleButton btnChicken;
    private JToggleButton btnPineapple;
    private JToggleButton btnHam;
    private JToggleButton btnRedOnion;
    private JButton btnRemoveTable;
    private JSplitPane tableAdminSplit;
    private JSplitPane split2;
    private JPanel Salads;
    private JScrollBar scrollBar1;
    private JLabel imageSouffleCake;
    private JLabel imageCaramelPudding;
    private JLabel imageKeyLime;
    private JLabel imageRedVelvet;
    private JLabel imageTiramisu;
    private JLabel imageBerryFizz;
    private JLabel imageWrap;
    private JLabel imageEggRolls;
    private JLabel imageWedge;
    private JLabel imageFlatBread;
    private JLabel imageSedona;
    private JLabel imageSangria;
    private JLabel imageCalifornia;
    private JLabel imageBBQ;
    private JLabel imageCaVeggie;
    private JLabel imageSalmon;
    private JLabel imageAsparagus;
    private ButtonGroup Crust;
    private ButtonGroup Size;
    private JButton currentOrderButton;
    private JLabel label2;

    //Other items
    List<Category> categories;
    List<FoodItem> foodItems;
    List<Table> tableItems;
    ReceiptModel model;
    Table currentTable;
    Booth currentBooth;
    ToGoOrder currentOrder;
    Map<String, String> userGroup;
    Map<String, String> adminGroup;
    Table firstMerge;

    int merging = -1;
    int removing = -1;

    /**
     * Initializes the main root Frame with everything loaded onto it.
     */
    public PosGui() {
        categories = new ArrayList<Category>();
        foodItems = new ArrayList<FoodItem>();

        setContentPane(rootPanel);
        setTitle("Restaurant POS");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setupButtons();
        loadLogins();
        loadTables();
        setupBooths();
        this.setUndecorated(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        pack();
        setVisible(true);
        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                merging = 0;
            }
        });
        btnCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                checkout();
            }
        });

        toGoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CardLayout myLayout = (CardLayout) RestLayout.getLayout();
                myLayout.show(RestLayout, "CardTogo");
                merge.setVisible(false);
                addOrderButton.setVisible(true);
                currentOrder = (ToGoOrder) actionEvent.getSource();
            }
        });
        DINEINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CardLayout myLayout = (CardLayout) RestLayout.getLayout();
                myLayout.show(RestLayout, "CardDinein");
                merge.setVisible(true);
                addOrderButton.setVisible(false);
            }
        });
        receiptTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();
                if (model.getValueAt(row, column) != "") {

                }
            }
        });
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                ToGoOrder myOrder = new ToGoOrder("test");
                myOrder.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        togoClicked((ToGoOrder)e.getSource());
                    }
                });
                togoPanel.add(myOrder);
                togoPanel.updateUI();
            }
        });
        btnRemoveTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removing = 1;
            }
        });
        loadFoodItems();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        paintLoginScreen();
        receiptTable = new JTable();
        model = new ReceiptModel(1, 3);
        receiptTable.setModel(model);
        receiptTable.setShowGrid(false);
        model.setColumnIdentifiers(new Object[]{"Quantity", "Description", "Price"});
    }

    private void addPizza()
    {
        int size;
        if(smallToggleButton.isSelected()) {
            size = 0;
            smallToggleButton.setSelected(false);
        }
        else if(mediumToggleButton.isSelected()) {
            size = 1;
            mediumToggleButton.setSelected(false);
        }
        else if(largeToggleButton.isSelected()) {
            size = 2;
            largeToggleButton.setSelected(false);
        }
        else if(extraLargeToggleButton.isSelected()) {
            size = 3;
            extraLargeToggleButton.setSelected(false);
        }
        else {
            size = -1;
        }

        if(size != -1) {
            String crust;
            if(toggleOriginal.isSelected()) {
                crust = "Original";
                toggleOriginal.setSelected(false);
            }
            else if(toggleThin.isSelected()) {
                crust = "Thin";
                toggleThin.setSelected(false);
            }
            else if(toggleDeep.isSelected()) {
                crust = "Deep Dish";
                toggleDeep.setSelected(false);
            }
            else {
                crust = "-1";
            }

            if(!crust.equals("-1")) {
                List<String> toppings = new LinkedList<String>();

                if(btnBacon.isSelected())
                    toppings.add("Bacon");
                if(btnBlackOlives.isSelected())
                    toppings.add("Black Olives");
                if(btnChicken.isSelected())
                    toppings.add("Chicken");
                if(btnHam.isSelected())
                    toppings.add("Ham");
                if(btnItalianSausage.isSelected())
                    toppings.add("Italian Sausage");
                if(btnMarinara.isSelected())
                    toppings.add("Marinara Sauce");
                if(btnMozzarella.isSelected())
                    toppings.add("Mozzarella Cheese");
                if(btnMushrooms.isSelected())
                    toppings.add("Mushrooms");
                if(btnPepperoni.isSelected())
                    toppings.add("Pepperoni");
                if(btnPineapple.isSelected())
                    toppings.add("Pineapple");
                Pizza myPizza = new Pizza(size);
                model.addFoodItem(myPizza);
                totalText.setText(Double.toString(currentTable.getReceipt().getTotal()));
            }
        }
    }


    /**
     * Loads the users and passwords from Logins.txt into the userGroup HashMap and the adminGroup HashMap
     */
    private void loadLogins() {
        userGroup = new HashMap<String, String>();
        adminGroup = new HashMap<String, String>();

        File i = new File("Resources/Data/Logins.txt");
        try {
            Scanner myFile = new Scanner(i);

            while(myFile.hasNext()) {
                switch(myFile.nextInt()) {
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

        catch(Exception e) {

        }
    }

    /**
     * Let's buttons repaint root
     */
    private void myRepaint()
    {
        this.repaint();
    }

    /**
     * Attempt to login using the username textfield and the password textfield
     */
    private void tryLogin() {
        String username = textFieldUser.getText();
        String password = new String(passwordFieldUser.getPassword());

        if(userGroup.containsKey(username)) {
            if(userGroup.get(username).equals(password)) {
                CardLayout myLayout = (CardLayout) rootPanel.getLayout();
                myLayout.show(rootPanel, "CardTable");
                labelWarning.setVisible(false);
            }
        }
        else if(adminGroup.containsKey(username)) {
            if(adminGroup.get(username).equals(password)) {
                CardLayout myLayout = (CardLayout) rootPanel.getLayout();
                myLayout.show(rootPanel, "CardTable");
                labelWarning.setVisible(false);
            }
        }
        else {
            labelWarning.setVisible(true);
        }

        textFieldUser.setText("");
        passwordFieldUser.setText("");
    }

    /**
     *  Loads the tables from the textfile into the GUI
     */
    private void loadTables() {
        try {
            File j = new File("Resources/Data/Tables.txt");
            Scanner in = new Scanner(j);

            int numTables = in.nextInt();
            for(int i = 0; i < numTables; ++i)
                addTable();

            in.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(new Frame(), "Tables.txt could not be properly loaded.");
        }
    }

    private void checkout()
    {
        Object[] options = {"Credit",
                "Cash"};
        int choice = JOptionPane.showOptionDialog(new Frame(),
                "Credit Card or Cash",
                "Method of Payment",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (currentTable != null) {
            if (choice == 0) {
                CreditCardDialog test = new CreditCardDialog();
                test.pack();
                test.setVisible(true);
            }

            ReceiptPrintout printout = new ReceiptPrintout();
            printout.loadReceipt(currentTable.getReceipt());
            //printout.loadReceipt(currentTable.getReceipt());
            printout.pack();
            printout.setVisible(true);

            currentTable.setOccupied(false);
            currentTable.checkOut();
            currentTable = null;
            exitToTables();
        }
        else if(currentBooth != null)
        {
            if (choice == 0) {
                CreditCardDialog test = new CreditCardDialog();
                test.pack();
                test.setVisible(true);
            }

            ReceiptPrintout printout = new ReceiptPrintout();
            printout.loadReceipt(currentBooth.getReceipt());
            //printout.loadReceipt(currentTable.getReceipt());
            printout.pack();
            printout.setVisible(true);

            currentBooth.setOccupied(false);
            currentBooth.checkOut();
            currentBooth = null;
            exitToTables();
        }
        else
        {
            if(choice == 0) {
                CreditCardDialog test = new CreditCardDialog();
                test.pack();
                test.setVisible(true);
                currentOrder.checkOut(1);

                ReceiptPrintout printout = new ReceiptPrintout();
                printout.loadReceipt(currentOrder.getReceipt());
                //printout.loadReceipt(currentTable.getReceipt());
                printout.pack();
                printout.setVisible(true);
            }
            else {
                currentOrder.checkOut(2);
            }
            currentOrder = null;

            exitToTogo();
        }
    }
    /**
     * Adds a table to the tablelayout
     */
    private void addTable() {
        Table tableNew = new Table();
        tablePanel.add(tableNew);
        tableNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableClicked((Table) e.getSource());
            }
        });
        tablePanel.updateUI();
    }

    /**
     * Increases the table count
     */
    private void incrementTables() {
        try {
            File j = new File("Resources/Data/Tables.txt");
            Scanner in = new Scanner(j);

            int numTables = in.nextInt();
            ++numTables;
            FileWriter q = new FileWriter(j);
            q.write(Integer.toString(numTables));
            in.close();
            q.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(new Frame(), "Tables.txt could not be properly loaded.");
        }
    }

    private void decrementTables(){
        try{
            File j = new File("Resources/Data/Tables.txt");
            Scanner in = new Scanner(j);

            int numTables = in.nextInt();
            --numTables;
            FileWriter q = new FileWriter(j);
            q.write(Integer.toString(numTables));
            in.close();
            q.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(new Frame(), "Tables.txt could not be properly loaded.");
        }
    }
    /**
     * When table is clicked, update the displayable receipt with the chosen table
     * @param myTable
     */
    private void tableClicked(Table myTable) {
        if(removing == 1) {
            removeTable(myTable);
        }
        else if(merging == -1) {
            totalText.setText("$0.00");
            model.loadTable(myTable);
            CardLayout myLayout = (CardLayout) rootPanel.getLayout();
            myLayout.show(rootPanel, "CardOrder");
            myTable.setOccupied(true);
            currentTable = myTable;
        }
        else {
            if(merging == 0) {
                firstMerge = myTable;
                merging = 1;
            }
            else {
                tablePanel.add(new MultiTable(firstMerge, myTable));
                tablePanel.remove(firstMerge);
                tablePanel.remove(myTable);
                merging = -1;
            }
        }
    }

    private void togoClicked(ToGoOrder order) {
        totalText.setText("$0.00");
        model.loadToGo(order);
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardOrder");
        currentOrder = order;
    }

    /**
     *  Currently switches to the login card
     */
    private void logOff() {
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardLogin");
    }

    /**
     * Switch card layout to the tablelayout
     */
    private void exitToTables() {
        model.clearReceipt();
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardTable");
        tableAdminSplit.setDividerLocation(1800);
        split2.setDividerLocation(1650);
    }

    /**
     * Switch card layout to the togoLayout
     */
    private void exitToTogo() {
        model.clearReceipt();
        CardLayout myLayout = (CardLayout) rootPanel.getLayout();
        myLayout.show(rootPanel, "CardTable");
    }

    /**
     * Loads the food items for the FoodMenu.txt
     */
    private void loadFoodItems() {
        imageSparker.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Berry Sparkler", 5));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageSmoothie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Smoothie", 3.5));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageBerryFizz.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Berry Fizz", 5));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageWrap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Lettuce Wrap", 6));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageEggRolls.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Avocado Club Egg Rolls", 4));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageFlatBread.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Bianco Flatbread", 7));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageWedge.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Petite Wedge", 2));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageSedona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Sedona Tortilla Soup", 6));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageSouffleCake.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Belgian Chocolate Souffle Cake", 15));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageRedVelvet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Red Velvet Cake", 25));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageCaramelPudding.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Salted Caramel Pudding", 12));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageKeyLime.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Key Lime Pie", 12));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageTiramisu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Tiramisu", 14));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageSangria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Sangria", 7));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageBBQ.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("BBQ Pizza", 12));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageCalifornia.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("California Club", 14));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageCaVeggie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("California  Veggie", 14));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageAsparagus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Asparagus Arugula", 8));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        imageSalmon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.addFoodItem(new FoodItem("Cedar Plank Salmon", 16));
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
        btnAddPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addPizza();
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                if (currentTable != null)
                    totalText.setText(nf.format(currentTable.getReceipt().getTotal()));
                else if (currentBooth != null)
                    totalText.setText(nf.format(currentBooth.getReceipt().getTotal()));
                else
                    totalText.setText(nf.format(currentOrder.getReceipt().getTotal()));
            }
        });
    }

    /**
     * When table is clicked, update the displayable receipt with the chosen table
     * @param myBooth
     */
    private void boothClicked(Booth myBooth) {
        if(merging == -1) {
            model.loadBooth(myBooth);
            CardLayout myLayout = (CardLayout) rootPanel.getLayout();
            myLayout.show(rootPanel, "CardOrder");
            myBooth.setOccupied(true);
            currentBooth = myBooth;
        }
    }

    private void setupBooths()
    {
        leftBooth1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boothClicked((Booth) e.getSource());
            }
        });
        leftBooth2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boothClicked((Booth) e.getSource());
            }
        });
        leftBooth3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boothClicked((Booth) e.getSource());
            }
        });
        rightBooth1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boothClicked((Booth) e.getSource());
            }
        });
        rightBooth2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boothClicked((Booth) e.getSource());
            }
        });
        rightBooth3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                boothClicked((Booth) e.getSource());
            }
        });
    }

    /**
     * Sets up button action listeners
     */
    private void setupButtons() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tryLogin();
            }
        });
        btnOrderExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                exitToTables();
                currentTable = null;
                currentBooth = null;
            }
        });
        btnTableExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                logOff();
            }
        });
        btnAddTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addTable();
                incrementTables();
            }
        });
    }

    private void removeTable(Table myTable) {
        tablePanel.remove(myTable);
        decrementTables();
        tablePanel.updateUI();
        removing = 1;
    }

    private void paintLoginScreen()
    {
        imagePanel1 = new ImagePanel();
    }

    private JScrollPane scrollPane1(){
        return scrollPane1;
    }

}