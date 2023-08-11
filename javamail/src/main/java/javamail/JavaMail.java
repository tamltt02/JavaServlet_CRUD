package javamail;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class JavaMail {
	 public static void main(String[] args) {

	        final String username = "tamlttph19033@fpt.edu.vn";
	        final String password = "vtjekpdqurdtzpfs";

	        Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
	        prop.put("mail.smtp.port", "587");
	        prop.put("mail.smtp.auth", "true");
	        prop.put("mail.smtp.starttls.enable", "true"); //TLS
	        
	        Session session = Session.getInstance(prop,
	                new Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username, password);
	                    }
	                });

	        try {

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("tamlttph19033@fpt.edu.vn"));
	            message.setRecipients(
	                    Message.RecipientType.TO,
	                    InternetAddress.parse("lethithanhtam24102002hn@gmail.com")
	            );
	            message.setSubject("Testing Gmail TLS");
	            message.setText("Dear Mail Crawler,"
	                    + "\n\n Please do not spam my email!");

	            Transport.send(message);

	            System.out.println("Done");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
}
