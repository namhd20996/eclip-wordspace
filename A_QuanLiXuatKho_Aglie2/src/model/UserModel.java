package model;

import java.sql.Date;
import java.util.Objects;

public class UserModel {
	private String user;
	private String passWord;
	private boolean role;
	private String email;
	private String maXacThuc;
	private Date thoiGianHieuLucMaXacThuc;
	private boolean trangThaiXacThuc;

	public UserModel() {

	}

	public UserModel(String user, String passWord, boolean role) {
		this.user = user;
		this.passWord = passWord;
		this.role = role;
	}

	public UserModel(String user, String passWord, boolean role, String email) {
		this.user = user;
		this.passWord = passWord;
		this.role = role;
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Date getThoiGianHieuLucMaXacThuc() {
		return thoiGianHieuLucMaXacThuc;
	}

	public void setThoiGianHieuLucMaXacThuc(Date thoiGianHieuLucMaXacThuc) {
		this.thoiGianHieuLucMaXacThuc = thoiGianHieuLucMaXacThuc;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	@Override
	public String toString() {
		return "UserModel [user=" + user + ", passWord=" + passWord + ", role=" + role + ", email=" + email
				+ ", maXacThuc=" + maXacThuc + ", thoiGianHieuLucMaXacThuc=" + thoiGianHieuLucMaXacThuc
				+ ", trangThaiXacThuc=" + trangThaiXacThuc + "]";
	}

}
