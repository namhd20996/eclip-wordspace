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
	private JTextField txt_maSinhVienFind;
	private JTextField txt_maSinhVien;
	private JTextField txt_hoTen;
	private JTextField txt_tiengAnh;
	private JTextField txt_tinHoc;
	private JTextField txt_GDTC;
	private JTable table;
	private StudentView studentView;
	private JLabel lable_AVG;
	private int count;

	/**
	 * Create the panel.
	 */
	public GPAManagementPanel() {
		setBackground(new Color(255, 255, 255));
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
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 49, 548, 42);
		add(panel);
		panel.setLayout(null);

		JLabel lbl_MSVF = new JLabel("Mã sinh viên:");
		lbl_MSVF.setBounds(10, 11, 98, 14);
		panel.add(lbl_MSVF);

		txt_maSinhVienFind = new JTextField();
//		textField_MaSinhVienFind.setName("Find");
		txt_maSinhVienFind.setHorizontalAlignment(SwingConstants.CENTER);
		txt_maSinhVienFind.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(255, 0, 0)));
		txt_maSinhVienFind.setText("Ps25979");
		txt_maSinhVienFind.setBounds(85, 8, 254, 20);
		panel.add(txt_maSinhVienFind);
		txt_maSinhVienFind.setColumns(10);

		JButton btn_Find = new JButton("Find");
		btn_Find.addActionListener(ctl);
		btn_Find.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Search-icon.png")));
		btn_Find.setBounds(449, 7, 89, 23);
		panel.add(btn_Find);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 95, 548, 482);
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 255, 255)));
		panel_2.setBounds(10, 11, 295, 181);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbl_maSinhVien = new JLabel("Mã sinh viên:");
		lbl_maSinhVien.setBounds(10, 25, 73, 14);
		panel_2.add(lbl_maSinhVien);

		JLabel lbl_hoTen = new JLabel("Họ tên:");
		lbl_hoTen.setBounds(10, 50, 48, 14);
		panel_2.add(lbl_hoTen);

		JLabel lbl_tiengAnh = new JLabel("Tiếng anh:");
		lbl_tiengAnh.setBounds(10, 75, 85, 14);
		panel_2.add(lbl_tiengAnh);

		JLabel lbl_tinHoc = new JLabel("Tin học:");
		lbl_tinHoc.setBounds(10, 106, 48, 14);
		panel_2.add(lbl_tinHoc);

		JLabel lbl_GDTC = new JLabel("GDTC:");
		lbl_GDTC.setBounds(10, 137, 48, 14);
		panel_2.add(lbl_GDTC);

		txt_maSinhVien = new JTextField();
		txt_maSinhVien.setName("maSinhVien");
		txt_maSinhVien.setHorizontalAlignment(SwingConstants.CENTER);
		txt_maSinhVien.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
