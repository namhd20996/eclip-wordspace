package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class Test {
	public static void main(String[] args) {
		try {
			// Kết nối
			Connection connection = JDBCUtil.getConnection();
			// Tạo đối tượng Statement
			Statement st = connection.createStatement();
			// Thực thi câu lệnh
			
			// Close
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
