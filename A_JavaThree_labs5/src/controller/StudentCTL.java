package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.StudentView;

public class StudentCTL implements ActionListener {
	private StudentView studentView;

	public StudentCTL(StudentView studentView) {
		this.studentView = studentView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Add")) {
			this.studentView.insertTable();
		}else if(src.equals("Save")) {
			this.studentView.insertListStudents();
		}else if(src.equals("F")) {
			this.studentView.firstElement();
		}else if(src.equals("L")) {
			this.studentView.lastElement();
		}else if(src.equals("B")) {
			this.studentView.previousElement();
		}else if(src.equals("N")) {
			this.studentView.nextElement();
		}else if(src.equals("Delete")) {
			this.studentView.deleteTable();
		}else if(src.equals("Update")) {
			this.studentView.updateTable();
		}else if(src.equals("Reset")) {
			this.studentView.resetForm();
		}else if(src.equals("Find")) {
			this.studentView.findStudent();
		}
	}

}
