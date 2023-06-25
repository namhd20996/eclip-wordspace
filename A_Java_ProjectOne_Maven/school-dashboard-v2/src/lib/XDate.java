package lib;

import java.sql.Date;
import java.text.SimpleDateFormat;


@SuppressWarnings("deprecation")
public class XDate {
	// Chuyển đổi String sang date sql
	public static Date dateFormat(String str, String parten) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(parten);
			java.util.Date da = sdf.parse(str);
			String a = (da.getYear() + 1900) + "-" + (da.getMonth() + 1) + "-" + da.getDate();
			date = Date.valueOf(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static Date dateFormat(String str) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date da = sdf.parse(str);
			String a = (da.getYear() + 1900) + "-" + (da.getMonth() + 1) + "-" + da.getDate();
			date = Date.valueOf(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String dateString(Date date) {
		String str = "";
		if (date.getDate() < 10) {
			str = "0" + date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
		}
		if ((date.getMonth() + 1) < 10) {
			str = date.getDate() + "/" + "0" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
		}

		if ((date.getMonth() + 1) < 10 && date.getDate() < 10) {
			str = "0" + date.getDate() + "/0" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
		}
		if (date.getMonth() + 1 >= 10 && date.getDate() >= 10) {
			str = date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
		}
		return str;
	}

	public static Date now() {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		return date;
	}

	public static Date addDays(int days) {
		Date now = XDate.now();
		now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
		return now;
	}

}
