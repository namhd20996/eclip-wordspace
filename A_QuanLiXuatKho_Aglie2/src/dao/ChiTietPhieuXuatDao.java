package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChiTietPhieuXuatModel;

public class ChiTietPhieuXuatDao implements DAOInterface<ChiTietPhieuXuatModel> {

	public static ChiTietPhieuXuatDao getInstance() {
		return new ChiTietPhieuXuatDao();
	}

	@Override
	public int insert(ChiTietPhieuXuatModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "INSERT INTO chitietphieuxuat (maPhieuxuat, maMatHang, soLuong, ghiChu) VALUES "
					+ "(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuXuat());
			pst.setString(2, t.getMaMatHang());
			pst.setInt(3, t.getSoLuong());
			pst.setString(4, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(ChiTietPhieuXuatModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update chitietphieuxuat " + "set maMatHang=?, soLuong=?, ghiChu=? " + "where maPhieuXuat=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaMatHang());
			pst.setInt(2, t.getSoLuong());
			pst.setString(3, t.getGhiChu());
			pst.setString(4, t.getMaPhieuXuat());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(ChiTietPhieuXuatModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from chitietphieuxuat where maPhieuXuat=?";
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
	public ChiTietPhieuXuatModel selectByID(ChiTietPhieuXuatModel t) {
		ChiTietPhieuXuatModel ctpx = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from chitietphieuxuat where maPhieuXuat=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuXuat());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maPhieuXuat = rs.getString("maPhieuXuat");
				String maMatHang = rs.getString("maMatHang");
				int soLuong = rs.getInt("soLuong");
				String ghiChu = rs.getString("ghiChu");
				ctpx = new ChiTietPhieuXuatModel(maPhieuXuat, maMatHang, soLuong, ghiChu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ctpx;
	}

	@Override
	public ArrayList<ChiTietPhieuXuatModel> selectAll() {
		ArrayList<ChiTietPhieuXuatModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from chitietphieuxuat ";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhieuXuat = rs.getString("maPhieuXuat");
				String maMatHang = rs.getString("maMatHang");
				int soLuong = rs.getInt("soLuong");
				String ghiChu = rs.getString("ghiChu");
				ChiTietPhieuXuatModel ctpx = new ChiTietPhieuXuatModel(maPhieuXuat, maMatHang, soLuong, ghiChu);
				list.add(ctpx);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<ChiTietPhieuXuatModel> selectByCondition(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
