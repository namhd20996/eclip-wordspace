package model;

public class TaiSanModel {
	private String maTaiSan;
	private String tenTaiSan;
	private double giaTien;
	private String ghiChu;

	public TaiSanModel() {
	}

	public TaiSanModel(String maTaiSan) {
		this.maTaiSan = maTaiSan;
	}

	public TaiSanModel(String maTaiSan, String tenTaiSan, double giaTien, String ghiChu) {
		this.maTaiSan = maTaiSan;
		this.tenTaiSan = tenTaiSan;
		this.giaTien = giaTien;
		this.ghiChu = ghiChu;
	}

	public String getMaTaiSan() {
		return maTaiSan;
	}

	public void setMaTaiSan(String maTaiSan) {
		this.maTaiSan = maTaiSan;
	}

	public String getTenTaiSan() {
		return tenTaiSan;
	}

	public void setTenTaiSan(String tenTaiSan) {
		this.tenTaiSan = tenTaiSan;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
