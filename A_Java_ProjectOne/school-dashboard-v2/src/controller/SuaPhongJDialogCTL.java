package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SuaPhongJDialog;

public class SuaPhongJDialogCTL implements ActionListener {
	private SuaPhongJDialog suaPhongJDialog;

	public SuaPhongJDialogCTL(SuaPhongJDialog suaPhongJDialog) {
		this.suaPhongJDialog = suaPhongJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Cập nhật")) {
			suaPhongJDialog.updateTablePhong();
		}else if(src.equals("Làm mới")) {
			suaPhongJDialog.resetForm();
		}
	}

}
