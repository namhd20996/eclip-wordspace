package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Form_PhieuThuTienPhong;

public class Form_PhieuThuTienPhongCTL implements ActionListener, MouseListener, KeyListener {
	private Form_PhieuThuTienPhong form_PhieuThuTienPhong;

	public Form_PhieuThuTienPhongCTL(Form_PhieuThuTienPhong form_PhieuThuTienPhong) {
		this.form_PhieuThuTienPhong = form_PhieuThuTienPhong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("cboMaPhong")) {
			form_PhieuThuTienPhong.setInformation();
		} else if (src.equals("Thêm")) {
			form_PhieuThuTienPhong.insertTablePhieuThuTienPhong();
		} else if (src.equals("Xóa")) {
			form_PhieuThuTienPhong.deleteTablePhieuChi();
		} else if (src.equals("Sửa")) {
			form_PhieuThuTienPhong.insertTablePhieuThuTienPhong();
		} else if (src.equals("Làm mới")) {
			form_PhieuThuTienPhong.resetForm();
		} else if (src.equals("|<")) {
			form_PhieuThuTienPhong.lastElement();
		} else if (src.equals("<<")) {
			form_PhieuThuTienPhong.previousElement();
		} else if (src.equals(">>")) {
			form_PhieuThuTienPhong.nextElement();
		} else if (src.equals(">|")) {
			form_PhieuThuTienPhong.lastElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		form_PhieuThuTienPhong.displayFormCapNhat();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource().toString().contains("soDien")) {
			form_PhieuThuTienPhong.displaySoDien();
		}else if(e.getSource().toString().contains("soNuoc")) {
			form_PhieuThuTienPhong.displaySoNuoc();
		}else if(e.getSource().toString().contains("maPhongFind")) {
			form_PhieuThuTienPhong.findMaPhong();
		}
		
		
	}

}
