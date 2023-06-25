package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DoiMatKhauDialog;

public class DoiMatKhauCTL implements ActionListener{
	private DoiMatKhauDialog doiMatKhauDialog;
	
	public DoiMatKhauCTL(DoiMatKhauDialog doiMatKhauDialog) {
		this.doiMatKhauDialog = doiMatKhauDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Xác nhận")) {
			this.doiMatKhauDialog.changePassword();
		}else if(src.equals("Hủy bỏ")) {
			this.doiMatKhauDialog.exitForm();
		}
	}

}
