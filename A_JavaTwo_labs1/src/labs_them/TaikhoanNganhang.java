package labs_them;

import java.util.Scanner;

public class TaikhoanNganhang {
	private String maTaiKhoan;
	private String hoTen;
	private double soDuTaiKhoan;

	public TaikhoanNganhang() {

	}

	public TaikhoanNganhang(String maTaiKhoan, String hoTen, double soDuTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
		this.hoTen = hoTen;
		this.soDuTaiKhoan = 0;
	}

	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getSoDuTaiKhoan() {
		return soDuTaiKhoan;
	}

	public void setSoDuTaiKhoan(double soDuTaiKhoan) {
		this.soDuTaiKhoan = soDuTaiKhoan;
	}

	public void nhapTaiKhoan(Scanner sc) {
		System.out.println("Nhập vào mã tài khoản");
		this.maTaiKhoan = sc.nextLine();
		System.out.println("Nhập vào họ và tên");
		this.hoTen = sc.nextLine();
	}

	public void xuatTaiKhoan() {
		System.out.printf("Mã tài khoản: %s Họ và tên: %s Số dư: %.2f", this.getMaTaiKhoan(), this.getHoTen(),
				this.getSoDuTaiKhoan());
	}
	
	public void rutTien(Scanner sc) {
		double t;
		System.out.println("Nhập vào số tiền cần rút");
		t = sc.nextDouble();
		if(this.soDuTaiKhoan >= t) {
			this.soDuTaiKhoan -= t;
			System.out.println("Giao dịch thành công\n"
					+ "Số dư tài khoản còn: "+this.getSoDuTaiKhoan()
					);
		}else {
			System.out.println("Giao dịch fail\n"
					+ "Số dư < số tiền rút: "+this.getSoDuTaiKhoan());
		}
	}
	
	public void guiTien(Scanner sc) {
		double g;
		System.out.println("Nhập vào số tiền cần gửi");
		g = sc.nextDouble();
		this.soDuTaiKhoan +=g;
	}
}
