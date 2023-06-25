package labs1_bai3;

public class LoginModel {
	private String passWord;
	private String confirm;
	
	public LoginModel() {
		
	}

	public LoginModel(String passWord, String confirm) {
		this.passWord = passWord;
		this.confirm = confirm;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
}
