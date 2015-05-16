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


    public void removeItem(String itemName)
    {
        Iterator<Map.Entry<FoodItem, Integer>> entries = orderedItems.entrySet().iterator();
        Map.Entry<FoodItem, Integer> entry = null;
        FoodItem item = null;

        while(entries.hasNext())
        {
            entry = entries.next();
            item = entry.getKey();
            if(item.getName().equals(itemName))
            {
                break;
            }
        }

        if(entry.getValue() != 1)
        {
            orderedItems.put(item, entry.getValue() - 1);
            System.out.println(entry.getValue() - 1);
        }
        else
        {
            System.out.println("Removed");
            orderedItems.remove(item);
        }
        System.out.println(orderedItems.toString());
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
        Map<FoodItem, Integer> otherList = otherReceipt.getOrderedItems();
        Set<Map.Entry<FoodItem, Integer>> otherEntries = otherList.entrySet();
        Iterator<Map.Entry<FoodItem, Integer>> iter = otherEntries.iterator();

        while(iter.hasNext())
        {
            Map.Entry<FoodItem, Integer> entry = iter.next();
            if(orderedItems.containsKey(entry.getKey()))
            {
                int numOtherFood = entry.getValue();
                int numMyFood = orderedItems.get(entry.getKey());
                orderedItems.put(entry.getKey(), numMyFood + numOtherFood);
            }
            else
            {
                orderedItems.put(entry.getKey(), entry.getValue());
            }
        }

        otherReceipt.clearReceipt();
    }

    public void clearReceipt()
    {
        orderedItems.clear();
    }
}
