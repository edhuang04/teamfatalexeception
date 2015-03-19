/**
 * Created by Trenton on 3/6/2015.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PosGui extends JFrame{
    //GUI Items
    private JPanel rootPanel;
    private JPanel TableMenu;
    private JPanel OrderMenu;
    private JButton btnExit;
    private JPanel LoginMenu;
    private JButton btnTableExit;
    private JButton btnOpen;
    private JButton btnServer;
    private JButton btnManager;
    private JButton btnOrderExit;
    private JList listReceipt;
    private JList listFoodItems;
    private JButton btn9x;
    private JButton btn8x;
    private JButton btn7x;
    private JButton btn6x;
    private JButton btn2x;
    private JButton btn5x;
    private JButton btn4x;
    private JButton btn3x;
    private JButton btn10x;
    private JList listCategories;
    private JPanel paneMultiplier;
    private JPanel OrderToolsPanel;
    private JPanel OrderMenuPanel;
    private JPanel TableLayoutPanel;
    private JButton currentOrderButton;
    private JLabel label2;

    //Other items
    private int multiplier = 1;
    List<Category> categories;
    List<FoodItem> foodItems;

    public PosGui()
    {
        setContentPane(rootPanel);
        setTitle("Restaurant POS");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        categories = new ArrayList<Category>();
        foodItems = new ArrayList<FoodItem>();
        setupButtons();
        loadCategoriesButtons();
        setVisible(true);
    }

    /**
     *
     */
    private void loadCategoriesButtons()
    {
        try {
            CategoryParser parser = new CategoryParser();

            //Finish parser

            for(Category category: categories)
            {
                CategoryButton catButton = new CategoryButton(category);
                catButton.addActionListener(new ActionListener() {
                    /**
                     *
                     * @param e
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        loadFoodItems();
                    }
                });
                listCategories.add(new CategoryButton(category));
            }
        }
        catch(Exception e) {

        }
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
    }
}
