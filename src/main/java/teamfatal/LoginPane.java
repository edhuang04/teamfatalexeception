package teamfatal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Alan Duncan on 4/11/2015.
 */
public class LoginPane extends JDialog implements ActionListener {
    String itsUsername = "";
    String itsPassword = "";
    boolean itsFirst = true;
    boolean itsKeep = false;
    JTextField itsUserField = new JTextField(15); //
    JPasswordField itsPassField = new JPasswordField(15);
    JCheckBox itsKeepBox = new JCheckBox("Save details:", false);
    boolean itsInit = false;

    public LoginPane() {
        super();
        setTitle("Login");
        setModal(true);
        getContentPane().setLayout(new GridLayout(3, 2));
        getContentPane().add(new JLabel("Username:"));
        getContentPane().add(itsUserField);
        getContentPane().add(new JLabel("Password"));
        getContentPane().add(itsPassField);
        getContentPane().add(itsKeepBox);
        JButton submit = new JButton("done");
        getContentPane().add(submit);
        submit.addActionListener(this);
        pack();
    }

    public String[] getLogin() {
        if (!itsKeep && !itsFirst) {
            return null;
        }
        if (!itsInit) {
            return null;
        }
        itsFirst = false;
        String[] res = new String[2];
        res[0] = itsUsername;
        res[1] = itsPassword;
        if (!itsKeep) {
            itsUsername = "";
            itsPassword = "";
        }
        return res;
    }

    public void actionPerformed(ActionEvent e) {
        itsUsername = itsUserField.getText();
        itsPassword = new String(itsPassField.getPassword());
        itsKeep = itsKeepBox.isSelected();
        itsInit = true;
        setVisible(false);
    }
}
