package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.ThemNguoiThueJDialog;

public class ThemNguoiThueCTL implements ActionListener, KeyListener {
	private ThemNguoiThueJDialog themNguoiThueJDialog;

	public ThemNguoiThueCTL(ThemNguoiThueJDialog themNguoiThueJDialog) {
		this.themNguoiThueJDialog = themNguoiThueJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm khách")) {
			themNguoiThueJDialog.insertTableNguoiThuePhong();
		} else if (src.equals("Cập nhật")) {
			themNguoiThueJDialog.updateTableNguoiThuePhong();
		}else if (src.equals("Làm mới")) {
			themNguoiThueJDialog.resetForm();
		}else if (src.equals("cboMaNguoiThue")) {
			themNguoiThueJDialog.displayInformationNguoiThue();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getSource().toString().contains("txtMaDichVu_Find")) {
			themNguoiThueJDialog.findMaDichVu();
		} else if (e.getSource().toString().contains("txtFindMaPhong")) {
			themNguoiThueJDialog.findMaPhong();
		}

	}

}
