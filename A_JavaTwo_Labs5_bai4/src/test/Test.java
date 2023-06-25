package test;

import javax.swing.UIManager;

import view.TextView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new TextView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
