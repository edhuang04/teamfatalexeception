package teamfatal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by trenton on 4/10/15.
 */
public class FoodItemGui extends JLabel {
    private FoodItem myFood;

    /**
     * Constructor
     */
    public FoodItemGui() {
        super();
    }

    /**
     * Sets the ImageIcon of the FoodItemGui
     * @param path Path to the image file to be used
     */
    public void setImage(String path)
    {
        ImageIcon icon = createImageIcon(path, "");
        this.setIcon(icon);
        this.setVisible(true);
    }

    /**
     * Gets FoodItem
     * @return FoodItem
     */
    public FoodItem getMyFood() {
        return myFood;
    }

    /**
     * @param myFood FoodItem to set FoodItemGui to
     */
    public void setMyFood(FoodItem myFood) {
        this.myFood = myFood;
    }

    /**
     * Create and return ImageIcon of the image
     * @param path Image location for the icon
     * @param description Description of the image
     * @return ImageIcon of the image
     */
    protected ImageIcon createImageIcon(String path, String description)
    {
        return new ImageIcon(path, description);
    }
}
