package model;

public class NhanVienModel {
	private String maNhanVien;
	private String matKhau;
	private String tenNhanVien;
	private String gioiTinh;
	private boolean vaiTro;

	public NhanVienModel() {

	}

	public NhanVienModel(String maNhanVien, String matKhau, String tenNhanVien, String gioiTinh, boolean vaiTro) {
		this.maNhanVien = maNhanVien;
		this.matKhau = matKhau;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.vaiTro = vaiTro;
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

	@Override
	public String toString() {
		return "NhanVienModel [maNhanVien=" + maNhanVien + ", matKhau=" + matKhau + ", tenNhanVien=" + tenNhanVien
				+ ", gioiTinh=" + gioiTinh + ", vaiTro=" + vaiTro + "]";
	}

}
