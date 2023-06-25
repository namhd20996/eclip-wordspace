package test;

import java.sql.Date;

import dao.KhachHangDao;
import model.KhachHang;

public class KhachHangTest {
	public static void main(String[] args) {
		Date ngaySinh = new Date(1996-1900, 9-1, 20);
		for(int i=0; i< 10; i++) {
			KhachHang kh = new KhachHang(""+i, "Hoàng Duy Nam: "+i, ngaySinh, "Bến cát 1");
			KhachHangDao.getInstane().insert(kh);
		}
	}
}	
