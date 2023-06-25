package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.QLSVView;

public class QLSVListenner implements ActionListener{
	private QLSVView qlsvView;
	
	public QLSVListenner(QLSVView qlsvView) {
		this.qlsvView = qlsvView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(qlsvView, src);
		if(src.equals("Nhập mới")) {
			this.qlsvView.resetForm();
		}else if(src.equals("Thêm")) {
			this.qlsvView.insertForm();
		}else if(src.equals("Xóa")) {
			this.qlsvView.delete();
		}else if(src.equals("Cập nhật")) {
			this.qlsvView.hienThiSinhVienDangChon();
		}else if(src.equals("Sắp xếp theo tên")) {
			this.qlsvView.loadLaiDuLieuTen();
		}else if(src.equals("Sắp xếp theo điểm")) {
			this.qlsvView.loadLaiDuLieuDiem();
		}
	}

}
