package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.ThongKeJDialog;

public class ThongKeJDialogCTL implements ActionListener, MouseListener{
	private ThongKeJDialog thongKeJDialog;

	public ThongKeJDialogCTL(ThongKeJDialog thongKeJDialog) {
		this.thongKeJDialog = thongKeJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("C")) {
			this.thongKeJDialog.loadDataTableBD();
		}else if(src.equals("CC")) {
			this.thongKeJDialog.loadDataTableDT();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.thongKeJDialog.exitForm();
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
