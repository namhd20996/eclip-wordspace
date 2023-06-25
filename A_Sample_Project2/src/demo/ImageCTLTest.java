package demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import demo.TestImage;

public class ImageCTLTest implements ActionListener, MouseListener{
	private TestImage testImage;

	public ImageCTLTest(TestImage testImage) {
		this.testImage = testImage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("New button")) {
			this.testImage.saveLogo();
			
		}else if(src.equals("New")) {
			this.testImage.uploadLogo();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2) {
			this.testImage.imageFrom();
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
