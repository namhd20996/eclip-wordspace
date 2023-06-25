package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import view.KidsZoneSchoolView;

public class KidsZoneSchoolCTL implements ActionListener, MouseListener {
	private KidsZoneSchoolView kidsZoneSchoolView;

	public KidsZoneSchoolCTL(KidsZoneSchoolView kidsZoneSchoolView) {
		this.kidsZoneSchoolView = kidsZoneSchoolView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(kidsZoneSchoolView, src);
		if(src.equals("Insert")) {
			this.kidsZoneSchoolView.getValueForm();
		}else if(src.equals("New")) {
			this.kidsZoneSchoolView.resetForm();
		}else if(src.equals("Update")) {
			this.kidsZoneSchoolView.updateTable();
		}else if(src.equals("Edit")) {
			this.kidsZoneSchoolView.displayControl();
		}else if(src.equals("Previous")) {
			this.kidsZoneSchoolView.previous();
		}else if(src.equals("Next")) {
			this.kidsZoneSchoolView.nextT();
		}else if(src.equals("E")) {
			this.kidsZoneSchoolView.enabledBTN();
		}else if(src.equals("Delete")) {
			this.kidsZoneSchoolView.deleteTable();
		}else if(src.equals("Exit")) {
			this.kidsZoneSchoolView.exitForm();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.kidsZoneSchoolView.displayControl();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
