package com.raven.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.form.MainForm;

import controller.MainFrameCTL;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLayeredPane;
import java.awt.Color;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private MigLayout layout;
	private Menu menu;
	private Header header;
	private MainForm mainForm;
	private JLayeredPane layeredPane;

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
		MainFrameCTL ctl = new MainFrameCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setForeground(Color.white);
		layeredPane.setOpaque(true);
		layeredPane.setBounds(0, 0, 1000, 660);
		contentPane.add(layeredPane);
		init();
//		setUndecorated(true);
//		setBackground(getBackground());
		setLocationRelativeTo(null);
	}

	private void init() {
		MainFrameCTL ctl = new MainFrameCTL(this);
		layout = new MigLayout("fill", "[]0[100%, fill]0", "0[fill, top]0");
		layeredPane.setLayout(layout);
		menu = new Menu();
		header = new Header();
		mainForm = new MainForm();
		menu.setEvent(ctl);
		menu.initMenuItem();
		layeredPane.add(menu, "w 200!, spany 2");
		layeredPane.add(header, "h 50!, wrap");
		layeredPane.add(mainForm, "w 100%, h 100%");
	}
}
