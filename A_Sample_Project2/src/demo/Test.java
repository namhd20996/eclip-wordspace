package demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;

import dao.KhoaHocDAO;
import dao.NguoiHocDAO;
import dao_helper.NguoiHocDAOHelper;
import lib.XDate;
import model.NguoiHocModel;
import view.MainJframe;

public class Test {
	public static void main(String[] args) {
		List<Object[]> list = KhoaHocDAO.getInstance().selectByTotal();
		for (Object[] objects : list) {
//			System.out.println(objects[0]+"  "+ objects[1]+"  "+objects[1]+"  "+objects[3]+"  "+objects[4]+"  "+objects[5]+"  "+objects[6]);
			System.out.println(XDate.dateString(Date.valueOf(objects[4].toString())));
		}
	}
}
