package model;

import java.util.Objects;

public class HangHoaModel {
	private String maMatHang;
	private String tenMatHang;
	private String donViTinh;
	private double donGia;
	private String maLoaiHang;

	public HangHoaModel() {

	}

	public HangHoaModel(String maMatHang, String tenMatHang, String donViTinh, double donGia, String maLoaiHang) {
		this.maMatHang = maMatHang;
		this.tenMatHang = tenMatHang;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
		this.maLoaiHang = maLoaiHang;
	}

	public String getMaMatHang() {
		return maMatHang;
	}

	public void setMaMatHang(String maMatHang) {
		this.maMatHang = maMatHang;
	}

	public String getTenMatHang() {
		return tenMatHang;
	}

	public void setTenMatHang(String tenMatHang) {
		this.tenMatHang = tenMatHang;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getMaLoaiHang() {
		return maLoaiHang;
	}

	public void setMaLoaiHang(String maLoaiHang) {
		this.maLoaiHang = maLoaiHang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(donGia, donViTinh, maLoaiHang, maMatHang, tenMatHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HangHoaModel other = (HangHoaModel) obj;
		return Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(donViTinh, other.donViTinh) && Objects.equals(maLoaiHang, other.maLoaiHang)
				&& Objects.equals(maMatHang, other.maMatHang) && Objects.equals(tenMatHang, other.tenMatHang);
	}

	@Override
	public String toString() {
		return "HangHoaModel [maMatHang=" + maMatHang + ", tenMatHang=" + tenMatHang + ", donViTinh=" + donViTinh
				+ ", donGia=" + donGia + ", maLoaiHang=" + maLoaiHang + "]";
	}

}
