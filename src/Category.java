import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trenton on 3/18/2015.
 */
public class Category {
    private List<FoodItem> foodItemList;
    private String name;

    /**
     * Default Constructores
     * @param name Name of the category
     */
    public Category(String name)
    {
        foodItemList = new ArrayList<FoodItem>();
        this.name = name;
    }

    /**
     * Adds the FoodItem to the Category's List, foodItemList
     * @param item FoodItem to be added to the category
     */
    public void addItem(FoodItem item)
    {
        foodItemList.add(item);
    }

    /**
     * Removes the FoodItem from the Category's List, foodItemList
     * @param item FoodItem to be removed from the category
     */
    public void removeItem(FoodItem item)
    {
        foodItemList.remove(item);
    }
}
