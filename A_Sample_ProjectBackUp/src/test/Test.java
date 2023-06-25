package test;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;

import view.MainJframe;

public class Test {
	public static void main(String[] args) {
		try {
//			UIManager.setLookAndFeel(new FlatDarculaLaf());
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new MainJframe();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
