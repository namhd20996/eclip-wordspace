package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.NguoiThuePhongJpanel;

public class NguoiThuePhongCTL implements ActionListener, MouseListener, KeyListener{
	private NguoiThuePhongJpanel nguoiThuePhongJpanel;

	public NguoiThuePhongCTL(NguoiThuePhongJpanel nguoiThuePhongJpanel) {
		this.nguoiThuePhongJpanel = nguoiThuePhongJpanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			nguoiThuePhongJpanel.insertTableNguoiThue();
		} else if (src.equals("Xóa")) {
			
		} else if (src.equals("Sửa")) {
			nguoiThuePhongJpanel.insertTableNguoiThue();
		} else if (src.equals("Làm mới")) {
			nguoiThuePhongJpanel.resetForm();
		} else if (src.equals("|<")) {
			nguoiThuePhongJpanel.firstElement();
		} else if (src.equals("<<")) {
			nguoiThuePhongJpanel.previousElement();
		} else if (src.equals(">>")) {
			nguoiThuePhongJpanel.nextElement();
		} else if (src.equals(">|")) {
			nguoiThuePhongJpanel.lastElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("lbl_IMG_NguoiThue")) {
				nguoiThuePhongJpanel.displayImage();
			} else if (e.getSource().toString().contains("lbl_IMG_MatTruoc")) {
				nguoiThuePhongJpanel.displayImageMatTruoc();
			} else if (e.getSource().toString().contains("lbl_IMG_MatSau")) {
				nguoiThuePhongJpanel.displayImageMatSau();
			}else if (e.getSource().toString().contains("tblNguoiThuePhong")) {
				nguoiThuePhongJpanel.displayFormCapNhat();
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
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
