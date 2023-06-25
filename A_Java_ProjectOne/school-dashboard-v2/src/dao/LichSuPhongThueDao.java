package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.LichSuPhongThueModel;

public class LichSuPhongThueDao implements DAOInterface<LichSuPhongThueModel> {
	public static LichSuPhongThueDao getInstance() {
		return new LichSuPhongThueDao();
	}

	@Override
	public int insert(LichSuPhongThueModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into LichSuPhongThue (maNguoiThue,maPhong, soCCCDNT, ngayThue, ngayTraPhong) values "
					+ "(?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiThue());
			pst.setString(2, t.getMaPhong());
			pst.setString(3, t.getSoCCCDNT());
			pst.setDate(4, t.getNgayThue());
			pst.setDate(5, t.getNgayTraPhong());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(LichSuPhongThueModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update LichSuPhongThue set maPhong=?, soCCCDNT=?, ngayThue=?, ngayTraPhong=? "
					+ "where maNguoiThue=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			pst.setString(2, t.getSoCCCDNT());
			pst.setDate(3, t.getNgayThue());
			pst.setDate(4, t.getNgayTraPhong());
			pst.setString(5, t.getMaNguoiThue());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(LichSuPhongThueModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from LichSuPhongThue where maNguoiThue=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiThue());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public LichSuPhongThueModel selectByID(LichSuPhongThueModel t) {
		LichSuPhongThueModel l = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from LichSuPhongThue where maNguoiThue=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiThue());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String maPhong = rs.getString("maPhong");
				String soCCCDNT = rs.getString("soCCCDNT");
				Date ngayThue = rs.getDate("ngayThue");
				Date ngayTraPhong = rs.getDate("ngayTraPhong");

				l = new LichSuPhongThueModel(maNguoiThue, maPhong, soCCCDNT, ngayThue, ngayTraPhong);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}

	@Override
	public ArrayList<LichSuPhongThueModel> selectAll() {
		ArrayList<LichSuPhongThueModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from LichSuPhongThue";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNguoiThue = rs.getString("maNguoiThue");
				String maPhong = rs.getString("maPhong");
				String soCCCDNT = rs.getString("soCCCDNT");
				Date ngayThue = rs.getDate("ngayThue");
				Date ngayTraPhong = rs.getDate("ngayTraPhong");
				LichSuPhongThueModel l = new LichSuPhongThueModel(maNguoiThue, maPhong, soCCCDNT, ngayThue, ngayTraPhong);
				list.add(l);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<LichSuPhongThueModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<LichSuPhongThueModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
