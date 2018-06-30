package javamail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendHtmlMail {

   public static void main(String args[])
   {
        Properties props = System.getProperties();
        Session session = Session.getDefaultInstance(props, null);
        try {
            // construct the message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("scott@java.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("james@java.com"));
            msg.setDataHandler( new DataHandler("<h1>Good Morning</h1>", "text/html"));
            msg.setSubject("Wishing");
            msg.setSentDate(new Date());
            Transport.send(msg);    // send message
            System.out.println("Mail Sent Successfully");
        } catch (Exception ex) {
            System.out.println("<h2>Error --> " + ex.getMessage() + "</h2>");
        }

    }

}
