package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Productinfor panel = new Productinfor();
		panel.setPrice("6$");
		panel.setpName("Tiger");
		panel.setBounds(10, 11, 260, 306);
		contentPane.add(panel);
		
		Productinfor panel_1 = new Productinfor();
		panel_1.setPrice("5$");
		panel_1.setpName("Heniken");
		panel_1.setBounds(288, 11, 260, 306);
		contentPane.add(panel_1);
		
		Productinfor panel_1_1 = new Productinfor();
		panel_1_1.setPrice("10$");
		panel_1_1.setpName("Sài Gòn");
		panel_1_1.setBounds(564, 11, 260, 306);
		contentPane.add(panel_1_1);
	}
}
