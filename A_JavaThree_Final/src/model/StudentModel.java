package model;

import java.util.Arrays;
import java.util.Objects;

public class StudentModel {
	private String maSV;
	private String hoTen;
	private String email;
	private String soDT;
	private boolean gioiTinh;
	private String diaChi;
	private byte[] hinh;

	public StudentModel() {

	}

	public StudentModel(String maSV, String hoTen, String email, String soDT, boolean gioiTinh, String diaChi,
			byte[] hinh) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.email = email;
		this.soDT = soDT;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.hinh = hinh;
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

	public byte[] getHinh() {
		return hinh;
	}

	public void setHinh(byte[] hinh) {
		this.hinh = hinh;
	}

	@Override
	public String toString() {
		return "StudentModel [maSV=" + maSV + ", hoTen=" + hoTen + ", email=" + email + ", soDT=" + soDT + ", gioiTinh="
				+ gioiTinh + ", diaChi=" + diaChi + ", hinh=" + Arrays.toString(hinh) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(hinh);
		result = prime * result + Objects.hash(diaChi, email, gioiTinh, hoTen, maSV, soDT);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentModel other = (StudentModel) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email) && gioiTinh == other.gioiTinh
				&& Arrays.equals(hinh, other.hinh) && Objects.equals(hoTen, other.hoTen)
				&& Objects.equals(maSV, other.maSV) && Objects.equals(soDT, other.soDT);
	}

}
