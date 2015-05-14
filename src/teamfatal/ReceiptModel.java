package teamfatal;

import com.sun.org.apache.xpath.internal.operations.Mult;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by trenton on 4/14/15.
 */
public class ReceiptModel extends DefaultTableModel{
    private Table myTable;
    private Booth myBooth;
    private MultiTable myMultitable;

    private ToGoOrder myOrder;

    public ReceiptModel()
    {
        super(0, 3);
    }

    public ReceiptModel(Receipt receipt)
    {
        super(0,3);
        myTable = new Table(0);
        loadReceipt();
    }

    public ReceiptModel(int row, int col)
    {
        super(row, col);
    }

    public Table getMyTable()
    {
        return myTable;
    }

    public void addFoodItem(FoodItem item)
    {
        if(myTable != null)
        {
            if (myTable.getReceipt().getOrderedItems().containsKey(item))
            {
                boolean itemFound = false;
                int iter = 1;

                while (!itemFound)
                {
                    if (this.getValueAt(iter, 1).equals(item.getName()))
                    {
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        this.setValueAt(Integer.parseInt(this.getValueAt(iter, 0).toString()) + 1, iter, 0);
                        this.setValueAt(nf.format(Double.parseDouble(this.getValueAt(iter, 2).toString().substring(1)) + item.getPrice()), iter, 2);
                        itemFound = true;
                    }
                    ++iter;
                }
            }
            else
            {
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                this.addRow(new Object[]{"1", item.getName(), nf.format(item.getPrice())});
            }

            myTable.getReceipt().addItem(item);
        }
        else if(myBooth != null)
        {
            if (myBooth.getReceipt().getOrderedItems().containsKey(item))
            {
                boolean itemFound = false;
                int iter = 1;

                while (!itemFound)
                {
                    if (this.getValueAt(iter, 1).equals(item.getName()))
                    {
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        this.setValueAt(Integer.parseInt(this.getValueAt(iter, 0).toString()) + 1, iter, 0);
                        this.setValueAt(nf.format(Double.parseDouble(this.getValueAt(iter, 2).toString().substring(1)) + item.getPrice()), iter, 2);
                        itemFound = true;
                    }
                    ++iter;
                }
            }
            else
            {
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                this.addRow(new Object[]{"1", item.getName(), nf.format(item.getPrice())});
            }

            myBooth.getReceipt().addItem(item);
        }
        else if(myMultitable != null)
        {
            if (myMultitable.getReceipt().getOrderedItems().containsKey(item))
            {
                boolean itemFound = false;
                int iter = 1;

                while (!itemFound)
                {
                    if (this.getValueAt(iter, 1).equals(item.getName()))
                    {
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        this.setValueAt(Integer.parseInt(this.getValueAt(iter, 0).toString()) + 1, iter, 0);
                        this.setValueAt(nf.format(Double.parseDouble(this.getValueAt(iter, 2).toString().substring(1)) + item.getPrice()), iter, 2);
                        itemFound = true;
                    }
                    ++iter;
                }
            }
            else
            {
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                this.addRow(new Object[]{"1", item.getName(), nf.format(item.getPrice())});
            }

            myMultitable.getReceipt().addItem(item);
        }
        else
        {
            if (myOrder.getReceipt().getOrderedItems().containsKey(item))
            {
                boolean itemFound = false;
                int iter = 1;

                while (!itemFound)
                {
                    if (this.getValueAt(iter, 1).equals(item.getName()))
                    {
                        NumberFormat nf = NumberFormat.getCurrencyInstance();
                        this.setValueAt(Integer.parseInt(this.getValueAt(iter, 0).toString()) + 1, iter, 0);
                        this.setValueAt("$" + nf.format(Double.parseDouble(this.getValueAt(iter, 2).toString().substring(1)) + item.getPrice()), iter, 2);
                        itemFound = true;
                    }
                    ++iter;
                }
            }
            else
            {
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                this.addRow(new Object[]{"1", item.getName(), nf.format(item.getPrice())});
            }

            myOrder.getReceipt().addItem(item);
        }
    }

    public void loadTable(Table otherTable)
    {
        myTable = otherTable;
        loadReceipt();
    }

    public void loadMultitable(MultiTable multiTable)
    {
        myMultitable = multiTable;
        loadReceipt();
    }

    public void loadToGo(ToGoOrder order)
    {
        myOrder = order;
        loadReceipt();
    }

    public void loadBooth(Booth myBooth)
    {
        this.myBooth = myBooth;
        loadReceipt();
    }

    private void loadReceipt()
    {
        if(myTable != null) {
            Map<FoodItem, Integer> mapOfFood = myTable.getReceipt().getOrderedItems();

            Iterator<Map.Entry<FoodItem, Integer>> iter = mapOfFood.entrySet().iterator();

            while (iter.hasNext()) {
                Map.Entry<FoodItem, Integer> entry = iter.next();
                double total = entry.getKey().getPrice() * entry.getValue();
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                this.addRow(new Object[]{entry.getValue(), entry.getKey().getName(), nf.format(total)});
            }
        }
        else if(myBooth != null)
        {
            Map<FoodItem, Integer> mapOfFood = myBooth.getReceipt().getOrderedItems();

            Iterator<Map.Entry<FoodItem, Integer>> iter = mapOfFood.entrySet().iterator();

            while (iter.hasNext()) {
                Map.Entry<FoodItem, Integer> entry = iter.next();
                double total = entry.getKey().getPrice() * entry.getValue();
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                this.addRow(new Object[]{entry.getValue(), entry.getKey().getName(), nf.format(total)});
            }
        }
        else if(myMultitable != null)
        {
            Map<FoodItem, Integer> mapOfFood = myMultitable.getReceipt().getOrderedItems();

            Iterator<Map.Entry<FoodItem, Integer>> iter = mapOfFood.entrySet().iterator();

            while (iter.hasNext()) {
                Map.Entry<FoodItem, Integer> entry = iter.next();
                double total = entry.getKey().getPrice() * entry.getValue();
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                this.addRow(new Object[]{entry.getValue(), entry.getKey().getName(), nf.format(total)});
            }
        }
        else
        {
            Map<FoodItem, Integer> mapOfFood = myOrder.getReceipt().getOrderedItems();

            Iterator<Map.Entry<FoodItem, Integer>> iter = mapOfFood.entrySet().iterator();

            while (iter.hasNext()) {
                Map.Entry<FoodItem, Integer> entry = iter.next();
                double total = entry.getKey().getPrice() * entry.getValue();
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                this.addRow(new Object[]{entry.getValue(), entry.getKey().getName(), nf.format(total)});
            }
        }
    }

    public void clearReceipt() {
        myTable = null;
        myBooth = null;
        myOrder = null;
        this.setRowCount(1);
    }
}
