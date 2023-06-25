package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietDichVuModel;

public class ChiTietDichVuDao implements DAOInterface<ChiTietDichVuModel> {
	public static ChiTietDichVuDao getInstance() {
		return new ChiTietDichVuDao();
	}

	@Override
	public int insert(ChiTietDichVuModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into ChiTietDichVu (maPhong, maDichVu, ghiChu) values " + "(?, ? ,?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			pst.setString(2, t.getMaDichVu());
			pst.setString(3, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(ChiTietDichVuModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update ChiTietDichVu set maDichVu=?, ghiChu=? where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaDichVu());
			pst.setString(2, t.getGhiChu());
			pst.setString(3, t.getMaPhong());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(ChiTietDichVuModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from ChiTietDichVu where maPhong=?";
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
	public ChiTietDichVuModel selectByID(ChiTietDichVuModel t) {
		ChiTietDichVuModel ct = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChiTietDichVu where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String maDichVu = rs.getString("maDichVu");
				String ghiChu = rs.getString("ghiChu");
				ct = new ChiTietDichVuModel(maPhong, maDichVu, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ct;
	}
	
	public ChiTietDichVuModel selectByMaDichVu(ChiTietDichVuModel t) {
		ChiTietDichVuModel ct = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChiTietDichVu where maDichVu=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaDichVu());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String maDichVu = rs.getString("maDichVu");
				String ghiChu = rs.getString("ghiChu");
				ct = new ChiTietDichVuModel(maPhong, maDichVu, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ct;
	}

	public ArrayList<ChiTietDichVuModel> selectByMaPhongAll(ChiTietDichVuModel t) {
		ArrayList<ChiTietDichVuModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChiTietDichVu where maPhong=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String maDichVu = rs.getString("maDichVu");
				String ghiChu = rs.getString("ghiChu");
				ChiTietDichVuModel ct = new ChiTietDichVuModel(maPhong, maDichVu, ghiChu);
				list.add(ct);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public ChiTietDichVuModel selectByMaPhongAndMaDichVu(ChiTietDichVuModel t) {
		ChiTietDichVuModel ct = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChiTietDichVu where maPhong=? and maDichVu=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			pst.setString(2, t.getMaDichVu());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String maDichVu = rs.getString("maDichVu");
				String ghiChu = rs.getString("ghiChu");
				ct = new ChiTietDichVuModel(maPhong, maDichVu, ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ct;
	}

	@Override
	public ArrayList<ChiTietDichVuModel> selectAll() {
		ArrayList<ChiTietDichVuModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChiTietDichVu";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String maDichVu = rs.getString("maDichVu");
				String ghiChu = rs.getString("ghiChu");
				ChiTietDichVuModel ct = new ChiTietDichVuModel(maPhong, maDichVu, ghiChu);
				list.add(ct);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public ArrayList<ChiTietDichVuModel> selectByKeyWordMaPhong(ChiTietDichVuModel t) {
		ArrayList<ChiTietDichVuModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from ChiTietDichVu where maPhong like ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + t.getMaPhong() + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
				String maDichVu = rs.getString("maDichVu");
				String ghiChu = rs.getString("ghiChu");
				ChiTietDichVuModel ct = new ChiTietDichVuModel(maPhong, maDichVu, ghiChu);
				list.add(ct);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Object[]> selectByStoreProc(ChiTietDichVuModel t) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select ctdv.maPhong,sum( dv.giaDichVu) as 'sumDichVu' from ChiTietDichVu ctdv\r\n"
					+ "inner join DichVu dv\r\n"
					+ "on ctdv.maDichVu = dv.maDichVu\r\n"
					+ "where maPhong = ?\r\n"
					+ "group by dv.giaDichVu, ctdv.maPhong";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhong = rs.getString("maPhong");
//				String maDichVu = rs.getString("maDichVu");
//				String ghiChu = rs.getString("ghiChu");
				double giaDichVu = rs.getDouble("sumDichVu");
				Object[] vals = { maPhong, giaDichVu };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<ChiTietDichVuModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ChiTietDichVuModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static void main(String[] args) {
		ChiTietDichVuModel c = new ChiTietDichVuModel();
		c.setMaPhong("A2");
		List<Object[]> list = ChiTietDichVuDao.getInstance().selectByStoreProc(c);
		for (Object[] objects : list) {
			System.out.println(objects[1]);
		}
	}
}
