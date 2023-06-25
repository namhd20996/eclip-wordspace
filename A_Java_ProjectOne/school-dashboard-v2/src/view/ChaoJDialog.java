package view;

import java.awt.BorderLayout;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import lib.XImage;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ChaoJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblLoading;
	private JLabel lalConnect;
	private JProgressBar progressBar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			UIManager.setLookAndFeel(new FlatDarculaLaf());
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
		setBounds(100, 100, 759, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel_Background = new JPanel();
		panel_Background.setBackground(new Color(0, 255, 255));
		panel_Background.setBounds(0, 0, 759, 533);
		contentPanel.add(panel_Background);
		panel_Background.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 128, 0));
		progressBar.setBounds(0, 517, 759, 16);
		panel_Background.add(progressBar);

		lblLoading = new JLabel("Loading...");
		lblLoading.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblLoading.setForeground(new Color(255, 255, 255));
		lblLoading.setBounds(10, 492, 212, 14);
		panel_Background.add(lblLoading);

		lalConnect = new JLabel("0%");
		lalConnect.setHorizontalAlignment(SwingConstants.RIGHT);
		lalConnect.setForeground(new Color(255, 255, 255));
		lalConnect.setBounds(686, 492, 63, 14);
		panel_Background.add(lalConnect);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//			lblNewLabel_1.setIcon(new ImageIcon(ChaoJDialog.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
		lblNewLabel_1.setBounds(0, 140, 759, 190);
		panel_Background.add(lblNewLabel_1);

		ImageIcon icon1 = new ImageIcon(getClass().getResource("/IMG_JPG/logo-truong-fpt_043152255.png"));
		Image img1 = XImage.resize(icon1.getImage(), 311, 190);
		this.lblNewLabel_1.setIcon(new ImageIcon(img1));

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 759, 533);
		panel_Background.add(lblNewLabel);

		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/background-gradient-doc-dao_052411719.png"));
		Image img = XImage.resize(icon.getImage(), 759, 533);
		this.lblNewLabel.setIcon(new ImageIcon(img));

		this.setUndecorated(true);
		this.runProgress();
		this.setLocationRelativeTo(null);
	}

	public void runProgress() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < 100; i++) {
						Thread.sleep(100);
						lalConnect.setText(i + "%");
						if (i == 10) {
							lblLoading.setText("Tunrning On Modules...");
						}
						if (i == 10) {
							lblLoading.setText("Tunrning On Modules...");
						}
						if (i == 20) {
							lblLoading.setText("Loading Modules...");
						}
						if (i == 50) {
							lblLoading.setText("Connect to Database...");
						}
						if (i == 70) {
							lblLoading.setText("Connect Successfull...");
						}
						if (i == 80) {
							lblLoading.setText("Launching Application...");
						}
						progressBar.setValue(i);
						if (i == 99) {

							dispose();
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}).start();
	}
}
