package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JButton;

public class Form_2 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_2 frame = new Form_2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Form_2() {
		setBounds(191, 76, 897, 589);
		getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("New cc");
		btnNewButton.setBounds(428, 201, 89, 23);
		getContentPane().add(btnNewButton);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);
	}
}
