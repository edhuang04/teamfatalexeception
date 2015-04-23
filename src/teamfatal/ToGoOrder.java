package teamfatal;

import javax.swing.*;

/**
 * Created by trenton on 4/22/15.
 */
public class ToGoOrder extends Table {
    String name;
    boolean paid;

    public ToGoOrder(String name)
    {
        super();
        this.name = name;
        this.setText(name);
    }

}
