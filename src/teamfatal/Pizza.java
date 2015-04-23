package teamfatal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by trenton on 4/9/15.
 */
public class Pizza extends FoodItem{
    private ArrayList<String> toppings;

    public Pizza(int size) {
        super();
        toppings = new ArrayList<String>();

        switch(size)
        {
            case 0:
                this.setName("Small Pizza");
                this.setPrice(10);
                break;
            case 1:
                this.setName("Medium Pizza");
                this.setPrice(12);
                break;
            case 2:
                this.setName("Large Pizza");
                this.setPrice(14);
                break;
            case 3:
                this.setName("Extra Large Pizza");
                this.setPrice(16);
                break;
        }
    }

    public void addTopping(String topping)
    {
        toppings.add(topping);
        this.setPrice(this.getPrice() + .5);
    }

    public void addToppings(List<String> toppings)
    {
        this.toppings.addAll(toppings);
        this.setPrice(this.getPrice() + (.5 * toppings.size()));
    }
}
