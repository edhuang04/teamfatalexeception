package teamfatal;

import javax.swing.*;

/**
 * Created by trenton on 4/22/15.
 */
public class ToGoOrder extends OrderObject {
    String name;
    boolean paid;

    @Override
    void checkOut() {

    }

    @Override
    void setOccupied(boolean occupied) {

    }

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
        receipt = new Receipt();
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
}
