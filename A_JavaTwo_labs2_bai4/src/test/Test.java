package test;

import javax.swing.UIManager;

import view.View;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new View();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
