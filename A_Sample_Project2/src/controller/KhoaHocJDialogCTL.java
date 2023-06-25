package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.KhoaHocJDialog;

public class KhoaHocJDialogCTL implements ActionListener , MouseListener{
	private KhoaHocJDialog khoaHocJDialog;

	public KhoaHocJDialogCTL(KhoaHocJDialog khoaHocJDialog) {
		this.khoaHocJDialog = khoaHocJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Học viên")) {
			this.khoaHocJDialog.displayHocVienJDialog();
		}else if(src.equals("C")) {
//			this.khoaHocJDialog.loadDataTableN();
			this.khoaHocJDialog.selectCombobox();
		}else if(src.equals("Mới")) {
			this.khoaHocJDialog.resetForm();
		}else if(src.equals("Thêm")) {
			this.khoaHocJDialog.insertTable();
		}else if(src.equals("Sửa")) {
			this.khoaHocJDialog.updateTable();
		}else if(src.equals("|<")) {
			this.khoaHocJDialog.firstElement();
		}else if(src.equals("<<")) {
			this.khoaHocJDialog.previousElement();
		}else if(src.equals(">>")) {
			this.khoaHocJDialog.nextElement();
		}else if(src.equals(">|")) {
			this.khoaHocJDialog.lastElement();
		}else if(src.equals("Xóa")) {
			this.khoaHocJDialog.deleteTable();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean src = e.getSource().getClass().getName().substring(12).equals("JLabel");
		if (src) {
			this.khoaHocJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2) {
			this.khoaHocJDialog.disPlayForm();
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
