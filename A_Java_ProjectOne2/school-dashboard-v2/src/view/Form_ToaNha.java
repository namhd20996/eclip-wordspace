package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class Form_ToaNha extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Form_ToaNha() {
		setBounds(0, 0, 1200, 600);
		setBackground(new Color(128, 0, 255));
		setOpaque(false);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 1200, 600);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 367, 207, 144);
		panel.add(panel_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(247, 367, 943, 144);
		panel.add(panel_1_1);
	}
}
