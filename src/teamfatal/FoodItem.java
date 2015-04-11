package teamfatal;

/**
 * Created by Trenton on 3/18/2015.
 */
public class FoodItem {
    private double price;
    private String name;
    private String comments;

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
     * Getter for the FoodItem comments
     * @return The comments left on the food item
     */
    public String getComments() {
        return comments;
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

    /**
     * Sets FoodItem comments to param comments
     * @param comments Comments to add to the food item
     */
    public void setComments(String comments)
    {
        this.comments = comments;
    }

    /**
     * Sets FoodItem price to param price
     * @param price
     */
    public void setPrice(double price){ this.price = price;}

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name + " - " + comments;
    }
}
