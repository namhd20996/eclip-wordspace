package test;

import java.util.ArrayList;

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
//		
//		Sach sach = new Sach("1", "LTC", 10, 2024);
//		SachDao.getInstane().update(sach);
		
		ArrayList<Sach> list = SachDao.getInstane().selectAll();
		for (Sach sach : list) {
			System.out.println(sach);
		}
		
		System.out.println("--------------------");
		Sach find = new Sach();
		find.setId("0");
		Sach sach2 = SachDao.getInstane().selectByID(find);
		System.out.println(sach2);
		
		System.out.println("-----------------------");
		ArrayList<Sach> list2 = SachDao.getInstane().selectByCondition("giaBan<50");
		for (Sach sach : list2) {
			System.out.println(sach);
		}
	}
}
