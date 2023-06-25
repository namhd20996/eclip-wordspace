package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ChuyenPhongModel;

public class ChuyenPhongDao implements DAOInterface<ChuyenPhongModel> {
	public static ChuyenPhongDao getInstance() {
		return new ChuyenPhongDao();
	}

	@Override
	public int insert(ChuyenPhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into ChuyenPhong (maChuyenPhong, maPhongCu, maPhongMoi, maNhanVien, soCCCDNT, ngayChuyen, ghiChu) values "
					+ "(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenPhong());
			pst.setString(2, t.getMaPhongCu());
			pst.setString(3, t.getMaPhongMoi());
			pst.setString(4, t.getMaNhanVien());
			pst.setString(5, t.getSoCCCDNT());
			pst.setDate(6, t.getNgayChuyen());
			pst.setString(7, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(ChuyenPhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update ChuyenPhong set maPhongCu=?, maPhongMoi=?, maNhanVien=?, soCCCDNT=?, ngayChuyen=?, ghiChu=? "
					+ "where maChuyenPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhongCu());
			pst.setString(2, t.getMaPhongMoi());
			pst.setString(3, t.getMaNhanVien());
			pst.setString(4, t.getSoCCCDNT());
			pst.setDate(5, t.getNgayChuyen());
			pst.setString(6, t.getGhiChu());
			pst.setString(7, t.getMaChuyenPhong());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(ChuyenPhongModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from ChuyenPhong where maChuyenPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenPhong());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ChuyenPhongModel selectByID(ChuyenPhongModel t) {
		ChuyenPhongModel c = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChuyenPhong where maChuyenPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenPhong());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maChuyenPhong = rs.getString("maChuyenPhong");
				String maPhongCu = rs.getString("maPhongCu");
				String maPhongMoi = rs.getString("maPhongMoi");
				String maNhanVien = rs.getString("maNhanVien");
				String soCCCDNT = rs.getString("soCCCDNT");
				Date ngayChuyen = rs.getDate("ngayChuyen");
				String ghiChu = rs.getString("ghiChu");
				c = new ChuyenPhongModel(maChuyenPhong, maPhongCu, maPhongMoi, maNhanVien, soCCCDNT, ngayChuyen,
						ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	@Override
	public ArrayList<ChuyenPhongModel> selectAll() {
		ArrayList<ChuyenPhongModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChuyenPhong";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maChuyenPhong = rs.getString("maChuyenPhong");
				String maPhongCu = rs.getString("maPhongCu");
				String maPhongMoi = rs.getString("maPhongMoi");
				String maNhanVien = rs.getString("maNhanVien");
				String soCCCDNT = rs.getString("soCCCDNT");
				Date ngayChuyen = rs.getDate("ngayChuyen");
				String ghiChu = rs.getString("ghiChu");
				ChuyenPhongModel c = new ChuyenPhongModel(maChuyenPhong, maPhongCu, maPhongMoi, maNhanVien, soCCCDNT,
						ngayChuyen, ghiChu);
				list.add(c);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<ChuyenPhongModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChuyenPhongModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
