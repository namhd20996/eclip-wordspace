package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Form_ToaNha;

public class Form_ToaNhaCTL implements ActionListener, MouseListener {
	private Form_ToaNha form_ToaNha;

	public Form_ToaNhaCTL(Form_ToaNha form_ToaNha) {
		this.form_ToaNha = form_ToaNha;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Làm mới")) {
			form_ToaNha.resetForm();
		} else if (src.equals("Thêm")) {
			form_ToaNha.insertTableToaNha();
		} else if (src.equals("Xóa")) {
			form_ToaNha.deleteTableToaNha();
		} else if (src.equals("Sửa")) {
			form_ToaNha.insertTableToaNha();
		} else if (src.equals("|<")) {
			form_ToaNha.firstElement();
		} else if (src.equals("<<")) {
			form_ToaNha.previousElement();
		} else if (src.equals(">>")) {
			form_ToaNha.nextElement();
		} else if (src.equals(">|")) {
			form_ToaNha.lastElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		form_ToaNha.displayOnForm();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("lbl_IMG")) {
				form_ToaNha.displayImage();
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
