package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MayTinhView;

public class MayTinhController implements ActionListener{
	private MayTinhView mayTinhView;
	
	public MayTinhController(MayTinhView mayTinhView) {
		this.mayTinhView = mayTinhView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		System.out.println(src);
		if(src.equals("+")) {
			this.mayTinhView.plus();
		}else if(src.equals("-")) {
			this.mayTinhView.minus();
		}else if(src.equals("x")) {
			this.mayTinhView.multiply();
		}else if(src.equals("/")) {
			this.mayTinhView.divide();
		}else if(src.equals("^2")) {
			this.mayTinhView.pow();
		}else if(src.equals("%")) {
			this.mayTinhView.mod();
		}
	}

}
