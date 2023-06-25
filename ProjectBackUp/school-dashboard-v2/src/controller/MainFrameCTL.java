package controller;

import com.raven.event.EventMenuSelected;
import com.raven.main.MainFrame;

public class MainFrameCTL implements EventMenuSelected{
	private MainFrame mainFrame;
	
	public MainFrameCTL(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void menuSelected(int menuIndex, int subMenuIndex) {
		System.out.println("Menu index: "+menuIndex+" Sub menu "+subMenuIndex);
	}

}
