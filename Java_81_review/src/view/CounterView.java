package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Countercontroller;
import model.CountTermodel;

public class CounterView extends JFrame{
	private CountTermodel countTermodel;
	private JButton jButton_up;
	private JButton jButton_down;
	private JLabel jLabel_value;
	private JButton jButton_reset;
	
	public CounterView() {
		this.countTermodel = new CountTermodel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Counter");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Countercontroller ac = new Countercontroller(this);
		
		jButton_up = new JButton("Up");
		jButton_up.addActionListener(ac);
		jButton_down = new JButton("Down");
		jButton_down.addActionListener(ac);
		jButton_reset = new JButton("Reset");
		jButton_reset.addActionListener(ac);
		jLabel_value = new JLabel(this.countTermodel.getValue()+"", JLabel.CENTER);
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jButton_up, BorderLayout.WEST);
		jPanel.add(jLabel_value, BorderLayout.CENTER);
		jPanel.add(jButton_down, BorderLayout.EAST);
		jPanel.add(jButton_reset, BorderLayout.SOUTH);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel, BorderLayout.CENTER);	
		
	}
	public void increment() {
		this.countTermodel.increement();
		this.jLabel_value.setText(this.countTermodel.getValue()+"");
	}
	
	public void decrement() {
		this.countTermodel.decrement();
		this.jLabel_value.setText(this.countTermodel.getValue()+"");
	}
	
	public void reset() {
		this.countTermodel.reset();
		this.jLabel_value.setText(this.countTermodel.getValue()+"");
	}
}
