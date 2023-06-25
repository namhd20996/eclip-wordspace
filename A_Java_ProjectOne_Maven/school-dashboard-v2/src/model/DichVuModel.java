package model;

public class DichVuModel {
	private String maDichVu;
	private String maNhanVien;
	private String tenDichVu;
	private double giaDichVu;
	private String ghiChu;

	public DichVuModel() {

	}

	public DichVuModel(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public DichVuModel(String maDichVu, String maNhanVien, String tenDichVu, double giaDichVu, String ghiChu) {
		this.maDichVu = maDichVu;
		this.maNhanVien = maNhanVien;
		this.tenDichVu = tenDichVu;
		this.giaDichVu = giaDichVu;
		this.ghiChu = ghiChu;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public double getGiaDichVu() {
		return giaDichVu;
	}

	public void setGiaDichVu(double giaDichVu) {
		this.giaDichVu = giaDichVu;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "DichVuModel [maDichVu=" + maDichVu + ", maNhanVien=" + maNhanVien + ", tenDichVu=" + tenDichVu
				+ ", giaDichVu=" + giaDichVu + ", ghiChu=" + ghiChu + "]";
	}

}
