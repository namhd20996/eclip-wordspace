package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.SinhVienModel;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, SinhVienModel> map = new HashMap<String,SinhVienModel>();
		SinhVienModel sv1 = new SinhVienModel();
		sv1.setHoVaTen("Nam");
		sv1.setDiem(10);
		sv1.setNganhHoc("Cntt");
		map.put(sv1.getHoVaTen(), sv1);
		Set<String> keys = map.keySet();
		for (String string : keys) {
			SinhVienModel sv = map.get(string);
			System.out.println("Họ và tên" + sv.getHoVaTen());
		}
	}
}
