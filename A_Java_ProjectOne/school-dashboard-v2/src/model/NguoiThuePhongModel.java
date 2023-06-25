package model;

import java.sql.Date;

import java.util.Arrays;

public class NguoiThuePhongModel {
	private String maNguoiThue;
	private String soCCCDNT;
	private String maPhong;
	private String maNhanVien;
	private byte[] hinhNT;
	private byte[] matTruocCC;
	private byte[] matSauCC;
	private String hoTen;
	private Date ngaySinh;
	private String gioiTinh;
	private String noiSinh;
	private String phuong_Xa;
	private String quan_Huyen;
	private String tinh_TP;
	private String noiDangKyHK;
	private String soDienThoai;
	private String email;
	private Date ngayCapCC;
	private String noiCap;
	private Date ngayBatDauThue;
	private Date ngayHetHanThue;
	private double tienCoc;
	private String ghiChu;

	public NguoiThuePhongModel() {

	}

	public NguoiThuePhongModel(String maNguoiThue) {
		this.maNguoiThue = maNguoiThue;
	}

	public NguoiThuePhongModel(String maNguoiThue, String soCCCDNT, String maPhong, String maNhanVien, byte[] hinhNT,
			byte[] matTruocCC, byte[] matSauCC, String hoTen, Date ngaySinh, String gioiTinh, String noiSinh,
			String phuong_Xa, String quan_Huyen, String tinh_TP, String noiDangKyHK, String soDienThoai, String email,
			Date ngayCapCC, String noiCap, Date ngayBatDauThue, Date ngayHetHanThue, double tienCoc, String ghiChu) {

		this.maNguoiThue = maNguoiThue;
		this.soCCCDNT = soCCCDNT;
		this.maPhong = maPhong;
		this.maNhanVien = maNhanVien;
		this.hinhNT = hinhNT;
		this.matTruocCC = matTruocCC;
		this.matSauCC = matSauCC;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.noiSinh = noiSinh;
		this.phuong_Xa = phuong_Xa;
		this.quan_Huyen = quan_Huyen;
		this.tinh_TP = tinh_TP;
		this.noiDangKyHK = noiDangKyHK;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.ngayCapCC = ngayCapCC;
		this.noiCap = noiCap;
		this.ngayBatDauThue = ngayBatDauThue;
		this.ngayHetHanThue = ngayHetHanThue;
		this.tienCoc = tienCoc;
		this.ghiChu = ghiChu;
	}

	public String getMaNguoiThue() {
		return maNguoiThue;
	}

	public void setMaNguoiThue(String maNguoiThue) {
		this.maNguoiThue = maNguoiThue;
	}

	public String getSoCCCDNT() {
		return soCCCDNT;
	}

	public void setSoCCCDNT(String soCCCDNT) {
		this.soCCCDNT = soCCCDNT;
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

	public byte[] getHinhNT() {
		return hinhNT;
	}

	public void setHinhNT(byte[] hinhNT) {
		this.hinhNT = hinhNT;
	}

	public byte[] getMatTruocCC() {
		return matTruocCC;
	}

	public void setMatTruocCC(byte[] matTruocCC) {
		this.matTruocCC = matTruocCC;
	}

	public byte[] getMatSauCC() {
		return matSauCC;
	}

	public void setMatSauCC(byte[] matSauCC) {
		this.matSauCC = matSauCC;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getPhuong_Xa() {
		return phuong_Xa;
	}

	public void setPhuong_Xa(String phuong_Xa) {
		this.phuong_Xa = phuong_Xa;
	}

	public String getQuan_Huyen() {
		return quan_Huyen;
	}

	public void setQuan_Huyen(String quan_Huyen) {
		this.quan_Huyen = quan_Huyen;
	}

	public String getTinh_TP() {
		return tinh_TP;
	}

	public void setTinh_TP(String tinh_TP) {
		this.tinh_TP = tinh_TP;
	}

	public String getNoiDangKyHK() {
		return noiDangKyHK;
	}

	public void setNoiDangKyHK(String noiDangKyHK) {
		this.noiDangKyHK = noiDangKyHK;
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

	public Date getNgayCapCC() {
		return ngayCapCC;
	}

	public void setNgayCapCC(Date ngayCapCC) {
		this.ngayCapCC = ngayCapCC;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

	public Date getNgayBatDauThue() {
		return ngayBatDauThue;
	}

	public void setNgayBatDauThue(Date ngayBatDauThue) {
		this.ngayBatDauThue = ngayBatDauThue;
	}

	public Date getNgayHetHanThue() {
		return ngayHetHanThue;
	}

	public void setNgayHetHanThue(Date ngayHetHanThue) {
		this.ngayHetHanThue = ngayHetHanThue;
	}

	public double getTienCoc() {
		return tienCoc;
	}

	public void setTienCoc(double tienCoc) {
		this.tienCoc = tienCoc;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "NguoiThuePhongModel [maNguoiThue=" + maNguoiThue + ", soCCCDNT=" + soCCCDNT + ", maPhong=" + maPhong
				+ ", maNhanVien=" + maNhanVien + ", hinhNT=" + Arrays.toString(hinhNT) + ", matTruocCC="
				+ Arrays.toString(matTruocCC) + ", matSauCC=" + Arrays.toString(matSauCC) + ", hoTen=" + hoTen
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", noiSinh=" + noiSinh + ", phuong_Xa="
				+ phuong_Xa + ", quan_Huyen=" + quan_Huyen + ", tinh_TP=" + tinh_TP + ", noiDangKyHK=" + noiDangKyHK
				+ ", soDienThoai=" + soDienThoai + ", email=" + email + ", ngayCapCC=" + ngayCapCC + ", noiCap="
				+ noiCap + ", ngayBatDauThue=" + ngayBatDauThue + ", ngayHetHanThue=" + ngayHetHanThue + ", tienCoc="
				+ tienCoc + ", ghiChu=" + ghiChu + "]";
	}

}
