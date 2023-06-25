package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.UserJDialog;

public class UserJDialogCTL implements ActionListener, MouseListener{
	private UserJDialog nhanVienJDialog;
	
	public UserJDialogCTL(UserJDialog nhanVienJDialog) {
		this.nhanVienJDialog = nhanVienJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("|<")) {
			nhanVienJDialog.firstElement();
		}else if(src.equals("<<")) {
			nhanVienJDialog.previousElement();
		}else if(src.equals(">>")) {
			nhanVienJDialog.nextElement();
		}else if(src.equals(">|")) {
			nhanVienJDialog.lastElement();
		}else if(src.equals("New")) {
			nhanVienJDialog.reserForm();
		}else if(src.equals("Add")) {
			nhanVienJDialog.insertTableTaiKhoan();
		}else if(src.equals("Save")) {
			nhanVienJDialog.reserForm();
		}else if(src.equals("Delete")) {
			nhanVienJDialog.reserForm();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().toString().contains("ExitForm")) {
			nhanVienJDialog.exitForm();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount()==2) {
			nhanVienJDialog.displayFormCapNhat();
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
