package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import view.MainJframe;

public class MainJframeCTL implements ActionListener, WindowListener{
	private MainJframe mainJframe;
	
	public MainJframeCTL(MainJframe mainJframe) {
		this.mainJframe = mainJframe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Giới thiệu sản phẩm")) {
			this.mainJframe.displayGioiThieuJDialog();
		}else if(src.equals("Kết thúc")) {
			this.mainJframe.exitForm();
		}else if(src.equals("Nhân viên")) {
			this.mainJframe.displayNhanVienJDialog();
		}else if(src.equals("Người học")) {
			this.mainJframe.displayNguoiHocJDialog();
		}else if(src.equals("Chuyên đề")) {
			this.mainJframe.displayChuyenDeJDialog();
		}else if(src.equals("Khóa học")) {
			this.mainJframe.displayKhoaHocJDialog();
		}else if(src.equals("Đổi mật khẩu")) {
			this.mainJframe.displayDoiMatKhauJDialog();
		}else if(src.equals("Người học từng năm")) {
			this.mainJframe.setIndex(0);
			this.mainJframe.displayThongKeJDialog();
		}else if(src.equals("Bảng khóa điểm")) {
			this.mainJframe.setIndex(1);
			this.mainJframe.displayThongKeJDialog();
		}else if(src.equals("Điểm từng khóa học")) {
			this.mainJframe.setIndex(2);
			this.mainJframe.displayThongKeJDialog();
		}else if(src.equals("Doanh thu từng chuyên đề")) {
			this.mainJframe.setIndex(3);
			this.mainJframe.displayThongKeJDialog();
		}else if(src.equals("Đăng xuất")) {
			this.mainJframe.logOut();
		}else if(src.equals("Đăng nhập")) {
			this.mainJframe.openDisplayDangNhapJDialog();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
//		this.mainJframe.displayDangNhapJDialog();
//		this.mainJframe.displayChaoJDialog();
		
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

}
