package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainJframeCTL;
import lib.XImage;
import lib.Auth;
import lib.MsgBox;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

public class MainJframe extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_IMG;
	private JLabel lblClock;
	private int index = 0;
	private JLabel lblLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainJframe frame = new MainJframe();
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
	public MainJframe() {
		this.displayDangNhapJDialog();
		this.displayChaoJDialog();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(MainJframe.class.getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg")));
		MainJframeCTL mainJframeCTL = new MainJframeCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 533);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenuItem mmDangNhap = new JMenuItem("Đăng nhập");
		mmDangNhap.addActionListener(mainJframeCTL);
		mmDangNhap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		mmDangNhap.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Windows-Log-Off-icon (1).png")));
		mnNewMenu.add(mmDangNhap);

		JMenuItem mmDangXuat = new JMenuItem("Đăng xuất");
		mmDangXuat.addActionListener(mainJframeCTL);
		mmDangXuat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		mmDangXuat.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Log-Out-icon (1).png")));
		mnNewMenu.add(mmDangXuat);

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem mmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mmDoiMatKhau.addActionListener(mainJframeCTL);
		mmDoiMatKhau.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Refresh-icon (1).png")));
		mnNewMenu.add(mmDoiMatKhau);

		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);

		JMenuItem mmKetThuc = new JMenuItem("Kết thúc");
		mmKetThuc.addActionListener(mainJframeCTL);
		mmKetThuc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mmKetThuc.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/cross-2-icon (1).png")));
		mnNewMenu.add(mmKetThuc);

		JMenu mnNewMenu_1 = new JMenu("Quản lý");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Người học");
		mntmNewMenuItem_4.addActionListener(mainJframeCTL);
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/User-Group-icon (1).png")));
		mnNewMenu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Chuyên đề");
		mntmNewMenuItem_5.addActionListener(mainJframeCTL);
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/clipboard-icon (1).png")));
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Khóa học");
		mntmNewMenuItem_6.addActionListener(mainJframeCTL);
		mntmNewMenuItem_6.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Courses-icon (1).png")));
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Nhân viên");
		mntmNewMenuItem_7.addActionListener(mainJframeCTL);
		mntmNewMenuItem_7
				.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Actions-contact-new-icon (1).png")));
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JMenu mnNewMenu_2 = new JMenu("Thống kê");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Người học từng năm");
		mntmNewMenuItem_8.addActionListener(mainJframeCTL);
		mntmNewMenuItem_8.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/User-Files-icon (1).png")));
		mnNewMenu_2.add(mntmNewMenuItem_8);

		JSeparator separator_2 = new JSeparator();
		mnNewMenu_2.add(separator_2);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Bảng khóa điểm");
		mntmNewMenuItem_9.addActionListener(mainJframeCTL);
		mntmNewMenuItem_9.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Content-icon24.png")));
		mnNewMenu_2.add(mntmNewMenuItem_9);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Điểm từng khóa học");
		mntmNewMenuItem_10.addActionListener(mainJframeCTL);
		mntmNewMenuItem_10.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/pie-chart-icon (1).png")));
		mnNewMenu_2.add(mntmNewMenuItem_10);

		JSeparator separator_3 = new JSeparator();
		mnNewMenu_2.add(separator_3);

		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Doanh thu từng chuyên đề");
		mntmNewMenuItem_11.addActionListener(mainJframeCTL);
		mntmNewMenuItem_11
				.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/dollar-folder-icon (1).png")));
		mnNewMenu_2.add(mntmNewMenuItem_11);

		JMenu mnNewMenu_3 = new JMenu("Trợ giúp");
		menuBar.add(mnNewMenu_3);

		JMenuItem mmHuongDanSuDung = new JMenuItem("Hướng dẫn sử dụng");
		mmHuongDanSuDung.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mmHuongDanSuDung.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/tv-guide-icon (1).png")));
		mnNewMenu_3.add(mmHuongDanSuDung);

		JSeparator separator_4 = new JSeparator();
		mnNewMenu_3.add(separator_4);

		JMenuItem mmGioiThieu = new JMenuItem("Giới thiệu sản phẩm");
		mmGioiThieu.addActionListener(mainJframeCTL);
		mmGioiThieu.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Information-icon24.png")));
		mnNewMenu_3.add(mmGioiThieu);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		toolBar.setBackground(new Color(255, 255, 255));
		toolBar.setBounds(0, 0, 759, 51);
		contentPane.add(toolBar);

		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(mainJframeCTL);
		btnDangXuat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDangXuat.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDangXuat.setBackground(new Color(255, 255, 255));
