	package bai2;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.ListenerClock;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Font;

public class ViewClock extends JFrame implements Runnable {

	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ViewClock frame = new ViewClock();
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
	public ViewClock() {
		ListenerClock lst = new ListenerClock(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("00 : 00");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(120, 94, 209, 48);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(lst);
		this.setLocationRelativeTo(null);
	}

	public void runTime() {
		Thread thread = new Thread(this);
		thread.start();
		this.btnNewButton.setEnabled(false);
	}

	@Override
	public void run() {
		while (true) {
			Date now = new Date();
			SimpleDateFormat fm = new SimpleDateFormat("hh:mm:ss aa");
			((AbstractButton) this.btnNewButton).setText(fm.format(now));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
