package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DichVuModel;

public class DichVuDao implements DAOInterface<DichVuModel> {
	public static DichVuDao getInstance() {
		return new DichVuDao();
	}

	@Override
	public int insert(DichVuModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into DichVu (maDichVu, maNhanVien, tenDichVu, giaDichVu, ghiChu) values "
					+ "(?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaDichVu());
			pst.setString(2, t.getMaNhanVien());
			pst.setString(3, t.getTenDichVu());
			pst.setDouble(4, t.getGiaDichVu());
			pst.setString(5, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(DichVuModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update DichVu set maNhanVien=?, tenDichVu=?, giaDichVu=?, ghiChu=? " + "where maDichVu=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNhanVien());
			pst.setString(2, t.getTenDichVu());
			pst.setDouble(3, t.getGiaDichVu());
			pst.setString(4, t.getGhiChu());
			pst.setString(5, t.getMaDichVu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(DichVuModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from DichVu where maDichVu=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaDichVu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public DichVuModel selectByID(DichVuModel t) {
		DichVuModel d = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from DichVu where maDichVu=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaDichVu());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maDichVu = rs.getString("maDichVu");
				String maNhanVien = rs.getString("maNhanVien");
				String tenDichVu = rs.getString("tenDichVu");
				double giaDichVu = rs.getDouble("giaDichVu");
				String ghiChu = rs.getString("ghiChu");
				d = new DichVuModel(maDichVu, maNhanVien, tenDichVu, giaDichVu, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return d;
	}

	public ArrayList<DichVuModel> selectByKeyWord(DichVuModel t) {
		ArrayList<DichVuModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from DichVu where maDichVu like ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + t.getMaDichVu() + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maDichVu = rs.getString("maDichVu");
				String maNhanVien = rs.getString("maNhanVien");
				String tenDichVu = rs.getString("tenDichVu");
				double giaDichVu = rs.getDouble("giaDichVu");
				String ghiChu = rs.getString("ghiChu");
				DichVuModel d = new DichVuModel(maDichVu, maNhanVien, tenDichVu, giaDichVu, ghiChu);
				list.add(d);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public ArrayList<DichVuModel> selectByNameDV(String t) {
		ArrayList<DichVuModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from DichVu where tenDichVu like ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + t + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maDichVu = rs.getString("maDichVu");
				String maNhanVien = rs.getString("maNhanVien");
				String tenDichVu = rs.getString("tenDichVu");
				double giaDichVu = rs.getDouble("giaDichVu");
				String ghiChu = rs.getString("ghiChu");
				DichVuModel d = new DichVuModel(maDichVu, maNhanVien, tenDichVu, giaDichVu, ghiChu);
				list.add(d);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public static void main(String[] args) {
		ArrayList<DichVuModel> list = DichVuDao.getInstance().selectByNameDV("Dien");
		for (DichVuModel a : list) {
System.out.println(a);
		}
	}

	@Override
	public ArrayList<DichVuModel> selectAll() {
		ArrayList<DichVuModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from DichVu";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maDichVu = rs.getString("maDichVu");
				String maNhanVien = rs.getString("maNhanVien");
				String tenDichVu = rs.getString("tenDichVu");
				double giaDichVu = rs.getDouble("giaDichVu");
				String ghiChu = rs.getString("ghiChu");
				DichVuModel d = new DichVuModel(maDichVu, maNhanVien, tenDichVu, giaDichVu, ghiChu);
				list.add(d);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<DichVuModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DichVuModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
