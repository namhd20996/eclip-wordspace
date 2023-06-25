package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

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

import controller.VerifyPassJDialogCTL;
import dao.NhanVienDao;
import lib.DataValidator;
import lib.MaHoa;
import lib.MsgBox;
import lib.XImage;
import model.NhanVienModel;



public class VerifyPassJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_IMG;
	private JLabel lbl_Exit;
	private JTextField textField_User;
	private JPasswordField pwNew;
	private JPasswordField pwConfirm;
	private JTextField txtVerify;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VerifyPassJDialog dialog = new VerifyPassJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerifyPassJDialog() {
		VerifyPassJDialogCTL ctl = new VerifyPassJDialogCTL(this);
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
		lbl_Exit.setName("ExitForm");
//		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setForeground(new Color(255, 255, 255));
		lbl_Exit.setBounds(302, 32, 48, 33);
		panel_Right.add(lbl_Exit);

		JLabel lblNewLabel_2 = new JLabel("Well Come");
		lblNewLabel_2.setFont(new Font("Zilla Slab SemiBold", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(123, 95, 131, 23);
		panel_Right.add(lblNewLabel_2);

		textField_User = new JTextField();
//		PlaceholderException pl = new PlaceholderException("T", textField);s
		textField_User.setBackground(new Color(0, 128, 255));
		textField_User.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));

		textField_User.setBounds(83, 197, 211, 33);
		panel_Right.add(textField_User);
		textField_User.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("User name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(83, 176, 93, 23);
		panel_Right.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Password new:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(83, 241, 116, 23);
		panel_Right.add(lblNewLabel_3_1);

		pwNew = new JPasswordField();
//		passwordField.addKeyListener(ctl);
		pwNew.setBackground(new Color(0, 128, 255));
		pwNew.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		pwNew.setBounds(83, 258, 211, 33);
		panel_Right.add(pwNew);

		JLabel lblNewLabel_3_2 = new JLabel("Login To Your Account");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_2.setBounds(110, 131, 168, 23);
		panel_Right.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/IMG_JPG/icons8_Account_50px.png")));
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(25, 185, 48, 50);
		panel_Right.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/IMG_JPG/icons8_Secure_50px.png")));
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_4.setBounds(25, 248, 48, 50);
		panel_Right.add(lblNewLabel_3_4);

		JButton btnVerify = new JButton("Verify");
		btnVerify.addActionListener(ctl);
		btnVerify.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnVerify.setFont(new Font("Zilla Slab SemiBold", Font.BOLD, 14));
		btnVerify.setBackground(new Color(255, 255, 255));
		btnVerify.setForeground(new Color(0, 0, 255));
		btnVerify.setBounds(83, 470, 211, 33);
		panel_Right.add(btnVerify);

		JLabel lbl_register = new JLabel("Login?");
		lbl_register.setName("Login");
		lbl_register.addMouseListener(ctl);
		lbl_register.setForeground(Color.WHITE);
		lbl_register.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_register.setBounds(174, 529, 87, 23);
		panel_Right.add(lbl_register);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("");
		lblNewLabel_3_4_1.setIcon(new ImageIcon(VerifyPassJDialog.class.getResource("/IMG_JPG/icons8_Forgot_Password_50px_4.png")));
		lblNewLabel_3_4_1.setForeground(Color.WHITE);
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_4_1.setBounds(25, 315, 48, 50);
		panel_Right.add(lblNewLabel_3_4_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Password confirm:");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1_1.setBounds(83, 302, 171, 23);
		panel_Right.add(lblNewLabel_3_1_1);
		
		pwConfirm = new JPasswordField();
		pwConfirm.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		pwConfirm.setBackground(new Color(0, 128, 255));
		pwConfirm.setBounds(83, 325, 211, 33);
		panel_Right.add(pwConfirm);
		
		JLabel lblNewLabel_3_5 = new JLabel("Verify code:");
		lblNewLabel_3_5.setForeground(Color.WHITE);
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_5.setBounds(83, 374, 93, 23);
		panel_Right.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("");
		lblNewLabel_3_3_1.setIcon(new ImageIcon(VerifyPassJDialog.class.getResource("/IMG_JPG/icons8_Secure_50px.png")));
		lblNewLabel_3_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_3_1.setBounds(25, 383, 48, 50);
		panel_Right.add(lblNewLabel_3_3_1);
		
		txtVerify = new JTextField();
		txtVerify.setColumns(10);
		txtVerify.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtVerify.setBackground(new Color(0, 128, 255));
		txtVerify.setBounds(83, 395, 211, 33);
		panel_Right.add(txtVerify);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}
	
	public void verifyPassword() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(textField_User, sb, "User null");
		DataValidator.validatePassword(pwNew, sb, "Password new null");
		DataValidator.validatePassword(pwConfirm, sb, "Password confirm null");
		DataValidator.validateConfirmPass(pwNew, pwConfirm, sb, "Password verify");
		DataValidator.validateIsID(txtVerify, sb, "Veryfi code null");
		if(sb.length()>0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String user = textField_User.getText();
		String passWord = new String(pwConfirm.getPassword());
		String verifyCode = txtVerify.getText();
		NhanVienModel usm = new NhanVienModel();
		usm.setMaNhanVien(user);
		usm.setMatKhau(MaHoa.toSHA1(passWord));
		usm.setMaXacThuc(verifyCode);
		if(NhanVienDao.getInstance().forgotPassword(usm)>0) {
			MsgBox.showMessageDialog(this, "Success", "Notification");
		}else {
			MsgBox.showMessageDialog(this, "Fail", "Notification");
		}
	}
	
	public void displayLogin() {
		dispose();
		DangNhapJDialog dangNhapJDialog = new DangNhapJDialog();
		dangNhapJDialog.setModal(true);
		dangNhapJDialog.setVisible(true);
	}
}
