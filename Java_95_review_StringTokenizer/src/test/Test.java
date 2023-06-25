package test;

import javax.swing.UIManager;

import view.ThucDonView;

public class Test {
	public static void main(String[] args) {
		try {
			new ThucDonView();
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
