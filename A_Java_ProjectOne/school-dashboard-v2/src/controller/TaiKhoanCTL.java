package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.TaoTaiKhoanJDialog;

public class TaiKhoanCTL implements ActionListener, MouseListener {
	private TaoTaiKhoanJDialog taiKhoanJDialog;

	public TaiKhoanCTL(TaoTaiKhoanJDialog taiKhoanJDialog) {
		this.taiKhoanJDialog = taiKhoanJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if(src.equals("Register")) {
			this.taiKhoanJDialog.registerUser();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.taiKhoanJDialog.exitForm();
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
