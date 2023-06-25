package model;

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
	
	public static Boolean isMaSach(String str) {
		String pattern = "^[a-zA-Z]{2,2}\\d{2,2}$";
		return str.matches(pattern);
	}
}
