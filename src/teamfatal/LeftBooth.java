package teamfatal;

import javax.swing.*;

/**
 * Created by trenton on 4/15/15.
 */
public class LeftBooth extends Booth{

    public LeftBooth() {
        super();
        ImageIcon myImage = super.createImageIcon("Resources/Images/LeftBoothRed.jpg", "");
        this.setIcon(myImage);
        this.setVisible(true);
    }

    @Override
    void setOccupied(boolean status) {
        if(status)
        {
            occupied = true;
            ImageIcon icon = createImageIcon("Resources/Images/LeftBoothGreen.jpg","");
            this.setIcon(icon);
        }
        else
        {
            occupied = false;
            ImageIcon icon = createImageIcon("Resources/Images/LeftBoothRed.jpg", "");
            this.setIcon(icon);
        }
    }

    @Override
    void checkOut() {
        occupied = false;
        ImageIcon icon = createImageIcon("Resources/Images/LeftBoothRed.jpg", "");
        this.setIcon(icon);
        boothReceipt.clearReceipt();
    }
}
