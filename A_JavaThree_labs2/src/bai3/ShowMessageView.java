package bai3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class ShowMessageView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowMessageView frame = new ShowMessageView();
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
	public ShowMessageView() {
		this.setTitle("Option Dialog");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 203);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ShowMessageController ctl = new ShowMessageController(this);
		JButton btnMesseage = new JButton("Message Dialog");
		btnMesseage.setBounds(10, 24, 134, 23);
		contentPane.add(btnMesseage);
		btnMesseage.addActionListener(ctl);
		
		JButton btnInput = new JButton("Input Dialog");
		btnInput.setBounds(208, 24, 127, 23);
		contentPane.add(btnInput);
		btnInput.addActionListener(ctl);
		
		JButton btnConfirm = new JButton("Confirm Dialog");
		btnConfirm.setBounds(10, 109, 134, 23);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(ctl);
		
		JButton btnOption = new JButton("Option Dialog");
		btnOption.setBounds(208, 109, 127, 23);
		contentPane.add(btnOption);
		
		JButton btnOptionIcon = new JButton("IT18103");
		btnOptionIcon.setIcon(new ImageIcon(ShowMessageView.class.getResource("/IMG_JavaIcon/Student-3-icon24.png")));
		btnOptionIcon.addActionListener(ctl);
		btnOptionIcon.setBounds(94, 58, 148, 40);
		contentPane.add(btnOptionIcon);
		btnOption.addActionListener(ctl);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
