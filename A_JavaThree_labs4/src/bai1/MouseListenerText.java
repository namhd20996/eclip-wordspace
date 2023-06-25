package bai1;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerText implements MouseListener{
	private TextAreaView textAreaView;
	
	
	public MouseListenerText(TextAreaView textAreaView) {
		this.textAreaView = textAreaView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		this.textAreaView.resetTextArea();
//		this.textAreaView.displayAbout();
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
