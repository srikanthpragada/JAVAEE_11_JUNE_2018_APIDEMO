package javamail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailFromGmail {

	public static void main(String args[]) {
		String SMTP_HOST_NAME = "smtp.gmail.com";
		String SMTP_PORT = "465"; // or use 567
		String toAddress = "srikanthpragada@gmail.com";
		final String username = "abc";
		final String fromAddress = username + "@gmail.com";
		final String password = "abc";
		String subject = "Test";
		String body = "A mail to test my program!";

		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

		try {

			// Security.addProvider(new Provider());
			Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.port", SMTP_PORT);
			props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
			props.put("mail.smtp.socketFactory.fallback", "false");

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromAddress));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			msg.setSubject(subject);
			msg.setText(body);
			Transport.send(msg);
			System.out.println("<h4>Mail has been sent Successfully!</h4>");
		} catch (Exception ex) {

			System.out.println(ex);
		}
	}

}
