package model;

import java.sql.Date;

import java.util.Objects;

import lib.XDate;

public class KhoaHocModel {
	private int maKhoaHoc;
	private String maChuyenDe;
	private double hocPhi;
	private int thoiLuong;
	private Date ngayKhaiGiang;
	private String ghiChu;
	private String maNV;
	private Date ngayTao = XDate.now();

	public KhoaHocModel() {

	}

	public KhoaHocModel(int maKhoaHoc, String maChuyenDe, double hocPhi, int thoiLuong, Date ngayKhaiGiang,
			String ghiChu, String maNV, Date ngayTao) {
		this.maKhoaHoc = maKhoaHoc;
		this.maChuyenDe = maChuyenDe;
		this.hocPhi = hocPhi;
		this.thoiLuong = thoiLuong;
		this.ngayKhaiGiang = ngayKhaiGiang;
		this.ghiChu = ghiChu;
		this.maNV = maNV;
		this.ngayTao = ngayTao;
	}

	public KhoaHocModel(String maChuyenDe, double hocPhi, int thoiLuong, Date ngayKhaiGiang, String ghiChu, String maNV,
			Date ngayTao) {
		this.maChuyenDe = maChuyenDe;
		this.hocPhi = hocPhi;
		this.thoiLuong = thoiLuong;
		this.ngayKhaiGiang = ngayKhaiGiang;
		this.ghiChu = ghiChu;
		this.maNV = maNV;
		this.ngayTao = ngayTao;
	}

	public int getMaKhoaHoc() {
		return maKhoaHoc;
	}

	public void setMaKhoaHoc(int maKhoaHoc) {
		this.maKhoaHoc = maKhoaHoc;
	}

	public String getMaChuyenDe() {
		return maChuyenDe;
	}

	public void setMaChuyenDe(String maChuyenDe) {
		this.maChuyenDe = maChuyenDe;
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

	public Date getNgayKhaiGiang() {
		return ngayKhaiGiang;
	}

	public void setNgayKhaiGiang(Date ngayKhaiGiang) {
		this.ngayKhaiGiang = ngayKhaiGiang;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

//	@Override
//	public String toString() {
//		return "KhoaHocModel [maKhoaHoc=" + maKhoaHoc + ", maChuyenDe=" + maChuyenDe + ", hocPhi=" + hocPhi
//				+ ", thoiLuong=" + thoiLuong + ", ngayKhaiGiang=" + ngayKhaiGiang + ", ghiChu=" + ghiChu + ", maNV="
//				+ maNV + ", ngayTao=" + ngayTao + "]";
//	}

	@Override
	public String toString() {
		return this.maChuyenDe + " (" + this.ngayKhaiGiang + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ghiChu, hocPhi, maChuyenDe, maKhoaHoc, maNV, ngayKhaiGiang, ngayTao, thoiLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhoaHocModel other = (KhoaHocModel) obj;
		return Objects.equals(ghiChu, other.ghiChu)
				&& Double.doubleToLongBits(hocPhi) == Double.doubleToLongBits(other.hocPhi)
				&& Objects.equals(maChuyenDe, other.maChuyenDe) && maKhoaHoc == other.maKhoaHoc
				&& Objects.equals(maNV, other.maNV) && Objects.equals(ngayKhaiGiang, other.ngayKhaiGiang)
				&& Objects.equals(ngayTao, other.ngayTao) && thoiLuong == other.thoiLuong;
	}

}
