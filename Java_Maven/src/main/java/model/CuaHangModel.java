package model;

import java.util.Arrays;
import java.util.Objects;

public class CuaHangModel {
	private String maCuaHang;
	private String tenCuaHang;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private String nguoiDaiDien;
	private byte[] hinhAnh;

	public CuaHangModel() {

	}

	public CuaHangModel(String maCuaHang, String tenCuaHang, String diaChi, String soDienThoai, String email,
			String nguoiDaiDien, byte[] hinhAnh) {
		this.maCuaHang = maCuaHang;
		this.tenCuaHang = tenCuaHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.nguoiDaiDien = nguoiDaiDien;
		this.hinhAnh = hinhAnh;
	}

	public String getMaCuaHang() {
		return maCuaHang;
	}

	public void setMaCuaHang(String maCuaHang) {
		this.maCuaHang = maCuaHang;
	}

	public String getTenCuaHang() {
		return tenCuaHang;
	}

	public void setTenCuaHang(String tenCuaHang) {
		this.tenCuaHang = tenCuaHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNguoiDaiDien() {
		return nguoiDaiDien;
	}

	public void setNguoiDaiDien(String nguoiDaiDien) {
		this.nguoiDaiDien = nguoiDaiDien;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return "CuaHangModel [maCuaHang=" + maCuaHang + ", tenCuaHang=" + tenCuaHang + ", diaChi=" + diaChi
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + ", nguoiDaiDien=" + nguoiDaiDien + ", hinhAnh="
				+ Arrays.toString(hinhAnh) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(hinhAnh);
		result = prime * result + Objects.hash(diaChi, email, maCuaHang, nguoiDaiDien, soDienThoai, tenCuaHang);
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
		CuaHangModel other = (CuaHangModel) obj;
		return Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Arrays.equals(hinhAnh, other.hinhAnh) && Objects.equals(maCuaHang, other.maCuaHang)
				&& Objects.equals(nguoiDaiDien, other.nguoiDaiDien) && Objects.equals(soDienThoai, other.soDienThoai)
				&& Objects.equals(tenCuaHang, other.tenCuaHang);
	}

}
