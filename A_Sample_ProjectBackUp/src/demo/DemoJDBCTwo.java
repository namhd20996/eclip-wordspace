package demo;

import java.util.ArrayList;

import java.util.List;

import dao.ChuyenDeDAO;
import dao.KhoaHocDAO;
import dao.NguoiHocDAO;

import dao_helper.ThongKeDAOHelper;
import model.ChuyenDeModel;
import model.KhoaHocModel;
import model.NguoiHocModel;

public class DemoJDBCTwo {
	public static void main(String[] args) {
//		List<Object[]> list = ThongKeDAO.getInstance().getBangDiem(1);
//		for (Object[] objects : list) {
////			System.out.println(objects[0]+" "+ objects[1]+""+objects[2]);
//		}
		
		List<Object[]> list1 = ThongKeDAOHelper.getInstance().getLuongNguoiHoc();
		for (Object[] objects : list1) {
			System.out.println(objects[0]+" "+ objects[1]+" - "+objects[2]+"- "+objects[3]);
		}
		
		ArrayList<KhoaHocModel> list2 = KhoaHocDAO.getInstance().selectAll();
		for (KhoaHocModel nguoiHocModel : list2) {
			System.out.println(nguoiHocModel);
		}
		
	}
}
