package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.QLNVView;

public class ListenerQLNV implements ActionListener {
	private QLNVView qlnvView;

	public ListenerQLNV(QLNVView qlnvView) {
		this.qlnvView = qlnvView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JOptionPane.showMessageDialog(this.qlnvView, src);
		if(src.equals("Kiểm tra")) {
			this.qlnvView.checkForm();
		}
	}

}
