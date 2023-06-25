package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.MouseListennerGPA;
import controller.DangNhapDialogCTL;
import dao.GPAManagementDAO;
import dao.StudentDAO;
import lib.DataValidator;
import lib.MessageDialog;
import model.GradeModel;
import model.StudentModel;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

public class GPAManagementPanel extends JPanel {
	private JTextField textField_MaSinhVienFind;
	private JTextField textField_MaSinhVien;
	private JTextField textField_HoTen;
	private JTextField textField_TiengAnh;
	private JTextField textField_TinHoc;
	private JTextField textField_GDTC;
	private JTable table;
	private StudentView studentView;
	private JLabel lable_AVG;
	private int count;

	/**
	 * Create the panel.
	 */
	public GPAManagementPanel() {
		MouseListennerGPA mouseListennerGPA = new MouseListennerGPA(this);
		DangNhapDialogCTL ctl = new DangNhapDialogCTL(this);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Quản Lý Điểm");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(10, 11, 153, 22);
		add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 548, 10);
		add(separator);

		JPanel panel = new JPanel();
		panel.setBounds(10, 49, 548, 42);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã sinh viên:");
		lblNewLabel_1.setBounds(10, 11, 98, 14);
		panel.add(lblNewLabel_1);

		textField_MaSinhVienFind = new JTextField();
		textField_MaSinhVienFind.setText("Ps25979");
		textField_MaSinhVienFind.setBounds(85, 8, 254, 20);
		panel.add(textField_MaSinhVienFind);
		textField_MaSinhVienFind.setColumns(10);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(ctl);
		btnFind.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Search-icon.png")));
		btnFind.setBounds(449, 7, 89, 23);
		panel.add(btnFind);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 95, 548, 482);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 255, 255)));
		panel_2.setBounds(10, 11, 295, 181);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Mã sinh viên:");
		lblNewLabel_1_1.setBounds(10, 25, 73, 14);
		panel_2.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Họ tên:");
		lblNewLabel_1_2.setBounds(10, 50, 48, 14);
		panel_2.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Tiếng anh:");
		lblNewLabel_1_3.setBounds(10, 75, 85, 14);
		panel_2.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Tin học:");
		lblNewLabel_1_4.setBounds(10, 106, 48, 14);
		panel_2.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("GDTC:");
		lblNewLabel_1_5.setBounds(10, 137, 48, 14);
		panel_2.add(lblNewLabel_1_5);

		textField_MaSinhVien = new JTextField();
