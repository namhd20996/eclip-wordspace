package controller;

import java.awt.event.ActionEvent;

import java.util.Date;
import java.awt.event.ActionListener;


import javax.swing.JOptionPane;

import model.SinhVienModel;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener {
	private QLSVView qlsvView;

	public QLSVController(QLSVView qlsvView) {
		this.qlsvView = qlsvView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(qlsvView, "Bạn đã nhấn: " + cm);
		if (cm.equals("Thêm")) {
			this.qlsvView.xoaForm();
			this.qlsvView.qlsvModel.setLuaChon("Thêm");
		} else if (cm.equals("Lưu")) {
			this.qlsvView.thucHienThem();
		} else if (cm.equals("Cập nhật")) {
			this.qlsvView.hienThiThongTinSinhVienDaChon();
		}else if (cm.equals("Xóa")) {
			this.qlsvView.thucHienXoa();
		}else if (cm.equals("Hủy bỏ")) {
			this.qlsvView.xoaForm();
		}else if(cm.equals("Tìm")) {
			this.qlsvView.thucHienTim();
		}else if(cm.equals("Hủy tìm")) {
			this.qlsvView.loadLaiDuLieu();
		}else if(cm.equals("About me")) {
			this.qlsvView.hienThiAbout();
		}else if(cm.equals("Exit")) {
			this.qlsvView.thoatKhoiChuongTrinh();
		}else if(cm.equals("Save")) {
			this.qlsvView.thucHienSave();
		}else if(cm.equals("Open")) {
			this.qlsvView.thucHienOpen();
		}
	}

}
