package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.View;

public class MouseController implements MouseListener{
	private View view;
	

	public MouseController(View view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.view.updateForm();
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
