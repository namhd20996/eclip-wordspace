package test;

import javax.swing.UIManager;

import view.MyNotePadView;

public class Test {
	public static void main(String[] args) {
		try {
			new MyNotePadView();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
