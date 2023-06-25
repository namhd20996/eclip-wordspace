package bai3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JSliderControllerA implements ActionListener{
	private JSliderView jSliderView;
	
	public JSliderControllerA(JSliderView jSliderView) {
		this.jSliderView = jSliderView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Set value")) {
			this.jSliderView.changeFont();
		}
	}

}
