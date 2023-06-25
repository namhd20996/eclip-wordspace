package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.HangHoaModel;

public class HangHoaDao implements DAOInterface<HangHoaModel> {

	public static HangHoaDao getInstance() {
		return new HangHoaDao();
	}

	@Override
	public int insert(HangHoaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into hanghoa (maMatHang, tenMatHang, donViTinh, donGia, maLoaiHang) values (?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaMatHang());
			pst.setString(2, t.getTenMatHang());
			pst.setString(3, t.getDonViTinh());
			pst.setDouble(4, t.getDonGia());
			pst.setString(5, t.getMaLoaiHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(HangHoaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update hanghoa " + "set tenMatHang=?, donViTinh=?, donGia=?, maLoaiHang=? "
					+ "where maMatHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenMatHang());
			pst.setString(2, t.getDonViTinh());
			pst.setDouble(3, t.getDonGia());
			pst.setString(4, t.getMaLoaiHang());
			pst.setString(5, t.getMaMatHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(HangHoaModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from hanghoa where maMatHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaMatHang());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi "+result+" dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public HangHoaModel selectByID(HangHoaModel t) {
		HangHoaModel hh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from hanghoa where maMatHang=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaMatHang());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maMatHang = rs.getString("maMatHang");
				String tenMatHang = rs.getString("tenMatHang");
				String donViTinh = rs.getString("donViTinh");
				double donGia = rs.getDouble("donGia");
				String maLoaiHang = rs.getString("maLoaiHang");
				hh = new HangHoaModel(maMatHang, tenMatHang, donViTinh, donGia, maLoaiHang);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hh;
	}

	@Override
	public ArrayList<HangHoaModel> selectAll() {
		ArrayList<HangHoaModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from hanghoa";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maMatHang = rs.getString("maMatHang");
				String tenMatHang = rs.getString("tenMatHang");
				String donViTinh = rs.getString("donViTinh");
				double donGia = rs.getDouble("donGia");
				String maLoaiHang = rs.getString("maLoaiHang");
				HangHoaModel hh = new HangHoaModel(maMatHang, tenMatHang, donViTinh, donGia, maLoaiHang);
				list.add(hh);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<HangHoaModel> selectByCondition(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
