package view_bai3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBai3 implements ActionListener{
	private View view;
	
	public ControllerBai3(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Reset")) {
			this.view.resetForm();
		}else if(src.equals("Login")) {
			this.view.loginForm();
		}else if(src.equals("Remember me?")) {
			this.view.checkBoxT();
		}
	}

}
