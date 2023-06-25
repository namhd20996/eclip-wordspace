package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.MainJframe;

public class MainFrameCTL implements MouseListener {
	private MainJframe mainJframe;

	public MainFrameCTL(MainJframe mainJframe) {
		this.mainJframe = mainJframe;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().toString().contains("Menu_1")) {
			this.mainJframe.clickedColorMenu_1();
		} else if (e.getSource().toString().contains("Menu_2")) {
			this.mainJframe.clickedColorMenu_2();
		} else if (e.getSource().toString().contains("Menu_3")) {
			this.mainJframe.clickedColorMenu_3();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
