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

    public ImagePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public ImagePanel(LayoutManager layout) {
        super(layout);
        image = new ImageIcon("Resources/Images/panelResized.png").getImage();
    }

    public ImagePanel(LayoutManager layout, Image image) {
        super(layout);

        this.image = image;
    }

    public ImagePanel(int id) {

        if(id == 1)
        {
            this.image = new ImageIcon("Resources/Images/panelResized.png").getImage();
        }
        else
        {
            this.image = new ImageIcon("Resources/Images/PanelResized2.jpg").getImage();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }
}
