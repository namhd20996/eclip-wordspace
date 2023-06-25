package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;


import controller.DoiMatKhauCTL;

import dao.UserDao;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import lib.XImage;


import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class DoiMatKhauDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_MaNV;
	private JLabel lblNewLabel_4;
	private JPasswordField passwordField;
	private JPasswordField passwordField_New;
	private JPasswordField passwordField_Confirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DoiMatKhauDialog dialog = new DoiMatKhauDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DoiMatKhauDialog() {
		DoiMatKhauCTL ctl = new DoiMatKhauCTL(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DoiMatKhauDialog.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
		setBounds(100, 100, 450, 331);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tài khoản");
		lblNewLabel.setBounds(189, 50, 48, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới");
		lblMtKhuMi.setBounds(189, 146, 144, 14);
		contentPanel.add(lblMtKhuMi);

		JLabel lblXcNhnLi = new JLabel("Xác nhân lại mật khẩu mới");
		lblXcNhnLi.setBounds(189, 193, 144, 14);
		contentPanel.add(lblXcNhnLi);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(23, 44, 156, 219);
		contentPanel.add(lblNewLabel_4);

		this.lblNewLabel_4.setIcon(new ImageIcon(DoiMatKhauDialog.class.getResource("/IMG_JavaIcon/secrecy-icon.png")));

		JLabel lbliMtKhu = new JLabel("Đổi Mật Khẩu");
		lbliMtKhu.setForeground(new Color(0, 0, 255));
		lbliMtKhu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbliMtKhu.setBounds(235, 11, 156, 33);
		contentPanel.add(lbliMtKhu);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Change", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 430, 309);
		contentPanel.add(panel);
		panel.setLayout(null);

		JButton btnXcNhn = new JButton("Xác nhận");
		btnXcNhn.addActionListener(ctl);
		btnXcNhn.setIcon(new ImageIcon(DoiMatKhauDialog.class.getResource("/IMG_JavaIcon/Analytics-icon 24.png")));
		btnXcNhn.setBounds(179, 240, 97, 23);
		panel.add(btnXcNhn);

		JButton btnNewButton = new JButton("Hủy bỏ");
		btnNewButton.addActionListener(ctl);
		btnNewButton.setIcon(
				new ImageIcon(DoiMatKhauDialog.class.getResource("/IMG_JavaIcon/ModernXP-02-System-Power-icon.png")));
		btnNewButton.setBounds(319, 240, 89, 23);
		panel.add(btnNewButton);

		textField_MaNV = new JTextField();
		textField_MaNV.setBounds(179, 59, 227, 20);
		panel.add(textField_MaNV);
		textField_MaNV.setColumns(10);

		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setBounds(179, 90, 48, 14);
		panel.add(lblMtKhu);

		passwordField = new JPasswordField();
		passwordField.setBounds(179, 112, 229, 20);
		panel.add(passwordField);

		passwordField_New = new JPasswordField();
		passwordField_New.setBounds(179, 157, 229, 20);
		panel.add(passwordField_New);

		passwordField_Confirm = new JPasswordField();
		passwordField_Confirm.setBounds(179, 198, 229, 20);
		panel.add(passwordField_Confirm);

		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
	}

	public void changePassword() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateEmpty(this.textField_MaNV, sb, "Tài khoản null");
			DataValidator.validateEmpty(this.passwordField, sb, "Mật khẩu null");
			DataValidator.validateEmpty(this.passwordField_New, sb, "Mật khẩu mới null");
			DataValidator.validateEmpty(this.passwordField_Confirm, sb, "Mật khẩu xác nhận null");
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Error");
				return;
			}
			String maNV = this.textField_MaNV.getText();
			String passWord = new String(this.passwordField.getText());
			String passWordN = new String(this.passwordField_New.getText());
			String passWordC = new String(this.passwordField_Confirm.getText());
			if (!maNV.equalsIgnoreCase(Auth.user.getUser())) {
				MsgBox.showErrorDialog(this, "Tài khoản sai", "Error");
			} else if (!passWord.equals(Auth.user.getPassWord())) {
				MsgBox.showErrorDialog(this, "Mật khẩu sai", "Error");
			} else if (!passWordN.equals(passWordC)) {
				MsgBox.showErrorDialog(this, "Mật khẩu không trùng khớp", "Error");
			} else {
				Auth.user.setPassWord(passWordC);
				if (UserDao.getInstance().update(Auth.user) > 0) {
					MsgBox.showMessageDialog(this, "Change password successful", "Notification");
				} else {
					MsgBox.showErrorDialog(this, "Change password fail", "Error");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exitForm() {
		if (MsgBox.showConfirmDialog(this, "Do you want exit?", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		this.dispose();
	}
}
