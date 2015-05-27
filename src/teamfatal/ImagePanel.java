package teamfatal;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by trenton on 4/9/15.
 */
public class ImagePanel extends JPanel {
    private Image image = null;

    public ImagePanel()
    {
        ClassLoader cldr = ImagePanel.class.getClassLoader();
        URL url = ImagePanel.class.getResource("/Images/login.png");
        this.image = new ImageIcon(url).getImage();
    }

    public ImagePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public ImagePanel(LayoutManager layout) {
        super(layout);
        URL url = ImagePanel.class.getResource("/Images/panelResized.png");
        image = new ImageIcon(url).getImage();
    }

    public ImagePanel(LayoutManager layout, Image image) {
        super(layout);

        this.image = image;
    }

    public ImagePanel(int id) {

        if(id == 1)
        {
            URL url = ImagePanel.class.getResource("/Images/panelResized.png");
            this.image = new ImageIcon(url).getImage();
        }
        else
        {
            URL url = ImagePanel.class.getResource("/Images/PanelResized2.jpg");
            this.image = new ImageIcon(url).getImage();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }
}
