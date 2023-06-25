package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.HocVienJDialog;

public class HocVienJDialogCTL implements ActionListener, MouseListener {
	private HocVienJDialog hocVienJDialog;

	public HocVienJDialogCTL(HocVienJDialog hocVienJDialog) {
		this.hocVienJDialog = hocVienJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Thêm")) {
			this.hocVienJDialog.insertTable();
		}else if (src.equals("Cập nhật")) {
			this.hocVienJDialog.updateTable();
		}else if (src.equals("Tất cả")) {
			this.hocVienJDialog.loadDataTable();
		}else if (src.equals("Chưa nhập điểm")) {
			this.hocVienJDialog.loadTableChuaNhapDiem();
		}else if (src.equals("Đã nhập điểm")) {
			this.hocVienJDialog.loadTableDaNhapDiem();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		boolean src = e.getSource().getClass().getName().substring(12).equals("JLabel");
		if (src) {
			this.hocVienJDialog.exitForm();
		}
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
