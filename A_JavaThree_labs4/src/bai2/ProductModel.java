package bai2;

import java.util.Objects;

public class ProductModel {
	private String maSP;
	private String tenSP;
	private String dVT;
	private double donGia;
	private String nCungCap;
	
	public ProductModel() {
		
	}

	public ProductModel(String maSP, String tenSP, String dVT, double donGia, String nCungCap) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.dVT = dVT;
		this.donGia = donGia;
		this.nCungCap = nCungCap;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getdVT() {
		return dVT;
	}

	public void setdVT(String dVT) {
		this.dVT = dVT;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getnCungCap() {
		return nCungCap;
	}

	public void setnCungCap(String nCungCap) {
		this.nCungCap = nCungCap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dVT, donGia, maSP, nCungCap, tenSP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductModel other = (ProductModel) obj;
		return Objects.equals(dVT, other.dVT)
				&& Double.doubleToLongBits(donGia) == Double.doubleToLongBits(other.donGia)
				&& Objects.equals(maSP, other.maSP) && Objects.equals(nCungCap, other.nCungCap)
				&& Objects.equals(tenSP, other.tenSP);
	}

	@Override
	public String toString() {
		return "ProductModel [maSP=" + maSP + ", tenSP=" + tenSP + ", dVT=" + dVT + ", donGia=" + donGia + ", nCungCap="
				+ nCungCap + "]";
	}
	
	
}
