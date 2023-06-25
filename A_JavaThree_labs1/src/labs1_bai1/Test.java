package labs1_bai1;

import javax.swing.UIManager;

import labs1_bai1.ViewSwing;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new ViewSwing();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
