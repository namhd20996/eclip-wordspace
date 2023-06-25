package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import view.NguoiHocJDialog;

public class NguoiHocJDialogCTL implements ActionListener, MouseListener, KeyListener {
	private NguoiHocJDialog nguoiHocJDialog;

	public NguoiHocJDialogCTL(NguoiHocJDialog nguoiHocJDialog) {
		this.nguoiHocJDialog = nguoiHocJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			this.nguoiHocJDialog.insertTableNguoiHoc();
		} else if (src.equals("Xóa")) {
			this.nguoiHocJDialog.deleteTableNguoiHoc();
		} else if (src.equals("Sửa")) {
			this.nguoiHocJDialog.insertTableNguoiHoc();
		} else if (src.equals("Mới")) {
			this.nguoiHocJDialog.resetForm();
		} else if (src.equals("|<")) {
			this.nguoiHocJDialog.firstElement();
		} else if (src.equals("<<")) {
			this.nguoiHocJDialog.previousElement();
		} else if (src.equals(">>")) {
			this.nguoiHocJDialog.nextElement();
		} else if (src.equals(">|")) {
			this.nguoiHocJDialog.lastElement();
		} else if (src.equals("Tìm")) {
			this.nguoiHocJDialog.findTable();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean src = e.getSource().getClass().getName().substring(12).equals("JLabel");
		if (src) {
			this.nguoiHocJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getClickCount() == 2) {
			this.nguoiHocJDialog.updateForm();
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
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getSource().toString().contains("maNguoiHoc"));
		if (e.getSource().toString().contains("Find")) {
			this.nguoiHocJDialog.changeFind();
		} else if (e.getSource().toString().contains("maNguoiHoc")) {
			if (e.getKeyCode() != KeyEvent.VK_ENTER) {
				this.nguoiHocJDialog.checkMaNguoiHoc();
			}
		}
	}

}
