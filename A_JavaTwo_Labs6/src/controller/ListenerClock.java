package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bai2.ViewClock;

public class ListenerClock implements ActionListener{
	private ViewClock viewClock;

	public ListenerClock(ViewClock viewClock) {
		this.viewClock = viewClock;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(this.viewClock, src);
		if(src.equals("00 : 00")) {
			this.viewClock.runTime();
		}
	}

}
