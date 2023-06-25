package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ThemPhongNhanh;

public class ThemPhongNhanhCTL implements ActionListener {
	private ThemPhongNhanh themPhongNhanh;

	public ThemPhongNhanhCTL(ThemPhongNhanh themPhongNhanh) {
		this.themPhongNhanh = themPhongNhanh;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Thêm")) {
			themPhongNhanh.insertTablePhong();
		}else if(src.equals("Xóa")) {
			themPhongNhanh.deleteTablePhong();
		}else if(src.equals("Làm mới")) {
			themPhongNhanh.resetForm();
		}
	}

}
