package teamfatal;

import javax.swing.*;

/**
 * created by trenton on 3/18/2015.
 */
public class CategoryButton{
    private Category category;

    /**
     * creates a button with no set text or icon.
     */
    public CategoryButton(Category category) {
        super();
        this.category = category;
    }

    public void setcategory()
    {
        this.category = getcategory();
    }

    public Category getcategory()
    {
        return category;
    }
}
