package model;

import java.sql.Date;

public class LichSuPhongThueModel {
	private String maNguoiThue;
	private String maPhong;
	private String soCCCDNT;
	private Date ngayThue;
	private Date ngayTraPhong;

	public LichSuPhongThueModel() {

	}

	public LichSuPhongThueModel(String maNguoiThue) {
		this.maNguoiThue = maNguoiThue;
	}

	public LichSuPhongThueModel(String maNguoiThue, String maPhong, String soCCCDNT, Date ngayThue, Date ngayTraPhong) {
		this.maNguoiThue = maNguoiThue;
		this.maPhong = maPhong;
		this.soCCCDNT = soCCCDNT;
		this.ngayThue = ngayThue;
		this.ngayTraPhong = ngayTraPhong;
	}

	public String getMaNguoiThue() {
		return maNguoiThue;
	}

	public void setMaNguoiThue(String maNguoiThue) {
		this.maNguoiThue = maNguoiThue;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getSoCCCDNT() {
		return soCCCDNT;
	}

	public void setSoCCCDNT(String soCCCDNT) {
		this.soCCCDNT = soCCCDNT;
	}

	public Date getNgayThue() {
		return ngayThue;
	}

	public void setNgayThue(Date ngayThue) {
		this.ngayThue = ngayThue;
	}

	public Date getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(Date ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	@Override
	public String toString() {
		return "LichSuPhongThueModel [maNguoiThue=" + maNguoiThue + ", maPhong=" + maPhong + ", soCCCDNT=" + soCCCDNT
				+ ", ngayThue=" + ngayThue + ", ngayTraPhong=" + ngayTraPhong + "]";
	}

}
