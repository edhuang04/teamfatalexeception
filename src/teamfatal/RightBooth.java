package teamfatal;

import javax.swing.*;

/**
 * Created by trenton on 4/15/15.
 */
public class RightBooth extends Booth{

    public RightBooth() {
        super();
        ImageIcon myImage = super.createImageIcon("Resources/Images/RightboothRed.jpg", "");
        this.setIcon(myImage);
        this.setVisible(true);
    }
}