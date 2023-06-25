package model;

import java.util.Arrays;

public class ToaNhaModel {
	private String maToaNha;
	private String tenToaNha;
	private byte[] hinhAnh;
	private int soPhong;
	private String phuong;
	private String quan;
	private String tinh;
	private String ghiChu;

	public ToaNhaModel() {

	}

	public ToaNhaModel(String maToaNha) {
		this.maToaNha = maToaNha;
	}

	public ToaNhaModel(String maToaNha, String tenToaNha, byte[] hinhAnh, int soPhong, String phuong, String quan,
			String tinh, String ghiChu) {
		this.maToaNha = maToaNha;
		this.tenToaNha = tenToaNha;
		this.hinhAnh = hinhAnh;
		this.soPhong = soPhong;
		this.phuong = phuong;
		this.quan = quan;
		this.tinh = tinh;
		this.ghiChu = ghiChu;
	}

	public String getMaToaNha() {
		return maToaNha;
	}

	public void setMaToaNha(String maToaNha) {
		this.maToaNha = maToaNha;
	}

	public String getTenToaNha() {
		return tenToaNha;
	}

	public void setTenToaNha(String tenToaNha) {
		this.tenToaNha = tenToaNha;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "ToaNhaModel [maToaNha=" + maToaNha + ", tenToaNha=" + tenToaNha + ", hinhAnh="
				+ Arrays.toString(hinhAnh) + ", soPhong=" + soPhong + ", phuong=" + phuong + ", quan=" + quan
				+ ", tinh=" + tinh + ", ghiChu=" + ghiChu + "]";
	}

}
