package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.TaiSanModel;

public class TaiSanDao implements DAOInterface<TaiSanModel> {
	public static TaiSanDao getInstance() {
		return new TaiSanDao();
	}

	@Override
	public int insert(TaiSanModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into TaiSan (maTaiSan, tenTaiSan, giaTien, ghiChu) values " + "(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTaiSan());
			pst.setString(2, t.getTenTaiSan());
			pst.setDouble(3, t.getGiaTien());
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
	public int update(TaiSanModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update TaiSan set tenTaiSan=?,  giaTien=?, ghiChu=? where maTaiSan=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenTaiSan());
			pst.setDouble(2, t.getGiaTien());
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
	public int delete(TaiSanModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from TaiSan where maTaiSan=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTaiSan());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public TaiSanModel selectByID(TaiSanModel t) {
		TaiSanModel ts = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from TaiSan where maTaiSan=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaTaiSan());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maTaiSan = rs.getString("maTaiSan");
				String tenTaiSan = rs.getString("tenTaiSan");
				double giaTien = rs.getDouble("giaTien");
				String ghiChu = rs.getString("ghiChu");
				ts = new TaiSanModel(maTaiSan, tenTaiSan, giaTien, ghiChu);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ts;
	}

	@Override
	public ArrayList<TaiSanModel> selectAll() {
		ArrayList<TaiSanModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from TaiSan";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maTaiSan = rs.getString("maTaiSan");
				String tenTaiSan = rs.getString("tenTaiSan");
				double giaTien = rs.getDouble("giaTien");
				String ghiChu = rs.getString("ghiChu");
				TaiSanModel ts = new TaiSanModel(maTaiSan, tenTaiSan, giaTien, ghiChu);
				list.add(ts);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<TaiSanModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TaiSanModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
