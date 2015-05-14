package teamfatal;

import javax.swing.*;

/**
 * Created by trenton on 5/13/15.
 */
public abstract class OrderObject extends JLabel{
    Receipt receipt;

    public OrderObject()
    {
        super();
        receipt = new Receipt();
    }

    public OrderObject(Receipt receipt)
    {
        super();
        this.receipt = receipt;
    }

    abstract void checkOut();
    abstract void setOccupied(boolean occupied);
    public Receipt getReceipt() { return receipt; }

    protected ImageIcon createImageIcon(String path, String description)
    {
        return new ImageIcon(path, description);
    }
}
