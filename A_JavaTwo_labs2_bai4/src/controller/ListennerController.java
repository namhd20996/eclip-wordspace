package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.View;

public class ListennerController implements ActionListener{
	private View view;
	
	public ListennerController(View view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JOptionPane.showMessageDialog(view, src);
		if(src.equals("Reset")) {
			this.view.resetForm();
		}else if(src.equals("Add")) {
			this.view.insertForm();
		}else if(src.equals("Update")) {
			this.view.insertForm();
		}else if(src.equals("Remove")) {
			this.view.thucHienXoa();
		}
	}

}
