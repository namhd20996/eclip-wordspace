package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.Form_Phong;

public class Form_PhongCTL implements ActionListener, MouseListener, KeyListener, ChangeListener {
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
		} else if (src.equals("|<")) {
			form_Phong.firstElement();
		} else if (src.equals("<<")) {
			form_Phong.previousElement();
		} else if (src.equals(">>")) {
			form_Phong.nextElement();
		} else if (src.equals(">|")) {
			form_Phong.lastElement();
		} else if (src.equals("Xóa")) {
			form_Phong.deleteTablePCT();
		} else if (src.equals("Sửa")) {
			form_Phong.insertTableThemPhongCTiet();
		} else if (src.equals("Mới")) {
			form_Phong.resetFormPCT();
		} else if (src.equals("cbo_TangFind")) {
			form_Phong.loadTableTang();
		} else if (src.equals("All")) {
			form_Phong.loadTablePhongTrangThai();
		} else if (src.equals("Null")) {
			form_Phong.loadTablePhongTrangThai();
		} else if (src.equals("Not null")) {
			form_Phong.loadTablePhongTrangThai();
		} else if (src.equals("first")) {
			form_Phong.firstElementLSNT();
		} else if (src.equals("pre")) {
			form_Phong.previousElementLSNT();
		} else if (src.equals("next")) {
			form_Phong.nextElementLSNT();
		} else if (src.equals("last")) {
			form_Phong.lastElementLSNT();
		} else if (src.equals("add")) {
			form_Phong.insertTableLSNT();
		} else if (src.equals("delete")) {
			form_Phong.deleteTableLSNT();
		} else if (src.equals("update")) {
			form_Phong.insertTableLSNT();
		} else if (src.equals("new")) {
			form_Phong.resetFormLSNT();
		}	else if (src.equals("cboMaToaNha_Find")) {
			form_Phong.displayListPhongByMaToaNha();
			form_Phong.displayInformationToaNha();
		}else if(src.equals("timListPhong")) {
			form_Phong.displayListPhongFindAll();
			form_Phong.displayInformationToaNha();
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
			if (e.getSource().toString().contains("tbl_DanhSachPhong")) {
				form_Phong.displayOnFormPhong();
			}
			if (e.getSource().toString().contains("tbl_LSNT")) {
				form_Phong.displayFormCapNhatLSNT();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		form_Phong.findMaPhong();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stateChanged(ChangeEvent e) {

	

	}

}
