package teamfatal;

/**
 * Created by Trenton on 3/18/2015.
 */
public class FoodItem {
    private double price;
    private String name;

    public FoodItem()
    {
        price = 0;
        name = "";
    }

    public FoodItem(double price, String name)
    {
        this.price = price;
        this.name = name;
    }

    /**
     * Getter for the FoodItem price
     * @return The price of the food item
     */
    public double getPrice() {
        return price;
    }

    /**
     * Getter for the FoodItem name
     * @return The name of the food item
     */
    public String getName() {
        return name;
    }

    /**
     * Initializes FoodItem with a name and price
     * @param name The name of the food item
     * @param price The price of the food item
     */
    public FoodItem(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof FoodItem)
        {
            if(((FoodItem) obj).getName() == name && ((FoodItem) obj).getPrice() == price)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    /**
     * Sets FoodItem price to param price
     * @param price
     */
    public void setPrice(double price){ this.price = price;}
}
