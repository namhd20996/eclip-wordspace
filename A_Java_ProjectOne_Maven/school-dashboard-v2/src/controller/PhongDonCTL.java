package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.PhongDon;

public class PhongDonCTL implements ActionListener {
	private PhongDon phongDon;

	public PhongDonCTL(PhongDon phongDon) {
		this.phongDon = phongDon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Thêm Khách")) {
			phongDon.displayUpdatePhong();
		}else if(src.equals("Trả")) {
			phongDon.displayTraPhong();
		}else if(src.equals("Xem")) {
			phongDon.displayXemPhong();
		}else if(src.equals("Xóa")) {
			phongDon.displayXoaPhong();
		}else if(src.equals("Sửa")) {
			phongDon.displaySuaPhong();
		}
	}

}
