package dao_helper;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DAOInterface;
import lib.JDBCHelper;
import model.ChuyenDeModel;

public class ChuyenDeDAOHelper implements DAOInterface<ChuyenDeModel> {
	private final String insert_SQL = "insert into ChuyenDe (maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa) values "
			+ "(?, ?, ?, ?, ?, ?)";
	private final String update_SQL = "update ChuyenDe "
			+ "set tenChuyenDe=?, hocPhi=?, thoiLuong=?, hinhLogo=?, moTa=? " + "where maChuyenDe=?";
	private final String delete_SQL = "delete from ChuyenDe where maChuyenDe=?";
	private final String select_ById = "select * from ChuyenDe where maChuyenDe=?";
	private final String select_All = "select * from ChuyenDe";

	public static ChuyenDeDAOHelper getInstance() {
		return new ChuyenDeDAOHelper();
	}

	@Override
	public int insert(ChuyenDeModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(insert_SQL, t.getMaChuyenDe(), t.getTenChuyenDe(), t.getHocPhi(),
					t.getThoiLuong(), t.getHinhLogo(), t.getMoTa());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(ChuyenDeModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(update_SQL, t.getTenChuyenDe(), t.getHocPhi(), t.getThoiLuong(), t.getHinhLogo(),
					t.getMoTa(), t.getMaChuyenDe());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(ChuyenDeModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(delete_SQL, t.getMaChuyenDe());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ChuyenDeModel selectByID(ChuyenDeModel t) {
		ArrayList<ChuyenDeModel> list = this.selectBySQL(select_ById, t.getMaChuyenDe().toString());
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
	public ArrayList<ChuyenDeModel> selectAll() {
		ArrayList<ChuyenDeModel> list = new ArrayList<>();
		try {
			list = this.selectBySQL(select_All, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<ChuyenDeModel> selectBySQL(String sql, Object t) {
		ArrayList<ChuyenDeModel> list = new ArrayList<>();
		try {
			ResultSet rs = JDBCHelper.query(sql, t);
			while (rs.next()) {
				String maChuyenDe = rs.getString("maChuyenDe");
				String tenChuyenDe = rs.getString("tenChuyenDe");
				double hocPhi = rs.getDouble("hocPhi");
				int thoiLuong = rs.getInt("thoiLuong");
				String hinhLogo = rs.getString("hinhLogo");
				String moTa = rs.getString("moTa");
				ChuyenDeModel cd = new ChuyenDeModel(maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa);
				list.add(cd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<ChuyenDeModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
