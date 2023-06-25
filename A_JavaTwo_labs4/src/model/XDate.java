package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {
	private static SimpleDateFormat sdf = new SimpleDateFormat();
	public static Date parse(String text, String pattern) throws ParseException {
		sdf.applyPattern(pattern);
		return sdf.parse(text);
	}
	
	public static Date parse(String text) throws ParseException {
		return XDate.parse(text, "dd-mm-yyyy");
	}
}
