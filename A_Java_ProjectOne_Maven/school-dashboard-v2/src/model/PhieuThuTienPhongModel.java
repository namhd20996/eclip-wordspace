package model;

import java.sql.Date;

public class PhieuThuTienPhongModel {
	private String maPhieuTTP;
	private String maPhong;
	private String maNhanVien;
	private double donGiaPhong;
	private Date thangThu;
	private double soDienTruoc;
	private double soNuocTruoc;
	private double soDien;
	private double soNuoc;
	private double donGiaDien;
	private double donGiaNuoc;
	private double thanhTienDien;
	private double thanhTienNuoc;
	private double tienDichVu;
	private double thanhTien;
	private String ghiChu;

	public PhieuThuTienPhongModel() {

	}

	public PhieuThuTienPhongModel(String maPhieuTTP) {
		this.maPhieuTTP = maPhieuTTP;
	}

	public PhieuThuTienPhongModel(String maPhieuTTP, String maPhong, String maNhanVien, double donGiaPhong,
			Date thangThu, double soDienTruoc, double soNuocTruoc, double soDien, double soNuoc, double donGiaDien,
			double donGiaNuoc, double thanhTienDien, double thanhTienNuoc, double tienDichVu, double thanhTien,
			String ghiChu) {
		this.maPhieuTTP = maPhieuTTP;
		this.maPhong = maPhong;
		this.maNhanVien = maNhanVien;
		this.donGiaPhong = donGiaPhong;
		this.thangThu = thangThu;
		this.soDienTruoc = soDienTruoc;
		this.soNuocTruoc = soNuocTruoc;
		this.soDien = soDien;
		this.soNuoc = soNuoc;
		this.donGiaDien = donGiaDien;
		this.donGiaNuoc = donGiaNuoc;
		this.thanhTienDien = thanhTienDien;
		this.thanhTienNuoc = thanhTienNuoc;
		this.tienDichVu = tienDichVu;
		this.thanhTien = thanhTien;
		this.ghiChu = ghiChu;
	}

	public String getMaPhieuTTP() {
		return maPhieuTTP;
	}

	public void setMaPhieuTTP(String maPhieuTTP) {
		this.maPhieuTTP = maPhieuTTP;
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

	public double getDonGiaPhong() {
		return donGiaPhong;
	}

	public void setDonGiaPhong(double donGiaPhong) {
		this.donGiaPhong = donGiaPhong;
	}

	public Date getThangThu() {
		return thangThu;
	}

	public void setThangThu(Date thangThu) {
		this.thangThu = thangThu;
	}

	public double getSoDienTruoc() {
		return soDienTruoc;
	}

	public void setSoDienTruoc(double soDienTruoc) {
		this.soDienTruoc = soDienTruoc;
	}

	public double getSoNuocTruoc() {
		return soNuocTruoc;
	}

	public void setSoNuocTruoc(double soNuocTruoc) {
		this.soNuocTruoc = soNuocTruoc;
	}

	public double getSoDien() {
		return soDien;
	}

	public void setSoDien(double soDien) {
		this.soDien = soDien;
	}

	public double getSoNuoc() {
		return soNuoc;
	}

	public void setSoNuoc(double soNuoc) {
		this.soNuoc = soNuoc;
	}

	public double getDonGiaDien() {
		return donGiaDien;
	}

	public void setDonGiaDien(double donGiaDien) {
		this.donGiaDien = donGiaDien;
	}

	public double getDonGiaNuoc() {
		return donGiaNuoc;
	}

	public void setDonGiaNuoc(double donGiaNuoc) {
		this.donGiaNuoc = donGiaNuoc;
	}

	public double getThanhTienDien() {
		return thanhTienDien;
	}

	public void setThanhTienDien(double thanhTienDien) {
		this.thanhTienDien = thanhTienDien;
	}

	public double getThanhTienNuoc() {
		return thanhTienNuoc;
	}

	public void setThanhTienNuoc(double thanhTienNuoc) {
		this.thanhTienNuoc = thanhTienNuoc;
	}

	public double getTienDichVu() {
		return tienDichVu;
	}

	public void setTienDichVu(double tienDichVu) {
		this.tienDichVu = tienDichVu;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "PhieuThuTienPhongModel [maPhieuTTP=" + maPhieuTTP + ", maPhong=" + maPhong + ", maNhanVien="
				+ maNhanVien + ", donGiaPhong=" + donGiaPhong + ", thangThu=" + thangThu + ", soDienTruoc="
				+ soDienTruoc + ", soNuocTruoc=" + soNuocTruoc + ", soDien=" + soDien + ", soNuoc=" + soNuoc
				+ ", donGiaDien=" + donGiaDien + ", donGiaNuoc=" + donGiaNuoc + ", thanhTienDien=" + thanhTienDien
				+ ", thanhTienNuoc=" + thanhTienNuoc + ", tienDichVu=" + tienDichVu + ", thanhTien=" + thanhTien
				+ ", ghiChu=" + ghiChu + "]";
	}

}
