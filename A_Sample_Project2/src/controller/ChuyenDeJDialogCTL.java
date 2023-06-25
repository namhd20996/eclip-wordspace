package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.ChuyenDeJDialog;

public class ChuyenDeJDialogCTL implements ActionListener, MouseListener , KeyListener{
	private ChuyenDeJDialog chuyenDeJDialog;

	public ChuyenDeJDialogCTL(ChuyenDeJDialog chuyenDeJDialog) {
		this.chuyenDeJDialog = chuyenDeJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(chuyenDeJDialog, src);
		if(src.equals("Thêm")) {
			this.chuyenDeJDialog.insertTable();
		}else if(src.equals(">>")) {
			this.chuyenDeJDialog.nextElement();
		}else if(src.equals("<<")) {
			this.chuyenDeJDialog.previousElement();
		}else if(src.equals(">|")) {
			this.chuyenDeJDialog.lastElement();
		}else if(src.equals("|<")) {
			this.chuyenDeJDialog.firstElement();
		}else if(src.equals("Mới")) {
			this.chuyenDeJDialog.resetForm();
		}else if(src.equals("Sửa")) {
			this.chuyenDeJDialog.insertTable();
		}else if(src.equals("Xóa")) {
			this.chuyenDeJDialog.deleteTable();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean src = e.getSource().toString().contains("Exit");
		System.out.println(e.getSource().toString());
		if (src) {
			this.chuyenDeJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(e.getSource().toString().contains("IMG"));
		if (e.getClickCount() == 2) {
			if (e.getSource().getClass().getName().substring(12).equals("JLabel")) {
				this.chuyenDeJDialog.imageFrom();
			}
			if (e.getSource().getClass().getName().substring(12).equals("JTable")) {
				this.chuyenDeJDialog.updateForm();
			}
		}
//		System.out.println(e.getSource().getClass().getName().substring(12));

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() != KeyEvent.VK_ENTER) {
			this.chuyenDeJDialog.checkMaChuyenDe();
		}
	}

}
