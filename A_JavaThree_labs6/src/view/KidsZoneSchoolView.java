package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.KidsZoneSchoolCTL;
import dao.KidsZoneSchoolDAO;
import model.Data;
import model.KidsZoneSchoolModel;
import model.ListKidsZoneSchoolModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.ArrayList;

public class KidsZoneSchoolView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_Name;
	private JTextField textField_ParentName;
	private JTextField textField_ContactNo;
	private ListKidsZoneSchoolModel listKidsZoneSchoolModel;
	private JComboBox comboBox_Standard;
	private JComboBox comboBox_Fees;
	private JTextArea textArea;
	private ListKidsZoneSchoolModel líKidsZoneSchoolModel;
	private int count = 0;
	private JButton btnNew;
	private JButton btnInsert;
	private JButton btnEdit;
	private JButton btnNext;
	private JButton btnPrevious;
	private JButton btnDelete;
	private JButton btnExit;
	private JButton btnUpdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					KidsZoneSchoolView frame = new KidsZoneSchoolView();
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
	public KidsZoneSchoolView() {
		this.setTitle("Student");
		this.listKidsZoneSchoolModel = new ListKidsZoneSchoolModel();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(KidsZoneSchoolView.class.getResource("/img/color-catalog-icon.png")));
		this.listKidsZoneSchoolModel = new ListKidsZoneSchoolModel();
		KidsZoneSchoolCTL kidsZoneSchoolCTL = new KidsZoneSchoolCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "Standard" }));
		table.addMouseListener(kidsZoneSchoolCTL);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 262, 363);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(330, 18, 48, 14);
		contentPane.add(lblNewLabel);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(330, 43, 48, 14);
		contentPane.add(lblAddress);

		JLabel lblParentname = new JLabel("ParentName:");
		lblParentname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblParentname.setBounds(282, 159, 96, 14);
		contentPane.add(lblParentname);

		JLabel lblContactno = new JLabel("ContactNo:");
		lblContactno.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContactno.setBounds(229, 190, 149, 14);
		contentPane.add(lblContactno);

		JLabel lblStandard = new JLabel("Standard:");
		lblStandard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStandard.setBounds(330, 223, 48, 14);
		contentPane.add(lblStandard);

		JLabel lblFees = new JLabel("Fees:");
		lblFees.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFees.setBounds(330, 256, 48, 14);
		contentPane.add(lblFees);

		textField_Name = new JTextField();
		textField_Name.setEnabled(false);
		textField_Name.setBounds(388, 15, 190, 20);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);

		textField_ParentName = new JTextField();
		textField_ParentName.setEnabled(false);
		textField_ParentName.setColumns(10);
		textField_ParentName.setBounds(388, 156, 292, 20);
		contentPane.add(textField_ParentName);

		textField_ContactNo = new JTextField();
		textField_ContactNo.setEnabled(false);
		textField_ContactNo.setColumns(10);
		textField_ContactNo.setBounds(388, 187, 190, 20);
		contentPane.add(textField_ContactNo);

		textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setBounds(388, 46, 292, 99);
		contentPane.add(textArea);

		String[] arrS = { "1m60", "1m70", "1m80", "1m90" };
		comboBox_Standard = new JComboBox();
		comboBox_Standard.addItem("");
		for (String string : arrS) {
			comboBox_Standard.addItem(string);
		}
		comboBox_Standard.setEnabled(false);
		comboBox_Standard.setBounds(388, 219, 190, 22);
		contentPane.add(comboBox_Standard);

		Double[] arrF = { 400.0, 500.0, 600.0, 700.0, 800.0 };
		comboBox_Fees = new JComboBox();
		comboBox_Fees.addItem("");
		for (Double string : arrF) {
			comboBox_Fees.addItem(string);
		}
		comboBox_Fees.setEnabled(false);
		comboBox_Fees.setBounds(388, 252, 292, 22);
		contentPane.add(comboBox_Fees);

		btnNew = new JButton("New");
		btnNew.addActionListener(kidsZoneSchoolCTL);
		btnNew.setBounds(330, 319, 89, 23);
		contentPane.add(btnNew);

		btnInsert = new JButton("Insert");
		btnInsert.setEnabled(false);
		btnInsert.addActionListener(kidsZoneSchoolCTL);
		btnInsert.setBounds(423, 319, 89, 23);
		contentPane.add(btnInsert);

		btnEdit = new JButton("Edit");
		btnEdit.setActionCommand("E");
		btnEdit.addActionListener(kidsZoneSchoolCTL);
		btnEdit.setBounds(512, 319, 89, 23);
		contentPane.add(btnEdit);

		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(kidsZoneSchoolCTL);
		btnUpdate.setBounds(601, 319, 89, 23);
		contentPane.add(btnUpdate);

		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(kidsZoneSchoolCTL);
		btnNext.setBounds(330, 351, 89, 23);
		contentPane.add(btnNext);

		btnPrevious = new JButton("Previous");
		btnPrevious.setEnabled(false);
		btnPrevious.addActionListener(kidsZoneSchoolCTL);
		btnPrevious.setBounds(423, 351, 89, 23);
		contentPane.add(btnPrevious);

		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(kidsZoneSchoolCTL);
		btnDelete.setBounds(512, 351, 89, 23);
		contentPane.add(btnDelete);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(kidsZoneSchoolCTL);
		btnExit.setBounds(601, 351, 89, 23);
		contentPane.add(btnExit);

		this.listKidsZoneSchoolModel.setListKidsZoneSchool(KidsZoneSchoolDAO.getInstance().selectAll());
		for (KidsZoneSchoolModel string : this.listKidsZoneSchoolModel.getListKidsZoneSchool()) {
			this.displayTable(string);
		}

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void resetForm() {
		this.textField_Name.setText("");
		this.textArea.setText("");
		this.textField_ParentName.setText("");
		this.textField_ContactNo.setText("");
		this.comboBox_Standard.setSelectedIndex(-1);
		this.comboBox_Fees.setSelectedIndex(-1);
		this.textField_Name.setEnabled(true);
		this.textArea.setEnabled(true);
		this.textField_ParentName.setEnabled(true);
		this.textField_ContactNo.setEnabled(true);
		this.comboBox_Standard.setEnabled(true);
		this.comboBox_Fees.setEnabled(true);
		this.textField_Name.requestFocus();
	}

	public void enabledBTN() {
		this.btnInsert.setEnabled(true);
		this.btnUpdate.setEnabled(true);
		this.btnDelete.setEnabled(true);
		this.btnNext.setEnabled(true);
		this.btnPrevious.setEnabled(true);
		this.textField_Name.setEnabled(true);
		this.textArea.setEnabled(true);
		this.textField_ParentName.setEnabled(true);
		this.textField_ContactNo.setEnabled(true);
		this.comboBox_Standard.setEnabled(true);
		this.comboBox_Fees.setEnabled(true);
	}

	public boolean checkFormValue() {
		if (this.textField_Name.getText().equals("")) {
			return false;
		} else {
			String name = this.textField_Name.getText();
			if (!Data.isHoTen(name)) {
				return false;
			}
		}

		if (this.textArea.getText().equals("")) {
			return false;
		} else {
			String address = this.textArea.getText();
			if (!Data.isID(address)) {
				return false;
			}
		}

		if (this.textField_ParentName.getText().equals("")) {
			return false;
		} else {
			String parentName = this.textField_ParentName.getText();
			if (!Data.isHoTen(parentName)) {
				return false;
			}
		}

		if (this.textField_ContactNo.getText().equals("")) {
			return false;
		} else {
			String parentName = this.textField_ContactNo.getText();
			if (!Data.isSo(parentName)) {
				return false;
			}
		}

		return true;
	}

	public void getValueForm() {
		String name = this.textField_Name.getText().trim();
		String address = this.textArea.getText().trim();
		String parentName = this.textField_ParentName.getText().trim();
		String contactNo = this.textField_ContactNo.getText().trim();
		String standard = this.comboBox_Standard.getSelectedItem().toString();
		double fees = (double) this.comboBox_Fees.getSelectedItem();
		KidsZoneSchoolModel kzs = new KidsZoneSchoolModel(name, address, parentName, contactNo, standard, fees);
		System.out.println(kzs);
		KidsZoneSchoolDAO.getInstance().insert(kzs);
	}

	public void displayTable(KidsZoneSchoolModel kzs) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { kzs.getName(), kzs.getStandard() });
	}

	public void updateTable() {
		if (this.checkFormValue()) {
			KidsZoneSchoolModel k = this.getObjectKids();
			KidsZoneSchoolModel z = new KidsZoneSchoolModel(k.getRegID(), this.textField_Name.getText(),
					this.textArea.getText(), this.textField_ParentName.getText(), this.textField_ContactNo.getText(),
					this.comboBox_Standard.getSelectedItem().toString(),
					Double.valueOf(this.comboBox_Fees.getSelectedItem().toString()));
			this.updateTableView(z);
			KidsZoneSchoolDAO.getInstance().update(z);
		} else {
			JOptionPane.showMessageDialog(this, "Form lỗi");
		}
	}

	public void updateTableView(KidsZoneSchoolModel k) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		model_table.setValueAt(k.getName(), i_row, 0);
		model_table.setValueAt(k.getStandard(), i_row, 1);
	}

	public KidsZoneSchoolModel getObjectKids() {
		ArrayList<KidsZoneSchoolModel> list = this.listKidsZoneSchoolModel.getListKidsZoneSchool();
		int i_row = table.getSelectedRow();
		KidsZoneSchoolModel k = list.get(i_row);
		return k;
	}

	public void deleteTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int select = JOptionPane.showConfirmDialog(this, "Do you want delete", "Delete", JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			KidsZoneSchoolModel k = this.getObjectKids();
			model_table.removeRow(i_row);
			KidsZoneSchoolDAO.getInstance().delete(k);
		}
	}

	public void exitForm() {
		int select = JOptionPane.showConfirmDialog(this, "Do you want exit?", "Exit", JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void displayControl() {
		KidsZoneSchoolModel k = this.getObjectKids();
		this.textField_Name.setText(k.getName());
		this.textArea.setText(k.getAddress());
		this.textField_ParentName.setText(k.getParentName());
		this.textField_ContactNo.setText(k.getContactNo());
		this.comboBox_Standard.setSelectedItem(k.getStandard());
		this.comboBox_Fees.setSelectedItem(k.getFees());
	}

	public void previous() {
		int i_row = table.getSelectedRow();
		count = i_row;
		count--;
		if (count >= 0) {
			this.table.setRowSelectionInterval(count, count);
		} else {
			count = 0;
		}
//		this.table.setRowSelectionInterval(0, 0);
		this.displayControl();
	}

	public void nextT() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int rowCount = model_table.getRowCount();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count < rowCount) {
			this.table.setRowSelectionInterval(count, count);
		} else {
			count = rowCount;
		}
//		this.table.setRowSelectionInterval(0, 0);
		this.displayControl();
	}

}
