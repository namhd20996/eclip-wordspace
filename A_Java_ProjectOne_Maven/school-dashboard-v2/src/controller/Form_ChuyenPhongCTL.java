package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Form_ChuyenPhong;

public class Form_ChuyenPhongCTL implements ActionListener, KeyListener, MouseListener {
	private Form_ChuyenPhong form_ChuyenPhong;

	public Form_ChuyenPhongCTL(Form_ChuyenPhong form_ChuyenPhong) {
		this.form_ChuyenPhong = form_ChuyenPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if (src.equals("Chuyển")) {
			form_ChuyenPhong.chuyenPhong();
		} else if (src.equals("Làm mới")) {
			form_ChuyenPhong.resetForm();
		} else if (src.equals("Sửa")) {
			form_ChuyenPhong.updateChuyenPhong();
		} else if (src.equals("Xóa")) {
			form_ChuyenPhong.deleteForm();
		} else if (src.equals("|<")) {
			form_ChuyenPhong.firstElement();
		} else if (src.equals("<<")) {
			form_ChuyenPhong.previousElement();
		} else if (src.equals(">>")) {
			form_ChuyenPhong.nextElement();
		} else if (src.equals(">|")) {
			form_ChuyenPhong.lastElement();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getSource().toString().contains("txtFindMaPhongTrong")) {
			form_ChuyenPhong.loadDataTable();
		} else if (e.getSource().toString().contains("txtFind")) {

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		form_ChuyenPhong.loadComboboxMPC();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().toString().contains("tblPhongTrong")) {
			form_ChuyenPhong.displayOnComboboxMPM();
		} else if (e.getSource().toString().contains("tblPhongChuyen")) {
			form_ChuyenPhong.displayOnForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
//		if(e.getClickCount()==2) {
//			
//		}
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
