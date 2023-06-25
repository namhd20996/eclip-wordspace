package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ChaoJDialog;

public class ChaoJDialogCTL implements ActionListener {
	private ChaoJDialog chaoJDialog;

	public ChaoJDialogCTL(ChaoJDialog chaoJDialog) {
		this.chaoJDialog = chaoJDialog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		if(src.equals("Exit")) {
//			this.chaoJDialog.closeChaoJDialog();
//		}
	}

}
