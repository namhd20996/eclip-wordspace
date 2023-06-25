package dao_helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;
import lib.JDBCHelper;

public class ThongKeDAOHelper {

	public static ThongKeDAOHelper getInstance() {
		return new ThongKeDAOHelper();
	}

	private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
		List<Object[]> list = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			list = new ArrayList<>();
			ResultSet rs = JDBCHelper.query(sql, args);
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

	public List<Object[]> getBangDiem(Integer maKhoaHoc) {
		String sql = "{CALL sp_BangDiem(?)}";
		String[] cols = { "maNguoiHoc", "nameNH", "diem" };
		return getListOfArray(sql, cols, maKhoaHoc);
	}

	public List<Object[]> getLuongNguoiHoc() {
		String sql = "{CALL sp_LuongNguoiHoc}";
		String[] cols = { "Năm", "Số lượng", "Ngày đăng ký đầu tiên", "Ngày đăng ký cuối cùng" };
		return getListOfArray(sql, cols);
	}

	public List<Object[]> getDiemChuyenDe() {
		String sql = "{CALL sp_DiemChuyenDe}";
		String[] cols = { "tenChuyenDe", "Số lượng học viên", "Điểm thấp nhất", "Điểm cao nhất", "Điểm trung bình" };
		return getListOfArray(sql, cols);
	}

	public List<Object[]> getDoanhThu(Integer nam) {
		String sql = "{CALL sp_DoanhThu(?)}";
		String[] cols = { "tenChuyenDe", "Số khóa học", "Số học viện", "Doanh thu", "Học phí thấp nhất",
				"Học phí cao nhất", "Học phí AVG" };
		return getListOfArray(sql, cols, nam);
	}
}
