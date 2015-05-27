package teamfatal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * Created by trenton on 4/2/15.
 */
public class Table extends OrderObject
{
    int id;
    boolean occupied;

    /**
     * Default Constructor
     * Calls JLabel to initialize Table.
     * Sets Icon to unoccupied table icon
     * Initializes table receipt
     */
    public Table(int otherId)
    {
        super();
        ImageIcon icon = createImageIcon("/Images/table-red.png", "");
        this.setIcon(icon);
        this.setVisible(true);
        occupied = false;
        id = otherId;
        this.setText(Integer.toString(id));
        this.setVerticalTextPosition(BOTTOM);
        this.setHorizontalTextPosition(CENTER);
        Font font = new Font("Verdana", Font.BOLD, 14);
        this.setFont(font);
        this.setForeground(Color.WHITE);
    }

    public Table(Receipt receipt)
    {
        super(receipt);
        ImageIcon icon = createImageIcon("/Images/table-red.png", "");
        this.setIcon(icon);
        this.setVisible(true);
        occupied = false;
    }

    public void setOccupied(boolean status)
    {
        if(status)
        {
            occupied = true;
            ImageIcon icon = createImageIcon("/Images/table-green.png","");
            this.setIcon(icon);
        }
        else
        {
            occupied = false;
            ImageIcon icon = createImageIcon("/Images/table-red.png", "");
            this.setIcon(icon);
        }
    }

    public void checkOut()
    {
        occupied = false;
        ImageIcon icon = createImageIcon("/Images/table-red.png", "");
        this.setIcon(icon);
        receipt.clearReceipt();
    }

    /**
     * Getter for table id
     * @return
     */
    public int getId() {
        return id;
    }
}