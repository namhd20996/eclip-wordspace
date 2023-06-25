package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;
import model.KhachHang;

public class Test {
	public static void main(String[] args) {
		try {
			Connection connection = JDBCUtil.getConnection();
			Date ngaySinh = new Date(1996-1900, 9-1, 20);
			KhachHang kh = new KhachHang(8, "Hoàng Duy Nam", ngaySinh, "Bến cát");
			
			Statement st = connection.createStatement();
			String sql = "INSERT INTO khachhang (`id`, `hoVaTen`, `ngaySinh`, `diaChi`) VALUES \r\n"
					+ "(\""+kh.getId()+"\", \""+kh.getHoVaTen()+"\", \""+kh.getNgaySinh()+"\", \""+kh.getDiaChi()+"\")";
			int check= st.executeUpdate(sql);
			System.out.println(check);
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
