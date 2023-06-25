package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.ListennerController;
import controller.MouseController;
import model.QLUser;

import model.User;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;
	private JTable table;
	private ButtonGroup buttonGroup;
	private JRadioButton radio_user;
	private JRadioButton radio_admin;
	private QLUser qlUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		this.qlUser = new QLUser();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ListennerController ls = new ListennerController(this);
		MouseController mouseController = new MouseController(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("User Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(20, 11, 173, 24);
		contentPane.add(lblNewLabel);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 418, 205);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("EDITION", null, panel, null);
		panel.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(22, 25, 75, 14);
		panel.add(lblUsername);

		JLabel label_password = new JLabel("Password");
		label_password.setBounds(22, 50, 68, 14);
		panel.add(label_password);

		JLabel lblNewLabel_1_2 = new JLabel("Role");
		lblNewLabel_1_2.setBounds(22, 75, 48, 14);
		panel.add(lblNewLabel_1_2);

		textField_username = new JTextField();
		textField_username.setBounds(92, 22, 311, 20);
		panel.add(textField_username);
		textField_username.setColumns(10);

		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(92, 47, 311, 20);
		panel.add(textField_password);

		radio_user = new JRadioButton("User");
		radio_user.setBounds(92, 71, 53, 23);
		panel.add(radio_user);

		radio_admin = new JRadioButton("Admin");
		radio_admin.setBounds(151, 71, 109, 23);
		panel.add(radio_admin);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(radio_admin);
		buttonGroup.add(radio_user);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(22, 132, 89, 23);
		panel.add(btnAdd);
		btnAdd.addActionListener(ls);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(124, 132, 89, 23);
		panel.add(btnRemove);
		btnRemove.addActionListener(ls);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(314, 132, 89, 23);
		panel.add(btnReset);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(223, 132, 89, 23);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(ls);
		btnReset.addActionListener(ls);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("LIST", null, panel_1, null);
		panel_1.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Username", "Password", "Role" }));
		table.addMouseListener(mouseController);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 393, 155);
		panel_1.add(scrollPane);

		this.setLocationRelativeTo(null);
//		this.addMouseListener(mouseController);
		this.setVisible(true);
	}

	public void resetForm() {
		this.textField_username.setText("");
		this.textField_password.setText("");
		this.buttonGroup.clearSelection();
	}

	public void insertForm() {
		try {
			String username = this.textField_username.getText();
			String password = this.textField_password.getText();
			boolean role = true;
			if (this.radio_user.isSelected()) {
				role = true;
			} else if (this.radio_admin.isSelected()) {
				role = false;
			}
			User user = new User(username, password, role);
			this.themHoacCapNhatUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void insertTable(User user) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table
				.addRow(new Object[] { user.getUserName(), user.getPassWord(), (user.isRole() ? "User" : "Admin"), });
	}

	public void themHoacCapNhatUser(User user) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.qlUser.kiemTraTonTai(user)) {
			this.qlUser.insert(user);
			this.insertTable(user);
			this.resetForm();
		} else {
			this.qlUser.update(user);
			this.resetForm();
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				System.out.println(id);
				if (id.equals(user.getUserName())) {
					model_table.setValueAt(user.getUserName() + "", i, 0);
					model_table.setValueAt(user.getPassWord() + "", i, 1);
					model_table.setValueAt((user.isRole() ? "User" : "Admin"), i, 2);
				}
			}
		}
	}

	public User getUser() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String userName = model_table.getValueAt(i_row, 0) + "";
		String passWord = model_table.getValueAt(i_row, 1) + "";
		String textRole = model_table.getValueAt(i_row, 2) + "";
		boolean role = textRole.equals("User");
		User user = new User(userName, passWord, role);
		return user;
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?");
		if (luaChon == JOptionPane.YES_OPTION) {
			User user = this.getUser();
			this.qlUser.delete(user);
			model_table.removeRow(i_row);
		}
	}
	
	public void updateForm() {
		User user = this.getUser();
		this.textField_username.setText(user.getUserName());
		this.textField_password.setText(user.getPassWord());
		if (user.isRole()) {
			this.radio_user.setSelected(true);
		} else {
			this.radio_admin.setSelected(true);
		}
	}

}
