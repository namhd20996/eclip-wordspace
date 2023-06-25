package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.LoaiHangJDialog;

public class LoaiHangJDialogCTL implements ActionListener, MouseListener {
	private LoaiHangJDialog loaiHangJDialog;

	public LoaiHangJDialogCTL(LoaiHangJDialog loaiHangJDialog) {
		this.loaiHangJDialog = loaiHangJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Add")) {
			this.loaiHangJDialog.insertTable();
		} else if (src.equals("Update")) {
			this.loaiHangJDialog.insertTable();
		} else if (src.equals("Delete")) {
			this.loaiHangJDialog.deleteTable();
		} else if (src.equals("New")) {
			this.loaiHangJDialog.resetForm();
		} else if (src.equals("|<")) {
			this.loaiHangJDialog.firstElement();
		} else if (src.equals("<<")) {
			this.loaiHangJDialog.previousElement();
		} else if (src.equals(">>")) {
			this.loaiHangJDialog.nextElement();
		} else if (src.equals(">|")) {
			this.loaiHangJDialog.lastElement();
		} else if (src.equals("")) {

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().toString().contains("Exit")) {
			this.loaiHangJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("IMG")) {
				this.loaiHangJDialog.displayImage();
			}
			if (e.getSource().toString().contains("JTable")) {
				this.loaiHangJDialog.displayFormCapNhat();
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
