package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;


public class LoginForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_IMG;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginForm dialog = new LoginForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginForm() {
		
		setBounds(100, 100, 759, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel_left = new JPanel();
		panel_left.setBackground(new Color(255, 255, 255));
		panel_left.setBounds(0, 0, 409, 533);
		contentPanel.add(panel_left);
		panel_left.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("UNIQUE");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Zilla Slab SemiBold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 11, 74, 25);
		panel_left.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("DEVELOPER");
		lblNewLabel_1_1.setForeground(new Color(0, 128, 255));
		lblNewLabel_1_1.setFont(new Font("Zilla Slab SemiBold", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(80, 11, 108, 25);
		panel_left.add(lblNewLabel_1_1);

		lbl_IMG = new JLabel("");
//		lbl_IMG.setIcon(new ImageIcon(LoginForm.class.getResource("/view/undraw_building_websites_i78t.png")));
		lbl_IMG.setBounds(0, 47, 409, 486);
		panel_left.add(lbl_IMG);

		ImageIcon icon = new ImageIcon(getClass().getResource("/view/undraw_building_websites_i78t.png"));
		Image img = XImage.resize(icon.getImage(), 409, 300);
		this.lbl_IMG.setIcon(new ImageIcon(img));

		JPanel panel_Right = new JPanel();
		panel_Right.setBackground(new Color(0, 128, 255));
		panel_Right.setBounds(409, -30, 350, 563);
		contentPanel.add(panel_Right);
		panel_Right.setLayout(null);

		JLabel label = new JLabel("New label");
		label.setBounds(151, 5, 48, 14);
		panel_Right.add(label);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(302, 32, 48, 33);
		panel_Right.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Well Come");
		lblNewLabel_2.setFont(new Font("Zilla Slab SemiBold", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(123, 95, 131, 23);
		panel_Right.add(lblNewLabel_2);
		
		
		textField = new JTextField();
//		PlaceholderException pl = new PlaceholderException("T", textField);s
		textField.setBackground(new Color(0, 128, 255));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		
		textField.setBounds(83, 281, 211, 33);
		panel_Right.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("User name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(83, 249, 93, 23);
		panel_Right.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Password:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(83, 345, 93, 23);
		panel_Right.add(lblNewLabel_3_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(0, 128, 255));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBounds(83, 376, 211, 33);
		panel_Right.add(passwordField);
		
		JLabel lblNewLabel_3_2 = new JLabel("Login To Your Account");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_2.setBounds(110, 131, 168, 23);
		panel_Right.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon(LoginForm.class.getResource("/view/icons8_Account_50px.png")));
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(25, 269, 48, 50);
		panel_Right.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(new ImageIcon(LoginForm.class.getResource("/view/icons8_Secure_50px.png")));
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_4.setBounds(25, 359, 48, 50);
		panel_Right.add(lblNewLabel_3_4);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setFont(new Font("Zilla Slab SemiBold", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBounds(83, 420, 211, 33);
		panel_Right.add(btnNewButton);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Forgot Password ?");
		lblNewLabel_3_2_1.setForeground(Color.WHITE);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_2_1.setBounds(137, 490, 168, 23);
		panel_Right.add(lblNewLabel_3_2_1);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}
}
