package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChuyenDeModel;
import model.KhoaHocModel;

public class ChuyenDeDAO implements DAOInterface<ChuyenDeModel> {

	public static ChuyenDeDAO getInstance() {
		return new ChuyenDeDAO();
	}

	@Override
	public int insert(ChuyenDeModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into ChuyenDe (maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa) values "
					+ "(?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenDe());
			pst.setString(2, t.getTenChuyenDe());
			pst.setDouble(3, t.getHocPhi());
			pst.setInt(4, t.getThoiLuong());
			pst.setString(5, t.getHinhLogo());
			pst.setString(6, t.getMoTa());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(ChuyenDeModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update ChuyenDe " + "set tenChuyenDe=?, hocPhi=?, thoiLuong=?, hinhLogo=?, moTa=? "
					+ "where maChuyenDe=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenChuyenDe());
			pst.setDouble(2, t.getHocPhi());
			pst.setInt(3, t.getThoiLuong());
			pst.setString(4, t.getHinhLogo());
			pst.setString(5, t.getMoTa());
			pst.setString(6, t.getMaChuyenDe());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(ChuyenDeModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from ChuyenDe where maChuyenDe=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenDe());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ChuyenDeModel selectByID(ChuyenDeModel t) {
		ChuyenDeModel cd = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChuyenDe where maChuyenDe=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenDe());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maChuyenDe = rs.getString("maChuyenDe");
				String tenChuyenDe = rs.getString("tenChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				String hinhLogo = rs.getString("hinhLogo");
				String moTa = rs.getString("moTa");
				cd = new ChuyenDeModel(maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cd;
	}
	
	public ChuyenDeModel selectByID(KhoaHocModel t) {
		ChuyenDeModel cd = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChuyenDe where maChuyenDe=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenDe());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maChuyenDe = rs.getString("maChuyenDe");
				String tenChuyenDe = rs.getString("tenChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				String hinhLogo = rs.getString("hinhLogo");
				String moTa = rs.getString("moTa");
				cd = new ChuyenDeModel(maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cd;
	}

	@Override
	public ArrayList<ChuyenDeModel> selectAll() {
		ArrayList<ChuyenDeModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChuyenDe";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maChuyenDe = rs.getString("maChuyenDe");
				String tenChuyenDe = rs.getString("tenChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				String hinhLogo = rs.getString("hinhLogo");
				String moTa = rs.getString("moTa");
				ChuyenDeModel cd = new ChuyenDeModel(maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa);
				list.add(cd);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<ChuyenDeModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChuyenDeModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ChuyenDeModel selectByTen(ChuyenDeModel t) {
		ChuyenDeModel cd = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChuyenDe where tenChuyenDe=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenChuyenDe());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maChuyenDe = rs.getString("maChuyenDe");
				String tenChuyenDe = rs.getString("tenChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				String hinhLogo = rs.getString("hinhLogo");
				String moTa = rs.getString("moTa");
				cd = new ChuyenDeModel(maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cd;
	}
	
	public ChuyenDeModel selectByStringTenCD(String t) {
		ChuyenDeModel cd = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChuyenDe where maChuyenDe=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maChuyenDe = rs.getString("maChuyenDe");
				String tenChuyenDe = rs.getString("tenChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				String hinhLogo = rs.getString("hinhLogo");
				String moTa = rs.getString("moTa");
				cd = new ChuyenDeModel(maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cd;
	}
}
