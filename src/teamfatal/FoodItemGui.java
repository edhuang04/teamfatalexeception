package teamfatal;

import javax.swing.*;
import java.awt.*;

/**
 * Created by trenton on 4/10/15.
 */
public class FoodItemGui extends JLabel {

    private Image image;
    private FoodItem myFood;

    public FoodItemGui() {
        super();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public FoodItem getMyFood() {
        return myFood;
    }

    public void setMyFood(FoodItem myFood) {
        this.myFood = myFood;
    }

}
