package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Form_DoanhThu;

public class Form_DoanhThuCTL implements ActionListener{
	private Form_DoanhThu form_DoanhThu;
	
	public Form_DoanhThuCTL(Form_DoanhThu form_DoanhThu) {
		this.form_DoanhThu = form_DoanhThu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if(src.equals("Thống Kê")) {
			form_DoanhThu.displayThongKeAll();
		}
	}

}
