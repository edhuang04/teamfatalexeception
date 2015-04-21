package teamfatal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by trenton on 4/2/15.
 */
abstract class Booth extends JLabel {
    Receipt boothReceipt;
    boolean occupied;

    /**
     * Default Constructor
     * Calls JLabel to initialize Table.
     * Sets Icon to unoccupied table icon
     * Initializes table receipt
     */
    public Booth() {
        super();
        occupied = false;
        boothReceipt = new Receipt();
    }

    abstract void setOccupied(boolean status);

    abstract void checkOut();

    /**
     * Getter for tableReceipt
     * @return Receipt for the table
     */
    public Receipt getReceipt() {
        return boothReceipt;
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