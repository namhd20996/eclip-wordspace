package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import view.Form_Phong;

public class Form_PhongCTL implements ActionListener, MouseListener {
	private Form_Phong form_Phong;

	public Form_PhongCTL(Form_Phong form_Phong) {
		this.form_Phong = form_Phong;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if (src.equals("CBO_Tang")) {
			form_Phong.displayListPhong();
		} else if (src.equals("Tất cả")) {
			form_Phong.displayPhongAll();
		} else if (src.equals("Trống")) {
			form_Phong.displayListPhongTrangThai();
		} else if (src.equals("Sử dụng")) {
			form_Phong.displayListPhongTrangThai();
		} else if (src.equals("Thêm")) {
			form_Phong.insertTableThemPhongCTiet();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("lbl_IMG")) {
				form_Phong.disPlayImage();
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
