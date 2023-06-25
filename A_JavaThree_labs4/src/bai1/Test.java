package bai1;

import javax.swing.UIManager;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new TextAreaView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
