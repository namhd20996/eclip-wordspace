package com.raven.form;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

public class MainFrom extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainFrom() {
		setBackground(new Color(255, 0, 0));
		setOpaque(false);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(10,20,10,20));
	}
	
	public void showForm(Component com) {
		removeAll();
		add(com);
		repaint();
		revalidate();
	}

}
