package teamfatal;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by trenton on 5/12/15.
 */
public class WaitlistDialog extends JDialog{
    private JPanel panel1;
    private JTextField textName;
    private JTextField textParty;
    private JTextField textCell;
    private JButton addGuest;
    private JButton buttonCancel;
    private boolean responded;

    @Override
    public String getName() {
        return name;
    }

    public String getPartyNum() {
        return partyNum;
    }

    public String getCellphone() {
        return cellphone;
    }

    private String name;
    private String partyNum;
    private String cellphone;

    public WaitlistDialog(){

        setContentPane(panel1);
        setModal(true);
        getRootPane().setDefaultButton(addGuest);

        addGuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        panel1.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public String getWaitName(){ return textName.getText();   }
    public String getPartyNumber() { return textParty.getText(); }
    public String getCell(){ return textCell.getText(); }

    public boolean respondeded() { return responded; }

    private void onOK() {
// add your code here
        responded = true;
        name = textName.getText();
        cellphone = textCell.getText();
        partyNum = textParty.getText();

        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        responded = false;
        dispose();
    }


}
