package teamfatal;

import java.util.*;

/**
 * Created by Trenton on 3/18/2015.
 */
public class Receipt {
    private Map<FoodItem, Integer> orderedItems;

    public Receipt()
    {
        orderedItems = new HashMap<FoodItem, Integer>();
    }

    public Receipt(Receipt otherReceipt)
    {
        orderedItems.putAll(otherReceipt.getOrderedItems());
    }

    public void addItem(FoodItem item)
    {
        if(orderedItems.containsKey(item))
        {
            orderedItems.put(item, orderedItems.get(item) + 1);
        }
        else
        {
            orderedItems.put(item, 1);
        }
    }


    public void removeItem(FoodItem item)
    {
        if(orderedItems.get(item) > 1)
        {
            orderedItems.put(item, orderedItems.get(item) - 1);
        }
        else
        {
            orderedItems.remove(item);
        }
    }

    /**
     * Calculates the total price of FoodItems in the Receipt
     * @return Total Price of FoodItems
     */
    public double getTotal()
    {
        double total = 0;

        Iterator<Map.Entry<FoodItem, Integer>> iter = orderedItems.entrySet().iterator();

        while(iter.hasNext())
        {
            Map.Entry<FoodItem, Integer> entry = iter.next();
            total += entry.getKey().getPrice() * entry.getValue();
        }

        return total;
    }

    public Map<FoodItem, Integer> getOrderedItems() {
        return orderedItems;
    }

    public void merge(Receipt otherReceipt)
    {

    }
}
