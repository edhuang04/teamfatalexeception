package teamfatal;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by trenton on 4/15/15.
 */
public class MultiTable extends JPanel {
    List<Table> tableList;
    Table mainTable;

    public MultiTable(Table table1, Table table2)
    {
        super();
        this.setLayout(new BorderLayout());
        mainTable = table1;
        tableList.add(table1);
        this.add(table1);
        tableList.add(table2);

        this.add(table2);
    }

    public List<Table> separate()
    {
        this.removeAll();
        return tableList;
    }
}
