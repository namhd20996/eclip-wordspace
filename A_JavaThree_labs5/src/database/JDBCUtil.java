package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/quanlysinhvien";
			String user = "root";
			String password = "";
			c = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}	
