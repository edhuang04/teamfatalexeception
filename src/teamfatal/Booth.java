package teamfatal;

import javax.swing.*;

/**
 * Created by trenton on 4/9/15.
 */
abstract class Booth extends JLabel{
    int id;
    Receipt tableReceipt;
    boolean available;

    /**
     * Default Constructor
     * Calls JLabel to initialize Table.
     * Sets Icon to unoccupied table icon
     * Initializes table receipt
     */
    public Booth()
    {
        super();
        this.setVisible(true);
        available = true;
        tableReceipt = new Receipt();
    }

    /**
     * Getter for tableReceipt
     * @return Receipt for the table
     */
    public Receipt getReceipt() {
        return tableReceipt;
    }

    /**
     * Getter for table id
     * @return
     */
    public int getId() {
        return id;
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
