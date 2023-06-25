package dao_helper;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import dao.DAOInterface;
import lib.JDBCHelper;
import model.HocVienModel;

public class HocVienDAOHelper implements DAOInterface<HocVienModel> {
	private final String insert_SQL = "insert into HocVien (maHocVien, maKhoaHoc, maNguoiHoc, diem) values "
			+ "(?, ?, ?, ?)";
	private final String update_SQL = "update HocVien " + "set maKhoaHoc=?, maNguoiHoc=?, diem=? "
			+ "where maHocVien=?";
	private final String delete_SQL = "delete from HocVien where maHocVien=?";
	private final String select_ById = "select * from HocVien where maHocVien=?";
	private final String select_All = "select * from HocVien";

	public static HocVienDAOHelper getInstance() {
		return new HocVienDAOHelper();
	}

	@Override
	public int insert(HocVienModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(insert_SQL, t.getMaKhoaHoc(), t.getMaNguoiHoc(), t.getDiem(), t.getMaHocVien());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(HocVienModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(update_SQL, t.getMaHocVien(), t.getMaKhoaHoc(), t.getMaNguoiHoc(), t.getDiem());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(HocVienModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(delete_SQL, t.getMaHocVien());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public HocVienModel selectByID(HocVienModel t) {
		ArrayList<HocVienModel> list = this.selectBySQL(select_ById, t.getMaHocVien());
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public ArrayList<HocVienModel> selectAll() {
		ArrayList<HocVienModel> list = this.selectBySQL(select_All, null);
		return list;
	}

	@Override
	public ArrayList<HocVienModel> selectBySQL(String sql, Object t) {
		ArrayList<HocVienModel> list = new ArrayList<>();
		try {
			ResultSet rs = JDBCHelper.query(sql, t);
			while (rs.next()) {
				int maHocVien = rs.getInt("maHocVien");
				int maKhoaHoc = rs.getInt("maKhoaHoc");
				String maNguoiHoc = rs.getString("maNguoiHoc");
				double diem = rs.getDouble("diem");
				HocVienModel hv = new HocVienModel(maHocVien, maKhoaHoc, maNguoiHoc, diem);
				list.add(hv);
			}
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

}