//		textField_MaSinhVien.addFocusListener(ctl);
		textField_MaSinhVien.addKeyListener(ctl);
		textField_MaSinhVien.setText("Ps25979");
		textField_MaSinhVien.setBounds(83, 22, 202, 20);
		panel_2.add(textField_MaSinhVien);
		textField_MaSinhVien.setColumns(10);

		textField_HoTen = new JTextField();
		textField_HoTen.setEnabled(false);
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(83, 47, 202, 20);
		panel_2.add(textField_HoTen);

		textField_TiengAnh = new JTextField();
		textField_TiengAnh.addFocusListener(ctl);
		textField_TiengAnh.setText("8");
		textField_TiengAnh.setColumns(10);
		textField_TiengAnh.setBounds(83, 72, 202, 20);
		panel_2.add(textField_TiengAnh);

		textField_TinHoc = new JTextField();
		textField_TinHoc.addFocusListener(ctl);
		textField_TinHoc.setText("8");
		textField_TinHoc.setColumns(10);
		textField_TinHoc.setBounds(83, 103, 202, 20);
		panel_2.add(textField_TinHoc);

		textField_GDTC = new JTextField();
		textField_GDTC.addFocusListener(ctl);
		textField_GDTC.setText("8");
		textField_GDTC.setColumns(10);
		textField_GDTC.setBounds(83, 134, 202, 20);
		panel_2.add(textField_GDTC);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(325, 11, 116, 181);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Điểm TB:");
		lblNewLabel_1_1_1.setBounds(39, 37, 48, 14);
		panel_3.add(lblNewLabel_1_1_1);

		lable_AVG = new JLabel("0.0");
		lable_AVG.setHorizontalAlignment(SwingConstants.CENTER);
		lable_AVG.setForeground(new Color(255, 0, 0));
		lable_AVG.setFont(new Font("Tahoma", Font.BOLD, 22));
		lable_AVG.setBounds(10, 62, 97, 76);
		panel_3.add(lable_AVG);

		JButton btnNew = new JButton("New");
		btnNew.setActionCommand("N");
		btnNew.addActionListener(ctl);
		btnNew.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Files-New-File-icon.png")));
		btnNew.setBounds(449, 11, 89, 23);
		panel_1.add(btnNew);

		JButton btnSave = new JButton("Save");
		btnSave.setActionCommand("S");
		btnSave.addActionListener(ctl);
		btnSave.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Save-icon.png")));
		btnSave.setBounds(451, 45, 89, 23);
		panel_1.add(btnSave);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setActionCommand("U");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Edit-Document-icon.png")));
		btnUpdate.setBounds(451, 79, 89, 23);
		panel_1.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setActionCommand("D");
		btnDelete.addActionListener(ctl);
		btnDelete.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/File-Delete-icon.png")));
		btnDelete.setBounds(451, 113, 89, 23);
		panel_1.add(btnDelete);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Sv", "Họ tên", "Tiếng anh", "Tin học", "GDTC", "Điểm TB" }));
		table.addMouseListener(mouseListennerGPA);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 242, 528, 229);
		panel_1.add(scrollPane);

		JButton btnFirst = new JButton("");
		btnFirst.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Button-6-next-iconT.png")));
		btnFirst.setActionCommand("F");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(10, 195, 89, 36);
		panel_1.add(btnFirst);

		JButton btnPre = new JButton("");
		btnPre.setActionCommand("Pre");
		btnPre.addActionListener(ctl);
		btnPre.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Button-5-forward-iconT.png")));
		btnPre.setBounds(119, 195, 89, 36);
		panel_1.add(btnPre);

		JButton btnNext = new JButton("");
		btnNext.setActionCommand("Nex");
		btnNext.addActionListener(ctl);
		btnNext.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Button-5-forward-icon.png")));
		btnNext.setBounds(218, 195, 89, 36);
		panel_1.add(btnNext);

		JButton btnLast = new JButton("");
		btnLast.setActionCommand("L");
		btnLast.addActionListener(ctl);
		btnLast.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Button-6-next-icon.png")));
		btnLast.setBounds(317, 195, 89, 36);
		panel_1.add(btnLast);

		this.loadDataTable();
	}

	public void resetFormGPA() {
		this.textField_MaSinhVienFind.setText("");
		this.textField_MaSinhVien.setText("");
		this.textField_HoTen.setText("");
		this.textField_TiengAnh.setText("");
		this.textField_TinHoc.setText("");
		this.textField_GDTC.setText("");
		this.lable_AVG.setText("00.00");
		this.textField_MaSinhVien.requestFocus();
	}

	public boolean checkFormGPA() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(this.textField_MaSinhVien, sb, "Mã sinh viên Null");
		DataValidator.validateIsDiem(this.textField_TiengAnh, sb, "Tiếng anh Null");
		DataValidator.validateIsDiem(this.textField_TinHoc, sb, "Tin học Null");
		DataValidator.validateIsDiem(this.textField_GDTC, sb, "GDTC Null");
		if (sb.length() > 0) {
			MessageDialog.showErrorDialog(this.studentView, sb.toString(), "Error");
			return false;
		}
		return true;
	}

	public void insertTableGrade() {
		if (this.checkFormGPA()) {
			try {
				String maSV = this.textField_MaSinhVien.getText();
				double tiengAnh = Double.valueOf(this.textField_TiengAnh.getText());
				double tinHoc = Double.valueOf(this.textField_TinHoc.getText());
				double GDTC = Double.valueOf(this.textField_GDTC.getText());
				GradeModel gra = new GradeModel(maSV, tiengAnh, tinHoc, GDTC);
				if (GPAManagementDAO.getInstance().selectByMaSV(gra) != null) {
					if (MessageDialog.showConfirmDialog(this.studentView, "Do you want Update",
							"Update") == JOptionPane.NO_OPTION) {
						return;
					}
					if (GPAManagementDAO.getInstance().update(gra) > 0) {
						MessageDialog.showMessageDialog(this.studentView, "Update Success", "Update");
					} else {
						MessageDialog.showMessageDialog(this.studentView, "Update Fail", "Update");
					}
				} else {

					if (GPAManagementDAO.getInstance().insert(gra) > 0) {
						MessageDialog.showMessageDialog(this.studentView, "Insert Success", "Insert");
					} else {
						MessageDialog.showMessageDialog(this.studentView, "Insert Fail", "Insert");
					}
				}
				this.loadDataTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void displayNameStudent() {
		try {
			String maSV = this.textField_MaSinhVien.getText();
			StudentModel st = new StudentModel();
			st.setMaSV(maSV);
			StudentModel stu = StudentDAO.getInstance().selectByID(st);
			if (stu != null) {
				this.textField_HoTen.setText(stu.getHoTen());
			} else {
				this.textField_HoTen.setText("Not found");
//				MessageDialog.showErrorDialog(this.studentView, "Not found", "Message");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayAVG() {
		if (this.checkFormGPA()) {
			double tiengAnh = Double.valueOf(this.textField_TiengAnh.getText());
			double tinHoc = Double.valueOf(this.textField_TinHoc.getText());
			double GDTC = Double.valueOf(this.textField_GDTC.getText());
			double avgLabel = (tiengAnh + tinHoc + GDTC) / 3;
			String fr = String.format("%.2f", avgLabel);
			this.lable_AVG.setText(fr);
		}
	}

	public void findMaSV() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateIsID(textField_MaSinhVienFind, sb, "Mã sinh viên null");
			if (sb.length() > 0) {
				MessageDialog.showErrorDialog(this.studentView, sb.toString(), "Fail");
				return;
			}
			String maSV = this.textField_MaSinhVienFind.getText().trim();
			GradeModel g = new GradeModel();
			g.setMaSV(maSV);
			GradeModel gra = GPAManagementDAO.getInstance().selectByMaSV(g);
			if (gra != null) {
				this.textField_MaSinhVien.setText(gra.getMaSV());
				this.textField_TiengAnh.setText(String.format("%.2f", gra.getTiengAnh()));
				this.textField_TinHoc.setText(String.format("%.2f", gra.getTinHoc()));
				this.textField_GDTC.setText(String.format("%.2f", gra.getGDTC()));
				this.displayNameStudent();
				this.displayAVG();
			} else {
				MessageDialog.showErrorDialog(this.studentView, "Not found", "Message");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTableGrade() {
		try {
			String maSV = this.textField_MaSinhVien.getText().trim();
			GradeModel g = new GradeModel();
			g.setMaSV(maSV);
			if (GPAManagementDAO.getInstance().selectByMaSV(g) == null) {
				MessageDialog.showMessageDialog(this.studentView, "MaSV not found", "Message");
				return;
			}
			if (MessageDialog.showConfirmDialog(this.studentView, "Do you want to Delete",
					"Delete") == JOptionPane.NO_OPTION) {
				return;
			}
			if (GPAManagementDAO.getInstance().delete(g) > 0) {
				MessageDialog.showMessageDialog(this.studentView, "Delete success", "Delete");
			} else {
				MessageDialog.showMessageDialog(this.studentView, "Delete fail", "Delete");
			}
			this.loadDataTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadDataTable() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			ArrayList<GradeModel> list = GPAManagementDAO.getInstance().selectTop3DESC(3);
			StudentModel st = new StudentModel();
			model_table.setRowCount(0);
			for (GradeModel gradeModel : list) {
				st.setMaSV(gradeModel.getMaSV());
				StudentModel stu = StudentDAO.getInstance().selectByID(st);
				model_table.addRow(new Object[] { gradeModel.getMaSV(), stu.getHoTen(), gradeModel.getTiengAnh(),
						gradeModel.getTinHoc(), gradeModel.getGDTC(),
						(gradeModel.getTiengAnh() + gradeModel.getTinHoc() + gradeModel.getGDTC()) / 3 });
			}
			model_table.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayForm() {
		GradeModel gra = this.getValueTableGPA();
		this.textField_MaSinhVien.setText(gra.getMaSV());
		this.textField_TiengAnh.setText(gra.getTiengAnh() + "");
		this.textField_TinHoc.setText(gra.getTinHoc() + "");
		this.textField_GDTC.setText(gra.getGDTC() + "");
		this.displayNameStudent();
		this.displayAVG();
	}

	public GradeModel getValueTableGPA() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int ỉ_row = table.getSelectedRow();
		String maSV = model_table.getValueAt(ỉ_row, 0) + "";
		GradeModel gra = new GradeModel();
		gra.setMaSV(maSV);
		GradeModel gr = GPAManagementDAO.getInstance().selectByMaSV(gra);
		System.out.println(gr);
		return gr;
	}

	public void firstElement() {
		this.table.setRowSelectionInterval(0, 0);
		this.displayForm();
	}

	public void previosElenemnt() {
		int i_row = table.getSelectedRow();
		count = i_row;
		count--;
		if (count < 0) {
			count = 0;
		}
		this.table.setRowSelectionInterval(count, count);
		this.displayForm();
	}

	public void nextElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int rowCount = model_table.getRowCount();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count > rowCount - 1) {
			count = rowCount - 1;
		}
		this.table.setRowSelectionInterval(count, count);
		this.displayForm();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int rowCount = model_table.getRowCount();
		this.table.setRowSelectionInterval(rowCount - 1, rowCount - 1);
		this.displayForm();
	}
}
