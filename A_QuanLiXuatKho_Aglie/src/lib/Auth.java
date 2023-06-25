package lib;

import model.UserModel;

public class Auth {
	// Authentication
	public static UserModel user = null;

	public static void clear() {
		Auth.user = null;
	}

	public static boolean isLogin() {
		return Auth.user != null;
	}

	public static boolean isMangager() {
		return Auth.isLogin() && user.isRole();
	}
}
