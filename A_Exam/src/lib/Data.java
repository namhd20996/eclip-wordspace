package lib;

public class Data {

	public static Boolean isEmail(String str) {
		String pattern = "^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com$";
		return str.matches(pattern);
	}

	public static Boolean isHoTen(String str) {
		String pattern = "^[a-zA-Z\\s]+$";
		return str.matches(pattern);
	}

	public static Boolean isSo(String str) {
		String pattern = "^(\\d)+$";
		return str.matches(pattern);
	}

	public static Boolean isID(String str) {
		String pattern = "^[a-zA-Z\\d]+$";
		return str.matches(pattern);
	}

	public static Boolean isMaNguoiHoc(String str) {
		String pattern = "^[a-zA-Z\\d]{7,7}+$";
		return str.matches(pattern);
	}

	public static Boolean isMaChuyenDe(String str) {
		String pattern = "^[a-zA-Z\\d]{5,5}+$";
		return str.matches(pattern);
	}

	public static Boolean isSDT(String str) {
		String pattern = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
		return str.matches(pattern);
	}

	public static Boolean isSoCCCCD(String str) {
		String pattern = "[0-9]{9,12}";
		return str.matches(pattern);
	}

	public static Boolean isPassword(String str) {
		String pattern = "^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
		return str.matches(pattern);
	}
}
