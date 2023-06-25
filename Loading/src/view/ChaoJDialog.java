package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.TitledBorder;



import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Toolkit;

public class ChaoJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JProgressBar progressBar;
	private JLabel lblNewLabel;
	private JLabel lbl_Connect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChaoJDialog dialog = new ChaoJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChaoJDialog() {
		
		setBounds(100, 100, 450, 355);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 128, 0));
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 292, 418, 17);
		contentPanel.add(progressBar);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 418, 215);
		contentPanel.add(lblNewLabel);
		
//		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
//		Image img = XImage.resize(icon.getImage(), 418, 215);
//		this.lblNewLabel.setIcon(new ImageIcon(img));
		
		lbl_Connect = new JLabel("New label");
		lbl_Connect.setBounds(130, 267, 160, 14);
		contentPanel.add(lbl_Connect);

//		Thread thread = new Thread(r);
//		thread.start();
		
		this.runProgress();
		
		this.setLocationRelativeTo(null);
	}


	Runnable r = new Runnable() {

		@Override
		public void run() {
			int i = 0;
			while (i < 100) {
				progressBar.setValue(i);
				i++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			dispose();
		}
	};
	
	public void runProgress() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					doTask("Connect to database...", 10);
					doTask("Task1...", 20);
					doTask("Task2...", 30);
					doTask("Task3...", 40);
					doTask("Connect...", 50);
					doTask("Connect...", 60);
					doTask("Connect user...", 70);
					doTask("Connect...", 80);
					doTask("Connect...", 90);
					doTask("Connect...", 100);
					doTask("Done", 100);
					dispose();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}).start();
	}
	
	public void doTask(String str, int progress) throws InterruptedException {
		this.lbl_Connect.setText(str);
		Thread.sleep(1000);
		this.progressBar.setValue(progress);
	}
}
