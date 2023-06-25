package model;

public class ChiTietDichVuModel {
	private String maPhong;
	private String maDichVu;
	private String ghiChu;

	public ChiTietDichVuModel() {

	}

	public ChiTietDichVuModel(String maPhong) {
		this.maPhong = maPhong;
	}

	public ChiTietDichVuModel(String maPhong, String maDichVu, String ghiChu) {
		this.maPhong = maPhong;
		this.maDichVu = maDichVu;
		this.ghiChu = ghiChu;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Override
	public String toString() {
		return "DichVuModel [maPhong=" + maPhong + ", maDichVu=" + maDichVu + ", ghiChu=" + ghiChu + "]";
	}

}
