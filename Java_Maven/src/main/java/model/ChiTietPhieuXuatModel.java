package model;

import java.util.Objects;

public class ChiTietPhieuXuatModel {
	private String maPhieuXuat;
	private String maMatHang;
	private int soLuong;
	private String ghiChu;

	public ChiTietPhieuXuatModel() {

	}

	public ChiTietPhieuXuatModel(String maPhieuXuat, String maMatHang, int soLuong, String ghiChu) {
		this.maPhieuXuat = maPhieuXuat;
		this.maMatHang = maMatHang;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
	}

	public String getMaPhieuXuat() {
		return maPhieuXuat;
	}

	public void setMaPhieuXuat(String maPhieuXuat) {
		this.maPhieuXuat = maPhieuXuat;
	}

	public String getMaMatHang() {
		return maMatHang;
	}

	public void setMaMatHang(String maMatHang) {
		this.maMatHang = maMatHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuXuatModel [maPhieuXuat=" + maPhieuXuat + ", maMatHang=" + maMatHang + ", soLuong=" + soLuong
				+ ", ghiChu=" + ghiChu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ghiChu, maMatHang, maPhieuXuat, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietPhieuXuatModel other = (ChiTietPhieuXuatModel) obj;
		return Objects.equals(ghiChu, other.ghiChu) && Objects.equals(maMatHang, other.maMatHang)
				&& Objects.equals(maPhieuXuat, other.maPhieuXuat) && soLuong == other.soLuong;
	}

}
