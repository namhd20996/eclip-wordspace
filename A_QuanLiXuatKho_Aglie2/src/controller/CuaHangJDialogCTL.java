package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.CuaHangJDialog;

public class CuaHangJDialogCTL implements ActionListener, MouseListener , KeyListener{

	private CuaHangJDialog cuaHangJDialog;

	public CuaHangJDialogCTL(CuaHangJDialog cuaHangJDialog) {
		this.cuaHangJDialog = cuaHangJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Add")) {
			this.cuaHangJDialog.insertTable();
		} else if (src.equals("Update")) {
			this.cuaHangJDialog.insertTable();
		} else if (src.equals("Delete")) {
			this.cuaHangJDialog.deleteTable();
		} else if (src.equals("New")) {
			this.cuaHangJDialog.resetForm();
		} else if (src.equals("|<")) {
			this.cuaHangJDialog.firstElement();
		} else if (src.equals("<<")) {
			this.cuaHangJDialog.previousElement();
		} else if (src.equals(">>")) {
			this.cuaHangJDialog.nextElement();
		} else if (src.equals(">|")) {
			this.cuaHangJDialog.lastElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getSource().toString());
		if (e.getSource().toString().contains("Exit")) {
			this.cuaHangJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			if (e.getSource().toString().contains("IMG")) {
				this.cuaHangJDialog.displayImage();
			}
			if (e.getSource().toString().contains("JTable")) {
				this.cuaHangJDialog.displayFormCapNhat();
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		this.cuaHangJDialog.findCuaHang();
		
	}

}
