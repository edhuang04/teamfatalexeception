package teamfatal;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.event.*;

public class ReceiptPrintout extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    public ReceiptPrintout() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

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
    }

    public void loadReceipt(Receipt myReceipt)
    {

    }

    private void onOK() {
// add your code here
        try {
            onEmail();
        }
        catch(Exception e)
        {

        }

        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    private void onEmail() throws AddressException, MessagingException {
        //Step1
        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

//Step2
        Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        MimeMessage generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("edhuang04@gmail.com"));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("alanduncan3@gmail.com"));
        generateMailMessage.setSubject("Team Fatal Pizzeria Receipt");
        String emailBody = "Hello, this is an automated test." + "<br><br> Regards, <br>Team Fatal Pizzeria";
        generateMailMessage.setContent(emailBody, "text/html");

//Step3
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
        transport.connect("smtp.gmail.com", "teamfatalpizza", "teamfatal");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}
