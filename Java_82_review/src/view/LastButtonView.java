package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.LastButtonListener;
import model.LastButtonModel;

public class LastButtonView extends JFrame {
	private LastButtonModel lastButtonModel;
	private JLabel jLabel;

	public LastButtonView() {
		this.lastButtonModel = new LastButtonModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("LastButton");
		this.setSize(300, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font font = new Font("arial", Font.BOLD, 20);	
		LastButtonListener ls = new LastButtonListener(this);

		JPanel jPanel_center = new JPanel();
		jPanel_center.setLayout(new GridLayout(2, 2));
		JButton jButton_1 = new JButton("1");
		jButton_1.setFont(font);
		jButton_1.addActionListener(ls);
		JButton jButton_2 = new JButton("2");
		jButton_2.setFont(font);
		jButton_2.addActionListener(ls);
		JButton jButton_3 = new JButton("3");
		jButton_3.setFont(font);
		jButton_3.addActionListener(ls);
		JButton jButton_4 = new JButton("4");
		jButton_4.setFont(font);
		jButton_4.addActionListener(ls);
		jPanel_center.add(jButton_1);
		jPanel_center.add(jButton_2);
		jPanel_center.add(jButton_3);
		jPanel_center.add(jButton_4);

		JPanel jPanel_footer = new JPanel();
		 jLabel = new JLabel("------------------");
		jLabel.setFont(font);
		jPanel_footer.add(jLabel);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_center, BorderLayout.CENTER);
		this.add(jPanel_footer, BorderLayout.SOUTH);
	}
	public void changeTo_1() {
		this.lastButtonModel.setValue_1();
		jLabel.setText("Last Button " + this.lastButtonModel.getValue());
	}
	public void changeTo_2() {
		this.lastButtonModel.setValue_2();
		jLabel.setText("Last Button " + this.lastButtonModel.getValue());
	}
	public void changeTo_3() {
		this.lastButtonModel.setValue_3();
		jLabel.setText("Last Button " + this.lastButtonModel.getValue());
	}
	public void changeTo_4() {
		this.lastButtonModel.setValue_4();
		jLabel.setText("Last Button " + this.lastButtonModel.getValue());
	}
}
