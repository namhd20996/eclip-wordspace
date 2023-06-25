package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GioiThieuJDialog;

public class GioiThieuJDialogCTL implements MouseListener {
	private GioiThieuJDialog gioiThieuJDialog;

	public GioiThieuJDialogCTL(GioiThieuJDialog gioiThieuJDialog) {

		this.gioiThieuJDialog = gioiThieuJDialog;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.gioiThieuJDialog.closeForm();
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
