package test;

import javax.swing.UIManager;

import view.QLNVView;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLNVView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
