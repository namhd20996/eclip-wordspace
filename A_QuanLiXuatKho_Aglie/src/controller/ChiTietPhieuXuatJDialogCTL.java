package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.ChiTietPhieuXuatJDialog;

public class ChiTietPhieuXuatJDialogCTL implements ActionListener, MouseListener {
	private ChiTietPhieuXuatJDialog chiTietPhieuXuatJDialog;

	public ChiTietPhieuXuatJDialogCTL(ChiTietPhieuXuatJDialog chiTietPhieuXuatJDialog) {
		this.chiTietPhieuXuatJDialog = chiTietPhieuXuatJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Add")) {
			this.chiTietPhieuXuatJDialog.insertTable();
		} else if (src.equals("Update")) {
			this.chiTietPhieuXuatJDialog.insertTable();
		} else if (src.equals("Delete")) {
			this.chiTietPhieuXuatJDialog.deleteTable();
		} else if (src.equals("New")) {
			this.chiTietPhieuXuatJDialog.resetForm();
		} else if (src.equals("|<")) {
			this.chiTietPhieuXuatJDialog.firstElement();
		} else if (src.equals("<<")) {
			this.chiTietPhieuXuatJDialog.previousElement();
		} else if (src.equals(">>")) {
			this.chiTietPhieuXuatJDialog.nextElement();
		} else if (src.equals(">|")) {
			this.chiTietPhieuXuatJDialog.lastElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().toString().contains("Exit")) {
			this.chiTietPhieuXuatJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("JTable")) {
				this.chiTietPhieuXuatJDialog.displayFormCapNhat();
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
