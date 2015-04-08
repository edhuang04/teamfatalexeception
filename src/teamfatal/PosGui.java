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
    private JButton btnOpen;
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
    private JPanel paneMultiplier;
    private JPanel OrderToolsPanel;
    private JPanel OrderMenuPanel;
    private JPanel TableLayoutPanel;
    private JButton btnPrintReceipt;
    private JButton button2;
    private JButton button3;
    private JButton btnBeverage;
    private JButton btnDessert;
    private JButton btnSalads;
    private JButton btnSoups;
    private JButton btnPizza;
    private JButton btnAddTable;
    private JButton btnLogin;
    private JPanel FoodItems;
    private JPanel PanelBeverages;
    private JPanel PanelSalads;
    private JPanel PanelSoups;
    private JPanel PanelDessert;
    private JPanel tablePanel;
    private JLabel labelUsername;
    private JLabel labelTime;
    private JPanel panelTopbar;
    private JTable table5;
    private JButton btnSlice;
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
        btn2x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 2;
            }
        });

        btn3x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 3;
            }
        });

        btn4x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 4;
            }
        });

        btn5x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 5;
            }
        });

        btn6x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 6;
            }
        });

        btn7x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 7;
            }
        });

        btn8x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 8;
            }
        });

        btn9x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 9;
            }
        });

        btn10x.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                multiplier = 10;
            }
        });

        btnOrderExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                exitToTables();
            }
        });

        btnTableExit.addActionListener(new ActionListener() {
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
    }
}