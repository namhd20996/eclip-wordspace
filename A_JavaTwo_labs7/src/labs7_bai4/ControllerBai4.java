package labs7_bai4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBai4 implements ActionListener{
	private ViewBai4 viewBai4;

	public ControllerBai4(ViewBai4 viewBai4) {
		this.viewBai4 = viewBai4;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Check")) {
			this.viewBai4.checkForm();
		}
	}
	
}
