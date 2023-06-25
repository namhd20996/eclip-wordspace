package model;

import java.util.Arrays;

public class PhongModel {
	private String maPhong;
	private String tenPhong;
	private String maToaNha;
	private String loaiPhong;
	private int tang;
	private int soLuongNguoi;
	private double dienTich;
	private double giaPhong;
	private String moTa;
	private byte[] hinhAnh;
	private String trangThai;
	private String ghiChu;

	public PhongModel() {

	}

	public PhongModel(int tang) {
		this.tang = tang;
	}

	public PhongModel(String trangThai) {
		this.trangThai = trangThai;
	}

	public PhongModel(String maPhong, String tenPhong, String maToaNha, String loaiPhong, int tang, int soLuongNguoi,
			double dienTich, double giaPhong, String moTa, byte[] hinhAnh, String trangThai, String ghiChu) {
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.maToaNha = maToaNha;
		this.loaiPhong = loaiPhong;
		this.tang = tang;
		this.soLuongNguoi = soLuongNguoi;
		this.dienTich = dienTich;
		this.giaPhong = giaPhong;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getMaToaNha() {
		return maToaNha;
	}

	public void setMaToaNha(String maToaNha) {
		this.maToaNha = maToaNha;
	}

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	public int getTang() {
		return tang;
	}

	public void setTang(int tang) {
		this.tang = tang;
	}

	public int getSoLuongNguoi() {
		return soLuongNguoi;
	}

	public void setSoLuongNguoi(int soLuongNguoi) {
		this.soLuongNguoi = soLuongNguoi;
	}

	public double getDienTich() {
		return dienTich;
	}

	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}

	public double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "PhongModel [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", maToaNha=" + maToaNha + ", loaiPhong="
				+ loaiPhong + ", tang=" + tang + ", soLuongNguoi=" + soLuongNguoi + ", dienTich=" + dienTich
				+ ", giaPhong=" + giaPhong + ", moTa=" + moTa + ", hinhAnh=" + Arrays.toString(hinhAnh) + ", trangThai="
				+ trangThai + ", ghiChu=" + ghiChu + "]";
	}

}
