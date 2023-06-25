package bai_1;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SendEmailTLS {
	public static final String from = "hoangduynam20996@gmail.com";
	public static final String passWord = "zjpapbalzczsdiop";

	public static void sendEmail(String to, String title, String content) {
		Properties pros = new Properties();
		pros.put("mail.smtp.host", "smtp.gmail.com");
		pros.put("mail.smtp.port", "587");
		pros.put("mail.smtp.auth", "true");
		pros.put("mail.smtp.starttls.enable", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, passWord);
			}

		};
		Session session = Session.getInstance(pros, auth);
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setHeader("Content-type", "text/html; charset=UTF-8");
			msg.setFrom(from);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			msg.setSubject(title);
			msg.setSentDate(new Date());
			msg.setContent(content, "text/html; charset=UTF-8");
			Transport.send(msg);
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println();
		}
	}
	public static void main(String[] args) {
		sendEmail("namhdps25979@fpt.edu.vn", "CC", "CC");
	}
}
