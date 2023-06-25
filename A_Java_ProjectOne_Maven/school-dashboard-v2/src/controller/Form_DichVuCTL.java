package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Form_DichVu;

public class Form_DichVuCTL implements ActionListener, MouseListener {
	private Form_DichVu form_DichVu;

	public Form_DichVuCTL(Form_DichVu form_DichVu) {
		this.form_DichVu = form_DichVu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			form_DichVu.insertTableDichVu();
		} else if (src.equals("Xóa")) {

		} else if (src.equals("Sửa")) {
			form_DichVu.insertTableDichVu();
		} else if (src.equals("Làm mới")) {
			form_DichVu.resetFormDichVu();
		} else if (src.equals("add")) {
			form_DichVu.insertTableCTDichVu();
		} else if (src.equals("delete")) {

		} else if (src.equals("update")) {
			form_DichVu.insertTableCTDichVu();
		} else if (src.equals("new")) {
			form_DichVu.resetFormCTDichVu();
		} else if (src.equals("|<")) {
			form_DichVu.firstElement();
		} else if (src.equals("<<")) {
			form_DichVu.previousElement();
		} else if (src.equals(">>")) {
			form_DichVu.nextElement();
		} else if (src.equals(">|")) {
			form_DichVu.lastElement();
		} else if (src.equals("first")) {
			form_DichVu.firstElementCTDV();
		} else if (src.equals("pre")) {
			form_DichVu.previousElementCTDV();
		} else if (src.equals("next")) {
			form_DichVu.nextElementCTDV();
		} else if (src.equals("last")) {
			form_DichVu.lastElementCTDV();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().toString().contains("tblDichVu")) {
			form_DichVu.displayFormCapNhat();
		} else if (e.getSource().toString().contains("tblCTDV")) {
			form_DichVu.displayFormCapNhatCTDV();
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
