package bai1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class DemoLayout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					DemoLayout frame = new DemoLayout();
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
	public DemoLayout() {
		DemoLayoutCTL ctl = new DemoLayoutCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBounds(10, 11, 418, 69);

		JButton jButton_Red = new JButton("Red");
		jButton_Red.addActionListener(ctl);
		JButton jButton_Green = new JButton("Green");
		jButton_Green.addActionListener(ctl);
		JButton jButton_Yellow = new JButton("Yellow");
		jButton_Yellow.addActionListener(ctl);

		panel.add(jButton_Red);
		panel.add(jButton_Green);
		panel.add(jButton_Yellow);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout());
		panel_1.setBounds(10, 91, 418, 113);

		JButton jButton_North = new JButton("North");
		jButton_North.addActionListener(ctl);
		JButton jButton_South = new JButton("South");
		jButton_South.addActionListener(ctl);
		JButton jButton_Center = new JButton("Center");
		jButton_Center.addActionListener(ctl);
		JButton jButton_East = new JButton("East");
		jButton_East.addActionListener(ctl);
		JButton jButton_West = new JButton("West");
		jButton_West.addActionListener(ctl);

		panel_1.add(jButton_North, BorderLayout.NORTH);
		panel_1.add(jButton_South, BorderLayout.SOUTH);
		panel_1.add(jButton_Center, BorderLayout.CENTER);
		panel_1.add(jButton_East, BorderLayout.EAST);
		panel_1.add(jButton_West, BorderLayout.WEST);
		contentPane.add(panel_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(new GridLayout(2, 5));
		panel_2_1.setBounds(10, 265, 418, 113);
		panel_2_1.setBackground(Color.pink);

		for (int i = 0; i < 10; i++) {
			JButton jButton = new JButton();
			panel_2_1.add(jButton);
		}
		contentPane.add(panel_2_1);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(10, 215, 418, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		this.setLocationRelativeTo(null);
	}

	public void changeColor(Color color) {
		this.panel.setBackground(color);
	}

	public void changeText(String string, Color color) {
		this.textField.setText(string);
		this.textField.setForeground(color);
	}
}
