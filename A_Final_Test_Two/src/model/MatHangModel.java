package model;

import java.util.Objects;

public class MatHangModel {
	private String maHang;
	private String tenHang;
	private double gia;
	
	public MatHangModel() {
		
	}

	public MatHangModel(String maHang, String tenHang, double gia) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.gia = gia;
	}

	public String getMaHang() {
		return maHang;
	}

	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gia, maHang, tenHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatHangModel other = (MatHangModel) obj;
		return Double.doubleToLongBits(gia) == Double.doubleToLongBits(other.gia)
				&& Objects.equals(maHang, other.maHang) && Objects.equals(tenHang, other.tenHang);
	}

	@Override
	public String toString() {
		return "MatHangModel [maHang=" + maHang + ", tenHang=" + tenHang + ", gia=" + gia + "]";
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
	
	
}
