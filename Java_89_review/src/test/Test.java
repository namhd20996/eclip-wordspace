package test;

import javax.swing.UIManager;

import view.MenuExamleView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			new MenuExamleView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
