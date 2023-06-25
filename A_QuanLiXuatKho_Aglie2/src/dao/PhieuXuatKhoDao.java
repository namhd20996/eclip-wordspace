package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.PhieuXuatKhoModel;

public class PhieuXuatKhoDao implements DAOInterface<PhieuXuatKhoModel> {

	public static PhieuXuatKhoDao getInstance() {
		return new PhieuXuatKhoDao();
	}

	@Override
	public int insert(PhieuXuatKhoModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "INSERT INTO phieuxuatkho (maPhieuXuat, ngayLap, ngayXuat, maCuaHang, userName) VALUES\r\n"
					+ "(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuXuat());
			pst.setDate(2, t.getNgayLap());
			pst.setDate(3, t.getNgayXuat());
			pst.setString(4, t.getMaCuaHang());
			pst.setString(5, t.getUser());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(PhieuXuatKhoModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update phieuxuatkho " + "set ngayLap=?, ngayXuat=?, maCuaHang=?, userName=? " + "where maPhieuXuat=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setDate(1, t.getNgayLap());
			pst.setDate(2, t.getNgayXuat());
			pst.setString(3, t.getMaCuaHang());
			pst.setString(4, t.getUser());
			pst.setString(5, t.getMaPhieuXuat());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(PhieuXuatKhoModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from phieuxuatkho where maPhieuXuat=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuXuat());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public PhieuXuatKhoModel selectByID(PhieuXuatKhoModel t) {
		PhieuXuatKhoModel pxk = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from phieuxuatkho where maPhieuXuat=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuXuat());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maPhieuXuat = rs.getString("maPhieuXuat");
				Date ngayLap = rs.getDate("ngayLap");
				Date ngayXuat = rs.getDate("ngayXuat");
				String maCuaHang = rs.getString("maCuaHang");
				String user = rs.getString("userName");
				pxk = new PhieuXuatKhoModel(maPhieuXuat, ngayLap, ngayXuat, maCuaHang, user);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return pxk;
	}

	@Override
	public ArrayList<PhieuXuatKhoModel> selectAll() {
		ArrayList<PhieuXuatKhoModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from phieuxuatkho";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhieuXuat = rs.getString("maPhieuXuat");
				Date ngayLap = rs.getDate("ngayLap");
				Date ngayXuat = rs.getDate("ngayXuat");
				String maCuaHang = rs.getString("maCuaHang");
				String user = rs.getString("userName");
				PhieuXuatKhoModel pxk = new PhieuXuatKhoModel(maPhieuXuat, ngayLap, ngayXuat, maCuaHang, user);
				list.add(pxk);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<PhieuXuatKhoModel> selectByCondition(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