//		btnNewButton.setMargin(new Insets(50, 14, 2, 14));
		btnDangXuat.setVerticalAlignment(SwingConstants.TOP);
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEADING);
		btnDangXuat.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Log-Out-icon (1).png")));
		toolBar.add(btnDangXuat);

		JButton btnKetThuc = new JButton("Kết thúc");
		btnKetThuc.setBackground(new Color(255, 255, 255));
		btnKetThuc.addActionListener(mainJframeCTL);
		btnKetThuc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnKetThuc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnKetThuc.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/cross-2-icon (1).png")));
		toolBar.add(btnKetThuc);

		JButton btnChuyenDe = new JButton("Chuyên đề");
		btnChuyenDe.setBackground(new Color(255, 255, 255));
		btnChuyenDe.addActionListener(mainJframeCTL);
		btnChuyenDe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChuyenDe.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnChuyenDe.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/clipboard-icon (1).png")));
		toolBar.add(btnChuyenDe);

		JButton btnNguoiHoc = new JButton("Người học");
		btnNguoiHoc.setBackground(new Color(255, 255, 255));
		btnNguoiHoc.addActionListener(mainJframeCTL);
		btnNguoiHoc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnNguoiHoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNguoiHoc.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/User-Group-icon (1).png")));
		toolBar.add(btnNguoiHoc);

		JButton btnKhoaHoc = new JButton("Khóa học");
		btnKhoaHoc.setBackground(new Color(255, 255, 255));
		btnKhoaHoc.addActionListener(mainJframeCTL);
		btnKhoaHoc.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnKhoaHoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnKhoaHoc.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Courses-icon (1).png")));
		toolBar.add(btnKhoaHoc);

		JButton btnHuongDan = new JButton("Hướng dẫn");
		btnHuongDan.setBackground(new Color(255, 255, 255));
		btnHuongDan.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHuongDan.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnHuongDan.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/tv-guide-icon (1).png")));
		toolBar.add(btnHuongDan);

		lbl_IMG = new JLabel("");
		lbl_IMG.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMG.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_IMG.setBounds(0, 73, 747, 350);
		contentPane.add(lbl_IMG);

		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/logo-truong-fpt_043152255.png"));
		Image img = XImage.resize(icon.getImage(), 450, 225);
		ImageIcon resize = new ImageIcon(img);
		this.lbl_IMG.setIcon(resize);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 463, 737, 2);
		contentPane.add(separator_5);

		lblLogin = new JLabel("Hệ thống quản lý đào tạo");
		lblLogin.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/Student-3-icon24.png")));
		lblLogin.setBounds(10, 476, 314, 24);
		contentPane.add(lblLogin);

		lblClock = new JLabel("02:02:02 PM");
		lblClock.setIcon(new ImageIcon(MainJframe.class.getResource("/IMG_JavaIcon/clock-icon (1).png")));
		lblClock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClock.setBounds(638, 479, 109, 19);
		contentPane.add(lblClock);

		Thread thread = new Thread(r);
		thread.start();
		this.displayLogin();
		this.addWindowListener(mainJframeCTL);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setVisible(true);
	}

	Runnable r = new Runnable() {

		@Override
		public void run() {
			while (true) {
				Date now = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
				lblClock.setText(sdf.format(now));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	public void exitForm() {
		if (MsgBox.showConfirmDialog(this, "Bạn muốn Exit?", "Exit") == JOptionPane.NO_OPTION) {
			return;
		}
		System.exit(0);
	}

	public void displayChaoJDialog() {
		ChaoJDialog chaoJDialog = new ChaoJDialog();
		chaoJDialog.setModal(true);
//		chaoJDialog.setUndecorated(true);
		chaoJDialog.setVisible(true);
	}

	public void displayNhanVienJDialog() {
		if (Auth.isLogin()) {
			NhanVienJDialog nhanVienJDialog = new NhanVienJDialog();
			nhanVienJDialog.setModal(true);
			nhanVienJDialog.setVisible(true);
		} else {
			MsgBox.showErrorDialog(this, "Login null", "Notification");
		}

	}

	public void displayNguoiHocJDialog() {
		if (Auth.isLogin()) {
			NguoiHocJDialog nguoiHocJDialog = new NguoiHocJDialog();
			nguoiHocJDialog.setModal(true);
			nguoiHocJDialog.setVisible(true);
		} else {
			MsgBox.showErrorDialog(this, "Login null", "Notification");
		}

	}

	public void displayChuyenDeJDialog() {
		if (Auth.isLogin()) {
			ChuyenDeJDialog chuyenDeJDialog = new ChuyenDeJDialog();
			chuyenDeJDialog.setModal(true);
			chuyenDeJDialog.setVisible(true);
		} else {
			MsgBox.showErrorDialog(this, "Login null", "Notification");
		}

	}

	public void displayKhoaHocJDialog() {
		if (Auth.isLogin()) {
			KhoaHocJDialog khoaHocJDialog = new KhoaHocJDialog();
			khoaHocJDialog.setModal(true);
			khoaHocJDialog.setVisible(true);
		} else {
			MsgBox.showErrorDialog(this, "Login null", "Notification");
		}
	}

	public void displayDoiMatKhauJDialog() {
		if (Auth.isLogin()) {
			DoiMatKhauDialog doiMatKhauDialog = new DoiMatKhauDialog();
			doiMatKhauDialog.setModal(true);
			doiMatKhauDialog.setVisible(true);
		} else {
			MsgBox.showErrorDialog(this, "Login null", "Notification");
		}

	}

	public void openDisplayDangNhapJDialog() {
		if (!Auth.isLogin()) {
			this.displayDangNhapJDialog();
		} else {
			MsgBox.showMessageDialog(this, "Login ready", "Notification");
		}
	}

	public void displayDangNhapJDialog() {
		try {
			DangNhapJDialog dangNhapJDialog = new DangNhapJDialog();
			dangNhapJDialog.setModal(true);
			dangNhapJDialog.setUndecorated(true);
			dangNhapJDialog.setVisible(true);
//			this.lblLogin.setText("User: "+Auth.user.getMaNV());
			this.displayLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
	
	public void displayLogin() {
		this.lblLogin.setText("User: "+Auth.user.getMaNV()+" | Role: "+(Auth.user.isRole()?"T.Phòng":"N.Viên"));
	}

	public void displayGioiThieuJDialog() {
		GioiThieuJDialog gioiThieuJDialog = new GioiThieuJDialog();
		gioiThieuJDialog.setModal(true);
		gioiThieuJDialog.setVisible(true);
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void displayThongKeJDialog() {
		if (Auth.isLogin()) {
			if (this.index == 3 && !Auth.isMangager()) {
				MsgBox.showMessageDialog(this, "Bạn không có quyền xem doanh thu", "Notification");
				return;
			}
			ThongKeJDialog thongKeJDialog = new ThongKeJDialog();
			thongKeJDialog.setModal(true);
			thongKeJDialog.selectTab(index);
			thongKeJDialog.setVisible(true);
		}
	}

	public void logOut() {
		Auth.clear();
		this.displayDangNhapJDialog();
	}

}
