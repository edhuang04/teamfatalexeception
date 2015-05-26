package teamfatal;

import javax.swing.*;
import java.awt.event.*;

public class ConfirmPaymentDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonCredit;
    private JButton buttonCancel;
    private JButton buttonCash;
    int paymentMethod;

    public ConfirmPaymentDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCredit);

        buttonCredit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCredit();
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
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        buttonCash.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                onCash();
            }
        });
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    private void onCredit() {
// add your code here
        paymentMethod = 2;
        dispose();
    }

    private void onCash() {
        paymentMethod = 1;
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        paymentMethod = 0;
        dispose();
    }
}
