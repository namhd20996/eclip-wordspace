package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MyNotePadController;
import model.MyNotePadModel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class MyNotePadView extends JFrame {

	private JPanel contentPane;
	public MyNotePadModel model;
	public JLabel lblNewLabel;
	public JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyNotePadView frame = new MyNotePadView();
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
	public MyNotePadView() {
		this.model = new MyNotePadModel();
		MyNotePadController ac = new MyNotePadController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10,50));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 12, 217, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Open");
		btnNewButton.setBounds(226, 10, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(ac);
		
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.setBounds(325, 10, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(ac);
		
		this.setVisible(true);
	}
}
