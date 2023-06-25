package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Form_NhanVien;

public class Form_NhanVienCTL implements ActionListener, MouseListener {
	private Form_NhanVien form_NhanVien;

	public Form_NhanVienCTL(Form_NhanVien form_NhanVien) {
		this.form_NhanVien = form_NhanVien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if (src.equals("Thêm")) {
			form_NhanVien.insertTableNhanVien();
		} else if (src.equals("Xóa")) {
			form_NhanVien.deleteTable();
		} else if (src.equals("Sửa")) {
			form_NhanVien.insertTableNhanVien();
		} else if (src.equals("Làm mới")) {
			form_NhanVien.resetForm();
		} else if (src.equals("|<")) {
			form_NhanVien.firstElement();
		} else if (src.equals("<<")) {
			form_NhanVien.previousElement();
		} else if (src.equals(">>")) {
			form_NhanVien.nextElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("tblNhanVien")) {
				form_NhanVien.displayOnForm();

			} else if (e.getSource().toString().contains("lbl_IMG")) {
				form_NhanVien.displayImage();
			}
		}
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
