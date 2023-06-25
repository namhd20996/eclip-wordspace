package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Form_TaiSan;

public class Form_TaiSanCTL implements ActionListener, MouseListener {
	private Form_TaiSan form_TaiSan;

	public Form_TaiSanCTL(Form_TaiSan form_TaiSan) {
		this.form_TaiSan = form_TaiSan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			form_TaiSan.insertTableTaiSan();
		} else if (src.equals("Xóa")) {
			form_TaiSan.deleteTableTaiSan();
		} else if (src.equals("Sửa")) {
			form_TaiSan.insertTableTaiSan();
		} else if (src.equals("Làm mới")) {
			form_TaiSan.resetForm();
		} else if (src.equals("|<")) {
			form_TaiSan.firstElement();
		} else if (src.equals("<<")) {
			form_TaiSan.previousElement();
		} else if (src.equals(">>")) {
			form_TaiSan.nextElement();
		} else if (src.equals(">|")) {
			form_TaiSan.lastElement();
		} else if (src.equals("add")) {
			form_TaiSan.insertTableTaiSanCT();
		} else if (src.equals("delete")) {
			form_TaiSan.deleteTaiSan_CT();
		} else if (src.equals("update")) {
			form_TaiSan.insertTableTaiSanCT();
		} else if (src.equals("new")) {
			form_TaiSan.resetForm_CT();
		} else if (src.equals("first")) {
			form_TaiSan.firstElement_CT();
		} else if (src.equals("pre")) {
			form_TaiSan.previousElement_CT();
		} else if (src.equals("next")) {
			form_TaiSan.nextElement_CT();
		} else if (src.equals("last")) {
			form_TaiSan.lastElement_CT();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().toString().contains("tblTaiSan")) {
			form_TaiSan.displayFormCapNhat();
		} else if (e.getSource().toString().contains("tblTaiSan_CT")) {
			form_TaiSan.displayOnFormTaiSan_CT();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
