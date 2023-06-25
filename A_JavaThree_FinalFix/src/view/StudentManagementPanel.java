package view;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.DangNhapDialogCTL;
import dao.StudentDAO;
import lib.DataValidator;
import lib.ImageHelper;
import lib.MessageDialog;
import model.StudentModel;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.border.MatteBorder;

public class StudentManagementPanel extends JPanel {
	private JTextField textField_MaSinhVien;
	private JTextField textField_HoTen;
	private JTextField textField_Email;
	private JTextField textField_SDT;
	private JTable table;
	private ButtonGroup buttonGroup;
	private JTextArea textDiaChi;
	private JRadioButton rdo_Nam;
	private JRadioButton rdo_Nu;
	private StudentView studentView;
	private JLabel label_IMG;
	private byte[] arrIMG;

	/**
	 * Create the panel.
	 */
	public StudentManagementPanel() {
		setBackground(new Color(255, 255, 255));
		DangNhapDialogCTL ctl = new DangNhapDialogCTL(this);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Quản Lý Sinh Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(10, 11, 196, 14);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã sinh viên:");
		lblNewLabel_1.setBounds(10, 49, 89, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Họ tên:");
		lblNewLabel_2.setBounds(10, 74, 48, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(10, 105, 48, 14);
		add(lblNewLabel_3);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 523, 2);
		add(separator);

		textField_MaSinhVien = new JTextField();
		textField_MaSinhVien.setHorizontalAlignment(SwingConstants.CENTER);
		textField_MaSinhVien.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_MaSinhVien.setText("Ps25979");
		textField_MaSinhVien.setBounds(80, 46, 184, 20);
		add(textField_MaSinhVien);
		textField_MaSinhVien.setColumns(10);

		textField_HoTen = new JTextField();
		textField_HoTen.setHorizontalAlignment(SwingConstants.CENTER);
		textField_HoTen.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(255, 128, 64)));
		textField_HoTen.setText("Hoàng Duy Nam");
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(80, 71, 184, 20);
		add(textField_HoTen);

