package model;

import java.util.Arrays;
import java.util.Objects;

public class LoaiHangModel {
	private String maLoaiHang;
	private String tenLoaiHang;
	private String ghiChu;
	private byte[] hinhAnh;

	public LoaiHangModel() {

	}

	public LoaiHangModel(String maLoaiHang, String tenLoaiHang, String ghiChu, byte[] hinhAnh) {
		this.maLoaiHang = maLoaiHang;
		this.tenLoaiHang = tenLoaiHang;
		this.ghiChu = ghiChu;
		this.hinhAnh = hinhAnh;
	}

	public String getMaLoaiHang() {
		return maLoaiHang;
	}

	public void setMaLoaiHang(String maLoaiHang) {
		this.maLoaiHang = maLoaiHang;
	}

	public String getTenLoaiHang() {
		return tenLoaiHang;
	}

	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	@Override
	public String toString() {
		return "LoaiHangModel [maLoaiHang=" + maLoaiHang + ", tenLoaiHang=" + tenLoaiHang + ", ghiChu=" + ghiChu
				+ ", hinhAnh=" + Arrays.toString(hinhAnh) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(hinhAnh);
		result = prime * result + Objects.hash(ghiChu, maLoaiHang, tenLoaiHang);
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
		LoaiHangModel other = (LoaiHangModel) obj;
		return Objects.equals(ghiChu, other.ghiChu) && Arrays.equals(hinhAnh, other.hinhAnh)
				&& Objects.equals(maLoaiHang, other.maLoaiHang) && Objects.equals(tenLoaiHang, other.tenLoaiHang);
	}

}
