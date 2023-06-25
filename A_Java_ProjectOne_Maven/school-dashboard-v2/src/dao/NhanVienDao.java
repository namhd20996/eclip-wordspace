package dao;

import java.sql.Blob;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.logging.log4j.core.appender.db.jdbc.JdbcAppender;

import model.NhanVienModel;

public class NhanVienDao implements DAOInterface<NhanVienModel> {
	public static NhanVienDao getInstance() {
		return new NhanVienDao();
	}

	@Override
	public int insert(NhanVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into NhanVien (maNhanVien, matKhau, tenNhanVien, gioiTinh, vaiTro, email, maXacThuc, thoiGianHieuLucMaXacThuc, trangThaiXacThuc, hinhAnh) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNhanVien());
			pst.setString(2, t.getMatKhau());
			pst.setString(3, t.getTenNhanVien());
			pst.setString(4, t.getGioiTinh());
			pst.setBoolean(5, t.isVaiTro());
			pst.setString(6, t.getEmail());
			pst.setString(7, t.getMaXacThuc());
			pst.setTimestamp(8, t.getThoiGianHieuLucMaXacThuc());
			pst.setBoolean(9, t.isTrangThaiXacThuc());
			if (t.getHinhAnh() != null) {
				Blob hinhAnh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(10, hinhAnh);
			} else {
				Blob hinhAnh = null;
				pst.setBlob(10	, hinhAnh);
			}
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(NhanVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NhanVien set matKhau=?, tenNhanVien=?, gioiTinh=?, vaiTro=?, email=?, maXacThuc=?, thoiGianHieuLucMaXacThuc=?, trangThaiXacThuc=? "
					+ "where maNhanVien=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMatKhau());
			pst.setString(2, t.getTenNhanVien());
			pst.setString(3, t.getGioiTinh());
			pst.setBoolean(4, t.isVaiTro());
			pst.setString(5, t.getEmail());
			pst.setString(6, t.getMaXacThuc());
			pst.setTimestamp(7, t.getThoiGianHieuLucMaXacThuc());
			pst.setBoolean(8, t.isTrangThaiXacThuc());
			if (t.getHinhAnh() != null) {
				Blob hinhAnh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(9, hinhAnh);
			} else {
				Blob hinhAnh = null;
				pst.setBlob(9, hinhAnh);
			}
			pst.setString(10, t.getMaNhanVien());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(NhanVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NhanVien set trangThaiXacThuc = ? where maNhanVien = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setBoolean(1, t.isTrangThaiXacThuc());
			pst.setString(2, t.getMaNhanVien());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public NhanVienModel selectByID(NhanVienModel t) {
		NhanVienModel nv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien where maNhanVien=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNhanVien());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				String matKhau = rs.getString("matKhau");
				String tenNhanVien = rs.getString("tenNhanVien");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				boolean vaiTro = rs.getBoolean("vaiTro");
				String email = rs.getString("email");
				String maXacThuc = rs.getString("maXacThuc");
				Timestamp thoiGianHieuLucMaXacThuc = rs.getTimestamp("thoiGianHieuLucMaXacThuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangThaiXacThuc");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				nv = new NhanVienModel(maNhanVien, matKhau, tenNhanVien, tenNhanVien, vaiTro, email, maXacThuc,
						thoiGianHieuLucMaXacThuc, trangThaiXacThuc, hinhAnh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}

	@Override
	public ArrayList<NhanVienModel> selectAll() {
		ArrayList<NhanVienModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien where trangThaiXacThuc = 1";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				String matKhau = rs.getString("matKhau");
				String tenNhanVien = rs.getString("tenNhanVien");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				boolean vaiTro = rs.getBoolean("vaiTro");
				String email = rs.getString("email");
				String maXacThuc = rs.getString("maXacThuc");
				Timestamp thoiGianHieuLucMaXacThuc = rs.getTimestamp("thoiGianHieuLucMaXacThuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangThaiXacThuc");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				NhanVienModel nv = new NhanVienModel(maNhanVien, matKhau, tenNhanVien, tenNhanVien, vaiTro, email,
						maXacThuc, thoiGianHieuLucMaXacThuc, trangThaiXacThuc, hinhAnh);
				list.add(nv);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<NhanVienModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NhanVienModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public NhanVienModel checkLogin(NhanVienModel t) {
		NhanVienModel nv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien where maNhanVien=? and matKhau=? and trangThaiXacThuc=1";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNhanVien());
			pst.setString(2, t.getMatKhau());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNhanVien = rs.getString("maNhanVien");
				String matKhau = rs.getString("matKhau");
				String tenNhanVien = rs.getString("tenNhanVien");
				String gioiTinh = rs.getString("gioiTinh");
				boolean vaiTro = rs.getBoolean("vaiTro");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				nv = new NhanVienModel(maNhanVien, matKhau, tenNhanVien, gioiTinh, vaiTro, hinhAnh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}

	public int forgotPassword(NhanVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NhanVien " + "set matKhau=? " + "where maNhanVien=? and maXacThuc=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMatKhau());
			pst.setString(2, t.getMaNhanVien());
			pst.setString(3, t.getMaXacThuc());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public NhanVienModel checkEmail(NhanVienModel t) {
		NhanVienModel us = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien where maNhanVien=? and email= ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNhanVien());
			pst.setString(2, t.getEmail());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String user = rs.getString("maNhanVien");
				String email = rs.getString("email");
				us = new NhanVienModel();
				us.setMaNhanVien(user);
				us.setEmail(email);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return us;
	}

	public int updateInformation(NhanVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NhanVien " + "set maXacThuc=?, thoiGianHieuLucMaXacThuc=?, trangThaiXacThuc=? "
					+ "where maNhanVien=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaXacThuc());
			pst.setTimestamp(2, t.getThoiGianHieuLucMaXacThuc());
			pst.setBoolean(3, t.isTrangThaiXacThuc());
			pst.setString(4, t.getMaNhanVien());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<NhanVienModel> list = NhanVienDao.getInstance().selectAll();
		for (NhanVienModel nhanVienModel : list) {
			System.out.println(nhanVienModel);
		}
	}

}
