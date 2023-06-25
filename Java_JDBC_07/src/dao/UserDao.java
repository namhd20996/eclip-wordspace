package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDao implements DAOInterface<User> {

	public static UserDao getInstane() {
		return new UserDao();
	}

	@Override
	public int insert(User t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2 tạo đối tượng
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "INSERT INTO user_name (`user_Name`, `pass_Word`, `hoVaTen`) VALUES\r\n" + 
			"('" +t.getUser_Name() + "', '" + t.getPass_Word() + "', '" + t.getHoVaTen() + "')";
			result = st.executeUpdate(sql);
			// Bước 4 xử lý kết quả
			System.out.println("Bạn đã thực thi SQL" + sql);
			System.out.println("Số dòng bị thay đổi: " + result);
			// Bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(User t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2 tạo đối tượng
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "UPDATE User" + " SET " + "pass_Word='" + t.getPass_Word() + "', hoVaTen=" + t.getHoVaTen()
					+  " WHERE user_Name = '" + t.getUser_Name() + "'";
			System.out.println(sql);
			result = st.executeUpdate(sql);
			// Bước 4 xử lý kết quả
			System.out.println("Bạn đã thực thi SQL" + sql);
			System.out.println("Số dòng bị thay đổi: " + result);
			// Bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(User t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2 tạo đối tượng
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "DELETE FROM User" 
					+ " WHERE user_Name= '"+ t.getUser_Name() + "'" ;
			System.out.println(sql);
			result = st.executeUpdate(sql);
			// Bước 4 xử lý kết quả
			System.out.println("Bạn đã thực thi SQL" + sql);
			System.out.println("Số dòng bị thay đổi: " + result);
			// Bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> result = new ArrayList<User>();
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM User";
			ResultSet rs = st.executeQuery(sql);
			// nex trong Result nó lấy các row tiếp theo
			while(rs.next()) {
				String user_Name = rs.getString("user_Name");
				String pass_Word = rs.getString("pass_Word");
				String hoVaTen = rs.getString("hoVaTen");
				User User = new User(user_Name, pass_Word, hoVaTen);
				result.add(User);
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public User selectByID(User t) {
		User result = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM user_name WHERE user_Name = \"" + t.getUser_Name() + "\"";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String user_Name = rs.getString("user_Name");
				String pass_Word = rs.getString("pass_Word");
				String hoVaTen = rs.getString("hoVaTen");
				result = new User(user_Name, pass_Word, hoVaTen);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<User> selectByCondition(String condition) {
		return null;
	}

}
