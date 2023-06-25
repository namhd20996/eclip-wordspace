package test;

import dao.SachDao;
import model.Sach;

public class SachTest {
	public static void main(String[] args) {
//		for (int i = 0; i < 99; i++) {
//			Sach sach = new Sach(""+i, "LTJV:"+i, 500000, 2020);
//			SachDao.getInstane().insert(sach);
//		}
//		
//		Sach sach = new Sach("1", "LTJV", 500000, 2020);
//		SachDao.getInstane().delete(sach);
		
//		for(int i=0; i<99; i++) {
//			Sach sach = new Sach("" + i, "LTJV " + i, 500000, 2020);
//			SachDao.getInstane().delete(sach);
//		}
		
		Sach sach = new Sach("1", "LTC", 10, 2024);
		SachDao.getInstane().update(sach);
	}
}
