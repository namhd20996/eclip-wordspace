package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.NhanVienJDialog;

public class NhanVienDialogCTL implements ActionListener, MouseListener, FocusListener, KeyListener {
	private NhanVienJDialog nhanVienJDialog;

	public NhanVienDialogCTL(NhanVienJDialog nhanVienJDialog) {
		this.nhanVienJDialog = nhanVienJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals(">|")) {
			this.nhanVienJDialog.lastElement();
		} else if (src.equals("|<")) {
			this.nhanVienJDialog.firstElement();
		} else if (src.equals("<<")) {
			this.nhanVienJDialog.previousElement();
		} else if (src.equals(">>")) {
			this.nhanVienJDialog.nextElement();
		} else if (src.equals("Thêm")) {
			this.nhanVienJDialog.insertTableNhanVien();
		} else if (src.equals("Xóa")) {
			this.nhanVienJDialog.deleteTableNhanVien();
		} else if (src.equals("Mới")) {
			this.nhanVienJDialog.resetForm();
		} else if (src.equals("Sửa")) {
			this.nhanVienJDialog.insertTableNhanVien();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean src = e.getSource().getClass().getName().substring(12).equals("JLabel");
		if (src) {
			this.nhanVienJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			this.nhanVienJDialog.updateOnForm();
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
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
//		this.nhanVienJDialog.checkMaNV();
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
		if (e.getKeyCode() != KeyEvent.VK_ENTER) {
			this.nhanVienJDialog.checkMaNV();
		}
	}

}
