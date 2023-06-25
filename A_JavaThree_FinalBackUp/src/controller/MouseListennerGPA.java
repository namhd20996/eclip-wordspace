package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.GPAManagementPanel;

public class MouseListennerGPA implements MouseListener {
	private GPAManagementPanel gpaManagementPanel;

	public MouseListennerGPA(GPAManagementPanel gpaManagementPanel) {
		this.gpaManagementPanel = gpaManagementPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.gpaManagementPanel.displayForm();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

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
