package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import view.IntroduceDialog;
import view.QLNVView;

public class QLNVController implements ActionListener, WindowListener, FocusListener{
	private QLNVView qlnvView;
	private IntroduceDialog introduceDialog;

	public QLNVController(QLNVView qlnvView) {
		this.qlnvView = qlnvView;
	}

	public QLNVController(IntroduceDialog introduceDialog) {
		this.introduceDialog = introduceDialog;
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
		}else if (src.equals("IMG")) {
			this.qlnvView.disPlayImage();
		}else if (src.equals("Ok")) {
			this.introduceDialog.closeIntroduceDialog();
		}else if (src.equals("About")) {
			this.qlnvView.hienThiAbout();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		this.qlnvView.introduceModal();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		this.qlnvView.kiemForm();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

}
