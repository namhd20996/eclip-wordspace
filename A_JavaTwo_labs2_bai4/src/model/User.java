package model;

import java.util.Objects;

public class User {
	private String userName;
	private String passWord;
	private boolean role;
	
	public User() {
		
	}

	public User(String userName, String passWord, boolean role) {
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "User [userName=" + userName + ", passWord=" + passWord + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(passWord, role, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(passWord, other.passWord) && role == other.role
				&& Objects.equals(userName, other.userName);
	}
	
	
}
