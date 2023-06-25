package labs_them;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;

public class RegexView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_User;
	private JTextField textField_Password;
	private JLabel lblNewLabel_User;
	private JLabel lblNewLabel_Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					RegexView frame = new RegexView();
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
	public RegexView() {
		RegexCTL ctl = new RegexCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(49, 74, 48, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(49, 125, 141, 14);
		contentPane.add(lblPassword);

		textField_User = new JTextField();
		textField_User.setBounds(134, 71, 152, 20);
		contentPane.add(textField_User);
		textField_User.setColumns(10);

		textField_Password = new JTextField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(134, 122, 152, 20);
		contentPane.add(textField_Password);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(49, 187, 89, 23);
		btnNewButton.addActionListener(ctl);
		contentPane.add(btnNewButton);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(0, 0, 255));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(120, 11, 115, 38);
		contentPane.add(lblLogin);

		lblNewLabel_User = new JLabel("");
		lblNewLabel_User.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_User.setBounds(134, 97, 89, 14);
		contentPane.add(lblNewLabel_User);

		lblNewLabel_Password = new JLabel("");
		lblNewLabel_Password.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_Password.setBounds(134, 150, 152, 14);
		contentPane.add(lblNewLabel_Password);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void checkForm() {
		if (this.textField_User.getText().equals("")) {
			this.lblNewLabel_User.setText("Chưa nhập user");
			this.lblNewLabel_User.setForeground(Color.red);
		} else {
			String user = this.textField_User.getText();
			if (!Data.isID(user)) {
				this.lblNewLabel_User.setText("Sai định dạng");
				this.lblNewLabel_User.setForeground(Color.red);
			} else {
				this.lblNewLabel_User.setText("User hợp lệ");
				this.lblNewLabel_User.setForeground(Color.red);
			}
		}
		if (this.textField_Password.getText().equals("")) {
			this.lblNewLabel_Password.setText("Chưa nhập password");
			this.lblNewLabel_Password.setForeground(Color.red);
		} else {
			if (this.textField_Password.getText().length() < 6) {
				this.lblNewLabel_Password.setText("Độ dài >=6");
				this.lblNewLabel_Password.setForeground(Color.red);
			} else {
				String passWord = this.textField_Password.getText();
				if (!Data.isPassword(passWord)) {
					this.lblNewLabel_Password.setText("Thiếu ký tự đặc biệt");
					this.lblNewLabel_Password.setForeground(Color.red);
				} else {
					this.lblNewLabel_Password.setText("Password hợp lệ");
					this.lblNewLabel_Password.setForeground(Color.red);
				}
			}
		}

	}
}
