package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.QLNVView;

public class QLNVController implements ActionListener {
	private QLNVView qlnvView;

	public QLNVController(QLNVView qlnvView) {
		this.qlnvView = qlnvView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(qlnvView, src);
		if (src.equals("Lưu")) {
			this.qlnvView.kiemForm();
			this.qlnvView.luuDoiTuong();
		}else if (src.equals("Thêm")) {
			this.qlnvView.resetForm();
		}else if (src.equals("Xóa")) {
			this.qlnvView.thucHienXoa();
		}else if (src.equals("Save")) {
			this.qlnvView.thucHienSave();
		}else if (src.equals("Open")) {
			this.qlnvView.thucHienOpen();
		}else if (src.equals("Tìm")) {
			this.qlnvView.thucHienTim();
		}else if (src.equals("Hủy tìm")) {
			this.qlnvView.loadLaiDuLieu();
		}else if (src.equals(">|")) {
			this.qlnvView.lastElement();
		}else if (src.equals("|<")) {
			this.qlnvView.firstElement();
		}else if (src.equals("<<")) {
			this.qlnvView.prewElement();
		}else if (src.equals(">>")) {
			this.qlnvView.nextElement();
		}else if (src.equals("Exit")) {
			this.qlnvView.thoatKhoiChuongTrinh();
		}else if(src.equals("About")) {
			this.qlnvView.hienThiAbout();
		}
	}

}
