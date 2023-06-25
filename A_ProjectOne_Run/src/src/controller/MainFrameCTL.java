package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.raven.event.EventMenuSelected;
import com.raven.form.Form_1;
import com.raven.form.Form_Home;
import com.raven.main.MainFrame;

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
