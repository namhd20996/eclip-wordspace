package bai3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderController implements ChangeListener{
	private JSliderView jSliderView;
	
	public JSliderController(JSliderView jSliderView) {
		this.jSliderView = jSliderView;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		this.jSliderView.changeSlider();
	}
}
