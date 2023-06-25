package model;

import java.sql.Date;

public class PhieuChiModel {
	private String maPhieuChi;
	private String maPhong;
	private String maNhanVien;
	private String tenPhieuChi;
	private double tongTien;
	private Date ngayLap;
	private String hinhThuc;
	private String ghiChu;

	public PhieuChiModel() {
	}

	public PhieuChiModel(String maPhieuChi) {
		this.maPhieuChi = maPhieuChi;
	}

	public PhieuChiModel(String maPhieuChi, String maPhong, String maNhanVien, String tenPhieuChi, double tongTien,
			Date ngayLap, String hinhThuc, String ghiChu) {
		this.maPhieuChi = maPhieuChi;
		this.maPhong = maPhong;
		this.maNhanVien = maNhanVien;
		this.tenPhieuChi = tenPhieuChi;
		this.tongTien = tongTien;
		this.ngayLap = ngayLap;
		this.hinhThuc = hinhThuc;
		this.ghiChu = ghiChu;
	}

	public String getMaPhieuChi() {
		return maPhieuChi;
	}

	public void setMaPhieuChi(String maPhieuChi) {
		this.maPhieuChi = maPhieuChi;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenPhieuChi() {
		return tenPhieuChi;
	}

	public void setTenPhieuChi(String tenPhieuChi) {
		this.tenPhieuChi = tenPhieuChi;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public String getHinhThuc() {
		return hinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "PhieuChiModel [maPhieuChi=" + maPhieuChi + ", maPhong=" + maPhong + ", maNhanVien=" + maNhanVien
				+ ", tenPhieuChi=" + tenPhieuChi + ", tongTien=" + tongTien + ", ngayLap=" + ngayLap + ", hinhThuc="
				+ hinhThuc + ", ghiChu=" + ghiChu + "]";
	}

}
