package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.NhanVienModel;

public class NhanVienDAO implements DAOInterface<NhanVienModel> {

	public static NhanVienDAO getInstance() {
		return new NhanVienDAO();
	}

	@Override
	public int insert(NhanVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into NhanVien (maNV, matKhau, hoTen, vaiTro) values" + "(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			pst.setString(2, t.getPassWord());
			pst.setString(3, t.getName());
			pst.setBoolean(4, t.isRole());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(NhanVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update NhanVien " + "set matKhau=?, hoTen=?, vaiTro=? " + "where maNV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getPassWord());
			pst.setString(2, t.getName());
			pst.setBoolean(3, t.isRole());
			pst.setString(4, t.getMaNV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(NhanVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from NhanVien where maNV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public NhanVienModel selectByID(NhanVienModel t) {
		NhanVienModel nv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien where maNV = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNV = rs.getString("maNV");
				String passWord = rs.getString("matKhau");
				String name = rs.getString("hoTen");
				boolean role = rs.getBoolean("vaiTro");
				nv = new NhanVienModel(maNV, passWord, name, role);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}

	@Override
	public ArrayList<NhanVienModel> selectAll() {
		ArrayList<NhanVienModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString("maNV");
				String passWord = rs.getString("matKhau");
				String name = rs.getString("hoTen");
				boolean role = rs.getBoolean("vaiTro");
				NhanVienModel nv = new NhanVienModel(maNV, passWord, name, role);
				list.add(nv);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public NhanVienModel selectByUandP(NhanVienModel t) {
		NhanVienModel nv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from NhanVien where maNV=? and matKhau=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaNV());
			pst.setString(2, t.getPassWord());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maNV = rs.getString("maNV");
				String passWord = rs.getString("matKhau");
				String name = rs.getString("hoTen");
				boolean role = rs.getBoolean("vaiTro");
				nv = new NhanVienModel(maNV, passWord, name, role);

			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nv;
	}

	@Override
	public ArrayList<NhanVienModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NhanVienModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

}
