package model;

import java.sql.Date;
import java.sql.Timestamp;

public class NhanVienModel {
	private String maNhanVien;
	private String matKhau;
	private String tenNhanVien;
	private String gioiTinh;
	private boolean vaiTro;
	private String email;
	private String maXacThuc;
	private Timestamp thoiGianHieuLucMaXacThuc;
	private boolean trangThaiXacThuc;
	private byte[] hinhAnh;

	public NhanVienModel() {

	}

	public NhanVienModel(String maNhanVien, String matKhau, boolean vaiTro, String email) {
		this.maNhanVien = maNhanVien;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
		this.email = email;
	}

	public NhanVienModel(String maNhanVien, String matKhau, String tenNhanVien, String gioiTinh, boolean vaiTro,
			byte[] hinhAnh) {
		this.maNhanVien = maNhanVien;
		this.matKhau = matKhau;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.vaiTro = vaiTro;
		this.hinhAnh = hinhAnh;
	}

	public NhanVienModel(String maNhanVien, String matKhau, String tenNhanVien, String gioiTinh, boolean vaiTro,
			String email, String maXacThuc, Timestamp thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc) {
		this.maNhanVien = maNhanVien;
		this.matKhau = matKhau;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.vaiTro = vaiTro;
		this.email = email;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public NhanVienModel(String maNhanVien, String matKhau, String tenNhanVien, String gioiTinh, boolean vaiTro,
			String email, String maXacThuc, Timestamp thoiGianHieuLucMaXacThuc, boolean trangThaiXacThuc,
			byte[] hinhAnh) {
		this.maNhanVien = maNhanVien;
		this.matKhau = matKhau;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.vaiTro = vaiTro;
		this.email = email;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
		this.hinhAnh = hinhAnh;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public boolean isVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(boolean vaiTro) {
		this.vaiTro = vaiTro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Timestamp getThoiGianHieuLucMaXacThuc() {
		return thoiGianHieuLucMaXacThuc;
	}

	public void setThoiGianHieuLucMaXacThuc(Timestamp thoiGianHieuLucMaXacThuc) {
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	@Override
	public String toString() {
		return "NhanVienModel [maNhanVien=" + maNhanVien + ", matKhau=" + matKhau + ", tenNhanVien=" + tenNhanVien
				+ ", gioiTinh=" + gioiTinh + ", vaiTro=" + vaiTro + ", email=" + email + ", maXacThuc=" + maXacThuc
				+ ", thoiGianHieuLucMaXacThuc=" + thoiGianHieuLucMaXacThuc + ", trangThaiXacThuc=" + trangThaiXacThuc
				+ "]";
	}

}
