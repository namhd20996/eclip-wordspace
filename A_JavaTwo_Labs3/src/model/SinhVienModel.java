package model;

import java.util.Objects;

public class SinhVienModel {
	private String hoVaTen;
	private double diem;
	private String nganhHoc;

	public SinhVienModel() {

	}

	public SinhVienModel(String hoVaTen, double diem, String nganhHoc) {
		this.hoVaTen = hoVaTen;
		this.diem = diem;
		this.nganhHoc = nganhHoc;
	}


	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public double getDiem() {
		return diem;
	}

	public void setDiem(double diem) {
		this.diem = diem;
	}

	public String getNganhHoc() {
		return nganhHoc;
	}

	public void setNganhHoc(String nganhHoc) {
		this.nganhHoc = nganhHoc;
	}

	public String getGrade() {
		if (this.diem < 3) {
			return "Kém";
		}
		if (this.diem < 5) {
			return "Yếu";
		}
		if (this.diem < 6.5) {
			return "Trung bình";
		}
		if (this.diem < 7.5) {
			return "Khá";
		}
		if (this.diem < 9) {
			return "Giỏi";
		}
		return "Xuất sắc";
	}

	public boolean isBonus() {
		return this.diem >= 7.5;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diem, hoVaTen, nganhHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVienModel other = (SinhVienModel) obj;
		return Double.doubleToLongBits(diem) == Double.doubleToLongBits(other.diem)
				&& Objects.equals(hoVaTen, other.hoVaTen) && Objects.equals(nganhHoc, other.nganhHoc);
	}

	@Override
	public String toString() {
		return "SinhVienModel [hoVaTen=" + hoVaTen + ", diem=" + diem + ", nganhHoc=" + nganhHoc + "]";
	}

	

}
