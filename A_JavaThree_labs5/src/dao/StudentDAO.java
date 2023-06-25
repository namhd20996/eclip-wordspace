package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.StudentModel;

public class StudentDAO implements DAOInterface<StudentModel> {

	public static StudentDAO getInstane() {
		return new StudentDAO();
	}

	@Override
	public int insert(StudentModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into student (maSV, hoTen, email, soDT, gioiTinh, diaChi) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			pst.setString(2, t.getHoTen());
			pst.setString(3, t.getEmail());
			pst.setString(4, t.getSoDT());
			pst.setBoolean(5, t.isGioiTinh());
			pst.setString(6, t.getDiaChi());
			result = pst.executeUpdate();
			System.out.println(sql);
			System.out.println(result);
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(StudentModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "UPDATE student\r\n"
					+ "SET hoTen = ?, email = ?, soDT = ?, gioiTinh = ?, diaChi = ?\r\n"
					+ "WHERE maSV = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getHoTen());
			pst.setString(2, t.getEmail());
			pst.setString(3, t.getSoDT());
			pst.setBoolean(4, t.isGioiTinh());
			pst.setString(5, t.getDiaChi());
			pst.setString(6, t.getMaSV());
			result = pst.executeUpdate();
			System.out.println(sql);
			System.out.println(result);
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(StudentModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from student where maSV = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			result = pst.executeUpdate();
			System.out.println(result);
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<StudentModel> selectAll() {
		ArrayList<StudentModel> ds = new ArrayList<StudentModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from student";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maSV = rs.getString("maSV");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String soDT = rs.getString("soDT");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				StudentModel st = new StudentModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
				ds.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}

	@Override
	public StudentModel selectByID(StudentModel t) {
		StudentModel st = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from stduent where maSV = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maSV = rs.getString("maSV");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String soDT = rs.getString("soDT");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				st = new StudentModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return st;
	}

	@Override
	public ArrayList<StudentModel> selectByCondition(String condition) {
		ArrayList<StudentModel> list = new ArrayList<StudentModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from student where "+ condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maSV = rs.getString("maSV");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String soDT = rs.getString("soDT");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				StudentModel st = new StudentModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
				list.add(st);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
