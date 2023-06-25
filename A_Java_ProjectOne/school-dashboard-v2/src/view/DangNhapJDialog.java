package view;

import java.awt.BorderLayout;



import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import controller.DangNhapDialogCTL;
import dao.NhanVienDao;

import lib.Auth;
import lib.DataValidator;
import lib.MaHoa;
import lib.MsgBox;
import lib.XImage;
import model.NhanVienModel;



public class DangNhapJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_IMG;
	private JTextField textField_User;
	private JPasswordField passwordField;
	private JLabel lbl_Exit;
	public AbstractButton btnLogin;
//	private MyTextField myTextField;
	private JLabel lbl_Show;
	private JLabel lbl_Hide;
	private JTextField lbl_None;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DangNhapJDialog dialog = new DangNhapJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DangNhapJDialog() {
//		this.myTextField = new MyTextField();

		DangNhapDialogCTL ctl = new DangNhapDialogCTL(this);
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

		lbl_Show = new JLabel("");
		lbl_Show.setName("lbl_Show");
		lbl_Show.addMouseListener(ctl);
		lbl_Show.setBounds(261, 376, 28, 23);
		ImageIcon iconShow = new ImageIcon(DangNhapJDialog.class.getResource("/IMG_JavaIcon/eye-2-xxl.png"));
		Image imgShow = XImage.resize(iconShow.getImage(), 28, 23);
		lbl_Show.setIcon(new ImageIcon(imgShow));
		panel_Right.add(lbl_Show);

		lbl_Hide = new JLabel("");
		lbl_Hide.setName("lbl_Hide");
		lbl_Hide.addMouseListener(ctl);
		lbl_Hide.setBounds(261, 376, 28, 23);
		ImageIcon iconHide = new ImageIcon(DangNhapJDialog.class.getResource("/IMG_JavaIcon/eye-2-xxl-hide.png"));
		Image imgHide = XImage.resize(iconHide.getImage(), 28, 23);
		lbl_Hide.setIcon(new ImageIcon(imgHide));
		panel_Right.add(lbl_Hide);

		JLabel label = new JLabel("New label");
		label.setBounds(151, 5, 48, 14);
		panel_Right.add(label);

		lbl_Exit = new JLabel("X");
		lbl_Exit.setName("LBL_Exit");
		lbl_Exit.addMouseListener(ctl);
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
//		myTextField.setHint("Userr");
		textField_User.setBackground(new Color(0, 128, 255));
		textField_User.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));

		textField_User.setBounds(83, 281, 211, 33);
		panel_Right.add(textField_User);
		textField_User.setColumns(10);

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
		passwordField.addKeyListener(ctl);
		passwordField.setBackground(new Color(0, 128, 255));
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		passwordField.setBounds(83, 376, 168, 33);
		panel_Right.add(passwordField);

		JLabel lblNewLabel_3_2 = new JLabel("Login To Your Account");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3_2.setBounds(110, 131, 168, 23);
		panel_Right.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/IMG_JPG/icons8_Account_50px.png")));
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_3.setBounds(25, 269, 48, 50);
		panel_Right.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("");
		lblNewLabel_3_4.setIcon(new ImageIcon(DangNhapJDialog.class.getResource("/IMG_JPG/icons8_Secure_50px.png")));
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_4.setBounds(25, 366, 48, 50);
		panel_Right.add(lblNewLabel_3_4);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(ctl);
		btnLogin.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnLogin.setFont(new Font("Zilla Slab SemiBold", Font.BOLD, 14));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setForeground(new Color(0, 0, 255));
		btnLogin.setBounds(83, 420, 211, 33);
		panel_Right.add(btnLogin);

		lbl_None = new JTextField();
		lbl_None.setEditable(false);
		lbl_None.setEnabled(false);
		lbl_None.setColumns(10);
		lbl_None.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		lbl_None.setBackground(new Color(0, 128, 255));
		lbl_None.setBounds(139, 400, 155, 9);
		panel_Right.add(lbl_None);
		
		JLabel lbl_register = new JLabel("Register?");
		lbl_register.setName("Register");
		lbl_register.addMouseListener(ctl);
		lbl_register.setForeground(Color.WHITE);
		lbl_register.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_register.setBounds(83, 494, 87, 23);
		panel_Right.add(lbl_register);
		
		JLabel lbl_forgotPw = new JLabel("Forgot Password ?");
		lbl_forgotPw.setName("ForgotPw");
		lbl_forgotPw.addMouseListener(ctl);
		lbl_forgotPw.setForeground(Color.WHITE);
		lbl_forgotPw.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_forgotPw.setBounds(200, 494, 168, 23);
		panel_Right.add(lbl_forgotPw);
		lbl_Show.setVisible(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}

	public void exitForm() {
		if (MsgBox.showConfirmDialog(this, "Bạn muốn thoát?", "Exit") == JOptionPane.NO_OPTION) {
			return;
		}
		System.exit(0);
		// Exit một form
//		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
//		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}

	public void checkForm() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateIsID(this.textField_User, sb, "Mã nhân viên null");
			DataValidator.validateEmpty(this.passwordField, sb, "Mật khẩu null");
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Error");
				return;
			}
			String maNV = this.textField_User.getText();
			String passWord = new String(this.passwordField.getPassword());
			NhanVienModel nv = new NhanVienModel();
//			System.out.println(maNV);
//			System.out.println(passWord);
			nv.setMaNhanVien(maNV);
			nv.setMatKhau(MaHoa.toSHA1(passWord));
			NhanVienModel nv_Dao = NhanVienDao.getInstance().checkLogin(nv);
			System.out.println(nv_Dao);
			if (nv_Dao == null) {
				MsgBox.showErrorDialog(this, "Lỗi user or password", "Error");
			} else {
				Auth.user = nv_Dao;
//				System.out.println(Auth.user.getPassWord());
				this.dispose();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showPassword() {
		lbl_Show.setVisible(false);
		lbl_Hide.setVisible(true);
		passwordField.setEchoChar('*');
	}

	public void hidePassword() {
		lbl_Hide.setVisible(false);
		lbl_Show.setVisible(true);
		passwordField.setEchoChar((char) 0);
	}
	
	public void displayTaoTaiKhoan() {
		TaoTaiKhoanJDialog taoTaiKhoanJDialog = new TaoTaiKhoanJDialog();
		taoTaiKhoanJDialog.setModal(true);
		taoTaiKhoanJDialog.setVisible(true);
	}
	
	public void displayForgotPw() {
		FogotPassJDialog fogotPassJDialog = new FogotPassJDialog();
		fogotPassJDialog.setModal(true);
		fogotPassJDialog.setVisible(true);
	}
}