//		textField_MaSinhVien.addFocusListener(ctl);
		txt_maSinhVien.addKeyListener(ctl);
		txt_maSinhVien.setText("Ps25979");
		txt_maSinhVien.setBounds(83, 22, 202, 20);
		panel_2.add(txt_maSinhVien);
		txt_maSinhVien.setColumns(10);

		txt_hoTen = new JTextField();
		txt_hoTen.setHorizontalAlignment(SwingConstants.CENTER);
		txt_hoTen.setBackground(new Color(255, 255, 255));
		txt_hoTen.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(255, 128, 64)));
		txt_hoTen.setEnabled(false);
		txt_hoTen.setColumns(10);
		txt_hoTen.setBounds(83, 47, 202, 20);
		panel_2.add(txt_hoTen);

		txt_tiengAnh = new JTextField();
		txt_tiengAnh.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tiengAnh.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 0)));
		txt_tiengAnh.addFocusListener(ctl);
		txt_tiengAnh.setText("8");
		txt_tiengAnh.setColumns(10);
		txt_tiengAnh.setBounds(83, 72, 202, 20);
		panel_2.add(txt_tiengAnh);

		txt_tinHoc = new JTextField();
		txt_tinHoc.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tinHoc.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 255, 0)));
		txt_tinHoc.addFocusListener(ctl);
		txt_tinHoc.setText("8");
		txt_tinHoc.setColumns(10);
		txt_tinHoc.setBounds(83, 103, 202, 20);
		panel_2.add(txt_tinHoc);

		txt_GDTC = new JTextField();
		txt_GDTC.setHorizontalAlignment(SwingConstants.CENTER);
		txt_GDTC.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		txt_GDTC.addFocusListener(ctl);
		txt_GDTC.setText("8");
		txt_GDTC.setColumns(10);
		txt_GDTC.setBounds(83, 134, 202, 20);
		panel_2.add(txt_GDTC);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
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

		JButton btn_New = new JButton("New");
		btn_New.setActionCommand("N");
		btn_New.addActionListener(ctl);
		btn_New.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Files-New-File-icon.png")));
		btn_New.setBounds(449, 11, 89, 23);
		panel_1.add(btn_New);

		JButton btn_Save = new JButton("Save");
		btn_Save.setActionCommand("S");
		btn_Save.addActionListener(ctl);
		btn_Save.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Save-icon.png")));
		btn_Save.setBounds(451, 45, 89, 23);
		panel_1.add(btn_Save);

		JButton btn_Update = new JButton("Update");
		btn_Update.setActionCommand("U");
		btn_Update.addActionListener(ctl);
		btn_Update.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Edit-Document-icon.png")));
		btn_Update.setBounds(451, 79, 89, 23);
		panel_1.add(btn_Update);

		JButton btn_Delete = new JButton("Delete");
		btn_Delete.setActionCommand("D");
		btn_Delete.addActionListener(ctl);
		btn_Delete.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/File-Delete-icon.png")));
		btn_Delete.setBounds(451, 113, 89, 23);
		panel_1.add(btn_Delete);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Sv", "Họ tên", "Tiếng anh", "Tin học", "GDTC", "Điểm TB" }));
		table.addMouseListener(mouseListennerGPA);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 242, 528, 229);
		panel_1.add(scrollPane);

		JButton btn_First = new JButton("");
		btn_First.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Button-6-next-iconT.png")));
		btn_First.setActionCommand("F");
		btn_First.addActionListener(ctl);
		btn_First.setBounds(10, 195, 89, 36);
		panel_1.add(btn_First);

		JButton btn_Pre = new JButton("");
		btn_Pre.setActionCommand("Pre");
		btn_Pre.addActionListener(ctl);
		btn_Pre.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Button-5-forward-iconT.png")));
		btn_Pre.setBounds(119, 195, 89, 36);
		panel_1.add(btn_Pre);

		JButton btn_Next = new JButton("");
		btn_Next.setActionCommand("Nex");
		btn_Next.addActionListener(ctl);
		btn_Next.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Button-5-forward-icon.png")));
		btn_Next.setBounds(218, 195, 89, 36);
		panel_1.add(btn_Next);

		JButton btn_Last = new JButton("");
		btn_Last.setActionCommand("L");
		btn_Last.addActionListener(ctl);
		btn_Last.setIcon(new ImageIcon(GPAManagementPanel.class.getResource("/IMG_JavaIcon/Button-6-next-icon.png")));
		btn_Last.setBounds(317, 195, 89, 36);
		panel_1.add(btn_Last);
		
		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255,255,255));
		this.table.setRowHeight(25);

		this.loadDataTable();
	}

	public void resetFormGPA() {
		this.txt_maSinhVienFind.setText("");
		this.txt_maSinhVien.setText("");
		this.txt_hoTen.setText("");
		this.txt_tiengAnh.setText("");
		this.txt_tinHoc.setText("");
		this.txt_GDTC.setText("");
		this.lable_AVG.setText("00.00");
		this.txt_maSinhVien.requestFocus();
	}

	public boolean checkFormGPA() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsDiem(this.txt_tiengAnh, sb, "Tiếng anh Null");
		DataValidator.validateIsDiem(this.txt_tinHoc, sb, "Tin học Null");
		DataValidator.validateIsDiem(this.txt_GDTC, sb, "GDTC Null");
		DataValidator.validateIsID(this.txt_maSinhVien, sb, "Mã sinh viên Null");
		if (sb.length() > 0) {
			MessageDialog.showErrorDialog(this.studentView, sb.toString(), "Error");
			return false;
		}
		return true;
	}

	public void insertTableGrade() {
		if (this.checkFormGPA()) {
			try {
				String maSV = this.txt_maSinhVien.getText();
				double tiengAnh = Double.valueOf(this.txt_tiengAnh.getText());
				double tinHoc = Double.valueOf(this.txt_tinHoc.getText());
				double GDTC = Double.valueOf(this.txt_GDTC.getText());
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
			String maSV = this.txt_maSinhVien.getText();
			StudentModel st = new StudentModel();
			st.setMaSV(maSV);
			StudentModel stu = StudentDAO.getInstance().selectByID(st);
			if (stu != null) {
				this.txt_hoTen.setText(stu.getHoTen());
			} else {
				this.txt_hoTen.setText("Not found");
//				MessageDialog.showErrorDialog(this.studentView, "Not found", "Message");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayAVG() {
//		if (this.checkFormGPA()) {
			double tiengAnh = Double.valueOf(this.txt_tiengAnh.getText());
			double tinHoc = Double.valueOf(this.txt_tinHoc.getText());
			double GDTC = Double.valueOf(this.txt_GDTC.getText());
			double avgLabel = (tiengAnh + tinHoc + GDTC) / 3;
			String fr = String.format("%.2f", avgLabel);
			this.lable_AVG.setText(fr);
//		}
	}

	public void findMaSV() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateIsID(txt_maSinhVienFind, sb, "Mã sinh viên null");
			if (sb.length() > 0) {
				MessageDialog.showErrorDialog(this.studentView, sb.toString(), "Fail");
				return;
			}
			String maSV = this.txt_maSinhVienFind.getText().trim();
			GradeModel g = new GradeModel();
			g.setMaSV(maSV);
			GradeModel gra = GPAManagementDAO.getInstance().selectByMaSV(g);
			if (gra != null) {
				this.txt_maSinhVien.setText(gra.getMaSV());
				this.txt_tiengAnh.setText(String.format("%.2f", gra.getTiengAnh()));
				this.txt_tinHoc.setText(String.format("%.2f", gra.getTinHoc()));
				this.txt_GDTC.setText(String.format("%.2f", gra.getGDTC()));
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
			String maSV = this.txt_maSinhVien.getText().trim();
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
		this.txt_maSinhVien.setText(gra.getMaSV());
		this.txt_tiengAnh.setText(gra.getTiengAnh() + "");
		this.txt_tinHoc.setText(gra.getTinHoc() + "");
		this.txt_GDTC.setText(gra.getGDTC() + "");
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
