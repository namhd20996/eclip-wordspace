package labs7_bai3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBai3 implements ActionListener{
	private ViewBai3 view;

	public ControllerBai3(ViewBai3 view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Result")) {
			this.view.formClass();
		}
	}
	
}
