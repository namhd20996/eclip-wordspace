package model;

import java.sql.Date;
import java.util.Objects;

import lib.XDate;

public class NguoiHocModel {
	private String maNguoiHoc;
	private String tenNguoiHoc;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String dienThoai;
	private String email;
	private String ghiChu;
	private String maNV;
	private Date ngayDangKy = XDate.now();

	public NguoiHocModel() {

	}

	public NguoiHocModel(String maNguoiHoc, String tenNguoiHoc, Date ngaySinh, boolean gioiTinh, String dienThoai,
			String email, String ghiChu, String maNV, Date ngayDangKy) {
		this.maNguoiHoc = maNguoiHoc;
		this.tenNguoiHoc = tenNguoiHoc;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.dienThoai = dienThoai;
		this.email = email;
		this.ghiChu = ghiChu;
		this.maNV = maNV;
		this.ngayDangKy = ngayDangKy;
	}

	public String getMaNguoiHoc() {
		return maNguoiHoc;
	}

	public void setMaNguoiHoc(String maNguoiHoc) {
		this.maNguoiHoc = maNguoiHoc;
	}

	public String getTenNguoiHoc() {
		return tenNguoiHoc;
	}

	public void setTenNguoiHoc(String tenNguoiHoc) {
		this.tenNguoiHoc = tenNguoiHoc;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	@Override
	public String toString() {
		return "NguoiHocModel [maNguoiHoc=" + maNguoiHoc + ", tenNguoiHoc=" + tenNguoiHoc + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", dienThoai=" + dienThoai + ", email=" + email + ", ghiChu=" + ghiChu
				+ ", maNV=" + maNV + ", ngayDangKy=" + ngayDangKy + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dienThoai, email, ghiChu, gioiTinh, maNV, maNguoiHoc, ngayDangKy, ngaySinh, tenNguoiHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NguoiHocModel other = (NguoiHocModel) obj;
		return Objects.equals(dienThoai, other.dienThoai) && Objects.equals(email, other.email)
				&& Objects.equals(ghiChu, other.ghiChu) && gioiTinh == other.gioiTinh
				&& Objects.equals(maNV, other.maNV) && Objects.equals(maNguoiHoc, other.maNguoiHoc)
				&& Objects.equals(ngayDangKy, other.ngayDangKy) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(tenNguoiHoc, other.tenNguoiHoc);
	}

}
