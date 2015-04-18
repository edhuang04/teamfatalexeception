package teamfatal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by trenton on 4/15/15.
 */
public class MultiTable extends JPanel {
    List<Table> tableList;
    Receipt tableReceipt;

    public MultiTable(Table table1, Table table2)
    {
        super();
        this.setLayout(new BorderLayout());
        tableList.add(table1);
        tableReceipt = table1.getReceipt();
        this.add(table1);
        tableList.add(table2);
        tableReceipt.merge(table2.getReceipt());
        this.add(table2);
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
}
