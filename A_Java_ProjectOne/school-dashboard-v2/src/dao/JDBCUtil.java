package dao;

import java.sql.Connection;


import java.sql.DriverManager;

import model.PhongModel;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyNhaTro;"
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
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
//		for(int i=0; i<100; i++) {
//			PhongModel phong = new PhongModel("L"+i, null, null, null, i, i, i, i, null, null, null, null);
//			PhongDao.getInstance().insert(phong);
//		}
		Connection connection = getConnection();
		System.out.println(connection);
	}
}
