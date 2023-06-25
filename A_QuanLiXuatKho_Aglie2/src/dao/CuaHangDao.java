package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import database.JDBCUtil;
import model.CuaHangModel;

public class CuaHangDao implements DAOInterface<CuaHangModel> {

	public static CuaHangDao getInstance() {
		return new CuaHangDao();
	}

	@Override
	public int insert(CuaHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "INSERT INTO cuahang (maCuaHang, tenCuaHang, diaChi, soDienThoai, email, nguoiDaiDien, hinhAnh) VALUES\r\n"
					+ "(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCuaHang());
			pst.setString(2, t.getTenCuaHang());
			pst.setString(3, t.getDiaChi());
			pst.setString(4, t.getSoDienThoai());
			pst.setString(5, t.getEmail());
			pst.setString(6, t.getNguoiDaiDien());
			if (t.getHinhAnh() != null) {
				Blob hinhAnh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(7, hinhAnh);
			} else {
				Blob hinhAnh = null;
				pst.setBlob(7, hinhAnh);
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
	public int update(CuaHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update cuahang "
					+ "set tenCuaHang=?, diaChi=?, soDienThoai=?, email=?, nguoiDaiDien=?, hinhAnh=? "
					+ "where maCuaHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenCuaHang());
			pst.setString(2, t.getDiaChi());
			pst.setString(3, t.getSoDienThoai());
			pst.setString(4, t.getEmail());
			pst.setString(5, t.getNguoiDaiDien());
			if (t.getHinhAnh() != null) {
				Blob hinhAnh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(6, hinhAnh);
			} else {
				Blob hinhAnh = null;
				pst.setBlob(6, hinhAnh);
			}
			pst.setString(7, t.getMaCuaHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(CuaHangModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from cuahang where maCuaHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCuaHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public CuaHangModel selectByID(CuaHangModel t) {
		CuaHangModel ch = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from cuahang where maCuaHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaCuaHang());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maCuaHang = rs.getString("maCuaHang");
				String tenCuaHang = rs.getString("tenCuaHang");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				String nguoiDaiDien = rs.getString("nguoiDaiDien");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				ch = new CuaHangModel(maCuaHang, tenCuaHang, diaChi, soDienThoai, email, nguoiDaiDien, hinhAnh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ch;
	}

	@Override
	public ArrayList<CuaHangModel> selectAll() {
		ArrayList<CuaHangModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from cuahang";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maCuaHang = rs.getString("maCuaHang");
				String tenCuaHang = rs.getString("tenCuaHang");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				String nguoiDaiDien = rs.getString("nguoiDaiDien");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				CuaHangModel ch = new CuaHangModel(maCuaHang, tenCuaHang, diaChi, soDienThoai, email, nguoiDaiDien,
						hinhAnh);
				list.add(ch);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public ArrayList<CuaHangModel> selectByKeyWord(String str) {
		ArrayList<CuaHangModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from cuahang where maCuaHang like ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, "%"+str+"%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maCuaHang = rs.getString("maCuaHang");
				String tenCuaHang = rs.getString("tenCuaHang");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				String email = rs.getString("email");
				String nguoiDaiDien = rs.getString("nguoiDaiDien");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				CuaHangModel ch = new CuaHangModel(maCuaHang, tenCuaHang, diaChi, soDienThoai, email, nguoiDaiDien,
						hinhAnh);
				list.add(ch);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	@Override
	public ArrayList<CuaHangModel> selectByCondition(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
