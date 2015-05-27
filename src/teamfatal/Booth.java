package teamfatal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by trenton on 4/2/15.
 */
public class Booth extends OrderObject {
    int id;
    boolean occupied;

    /**
     * Default Constructor
     * Calls JLabel to initialize Table.
     * Sets Icon to unoccupied table icon
     * Initializes table receipt
     */
    public Booth() {
        super();
        this.setIcon(createImageIcon("/Images/LeftBoothRed.jpg", "Booth"));
        occupied = false;
    }

    void setOccupied(boolean status) {
        if (status) {
            occupied = true;
            ImageIcon icon = createImageIcon("/Images/LeftBoothGreen.jpg", "");
            this.setIcon(icon);
        } else {
            occupied = false;
            ImageIcon icon = createImageIcon("/Images/LeftBoothRed.jpg", "");
            this.setIcon(icon);
        }
    }

    public void checkOut() {
        occupied = false;
        ImageIcon icon = createImageIcon("/Images/LeftBoothRed.jpg", "");
        this.setIcon(icon);
        receipt.clearReceipt();
    }
}