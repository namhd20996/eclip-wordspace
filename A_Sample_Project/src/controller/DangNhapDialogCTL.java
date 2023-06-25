package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.DangNhapJDialog;
import view.DoiMatKhauDialog;

public class DangNhapDialogCTL implements ActionListener , KeyListener, MouseListener{
	private DangNhapJDialog dangNhapJDialog;
	private DoiMatKhauDialog doiMatKhauDialog;

	public DangNhapDialogCTL(DangNhapJDialog dangNhapJDialog) {
		this.dangNhapJDialog = dangNhapJDialog;
	}

	public DangNhapDialogCTL(DoiMatKhauDialog doiMatKhauDialog) {
		this.doiMatKhauDialog = doiMatKhauDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Login")) {
			this.dangNhapJDialog.checkForm();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == '\n') {
			this.dangNhapJDialog.checkForm();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.dangNhapJDialog.exitForm();
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
