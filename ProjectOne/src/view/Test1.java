package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Test1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 frame = new Test1();
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
	public Test1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Test test = new Test();
		test.setPrice("cc");
		test.setPname("cc");
		test.setName("");
		test.setBounds(10, 11, 222, 283);
		contentPane.add(test);
		
		Test test_1 = new Test();
		test_1.setBounds(252, 11, 222, 283);
		contentPane.add(test_1);
		
		Test test_1_1 = new Test();
		test_1_1.setBounds(484, 11, 222, 283);
		contentPane.add(test_1_1);
	}
}
