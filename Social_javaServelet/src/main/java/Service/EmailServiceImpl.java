package Service;

import javax.servlet.ServletContext;

import Entitty.User;
import Utils.SendEmail;

public class EmailServiceImpl implements EmailSerVice {
	private static final String Email_welcome = "welcome to Online Entrertainment";
	private static final String Email_forgot = "new pass forgot";

	@Override
	public void sendEmail(ServletContext context, User recipient, String type) {
		String host = "smtp.mailtrap.io";
		String port = "25";
		String user = "d0bbcda427ac24";
		String pass = "d577a1d7a30b35";
		try {
			String content = null;
			String subject = null;
			switch (type) {
			case "welcome":
				subject = Email_welcome;
				content = "Dear ," + recipient.getUsername() + ",hope you have a";
				break;
			case "forgot":
				subject = Email_forgot;
				content = "Dearrrr ," + recipient.getUsername() + "new pass : " + recipient.getPassword();
				break;
			}
			SendEmail.sendEmail(host, port, user, pass, recipient.getEmail(), subject, content);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
