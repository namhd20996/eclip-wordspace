package test;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import component.Header;
import component.Menu;
import controller.MainFrameCTL;
import lib.Auth;
import lib.XImage;
import net.miginfocom.swing.MigLayout;
import view.ChaoJDialog;
import view.DangNhapJDialog;
import view.Form_ToaNha;
import view.MainForm;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private MigLayout layout;
	private Menu menu;
	private Header header;
	public MainForm mainForm;
	private JLayeredPane layeredPane;
	private Animator animator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		if (!Auth.isLogin()) {
			displayDangNhapJDialog();
			displayChaoJDialog();
		}
		MainFrameCTL ctl = new MainFrameCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setForeground(Color.white);
		layeredPane.setOpaque(true);
//		layeredPane.setBackground(Color.blue);
		layeredPane.setBounds(-12, 0, 1200, 660);
		contentPane.add(layeredPane);

//		displayUserAndRole();
		init();
		setUndecorated(true);
		setBackground(Color.BLUE);
		setLocationRelativeTo(null);
	}

	private void init() {
		try {
			MainFrameCTL ctl = new MainFrameCTL(this);
			layout = new MigLayout("fill", "[]0[100%, fill]0", "0[fill, top]0");
			layeredPane.setLayout(layout);
			menu = new Menu();
			header = new Header();
			mainForm = new MainForm();
			if (Auth.user != null) {
				ImageIcon icon = null;
				if (Auth.user.getHinhAnh() != null) {
					Image img = XImage.createImageFromByteArray(Auth.user.getHinhAnh(), "jpg");
					icon = new ImageIcon(img);
				} else {
					icon = new ImageIcon(Form_ToaNha.class.getResource("/icon/BGToaNha.png"));
				}
				header.displayRole(Auth.user.getMaNhanVien(), Auth.user.isVaiTro() ? "Admin" : "User", icon);
			}
			menu.setEvent(ctl);
			menu.initMenuItem();
			layeredPane.add(menu, "w 180!, spany 2");
			layeredPane.add(header, "h 50!, wrap");
			layeredPane.add(mainForm, "w 100%, h 100%");
			TimingTarget target = new TimingTargetAdapter() {
				@Override
				public void timingEvent(float fraction) {
					double width;
					if (menu.isShowMenu()) {
						width = 60 + (120 * (1f - fraction));
					} else {
						width = 60 + (120 * fraction);
					}
					layout.setComponentConstraints(menu, "w " + width + "!, spany2");
					menu.revalidate();
				}

				@Override
				public void end() {
					menu.setShowMenu(!menu.isShowMenu());
					menu.setEnableMenu(true);
				}
			};

			animator = new Animator(500, target);
			animator.setResolution(0);
			animator.setDeceleration(0.5f);
			animator.setAcceleration(0.5f);
			header.addMenuEvent(ctl);
			mainForm.showForm(new view.Form_Home());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayDangNhapJDialog() {
		System.out.println("Hello");
		DangNhapJDialog dangNhapJDialog = new DangNhapJDialog();
		dangNhapJDialog.setModal(true);
		dangNhapJDialog.setVisible(true);
	}

	public void displayChaoJDialog() {
		ChaoJDialog chaoJDialog = new ChaoJDialog();
		chaoJDialog.setModal(true);
		chaoJDialog.setVisible(true);
	}

	public void logOut() {
		try {
			Auth.clear();
			this.setVisible(false);
			displayDangNhapJDialog();
			this.setVisible(true);
			if (Auth.user != null) {
				ImageIcon icon = null;
				if (Auth.user.getHinhAnh() != null) {
					Image img = XImage.createImageFromByteArray(Auth.user.getHinhAnh(), "jpg");
					icon = new ImageIcon(img);
				} else {
					icon = new ImageIcon(Form_ToaNha.class.getResource("/icon/BGToaNha.png"));
				}
				header.displayRole(Auth.user.getMaNhanVien(), Auth.user.isVaiTro() ? "Admin" : "User", icon);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionFormSize() {
		if (!animator.isRunning()) {
			animator.start();
		}
		menu.setEnableMenu(false);
		if (menu.isShowMenu()) {
			// Ẩn các item hiện ra khi đóng mở header
			menu.hideallMenu();
		}
	}
}
