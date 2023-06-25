package com.raven.main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.form.Form_Home;
import com.raven.form.MainForm;

import controller.MainFrameCTL;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLayeredPane;

import java.awt.BorderLayout;
import java.awt.Color;

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
		init();
		setUndecorated(true);
		setBackground(Color.BLUE);
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
		mainForm.showForm(new Form_Home());
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
