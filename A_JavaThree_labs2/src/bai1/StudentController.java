package bai1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bai1.StudentView;

public class StudentController implements ActionListener{
	private StudentView studentView;
	
	public StudentController(StudentView studentView) {
		this.studentView = studentView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Validate")) {
			this.studentView.validateTest();
		}else if(src.equals("Reset")) {
			this.studentView.resetForm();
		}
		
	}

}
