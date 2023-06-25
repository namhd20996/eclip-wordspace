package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import model.PhongModel;

public class PhongDao implements DAOInterface<PhongModel> {

	public static PhongDao getInstance() {
		return new PhongDao();
	}

	@Override
	public int insert(PhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into Phong(maPhong, tenPhong, maToaNha, loaiPhong, tang, soLuongNguoi, dienTich, giaPhong, moTa, hinhAnh, trangThai, ghiChu) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			pst.setString(2, t.getTenPhong());
			pst.setString(3, t.getMaToaNha());
			pst.setString(4, t.getLoaiPhong());
			pst.setInt(5, t.getTang());
			pst.setInt(6, t.getSoLuongNguoi());
			pst.setDouble(7, t.getDienTich());
			pst.setDouble(8, t.getGiaPhong());
			pst.setString(9, t.getMoTa());
			if (t.getHinhAnh() != null) {
				Blob hinh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(10, hinh);
			} else {
				Blob hinh = null;
				pst.setBlob(10, hinh);
			}
			pst.setString(11, t.getTrangThai());
			pst.setString(12, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(PhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update Phong set tenPhong=?, maToaNha=?, loaiPhong=?, tang=?, soLuongNguoi=?, dienTich=?, giaPhong=?, moTa=?, hinhAnh=?, trangThai=?, ghiChu=? "
					+ "where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);

			pst.setString(1, t.getTenPhong());
			pst.setString(2, t.getMaToaNha());
			pst.setString(3, t.getLoaiPhong());
			pst.setInt(4, t.getTang());
			pst.setInt(5, t.getSoLuongNguoi());
			pst.setDouble(6, t.getDienTich());
			pst.setDouble(7, t.getGiaPhong());
			pst.setString(8, t.getMoTa());
			if (t.getHinhAnh() != null) {
				Blob hinh = new SerialBlob(t.getHinhAnh());
				pst.setBlob(9, hinh);
			} else {
				Blob hinh = null;
				pst.setBlob(9, hinh);
			}
			pst.setString(10, t.getTrangThai());
			pst.setString(11, t.getGhiChu());
			pst.setString(12, t.getMaPhong());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int updateSuaPhong(PhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update Phong set  loaiPhong=?, tang=?, soLuongNguoi=?, dienTich=?, giaPhong=?, moTa=?,  trangThai=?, ghiChu=? "
					+ "where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getLoaiPhong());
			pst.setInt(2, t.getTang());
			pst.setInt(3, t.getSoLuongNguoi());
			pst.setDouble(4, t.getDienTich());
			pst.setDouble(5, t.getGiaPhong());
			pst.setString(6, t.getMoTa());
			pst.setString(7, t.getTrangThai());
			pst.setString(8, t.getGhiChu());
			pst.setString(9, t.getMaPhong());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public int updateInformation(PhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update Phong set trangThai=? " + "where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTrangThai());
			pst.setString(2, t.getMaPhong());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(PhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from Phong where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public PhongModel selectByID(PhongModel t) {
		PhongModel p = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from Phong where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				String maToaNha = rs.getString("maToaNha");
				String loaiPhong = rs.getString("loaiPhong");
				int tang = rs.getInt("tang");
				int soLuongNguoi = rs.getInt("soLuongNguoi");
				double dienTich = rs.getDouble("dienTich");
				double giaPhong = rs.getDouble("giaPhong");
				String moTa = rs.getString("moTa");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				String trangThai = rs.getString("trangThai");
				String ghiChu = rs.getString("ghiChu");
				p = new PhongModel(maPhong, tenPhong, maToaNha, loaiPhong, tang, soLuongNguoi, dienTich, giaPhong, moTa,
						hinhAnh, trangThai, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public ArrayList<PhongModel> selectAll() {
		ArrayList<PhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from Phong";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				String maToaNha = rs.getString("maToaNha");
				String loaiPhong = rs.getString("loaiPhong");
				int tang = rs.getInt("tang");
				int soLuongNguoi = rs.getInt("soLuongNguoi");
				double dienTich = rs.getDouble("dienTich");
				double giaPhong = rs.getDouble("giaPhong");
				String moTa = rs.getString("moTa");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				String trangThai = rs.getString("trangThai");
				String ghiChu = rs.getString("ghiChu");
				PhongModel p = new PhongModel(maPhong, tenPhong, maToaNha, loaiPhong, tang, soLuongNguoi, dienTich,
						giaPhong, moTa, hinhAnh, trangThai, ghiChu);
				list.add(p);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<PhongModel> findByTrangThaiIsNotNull() {
		ArrayList<PhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from Phong where trangThai is not null";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				String maToaNha = rs.getString("maToaNha");
				String loaiPhong = rs.getString("loaiPhong");
				int tang = rs.getInt("tang");
				int soLuongNguoi = rs.getInt("soLuongNguoi");
				double dienTich = rs.getDouble("dienTich");
				double giaPhong = rs.getDouble("giaPhong");
				String moTa = rs.getString("moTa");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				String trangThai = rs.getString("trangThai");
				String ghiChu = rs.getString("ghiChu");
				PhongModel p = new PhongModel(maPhong, tenPhong, maToaNha, loaiPhong, tang, soLuongNguoi, dienTich,
						giaPhong, moTa, hinhAnh, trangThai, ghiChu);
				list.add(p);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<PhongModel> selectTangCBO() {
		ArrayList<PhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select distinct (tang) from Phong order by tang";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int tang = rs.getInt("tang");
				PhongModel p = new PhongModel();
				p.setTang(tang);
				list.add(p);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<PhongModel> selectByTang(PhongModel t) {
		ArrayList<PhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from Phong where tang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getTang());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				String maToaNha = rs.getString("maToaNha");
				String loaiPhong = rs.getString("loaiPhong");
				int tang = rs.getInt("tang");
				int soLuongNguoi = rs.getInt("soLuongNguoi");
				double dienTich = rs.getDouble("dienTich");
				double giaPhong = rs.getDouble("giaPhong");
				String moTa = rs.getString("moTa");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				String trangThai = rs.getString("trangThai");
				String ghiChu = rs.getString("ghiChu");
				PhongModel p = new PhongModel(maPhong, tenPhong, maToaNha, loaiPhong, tang, soLuongNguoi, dienTich,
						giaPhong, moTa, hinhAnh, trangThai, ghiChu);
				list.add(p);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<PhongModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhongModel> selectByCondition(String condition) {
		ArrayList<PhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from Phong where " + condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				String maToaNha = rs.getString("maToaNha");
				String loaiPhong = rs.getString("loaiPhong");
				int tang = rs.getInt("tang");
				int soLuongNguoi = rs.getInt("soLuongNguoi");
				double dienTich = rs.getDouble("dienTich");
				double giaPhong = rs.getDouble("giaPhong");
				String moTa = rs.getString("moTa");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				String trangThai = rs.getString("trangThai");
				String ghiChu = rs.getString("ghiChu");
				PhongModel p = new PhongModel(maPhong, tenPhong, maToaNha, loaiPhong, tang, soLuongNguoi, dienTich,
						giaPhong, moTa, hinhAnh, trangThai, ghiChu);
				list.add(p);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<PhongModel> selectByKeyWord(String condition) {
		ArrayList<PhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from Phong where trangThai is null and maPhong like " + condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				String maToaNha = rs.getString("maToaNha");
				String loaiPhong = rs.getString("loaiPhong");
				int tang = rs.getInt("tang");
				int soLuongNguoi = rs.getInt("soLuongNguoi");
				double dienTich = rs.getDouble("dienTich");
				double giaPhong = rs.getDouble("giaPhong");
				String moTa = rs.getString("moTa");
				Blob blob = rs.getBlob("hinhAnh");
				byte[] hinhAnh = null;
				if (blob != null) {
					hinhAnh = blob.getBytes(1, (int) blob.length());
				}
				String trangThai = rs.getString("trangThai");
				String ghiChu = rs.getString("ghiChu");
				PhongModel p = new PhongModel(maPhong, tenPhong, maToaNha, loaiPhong, tang, soLuongNguoi, dienTich,
						giaPhong, moTa, hinhAnh, trangThai, ghiChu);
				list.add(p);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
