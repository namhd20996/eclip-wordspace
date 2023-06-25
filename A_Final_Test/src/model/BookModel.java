package model;

import java.io.Serializable;
import java.util.Objects;

public class BookModel implements Serializable{
	private String maSach;
	private String tenSach;
	private int namXuatBan;

	public BookModel() {

	}

	public BookModel(String maSach, String tenSach, int namXuatBan) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.namXuatBan = namXuatBan;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	@Override
	public String toString() {
		return "BookModel [maSach=" + maSach + ", tenSach=" + tenSach + ", namXuatBan=" + namXuatBan + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach, namXuatBan, tenSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookModel other = (BookModel) obj;
		return Objects.equals(maSach, other.maSach) && namXuatBan == other.namXuatBan
				&& Objects.equals(tenSach, other.tenSach);
	}

}
