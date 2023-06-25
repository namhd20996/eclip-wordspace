package demo;

import java.util.ArrayList;

import dao_helper.HocVienDAOHelper;
import lib.JDBCHelper;
import model.HocVienModel;

public class DemoHocVienHelper {
	public static void main(String[] args) {
		HocVienModel hv = new HocVienModel();
		hv.setMaHocVien(1);
		HocVienModel hv1 = HocVienDAOHelper.getInstance().selectByID(hv);
		System.out.println(hv1);
	}
}	
