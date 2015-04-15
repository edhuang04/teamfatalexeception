package teamfatal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trenton on 4/14/15.
 */
public class ReceiptGui extends JTable{
    private Receipt myReceipt;
    private JLabel taxLabel;
    private JLabel totalLabel;

    public ReceiptGui(Receipt otherReceipt)
    {
        //this.
        super();
        myReceipt = otherReceipt;
        //myItems = new ArrayList<ItemReceiptGui>();
    }

    private class ItemReceiptGui extends JPanel{
        JLabel price;
        JLabel comments;
        JLabel name;

        public ItemReceiptGui(double price, String name, String comments)
        {
            this.price = new JLabel( Double.toString(price) );
            this.name = new JLabel(name);
            this.comments = new JLabel(comments);
            this.add(this.price);
            this.add(this.name);
            this.add(this.comments);
        }

        public ItemReceiptGui(double price, String name)
        {
            this.price = new JLabel( Double.toString(price) );
            this.name = new JLabel(name);
            this.add(this.price);
            this.add(this.name);
        }
    }
}
