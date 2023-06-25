package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LoadDing extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblLoading;
	private JLabel lalConnect;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			LoadDing dialog = new LoadDing();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoadDing() {
		setBounds(100, 100, 600, 468);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel_Background = new JPanel();
		panel_Background.setBackground(new Color(0, 255, 255));
		panel_Background.setBounds(0, 0, 599, 468);
		contentPanel.add(panel_Background);
		panel_Background.setLayout(null);
		
		 lblLoading = new JLabel("Loading...");
		lblLoading.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblLoading.setForeground(new Color(255, 255, 255));
		lblLoading.setBounds(10, 425, 212, 14);
		panel_Background.add(lblLoading);
		
		 lalConnect = new JLabel("0%");
		lalConnect.setHorizontalAlignment(SwingConstants.RIGHT);
		lalConnect.setForeground(new Color(255, 255, 255));
		lalConnect.setBounds(515, 425, 63, 14);
		panel_Background.add(lalConnect);
		
		JLabel lblNewLabel_1_1 = new JLabel("FPT Sofware");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(285, 209, 212, 84);
		panel_Background.add(lblNewLabel_1_1);
		
		JLabel lblBackgroud = new JLabel("0%");
		lblBackgroud.setIcon(new ImageIcon(LoadDing.class.getResource("/view/anh-background-gradient_052410174.jpg")));
		lblBackgroud.setBounds(0, 0, 599, 468);
		panel_Background.add(lblBackgroud);
		
		 progressBar = new JProgressBar();
		 progressBar.setForeground(new Color(255, 128, 0));
		 progressBar.setBounds(0, 452, 599, 16);
		 contentPanel.add(progressBar);
		
	this.setUndecorated(true);
	this.runProgress();
	}
	
	public void runProgress() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					for(int i=0; i<100; i++) {
						Thread.sleep(100);
						lalConnect.setText(i+"%");
						if(i==10) {
							lblLoading.setText("Tunrning On Modules...");
						}
						if(i==10) {
							lblLoading.setText("Tunrning On Modules...");
						}
						if(i==20) {
							lblLoading.setText("Loading Modules...");
						}
						if(i==50) {
							lblLoading.setText("Connect to Database...");
						}
						if(i==70) {
							lblLoading.setText("Connect Successfull...");
						}
						if(i==80) {
							lblLoading.setText("Launching Application...");
						}
						progressBar.setValue(i);
						if(i==99) {
							
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
