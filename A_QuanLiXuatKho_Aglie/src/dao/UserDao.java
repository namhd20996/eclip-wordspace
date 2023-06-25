package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import lib.MaHoa;
import model.UserModel;

public class UserDao implements DAOInterface<UserModel> {

	public static UserDao getInstance() {
		return new UserDao();
	}

	@Override
	public int insert(UserModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into taikhoan (userName, pass_Word, isRole, email) values " + "(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser());
			pst.setString(2, t.getPassWord());
			pst.setBoolean(3, t.isRole());
			pst.setString(4, t.getEmail());
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
			String sql = "update taikhoan set pass_Word=? where userName=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getPassWord());
			pst.setString(2, t.getUser());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public int updateTableUserJDialog(UserModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update taikhoan set pass_Word=?, email=?, isRole=? where userName=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getPassWord());
			pst.setString(2, t.getEmail());
			pst.setBoolean(3, t.isRole());
			pst.setString(4, t.getUser());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int updateInformation(UserModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update taikhoan " + "set maXacThuc=?, thoiGianHieuLucMaXacThuc=?, trangThaiXacThuc=? "
					+ "where userName=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaXacThuc());
			pst.setDate(2, t.getThoiGianHieuLucMaXacThuc());
			pst.setBoolean(3, t.isTrangThaiXacThuc());
			pst.setString(4, t.getUser());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int forgotPassword(UserModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update taikhoan " + "set pass_Word=? " + "where userName=? and maXacThuc=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getPassWord());
			pst.setString(2, t.getUser());
			pst.setString(3, t.getMaXacThuc());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(UserModel t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserModel selectByID(UserModel t) {
		UserModel u = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from taikhoan where userName=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String user = rs.getString("userName");
				String passWord = rs.getString("pass_Word");
				boolean role = rs.getBoolean("isRole");
				String email = rs.getString("email");
				String maXacThuc = rs.getString("maXacThuc");
				Date thoiGianHieuLucMaXacThuc = rs.getDate("thoiGianHieuLucMaXacThuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangThaiXacThuc");
				u = new UserModel(user, passWord, role, email, maXacThuc, thoiGianHieuLucMaXacThuc, trangThaiXacThuc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return u;
	}

	@Override
	public ArrayList<UserModel> selectAll() {
		ArrayList<UserModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from taikhoan";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String user = rs.getString("userName");
				String passWord = rs.getString("pass_Word");
				boolean role = rs.getBoolean("isRole");
				String email = rs.getString("email");
				String maXacThuc = rs.getString("maXacThuc");
				Date thoiGianHieuLucMaXacThuc = rs.getDate("thoiGianHieuLucMaXacThuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangThaiXacThuc");
				UserModel u = new UserModel(user, passWord, role, email, maXacThuc, thoiGianHieuLucMaXacThuc,
						trangThaiXacThuc);
				list.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<UserModel> selectByCondition(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserModel checkLogin(UserModel t) {
		UserModel us = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from taikhoan where userName=? and pass_Word= ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser());
			pst.setString(2, t.getPassWord());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String user = rs.getString("userName");
				String passWord = rs.getString("pass_Word");
				boolean role = rs.getBoolean("isRole");
				us = new UserModel(user, passWord, role);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return us;
	}

	public UserModel checkEmail(UserModel t) {
		UserModel us = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from taikhoan where userName=? and email= ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getUser());
			pst.setString(2, t.getEmail());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String user = rs.getString("userName");
				String email = rs.getString("email");
				us = new UserModel();
				us.setUser(user);
				us.setEmail(email);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return us;
	}

	public static void main(String[] args) {
//		UserModel um = new UserModel();
//		um.setUser("hosehold88");
//		um.setPassWord(MaHoa.toSHA1("123@aA"));
//		UserModel u = UserDao.getInstance().checkLogin(um);
//		System.out.println(u);
		ArrayList<UserModel> list = UserDao.getInstance().selectAll();
		for (UserModel userModel : list) {
			System.out.println(userModel);
		}
	}
}
