package demo;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import dao.NhanVienDAO;
import database.JDBCUtil;
import lib.XDate;
import model.NhanVienModel;

public class DemoJDBC {
	public static void main(String[] args) {
		NhanVienModel n = new NhanVienModel("1", "123", "Hoàng Duy Nam", true);
//		NhanVienModel n = new NhanVienModel();
//		n.setMaNV("1");
		ArrayList<NhanVienModel> list = NhanVienDAO.getInstance().selectAll();
		for (NhanVienModel nhanVienModel : list) {
			System.out.println(nhanVienModel);
		}

		// Lấy ngày hiện tại Date.sql
		/*
		 * long millis = System.currentTimeMillis(); java.sql.Date date = new
		 * java.sql.Date(millis); System.out.println(date);
		 */
//		Date a = XDate.now();
//		System.out.println(a);
//
//		// converting string into sql date
//		String t = "11/09/2019";
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			java.util.Date da = sdf.parse(t);
//			String str = (da.getYear() + 1900) + "-" + (da.getMonth() + 1) + "-" + da.getDate();
//			System.out.println(str);
//			Date date = Date.valueOf(str);
//			System.out.println(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//        String str = "2017-09-11";
//        Date date = Date.valueOf(str);
//        System.out.println(date);

		// @Deprecated khi bỏ nó phía trước các function or biến nó giúp báo cho người
		// dùng biết function or biến đó đã cũ có thể Ko dùng được trong tương lai
		
		// @SuppressWarnings thông báo trình biên dịch tắt các cảnh báo lỗi
	}
}
