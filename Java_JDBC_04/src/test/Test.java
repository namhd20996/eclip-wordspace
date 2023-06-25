package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;

public class Test {
	public static void main(String[] args) {
		try {
			// Bước 1 tạo kết nối
			Connection connection =  JDBCUtil.getConnection();
			// Bước 2 tạo ra đối tượng statement
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "INSERT persons VALUES \r\n"
					+ "(\"5\", \"Tran\", \"Van C\", \"M\", \"1995-10-10\", 1000000),\r\n"
					+ "(\"6\", \"Tran\", \"Van D\", \"M\", \"1996-10-10\", 1000000)";
			int check = st.executeUpdate(sql);
			// Bước 4 xử lý kết quả
			System.out.println("Số dòng thay đổi" +check);
			if(check>0) {
				System.out.println("thêm dữ liệu thành công");
			}else {
				System.out.println("Fail");
			}
			// Bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
