package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.PhieuXuatKhoJDialog;

public class PhieuXuatKhoJDialogCTL implements ActionListener, MouseListener {

	private PhieuXuatKhoJDialog phieuXuatKhoJDialog;

	public PhieuXuatKhoJDialogCTL(PhieuXuatKhoJDialog phieuXuatKhoJDialog) {
		this.phieuXuatKhoJDialog = phieuXuatKhoJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Add")) {
			this.phieuXuatKhoJDialog.insertTable();
		} else if (src.equals("Update")) {
			this.phieuXuatKhoJDialog.insertTable();
		} else if (src.equals("Delete")) {
			this.phieuXuatKhoJDialog.deleteTable();
		} else if (src.equals("New")) {
			this.phieuXuatKhoJDialog.resetForm();
		} else if (src.equals("|<")) {
			this.phieuXuatKhoJDialog.firstElement();
		} else if (src.equals("<<")) {
			this.phieuXuatKhoJDialog.previousElement();
		} else if (src.equals(">>")) {
			this.phieuXuatKhoJDialog.nextElement();
		} else if (src.equals(">|")) {
			this.phieuXuatKhoJDialog.lastElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().toString().contains("Exit")) {
			this.phieuXuatKhoJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("JTable")) {
				this.phieuXuatKhoJDialog.displayFormCapNhat();
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
