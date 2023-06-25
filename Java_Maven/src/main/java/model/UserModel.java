package model;

import java.util.Objects;

public class UserModel {
	private String user;
	private String passWord;
	private boolean role;

	public UserModel() {

	}

	public UserModel(String user, String passWord, boolean role) {
		this.user = user;
		this.passWord = passWord;
		this.role = role;
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

	@Override
	public String toString() {
		return "UserModel [user=" + user + ", passWord=" + passWord + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(passWord, role, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		return Objects.equals(passWord, other.passWord) && role == other.role && Objects.equals(user, other.user);
	}

}
