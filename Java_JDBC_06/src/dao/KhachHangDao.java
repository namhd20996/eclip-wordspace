package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;

public class KhachHangDao implements DAOInterface<KhachHang> {

	public static KhachHangDao getInstane() {
		return new KhachHangDao();
	}

	@Override
	public int insert(KhachHang t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2 tạo đối tượng
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "INSERT INTO khachhang (`id`, `hoVaTen`, `ngaySinh`, `diaChi`) VALUES \r\n" + "(\"" + t.getId()
					+ "\", \"" + t.getHoVaTen() + "\", \"" + t.getNgaySinh() + "\", \"" + t.getDiaChi() + "\")";
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
	public int update(KhachHang t) {
		int check = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			Statement st = connection.createStatement();
			String sql = "UPDATE khachhang\r\n" + "SET hoVaTen =" + "\"" + t.getHoVaTen() + "\", " + "\r\n"
					+ "ngaySinh =" + "\"" + t.getNgaySinh() + "\", " + "\r\n" + "diaChi = " + "\"" + t.getDiaChi()
					+ "\"" + "\r\n" + "WHERE id =" + "\"" + t.getId() + "\"";
			check = st.executeUpdate(sql);
			System.out.println(check);
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public int delete(KhachHang t) {
		int result = 0;
		try {
			// Bước 1 tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			// Bước 2 tạo đối tượng
			Statement st = connection.createStatement();
			// Bước 3 thực thi câu lệnh
			String sql = "DELETE FROM khachhang" 
					+ " WHERE id= \""+ t.getId() + "\"" ;
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
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang selectByID(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
