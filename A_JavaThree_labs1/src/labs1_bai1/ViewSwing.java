package labs1_bai1;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ViewSwing extends JFrame {

	private JCheckBox jCheckBox_Mango;
	private JCheckBox jCheckBox_Apple;
	private JCheckBox jCheckBox_Peer;
	private JLabel jLabel_B;
	private JLabel jLabel_A;
	private JLabel jLabel_C;

	public ViewSwing() {
		this.init();
		this.setVisible(true);
	}

	private void init() {
		ControllerView ctl = new ControllerView(this);
		this.setTitle("Ví Dụ Java Swing");
		this.setSize(400, 220);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("arial", Font.BOLD, 20);

		JPanel jPanel_North = new JPanel();
		JLabel jLabel_North = new JLabel("Control in action: CheckBox");
		jLabel_North.setFont(font);
		jPanel_North.add(jLabel_North);

		JPanel jPanel_Center = new JPanel();
		jPanel_Center.setLayout(new FlowLayout());
		jCheckBox_Apple = new JCheckBox("Apple");
		jCheckBox_Apple.setFont(font);
		jCheckBox_Apple.addActionListener(ctl);
		jCheckBox_Mango = new JCheckBox("Mango");
		jCheckBox_Mango.setFont(font);
		jCheckBox_Mango.addActionListener(ctl);
		jCheckBox_Peer = new JCheckBox("Peer");
		jCheckBox_Peer.setFont(font);
		jCheckBox_Peer.addActionListener(ctl);
		jPanel_Center.add(jCheckBox_Apple);
		jPanel_Center.add(jCheckBox_Mango);
		jPanel_Center.add(jCheckBox_Peer);

		JPanel jPanel_South = new JPanel();
		jPanel_South.setLayout(new GridLayout(3, 2));
		JLabel jLabel_1 = new JLabel();
		JLabel jLabel_2 = new JLabel();
		JLabel jLabel_3 = new JLabel();
		jLabel_A = new JLabel("Test", JLabel.CENTER);
		jLabel_B = new JLabel("Test", JLabel.CENTER);
		jLabel_C = new JLabel("Test", JLabel.CENTER);
		jLabel_A.setFont(font);
		jLabel_B.setFont(font);
		jLabel_C.setFont(font);
		jPanel_South.add(jLabel_A);
		jPanel_South.add(jLabel_B);
		jPanel_South.add(jLabel_C);

		this.setLayout(new BorderLayout());
		this.add(jPanel_North, BorderLayout.NORTH);
		this.add(jPanel_Center, BorderLayout.CENTER);
		this.add(jPanel_South, BorderLayout.SOUTH);
	}

	public void setLabelA() {
		boolean check = this.jCheckBox_Apple.isSelected();
		if(check) {
			this.jLabel_A.setText("Apple CheckBox: Checked");
		}else {
			this.jLabel_A.setText("");
		}
	}
	
	public void setLabelB() {
		boolean check = this.jCheckBox_Mango.isSelected();
		if(check) {
			this.jLabel_B.setText("Mango CheckBox: Checked");
		}else {
			this.jLabel_B.setText("");
		}
	}
	
	public void setLabelC() {
		boolean check = this.jCheckBox_Peer.isSelected();
		if(check) {
			this.jLabel_C.setText("Peer CheckBox: Checked");
		}else {
			this.jLabel_C.setText("");
		}
	}
}
