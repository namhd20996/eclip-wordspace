package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.VerifyPassJDialog;

public class VerifyPassJDialogCTL implements ActionListener, MouseListener{
	private VerifyPassJDialog verifyPassJDialog;
	
	public VerifyPassJDialogCTL(VerifyPassJDialog verifyPassJDialog) {
		this.verifyPassJDialog = verifyPassJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Verify")) {
			this.verifyPassJDialog.verifyPassword();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.verifyPassJDialog.displayLogin();
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
