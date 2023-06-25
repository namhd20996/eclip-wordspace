package dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.text.StyledEditorKit.BoldAction;

import database.JDBCUtil;
import model.StudentModel;

public class StudentDAO implements DAOInterface<StudentModel> {
	public static StudentDAO getInstance() {
		return new StudentDAO();
	}

	@Override
	public int insert(StudentModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into students (maSV, hoTen, email, soDT, gioiTinh, diaChi, hinh) values\n"
					+ "(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			pst.setString(2, t.getHoTen());
			pst.setString(3, t.getEmail());
			pst.setString(4, t.getSoDT());
			pst.setBoolean(5, t.isGioiTinh());
			pst.setString(6, t.getDiaChi());
//			File input = null;
//			BufferedImage read = ImageIO.read(input);
			if (t.getHinh() != null) {
				Blob hinh = new SerialBlob(t.getHinh());
				pst.setBlob(7, hinh);
			} else {
				Blob hinh = null;
				pst.setBlob(7, hinh);
			}
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
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
			String sql = "update students\n" + "set hoTen=?, email=?, soDT=?, gioiTinh=?, diaChi=?, hinh=?\n"
					+ "where maSV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getHoTen());
			pst.setString(2, t.getEmail());
			pst.setString(3, t.getSoDT());
			pst.setBoolean(4, t.isGioiTinh());
			pst.setString(5, t.getDiaChi());
//			File input = null;
//			BufferedImage read = ImageIO.read(input);
			if (t.getHinh() != null) {
				Blob hinh = new SerialBlob(t.getHinh());
				pst.setBlob(6, hinh);
			} else {
				Blob hinh = null;
				pst.setBlob(6, hinh);
			}
			pst.setString(7, t.getMaSV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
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
			String sql = "delete from students where maSV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<StudentModel> selectAll() {
		ArrayList<StudentModel> list = new ArrayList<StudentModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM students";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maSV = rs.getString("maSV");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String soDT = rs.getString("soDT");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
//				 Chuyển đổi hình ảnh từ mysql
				Blob blob = rs.getBlob("hinh");
				byte[] hinh = null;
				if (blob != null) {
					hinh = blob.getBytes(1, (int) blob.length());
				}
				StudentModel st = new StudentModel(maSV, hoTen, email, soDT, gioiTinh, diaChi, hinh);
				list.add(st);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public StudentModel selectByID(StudentModel t) {
		StudentModel st = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM students WHERE maSV = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maSV = rs.getString("maSV");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String soDT = rs.getString("soDT");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				// Chuyển đổi hình ảnh từ mysql
				Blob blob = rs.getBlob("hinh");
				byte[] hinh = null;
				if (blob != null) {
					hinh = blob.getBytes(1, (int) blob.length());
				}

				return st = new StudentModel(maSV, hoTen, email, soDT, gioiTinh, diaChi, hinh);
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
			String sql = "select * from students where " + condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maSV = rs.getString("maSV");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("soDT");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				// Chuyển đổi hình ảnh từ mysql
				Blob blob = rs.getBlob("hinh");
				byte[] hinh = null;
				if (blob != null) {
					hinh = blob.getBytes(1, (int) blob.length());
				}
				StudentModel st = new StudentModel(maSV, hoTen, email, email, gioiTinh, diaChi, hinh);
				list.add(st);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
