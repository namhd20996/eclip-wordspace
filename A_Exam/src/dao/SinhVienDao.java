package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.SinhVienModel;

public class SinhVienDao implements DAOInterface<SinhVienModel> {
	public static SinhVienDao getInstance() {
		return new SinhVienDao();
	}

	@Override
	public int insert(SinhVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into SinhVien (maSV, hoTen, email, soDT, gioiTinh, diaChi) values "
					+ "(?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			pst.setString(2, t.getHoTen());
			pst.setString(3, t.getEmail());
			pst.setString(4, t.getSoDT());
			pst.setBoolean(5, t.isGioiTinh());
			pst.setString(6, t.getDiaChi());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(SinhVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update SinhVien set hoTen=?, email=?, soDT=?, gioiTinh=?, diaChi=? where " + "maSV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getHoTen());
			pst.setString(2, t.getEmail());
			pst.setString(3, t.getSoDT());
			pst.setBoolean(4, t.isGioiTinh());
			pst.setString(5, t.getDiaChi());
			pst.setString(6, t.getMaSV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(SinhVienModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from SinhVien where maSV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public SinhVienModel selectByID(SinhVienModel t) {
		SinhVienModel sv = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from SinhVien where maSV=?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String maSV = rs.getString("maSV");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String soDT = rs.getString("soDT");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				sv = new SinhVienModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sv;
	}

	@Override
	public ArrayList<SinhVienModel> selectAll() {
		ArrayList<SinhVienModel> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from SinhVien";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maSV = rs.getString("maSV");
				String hoTen = rs.getString("hoTen");
				String email = rs.getString("email");
				String soDT = rs.getString("soDT");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				SinhVienModel sv = new SinhVienModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
				list.add(sv);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<SinhVienModel> selectBySQL(String sql, Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<SinhVienModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
