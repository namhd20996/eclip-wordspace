package bai4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController implements ActionListener{
	private StudentView studentView;
	
	public StudentController(StudentView studentView) {
		this.studentView = studentView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Save")) {
			this.studentView.setValueForm();
		}else if(src.equals("Reset")) {
			this.studentView.resetForm();
		}else if(src.equals("Exit")) {
			this.studentView.exitForm();
		}
	}

}
