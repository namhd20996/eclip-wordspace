package labs_them;

import javax.swing.UIManager;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new RegexView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
