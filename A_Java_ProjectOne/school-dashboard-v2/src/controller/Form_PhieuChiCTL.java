package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Form_PhieuChi;

public class Form_PhieuChiCTL implements ActionListener, MouseListener {
	private Form_PhieuChi form_PhieuChi;

	public Form_PhieuChiCTL(Form_PhieuChi form_PhieuChi) {
		this.form_PhieuChi = form_PhieuChi;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			form_PhieuChi.insertTablePhieuChi();
		} else if (src.equals("Xóa")) {
			form_PhieuChi.deleteTablePhieuChi();
		} else if (src.equals("Sửa")) {
			form_PhieuChi.insertTablePhieuChi();
		} else if (src.equals("Làm mới")) {
			form_PhieuChi.resetForm();
		} else if (src.equals("|<")) {
			form_PhieuChi.firstElement();
		} else if (src.equals("<<")) {
			form_PhieuChi.previousElement();
		} else if (src.equals(">>")) {
			form_PhieuChi.nextElement();
		} else if (src.equals(">|")) {
			form_PhieuChi.lastElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		form_PhieuChi.displayFormCapNhat();
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
