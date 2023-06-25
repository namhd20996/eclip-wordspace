package model;

import java.sql.Date;

public class ChuyenPhongModel {
	private String maChuyenPhong;
	private String maPhongCu;
	private String maPhongMoi;
	private String maNhanVien;
	private String soCCCDNT;
	private Date ngayChuyen;
	private String ghiChu;

	public ChuyenPhongModel() {

	}

	public ChuyenPhongModel(String maChuyenPhong) {
		this.maChuyenPhong = maChuyenPhong;
	}

	public ChuyenPhongModel(String maChuyenPhong, String maPhongCu, String maPhongMoi, String maNhanVien,
			String soCCCDNT, Date ngayChuyen, String ghiChu) {
		this.maChuyenPhong = maChuyenPhong;
		this.maPhongCu = maPhongCu;
		this.maPhongMoi = maPhongMoi;
		this.maNhanVien = maNhanVien;
		this.soCCCDNT = soCCCDNT;
		this.ngayChuyen = ngayChuyen;
		this.ghiChu = ghiChu;
	}

	public String getMaChuyenPhong() {
		return maChuyenPhong;
	}

	public void setMaChuyenPhong(String maChuyenPhong) {
		this.maChuyenPhong = maChuyenPhong;
	}

	public String getMaPhongCu() {
		return maPhongCu;
	}

	public void setMaPhongCu(String maPhongCu) {
		this.maPhongCu = maPhongCu;
	}

	public String getMaPhongMoi() {
		return maPhongMoi;
	}

	public void setMaPhongMoi(String maPhongMoi) {
		this.maPhongMoi = maPhongMoi;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getSoCCCDNT() {
		return soCCCDNT;
	}

	public void setSoCCCDNT(String soCCCDNT) {
		this.soCCCDNT = soCCCDNT;
	}

	public Date getNgayChuyen() {
		return ngayChuyen;
	}

	public void setNgayChuyen(Date ngayChuyen) {
		this.ngayChuyen = ngayChuyen;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "ChuyenPhongModel [maChuyenPhong=" + maChuyenPhong + ", maPhongCu=" + maPhongCu + ", maPhongMoi="
				+ maPhongMoi + ", maNhanVien=" + maNhanVien + ", soCCCDNT=" + soCCCDNT + ", ngayChuyen=" + ngayChuyen
				+ ", ghiChu=" + ghiChu + "]";
	}

}
