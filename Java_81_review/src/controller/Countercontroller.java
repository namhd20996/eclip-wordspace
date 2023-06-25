package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CounterView;

public class Countercontroller implements ActionListener{
	private CounterView counterView;
	
	public Countercontroller(CounterView counterView) {
		this.counterView = counterView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("UP")) {
			counterView.increment();
		}else if(e.getActionCommand().equalsIgnoreCase("Down")) {
			counterView.decrement();
		}else if(e.getActionCommand().equalsIgnoreCase("Reset")) {
			counterView.reset();
		}
	}

}
