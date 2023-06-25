package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import model.HocVienModel;

public class HocVienDAO implements DAOInterface<HocVienModel> {

	public static HocVienDAO getInstance() {
		return new HocVienDAO();
	}

	@Override
	public int insert(HocVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into HocVien (maKhoaHoc, maNguoiHoc, diem) values " + "(?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaKhoaHoc());
			pst.setString(2, t.getMaNguoiHoc());
			pst.setDouble(3, t.getDiem());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(HocVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update HocVien " + "set maKhoaHoc=?, maNguoiHoc=?, diem=? " + "where maHocVien=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaKhoaHoc());
			pst.setString(2, t.getMaNguoiHoc());
			pst.setDouble(3, t.getDiem());
			pst.setInt(4, t.getMaHocVien());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(HocVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from HocVien where maHocVien=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaHocVien());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi xóa " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public HocVienModel selectByID(HocVienModel t) {
		HocVienModel hv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from HocVien where maHocVien=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaHocVien());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int maHocVien = rs.getInt("maHocVien");
				int maKhoaHoc = rs.getInt("maKhoaHoc");
				String maNguoiHoc = rs.getString("maNguoiHoc");
				double diem = rs.getDouble("diem");
				hv = new HocVienModel(maHocVien, maKhoaHoc, maNguoiHoc, diem);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return hv;
	}

	@Override
	public ArrayList<HocVienModel> selectAll() {
		ArrayList<HocVienModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from HocVien";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int maHocVien = rs.getInt("maHocVien");
				int maKhoaHoc = rs.getInt("maKhoaHoc");
				String maNguoiHoc = rs.getString("maNguoiHoc");
				double diem = rs.getDouble("diem");
				HocVienModel hv = new HocVienModel(maHocVien, maKhoaHoc, maNguoiHoc, diem);
				list.add(hv);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<HocVienModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HocVienModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object[]> getDanhSachNH(int maKhoaHoc) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select hv.*, nh.nameNH from HocVien hv\r\n" + "inner join NguoiHoc nh\r\n"
					+ "on nh.maNguoiHoc = hv.maNguoiHoc\r\n" + "where maKhoaHoc = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, maKhoaHoc);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int maHocVien = rs.getInt("maHocVien");
				String maNguoiHoc = rs.getString("maNguoiHoc");
				String nameNH = rs.getString("nameNH");
				double diem = rs.getDouble("diem");
				Object[] vals = { maHocVien, maNguoiHoc, nameNH, diem };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Object[]> getDanhSachNhChuaNhapDiem(int maKhoaHoc) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select hv.*, nh.nameNH from HocVien hv\r\n" + "inner join NguoiHoc nh\r\n"
					+ "on hv.maNguoiHoc = nh.maNguoiHoc\r\n" + "where maKhoaHoc = ? and diem = -1";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, maKhoaHoc);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int maHocVien = rs.getInt("maHocVien");
				String maNguoiHoc = rs.getString("maNguoiHoc");
				String nameNH = rs.getString("nameNH");
				double diem = rs.getDouble("diem");
				Object[] vals = { maHocVien, maNguoiHoc, nameNH, diem };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public List<Object[]> getDanhSachNHDaNhapDiem(int maKhoaHoc) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select hv.*, nh.nameNH from HocVien hv\r\n" + "inner join NguoiHoc nh\r\n"
					+ "on hv.maNguoiHoc = nh.maNguoiHoc\r\n" + "where maKhoaHoc = ? and diem >= 0";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, maKhoaHoc);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int maHocVien = rs.getInt("maHocVien");
				String maNguoiHoc = rs.getString("maNguoiHoc");
				String nameNH = rs.getString("nameNH");
				double diem = rs.getDouble("diem");
				Object[] vals = { maHocVien, maNguoiHoc, nameNH, diem };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
