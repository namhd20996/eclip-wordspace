package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.DangNhapDialogCTL;
import dao.UserDAO;
import lib.DataValidator;
import lib.MessageDialog;
import model.ShareData;
import model.UserModel;
import java.awt.Toolkit;

public class StudentDialog extends JDialog {
	private JTextField textField;
	private JPasswordField passwordField;
	public JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StudentDialog dialog = new StudentDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public StudentDialog() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(StudentDialog.class.getResource("/IMG_JavaIcon/graduate-icon96.png")));
		DangNhapDialogCTL stu = new DangNhapDialogCTL(this);
//		this.setTitle("Login");
		setBounds(100, 100, 391, 251);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(164, 28, 48, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(164, 84, 134, 14);
		getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
//		textField.addKeyListener(stu);
		textField.setBounds(164, 53, 174, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(stu);
//		passwordField.addKeyListener(stu);
		passwordField.setBounds(164, 110, 174, 20);
		getContentPane().add(passwordField);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(stu);
		btnLogin.setIcon(new ImageIcon(StudentDialog.class.getResource("/IMG_JavaIcon/Analytics-icon 24.png")));
		btnLogin.setBounds(164, 164, 89, 23);
		getContentPane().add(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(stu);
		btnCancel.setIcon(
				new ImageIcon(StudentDialog.class.getResource("/IMG_JavaIcon/ModernXP-02-System-Power-icon.png")));
		btnCancel.setBounds(232, 164, 106, 23);
		getContentPane().add(btnCancel);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(
				new ImageIcon(StudentDialog.class.getResource("/IMG_JavaIcon/Actions-user-group-new-icon 48.png")));
		lblNewLabel_1_1.setBounds(31, 49, 89, 81);
		getContentPane().add(lblNewLabel_1_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 359, 194);
		getContentPane().add(panel);

//		this.addKeyListener(stu);
		this.setLocationRelativeTo(null);
	}

	public void checkFormLogin() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateEmpty(this.textField, sb, "UserName không được để trống");
			DataValidator.validateEmpty(this.passwordField, sb, "PassWord không được để trống");

			if (sb.length() > 0) {
				MessageDialog.showErrorDialog(this, sb.toString(), "Error");
				return;
			}
			String user = this.textField.getText().trim();
			String passWord = new String(this.passwordField.getPassword());
			UserModel userModel = new UserModel();
			userModel.setUser(user);
			userModel.setPassWord(passWord);
			UserModel userDao = UserDAO.getInstance().checkLogin(userModel);
			if (userDao == null) {
				MessageDialog.showErrorDialog(this, "Lỗi user or password", "Error");
			} else {
				ShareData.userData = userDao;
				this.dispose();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exitFormDialog() {
		if (MessageDialog.showConfirmDialog(this, "Do you want to Exit?", "Exit") == JOptionPane.NO_OPTION) {
			return;
		}
		System.exit(0);
	}
}
