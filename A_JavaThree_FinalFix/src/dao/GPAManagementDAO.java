package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.GradeModel;

public class GPAManagementDAO implements DAOInterface<GradeModel> {

	public static GPAManagementDAO getInstance() {
		return new GPAManagementDAO();
	}

	@Override
	public int insert(GradeModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into grade (maSV, tiengAnh, tinHoc, GDTC) values\n" + "(?, ?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			pst.setDouble(2, t.getTiengAnh());
			pst.setDouble(3, t.getTinHoc());
			pst.setDouble(4, t.getGDTC());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(GradeModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "UPDATE grade\r\n"
					+ "SET tiengAnh = ?, tinHoc = ?, GDTC = ?\r\n"
					+ "WHERE maSV = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setDouble(1, t.getTiengAnh());
			pst.setDouble(2, t.getTinHoc());
			pst.setDouble(3, t.getGDTC());
			pst.setString(4, t.getMaSV());
			result = pst.executeUpdate();
			System.out.println("Đã thực thi " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(GradeModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from grade where maSV = ?";
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
	public ArrayList<GradeModel> selectAll() {
		ArrayList<GradeModel> list = new ArrayList<GradeModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from grade";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String maSV = rs.getString("maSV");
				double tiengAnh = rs.getDouble("tiengAnh");
				double tinHoc = rs.getDouble("tinHoc");
				double GDTC = rs.getDouble("GDTC");
				GradeModel gra = new GradeModel(id, maSV, tiengAnh, tinHoc, GDTC);
				list.add(gra);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public GradeModel selectByID(GradeModel t) {
		// TODO Auto-generated method stub
		return null;
	}

	public GradeModel selectByMaSV(GradeModel t) {
		GradeModel gra = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from grade where maSV = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getMaSV());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String maSV = rs.getString("maSV");
				double tiengAnh = rs.getDouble("tiengAnh");
				double tinHoc = rs.getDouble("tinHoc");
				double GDTC = rs.getDouble("GDTC");
				return gra = new GradeModel(id, maSV, tiengAnh, tinHoc, GDTC);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return gra;
	}

	public ArrayList<GradeModel> selectTop3DESC(int limit) {
		ArrayList<GradeModel> list = new ArrayList<GradeModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT *, (tiengAnh + tinHoc + GDTC)/3 AS \"DTB\" FROM grade ORDER BY DTB DESC LIMIT "
					+ limit;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String maSV = rs.getString("maSV");
				double tiengAnh = rs.getDouble("tiengAnh");
				double tinHoc = rs.getDouble("tinHoc");
				double GDTC = rs.getDouble("GDTC");
				GradeModel gra = new GradeModel(id, maSV, tiengAnh, tinHoc, GDTC);
				list.add(gra);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public ArrayList<GradeModel> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
