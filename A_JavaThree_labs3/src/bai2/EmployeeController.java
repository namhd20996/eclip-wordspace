package bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController implements ActionListener{
	private EmployeeView employeeView;
	
	public EmployeeController(EmployeeView employeeView) {
		this.employeeView = employeeView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Ok")) {
			this.employeeView.displayForm();
		}else if(src.equals("Exit")) {
			this.employeeView.exitForm();
		}else if(src.equals("Reset")) {
			this.employeeView.resetForm();
		}
	}

}
