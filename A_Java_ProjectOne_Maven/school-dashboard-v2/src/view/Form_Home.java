package view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.JPanel;

import lib.XImage;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Form_Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Form_Home() {
		setBounds(0, 0, 1200, 600);
		setBackground(new Color(0, 128, 255));
		setOpaque(false);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1200, 600);
		panel.setBackground(new Color(255, 255, 255));
		add(panel);
		panel.setLayout(null);
		
		JLabel lbl_IMG = new JLabel("To be continue...");
		lbl_IMG.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 18));
		lbl_IMG.setForeground(new Color(255, 0, 0));
		lbl_IMG.setBounds(10, 11, 1180, 578);
		ImageIcon icon = new ImageIcon(getClass().getResource("/icon/Noel.jpg"));
		Image img = XImage.resize(icon.getImage(), 956, 560);
		lbl_IMG.setIcon(new ImageIcon(img));
		panel.add(lbl_IMG);
	}
}
