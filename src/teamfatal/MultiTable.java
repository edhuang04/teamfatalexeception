package teamfatal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trenton on 4/15/15.
 */
public class MultiTable extends OrderObject {
    JPanel panel;
    List<Table> tableList;
    boolean occupied;

    public MultiTable(Table table1, Table table2)
    {
        super();
        panel = new ImagePanel(new FlowLayout());
        tableList = new ArrayList<Table>();
        tableList.add(table1);
        receipt = table1.getReceipt();
        panel.add(table1);
        tableList.add(table2);
        receipt.merge(table2.getReceipt());
        panel.add(table2);
        panel.setBackground(Color.DARK_GRAY);
    }

    public void addTable(Table otherTable)
    {
        tableList.add(otherTable);
    }

    public List<Table> separate()
    {
        panel.removeAll();
        receipt = null;
        return tableList;
    }

    public void setOccupied(boolean status)
    {
        if(status)
        {
            occupied = true;
            ImageIcon icon = createImageIcon("/Images/table-green.png","");

            for(Table table: tableList) {
                table.setIcon(icon);
            }
        }
        else
        {
            occupied = false;
            ImageIcon icon = createImageIcon("/Images/table-red.png", "");
            for(Table table: tableList) {
                table.setIcon(icon);
            }
        }
    }

    public void checkOut()
    {
        occupied = false;
        setOccupied(false);
        separate();
        receipt.clearReceipt();
    }

    public List<Table> finish()
    {
        occupied = false;
        setOccupied(false);
        receipt.clearReceipt();
        return separate();
    }

    public JPanel getPanel()
    {
        return panel;
    }
}
