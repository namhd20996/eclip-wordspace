package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class RegisterDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private Component rdo_Admin;
	private Component rdbtnUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisterDialog dialog = new RegisterDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisterDialog() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(RegisterDialog.class.getResource("/IMG_JavaIcon/color-catalog-icon.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("User:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(125, 64, 84, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("Password:");
		lblMtKhu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMtKhu.setBounds(125, 99, 84, 14);
		contentPanel.add(lblMtKhu);

		JLabel lblXcNhn = new JLabel("Confirm password:");
		lblXcNhn.setBounds(125, 133, 98, 14);
		contentPanel.add(lblXcNhn);

		JLabel lblRole = new JLabel("Role:");
		lblRole.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRole.setBounds(125, 167, 84, 14);
		contentPanel.add(lblRole);

		textField = new JTextField();
		textField.setBounds(229, 61, 181, 20);
		contentPanel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(229, 96, 181, 20);
		contentPanel.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(229, 130, 181, 20);
		contentPanel.add(passwordField_1);

		rdo_Admin = new JRadioButton("Admin");
		rdo_Admin.setBounds(229, 163, 67, 23);
		contentPanel.add(rdo_Admin);

		rdbtnUser = new JRadioButton("User");
		rdbtnUser.setBounds(298, 163, 67, 23);
		contentPanel.add(rdbtnUser);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add((AbstractButton) rdo_Admin);
		buttonGroup.add((AbstractButton) rdbtnUser);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(RegisterDialog.class.getResource("/IMG_JavaIcon/Student-3-icon64.png")));
		lblNewLabel_4.setBounds(10, 64, 112, 117);
		contentPanel.add(lblNewLabel_4);

		JLabel lblngKTi = new JLabel("Register for an Account");
		lblngKTi.setForeground(new Color(255, 0, 0));
		lblngKTi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblngKTi.setHorizontalAlignment(SwingConstants.CENTER);
		lblngKTi.setBounds(71, 11, 284, 39);
		contentPanel.add(lblngKTi);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Resgister", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 418, 243);
		contentPanel.add(panel);
		panel.setLayout(null);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(114, 209, 89, 23);
		panel.add(btnLogin);
		btnLogin.setIcon(new ImageIcon(RegisterDialog.class.getResource("/IMG_JavaIcon/Analytics-icon 24.png")));

		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(209, 209, 105, 23);
		panel.add(btnRegister);
		btnRegister
				.setIcon(new ImageIcon(RegisterDialog.class.getResource("/IMG_JavaIcon/painting-palette-icon.png")));

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(319, 209, 89, 23);
		panel.add(btnCancel);
		btnCancel.setIcon(
				new ImageIcon(RegisterDialog.class.getResource("/IMG_JavaIcon/ModernXP-02-System-Power-icon.png")));
	}
}
