package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;

public class ThongKeDao {

	public static ThongKeDao getInstance() {
		return new ThongKeDao();
	}

	public List<Object[]> getDoanhThu(String maCuaHang) {
		List<Object[]> list = new ArrayList<>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "{Call get_DoanhThu(?)}";
			CallableStatement cst = connection.prepareCall(sql);
			cst.setString(1, maCuaHang);
			ResultSet rs = cst.executeQuery();
			while (rs.next()) {
				String tenCuaHang = rs.getString("tenCuaHang");
				String diaChi = rs.getString("diaChi");
				String soDienThoai = rs.getString("soDienThoai");
				String tenMatHang = rs.getString("tenMatHang");
				int soLuong = rs.getInt("soLuong");
				double thanhTien = rs.getDouble("thanhTien");
				Object[] vals = { tenCuaHang, diaChi, soDienThoai, tenMatHang, soLuong, thanhTien };
				list.add(vals);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<Object[]> list = ThongKeDao.getInstance().getDoanhThu("CH01");
		for (Object[] objects : list) {
			System.out.println(objects[5]);
		}
	}
}
