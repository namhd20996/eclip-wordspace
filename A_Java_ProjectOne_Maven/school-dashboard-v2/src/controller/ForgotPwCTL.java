package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.FogotPassJDialog;

public class ForgotPwCTL implements ActionListener , MouseListener{
	private FogotPassJDialog fogotPassJDialog;

	public ForgotPwCTL(FogotPassJDialog fogotPassJDialog) {
		this.fogotPassJDialog = fogotPassJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Confirm")) {
			this.fogotPassJDialog.verifyTT();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.fogotPassJDialog.displayLogin();
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
