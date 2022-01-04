//import java.io.IOException;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//import javax.swing.JOptionPane;
//
//public class SendEmail {
//	public static void envoyerEmailPlanning(String toEmail, String docPdf, String nomComplet)
//			throws IOException {
//
//		// Informations d'Admin
//		final String password = "ensate@2000";
//		String fromEmail = "services.etudiants.ensate@gmail.com";
//
//		Properties properties = new Properties();
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.port", "587");
//
//		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(fromEmail, password);
//			}
//		});
//
//		try {
//			MimeMessage msg = new MimeMessage(session);
//			msg.setFrom(new InternetAddress(fromEmail));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
//			msg.setSubject("Planning - " + nomComplet);
//			Multipart contenu = new MimeMultipart();
//			MimeBodyPart contneuText = new MimeBodyPart();
//			contneuText
//					.setText("Bonjour " + nomComplet + ",\n"
//							+ "Veuillez trouvez ci-joint le planning des examens.\nCordialement");
//			MimeBodyPart attachementpdf = new MimeBodyPart();
//			attachementpdf.attachFile(docPdf);
//			contenu.addBodyPart(contneuText);
//			contenu.addBodyPart(attachementpdf);
//			msg.setContent(contenu);
//			Transport.send(msg);
//			JOptionPane.showMessageDialog(null,
//					"L'email contenant le document est envoyé aux étudiants" + nomComplet);
//		} catch (MessagingException ex) {
//			Logger.getLogger(SendEmail.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}
//
//	public static void main(String[] args) {
//		try {
//			envoyerEmailPlanning("merroun2000@gmail.com",
//					"C:\\Users\\Surface Pro\\Music\\Planning-des-controles_CF_-Automne-2021.pdf", "Moad Merroun");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//}
