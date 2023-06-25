package model;

import java.util.Objects;

public class NhanVienModel {
	private String maNV;
	private String passWord;
	private String name;
	private boolean role;

	public NhanVienModel() {

	}

	public NhanVienModel(String maNV, String passWord, String name, boolean role) {
		this.maNV = maNV;
		this.passWord = passWord;
		this.name = name;
		this.role = role;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "NhanVienModel [maNV=" + maNV + ", passWord=" + passWord + ", name=" + name + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV, name, passWord, role);
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
		return Objects.equals(maNV, other.maNV) && Objects.equals(name, other.name)
				&& Objects.equals(passWord, other.passWord) && role == other.role;
	}

}
