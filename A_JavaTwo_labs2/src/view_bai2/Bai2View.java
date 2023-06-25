package view_bai2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;

public class Bai2View extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Bai2View frame = new Bai2View();
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
	public Bai2View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 47, 418, 335);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("EDITION", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staff ID");
		lblNewLabel.setBounds(10, 11, 48, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(64, 8, 339, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(64, 36, 339, 20);
		panel.add(textField_1);
		
		JLabel lblFullname = new JLabel("FullName");
		lblFullname.setBounds(10, 39, 66, 14);
		panel.add(lblFullname);
		
		JLabel lblConutry = new JLabel("Conutry");
		lblConutry.setBounds(10, 64, 48, 14);
		panel.add(lblConutry);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(64, 60, 129, 22);
		panel.add(comboBox);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 89, 48, 14);
		panel.add(lblGender);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(64, 85, 73, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(139, 85, 109, 23);
		panel.add(rdbtnFemale);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFemale);
		buttonGroup.add(rdbtnNewRadioButton);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 114, 48, 14);
		panel.add(lblStatus);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Single?");
		chckbxNewCheckBox.setBounds(64, 111, 99, 23);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setBounds(10, 139, 48, 14);
		panel.add(lblNote);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(64, 141, 339, 110);
		panel.add(textArea);
		
		JButton btnCreate = new JButton("Add");
		btnCreate.setBounds(64, 262, 73, 23);
		panel.add(btnCreate);
		
		JButton btnUpdate = new JButton("Remove");
		btnUpdate.setBounds(139, 262, 91, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(230, 262, 73, 23);
		panel.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(313, 262, 73, 23);
		panel.add(btnReset);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("List", null, panel_1, null);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "FullName", "Country", "Gender", "Status"
			}
		));
		panel_1.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 3, 413, 259);
		panel_1.add(scrollPane);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setBounds(87, 273, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnStore = new JButton("Store");
		btnStore.setBounds(225, 273, 89, 23);
		panel_1.add(btnStore);
		
		JLabel lblNewLabel_1 = new JLabel("Staff Management");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 11, 201, 25);
		contentPane.add(lblNewLabel_1);
		this.setLocationRelativeTo(null);
	}
}
