package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MyColorView;

public class MyColorController implements ActionListener{
	private MyColorView myColorView;
	
	public MyColorController(MyColorView myColorView) {
		this.myColorView = myColorView;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Red text")) {
			this.myColorView.changeTo_color(Color.RED);
		}else if(src.equals("Blue text")) {
			this.myColorView.changeTo_color(Color.BLUE);
		}else if(src.equals("Yellow text")) {
			this.myColorView.changeTo_color(Color.YELLOW);
		}else if(src.equals("Background red")) {
			this.myColorView.changeBackground_color(Color.RED);
		}else if(src.equals("Background blue")) {
			this.myColorView.changeBackground_color(Color.BLUE);
		}else if(src.equals("Background yellow")) {
			this.myColorView.changeBackground_color(Color.YELLOW);
		}
		
	}

}
