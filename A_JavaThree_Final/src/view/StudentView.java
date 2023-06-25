package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthButtonUI;

import controller.DangNhapDialogCTL;
import controller.StudentCTLView;
import lib.ImageHelper;
import lib.MessageDialog;
import model.ShareData;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.InputEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private StudentManagementPanel studentManagementPanel;
	private GPAManagementPanel gpaManagementPanel;
	private JTabbedPane tabbedPane;
	private IntroduceDialog introduceDialog;
	private JLabel lblUser;
	private JLabel lblRole;
	private JMenuItem mmQuanLySinhVien;
	private JMenuItem mmQuanLyDiem;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StudentView frame = new StudentView();
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
	public StudentView() {
//		this.displayModalDialog();
		this.displaDangNhap();
		this.displayChaoJDialog();
		this.setTitle("Student Management");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(StudentView.class.getResource("/IMG_JavaIcon/color-catalog-icon.png")));
		StudentCTLView studentCTL = new StudentCTLView(this);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setUndecorated(true);
		this.setDefaultCloseOperation(0);
		setBounds(100, 100, 586, 661);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Hệ Thống");
		menuBar.add(mnNewMenu);

		JMenuItem mmDangXuat = new JMenuItem("Đăng xuất");
		mmDangXuat.addActionListener(studentCTL);
		mmDangXuat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		mmDangXuat.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/box-out-icon24.png")));
		mnNewMenu.add(mmDangXuat);

		JMenuItem mmThoat = new JMenuItem("Thoát");
		mmThoat.addActionListener(studentCTL);
		mmThoat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		mmThoat.setIcon(
				new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/ModernXP-02-System-Power-icon.png")));
		mnNewMenu.add(mmThoat);

		JMenu mnNewMenu_1 = new JMenu("Quản Lý");
		menuBar.add(mnNewMenu_1);

		mmQuanLySinhVien = new JMenuItem("Quản lý sinh viên");
		mmQuanLySinhVien.addActionListener(studentCTL);
		mmQuanLySinhVien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		mmQuanLySinhVien.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/Student-3-icon24.png")));
		mnNewMenu_1.add(mmQuanLySinhVien);

		mmQuanLyDiem = new JMenuItem("Quản lý điểm");
		mmQuanLyDiem.addActionListener(studentCTL);
		mmQuanLyDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		mmQuanLyDiem.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/archive-folders-icon24.png")));
		mnNewMenu_1.add(mmQuanLyDiem);

		JMenu mnNewMenu_2 = new JMenu("Trợ Giúp");
		menuBar.add(mnNewMenu_2);

		JMenuItem mmNoiDung = new JMenuItem("Nội dung");
		mmNoiDung.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/Content-icon24.png")));
		mnNewMenu_2.add(mmNoiDung);

		JMenuItem mmGioiThieu = new JMenuItem("Giới thiệu");
		mmGioiThieu.setActionCommand("Intro");
		mmGioiThieu.addActionListener(studentCTL);
		mmGioiThieu.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/Information-icon24.png")));
		mnNewMenu_2.add(mmGioiThieu);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(new Color(255, 255, 255));
		toolBar.setBounds(0, 0, 183, 33);
		contentPane.add(toolBar);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setActionCommand("Out");
		btnNewButton.addActionListener(studentCTL);
		btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/box-out-icon24.png")));
		toolBar.add(btnNewButton);

		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setActionCommand("St");
		btnNewButton_1.addActionListener(studentCTL);
		btnNewButton_1.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/Student-3-icon24.png")));
		toolBar.add(btnNewButton_1);

		btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setActionCommand("GPA");
		btnNewButton_2.addActionListener(studentCTL);
		btnNewButton_2
				.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/archive-folders-icon24.png")));
		toolBar.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setActionCommand("Intro");
		btnNewButton_3.addActionListener(studentCTL);
		btnNewButton_3.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JavaIcon/Information-icon24.png")));
		toolBar.add(btnNewButton_3);
		
//
//		lblNewLabel = new JLabel("");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
////		lblNewLabel.setIcon(new ImageIcon(StudentView.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
//		lblNewLabel.setBounds(0, 96, 549, 296);
//		
//
//		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/logo-truong-fpt_043152255.png"));
//		Image img = ImageHelper.resize(icon.getImage(), 400, 200);
//		this.lblNewLabel.setIcon(new ImageIcon(img));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(10, 44, 576, 584);
		contentPane.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("", null, panel_1, null);
		panel_1.setLayout(null);


		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(393, 0, 193, 43);
		contentPane.add(panel);
		panel.setLayout(null);

		lblUser = new JLabel("");
		lblUser.setForeground(new Color(0, 128, 255));
		lblUser.setIcon(null);
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Bauhaus 93", Font.PLAIN, 11));
		lblUser.setBounds(10, 0, 163, 14);
		panel.add(lblUser);

		lblRole = new JLabel("");
		lblRole.setForeground(new Color(255, 128, 64));
		lblRole.setIcon(null);
		lblRole.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRole.setFont(new Font("Bauhaus 93", Font.PLAIN, 11));
		lblRole.setBounds(20, 25, 153, 14);
		panel.add(lblRole);

		this.processLoginSuccessful();
		this.setUndecorated(true);
		this.addWindowListener(studentCTL);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void exitForm() {
		int select = JOptionPane.showConfirmDialog(this, "Do you want Exit?", "Exit", JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void newStudentManagementPanel() {
		if (this.studentManagementPanel == null) {
			this.studentManagementPanel = new StudentManagementPanel();
			ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JavaIcon/Student-3-icon24.png"));
			this.tabbedPane.addTab("Quản lý sinh viên", icon, this.studentManagementPanel, "Quản lý sinh viên");
		}
		// Đặt thành phần đã chọn cho tabbedpane này.
		this.tabbedPane.setSelectedComponent(this.studentManagementPanel);
	}

	public void newGPAManagementPanel() {
		if (this.gpaManagementPanel == null) {
			this.gpaManagementPanel = new GPAManagementPanel();
			ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JavaIcon/archive-folders-icon24.png"));
			this.tabbedPane.addTab("Quản lý điểm", icon, this.gpaManagementPanel, "Quản lý điểm");
		}
		this.tabbedPane.setSelectedComponent(this.gpaManagementPanel);
	}

	public void disPlayIntroduceDialog() {
		if (this.introduceDialog == null) {
			IntroduceDialog itr = new IntroduceDialog();
			itr.setModal(true);
			itr.setVisible(true);
		}
	}
//
//	public void displayModalDialog() {
//		StudentDialog stu = new StudentDialog();
//		stu.setModal(true);
////		stu.setUndecorated(true); // Loại bỏ chữ X để thoát Jdialog
//		stu.setDefaultCloseOperation(0);
//		stu.setVisible(true);
//		this.processLoginSuccessful();
//	}

	public void displayOutUser() {
		this.setVisible(false);
		this.displaDangNhap();
		this.setVisible(true);
	}

	public void displaDangNhap() {
		try {
			DangNhapJDialog stu = new DangNhapJDialog();
			stu.setModal(true);
//		stu.setUndecorated(true); // Loại bỏ chữ X để thoát Jdialog
			stu.setDefaultCloseOperation(0);
			stu.setVisible(true);
			this.processLoginSuccessful();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void outUser() {
		if (MessageDialog.showConfirmDialog(this, "Do you want Out?", "Exit") == JOptionPane.NO_OPTION) {
			return;
		}
		this.gpaManagementPanel = null;
		this.studentManagementPanel = null;
		ShareData.userData = null;
		this.lblUser.setText("");
		this.lblRole.setText("");
//		this.displayModalDialog();
		this.displaDangNhap();
	}

	public void processLoginSuccessful() {
		this.lblUser.setText(ShareData.userData.getUser());
		this.lblRole.setText(ShareData.userData.getRole());
		this.tabbedPane.removeAll();
		if (ShareData.userData.getRole().equals("admin")) {
			this.btnNewButton_1.setEnabled(false);
			this.btnNewButton_2.setEnabled(true);
			this.mmQuanLyDiem.setEnabled(true);
			this.mmQuanLySinhVien.setEnabled(false);
		} else if (ShareData.userData.getRole().equals("user")) {
			this.btnNewButton_1.setEnabled(true);
			this.btnNewButton_2.setEnabled(false);
			this.mmQuanLyDiem.setEnabled(false);
			this.mmQuanLySinhVien.setEnabled(true);
		}
	}

	public void displayChaoJDialog() {
		ChaoJDialog chaoJDialog = new ChaoJDialog();
		chaoJDialog.setModal(true);
//		chaoJDialog.setUndecorated(true);
		chaoJDialog.setVisible(true);
	}
}
