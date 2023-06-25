package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.BorderUIResource.BevelBorderUIResource;

import controller.ThucDonController;
import model.ThucDonModel;

public class ThucDonView extends JFrame {
	public ThucDonModel thucDonModel;
	public JRadioButton jRadioButton_com;
	public JRadioButton jRadioButton_pho;
	public JRadioButton jRadioButton_bun;
	public ButtonGroup buttonGroup_monChinh;
	public JCheckBox jCheckBox_che;
	public JCheckBox jCheckBox_traSua;
	public JCheckBox jCheckBox_coCa;
	public JCheckBox jCheckBox_pepSi;
	public JLabel jLabel_thongTin;
	public JButton jButton_toTal;
	public ArrayList<JCheckBox> list_buttonGroup_monPhu;
	public JComboBox<String> jComboBox;
	public JList<String> jList_cacMonPhu;

	public ThucDonView() {
		this.thucDonModel = new ThucDonModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Thực đơn");
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("arial", Font.ITALIC, 28);
		ThucDonController td = new ThucDonController(this);

		JLabel header = new JLabel("Thực đơn");
		header.setFont(font);

		JPanel jPanel_tieuDe = new JPanel();
		jPanel_tieuDe.add(header);

		JPanel jPanel_monChinh = new JPanel();
		jPanel_monChinh.setLayout(new FlowLayout());

		// JComboBox
		String[] cacMonChinh = new String[] { "Cơm", "Phở", "Bún" };
		jComboBox = new JComboBox<String>(cacMonChinh);
		jComboBox.setFont(font);

//		jRadioButton_com = new JRadioButton("Cơm");
//		jRadioButton_com.setFont(font);
////		jRadioButton_com.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(thucDonView.class.getResource("AD-Andorra-Flag-icon.png"))));
//		jRadioButton_pho = new JRadioButton("Phở");
//		jRadioButton_pho.setFont(font);
//		jRadioButton_bun = new JRadioButton("Bún");
//		jRadioButton_bun.setFont(font);
//		// Button
//		buttonGroup_monChinh = new ButtonGroup();
//		buttonGroup_monChinh.add(jRadioButton_com);
//		buttonGroup_monChinh.add(jRadioButton_pho);
//		buttonGroup_monChinh.add(jRadioButton_bun);
//
//		jPanel_monChinh.add(jRadioButton_com);
//		jPanel_monChinh.add(jRadioButton_pho);
		jPanel_monChinh.add(jComboBox);

		JPanel jPanel_monPhu = new JPanel();
		jPanel_monPhu.setLayout(new BorderLayout());

		String[] cacMonPhu = new String[] { "Chè", "Trà sữa", "Coca", "Pepsi" };
		jList_cacMonPhu = new JList<String>(cacMonPhu);
//		jCheckBox_che = new JCheckBox("Chè");
//		jCheckBox_traSua = new JCheckBox("Trà sữa");
//		jCheckBox_coCa = new JCheckBox("Coca");
//		jCheckBox_pepSi = new JCheckBox("Pepsi");
//
//		list_buttonGroup_monPhu = new ArrayList<JCheckBox>();
//		list_buttonGroup_monPhu.add(jCheckBox_che);
//		list_buttonGroup_monPhu.add(jCheckBox_traSua);
//		list_buttonGroup_monPhu.add(jCheckBox_coCa);
//		list_buttonGroup_monPhu.add(jCheckBox_pepSi);
//
//		jPanel_monPhu.add(jCheckBox_che);
//		jPanel_monPhu.add(jCheckBox_traSua);
//		jPanel_monPhu.add(jCheckBox_coCa);
		jPanel_monPhu.add(jList_cacMonPhu);

		JPanel jPanel_luaChon = new JPanel();
		jPanel_luaChon.setLayout(new GridLayout(2, 1));
		jPanel_luaChon.add(jPanel_monChinh, BorderLayout.NORTH);
		jPanel_luaChon.add(jPanel_monPhu, BorderLayout.CENTER);

		JPanel jPanel_thanhToan = new JPanel();
		jPanel_thanhToan.setLayout(new GridLayout(1, 2));
		jLabel_thongTin = new JLabel("");
//		jLabel_thongTin.setFont(font);
		jButton_toTal = new JButton("Total");
		jButton_toTal.setFont(font);
		jButton_toTal.addActionListener(td);
		jPanel_thanhToan.add(jButton_toTal);
		jPanel_thanhToan.add(jLabel_thongTin);

		this.add(jPanel_tieuDe, BorderLayout.NORTH);
		this.add(jPanel_luaChon, BorderLayout.CENTER);
		this.add(jPanel_thanhToan, BorderLayout.SOUTH);
	}

	public void hienThiTotal() {
		String result = "Món chính: " + this.thucDonModel.getLuaChon_MonChinh() + ", Món phụ: "
				+ this.thucDonModel.getLuaChon_MonPhu() + ", Tổng tiền: " + this.thucDonModel.getToTal();
		this.jLabel_thongTin.setText(result);
	}
}
