package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.DangNhapJDialog;

public class DangNhapDialogCTL implements ActionListener, MouseListener, KeyListener {
	private DangNhapJDialog dangNhapJDialog;

	public DangNhapDialogCTL(DangNhapJDialog dangNhapJDialog) {
		this.dangNhapJDialog = dangNhapJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Login")) {
			dangNhapJDialog.checkForm();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().toString().contains("LBL_Exit")) {
			this.dangNhapJDialog.exitForm();
		} else if (e.getSource().toString().contains("Register")) {
			this.dangNhapJDialog.displayTaoTaiKhoan();
		} else if (e.getSource().toString().contains("ForgotPw")) {
			this.dangNhapJDialog.displayForgotPw();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().toString().contains("lbl_Show")) {
			this.dangNhapJDialog.showPassword();
		} else if (e.getSource().toString().contains("lbl_Hide")) {
			this.dangNhapJDialog.hidePassword();
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("123");
			this.dangNhapJDialog.btnLogin.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
