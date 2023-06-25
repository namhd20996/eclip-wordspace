package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import view.GPAManagementPanel;
import view.IntroduceDialog;
import view.StudentDialog;
import view.StudentManagementPanel;


public class DangNhapDialogCTL implements ActionListener, MouseListener, FocusListener, KeyListener, WindowListener{
	private StudentDialog studentDialog;
	private IntroduceDialog introduceDialog;
	private StudentManagementPanel studentManagementPanel;
	private GPAManagementPanel gpaManagementPanel;

	public DangNhapDialogCTL(StudentDialog studentDialog) {
		this.studentDialog = studentDialog;
	}

	public DangNhapDialogCTL(IntroduceDialog introduceDialog) {
		this.introduceDialog = introduceDialog;
	}

	public DangNhapDialogCTL(StudentManagementPanel studentManagementPanel) {
		this.studentManagementPanel = studentManagementPanel;
	}

	public DangNhapDialogCTL(GPAManagementPanel gpaManagementPanel) {
		this.gpaManagementPanel = gpaManagementPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

//		JOptionPane.showMessageDialog(studentDialog, src);
		if (src.equals("Login")) {
			this.studentDialog.checkFormLogin();
		} else if (src.equals("Ok")) {
			this.introduceDialog.closeIntroduceDialog();
		} else if (src.equals("New")) {
			this.studentManagementPanel.resetForm();
		} else if (src.equals("Save")) {
			this.studentManagementPanel.insertTableStudents();
		} else if (src.equals("Update")) {
			this.studentManagementPanel.updateTableStudents();
		} else if (src.equals("Delete")) {
			this.studentManagementPanel.deleteTableStudents();
		} else if (src.equals("N")) {
			this.gpaManagementPanel.resetFormGPA();
		} else if (src.equals("S")) {
			this.gpaManagementPanel.insertTableGrade();
		} else if (src.equals("Find")) {
			this.gpaManagementPanel.findMaSV();
		} else if (src.equals("U")) {
			this.gpaManagementPanel.insertTableGrade();
		} else if (src.equals("D")) {
			this.gpaManagementPanel.deleteTableGrade();
		} else if (src.equals("F")) {
			this.gpaManagementPanel.firstElement();
		} else if (src.equals("New Image")) {
			this.studentManagementPanel.disPlayImage();
		}else if (src.equals("Cancel")) {
			this.studentDialog.exitFormDialog();
		}else if (src.equals("L")) {
			this.gpaManagementPanel.lastElement();
		}else if (src.equals("Pre")) {
			this.gpaManagementPanel.previosElenemnt();
		}else if (src.equals("Nex")) {
			this.gpaManagementPanel.nextElement();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.studentManagementPanel.displayOnForm();
//		this.gpaManagementPanel.displayForm();
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

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		this.gpaManagementPanel.displayNameStudent();
		this.gpaManagementPanel.displayAVG();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == '\n') {
			this.gpaManagementPanel.displayNameStudent();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.studentDialog.btnLogin.doClick();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		this.studentDialog.checkFormLogin();
	}

	@Override
	public void windowOpened(WindowEvent e) {
//		this.gpaManagementPanel.displayNameStudent();
//		this.gpaManagementPanel.displayAVG();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
