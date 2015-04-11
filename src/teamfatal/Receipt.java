package teamfatal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Trenton on 3/18/2015.
 */
public class Receipt {
    private List<FoodItem> orderedItems;

    public Receipt()
    {
        orderedItems = new ArrayList<FoodItem>();
    }

    public Receipt(Receipt otherReceipt)
    {
        orderedItems.addAll(otherReceipt.getOrderedItems());
    }

    public void addItem(FoodItem item)
    {
        orderedItems.add(item);
    }

    public void removeItem(FoodItem item)
    {
        orderedItems.remove(item);
    }

    /**
     * Calculates the total price of FoodItems in the Receipt
     * @return Total Price of FoodItems
     */
    public double getTotal()
    {
        double total = 0;

        for(FoodItem item:orderedItems)
        {
            total += item.getPrice();
        }

        return total;
    }

    public List<FoodItem> getOrderedItems() {
        return orderedItems;
    }
}
