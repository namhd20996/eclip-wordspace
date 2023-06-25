package model;

import java.io.Serializable;
import java.util.Objects;

public class NhanVienModel implements Serializable{
	private String maNhanVien;
	private String hoVaTen;
	private int tuoi;
	private String email;
	private double luong;
	
	
	public NhanVienModel() {
	}


	public NhanVienModel(String maNhanVien, String hoVaTen, int tuoi, String email, double luong) {
		this.maNhanVien = maNhanVien;
		this.hoVaTen = hoVaTen;
		this.tuoi = tuoi;
		this.email = email;
		this.luong = luong;
	}


	public String getMaNhanVien() {
		return maNhanVien;
	}


	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public String getHoVaTen() {
		return hoVaTen;
	}


	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}


	public int getTuoi() {
		return tuoi;
	}


	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getLuong() {
		return luong;
	}


	public void setLuong(double luong) {
		this.luong = luong;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, hoVaTen, luong, maNhanVien, tuoi);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVienModel other = (NhanVienModel) obj;
		return Objects.equals(email, other.email) && Objects.equals(hoVaTen, other.hoVaTen)
				&& Double.doubleToLongBits(luong) == Double.doubleToLongBits(other.luong)
				&& Objects.equals(maNhanVien, other.maNhanVien) && tuoi == other.tuoi;
	}


	@Override
	public String toString() {
		return "NhanVienModel [maNhanVien=" + maNhanVien + ", hoVaTen=" + hoVaTen + ", tuoi=" + tuoi + ", email="
				+ email + ", luong=" + luong + "]";
	}
	
	
}
