package model;

public class User {
	private String user_Name;
	private String pass_Word;
	private String hoVaTen;

	public User() {
		super();
	}

	public User(String user_Name, String pass_Word, String hoVaTen) {
		super();
		this.user_Name = user_Name;
		this.pass_Word = pass_Word;
		this.hoVaTen = hoVaTen;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getPass_Word() {
		return pass_Word;
	}

	public void setPass_Word(String pass_Word) {
		this.pass_Word = pass_Word;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	@Override
	public String toString() {
		return "User [user_Name=" + user_Name + ", pass_Word=" + pass_Word + ", hoVaTen=" + hoVaTen + "]";
	}

}
