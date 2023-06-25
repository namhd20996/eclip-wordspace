package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.MainFrame;

public class MainFrameCTL implements ActionListener , MouseListener{
	private MainFrame mainFrame;

	public MainFrameCTL(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("|<")) {
			mainFrame.firstElement();
		} else if (src.equals("<<")) {
			mainFrame.previousElement();
		} else if (src.equals(">>")) {
			mainFrame.nextElement();
		} else if (src.equals(">|")) {
			mainFrame.lastElement();
		}else if(src.equals("Add")) {
			mainFrame.inserTableSV();
		}else if(src.equals("Delete")) {
			mainFrame.deleteTable();
		}else if(src.equals("Update")) {
			mainFrame.inserTableSV();
		}else if(src.equals("New")) {
			mainFrame.resetForm();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mainFrame.displayFormCapNhat();
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
