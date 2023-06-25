package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MayTinhController;
import model.MayTinhModel;

public class MayTinhView extends JFrame {
	private MayTinhModel mayTinhModel;
	private JTextField jTextField_first;
	private JTextField jTextField_second;
	private JTextField jTextField_answer;

	public MayTinhView() {
		this.mayTinhModel = new MayTinhModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Máy tính");
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("arial", Font.ITALIC, 50);
		MayTinhController mt = new MayTinhController(this);

		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(3, 2));

		JLabel jLabel_first = new JLabel("First value");
		jLabel_first.setFont(font);
		JLabel jLabel_second = new JLabel("Second value");
		jLabel_second.setFont(font);
		JLabel jLabel_answer = new JLabel("Answer value");
		jLabel_answer.setFont(font);

		jTextField_first = new JTextField(50);
		jTextField_first.setFont(font);
		jTextField_second = new JTextField(50);
		jTextField_second.setFont(font);
		jTextField_answer = new JTextField(50);
		jTextField_answer.setFont(font);

		jPanel.add(jLabel_first);
		jPanel.add(jTextField_first);
		jPanel.add(jLabel_second);
		jPanel.add(jTextField_second);
		jPanel.add(jLabel_answer);
		jPanel.add(jTextField_answer);

		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new GridLayout(2, 3));

		JButton jButton_1 = new JButton("+");
		jButton_1.setFont(font);
		jButton_1.addActionListener(mt);
		JButton jButton_2 = new JButton("-");
		jButton_2.setFont(font);
		jButton_2.addActionListener(mt);
		JButton jButton_3 = new JButton("x");
		jButton_3.setFont(font);
		jButton_3.addActionListener(mt);
		JButton jButton_4 = new JButton("/");
		jButton_4.setFont(font);
		jButton_4.addActionListener(mt);
		JButton jButton_5 = new JButton("^2");
		jButton_5.setFont(font);
		jButton_5.addActionListener(mt);
		JButton jButton_6 = new JButton("%");
		jButton_6.setFont(font);
		jButton_6.addActionListener(mt);

		jPanel_button.add(jButton_1);
		jPanel_button.add(jButton_2);
		jPanel_button.add(jButton_3);
		jPanel_button.add(jButton_4);
		jPanel_button.add(jButton_5);
		jPanel_button.add(jButton_6);

		this.setLayout(new BorderLayout());
		this.add(jPanel, BorderLayout.NORTH);
		this.add(jPanel_button, BorderLayout.SOUTH);
	}
	
	public void plus() {
		double firstValue = Double.parseDouble(jTextField_first.getText()+"");
		double secondValue = Double.parseDouble(jTextField_second.getText()+"");
		this.mayTinhModel.setFirstValue(firstValue);
		this.mayTinhModel.setSecondValue(secondValue);
		this.mayTinhModel.plus();
		this.jTextField_answer.setText(this.mayTinhModel.getAnswer()+"");
	}
	
	public void minus() {
		double firstValue = Double.parseDouble(jTextField_first.getText()+"");
		double secondValue = Double.parseDouble(jTextField_second.getText()+"");
		this.mayTinhModel.setFirstValue(firstValue);
		this.mayTinhModel.setSecondValue(secondValue);
		this.mayTinhModel.minus();
		this.jTextField_answer.setText(this.mayTinhModel.getAnswer()+"");
	}
	
	public void multiply() {
		double firstValue = Double.parseDouble(jTextField_first.getText()+"");
		double secondValue = Double.parseDouble(jTextField_second.getText()+"");
		this.mayTinhModel.setFirstValue(firstValue);
		this.mayTinhModel.setSecondValue(secondValue);
		this.mayTinhModel.multiply();
		this.jTextField_answer.setText(this.mayTinhModel.getAnswer()+"");
	}
	
	public void divide() {
		double firstValue = Double.parseDouble(jTextField_first.getText()+"");
		double secondValue = Double.parseDouble(jTextField_second.getText()+"");
		this.mayTinhModel.setFirstValue(firstValue);
		this.mayTinhModel.setSecondValue(secondValue);
		this.mayTinhModel.divide();
		this.jTextField_answer.setText(this.mayTinhModel.getAnswer()+"");
	}
	
	public void pow() {
		double firstValue = Double.parseDouble(jTextField_first.getText()+"");
		double secondValue = Double.parseDouble(jTextField_second.getText()+"");
		this.mayTinhModel.setFirstValue(firstValue);
		this.mayTinhModel.setSecondValue(secondValue);
		this.mayTinhModel.pow();
		this.jTextField_answer.setText(this.mayTinhModel.getAnswer()+"");
	}
	
	public void mod() {
		double firstValue = Double.parseDouble(jTextField_first.getText()+"");
		double secondValue = Double.parseDouble(jTextField_second.getText()+"");
		this.mayTinhModel.setFirstValue(firstValue);
		this.mayTinhModel.setSecondValue(secondValue);
		this.mayTinhModel.mod();
		this.jTextField_answer.setText(this.mayTinhModel.getAnswer()+"");
	}
}
