package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.QLSVView;

public class MouseListenerController implements MouseListener{
	private QLSVView qlsvView;
	
	public MouseListenerController(QLSVView qlsvView) {
		this.qlsvView = qlsvView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.qlsvView.hienThiSinhVienDangChon();
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
