package labs1_bai3;

import javax.swing.UIManager;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new LoginView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
