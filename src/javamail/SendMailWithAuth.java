package javamail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailWithAuth {

   public static void main(String args[])
   {
        Properties props = System.getProperties();
        props.setProperty("mail.smtp.auth","true");
        
        Session session = Session.getDefaultInstance(props,
        		new Authenticator() {
        	      @Override 
        	      public PasswordAuthentication getPasswordAuthentication() {
        	    	  return new PasswordAuthentication("scott@java.com","scott");
        	      }
        });
        
        try {
            // construct the message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("scott@java.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("james@java.com"));
            msg.setDataHandler( new DataHandler("<h1>Hello!</h1>", "text/html"));
            msg.setSubject("Test with Auth");
            msg.setSentDate(new Date());
            Transport.send(msg);    // send message
            System.out.println("Mail sent successfully!");
        } catch (Exception ex) {
            System.out.println("Error --> " + ex.getMessage());
        }

    }

}
