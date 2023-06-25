package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.HangHoaJDialog;

public class HangHoaJDialogCTL implements ActionListener, MouseListener {
	private HangHoaJDialog hangHoaJDialog;

	public HangHoaJDialogCTL(HangHoaJDialog hangHoaJDialog) {
		this.hangHoaJDialog = hangHoaJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Add")) {
			this.hangHoaJDialog.insertTable();
		} else if (src.equals("Update")) {
			this.hangHoaJDialog.insertTable();
		} else if (src.equals("Delete")) {
			this.hangHoaJDialog.deleteTable();
		} else if (src.equals("New")) {
			this.hangHoaJDialog.resetForm();
		} else if (src.equals("|<")) {
			this.hangHoaJDialog.firstElement();
		} else if (src.equals("<<")) {
			this.hangHoaJDialog.previousElement();
		} else if (src.equals(">>")) {
			this.hangHoaJDialog.nextElement();
		} else if (src.equals(">|")) {
			this.hangHoaJDialog.lastElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().toString().contains("Exit")) {
			this.hangHoaJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("JTable")) {
				this.hangHoaJDialog.displayFormCapNhat();
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
