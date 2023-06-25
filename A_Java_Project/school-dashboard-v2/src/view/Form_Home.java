package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class Form_Home extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public Form_Home() {
		setBounds(0, 0, 1200, 600);
		setBackground(new Color(128, 0, 255));
		setOpaque(false);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 1200, 600);
		add(panel);
		panel.setLayout(null);
	}
}
