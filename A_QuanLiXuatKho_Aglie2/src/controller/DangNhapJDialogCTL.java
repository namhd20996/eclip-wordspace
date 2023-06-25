package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.DangNhapJDialog;

public class DangNhapJDialogCTL implements ActionListener, KeyListener, MouseListener {
	private DangNhapJDialog dangNhapJDialog;

	public DangNhapJDialogCTL(DangNhapJDialog dangNhapJDialog) {
		this.dangNhapJDialog = dangNhapJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(dangNhapJDialog, src);
		if (src.equals("Login")) {
			this.dangNhapJDialog.checkForm();
		}
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().toString().contains("ExitForm")) {
			this.dangNhapJDialog.exitForm();
		} else if (e.getSource().toString().contains("Register")) {
			this.dangNhapJDialog.displayTaoTaiKhoan();

		}else if (e.getSource().toString().contains("ForgotPw")) {
			this.dangNhapJDialog.displayForgotPw();

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
