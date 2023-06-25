package view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MainFrameCTL;
import lib.XImage;

import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JComboBox;

public class MainJframe extends JFrame {

	private JPanel contentPane;
	private Color defaultColor, clickedColor;
	private JPanel pnlMenu_3;
	private JPanel pnlMenu_2;
	private JPanel pnlMenu_1;
	private JLabel lblHeader;
	private JDesktopPane desktopPane;
	private JLabel lblMenu;

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
		defaultColor = new Color(13, 36, 51);
		clickedColor = new Color(240, 151, 57);
		MainFrameCTL ctl = new MainFrameCTL(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1088, 665);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1088, 665);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(0, 0, 1088, 76);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1040, 11, 48, 22);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Quản Lý Nhà Trọ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_2.setBounds(476, 11, 244, 36);
		panel_1.add(lblNewLabel_2);

		lblHeader = new JLabel("Menu");
		lblHeader.setIcon(new ImageIcon(MainJframe.class.getResource("/icon/menu.png")));
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblHeader.setBounds(22, 11, 244, 36);
		panel_1.add(lblHeader);
		
		lblMenu = new JLabel("");
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMenu.setForeground(new Color(255, 255, 255));
		lblMenu.setBounds(61, 43, 213, 22);
		panel_1.add(lblMenu);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(13, 36, 51));
		panel_2.setBounds(0, 76, 192, 589);
		panel.add(panel_2);
		panel_2.setLayout(null);

		pnlMenu_1 = new JPanel();
		pnlMenu_1.setName("Menu_1");
		pnlMenu_1.addMouseListener(ctl);
		pnlMenu_1.setBackground(new Color(13, 36, 51));
		pnlMenu_1.setBounds(10, 48, 172, 39);
		panel_2.add(pnlMenu_1);
		pnlMenu_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Quản lý phòng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon(MainJframe.class.getResource("/com/raven/icon/1.png")));
		lblNewLabel_1.setBounds(26, 11, 136, 17);
		pnlMenu_1.add(lblNewLabel_1);

		pnlMenu_2 = new JPanel();
		pnlMenu_2.setName("Menu_2");
		pnlMenu_2.addMouseListener(ctl);
		pnlMenu_2.setLayout(null);
		pnlMenu_2.setBackground(new Color(13, 36, 51));
		pnlMenu_2.setBounds(10, 104, 172, 39);
		panel_2.add(pnlMenu_2);

		JLabel lblNewLabel_1_1 = new JLabel("Menu_1");
		lblNewLabel_1_1.setIcon(new ImageIcon(MainJframe.class.getResource("/com/raven/icon/6.png")));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(47, 11, 88, 17);
		pnlMenu_2.add(lblNewLabel_1_1);

		pnlMenu_3 = new JPanel();
		pnlMenu_3.setName("Menu_3");
		pnlMenu_3.addMouseListener(ctl);
		pnlMenu_3.setLayout(null);
		pnlMenu_3.setBackground(new Color(13, 36, 51));
		pnlMenu_3.setBounds(10, 154, 172, 39);
		panel_2.add(pnlMenu_3);

		JLabel lblNewLabel_1_2 = new JLabel("Menu_1");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(47, 11, 88, 17);
		pnlMenu_3.add(lblNewLabel_1_2);

		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBackground(new Color(13, 36, 51));
		panel_3_3.setBounds(10, 204, 172, 39);
		panel_2.add(panel_3_3);

		JLabel lblNewLabel_1_3 = new JLabel("Menu_1");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(47, 11, 88, 17);
		panel_3_3.add(lblNewLabel_1_3);

		JPanel panel_3_4 = new JPanel();
		panel_3_4.setLayout(null);
		panel_3_4.setBackground(new Color(13, 36, 51));
		panel_3_4.setBounds(10, 254, 172, 39);
		panel_2.add(panel_3_4);

		JLabel lblNewLabel_1_4 = new JLabel("Menu_1");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(47, 11, 88, 17);
		panel_3_4.add(lblNewLabel_1_4);

		JPanel panel_3_5 = new JPanel();
		panel_3_5.setLayout(null);
		panel_3_5.setBackground(new Color(13, 36, 51));
		panel_3_5.setBounds(10, 304, 172, 39);
		panel_2.add(panel_3_5);

		JLabel lblNewLabel_1_5 = new JLabel("Menu_1");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(47, 11, 88, 17);
		panel_3_5.add(lblNewLabel_1_5);

		JPanel panel_3_6 = new JPanel();
		panel_3_6.setLayout(null);
		panel_3_6.setBackground(new Color(13, 36, 51));
		panel_3_6.setBounds(10, 354, 172, 39);
		panel_2.add(panel_3_6);

		JLabel lblNewLabel_1_6 = new JLabel("Menu_1");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(47, 11, 88, 17);
		panel_3_6.add(lblNewLabel_1_6);

		JPanel panel_3_7 = new JPanel();
		panel_3_7.setLayout(null);
		panel_3_7.setBackground(new Color(13, 36, 51));
		panel_3_7.setBounds(10, 404, 172, 39);
		panel_2.add(panel_3_7);

		JLabel lblNewLabel_1_7 = new JLabel("Menu_1");
		lblNewLabel_1_7.setForeground(Color.WHITE);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_7.setBounds(10, 11, 50, 17);
		panel_3_7.add(lblNewLabel_1_7);

		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 255, 255));
		desktopPane.setBounds(202, 76, 897, 589);
		panel.add(desktopPane);
		desktopPane.setLayout(new BorderLayout(0, 0));

		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}

	public void clickedColorMenu_1() {
		pnlMenu_1.setBackground(clickedColor);
		pnlMenu_2.setBackground(defaultColor);
		pnlMenu_3.setBackground(defaultColor);
		lblMenu.setText("Quản lý phòng");
		desktopPane.removeAll();
		desktopPane.add(new Form_1()).setVisible(true);
	}

	public void clickedColorMenu_2() {
		pnlMenu_1.setBackground(defaultColor);
		pnlMenu_2.setBackground(clickedColor);
		pnlMenu_3.setBackground(defaultColor);
		desktopPane.removeAll();
		desktopPane.add(new Form_2()).setVisible(true);
	}

	public void clickedColorMenu_3() {
		pnlMenu_1.setBackground(defaultColor);
		pnlMenu_2.setBackground(defaultColor);
		pnlMenu_3.setBackground(clickedColor);
	}
}
