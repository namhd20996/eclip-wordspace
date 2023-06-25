package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.MouseListenerController;
import controller.QLSVListenner;
import model.QlSVModel;
import model.SinhVienModel;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_HoTen;
	private JTextField textField_Diem;
	private JTextField textField_HocLuc;
	private JTable table;
	private JComboBox comboBox_Nganh;
	private JCheckBox chekcbox_Thuong;
	private QlSVModel qlSVModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.setTitle("Quản lí sinh viên");
		this.qlSVModel = new QlSVModel();
		QLSVListenner qlsvListenner = new QLSVListenner(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Họ và tên");
		lblNewLabel.setBounds(10, 34, 67, 14);
		contentPane.add(lblNewLabel);

		JLabel lblim = new JLabel("Điểm");
		lblim.setBounds(10, 66, 48, 14);
		contentPane.add(lblim);

		JLabel lblNgnh = new JLabel("Ngành");
		lblNgnh.setBounds(10, 98, 48, 14);
		contentPane.add(lblNgnh);

		JLabel lblHcLc = new JLabel("Học lực");
		lblHcLc.setBounds(10, 123, 48, 14);
		contentPane.add(lblHcLc);

		textField_HoTen = new JTextField();
		textField_HoTen.setBounds(79, 31, 438, 20);
		contentPane.add(textField_HoTen);
		textField_HoTen.setColumns(10);

		textField_Diem = new JTextField();
		textField_Diem.setColumns(10);
		textField_Diem.setBounds(79, 63, 438, 20);
		contentPane.add(textField_Diem);

		textField_HocLuc = new JTextField();
		textField_HocLuc.setEnabled(false);
		textField_HocLuc.setEditable(false);
		textField_HocLuc.setColumns(10);
		textField_HocLuc.setBounds(79, 120, 438, 20);
		contentPane.add(textField_HocLuc);

		String[] arrNganh = new String[] { "", "Ứng dụng phần mềm", "Quản trị kinh doanh", "Content create", "Luật" };
		comboBox_Nganh = new JComboBox(arrNganh);
		comboBox_Nganh.setBounds(79, 94, 155, 22);
		contentPane.add(comboBox_Nganh);
		chekcbox_Thuong = new JCheckBox("Có phần thưởng?");
		chekcbox_Thuong.setBounds(79, 147, 200, 23);
		contentPane.add(chekcbox_Thuong);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(79, 176, 89, 23);
		contentPane.add(btnThem);
		btnThem.addActionListener(qlsvListenner);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(178, 176, 89, 23);
		contentPane.add(btnXoa);
		btnXoa.addActionListener(qlsvListenner);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(277, 176, 89, 23);
		contentPane.add(btnCapNhat);
		btnCapNhat.addActionListener(qlsvListenner);

		JButton btnNhapMoi = new JButton("Nhập mới");
		btnNhapMoi.setBounds(376, 176, 130, 23);
		contentPane.add(btnNhapMoi);
		btnNhapMoi.addActionListener(qlsvListenner);

		JLabel lblNewLabel_4 = new JLabel("Quản Lý Sinh Viên");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(180, -2, 234, 22);
		contentPane.add(lblNewLabel_4);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Họ và tên", "Điểm", "Ngành", "Học lực", "Thưởng" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 210, 507, 149);
		contentPane.add(scrollPane);

		JButton btnSapXepTheoTen = new JButton("Sắp xếp theo tên");
		btnSapXepTheoTen.setBounds(10, 370, 145, 23);
		contentPane.add(btnSapXepTheoTen);
		btnSapXepTheoTen.addActionListener(qlsvListenner);

		JButton btnSapXepTheoDiem = new JButton("Sắp xếp theo điểm");
		btnSapXepTheoDiem.setBounds(190, 370, 145, 23);
		contentPane.add(btnSapXepTheoDiem);
		btnSapXepTheoDiem.addActionListener(qlsvListenner);

		MouseListenerController ctl = new MouseListenerController(this);
		table.addMouseListener(ctl);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void resetForm() {
		this.textField_HoTen.setText("");
		this.textField_Diem.setText("");
		this.comboBox_Nganh.setSelectedIndex(-1);
		this.textField_HocLuc.setText("");
		this.chekcbox_Thuong.setSelected(false);
	}

	public void insertForm() {
		String hoVaTen = this.textField_HoTen.getText();
		double diem = Double.valueOf(this.textField_Diem.getText());
		String nganhHoc = this.comboBox_Nganh.getSelectedItem().toString();
		SinhVienModel sv = new SinhVienModel(hoVaTen, diem, nganhHoc);
		this.textField_HocLuc.setText(sv.getGrade());
		if (sv.isBonus()) {
			this.chekcbox_Thuong.setSelected(true);
		} else {
			this.chekcbox_Thuong.setSelected(false);
		}
		this.themHoacCapNhapSinhVien(sv);
	}

	public void insertTable(SinhVienModel sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { sv.getHoVaTen(), sv.getDiem(), sv.getNganhHoc(), sv.getGrade(),
				(sv.isBonus() ? true : false) });
	}

	private void themHoacCapNhapSinhVien(SinhVienModel sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = model_table.getRowCount();
		if (!this.qlSVModel.kiemTraTonTai(sv)) {
			this.insertTable(sv);
			this.qlSVModel.insert(sv);
			table.setRowSelectionInterval(i_row, i_row);
		} else {
			this.qlSVModel.update(sv);
//			int i_row = model_table.getRowCount();
			for (int i = 0; i < i_row; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(sv.getHoVaTen())) {
					model_table.setValueAt(sv.getHoVaTen(), i, 0);
					model_table.setValueAt(sv.getDiem(), i, 1);
					model_table.setValueAt(sv.getNganhHoc(), i, 2);
					model_table.setValueAt(sv.getGrade(), i, 3);
					model_table.setValueAt((sv.isBonus() ? true : false), i, 4);
				}
			}
		}
	}

	public SinhVienModel getSinhVienDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String hoVaTen = model_table.getValueAt(i_row, 0) + "";
		double diem = Double.valueOf(model_table.getValueAt(i_row, 1) + "");
		String nganhHoc = model_table.getValueAt(i_row, 2) + "";
		SinhVienModel sv = new SinhVienModel(hoVaTen, diem, nganhHoc);
		return sv;
	}

	public void delete() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa", "Delete", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			SinhVienModel sv = this.getSinhVienDangChon();
			this.qlSVModel.delete(sv);
			model_table.removeRow(i_row);
		}
	}

	public void hienThiSinhVienDangChon() {
		SinhVienModel sv = this.getSinhVienDangChon();
		this.textField_HoTen.setText(sv.getHoVaTen());
		this.textField_Diem.setText(sv.getDiem() + "");
		this.comboBox_Nganh.setSelectedItem(sv.getNganhHoc());
		this.textField_HocLuc.setText(sv.getGrade());
		if (sv.isBonus()) {
			this.chekcbox_Thuong.setSelected(true);
		} else {
			this.chekcbox_Thuong.setSelected(false);
		}
	}

	public void loadLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				model_table.removeRow(0);
			}
		}
		for (SinhVienModel sv : this.qlSVModel.getDsSinhVien()) {
			this.insertTable(sv);
		}
	}

	public void loadLaiDuLieuTen() {
		this.qlSVModel.sapXepSinhVienTheoTen();
		this.loadLaiDuLieu();
	}

	public void loadLaiDuLieuDiem() {
		this.qlSVModel.sapXepSinhVienTheoDiem();
		this.loadLaiDuLieu();
	}

}
