package teamfatal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by trenton on 4/9/15.
 */
public class ImagePanel extends JPanel {
    private Image image = null;

    public ImagePanel()
    {
        this.image = new ImageIcon("Resources/Images/login.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }
}
