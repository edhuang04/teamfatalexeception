package teamfatal;

import javax.swing.*;
import java.awt.event.*;

public class CashDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldCurrentPayment;
    private JTextField textFieldDue;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a0Button;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a3Button;
    private JButton buttonDot;
    private JTextField textFieldChange;
    private JButton buttonBackspace;
    private double total;

    public CashDialog(double total) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        this.total = total;
        textFieldDue.setText(String.format("%.2f", total));

        buttonOK.addActionListener(new ActionListener() {
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
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        a0Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '0');
                calculate();
            }
        });
        buttonDot.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '.');
                calculate();
            }
        });
        a3Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '3');
                calculate();
            }
        });
        a2Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '2');
                calculate();
            }
        });
        a1Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '1');
                calculate();
            }
        });
        a6Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '6');
                calculate();
            }
        });
        a5Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '5');
                calculate();
            }
        });
        a4Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '4');
                calculate();
            }
        });
        a7Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '7');
                calculate();
            }
        });
        a8Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '8');
                calculate();
            }
        });
        a9Button.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCurrentPayment.setText(textFieldCurrentPayment.getText() + '9');
                calculate();
            }
        });
        buttonBackspace.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textFieldCurrentPayment.getText();
                if(text.length() > 0) {
                    textFieldCurrentPayment.setText(text.substring(0, text.length() - 1));
                    calculate();
                }
            }
        });
    }

    private void calculate() {
        double currentPayment = Double.parseDouble(textFieldCurrentPayment.getText());

        if(currentPayment > total){
            textFieldChange.setText(String.format("%.2f", currentPayment - total));
        }
        else{
            textFieldChange.setText("0.00");
        }
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }
}
