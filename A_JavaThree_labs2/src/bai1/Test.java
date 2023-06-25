package bai1;

import javax.swing.UIManager;

import bai1.StudentView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new StudentView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
