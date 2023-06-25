package model;

import java.sql.Date;

public class SinhVienModel {
	private String maSV;
	private String hoTen;
	private String email;
	private String soDT;
	private boolean gioiTinh;
	private String diaChi;

	public SinhVienModel() {

	}

	public SinhVienModel(String maSV, String hoTen, String email, String soDT, boolean gioiTinh, String diaChi) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.email = email;
		this.soDT = soDT;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public String toString() {
		return "SinhVienModel [maSV=" + maSV + ", hoTen=" + hoTen + ", email=" + email + ", soDT=" + soDT
				+ ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + "]";
	}

}
