package teamfatal;

import javax.swing.*;

/**
 * Created by Trenton on 3/18/2015.
 */
public class CategoryButton extends JButton{
    private Category category;

    /**
     * Creates a button with no set text or icon.
     */
    public CategoryButton(Category category) {
        super();
        this.category = category;
    }

    public void setCategory()
    {
        this.category = getCategory();
    }

    public Category getCategory()
    {
        return category;
    }
}
