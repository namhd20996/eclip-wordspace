package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import view.StudentView;

public class StudentCTLView implements ActionListener , WindowListener{
	private StudentView studentView;

	public StudentCTLView(StudentView studentView) {
		this.studentView = studentView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(studentView, src);
		if(src.equals("Thoát")) {
			this.studentView.exitForm();
		}else if(src.equals("Quản lý sinh viên")) {
			this.studentView.newStudentManagementPanel();
		}else if(src.equals("Quản lý điểm")) {
			this.studentView.newGPAManagementPanel();
		}else if(src.equals("Giới thiệu")) {
			this.studentView.disPlayIntroduceDialog();
		}else if(src.equals("Out")) {
			this.studentView.outUser();
		}else if(src.equals("Đăng xuất")) {
			this.studentView.outUser();
		}else if(src.equals("St")) {
			this.studentView.newStudentManagementPanel();
		}else if(src.equals("GPA")) {
			this.studentView.newGPAManagementPanel();
		}else if(src.equals("Intro")) {
			this.studentView.disPlayIntroduceDialog();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		this.studentView.displayModalDialog();
//		this.studentView.processLoginSuccessful();
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
