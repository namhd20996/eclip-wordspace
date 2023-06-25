package lib;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	static final String from = "hoangduynam20996@gmail.com";
	static final String passWord = "fuaycypcqvrdsjyy";

	public static void sendEmail(String to, String tieuDe, String noiDung) {
//		final String to = "namhdps25979@fpt.edu.vn";

		// Properties: Khai báo các thuộc tính
		Properties pros = new Properties();
		// Gửi từ gmail, từ sever nào
		pros.put("mail.smtp.host", "smtp.gmail.com");
		// Port có 2 loại: tls = 587, ssl = 465
		pros.put("mail.smtp.port", "587");
		// Khai báo phải đăng nhập để gửi mail
		pros.put("mail.smtp.auth", "true");
		// Định nghĩa giao thức
		pros.put("mail.smtp.starttls.enable", "true");

		// Tạo đổi tượng auth để đăng nhập vào gmail
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, passWord);
			}

		};

		// Tạo phiên làm việc
		// Đưa các thuộc tính và tài khoản vào phiên làm việc
		Session session = Session.getInstance(pros, auth);
		// Gửi email
		// Tạo tin nhắn mới
		MimeMessage msg = new MimeMessage(session);
		try {
			// Gửi email có nội dung kiểu text và html
			msg.addHeader("Content-type", "text/html; charset=UTF-8");
			// Gửi từ đâu
			msg.setFrom("");
			// Gửi cho ai và kiểu gửi
			// InternetAddress giúp kiểm tra có đúng định dạng hay không
			// InternetAddress.parse(to, false) để nó ko có Address list
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
			// Tiêu đề
			msg.setSubject(tieuDe);
			// Quy định ngày gửi
			msg.setSentDate(new Date());
			// Quy định email nhận phản hồi
			// Nếu để email nhận phản hồi là email đã gửi đến thì không cần setReplyto
//			msg.setReplyTo(InternetAddress.parse(from, false));
			/*
			 * Nội dung gửi bằng text msg.setText("Đây là phần nội dung", "UTF-8");
			 */
//			// Nội dung gửi bằng htmk
//			msg.setContent("<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "<head>\r\n"
//					+ "    <meta charset=\"UTF-8\">\r\n"
//					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
//					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
//					+ "    <title>Document</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "    <h1>Hello!</h1>\r\n"
//					+ "    <img src=\"https://taimienphi.vn/tmp/cf/aut/anh-gai-xinh-1.jpg\" alt=\"\">\r\n"
//					+ "</body>\r\n" + "</html>", "text/html	");
			msg.setContent(noiDung, "text/html; charset=UTF-8");
			// Gửi mail
			Transport.send(msg);
			System.out.println("Gửi email thành công");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			System.out.println("Gửi email không thành công");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String arr[] = { "boldkillbase@gmail.com", "namhdps25979@fpt.edu.vn" };
		for (int i = 0; i < arr.length; i++) {
			sendEmail(arr[i], "Test", "Hello fen");
		}
	}
}
