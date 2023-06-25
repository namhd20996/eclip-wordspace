package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.ForgotPwCTL;
import dao.NhanVienDao;
import lib.DataValidator;
import lib.Email;
import lib.MsgBox;
import lib.SoNgauNhien;
import lib.XImage;
import model.NhanVienModel;

public class FogotPassJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbl_Exit;
	private JLabel lbl_IMG;
	private JTextField txtEmail;
	private JTextField txtUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FogotPassJDialog dialog = new FogotPassJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FogotPassJDialog() {
		ForgotPwCTL ctl = new ForgotPwCTL(this);
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

		JLabel lblNewLabel_3 = new JLabel("User name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(83, 249, 93, 23);
		panel_Right.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Email:");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(83, 345, 93, 23);
		panel_Right.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Login To Forgot Account");
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

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(ctl);
		btnConfirm.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnConfirm.setFont(new Font("Zilla Slab SemiBold", Font.BOLD, 14));
		btnConfirm.setBackground(new Color(255, 255, 255));
		btnConfirm.setForeground(new Color(0, 0, 255));
		btnConfirm.setBounds(83, 420, 211, 33);
		panel_Right.add(btnConfirm);

		JLabel lbl_register = new JLabel("Login");
		lbl_register.setName("Login");
		lbl_register.addMouseListener(ctl);
		lbl_register.setForeground(Color.WHITE);
		lbl_register.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_register.setBounds(167, 474, 87, 23);
		panel_Right.add(lbl_register);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtEmail.setBackground(new Color(0, 128, 255));
		txtEmail.setBounds(83, 376, 211, 33);
		panel_Right.add(txtEmail);

		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 255)));
		txtUser.setBackground(new Color(0, 128, 255));
		txtUser.setBounds(83, 283, 211, 33);
		panel_Right.add(txtUser);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}

	public void verifyTT() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtUser, sb, "Tài khoản null");
		DataValidator.validateIsEmail(txtEmail, sb, "Email null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String user = txtUser.getText();
		String email = txtEmail.getText();
		NhanVienModel userM = new NhanVienModel();
		userM.setMaNhanVien(user);
		userM.setEmail(email);
		if (NhanVienDao.getInstance().checkEmail(userM) != null) {
			// Lấy dãy số xác thực
			String soNgauNhien = SoNgauNhien.soNgauNhien();
			// Qui định thời gian hiệu lực
			Date todaysDate = new Date(new java.util.Date().getTime());
			Calendar c = Calendar.getInstance();
			c.setTime(todaysDate);
			c.add(Calendar.DATE, 1);
			Date thoiGianHieuLucMaXacThuc = new Date(c.getTimeInMillis());
			// Trạng thái xác thực
			boolean trangThaiXacThuc = true;
			Timestamp t = new Timestamp(System.currentTimeMillis());
			userM.setMaXacThuc(soNgauNhien);
			userM.setThoiGianHieuLucMaXacThuc(t);
			userM.setTrangThaiXacThuc(trangThaiXacThuc);
			if (NhanVienDao.getInstance().updateInformation(userM) > 0) {
				Email.sendEmail(userM.getEmail(), "Gửi từ Duy Nam", getNoiDung(userM));
				MsgBox.showMessageDialog(this, "Vui lòng check mail để lấy mã code", "Notification");
				dispose();
				displayVerify();
			}
		} else {
			MsgBox.showErrorDialog(this, "User or Email không chính xác", "Notification");
		}
	}

	public String getNoiDung(NhanVienModel kh) {
		String link = "http://localhost:8080/BoostrapLearning/khach-hang?action=xac-thuc&maKhachHang="
				+ kh.getMaNhanVien() + "&maXacThuc=" + kh.getMaXacThuc();
		String noiDung = "<p>Xin ch&agrave;o bạn: <strong>" + kh.getEmail() + "</strong></p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde;: <strong>"
				+ kh.getMaXacThuc()
				+ "</strong> x&aacute;c thực hoặc click trực tiếp v&agrave;o đường link&nbsp; sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\"" + link + "\">" + link + "</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; mail tự động xin vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Xin tr&acirc;n trọng cảm ơn.</p>";
		return noiDung;
	}

	public void displayLogin() {
		dispose();
		DangNhapJDialog dangNhapJDialog = new DangNhapJDialog();
		dangNhapJDialog.setModal(true);
		dangNhapJDialog.setVisible(true);
	}

	public void displayVerify() {
		VerifyPassJDialog verifyPassJDialog = new VerifyPassJDialog();
		verifyPassJDialog.setModal(true);
		verifyPassJDialog.setVisible(true);
	}
}
