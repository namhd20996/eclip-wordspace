package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TraPhongJDialog;

public class TraPhongJDialogCTL implements ActionListener{
	private TraPhongJDialog traPhongJDialog;
	
	public TraPhongJDialogCTL(TraPhongJDialog traPhongJDialog) {
		this.traPhongJDialog = traPhongJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Trả phòng")) {
			traPhongJDialog.displayTraPhong();
		}
	}

}
