package database;

import java.sql.Connection;


import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;databaseName=Polypro;"
					+ "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			String user = "sa";
			String passWord = "123";
			c = DriverManager.getConnection(url, user, passWord);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		Connection cc = getConnection();
		System.out.println(cc);
	}
}
