package teamfatal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by trenton on 4/2/15.
 */
public class TableItem extends JLabel
{
    int id;
    Receipt tableReceipt;

    /**
     * Default Constructor
     * Calls JLabel to initialize TableItem.
     * Sets Icon to unoccupied table icon
     * Initializes table receipt
     */
    public TableItem()
    {
        super();
        ImageIcon icon = createImageIcon("Resources/Images/table-red.png", "");//
        this.setIcon(icon);
        this.setVisible(true);
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
    private ImageIcon createImageIcon(String path, String description)
    {
        return new ImageIcon(path, description);
    }
}