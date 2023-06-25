package dao_helper;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.DAOInterface;
import lib.JDBCHelper;
import model.NhanVienModel;

public class NhanVienDAOHelper implements DAOInterface<NhanVienModel> {
	private final String insert_SQL = "insert into NhanVien (maNV, matKhau, hoTen, vaiTro) values" + "(?, ?, ?, ?)";
	private final String update_SQL = "update NhanVien " + "set matKhau=?, hoTen=?, vaiTro=? " + "where maNV=?";
	private final String delete_SQL = "delete from NhanVien where maNV=?";
	private final String select_ById = "select * from NhanVien where maNV=?";
	private final String select_All = "select * from NhanVien";

	public static NhanVienDAOHelper getInstance() {
		return new NhanVienDAOHelper();
	}

	@Override
	public int insert(NhanVienModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(insert_SQL, t.getMaNV(), t.getPassWord(), t.getName(), t.isRole());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(NhanVienModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(update_SQL, t.getPassWord(), t.getName(), t.isRole(), t.getMaNV());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(NhanVienModel t) {
		int result = 0;
		try {
			result = JDBCHelper.update(delete_SQL, t.getMaNV());
			System.out.println("Đã thực thi " + result + " dòng");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public NhanVienModel selectByID(NhanVienModel t) {
		ArrayList<NhanVienModel> list = this.selectBySQL(select_ById, t.getMaNV().toString());
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
	public ArrayList<NhanVienModel> selectAll() {
		ArrayList<NhanVienModel> list = new ArrayList<>();
		try {
			list = this.selectBySQL(select_All, null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<NhanVienModel> selectBySQL(String sql, Object t) {
		ArrayList<NhanVienModel> list = new ArrayList<>();
		try {
			ResultSet rs = JDBCHelper.query(sql, t);
			while (rs.next()) {
				String maNV = rs.getString("maNV");
				String passWord = rs.getString("matKhau");
				String name = rs.getString("hoTen");
				boolean role = rs.getBoolean("vaiTro");
				NhanVienModel nv = new NhanVienModel(maNV, passWord, name, role);
				list.add(nv);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<NhanVienModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
