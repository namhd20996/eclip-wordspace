package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.PhieuChiModel;

public class PhieuChiDao implements DAOInterface<PhieuChiModel> {
	public static PhieuChiDao getInstance() {
		return new PhieuChiDao();
	}

	@Override
	public int insert(PhieuChiModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into PhieuChi (maPhieuChi, maPhong, maNhanVien, tenPhieuChi, tongTien, ngayLap, hinhThuc, ghiChu) values "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuChi());
			pst.setString(2, t.getMaPhong());
			pst.setString(3, t.getMaNhanVien());
			pst.setString(4, t.getTenPhieuChi());
			pst.setDouble(5, t.getTongTien());
			pst.setDate(6, t.getNgayLap());
			pst.setString(7, t.getHinhThuc());
			pst.setString(8, t.getGhiChu());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(PhieuChiModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update PhieuChi set maPhong=?, maNhanVien=?, tenPhieuChi=?, tongTien=?, ngayLap=?, hinhThuc=?, ghiChu=? "
					+ "where maPhieuChi=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhong());
			pst.setString(2, t.getMaNhanVien());
			pst.setString(3, t.getTenPhieuChi());
			pst.setDouble(4, t.getTongTien());
			pst.setDate(5, t.getNgayLap());
			pst.setString(6, t.getHinhThuc());
			pst.setString(7, t.getGhiChu());
			pst.setString(8, t.getMaPhieuChi());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(PhieuChiModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from PhieuChi where maPhieuChi=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuChi());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public PhieuChiModel selectByID(PhieuChiModel t) {
		PhieuChiModel p = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from PhieuChi where maPhieuChi=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuChi());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maPhieuChi = rs.getString("maPhieuChi");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				String tenPhieuChi = rs.getString("tenPhieuChi");
				double tongTien = rs.getDouble("tongTien");
				Date ngayLap = rs.getDate("ngayLap");
				String hinhThuc = rs.getString("hinhThuc");
				String ghiChu = rs.getString("ghiChu");
				p = new PhieuChiModel(maPhieuChi, maPhong, maNhanVien, tenPhieuChi, tongTien, ngayLap, hinhThuc,
						ghiChu);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}

	@Override
	public ArrayList<PhieuChiModel> selectAll() {
		ArrayList<PhieuChiModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from PhieuChi";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maPhieuChi = rs.getString("maPhieuChi");
				String maPhong = rs.getString("maPhong");
				String maNhanVien = rs.getString("maNhanVien");
				String tenPhieuChi = rs.getString("tenPhieuChi");
				double tongTien = rs.getDouble("tongTien");
				Date ngayLap = rs.getDate("ngayLap");
				String hinhThuc = rs.getString("hinhThuc");
				String ghiChu = rs.getString("ghiChu");
				PhieuChiModel p = new PhieuChiModel(maPhieuChi, maPhong, maNhanVien, tenPhieuChi, tongTien, ngayLap,
						hinhThuc, ghiChu);
				list.add(p);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<PhieuChiModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhieuChiModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
