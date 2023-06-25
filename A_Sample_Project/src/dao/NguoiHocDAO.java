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
import model.NguoiHocModel;

public class NguoiHocDAO implements DAOInterface<NguoiHocModel> {

	public static NguoiHocDAO getInstance() {
		return new NguoiHocDAO();
	}

	@Override
	public int insert(NguoiHocModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into NguoiHoc (maNguoiHoc, nameNH, ngaySinh, gioiTinh, dienThoai, email, ghiChu, maNV, ngayDangKy) values"
					+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiHoc());
			pst.setString(2, t.getTenNguoiHoc());
			pst.setDate(3, t.getNgaySinh());
			pst.setBoolean(4, t.isGioiTinh());
			pst.setString(5, t.getDienThoai());
			pst.setString(6, t.getEmail());
			pst.setString(7, t.getGhiChu());
			pst.setString(8, t.getMaNV());
			pst.setDate(9, t.getNgayDangKy());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(NguoiHocModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NguoiHoc "
					+ "set nameNH=?, ngaySinh=?, gioiTinh=?, dienThoai=?, email=?, ghiChu=?, maNV=?, ngayDangKy=? "
					+ "where maNguoiHoc=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenNguoiHoc());
			pst.setDate(2, t.getNgaySinh());
			pst.setBoolean(3, t.isGioiTinh());
			pst.setString(4, t.getDienThoai());
			pst.setString(5, t.getEmail());
			pst.setString(6, t.getGhiChu());
			pst.setString(7, t.getMaNV());
			pst.setDate(8, t.getNgayDangKy());
			pst.setString(9, t.getMaNguoiHoc());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(NguoiHocModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from NguoiHoc where maNguoiHoc = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiHoc());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public NguoiHocModel selectByID(NguoiHocModel t) {
		NguoiHocModel nh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiHoc where maNguoiHoc=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiHoc());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNguoiHoc = rs.getString("maNguoiHoc");
				String tenNguoiHoc = rs.getString("nameNH");
				Date ngaySinh = rs.getDate("ngaySinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String dienThoai = rs.getString("dienThoai");
				String email = rs.getString("email");
				String ghiChu = rs.getString("ghiChu");
				String maNV = rs.getString("maNV");
				Date ngayDangKy = rs.getDate("ngayDangKy");
				nh = new NguoiHocModel(maNguoiHoc, tenNguoiHoc, ngaySinh, gioiTinh, dienThoai, email, ghiChu, maNV,
						ngayDangKy);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nh;
	}

	@Override
	public ArrayList<NguoiHocModel> selectAll() {
		ArrayList<NguoiHocModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiHoc";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNguoiHoc = rs.getString("maNguoiHoc");
				String tenNguoiHoc = rs.getString("nameNH");
				Date ngaySinh = rs.getDate("ngaySinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String dienThoai = rs.getString("dienThoai");
				String email = rs.getString("email");
				String ghiChu = rs.getString("ghiChu");
				String maNV = rs.getString("maNV");
				Date ngayDangKy = rs.getDate("ngayDangKy");
				NguoiHocModel nh = new NguoiHocModel(maNguoiHoc, tenNguoiHoc, ngaySinh, gioiTinh, dienThoai, email,
						ghiChu, maNV, ngayDangKy);
				list.add(nh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<NguoiHocModel> selectByCondition(String condition) {
		ArrayList<NguoiHocModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiHoc where maNguoiHoc like ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, "%"+condition+"%");
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNguoiHoc = rs.getString("maNguoiHoc");
				String tenNguoiHoc = rs.getString("nameNH");
				Date ngaySinh = rs.getDate("ngaySinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String dienThoai = rs.getString("dienThoai");
				String email = rs.getString("email");
				String ghiChu = rs.getString("ghiChu");
				String maNV = rs.getString("maNV");
				Date ngayDangKy = rs.getDate("ngayDangKy");
				NguoiHocModel nh = new NguoiHocModel(maNguoiHoc, tenNguoiHoc, ngaySinh, gioiTinh, dienThoai, email,
						ghiChu, maNV, ngayDangKy);
				list.add(nh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<NguoiHocModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<NguoiHocModel> selectByCourse(int maKhoaHoc) {
		ArrayList<NguoiHocModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM NguoiHoc WHERE maNguoiHoc NOT IN (SELECT maNguoiHoc FROM HocVien WHERE maKhoaHoc = ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, maKhoaHoc);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNguoiHoc = rs.getString("maNguoiHoc");
				String tenNguoiHoc = rs.getString("nameNH");
				Date ngaySinh = rs.getDate("ngaySinh");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String dienThoai = rs.getString("dienThoai");
				String email = rs.getString("email");
				String ghiChu = rs.getString("ghiChu");
				Date ngayDangKy = rs.getDate("ngayDangKy");
				NguoiHocModel nh = new NguoiHocModel(maNguoiHoc, tenNguoiHoc, ngaySinh, gioiTinh, dienThoai, email,
						ghiChu, maNguoiHoc, ngayDangKy);
				list.add(nh);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public NguoiHocModel selectByTenNguoiHoc(NguoiHocModel t) {
		NguoiHocModel nh = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NguoiHoc where nameNH = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTenNguoiHoc());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNguoiHoc = rs.getString("maNguoiHoc");
				nh = new NguoiHocModel();
				nh.setMaNguoiHoc(maNguoiHoc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nh;
	}

}
