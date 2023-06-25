package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import lib.XDate;
import model.KhoaHocModel;

public class KhoaHocDAO implements DAOInterface<KhoaHocModel> {

	public static KhoaHocDAO getInstance() {
		return new KhoaHocDAO();
	}

	@Override
	public int insert(KhoaHocModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into KhoaHoc (maChuyenDe, hocPhi, thoiLuong, ngayKhaiGiang, ghiChu, maNV, ngayTao) values "
					+ "(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenDe());
			pst.setDouble(2, t.getHocPhi());
			pst.setInt(3, t.getThoiLuong());
			pst.setDate(4, t.getNgayKhaiGiang());
			pst.setString(5, t.getGhiChu());
			pst.setString(6, t.getMaNV());
			pst.setDate(7, t.getNgayTao());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(KhoaHocModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update KhoaHoc "
					+ "set maChuyenDe=?, hocPhi=?, thoiLuong=?, ngayKhaiGiang=?, ghiChu=?, maNV=?, ngayTao=? "
					+ "where maKhoaHoc=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenDe());
			pst.setDouble(2, t.getHocPhi());
			pst.setInt(3, t.getThoiLuong());
			pst.setDate(4, t.getNgayKhaiGiang());
			pst.setString(5, t.getGhiChu());
			pst.setString(6, t.getMaNV());
			pst.setDate(7, t.getNgayTao());
			pst.setInt(8, t.getMaKhoaHoc());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(KhoaHocModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from KhoaHoc where maKhoaHoc=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaKhoaHoc());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public KhoaHocModel selectByID(KhoaHocModel t) {
		KhoaHocModel kh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from KhoaHoc where maKhoaHoc = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, t.getMaKhoaHoc());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int maKhoaHoc = rs.getInt("maKhoaHoc");
				String maChuyenDe = rs.getString("maChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				Date ngayKhaiGiang = rs.getDate("ngayKhaiGiang");
				String ghiChu = rs.getString("ghiChu");
				String maNV = rs.getString("maNV");
				Date ngayTao = rs.getDate("ngayTao");
				kh = new KhoaHocModel(maKhoaHoc, maChuyenDe, hocPhi, thoiLuong, ngayKhaiGiang, ghiChu, maNV, ngayTao);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return kh;
	}

	public ArrayList<KhoaHocModel> selectByMaChuyenDe(KhoaHocModel t) {
		ArrayList<KhoaHocModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from KhoaHoc where maChuyenDe = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaChuyenDe());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int maKhoaHoc = rs.getInt("maKhoaHoc");
				String maChuyenDe = rs.getString("maChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				Date ngayKhaiGiang = rs.getDate("ngayKhaiGiang");
				String ghiChu = rs.getString("ghiChu");
				String maNV = rs.getString("maNV");
				Date ngayTao = rs.getDate("ngayTao");
				KhoaHocModel kh = new KhoaHocModel(maKhoaHoc, maChuyenDe, hocPhi, thoiLuong, ngayKhaiGiang, ghiChu,
						maNV, ngayTao);
				list.add(kh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<KhoaHocModel> selectAll() {
		ArrayList<KhoaHocModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from KhoaHoc";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int maKhoaHoc = rs.getInt("maKhoaHoc");
				String maChuyenDe = rs.getString("maChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				Date ngayKhaiGiang = rs.getDate("ngayKhaiGiang");
				String ghiChu = rs.getString("ghiChu");
				String maNV = rs.getString("maNV");
				Date ngayTao = rs.getDate("ngayTao");
//				System.out.println(DataHelper.dateString(ngayTao));
				KhoaHocModel kh = new KhoaHocModel(maKhoaHoc, maChuyenDe, hocPhi, thoiLuong, ngayKhaiGiang, ghiChu,
						maNV, ngayTao);
				list.add(kh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<KhoaHocModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhoaHocModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Object[]> getBangDiem(int maKhoaHoc) {
		List<Object[]> list = new ArrayList<>();
		String[] cols = { "maNguoiHoc", "nameNH", "diem" };
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "{Call sp_BangDiem(?)}";
			CallableStatement cst = connection.prepareCall(sql);
			cst.setInt(1, maKhoaHoc);
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				Object[] vals = new Object[cols.length];
				for (int i = 0; i < cols.length; i++) {
					vals[i] = rs.getObject(cols[i]);
				}
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Object[]> selectByTotal() {
		List<Object[]> list = new ArrayList<>();
		String cols[] = { "maKhoahoc", "maChuyenDe", "thoiLuong", "hocPhi", "ngayKhaiGiang", "ghiChu", "maNV",
				"ngayTao" };
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select maKhoaHoc, cd.maChuyenDe, cd.thoiLuong, cd.hocPhi, ngayKhaiGiang, ghiChu,maNV, ngayTao from KhoaHoc as kh\r\n"
					+ "inner join ChuyenDe as cd  on kh.maChuyenDe = cd.maChuyenDe";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Object[] vals = new Object[cols.length];
				for (int i = 0; i < cols.length; i++) {
					vals[i] = rs.getObject(cols[i]);
				}
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Integer> getYearKH() {
		ArrayList<Integer> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select distinct year(ngayKhaiGiang) as N'namKhaiGiang' from KhoaHoc order by N'namKhaiGiang' desc";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int namKhaiGiang = rs.getInt("namKhaiGiang");
				list.add(namKhaiGiang);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
