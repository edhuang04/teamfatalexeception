package teamfatal;

import javax.swing.*;

/**
 * Created by trenton on 4/22/15.
 */
public class ToGoOrder extends JLabel {
    String name;
    boolean paid;
    Receipt orderReceipt;

    /**
     * Default Constructor
     * Calls JLabel to initialize Table.
     * Sets Icon to unoccupied table icon
     * Initializes table receipt
     */
    public ToGoOrder(String name)
    {
        super();
        this.name = name;
        ImageIcon icon = createImageIcon("Resources/Images/Togo.jpg", "");
        this.setIcon(icon);
        this.setVisible(true);
        paid = false;
        orderReceipt = new Receipt();
    }

    public void setPaid(boolean status)
    {
        if(status)
        {
            paid = true;
            ImageIcon icon = createImageIcon("Resources/Images/table-green.png","");
            this.setIcon(icon);
        }
        else
        {
            paid = false;
            ImageIcon icon = createImageIcon("Resources/Images/table-red.png", "");
            this.setIcon(icon);
        }
    }

    public void checkOut(int status)
    {

    }

    public void pickup()
    {
        if(paid)
        {

        }
        else
        {
            paymentMenu();
        }
    }

    private void paymentMenu()
    {

    }

    /**
     * Getter for tableReceipt
     * @return Receipt for the table
     */
    public Receipt getReceipt() {
        return orderReceipt;
    }


    /**
     * Create and return ImageIcon of the image
     * @param path Image location for the icon
     * @param description Description of the image
     * @return ImageIcon of the image
     */
    protected ImageIcon createImageIcon(String path, String description)
    {
        return new ImageIcon(path, description);
    }

}
