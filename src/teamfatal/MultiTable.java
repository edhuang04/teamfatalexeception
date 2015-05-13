package teamfatal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trenton on 4/15/15.
 */
public class MultiTable extends JPanel {
    List<Table> tableList;
    Table table;
    Receipt tableReceipt;
    boolean occupied;

    public MultiTable(Table table1, Table table2)
    {
        super();
        tableList = new ArrayList<Table>();
        this.setLayout(new FlowLayout());
        tableList.add(table1);

        tableReceipt = table1.getReceipt();
        this.add(table1);
        tableList.add(table2);
        tableReceipt.merge(table2.getReceipt());
        this.add(table2);
        table = new Table(0);
        this.setBackground(Color.DARK_GRAY);
    }

    public void addTable(Table otherTable)
    {
        tableList.add(otherTable);
    }

    public List<Table> separate()
    {
        this.removeAll();
        tableReceipt = null;
        return tableList;
    }

    /**
     * Getter for tableReceipt
     * @return Receipt for the table
     */
    public Receipt getReceipt() {
        return tableReceipt;
    }

    public void setOccupied(boolean status)
    {
        if(status)
        {
            occupied = true;
            ImageIcon icon = createImageIcon("Resources/Images/table-green.png","");

            for(Table table: tableList) {
                table.setIcon(icon);
            }
        }
        else
        {
            occupied = false;
            ImageIcon icon = createImageIcon("Resources/Images/table-red.png", "");
            for(Table table: tableList) {
                table.setIcon(icon);
            }
        }
    }

    public void checkOut()
    {
        occupied = false;
        ImageIcon icon = createImageIcon("Resources/Images/table-red.png", "");
        separate();
        tableReceipt.clearReceipt();
    }

    public Table getTable() {
        return table;
    }

    /**
     * Create and return ImageIcon of the image
     * @param path Image location for the icon
     * @param description Description of the image
     * @return ImageIcon of the image
     */
    protected ImageIcon createImageIcon(String path, String description)
    {
        return new ImageIcon(path, description);
    }
}
