package lib;

import model.NhanVienModel;

public class Auth {
	// Authentication
	public static NhanVienModel user = null;

	public static void clear() {
		Auth.user = null;
	}

	public static boolean isLogin() {
		return Auth.user != null;
	}

	public static boolean isMangager() {
		return Auth.isLogin() && user.isVaiTro();
	}
}
