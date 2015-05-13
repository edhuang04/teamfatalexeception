package teamfatal;

/**
 * Created by trenton on 5/11/15.
 */
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * Created by trenton on 4/14/15.
 */
public class WaitlistModel extends DefaultTableModel {

    public WaitlistModel()
    {
        super(0, 2);
    }

    public WaitlistModel(Receipt receipt)
    {
        super(0,2);
    }

    public WaitlistModel(int row, int col)
    {
        super(row, col);
    }

    public void addEntry(int numPersons, String name)
    {
        this.addRow(new Object[]{name, Integer.toString(numPersons)});
    }


    public void clearWaitlist() {
        this.setNumRows(0);
    }
}
