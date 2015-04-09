package teamfatal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by trenton on 4/2/15.
 */
public class TableItem extends JLabel
{
    int id;
    Receipt tableReceipt;

    public TableItem()
    {
        super();
        ImageIcon icon = createImageIcon("Resources/Images/table-red.png", "");//
        this.setIcon(icon);
        this.setVisible(true);
        tableReceipt = new Receipt();
    }

    public Receipt getReceipt() {
        return tableReceipt;
    }

    public int getId() {
        return id;
    }

    private ImageIcon createImageIcon(String path, String description)
    {
        return new ImageIcon(path, description);
    }
}