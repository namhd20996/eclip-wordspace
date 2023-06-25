package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.QLBHView;

public class QLBHCTL implements ActionListener, MouseListener{
	private QLBHView qlbhView;
	
	
	public QLBHCTL(QLBHView qlbhView) {
	
		this.qlbhView = qlbhView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("New")) {
			this.qlbhView.resetForm();
		}else if(src.equals("Save")) {
			this.qlbhView.getValueForm();
		}else if(src.equals("SaveF")) {
			this.qlbhView.thucHienSave();
		}else if(src.equals("ReadF")) {
			this.qlbhView.thucHienOpen();
		}else if(src.equals("Find")) {
			this.qlbhView.thucHienTim();
		}else if(src.equals("Exit")) {
			this.qlbhView.thoatKhoiChuongTrinh();
		}else if(src.equals("Next")) {
			this.qlbhView.next();
		}
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.qlbhView.updateForm();
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
