package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDao implements DAOInterface<Sach> {

	public static SachDao getInstane() {
		return new SachDao();
	}

	@Override
	public int insert(Sach t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2 tạo đối tượng
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "INSERT INTO sach (`id`, `tenSach`, `giaBan`, `namXuatBan`) VALUES\r\n" + "('" + t.getId()
					+ "', '" + t.getTenSach() + "', " + t.getGiaBan() + ", " + t.getNamXuatBan() + ")";
			result = st.executeUpdate(sql);
			// Bước 4 xử lý kết quả
			System.out.println("Bạn đã thực thi SQL" + sql);
			System.out.println("Số dòng bị thay đổi: " + result);
			// Bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Sach t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2 tạo đối tượng
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "UPDATE sach" + " SET " + "tenSach='" + t.getTenSach() + "', giaBan=" + t.getGiaBan()
					+ ", namXuatBan=" + t.getNamXuatBan() + " WHERE id = '" + t.getId() + "'";
			System.out.println(sql);
			result = st.executeUpdate(sql);
			// Bước 4 xử lý kết quả
			System.out.println("Bạn đã thực thi SQL" + sql);
			System.out.println("Số dòng bị thay đổi: " + result);
			// Bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Sach t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2 tạo đối tượng
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "DELETE FROM sach" 
					+ " WHERE id= '"+ t.getId() + "'" ;
			System.out.println(sql);
			result = st.executeUpdate(sql);
			// Bước 4 xử lý kết quả
			System.out.println("Bạn đã thực thi SQL" + sql);
			System.out.println("Số dòng bị thay đổi: " + result);
			// Bước 5 ngắt kết nối
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> result = new ArrayList<Sach>();
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM sach";
			ResultSet rs = st.executeQuery(sql);
			// nex trong Result nó lấy các row tiếp theo
			while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				result.add(sach);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public Sach selectByID(Sach t) {
		Sach result = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM sach WHERE id = \"" + t.getId() + "\"";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				result = new Sach(id, tenSach, giaBan, namXuatBan);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> result = new ArrayList<Sach>();
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "SELECT * FROM sach WHERE " + condition;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");
				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				result.add(sach);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

}
