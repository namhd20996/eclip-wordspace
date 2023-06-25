package controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;



import test.MainFrame;
import view.Form_1;
import view.Form_Home;
import lib.EventMenuSelected;

public class MainFrameCTL implements EventMenuSelected, ActionListener{
	private MainFrame mainFrame;
	
	public MainFrameCTL(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void menuSelected(int menuIndex, int subMenuIndex) {
		System.out.println("Menu index: "+menuIndex+" Sub menu "+subMenuIndex);
		if(menuIndex == 0) {
			if(subMenuIndex==0) {
				this.mainFrame.mainForm.showForm(new Form_Home());
			}
			if(subMenuIndex == 1) {
				this.mainFrame.mainForm.showForm(new Form_1());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Header")) {
			this.mainFrame.actionFormSize();
		}
	}

}
