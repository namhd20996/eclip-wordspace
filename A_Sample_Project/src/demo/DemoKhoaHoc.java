package demo;

import java.util.ArrayList;

import dao.KhoaHocDAO;
import dao_helper.KhoaHocDAOHelper;
import dao_helper.NguoiHocDAOHelper;
import model.KhoaHocModel;

public class DemoKhoaHoc {
	public static void main(String[] args) {
		KhoaHocModel k = new KhoaHocModel();
		k.setMaKhoaHoc(1);
//		KhoaHocModel kh = KhoaHocDAOHelper.getInstance().selectByID(k);
		KhoaHocModel kh1 = KhoaHocDAO.getInstance().selectByID(k);
//		System.out.println(kh);
		System.out.println(kh1);
		
	}
}
