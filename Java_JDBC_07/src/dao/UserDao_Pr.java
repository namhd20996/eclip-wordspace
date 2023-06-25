package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDao_Pr implements DAOInterface<User> {

	public static UserDao_Pr getInstane() {
		return new UserDao_Pr();
	}

	@Override
	public int insert(User t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2
			String sql = "INSERT INTO user_name (`user_Name`, `pass_Word`, `hoVaTen`) VALUES\r\n" + 
					"(?, ?, ?)";
			// Bước 3 thực thi câu lệnh
			PreparedStatement  pst = connection.prepareStatement(sql);
			
			pst.setString(1, t.getUser_Name());
			pst.setString(2, t.getPass_Word());
			pst.setString(3, t.getHoVaTen());
			
			result = pst.executeUpdate();
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
			Connection connection = JDBCUtil.getConnection();
			String sql = "UPDATE user_name " + 
						"SET " + "pass_Word = ? ," +
						"hoVaTen = ?" + 
						"WHERE user_Name = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getPass_Word());
			pst.setString(2, t.getHoVaTen());
			pst.setString(3, t.getUser_Name());
			result = pst.executeUpdate();
			System.out.println("Số dòng bị thay đổi: "+ result);
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(User t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "DELETE FROM user_name WHERE user_Name = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser_Name());
			result = pst.executeUpdate();
			System.out.println("Số dòng bị xóa: "+result);
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> result = new ArrayList<User>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM user_name";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			// next trong Result nó lấy các row tiếp theo
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
			String sql = "SELECT * FROM user_name WHERE user_Name = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser_Name());
			ResultSet rs = pst.executeQuery(sql);
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
