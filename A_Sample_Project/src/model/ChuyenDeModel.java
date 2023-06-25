package model;

import java.util.Objects;

public class ChuyenDeModel {
	private String maChuyenDe;
	private String tenChuyenDe;
	private double hocPhi;
	private int thoiLuong;
	private String hinhLogo;
	private String moTa;

	public ChuyenDeModel() {

	}

	public ChuyenDeModel(String maChuyenDe, String tenChuyenDe, double hocPhi, int thoiLuong, String hinhLogo,
			String moTa) {
		this.maChuyenDe = maChuyenDe;
		this.tenChuyenDe = tenChuyenDe;
		this.hocPhi = hocPhi;
		this.thoiLuong = thoiLuong;
		this.hinhLogo = hinhLogo;
		this.moTa = moTa;
	}

	public String getMaChuyenDe() {
		return maChuyenDe;
	}

	public void setMaChuyenDe(String maChuyenDe) {
		this.maChuyenDe = maChuyenDe;
	}

	public String getTenChuyenDe() {
		return tenChuyenDe;
	}

	public void setTenChuyenDe(String tenChuyenDe) {
		this.tenChuyenDe = tenChuyenDe;
	}

	public double getHocPhi() {
		return hocPhi;
	}

	public void setHocPhi(double hocPhi) {
		this.hocPhi = hocPhi;
	}

	public int getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(int thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public String getHinhLogo() {
		return hinhLogo;
	}

	public void setHinhLogo(String hinhLogo) {
		this.hinhLogo = hinhLogo;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "ChuyenDeModel [maChuyenDe=" + maChuyenDe + ", tenChuyenDe=" + tenChuyenDe + ", hocPhi=" + hocPhi
				+ ", thoiLuong=" + thoiLuong + ", hinhLogo=" + hinhLogo + ", moTa=" + moTa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hinhLogo, hocPhi, maChuyenDe, moTa, tenChuyenDe, thoiLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChuyenDeModel other = (ChuyenDeModel) obj;
		return Objects.equals(hinhLogo, other.hinhLogo)
				&& Double.doubleToLongBits(hocPhi) == Double.doubleToLongBits(other.hocPhi)
				&& Objects.equals(maChuyenDe, other.maChuyenDe) && Objects.equals(moTa, other.moTa)
				&& Objects.equals(tenChuyenDe, other.tenChuyenDe) && thoiLuong == other.thoiLuong;
	}

}
