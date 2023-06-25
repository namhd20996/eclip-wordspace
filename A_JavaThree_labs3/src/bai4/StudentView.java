package bai4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_FirstName;
	private JTextField textField_LastName;
	private JTextField textField_Contact;
	private JTextField textField_Highest;
	private JTextField textField_Specitifi;
	private JTextField textField_Enroll;
	private JTextField textField_Hobbies;
	private JTextField textField_Sport;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StudentView frame = new StudentView();
					frame.setLocationRelativeTo(null);
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
		StudentController ctl = new StudentController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 128, 64), null));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(
						new TitledBorder(
								new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255),
										new Color(160, 160, 160)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"Personal Details", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 39, 418, 190);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setBounds(37, 28, 72, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Last name");
		lblNewLabel_1.setBounds(37, 53, 72, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Contact");
		lblNewLabel_1_1.setBounds(37, 78, 72, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setBounds(37, 103, 72, 14);
		panel.add(lblNewLabel_1_2);

		textField_FirstName = new JTextField();
		textField_FirstName.setBounds(119, 23, 289, 20);
		panel.add(textField_FirstName);
		textField_FirstName.setColumns(10);

		textField_LastName = new JTextField();
		textField_LastName.setColumns(10);
		textField_LastName.setBounds(119, 50, 289, 20);
		panel.add(textField_LastName);

		textField_Contact = new JTextField();
		textField_Contact.setColumns(10);
		textField_Contact.setBounds(119, 75, 289, 20);
		panel.add(textField_Contact);

		textArea = new JTextArea();

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(117, 103, 291, 76);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Acamedic Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 240, 418, 114);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1_2_1 = new JLabel("Highest qualifition");
		lblNewLabel_1_2_1.setBounds(41, 25, 96, 14);
		panel_1.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("Specification");
		lblNewLabel_1_2_1_1.setBounds(41, 50, 68, 14);
		panel_1.add(lblNewLabel_1_2_1_1);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Enroll for");
		lblNewLabel_1_2_1_2.setBounds(41, 75, 68, 14);
		panel_1.add(lblNewLabel_1_2_1_2);

		textField_Highest = new JTextField();
		textField_Highest.setColumns(10);
		textField_Highest.setBounds(146, 22, 262, 20);
		panel_1.add(textField_Highest);

		textField_Specitifi = new JTextField();
		textField_Specitifi.setColumns(10);
		textField_Specitifi.setBounds(146, 47, 262, 20);
		panel_1.add(textField_Specitifi);

		textField_Enroll = new JTextField();
		textField_Enroll.setColumns(10);
		textField_Enroll.setBounds(146, 72, 262, 20);
		panel_1.add(textField_Enroll);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(
				new TitledBorder(null, "Extracurricular Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(10, 365, 418, 84);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_1_2_1_3 = new JLabel("Hobbies");
		lblNewLabel_1_2_1_3.setBounds(42, 22, 67, 14);
		panel_1_1.add(lblNewLabel_1_2_1_3);

		JLabel lblNewLabel_1_2_1_4 = new JLabel("Sport");
		lblNewLabel_1_2_1_4.setBounds(42, 51, 67, 14);
		panel_1_1.add(lblNewLabel_1_2_1_4);

		textField_Hobbies = new JTextField();
		textField_Hobbies.setColumns(10);
		textField_Hobbies.setBounds(119, 19, 289, 20);
		panel_1_1.add(textField_Hobbies);

		textField_Sport = new JTextField();
		textField_Sport.setColumns(10);
		textField_Sport.setBounds(119, 48, 289, 20);
		panel_1_1.add(textField_Sport);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBounds(10, 479, 418, 67);
		contentPane.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(45, 11, 89, 45);
		panel_1_1_1.add(btnSave);
		btnSave.addActionListener(ctl);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(170, 11, 89, 45);
		panel_1_1_1.add(btnReset);
		btnReset.addActionListener(ctl);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(289, 11, 89, 45);
		panel_1_1_1.add(btnExit);
		btnExit.addActionListener(ctl);

		JLabel lblStudent = new JLabel("STUDENT  REGISTRATION");
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStudent.setForeground(new Color(128, 128, 255));
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setBounds(62, 11, 349, 29);
		contentPane.add(lblStudent);
	}

	public boolean checkForm() {
		if (this.textField_FirstName.getText().equals("") || this.textField_LastName.getText().equals("")
				|| this.textField_Contact.getText().equals("") || this.textArea.getText().equals("")
				|| this.textField_Highest.getText().equals("") || this.textField_Specitifi.getText().equals("")
				|| this.textField_Enroll.getText().equals("") || this.textField_Hobbies.getText().equals("")
				|| this.textField_Sport.getText().equals("")) {
			return false;
		}

		return true;
	}
	
	public void setValueForm() {
		if(this.checkForm()) {
			String str = "";
			str = str + "First name: "+ this.textField_FirstName.getText() +"\n";
			str = str + "Last name: "+ this.textField_LastName.getText() +"\n";
			str = str + "Contact: "+ this.textField_Contact.getText() +"\n";
			str = str + "Address: "+ this.textArea.getText() +"\n";
			str = str + "Highest qualifition: "+ this.textField_Highest.getText() +"\n";
			str = str + "Specification: "+ this.textField_Specitifi.getText() +"\n";
			str = str + "Enroll for: "+ this.textField_Enroll.getText() +"\n";
			str = str + "Hobbies: "+ this.textField_Hobbies.getText() +"\n";
			str = str + "Sport: "+ this.textField_Sport.getText() +"\n";
			JOptionPane.showMessageDialog(this, str);
		}else {
			JOptionPane.showMessageDialog(this, "Fail");
		}
	}
	
	public void resetForm() {
		this.textField_FirstName.setText("");
		this.textField_LastName.setText("");
		this.textField_Contact.setText("");
		this.textArea.setText("");
		this.textField_Highest.setText("");
		this.textField_Specitifi.setText("");
		this.textField_Enroll.setText("");
		this.textField_Hobbies.setText("");
		this.textField_Sport.setText("");
		this.textField_FirstName.requestFocus();
	}
	
	public void exitForm() {
		int select = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát?", "Exit", JOptionPane.YES_NO_OPTION);
		if(select == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
