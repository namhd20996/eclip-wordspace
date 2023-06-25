package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.MenuExamleView;

public class MenuMouseController implements MouseListener {
	private MenuExamleView menuExamleView;

	public MenuMouseController(MenuExamleView menuExamleView) {
		this.menuExamleView = menuExamleView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()) {
			this.menuExamleView.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
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
