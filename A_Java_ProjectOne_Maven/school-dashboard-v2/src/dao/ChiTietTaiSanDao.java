package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ChiTietTaiSan;

public class ChiTietTaiSanDao implements DAOInterface<ChiTietTaiSan> {

	public static ChiTietTaiSanDao getInstance() {
		return new ChiTietTaiSanDao();
	}

	@Override
	public int insert(ChiTietTaiSan t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into ChiTietTaiSan(maTaiSan, maPhong, soLuong, ghiChu) values (?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTaiSan());
			pst.setString(2, t.getMaPhong());
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
	public int update(ChiTietTaiSan t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update ChiTietTaiSan " + "set maPhong=?, soLuong=?, ghiChu=? where maTaiSan=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			pst.setInt(2, t.getSoLuong());
			pst.setString(3, t.getGhiChu());
			pst.setString(4, t.getMaTaiSan());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(ChiTietTaiSan t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from ChiTietTaiSan where maTaiSan=? and maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTaiSan());
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
	public ChiTietTaiSan selectByID(ChiTietTaiSan t) {
		ChiTietTaiSan ctts = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChiTietTaiSan where maTaiSan=? and maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTaiSan());
			pst.setString(2, t.getMaPhong());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maTaiSan = rs.getString("maTaiSan");
				String maPhong = rs.getString("maPhong");
				String ghiChu = rs.getString("ghiChu");
				int soLuong = rs.getInt("soLuong");
				ctts = new ChiTietTaiSan(maPhong, maTaiSan, ghiChu, soLuong);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ctts;
	}

	@Override
	public ArrayList<ChiTietTaiSan> selectAll() {
		ArrayList<ChiTietTaiSan> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChiTietTaiSan";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTaiSan = rs.getString("maTaiSan");
				String maPhong = rs.getString("maPhong");
				String ghiChu = rs.getString("ghiChu");
				int soLuong = rs.getInt("soLuong");
				ChiTietTaiSan ctts = new ChiTietTaiSan(maPhong, maTaiSan, ghiChu, soLuong);
				list.add(ctts);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<ChiTietTaiSan> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChiTietTaiSan> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		ChiTietTaiSan ct = new ChiTietTaiSan(null, null, null, 0);
	}

}
