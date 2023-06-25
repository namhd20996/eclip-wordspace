package dao_helper;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DAOInterface;
import lib.JDBCHelper;
import model.NguoiHocModel;

public class NguoiHocDAOHelper implements DAOInterface<NguoiHocModel> {
	private final String insert_SQL = "insert into NguoiHoc (maNguoiHoc, nameNH, ngaySinh, gioiTinh, dienThoai, email, ghiChu, maNV, ngayDangKy) values"
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String update_SQL = "update NguoiHoc "
			+ "set nameNH=?, ngaySinh=?, gioiTinh=?, dienThoai=?, email=?, ghiChu=?, maNV=?, ngayDangKy=? "
			+ "where maNguoiHoc=?";
	private final String delete_SQL = "delete from NguoiHoc where maNguoiHoc=?";
	private final String select_ById = "select * from NguoiHoc where maNguoiHoc=?";
	private final String select_All = "select * from NguoiHoc";

	public static NguoiHocDAOHelper getInstance() {
		return new NguoiHocDAOHelper();
	}

	@Override
	public int insert(NguoiHocModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(insert_SQL, t.getTenNguoiHoc(), t.getNgaySinh(),
					t.isGioiTinh(), t.getDienThoai(), t.getEmail(), t.getGhiChu(), t.getMaNV(), t.getNgayDangKy(), t.getMaNguoiHoc());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(NguoiHocModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(update_SQL, t.getTenNguoiHoc(), t.getNgaySinh(),
					t.isGioiTinh(), t.getDienThoai(), t.getEmail(), t.getGhiChu(), t.getMaNV(), t.getNgayDangKy(),t.getMaNguoiHoc());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(NguoiHocModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(delete_SQL, t.getMaNguoiHoc());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public NguoiHocModel selectByID(NguoiHocModel t) {
		ArrayList<NguoiHocModel> list = this.selectBySQL(select_ById, t.getMaNguoiHoc());
		try {
			if (list.isEmpty()) {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list.get(0);
	}

	@Override
	public ArrayList<NguoiHocModel> selectAll() {
		ArrayList<NguoiHocModel> list = new ArrayList<>();
		try {
			list = this.selectBySQL(select_All, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<NguoiHocModel> selectBySQL(String sql, Object t) {
		ArrayList<NguoiHocModel> list = new ArrayList<>();
		try {
			ResultSet rs = JDBCHelper.query(sql, t);
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<NguoiHocModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
