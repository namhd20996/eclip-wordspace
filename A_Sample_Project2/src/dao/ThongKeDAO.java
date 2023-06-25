package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import lib.XDate;

public class ThongKeDAO{
	
	public static ThongKeDAO getInstance() {
		return new ThongKeDAO();
	}
	
	public List<Object[]> getLuongNguoiHoc() {
		List<Object[]> list = new ArrayList<>();
		String[] cols = { "Năm", "Số lượng", "Ngày đăng ký đầu tiên", "Ngày đăng ký cuối cùng" };
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "{CALL sp_LuongNguoiHoc}";
			CallableStatement cst = connection.prepareCall(sql);
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

	public List<Object[]> getDoanhThu(int year) {
		List<Object[]> list = new ArrayList<>();
		String[] cols = { "tenChuyenDe", "Số khóa học", "Số học viện", "Doanh thu", "Học phí thấp nhất",
				"Học phí cao nhất", "Học phí AVG" };
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "{Call sp_DoanhThu(?)}";
			CallableStatement cst = connection.prepareCall(sql);
			cst.setInt(1, year);
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
			e.printStackTrace();
		}

		return list;
	}

	public List<Object[]> getDiemChuyenDe() {
		List<Object[]> list = new ArrayList<>();
		String[] cols = { "tenChuyenDe", "Số lượng học viên", "Điểm thấp nhất", "Điểm cao nhất", "Điểm trung bình" };
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "{CALL sp_DiemChuyenDe}";
			CallableStatement cst = connection.prepareCall(sql);
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
	
	public void getLuongNguoiHocTest() {
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "{CALL sp_LuongNguoiHoc}";
			CallableStatement cst = connection.prepareCall(sql);
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
//				Datee nam = rs.getDate("Năm");
				int nam = rs.getInt("Năm");
//				System.out.println(nam);
				int soLuong = rs.getInt("Số lượng");
				Date ngayDangKyF = rs.getDate("Ngày đăng ký đầu tiên");
				Date ngayDangKyL = rs.getDate("Ngày đăng ký cuối cùng");
//				System.out.println(DataHelper.dateString(ngayDangKyL));
				System.out.println(nam + " " + soLuong + " " + XDate.dateString(ngayDangKyL) + " "
						+ XDate.dateString(ngayDangKyL));
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
