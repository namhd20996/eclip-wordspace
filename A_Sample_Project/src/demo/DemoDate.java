package demo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import lib.XDate;

public class DemoDate {
	public static void main(String[] args) {
		String a = "31/12/2020";
		Date b = XDate.dateFormat(a, "dd/MM/yyyy");
		System.out.println(b);
		
		String t = XDate.dateString(b);
		System.out.println(t);
		
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			String url = "jdbc:sqlserver://DESKTOP-38IS4DJ\\SQLEXPRESS:1433;databaseName=Polypro;"
//					+ "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
//			String user = "sa";
//			String passWord = "123";
//			Connection connection = DriverManager.getConnection(url, user, passWord);
//			System.out.println("TT");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
