package model;

import java.util.Objects;

public class HocVienModel {
	private int maHocVien;
	private int maKhoaHoc;
	private String maNguoiHoc;
	private double diem = -1;

	public HocVienModel() {

	}

	public HocVienModel(int maHocVien, int maKhoaHoc, String maNguoiHoc, double diem) {
		this.maHocVien = maHocVien;
		this.maKhoaHoc = maKhoaHoc;
		this.maNguoiHoc = maNguoiHoc;
		this.diem = diem;
	}

	public HocVienModel(int maKhoaHoc, String maNguoiHoc, double diem) {
		this.maKhoaHoc = maKhoaHoc;
		this.maNguoiHoc = maNguoiHoc;
		this.diem = diem;
	}

	public int getMaHocVien() {
		return maHocVien;
	}

	public void setMaHocVien(int maHocVien) {
		this.maHocVien = maHocVien;
	}

	public int getMaKhoaHoc() {
		return maKhoaHoc;
	}

	public void setMaKhoaHoc(int maKhoaHoc) {
		this.maKhoaHoc = maKhoaHoc;
	}

	public String getMaNguoiHoc() {
		return maNguoiHoc;
	}

	public void setMaNguoiHoc(String maNguoiHoc) {
		this.maNguoiHoc = maNguoiHoc;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return "HocVienModel [maHocVien=" + maHocVien + ", maKhoaHoc=" + maKhoaHoc + ", maNguoiHoc=" + maNguoiHoc
				+ ", diem=" + diem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diem, maHocVien, maKhoaHoc, maNguoiHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HocVienModel other = (HocVienModel) obj;
		return Double.doubleToLongBits(diem) == Double.doubleToLongBits(other.diem) && maHocVien == other.maHocVien
				&& maKhoaHoc == other.maKhoaHoc && Objects.equals(maNguoiHoc, other.maNguoiHoc);
	}

}
