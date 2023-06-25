package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Hide_Show_Password extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel show;
	private JLabel hide;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hide_Show_Password frame = new Hide_Show_Password();
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
	public Hide_Show_Password() {
		CTL ctl = new CTL(this);
		hide = new JLabel("New label");
		hide.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		show = new JLabel("New label");
		show.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				show.setVisible(false);
				hide.setVisible(true);
				passwordField.setEchoChar((char) 0);
			}
		});
		show.setIcon(new ImageIcon(Hide_Show_Password.class.getResource("/icon/delete.png")));
		show.setBounds(193, 266, 94, 49);
		contentPane.add(show);

	
		hide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				show.setVisible(true);
				hide.setVisible(false);
				passwordField.setEchoChar('*');
			}
		});
		
		hide.setIcon(new ImageIcon(Hide_Show_Password.class.getResource("/icon/edit.png")));
		hide.setBounds(193, 154, 70, 18);
		contentPane.add(hide);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(59, 123, 225, 80);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(59, 263, 228, 54);
		contentPane.add(textField);
		textField.setColumns(10);

		this.addWindowListener(ctl);
	}
	
}
