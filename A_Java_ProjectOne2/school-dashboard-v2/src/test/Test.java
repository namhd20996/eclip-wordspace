package test;

import java.util.ArrayList;

import dao.PhongDao;
import model.PhongModel;

public class Test {
	public static void main(String[] args) {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
		for (PhongModel phongModel : list) {
			System.out.println(phongModel);
		}
	}
}
