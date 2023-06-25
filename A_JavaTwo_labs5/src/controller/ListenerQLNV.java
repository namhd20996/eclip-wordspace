package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.QLNVView;

public class ListenerQLNV implements ActionListener{
	private QLNVView qlnvView;

	public ListenerQLNV(QLNVView qlnvView) {
		this.qlnvView = qlnvView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(qlnvView, src);
		if(src.equals("Thêm")) {
			this.qlnvView.insertForm();
		}else if(src.equals("Lưu")) {
			this.qlnvView.actionSaveFile();
		}else if(src.equals("Đọc")) {
			this.qlnvView.actionOpen();
		}
	}
	
	
}
