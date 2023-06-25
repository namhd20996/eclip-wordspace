package com.raven.form;

import java.awt.Color;

import javax.swing.JPanel;

public class Form_1 extends JPanel {

	/**
	 * Create the panel.
	 */
	public Form_1() {
		setBounds(0, 11, 1200, 500);
		setBackground(new Color(128, 0, 255));
		setOpaque(false);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 255));
		panel.setBounds(0, 11, 1200, 800);
		add(panel);
	}

}
