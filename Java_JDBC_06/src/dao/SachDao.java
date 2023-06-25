package dao;

import java.sql.Connection;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sach selectByID(Sach t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
