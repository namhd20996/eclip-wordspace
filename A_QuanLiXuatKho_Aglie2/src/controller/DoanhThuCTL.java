package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.DoanhThuJDialog;

public class DoanhThuCTL implements ActionListener, MouseListener{
	private DoanhThuJDialog doanhThuJDialog;
	
	public DoanhThuCTL(DoanhThuJDialog doanhThuJDialog) {
		this.doanhThuJDialog = doanhThuJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("C")) {
			this.doanhThuJDialog.loadTable();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.doanhThuJDialog.exitForm();
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
