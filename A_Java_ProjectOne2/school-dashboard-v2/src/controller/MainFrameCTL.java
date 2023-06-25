package controller;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;



import test.MainFrame;
import util.EventMenuSelected;
import view.Form_ChuyenPhong;
import view.Form_Home;
import view.Form_ToaNha;
import view.Form_Phong;
import view.ListPhongJPanel;
import view.NguoiThuePhongJpanel;

public class MainFrameCTL implements EventMenuSelected, ActionListener{
	private MainFrame mainFrame;
	
	public MainFrameCTL(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void menuSelected(int menuIndex, int subMenuIndex) {
		System.out.println("Menu index: "+menuIndex+" Sub menu "+subMenuIndex);
		if(menuIndex == 0) {
			if(subMenuIndex==-1) {
				this.mainFrame.mainForm.showForm(new Form_Home());
			}
		}
		
		if(menuIndex == 0) {
			if(subMenuIndex==0) {
				this.mainFrame.mainForm.showForm(new Form_ToaNha());
			}
		}
		
		if(menuIndex==1) {
			if(subMenuIndex==0) {
				this.mainFrame.mainForm.showForm(new Form_Phong());
			}
			if(subMenuIndex==1) {
				this.mainFrame.mainForm.showForm(new Form_ChuyenPhong());
			}
		}
		
		if(menuIndex==6) {
			if(subMenuIndex==0) {
				this.mainFrame.mainForm.showForm(new NguoiThuePhongJpanel());
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
