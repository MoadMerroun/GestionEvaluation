import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
	public static void envoyerEmail(String toEmail, String nomComplet, String messg)
			throws IOException {

		// Informations d'Admin
		final String password = "ensate@2000";
		String fromEmail = "services.etudiants.ensate@gmail.com";

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromEmail));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			msg.setSubject("Service Messagerie SMS ENSA - " + nomComplet);
			Multipart contenu = new MimeMultipart();
			MimeBodyPart contneuText = new MimeBodyPart();
			contneuText.setText(messg);
			contenu.addBodyPart(contneuText);
			msg.setContent(contenu);
			Transport.send(msg);
		} catch (MessagingException ex) {
			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
