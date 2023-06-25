package test;

import java.util.ArrayList;

import javax.swing.UIManager;

import dao.KidsZoneSchoolDAO;
import model.KidsZoneSchoolModel;
import model.ListKidsZoneSchoolModel;
import view.KidsZoneSchoolView;

public class KidsZoneSchoolMain {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new KidsZoneSchoolView();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		KidsZoneSchoolModel kd = new KidsZoneSchoolModel(1,"Nam", "Bàu bàng", "hoàng Huệ", "0968997434", "1m70", 500);
//		KidsZoneSchoolDAO.getInstance().update(kd);
//		
	}
}
