package bai2;

import javax.swing.UIManager;

import bai2.CalculatorView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new CalculatorView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
