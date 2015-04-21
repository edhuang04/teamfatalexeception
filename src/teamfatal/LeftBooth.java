package teamfatal;

import javax.swing.*;

/**
 * Created by trenton on 4/15/15.
 */
public class LeftBooth extends Booth{

    public LeftBooth() {
        super();
        ImageIcon myImage = super.createImageIcon("Resources/Images/LeftboothRed.jpg", "");
        this.setIcon(myImage);
        this.setVisible(true);
    }
}
