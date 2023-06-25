package labs7_bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBai2 implements ActionListener{
	private ViewBai2 v;
	
	public ControllerBai2(ViewBai2 v) {
		this.v = v;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Tính Tổng")) {
			this.v.sumValueView();
		}
	}

}
