package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		// Đăng ký Driver
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// Các thông số để truyền
			String url = "jdbc:mySQL://localhost:3306/nhasach";
			String user = "root";
			String password = "";
			c = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
