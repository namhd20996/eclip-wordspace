package view_bai1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Bai_01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_1_2;
	private JComboBox comboBox;
	private JLabel lblNewLabel_1_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Bai_01 frame = new Bai_01();
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
	public Bai_01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 326);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staff Edition");
		lblNewLabel.setBounds(93, 11, 111, 14);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Staff Id");
		lblNewLabel_1.setBounds(10, 41, 73, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Full name");
		lblNewLabel_1_1.setBounds(10, 65, 89, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(68, 40, 325, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(68, 64, 325, 20);
		textField_1.setColumns(10);
		contentPane.add(textField_1);
		
		lblNewLabel_1_2 = new JLabel("Country");
		lblNewLabel_1_2.setBounds(10, 90, 48, 14);
		contentPane.add(lblNewLabel_1_2);
		
		String [] country = new String[] {"Việt Nam", "Mỹ"};
		comboBox = new JComboBox();
		comboBox.addItem("");
		for (String string : country) {
			comboBox.addItem(string);
		}
		comboBox.setBounds(68, 86, 130, 22);
		contentPane.add(comboBox);
		
		lblNewLabel_1_3 = new JLabel("Country");
		lblNewLabel_1_3.setBounds(10, 119, 48, 14);
		contentPane.add(lblNewLabel_1_3);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(58, 117, 64, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFelmale = new JRadioButton("Female");
		rdbtnFelmale.setBounds(124, 117, 98, 23);
		contentPane.add(rdbtnFelmale);
		
		buttonGroup.add(rdbtnFelmale);
		buttonGroup.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Status");
		lblNewLabel_1_3_1.setBounds(10, 145, 48, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Single");
		chckbxNewCheckBox.setBounds(58, 147, 89, 14);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Note");
		lblNewLabel_1_3_1_1.setBounds(10, 170, 48, 14);
		contentPane.add(lblNewLabel_1_3_1_1);
		
		JTextArea jTextArea = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(jTextArea);
		scrollPane.setBounds(58, 168, 335, 81);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(10, 260, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(109, 260, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(211, 260, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(304, 260, 89, 23);
		contentPane.add(btnReset);
		
		this.setLocationRelativeTo(null);
	}
}
