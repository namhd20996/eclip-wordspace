package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.QLNVView;

public class ControllerMouse implements MouseListener{
	private QLNVView qlnvView;
	
	public ControllerMouse(QLNVView qlnvView) {
		this.qlnvView = qlnvView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.qlnvView.updateForm();
		this.qlnvView.indexMouse();
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
