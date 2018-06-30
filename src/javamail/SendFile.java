
package javamail;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendFile {

	public static void main(String[] args) {

		String to = "james@java.com";
		String from = "scott@java.com";
		String filename = "e:\\classroom\\logo.jpg";

		String msgText = "A file is attached to this message";
		String subject = "Sending a file";

		// create some properties and get the default Session
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props, null);

		try {
			// create a message
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);

			// create and fill the first message part
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(msgText);

			// create the second message part
			MimeBodyPart mbp2 = new MimeBodyPart();
			// attach the file to the message
			FileDataSource fds = new FileDataSource(filename);
			mbp2.setDataHandler(new DataHandler(fds));
			mbp2.setFileName(fds.getName());

			// create the Multipart and its parts to it
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			mp.addBodyPart(mbp2);

			// add the Multipart to the message
			msg.setContent(mp);

			// send the message
			Transport.send(msg);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	} // end of main
}
