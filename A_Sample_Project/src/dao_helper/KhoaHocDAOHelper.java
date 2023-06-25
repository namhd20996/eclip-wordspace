package dao_helper;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DAOInterface;
import lib.JDBCHelper;
import model.KhoaHocModel;
import model.NhanVienModel;

public class KhoaHocDAOHelper implements DAOInterface<KhoaHocModel> {
	private final String insert_SQL = "insert into KhoaHoc (maKhoaHoc, maChuyenDe, hocPhi, thoiLuong, ngayKhaiGiang, ghiChu, maNV, ngayTao) values "
			+ "(?, ?, ?, ?, ?, ?, ?, ?)";
	private final String update_SQL = "update KhoaHoc "
			+ "set maChuyenDe=?, hocPhi=?, thoiLuong=?, ngayKhaiGiang=?, ghiChu=?, maNV=?, ngayTao=? "
			+ "where maKhoaHoc=?";
	private final String delete_SQL = "delete from KhoaHoc where maKhoaHoc=?";
	private final String select_ById = "select * from KhoaHoc where maKhoaHoc=?";
	private final String select_All = "select * from KhoaHoc";

	public static KhoaHocDAOHelper getInstance() {
		return new KhoaHocDAOHelper();
	}

	@Override
	public int insert(KhoaHocModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(insert_SQL, t.getMaKhoaHoc(), t.getMaChuyenDe(), t.getHocPhi(), t.getThoiLuong(),
					t.getNgayKhaiGiang(), t.getGhiChu(), t.getMaNV(), t.getNgayTao());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(KhoaHocModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(update_SQL, t.getMaChuyenDe(), t.getHocPhi(), t.getThoiLuong(),
					t.getNgayKhaiGiang(), t.getGhiChu(), t.getMaNV(), t.getNgayTao(), t.getMaKhoaHoc());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(KhoaHocModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(delete_SQL, t.getMaKhoaHoc());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public KhoaHocModel selectByID(KhoaHocModel t) {
		ArrayList<KhoaHocModel> list = this.selectBySQL(select_ById, t.getMaKhoaHoc());
		try {
			if (list.isEmpty()) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list.get(0);
	}

	@Override
	public ArrayList<KhoaHocModel> selectAll() {
		ArrayList<KhoaHocModel> list = new ArrayList<>();
		try {
			list = this.selectBySQL(select_All, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<KhoaHocModel> selectBySQL(String sql, Object t) {
		ArrayList<KhoaHocModel> list = new ArrayList<>();
		try {
			ResultSet rs = JDBCHelper.query(sql, t);
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
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<KhoaHocModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
