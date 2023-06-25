package view_bai3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField textField_UserName;
	private JTextField textField_Password;
	private JCheckBox checkbox_Remember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					View frame = new View();
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
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		ControllerBai3 controller = new ControllerBai3(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(50, 74, 63, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(50, 99, 48, 14);
		contentPane.add(lblPassword);

		JLabel lblLoginForm = new JLabel("LOGIN FORM");
		lblLoginForm.setForeground(new Color(0, 0, 255));
		lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoginForm.setBounds(106, 22, 135, 41);
		contentPane.add(lblLoginForm);

		textField_UserName = new JTextField();
		textField_UserName.setBounds(116, 71, 210, 20);
		contentPane.add(textField_UserName);
		textField_UserName.setColumns(10);

		checkbox_Remember = new JCheckBox("Remember me?");
		checkbox_Remember.setBounds(116, 123, 128, 23);
		contentPane.add(checkbox_Remember);
		checkbox_Remember.addActionListener(controller);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(65, 153, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(controller);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(201, 153, 89, 23);
		contentPane.add(btnReset);
		btnReset.addActionListener(controller);

		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(116, 96, 210, 20);
		contentPane.add(textField_Password);
		this.setLocationRelativeTo(null);
		this.setTitle("Login");
	}

	public void resetForm() {
		this.textField_UserName.setText("");
		this.textField_Password.setText("");
		this.checkbox_Remember.setSelected(true);
	}

	public void loginForm() {
		String userName = this.textField_UserName.getText();
		String passWord = this.textField_Password.getText();

		StringBuffer sb = new StringBuffer();
		if (userName.equals("")) {
			sb.append("Username đang bỏ trống\n");
		}
		if (passWord.equals("")) {
			sb.append("Password đang bỏ trống");
		}
		
		if(sb.length() > 0 ) {
			JOptionPane.showMessageDialog(this, sb.toString());
			return;
		}
		
		if(userName.equals("fpt") && passWord.equals("polytechnic")) {
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
		}else {
			JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng");
		}
	}

	public void checkBoxT() {
		boolean t = this.checkbox_Remember.isSelected();
		if(t) {
			JOptionPane.showMessageDialog(this, "Đã ghi nhớ tài khoản");
		}
	}

}
