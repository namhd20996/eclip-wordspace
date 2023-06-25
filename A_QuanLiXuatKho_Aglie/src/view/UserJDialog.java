package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.UserJDialogCTL;
import dao.UserDao;
import lib.DataValidator;
import lib.MaHoa;
import lib.MsgBox;
import model.UserModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

public class UserJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnNew;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPre;
	private JButton btnFirst;
	int count = 0;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtUser;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JLabel lblNewLabel_1;
	private JTextField txtFind;
	private JButton btnFind;
	private JTable table;
	private JLabel lblNewLabel_6;
	private JScrollPane scrollPane;

	private JRadioButton rdoAdmin;
	private JRadioButton rdoUser;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UserJDialog dialog = new UserJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UserJDialog() {
		UserJDialogCTL ctl = new UserJDialogCTL(this);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 675, 533);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(ctl);
		btnAdd.setBounds(10, 499, 57, 23);
		getContentPane().add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setBounds(77, 499, 67, 23);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(ctl);
		btnDelete.setBounds(153, 499, 67, 23);
		getContentPane().add(btnDelete);

		btnNew = new JButton("New");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(230, 499, 57, 23);
		getContentPane().add(btnNew);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(608, 499, 57, 23);
		getContentPane().add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(541, 499, 57, 23);
		getContentPane().add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(474, 499, 57, 23);
		getContentPane().add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(407, 499, 57, 23);
		getContentPane().add(btnFirst);

		JLabel lblNewLabel = new JLabel("Quản lí nhân viên");
		lblNewLabel.setBounds(10, 11, 225, 26);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 255));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 48, 655, 440);
		getContentPane().add(tabbedPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("List", null, panel_1, null);
		panel_1.setLayout(null);

		lblNewLabel_2 = new JLabel("User:");
		lblNewLabel_2.setBounds(10, 11, 48, 14);
		panel_1.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Password:");
		lblNewLabel_3.setBounds(10, 42, 87, 14);
		panel_1.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Role:");
		lblNewLabel_4.setBounds(332, 42, 48, 14);
		panel_1.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setBounds(332, 11, 48, 14);
		panel_1.add(lblNewLabel_5);

		txtUser = new JTextField();
		txtUser.setBounds(66, 8, 233, 20);
		panel_1.add(txtUser);
		txtUser.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(66, 39, 233, 20);
		panel_1.add(txtPassword);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(372, 8, 268, 20);
		panel_1.add(txtEmail);

		rdoAdmin = new JRadioButton("Admin");
		rdoAdmin.setBackground(new Color(255, 255, 255));
		rdoAdmin.setBounds(372, 36, 109, 23);
		panel_1.add(rdoAdmin);

		rdoUser = new JRadioButton("User");
		rdoUser.setBackground(new Color(255, 255, 255));
		rdoUser.setBounds(483, 36, 109, 23);
		panel_1.add(rdoUser);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoAdmin);
		buttonGroup.add(rdoUser);

		lblNewLabel_1 = new JLabel("Tìm kiếm nhân viên:");
		lblNewLabel_1.setBounds(10, 87, 119, 26);
		panel_1.add(lblNewLabel_1);

		txtFind = new JTextField();
		txtFind.setColumns(10);
		txtFind.setBounds(112, 90, 429, 20);
		panel_1.add(txtFind);

		btnFind = new JButton("Find");
		btnFind.setBounds(551, 89, 89, 23);
		panel_1.add(btnFind);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 64));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "User", "Password", "Role", "Email",
				"Mã xác thực", "Thời gian hiệu lực", "Trạng thái xác thực" }));
		table.addMouseListener(ctl);

		lblNewLabel_6 = new JLabel("Danh sách nhân viên:");
		lblNewLabel_6.setBounds(10, 112, 119, 26);
		panel_1.add(lblNewLabel_6);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 149, 630, 252);
		panel_1.add(scrollPane);

		JLabel lbl_Exit = new JLabel("X");
		lbl_Exit.setName("ExitForm");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setForeground(new Color(255, 0, 0));
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setBounds(617, 11, 48, 26);
		getContentPane().add(lbl_Exit);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		upStatus();
		loadDataTable();
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == table.getRowCount() - 1;

		btnAdd.setEnabled(!edit);
		btnUpdate.setEnabled(edit);
		btnDelete.setEnabled(edit);

		btnFirst.setEnabled(edit && !first);
		btnPre.setEnabled(edit && !first);
		btnNext.setEnabled(edit && !last);
		btnLast.setEnabled(edit && !last);
	}

	public void firstElement() {
		count = 0;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count > table.getRowCount() - 1) {
			count = table.getRowCount() - 1;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void lastElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		count = table.getRowCount() - 1;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void displayFormCapNhat() {
		UserModel u = getUser();
		txtUser.setText(u.getUser());
		txtPassword.setText(u.getPassWord());
		txtEmail.setText(u.getEmail());
		if (u.isRole()) {
			rdoAdmin.setSelected(true);
		} else {
			rdoUser.setSelected(true);
		}
		int i_row = table.getSelectedRow();
		count = i_row;
		upStatus();
	}

	public UserModel getUser() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String user = model_table.getValueAt(i_row, 0) + "";
		UserModel u = new UserModel();
		u.setUser(user);
		UserModel ud = UserDao.getInstance().selectByID(u);
		return ud;
	}

	public void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		ArrayList<UserModel> list = UserDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (UserModel userModel : list) {
			model_table.addRow(new Object[] { userModel.getUser(), userModel.getPassWord(), userModel.isRole(),
					userModel.getEmail(), userModel.getMaXacThuc(), userModel.getThoiGianHieuLucMaXacThuc(),
					userModel.isTrangThaiXacThuc() });
		}
	}

	public void reserForm() {
		txtUser.setText("");
		txtPassword.setText("");
		txtEmail.setText("");
		buttonGroup.clearSelection();
		count = -1;
		upStatus();
	}

	public void insertTableTaiKhoan() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtUser, sb, "User null");
		DataValidator.validateEmpty(txtPassword, sb, "Password null");
		DataValidator.validateEmpty(txtEmail, sb, "Email null");
		DataValidator.validateChecked(buttonGroup, sb, "Role null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String user = txtUser.getText();
		String passWord = txtPassword.getText();
		String email = txtEmail.getText();
		boolean role = true;
		if (rdoAdmin.isSelected()) {
			role = true;
		} else {
			role = false;
		}
		UserModel u = new UserModel();
		u.setUser(user);
		u.setPassWord(MaHoa.toSHA1(passWord));
		u.setEmail(email);
		u.setRole(role);
		if (UserDao.getInstance().selectByID(u) != null) {
			if (MsgBox.showConfirmDialog(this, "User đã tồn tại bạn muốn cập nhật",
					"Notificaiton") == JOptionPane.NO_OPTION) {
				return;
			}
			if (UserDao.getInstance().updateTableUserJDialog(u) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notificaiton");
			} else {
				MsgBox.showMessageDialog(this, "Update faill", "Notificaiton");
			}
		} else {
			if (UserDao.getInstance().insert(u) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notificaiton");
			} else {
				MsgBox.showMessageDialog(this, "Insert faill", "Notificaiton");
			}
		}
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}
}