		textField_Email = new JTextField();
		textField_Email.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Email.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 0)));
		textField_Email.setText("nam@gmail.com");
		textField_Email.setColumns(10);
		textField_Email.setBounds(80, 102, 184, 20);
		add(textField_Email);

		textField_SDT = new JTextField();
		textField_SDT.setHorizontalAlignment(SwingConstants.CENTER);
		textField_SDT.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_SDT.setText("0968997434");
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(80, 138, 184, 20);
		add(textField_SDT);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(328, 49, 184, 211);
		add(panel);
		panel.setLayout(null);

		label_IMG = new JLabel("");
		label_IMG.setHorizontalAlignment(SwingConstants.CENTER);
		label_IMG
				.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/IMG_JavaIcon/Student-3-icon64.png")));
		label_IMG.setBounds(10, 11, 164, 155);
		panel.add(label_IMG);

		JButton btnNewImg = new JButton("New Image");
		btnNewImg.addActionListener(ctl);
		btnNewImg.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/IMG_JavaIcon/Folder-Add-icon.png")));
		btnNewImg.setBounds(40, 177, 109, 23);
		panel.add(btnNewImg);

		textDiaChi = new JTextArea();
		textDiaChi.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(255, 128, 0)));
		textDiaChi.setText("Bàu bàng, Bình dương");

		rdo_Nam = new JRadioButton("Nam");
		rdo_Nam.setBackground(new Color(255, 255, 255));
		rdo_Nam.setSelected(true);
		rdo_Nam.setBounds(78, 165, 61, 23);
		add(rdo_Nam);

		rdo_Nu = new JRadioButton("Nữ");
		rdo_Nu.setBackground(new Color(255, 255, 255));
		rdo_Nu.setBounds(141, 165, 109, 23);
		add(rdo_Nu);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdo_Nam);
		buttonGroup.add(rdo_Nu);

		JLabel lblNewLabel_3_1 = new JLabel("Số điện thoại:");
		lblNewLabel_3_1.setBounds(10, 141, 78, 14);
		add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Giới tính:");
		lblNewLabel_3_2.setBounds(10, 172, 48, 14);
		add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Địa chỉ:");
		lblNewLabel_3_3.setBounds(10, 208, 48, 14);
		add(lblNewLabel_3_3);

		JButton btn_New = new JButton("New");
		btn_New.addActionListener(ctl);
		btn_New.setIcon(
				new ImageIcon(StudentManagementPanel.class.getResource("/IMG_JavaIcon/Files-New-File-icon.png")));
		btn_New.setBounds(10, 303, 89, 23);
		add(btn_New);

		JButton Delete = new JButton("Delete");
		Delete.addActionListener(ctl);
		Delete.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/IMG_JavaIcon/File-Delete-icon.png")));
		Delete.setBounds(444, 303, 89, 23);
		add(Delete);

		JButton btn_Save = new JButton("Save");
		btn_Save.addActionListener(ctl);
		btn_Save.setIcon(new ImageIcon(StudentManagementPanel.class.getResource("/IMG_JavaIcon/Save-icon.png")));
		btn_Save.setBounds(246, 303, 89, 23);
		add(btn_Save);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setIcon(
				new ImageIcon(StudentManagementPanel.class.getResource("/IMG_JavaIcon/Edit-Document-icon.png")));
		btnUpdate.setBounds(345, 303, 89, 23);
		add(btnUpdate);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Sv", "Họ tên", "Email", "SĐT", "Giới tính", "Địa chỉ", "IMG" }));
		table.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 337, 523, 178);
		add(scrollPane);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(274, 275, 259, 2);
		add(separator_1);

		JScrollPane scrollPane_1 = new JScrollPane(textDiaChi);
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(80, 203, 184, 74);
		add(scrollPane_1);
		
		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255,255,255));
		this.table.setRowHeight(25);
		this.loadDataStudentsOnTable();

	}

	public void resetForm() {
		this.textField_MaSinhVien.setText("");
		this.textField_HoTen.setText("");
		this.textField_Email.setText("");
		this.textField_SDT.setText("");
		this.buttonGroup.clearSelection();
		this.textDiaChi.setText("");
		this.arrIMG = null;
		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JavaIcon/Student-3-icon64.png"));
		this.label_IMG.setIcon(icon);
		this.textField_MaSinhVien.requestFocus();
	}

	public boolean checkFormFail() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsHoTen(this.textField_HoTen, sb, "Họ tên null");
		DataValidator.validateIsEmail(this.textField_Email, sb, "Email null");
		DataValidator.validateIsSDT(this.textField_SDT, sb, "Sdt null");
		DataValidator.validateIsID(textField_MaSinhVien, sb, "Mã sinh viên null");
		if (!this.rdo_Nam.isSelected() && !this.rdo_Nu.isSelected()) {
			sb.append("Chưa chọn giới tính").append("\n");
		}
		if (sb.length() > 0) {
			MessageDialog.showErrorDialog(this.studentView, sb.toString(), "Error");
			return false;
		}
		return true;
	}

	public void insertTableStudents() {
		if (this.checkFormFail()) {
			try {
				String maSV = this.textField_MaSinhVien.getText().trim();
				String hoTen = this.textField_HoTen.getText().trim();
				String email = this.textField_Email.getText().trim();
				String soDT = this.textField_SDT.getText().trim();
				boolean gioiTinh = true;
				if (this.rdo_Nam.isSelected()) {
					gioiTinh = true;
				} else {
					gioiTinh = false;
				}
				String diaChi = this.textDiaChi.getText().trim();
				// Hinh
				byte[] hinh = this.arrIMG;
				StudentModel st = new StudentModel(maSV, hoTen, email, soDT, gioiTinh, diaChi, hinh);
				if (StudentDAO.getInstance().insert(st) > 0) {
					MessageDialog.showMessageDialog(this.studentView, "Insert Success", "Success");
					this.loadDataStudentsOnTable();
				} else {
					MessageDialog.showMessageDialog(this.studentView, "Insert Fail", "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void updateTableStudents() {
		if (this.checkFormFail()) {
			try {
				if (MessageDialog.showConfirmDialog(this.studentView, "Do you want update?",
						"Update") == JOptionPane.NO_OPTION) {
					return;
				}
				String maSV = this.textField_MaSinhVien.getText().trim();
				String hoTen = this.textField_HoTen.getText().trim();
				String email = this.textField_Email.getText().trim();
				String soDT = this.textField_SDT.getText().trim();
				boolean gioiTinh = true;
				if (this.rdo_Nam.isSelected()) {
					gioiTinh = true;
				} else {
					gioiTinh = false;
				}
				String diaChi = this.textDiaChi.getText().trim();
				// Hinh
				byte[] hinh = this.arrIMG;
				StudentModel st = new StudentModel(maSV, hoTen, email, soDT, gioiTinh, diaChi, hinh);
				if (StudentDAO.getInstance().update(st) > 0) {
					MessageDialog.showMessageDialog(this.studentView, "Update Success", "Success");
					this.loadDataStudentsOnTable();
				} else {
					MessageDialog.showMessageDialog(this.studentView, "Update Fail", "Fail");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteTableStudents() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateIsID(this.textField_MaSinhVien, sb, "Mã sinh viên Null");
			if (sb.length() > 0) {
				MessageDialog.showErrorDialog(this.studentView, sb.toString(), "Error");
				return;
			}

			if (MessageDialog.showConfirmDialog(this.studentView, "Do you want Delete?",
					"Delete") == JOptionPane.NO_OPTION) {
				return;
			}
			StudentModel st = new StudentModel();
			String maSV = this.textField_MaSinhVien.getText().trim();
			st.setMaSV(maSV);

			if (StudentDAO.getInstance().delete(st) > 0) {
				MessageDialog.showMessageDialog(this.studentView, "Delete Success", "Delete");
				this.loadDataStudentsOnTable();
			} else {
				MessageDialog.showMessageDialog(this.studentView, "Delete Fail", "Delete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertTableSTView(StudentModel st) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//		model_table.setRowCount(0);
		model_table.addRow(new Object[] { st.getMaSV(), st.getHoTen(), st.getEmail(), st.getSoDT(),
				(st.isGioiTinh() ? "Nam" : "Nữ"), st.getDiaChi(), st.getHinh() });
//		model_table.fireTableDataChanged();
	}

	public void findStudentsByID() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateIsID(this.textField_MaSinhVien, sb, "Mã sinh viên Null");
			if (sb.length() > 0) {
				MessageDialog.showErrorDialog(this.studentView, "Fail", "Error");
				return;
			}
			StudentModel st = new StudentModel();
			String maSV = this.textField_MaSinhVien.getText().trim();
			st.setMaSV(maSV);
			StudentModel stu = StudentDAO.getInstance().selectByID(st);
			this.insertTableSTView(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadDataStudentsOnTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//		while (true) {
//			int rowCount = model_table.getRowCount();
//			if (rowCount == 0) {
//				break;
//			} else {
//				model_table.removeRow(0);
//			}
//		}
		try {
			ArrayList<StudentModel> list = StudentDAO.getInstance().selectAll();
			model_table.setRowCount(0);
			for (StudentModel st : list) {
				this.insertTableSTView(st);
			}
			model_table.fireTableDataChanged();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayOnForm() {
		try {
			StudentModel st = this.getStudentModel();
			this.textField_MaSinhVien.setText(st.getMaSV());
			this.textField_HoTen.setText(st.getHoTen());
			this.textField_Email.setText(st.getEmail());
			this.textField_SDT.setText(st.getSoDT());
			if (st.isGioiTinh()) {
				this.rdo_Nam.setSelected(true);
			} else {
				this.rdo_Nu.setSelected(true);
			}
			this.textDiaChi.setText(st.getDiaChi());
//			this.label_IMG.setText(st.getHinh());
			if (st.getHinh() != null) {
				Image img = ImageHelper.createImageFromByteArray(st.getHinh(), "jpg");
				this.label_IMG.setIcon(new ImageIcon(img));
				this.arrIMG = st.getHinh();
			} else {
				this.arrIMG = st.getHinh();
				ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JavaIcon/Student-3-icon64.png"));
				this.label_IMG.setIcon(icon);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public StudentModel getStudentModel() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int i_row = table.getSelectedRow();
			if (i_row >= 0) {
				String id = model_table.getValueAt(i_row, 0) + "";
				StudentModel st = new StudentModel();
				st.setMaSV(id);
				StudentModel stu = StudentDAO.getInstance().selectByID(st);
				return stu;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public void disPlayImage() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Image File (*.jpg)";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".jpg");
				}
			}
		});
		if (fc.showOpenDialog(this) == JFileChooser.CANCEL_OPTION) {
			return;
		}

		File file = fc.getSelectedFile();
		try {
			ImageIcon icon = new ImageIcon(file.getPath());
			Image img = ImageHelper.resize(icon.getImage(), 164, 155);
			ImageIcon resizeIcon = new ImageIcon(img);
			this.label_IMG.setIcon(resizeIcon);
			arrIMG = ImageHelper.toByteArray(img, "jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
