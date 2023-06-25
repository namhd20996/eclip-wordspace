package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.MouseView;

public class MouseController implements MouseListener, MouseMotionListener{
	private MouseView mouseView;

	public MouseController(MouseView mouseView) {
		this.mouseView = mouseView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.mouseView.Click();
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
		this.mouseView.enter();
//		int x = e.getX(); int y = e.getY();
//		this.mouseView.updateView(x, y);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.mouseView.exit();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX(); int y = e.getY();
		this.mouseView.updateView(x, y);
	}
	
	
}
