package teamfatal;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * Created by trenton on 4/14/15.
 */
public class ReceiptModel extends DefaultTableModel{
    private Table myTable;

    public ReceiptModel()
    {
        super(0,3);
    }

    public ReceiptModel(int row, int col)
    {
        super(row, col);
    }

    public Table getMyTable() {
        return myTable;
    }

    public void addFoodItem(FoodItem item)
    {
        if(myTable.getReceipt().getOrderedItems().containsKey(item))
        {
            boolean itemFound = false;
            int iter = 1;

            while(!itemFound)
            {
                if(this.getValueAt(iter, 1).equals(item.getName()))
                {
                    this.setValueAt(Integer.parseInt(this.getValueAt(iter, 0).toString()) + 1, iter, 0);
                    this.setValueAt("$" + Double.toString(Double.parseDouble(this.getValueAt(iter, 2).toString().substring(1)) + item.getPrice()), iter, 2);
                    itemFound = true;
                }
                ++iter;
            }
        }
        else
        {
            this.addRow(new Object[]{"1", item.getName(), "$" + Double.toString(item.getPrice())});
        }

        myTable.getReceipt().addItem(item);
    }

    public void loadTable(Table otherTable)
    {
        myTable = otherTable;
        loadReceipt();
    }

    private void loadReceipt()
    {
        Map<FoodItem, Integer> mapOfFood = myTable.getReceipt().getOrderedItems();

        Iterator<Map.Entry<FoodItem, Integer>> iter = mapOfFood.entrySet().iterator();

        while(iter.hasNext())
        {
            Map.Entry<FoodItem, Integer> entry = iter.next();
            double total = entry.getKey().getPrice() * entry.getValue();
            this.addRow(new Object[]{entry.getValue(), entry.getKey().getName(), "$" + Double.toString(total)});
        }
    }

    public void clearReceipt() {
        myTable = null;
        this.setRowCount(0);
    }
}
