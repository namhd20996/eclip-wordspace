package model;

import java.sql.Date;
import java.util.Objects;

public class PhieuXuatKhoModel {
	private String maPhieuXuat;
	private Date ngayLap;
	private Date ngayXuat;
	private String maCuaHang;
	private String user;

	public PhieuXuatKhoModel() {

	}

	public PhieuXuatKhoModel(String maPhieuXuat, Date ngayLap, Date ngayXuat, String maCuaHang, String user) {
		this.maPhieuXuat = maPhieuXuat;
		this.ngayLap = ngayLap;
		this.ngayXuat = ngayXuat;
		this.maCuaHang = maCuaHang;
		this.user = user;
	}

	public String getMaPhieuXuat() {
		return maPhieuXuat;
	}

	public void setMaPhieuXuat(String maPhieuXuat) {
		this.maPhieuXuat = maPhieuXuat;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Date getNgayXuat() {
		return ngayXuat;
	}

	public void setNgayXuat(Date ngayXuat) {
		this.ngayXuat = ngayXuat;
	}

	public String getMaCuaHang() {
		return maCuaHang;
	}

	public void setMaCuaHang(String maCuaHang) {
		this.maCuaHang = maCuaHang;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PhieuXuatKhoModel [maPhieuXuat=" + maPhieuXuat + ", ngayLap=" + ngayLap + ", ngayXuat=" + ngayXuat
				+ ", maCuaHang=" + maCuaHang + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maCuaHang, maPhieuXuat, ngayLap, ngayXuat, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuXuatKhoModel other = (PhieuXuatKhoModel) obj;
		return Objects.equals(maCuaHang, other.maCuaHang) && Objects.equals(maPhieuXuat, other.maPhieuXuat)
				&& Objects.equals(ngayLap, other.ngayLap) && Objects.equals(ngayXuat, other.ngayXuat)
				&& Objects.equals(user, other.user);
	}

}
