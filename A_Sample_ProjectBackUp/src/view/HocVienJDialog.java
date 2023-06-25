package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import controller.HocVienJDialogCTL;
import dao.HocVienDAO;
import dao.NguoiHocDAO;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import model.HocVienModel;
import model.NguoiHocModel;

import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

public class HocVienJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTable table;
	public Integer maKhoaHoc;
	private JComboBox comboBox;
	private JRadioButton rdoTatCa;
	private JRadioButton rdoDaNhapDiem;
	private JRadioButton rdoChuaNhapDiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		HocVienJDialog dialog = new HocVienJDialog();

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the dialog.
	 */
	public HocVienJDialog() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HocVienJDialog.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
		HocVienJDialogCTL ctl = new HocVienJDialogCTL(this);
		setBounds(100, 100, 675, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setAutoscrolls(true);
		panel.setForeground(new Color(0, 0, 255));
		panel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		panel.setBounds(10, 72, 655, 46);
		contentPanel.add(panel);
		panel.setLayout(null);

		comboBox = new JComboBox();
		comboBox.addActionListener(ctl);
		comboBox.setBounds(0, 22, 423, 22);
		panel.add(comboBox);

		textField = new JTextField();
		textField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(452, 23, 89, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(565, 22, 89, 23);
		panel.add(btnThem);

		JLabel lblNewLabel = new JLabel("Học viên khác");
		lblNewLabel.setBounds(0, 0, 156, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		panel_1.setBounds(10, 141, 655, 381);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		rdoTatCa = new JRadioButton("Tất cả");
		rdoTatCa.setBackground(new Color(255, 255, 255));
		rdoTatCa.addActionListener(ctl);
		rdoTatCa.setBounds(0, 347, 109, 23);
		panel_1.add(rdoTatCa);

		rdoDaNhapDiem = new JRadioButton("Đã nhập điểm");
		rdoDaNhapDiem.setBackground(new Color(255, 255, 255));
		rdoDaNhapDiem.addActionListener(ctl);
		rdoDaNhapDiem.setBounds(111, 347, 109, 23);
		panel_1.add(rdoDaNhapDiem);

		rdoChuaNhapDiem = new JRadioButton("Chưa nhập điểm");
		rdoChuaNhapDiem.setBackground(new Color(255, 255, 255));
		rdoChuaNhapDiem.addActionListener(ctl);
		rdoChuaNhapDiem.setBounds(244, 347, 109, 23);
		panel_1.add(rdoChuaNhapDiem);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoTatCa);
		buttonGroup.add(rdoDaNhapDiem);
		buttonGroup.add(rdoChuaNhapDiem);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(ctl);
		btnCapNhat.setBounds(566, 347, 89, 23);
		panel_1.add(btnCapNhat);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 h\u1ECDc vi\u00EAn",
				"M\u00E3 ng\u01B0\u1EDDi h\u1ECDc", "H\u1ECD & t\u00EAn", "\u0110i\u1EC3m", "X\u00F3a" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 11, 655, 321);
		panel_1.add(scrollPane);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		JLabel lblNewLabel_1 = new JLabel("Học viên trong của khóa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 124, 224, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lbl_Exit = new JLabel("X");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setForeground(new Color(255, 0, 0));
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setBounds(627, 11, 48, 23);
		contentPanel.add(lbl_Exit);

		JLabel lblQunLHc = new JLabel("Quản Lý Học Viện");
		lblQunLHc.setForeground(new Color(0, 0, 255));
		lblQunLHc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQunLHc.setBounds(10, 11, 339, 29);
		contentPanel.add(lblQunLHc);

//		this.loadDataTable();
//		this.loadCombobox();
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}

	public void loadDataTable() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			List<Object[]> list = HocVienDAO.getInstance().getDanhSachNH(maKhoaHoc);
			model_table.setRowCount(0);
			for (Object[] objects : list) {
				model_table.addRow(new Object[] { objects[0], objects[1], objects[2], objects[3], false });
			}
			model_table.fireTableDataChanged();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadTableChuaNhapDiem() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			List<Object[]> list = HocVienDAO.getInstance().getDanhSachNhChuaNhapDiem(maKhoaHoc);
			model_table.setRowCount(0);
			for (Object[] objects : list) {
				model_table.addRow(new Object[] { objects[0], objects[1], objects[2], objects[3], false });
			}
			model_table.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadTableDaNhapDiem() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			List<Object[]> list = HocVienDAO.getInstance().getDanhSachNHDaNhapDiem(maKhoaHoc);
			model_table.setRowCount(0);
			for (Object[] objects : list) {
				model_table.addRow(new Object[] { objects[0], objects[1], objects[2], objects[3], false });
			}
			model_table.fireTableDataChanged();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadCombobox() {
		try {
//			System.out.println(maKhoaHoc);
			ArrayList<NguoiHocModel> list = NguoiHocDAO.getInstance().selectByCourse(maKhoaHoc);
			this.comboBox.addItem("");
			for (NguoiHocModel nguoiHocModel : list) {
				this.comboBox.addItem(nguoiHocModel.getTenNguoiHoc());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertTable() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateCombobox(comboBox, sb, "Chưa chọn tên nhân viên");
			DataValidator.validateIsDiem(this.textField, sb, "Điểm null");
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Notification");
				return;
			}
			int maKhoaHoc = this.maKhoaHoc;
			NguoiHocModel nh = new NguoiHocModel();
			String tenNguoiHoc = this.comboBox.getSelectedItem() + "";
			nh.setTenNguoiHoc(tenNguoiHoc);
			String maNguoiHoc = NguoiHocDAO.getInstance().selectByTenNguoiHoc(nh).getMaNguoiHoc();
			double diem = Double.valueOf(this.textField.getText());
			HocVienModel hv = new HocVienModel(maKhoaHoc, maNguoiHoc, diem);
			if (HocVienDAO.getInstance().insert(hv) > 0) {
				this.comboBox.removeItem(tenNguoiHoc);
				MsgBox.showMessageDialog(this, "Insert Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert Fail", "Notification");
			}
			this.loadCombobox();
			this.loadDataTable();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updateTable() {
		if (MsgBox.showConfirmDialog(this, "Do you want to update", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int rowCount = model_table.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				int maHocVien = Integer.valueOf((model_table.getValueAt(i, 0) + ""));
				int maKhoaHoc = this.maKhoaHoc;
				String maNguoiHoc = model_table.getValueAt(i, 1) + "";
				double diem = Double.valueOf(model_table.getValueAt(i, 3) + "");
				boolean isDelete = (boolean) model_table.getValueAt(i, 4);
//				System.out.println(maHocVien +" ma hoc vien");
//				System.out.println(maKhoaHoc +" ma khoa hoc");
//				System.out.println(maNguoiHoc + "ma nguoi hoc");
//				System.out.println(diem +"diem");
//				System.out.println(isDelete);
				if (isDelete) {
					HocVienModel hv = new HocVienModel(maHocVien, maKhoaHoc, maNguoiHoc, diem);
					HocVienDAO.getInstance().delete(hv);
				} else {
					HocVienModel hv = new HocVienModel(maHocVien, maKhoaHoc, maNguoiHoc, diem);
					HocVienDAO.getInstance().update(hv);
				}
			}
			this.loadDataTable();
			this.loadCombobox();
			MsgBox.showMessageDialog(this, "Update Successfull", "Notification");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}
}
