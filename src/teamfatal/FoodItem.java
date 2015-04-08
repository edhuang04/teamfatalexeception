package teamfatal;

/**
 * Created by Trenton on 3/18/2015.
 */
public class FoodItem {
    private double price;
    private String name;
    private String comments;

    /**
     *
     * @return The price of the food item
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return The name of the food item
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return The comments left on the food item
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param name The name of the food item
     * @param price The price of the food item
     */
    public FoodItem(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    /**
     *
     * @param comments Comments to add to the food item
     */
    public void setComments(String comments)
    {
        this.comments = comments;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price){ this.price = price;}

    @Override
    public String toString()
    {
        return name + " - " + comments;
    }
}
