package teamfatal;

/**
 * Created by trenton on 5/11/15.
 */
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * Created by trenton on 4/14/15.
 */
public class WaitlistModel extends DefaultTableModel {
    private List<Integer> providerList;

    public WaitlistModel()
    {
        super(0, 3);
        super.setColumnIdentifiers(new Object[] {"Party Name", "Size", "Phone Number" });
        providerList = new ArrayList<>();
    }

    public WaitlistModel(Receipt receipt)
    {
        super(0,3);
    }

    public WaitlistModel(int row, int col)
    {
        super(row, col);
    }

    public void addEntry(String name, String partySize, String phone, int provider)
    {
        this.addRow(new Object[]{name, partySize, phone});
        providerList.add(provider);
    }

    public void removeEntry(int row)
    {
        this.removeRow(row);
        providerList.remove(row);
    }

    public void notify(int row)
    {
        try{
            Properties mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            String number = this.getValueAt(row, 2).toString();
            System.out.println(number);
//Step2
            String email = "";
            int provider = providerList.get(row);
            switch(provider) { //1 = AT&T, 2 = T-Mobile, 3 = Sprint, 4 = Verizon
                case 0:
                    email = number + "@txt.att.net";
                    break;
                case 1:
                    email = number + "@tmomail.net";
                    break;
                case 2:
                    email = number + "@sprintpaging.net";
                    break;
                case 3:
                    email = number + "@vtext.com";
            }
            System.out.println(email);
//            Session getMailSession = Session.getDefaultInstance(mailServerProperties, null);
//            MimeMessage generateMailMessage = new MimeMessage(getMailSession);
//            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
//            generateMailMessage.setSubject("Team Fatal Pizzeria Notification");
//            String emailBody = "Your table is now ready.";
//            generateMailMessage.setContent(emailBody, "text/html");
//
//            Transport transport = getMailSession.getTransport("smtp");
//
//            // Enter your correct gmail UserID and Password (XXXApp Shah@gmail.com)
//            transport.connect("smtp.gmail.com", "teamfatalpizza", "teamfatal");
//            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
//            transport.close();
        }
        catch(Exception e){
            System.out.println("Did not notify.");
        }
    }

    public void clearWaitlist() {
        this.setNumRows(0);
    }
}
