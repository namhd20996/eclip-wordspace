package model;

import java.util.Objects;

public class GradeModel {
	private int id;
	private String maSV;
	private double tiengAnh;
	private double tinHoc;
	private double GDTC;

	public GradeModel() {

	}

	public GradeModel(int id, String maSV, double tiengAnh, double tinHoc, double gDTC) {
		this.id = id;
		this.maSV = maSV;
		this.tiengAnh = tiengAnh;
		this.tinHoc = tinHoc;
		GDTC = gDTC;
	}

	public GradeModel(String maSV, double tiengAnh, double tinHoc, double gDTC) {
		this.maSV = maSV;
		this.tiengAnh = tiengAnh;
		this.tinHoc = tinHoc;
		GDTC = gDTC;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public double getTiengAnh() {
		return tiengAnh;
	}

	public void setTiengAnh(double tiengAnh) {
		this.tiengAnh = tiengAnh;
	}

	public double getTinHoc() {
		return tinHoc;
	}

	public void setTinHoc(double tinHoc) {
		this.tinHoc = tinHoc;
	}

	public double getGDTC() {
		return GDTC;
	}

	public void setGDTC(double gDTC) {
		GDTC = gDTC;
	}

	@Override
	public String toString() {
		return "GradeModel [id=" + id + ", maSV=" + maSV + ", tiengAnh=" + tiengAnh + ", tinHoc=" + tinHoc + ", GDTC="
				+ GDTC + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(GDTC, id, maSV, tiengAnh, tinHoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GradeModel other = (GradeModel) obj;
		return Double.doubleToLongBits(GDTC) == Double.doubleToLongBits(other.GDTC) && id == other.id
				&& Objects.equals(maSV, other.maSV)
				&& Double.doubleToLongBits(tiengAnh) == Double.doubleToLongBits(other.tiengAnh)
				&& Double.doubleToLongBits(tinHoc) == Double.doubleToLongBits(other.tinHoc);
	}

}
