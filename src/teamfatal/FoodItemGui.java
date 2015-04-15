package teamfatal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by trenton on 4/10/15.
 */
public class FoodItemGui extends JLabel {

    private Image image;
    private FoodItem myFood;

    public FoodItemGui()
    {
        super();
        image = new ImageIcon("Resources/Images/DefaultFood.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, image.getWidth(null), image.getHeight(null), null);
    }
}
