package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainJframe;

public class MainJframeCTL implements ActionListener {
	private MainJframe mainJframe;

	public MainJframeCTL(MainJframe mainJframe) {
		this.mainJframe = mainJframe;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Kết thúc")) {
			this.mainJframe.exitForm();
		}else if(src.equals("Đăng nhập")) {
			this.mainJframe.checkLogin();
		}else if(src.equals("Loại hàng")) {
			this.mainJframe.displayLoaiHang();
		}else if(src.equals("Hàng hóa")) {
			this.mainJframe.displayHangHoa();
		}else if(src.equals("Cửa hàng")) {
			this.mainJframe.displayCuaHang();
		}else if(src.equals("Phiếu xuất kho")) {
			this.mainJframe.displayPhieuXuatKho();
		}else if(src.equals("Chi tiết phiếu xuất")) {
			this.mainJframe.displayChiTietPhieuXuat();
		}else if(src.equals("Doanh thu cửa hàng")) {
			this.mainJframe.displayDoanhThu();
		}else if(src.equals("Đổi mật khẩu")) {
			this.mainJframe.displayDoiMatKhau();
		}else if(src.equals("Đăng xuất")) {
			this.mainJframe.logOut();
		}else if(src.equals("Nhân viên")) {
			this.mainJframe.displayUser();
		}
	}

}
