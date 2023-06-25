package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.TaiKhoanCTL;
import dao.NhanVienDao;

import lib.DataValidator;
import lib.MaHoa;
import lib.MsgBox;
import lib.XImage;
import model.NhanVienModel;

import javax.swing.JRadioButton;

public class TaoTaiKhoanJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_IMG;
	private JLabel lbl_Exit;
	private JTextField textField_User;
	private JPasswordField passwordField;
	private JPasswordField passwordField_Confirm;
	private JTextField txtEmail;
	private JRadioButton rdoAdmin;
	private JRadioButton rdoUser;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TaoTaiKhoanJDialog dialog = new TaoTaiKhoanJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TaoTaiKhoanJDialog() {
		TaiKhoanCTL ctl = new TaiKhoanCTL(this);
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

		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/undraw_building_websites_i78t.png"));
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

		lbl_Exit = new JLabel("X");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setForeground(new Color(255, 255, 255));
		lbl_Exit.setBounds(302, 32, 48, 33);
		panel_Right.add(lbl_Exit);

		JLabel lblNewLabel_2 = new JLabel("Well Come");
		lblNewLabel_2.setFont(new Font("Zilla Slab SemiBold", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(120, 45, 131, 23);
		panel_Right.add(lblNewLabel_2);

		textField_User = new JTextField();
//		PlaceholderException pl = new PlaceholderException("T", textField);s
		textField_User.setBackground(new Color(0, 128, 255));
		textField_User.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));

		textField_User.setBounds(83, 147, 211, 33);
		panel_Right.add(textField_User);
		textField_User.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("User name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(83, 115, 93, 23);
		panel_Right.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Password:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(83, 191, 93, 23);
		panel_Right.add(lblNewLabel_3_1);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(0, 128, 255));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBounds(83, 222, 211, 33);
		panel_Right.add(passwordField);

		JLabel lblNewLabel_3_2 = new JLabel("Login To Your Account");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_2.setBounds(107, 81, 168, 23);
		panel_Right.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/IMG_JPG/icons8_Account_50px.png")));
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(25, 135, 48, 50);
		panel_Right.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/IMG_JPG/icons8_Secure_50px.png")));
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_4.setBounds(25, 212, 48, 50);
		panel_Right.add(lblNewLabel_3_4);

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(ctl);
		btnRegister.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnRegister.setFont(new Font("Zilla Slab SemiBold", Font.BOLD, 14));
		btnRegister.setBackground(new Color(255, 255, 255));
		btnRegister.setForeground(new Color(0, 0, 255));
		btnRegister.setBounds(83, 451, 211, 33);
		panel_Right.add(btnRegister);

		JLabel lbl_forgotPw = new JLabel("Forgot Password ?");
		lbl_forgotPw.setName("ForgotPw");
//		lbl_forgotPw.addMouseListener(ctl);
		lbl_forgotPw.setForeground(Color.WHITE);
		lbl_forgotPw.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_forgotPw.setBounds(202, 510, 168, 23);
		panel_Right.add(lbl_forgotPw);

		JLabel lbl_register = new JLabel("Login?");
		lbl_register.setName("Login");
		lbl_register.addMouseListener(ctl);
		lbl_register.setForeground(Color.WHITE);
		lbl_register.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_register.setBounds(83, 510, 87, 23);
		panel_Right.add(lbl_register);

		JLabel lblNewLabel_3_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1_1.setBounds(83, 266, 171, 23);
		panel_Right.add(lblNewLabel_3_1_1);

		passwordField_Confirm = new JPasswordField();
		passwordField_Confirm.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField_Confirm.setBackground(new Color(0, 128, 255));
		passwordField_Confirm.setBounds(83, 297, 211, 33);
		panel_Right.add(passwordField_Confirm);

		JLabel lblNewLabel_3_4_1 = new JLabel("");
		lblNewLabel_3_4_1.setIcon(
				new ImageIcon(TaoTaiKhoanJDialog.class.getResource("/IMG_JPG/icons8_Forgot_Password_50px_4.png")));
		lblNewLabel_3_4_1.setForeground(Color.WHITE);
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_4_1.setBounds(25, 280, 48, 50);
		panel_Right.add(lblNewLabel_3_4_1);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Role:");
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1_1_1.setBounds(83, 400, 171, 23);
		panel_Right.add(lblNewLabel_3_1_1_1);

		JLabel lblNewLabel_3_3_1 = new JLabel("");
		lblNewLabel_3_3_1
				.setIcon(new ImageIcon(TaoTaiKhoanJDialog.class.getResource("/IMG_JPG/icons8_Account_50px.png")));
		lblNewLabel_3_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_3_1.setBounds(25, 398, 48, 50);
		panel_Right.add(lblNewLabel_3_3_1);

		rdoAdmin = new JRadioButton("Admin");
		rdoAdmin.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoAdmin.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(255, 255, 255)));
		rdoAdmin.setBackground(new Color(0, 128, 255));
		rdoAdmin.setForeground(new Color(255, 128, 0));
		rdoAdmin.setBounds(83, 421, 68, 23);
		panel_Right.add(rdoAdmin);

		rdoUser = new JRadioButton("User");
		rdoUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoUser.setForeground(new Color(255, 128, 0));
		rdoUser.setBackground(new Color(0, 128, 255));
		rdoUser.setBounds(202, 421, 109, 23);
		panel_Right.add(rdoUser);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoAdmin);
		buttonGroup.add(rdoUser);

		JLabel lblNewLabel_3_5 = new JLabel("Email:");
		lblNewLabel_3_5.setForeground(Color.WHITE);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_5.setBounds(83, 338, 93, 23);
		panel_Right.add(lblNewLabel_3_5);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtEmail.setBackground(new Color(0, 128, 255));
		txtEmail.setBounds(83, 362, 211, 33);
		panel_Right.add(txtEmail);

		JLabel lblNewLabel_3_3_2 = new JLabel("");
		lblNewLabel_3_3_2
				.setIcon(new ImageIcon(TaoTaiKhoanJDialog.class.getResource("/IMG_JPG/icons8_Account_50px.png")));
		lblNewLabel_3_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_3_2.setBounds(25, 350, 48, 50);
		panel_Right.add(lblNewLabel_3_3_2);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}

	public void registerUser() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(textField_User, sb, "Tài khoản null");
		DataValidator.validatePassword(passwordField, sb, "Mật khẩu null");
		DataValidator.validatePassword(passwordField_Confirm, sb, "Mật khẩu null");
		DataValidator.validateConfirmPass(passwordField_Confirm, passwordField, sb, "Mật khẩu không khớp");
		DataValidator.validateIsEmail(txtEmail, sb, "Email null");
		DataValidator.validateChecked(buttonGroup, sb, "Chưa chọn Role");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maNhanVien = textField_User.getText();
		String passWord = new String(passwordField_Confirm.getPassword());
		boolean role = true;
		if (rdoAdmin.isSelected()) {
			role = true;
		} else if (rdoUser.isSelected()) {
			role = false;
		}
		String email = txtEmail.getText();
		NhanVienModel userM = new NhanVienModel(maNhanVien, MaHoa.toSHA1(passWord), role, email);
		userM.setTrangThaiXacThuc(true);
		if (NhanVienDao.getInstance().insert(userM) > 0) {
			MsgBox.showMessageDialog(this, "Register successfull", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Register fail", "Notification");
		}
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}
}
