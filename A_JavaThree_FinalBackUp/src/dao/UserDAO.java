package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.UserModel;

public class UserDAO implements DAOInterface<UserModel> {

	public static UserDAO getInstance() {
		return new UserDAO();
	}

	@Override
	public int insert(UserModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into users (userName, passWordU, roleU) values\n" + "(?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser());
			pst.setString(2, t.getPassWord());
			pst.setString(3, t.getRole());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(UserModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update users\n" + "set passWordU =?, roleU=?\n" + "where userName = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getPassWord());
			pst.setString(2, t.getRole());
			pst.setString(3, t.getUser());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(UserModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from users where userName = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<UserModel> selectAll() {
		ArrayList<UserModel> list = new ArrayList<UserModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from users";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String user = rs.getString("userName");
				String passWord = rs.getString("passWordU");
				String role = rs.getString("roleU");
				UserModel u = new UserModel(user, passWord, role);
				list.add(u);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public UserModel selectByID(UserModel t) {
		UserModel u = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from users where userName = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String user = rs.getString("userName");
				String passWord = rs.getString("passWordU");
				String role = rs.getString("roleU");
				return u = new UserModel(user, passWord, role);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return u;
	}

	@Override
	public ArrayList<UserModel> selectByCondition(String condition) {
		ArrayList<UserModel> list = new ArrayList<UserModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from users where " + condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String user = rs.getString("userName");
				String passWord = rs.getString("passWordU");
				String role = rs.getString("roleU");
				UserModel u = new UserModel(user, passWord, role);
				list.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public UserModel checkLogin(UserModel t) {
		UserModel u = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select userName, passWordU, roleU from users where userName = ? and passWordU = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser());
			pst.setString(2, t.getPassWord());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				u = new UserModel();
				String user = rs.getString("userName");
//				String passWord = rs.getString("passWordU");
				String role = rs.getString("roleU");
				u.setUser(user);
				u.setRole(role);
				return u;
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return u;
	}

}
