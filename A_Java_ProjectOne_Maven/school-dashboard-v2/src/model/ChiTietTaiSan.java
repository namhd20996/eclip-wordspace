package model;

public class ChiTietTaiSan {
	private String maPhong;
	private String maTaiSan;
	private String ghiChu;
	private int soLuong;

	public ChiTietTaiSan() {

	}

	public ChiTietTaiSan(String maPhong, String maTaiSan, String ghiChu, int soLuong) {
		this.maPhong = maPhong;
		this.maTaiSan = maTaiSan;
		this.ghiChu = ghiChu;
		this.soLuong = soLuong;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaTaiSan() {
		return maTaiSan;
	}

	public void setMaTaiSan(String maTaiSan) {
		this.maTaiSan = maTaiSan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

}
