package teamfatal;

import java.awt.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.event.*;

public class ReceiptPrintout extends JDialog {
    private JPanel contentPane;
    private JButton btnPrint;
    private JButton btnEmail;
    private JLabel labelDate;
    private JButton btnText;
    private JLabel labelOrdNum;
    private JTable table1;
    private JButton btnEmailCancel;
    private JButton btnEmailOk;
    private JTextField textFieldEmail;
    private JPanel emailPane;
    private JComboBox comboBoxProv;
    private JPanel textPane;
    private JButton btnTextOk;
    private JButton btnTextCancel;
    private JPanel CardPanel;
    private JTextField textFieldPhone;
    private JLabel labelTotal;
    private JLabel labelTax;
    private JLabel labelPercentFifth;
    private JLabel labelPercentEighth;
    private JLabel labelPercentTwenty;
    private Receipt myReceipt;
    private final double TAX = 0.0875;

    public ReceiptPrintout() {
        setContentPane(CardPanel);
        setModal(true);
        getRootPane().setDefaultButton(btnPrint);
        String timestamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        labelDate.setText(timestamp);
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
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
        btnText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CardLayout myLayout = (CardLayout) CardPanel.getLayout();
                myLayout.show(CardPanel, "CardText");
            }
        });
        btnEmail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CardLayout myLayout = (CardLayout) CardPanel.getLayout();
                myLayout.show(CardPanel, "CardEmail");
            }
        });
        btnEmailOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String email = textFieldEmail.getText();
                try {
                    onEmail(email);
                }
                catch(Exception e)
                {
                    System.out.println(e.getLocalizedMessage());
                }
                dispose();
            }
        });
        btnTextOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String phoneNumber = textFieldPhone.getText();
                int provider = comboBoxProv.getSelectedIndex() + 1;

                try {
                    onText(phoneNumber, provider);
                }
                catch(Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
                dispose();
            }
        });
        btnEmailCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CardLayout myLayout = (CardLayout) CardPanel.getLayout();
                myLayout.show(CardPanel, "CardMain");
            }
        });
        btnTextCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CardLayout myLayout = (CardLayout) CardPanel.getLayout();
                myLayout.show(CardPanel, "CardMain");
            }
        });
    }

    public void loadReceipt(Receipt myReceipt)
    {
        this.myReceipt = myReceipt;
        setTax(myReceipt.getTotal());
        setTotal(myReceipt.getTotal());
        setTips(myReceipt.getTotal());
        ReceiptModel model = new ReceiptModel();
        model.loadOrder(new Table(myReceipt));
        table1.setModel(model);
        table1.repaint();
        table1.updateUI();
    }

    private void setTax(double amount)
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        labelTax.setText(nf.format(amount * TAX));
    }

    private void setTotal(double amount)
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        labelTotal.setText(nf.format(amount * (1+TAX)));
    }

    private void setTips(double amount)
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        labelPercentFifth.setText(labelPercentFifth.getText() + nf.format(amount*.15));
        labelPercentEighth.setText(labelPercentEighth.getText() + nf.format(amount*.18));
        labelPercentTwenty.setText(labelPercentTwenty.getText() + nf.format(amount*.20));
    }

    private void onOK() {
// add your code here

        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    private void onEmail(String email) throws AddressException, MessagingException {
        //Step1
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
//Step2
        Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        MimeMessage generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        generateMailMessage.setSubject("Team Fatal Pizzeria Receipt");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String emailBody = "Total - " + nf.format(myReceipt.getTotal());
        generateMailMessage.setContent(emailBody, "text/html");

//Step3
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "teamfatalpizza", "teamfatal");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

    private void onText(String number, int provider) throws AddressException, MessagingException {
        //Step1
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

//Step2
        String email = "";
        switch(provider) { //1 = AT&T, 2 = T-Mobile, 3 = Sprint, 4 = Verizon
            case 1:
                email = number + "@txt.att.net";
                break;
            case 2:
                email = number + "@tmomail.net";
                break;
            case 3:
                email = number + "@sprintpaging.net";
                break;
            case 4:
                email = number + "@vtext.com";
        }

        Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        MimeMessage generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        generateMailMessage.setSubject("Team Fatal Pizzeria Receipt");
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String emailBody = "Total - " + nf.format(myReceipt.getTotal()) + "<br><br> Regards, <br>Team Fatal Pizzeria";
        generateMailMessage.setContent(emailBody, "text/html");

//Step3
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
        transport.connect("smtp.gmail.com", "teamfatalpizza", "teamfatal");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}
