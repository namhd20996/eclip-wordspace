package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

import view.ThucDonView;

public class ThucDonController implements ActionListener {
	private ThucDonView thucDonView;

	public ThucDonController(ThucDonView thucDonView) {
		this.thucDonView = thucDonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		String monChinh = this.thucDonView.jComboBox.getSelectedItem().toString();
//		String monChinh = "";
//		Enumeration<AbstractButton> buttons_monChinh = this.thucDonView.buttonGroup_monChinh.getElements();
//		// hasMoreElements() lấy ra nút tiếp theo nếu còn trong button group
//		while (buttons_monChinh.hasMoreElements()) {
////			System.out.println(buttons_monChinh.hasMoreElements());
//			AbstractButton b = buttons_monChinh.nextElement();
//			if (b.isSelected()) {
//				monChinh = b.getText();
//			}
//		}
		
		String monPhu = "";
		Object[] luaChonMonPhu = this.thucDonView.jList_cacMonPhu.getSelectedValues();
		for(Object obj : luaChonMonPhu) {
			monPhu = monPhu + obj.toString()+";";
		}

//		String monPhu = "";
//		for (AbstractButton b : this.thucDonView.list_buttonGroup_monPhu) {
//			if (b.isSelected()) {
//				monPhu = monPhu + b.getText() + ";";
//			}
//		}
		// hasMoreElements() lấy ra nút tiếp theo nếu còn trong button group

		this.thucDonView.thucDonModel.setLuaChon_MonChinh(monChinh);
		this.thucDonView.thucDonModel.setLuaChon_MonPhu(monPhu);
		this.thucDonView.thucDonModel.tinhTongTien();
		this.thucDonView.hienThiTotal();
		
		String soTien_Chuoi = JOptionPane.showInputDialog(this.thucDonView,
				this.thucDonView.jLabel_thongTin.getText() +
				"\nNhập vào số tiền:",
				"Thông báo",
				JOptionPane.PLAIN_MESSAGE
				);
		
		try {
			double soTien = Double.valueOf(soTien_Chuoi);
			JOptionPane.showMessageDialog(thucDonView, 
					"Thối tiền lại cho khách: "+(soTien-thucDonView.thucDonModel.getToTal()),
					"InforTest",
					 JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(thucDonView, 
					"Nhập sai dữ liệu",
					"Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
