package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.SinhVienModel;
import model.Tinh;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel qlsvModel;
	public JTextField textField_MaSinhVien;
	public JTable table;
	public JTextField textField_id;
	public JTextField textField_HoTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup buttonGroup;
	public JComboBox comboBox_QueQuan;
	public JRadioButton rdbtnNewRadioButton_Nam;
	public JRadioButton rdbtnNewRadioButton_Nu;
	private JComboBox comboBox_QueQuan_TimKiem;

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
		this.qlsvModel = new QLSVModel();
		QLSVController ql = new QLSVController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 422);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open");
		menuFile.add(menuOpen);
		menuOpen.addActionListener(ql);

		JMenuItem menuSave = new JMenuItem("Save");
		menuFile.add(menuSave);
		menuSave.addActionListener(ql);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuFile.add(menuExit);
		menuExit.addActionListener(ql);

		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(menuAbout);

		JMenuItem menuAboutme = new JMenuItem("About me");
		menuAbout.add(menuAboutme);
		contentPane = new JPanel();
		menuAboutme.addActionListener(ql);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label_QueQuan = new JLabel("Quê Quán");
		label_QueQuan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_QueQuan.setBounds(10, 11, 77, 14);
		contentPane.add(label_QueQuan);

		JLabel label_QueQuan_1 = new JLabel("Mã Sinh Viên");
		label_QueQuan_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_QueQuan_1.setBounds(207, 11, 111, 14);
		contentPane.add(label_QueQuan_1);

		textField_MaSinhVien = new JTextField();
		textField_MaSinhVien.setBounds(292, 10, 96, 20);
		contentPane.add(textField_MaSinhVien);
		textField_MaSinhVien.setColumns(10);

		JButton button_Tim = new JButton("Tìm");
		button_Tim.setBounds(398, 9, 63, 23);
		contentPane.add(button_Tim);
		button_Tim.addActionListener(ql);

		comboBox_QueQuan_TimKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDsTinh();
		comboBox_QueQuan_TimKiem.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan_TimKiem.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan_TimKiem.setBounds(84, 9, 101, 22);
		contentPane.add(comboBox_QueQuan_TimKiem);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 69, 541, -11);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 47, 541, 2);
		contentPane.add(separator_2);

		JLabel label_QueQuan_2 = new JLabel("Danh Sách Sinh Viên");
		label_QueQuan_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_QueQuan_2.setBounds(10, 59, 147, 14);
		contentPane.add(label_QueQuan_2);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 sinh vi\u00EAn", "H\u1ECD t\u00EAn", "Ng\u00E0y Sinh", "Qu\u00EA qu\u00E1n",
						"Gi\u1EDBi t\u00EDnh", "\u0110i\u1EC3m 1", "\u0110i\u1EC3m 2", "\u0110i\u1EC3m 3" }));
		// Sét độ cao dòng trong table
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 84, 541, 174);
		contentPane.add(scrollPane);

		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 269, 541, 2);
		contentPane.add(separator_2_1);

		JLabel label_ThongTin = new JLabel("Thông Tin Sinh Viên");
		label_ThongTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_ThongTin.setBounds(10, 282, 126, 14);
		contentPane.add(label_ThongTin);

		JLabel label_id = new JLabel("Mã Sinh Viên");
		label_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_id.setBounds(10, 308, 111, 14);
		contentPane.add(label_id);

		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(95, 307, 96, 20);
		contentPane.add(textField_id);

		JLabel label_HoTen = new JLabel("Họ Tên");
		label_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_HoTen.setBounds(10, 334, 111, 14);
		contentPane.add(label_HoTen);

		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(95, 333, 96, 20);
		contentPane.add(textField_HoTen);

		JLabel label_QueQuan_3 = new JLabel("Quê Quán");
		label_QueQuan_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_QueQuan_3.setBounds(10, 361, 77, 14);
		contentPane.add(label_QueQuan_3);

		comboBox_QueQuan = new JComboBox();
		comboBox_QueQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_QueQuan.addItem(tinh.getTenTinh());
		}
		comboBox_QueQuan.setBounds(95, 359, 96, 22);
		contentPane.add(comboBox_QueQuan);

		JLabel label_NgaySinh = new JLabel("Ngày Sinh");
		label_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_NgaySinh.setBounds(10, 386, 111, 14);
		contentPane.add(label_NgaySinh);

		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(95, 385, 96, 20);
		contentPane.add(textField_NgaySinh);

		JLabel label_id_1 = new JLabel("Giới Tính");
		label_id_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_id_1.setBounds(292, 308, 111, 14);
		contentPane.add(label_id_1);

		rdbtnNewRadioButton_Nam = new JRadioButton("Nam");
		rdbtnNewRadioButton_Nam.setBounds(373, 306, 63, 23);
		contentPane.add(rdbtnNewRadioButton_Nam);

		rdbtnNewRadioButton_Nu = new JRadioButton("Nữ");
		rdbtnNewRadioButton_Nu.setBounds(438, 306, 63, 23);
		contentPane.add(rdbtnNewRadioButton_Nu);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton_Nu);
		buttonGroup.add(rdbtnNewRadioButton_Nam);

		JLabel lblimMn = new JLabel("Điểm Môn 1");
		lblimMn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblimMn.setBounds(292, 335, 111, 14);
		contentPane.add(lblimMn);

		textField_Mon1 = new JTextField();
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(377, 334, 96, 20);
		contentPane.add(textField_Mon1);

		JLabel lblimMn_1 = new JLabel("Điểm Môn 2");
		lblimMn_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblimMn_1.setBounds(292, 362, 111, 14);
		contentPane.add(lblimMn_1);

		textField_Mon2 = new JTextField();
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(377, 361, 96, 20);
		contentPane.add(textField_Mon2);

		JLabel lblimMn_2 = new JLabel("Điểm Môn 3");
		lblimMn_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblimMn_2.setBounds(292, 386, 111, 14);
		contentPane.add(lblimMn_2);

		textField_Mon3 = new JTextField();
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(377, 385, 96, 20);
		contentPane.add(textField_Mon3);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(16, 432, 89, 23);
		contentPane.add(btnThem);
		btnThem.addActionListener(ql);

		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(115, 432, 89, 23);
		contentPane.add(btnXa);
		btnXa.addActionListener(ql);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(229, 432, 89, 23);
		contentPane.add(btnCapNhat);
		btnCapNhat.addActionListener(ql);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(347, 432, 89, 23);
		contentPane.add(btnLuu);
		btnLuu.addActionListener(ql);

		JButton button_HuyBo = new JButton("Hủy bỏ");
		button_HuyBo.setBounds(462, 432, 89, 23);
		contentPane.add(button_HuyBo);
		button_HuyBo.addActionListener(ql);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 419, 541, 2);
		contentPane.add(separator_3);

		JButton button_HuyTim = new JButton("Hủy tìm");
		button_HuyTim.setBounds(471, 9, 80, 23);
		button_HuyTim.addActionListener(ql);
		contentPane.add(button_HuyTim);

		this.setSize(573, 521);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_id.setText("");
		textField_HoTen.setText("");
		textField_MaSinhVien.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		buttonGroup.clearSelection();
		comboBox_QueQuan.setSelectedIndex(-1);
		textField_NgaySinh.setText("");
	}

	public void themSinhVienVaoTable(SinhVienModel sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { sv.getMaSinhVien() + "", sv.getTenSinhVien(),
				sv.getNgaySinh().getDate() + "/" + (sv.getNgaySinh().getMonth() + 1) + "/"
						+ (sv.getNgaySinh().getYear() + 1900),
				sv.getQueQuan().getTenTinh(), (sv.isGioiTinh() ? "Nam" : "Nữ"), sv.getDiemMon1() + "",
				sv.getDiemMon2() + "", sv.getDiemMon3() + "", });
	}

	public void themHoacCapNhatSinhVien(SinhVienModel sv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		// Truyền bạn sinh viên và kiểm tra có trong model hay chưa nếu chưa thì thêm và
		// ngược lại thì Update theo mã sinh viên
		if (!this.qlsvModel.kiemTraTonTai(sv)) {
			this.qlsvModel.insert(sv);
			this.themSinhVienVaoTable(sv);
		} else {
			
			// getRowCount lấy ra số lượng dòng có trong table
			// getValueAt(1,2); tham số đầu tiên index row tham số thứ 2 vị trí index column
			// trong table
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(sv.getMaSinhVien() + "")) {
					this.qlsvModel.update(i,sv);
					model_table.setValueAt(sv.getMaSinhVien() + "", i, 0);
					model_table.setValueAt(sv.getTenSinhVien() + "", i, 1);
					model_table.setValueAt(sv.getNgaySinh().getDate() + "/" + (sv.getNgaySinh().getMonth() + 1) + "/"
							+ (sv.getNgaySinh().getYear() + 1900), i, 2);
					model_table.setValueAt(sv.getQueQuan().getTenTinh(), i, 3);
					model_table.setValueAt((sv.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(sv.getDiemMon1(), i, 5);
					model_table.setValueAt(sv.getDiemMon2(), i, 6);
					model_table.setValueAt(sv.getDiemMon3(), i, 7);
				}
			}
		}
	}

	public SinhVienModel getSinhVienDangChon() {
		// Lấy ra sinh viên đang được click chọn trên table
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int maSinhVien = Integer.valueOf((String) model_table.getValueAt(i_row, 0));
		String tenSinhVien = model_table.getValueAt(i_row, 1) + "";
		String s_ngaySinh = model_table.getValueAt(i_row, 2) + "";
		Date ngaySinh = new Date(s_ngaySinh);
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 3));
		String textGioiTinh = model_table.getValueAt(i_row, 4) + "";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5) + "");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6) + "");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7) + "");

		SinhVienModel sv = new SinhVienModel(maSinhVien, tenSinhVien, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2,
				diemMon3);
		return sv;
	}

	public void hienThiThongTinSinhVienDaChon() {
		SinhVienModel sv = this.getSinhVienDangChon();
		this.textField_id.setText(sv.getMaSinhVien() + "");
		this.textField_HoTen.setText(sv.getTenSinhVien());
		String s_ngaySinh = sv.getNgaySinh().getDate() + "/" + (sv.getNgaySinh().getMonth() + 1) + "/"
				+ (sv.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh);
		this.comboBox_QueQuan.setSelectedItem(sv.getQueQuan().getTenTinh());
		if (sv.isGioiTinh()) {
			rdbtnNewRadioButton_Nam.setSelected(true);
		} else {
			rdbtnNewRadioButton_Nu.setSelected(false);
		}
		this.textField_Mon1.setText(sv.getDiemMon1() + "");
		this.textField_Mon2.setText(sv.getDiemMon2() + "");
		this.textField_Mon3.setText(sv.getDiemMon3() + "");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng đang chọn");
		if (luaChon == JOptionPane.YES_OPTION) {
			SinhVienModel sv = this.getSinhVienDangChon();
			this.qlsvModel.delete(sv);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThem() {
		// Khi nhấn vào Button lưu các thông tin sẽ được cầm truyền vào Function
		// themHoacCapNhat để add bạn sinh viên vào table và Arraylist
		try {
			int maSinhVien = Integer.valueOf(this.textField_id.getText());
			String tenSinhVien = this.textField_HoTen.getText();
			int queQuan = this.comboBox_QueQuan.getSelectedIndex() - 1;
			Tinh tinh = Tinh.getTinhByID(queQuan);
			Date ngaySinh = new Date(this.textField_NgaySinh.getText());
			boolean gioiTinh = true;
			if (this.rdbtnNewRadioButton_Nam.isSelected()) {
				gioiTinh = true;
			} else if (this.rdbtnNewRadioButton_Nu.isSelected()) {
				gioiTinh = false;
			}
			float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
			float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
			float diemMon3 = Float.valueOf(this.textField_Mon3.getText());
			SinhVienModel sv = new SinhVienModel(maSinhVien, tenSinhVien, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2,
					diemMon3);
			this.themHoacCapNhatSinhVien(sv);

		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void thucHienTim() {
		// Gọi hàm hủy tìm để dữ liệu tìm trả về ban đầu
		this.loadLaiDuLieu();
		// Thực hiện tìm
		int queQuan = this.comboBox_QueQuan_TimKiem.getSelectedIndex() - 1;
		String maSinhVienTimKiem = this.textField_MaSinhVien.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaSinhVienCanXoa = new TreeSet<>();

		if (queQuan >= 0) {
			Tinh tinhDaChon = Tinh.getTinhByID(queQuan);
			for (int i = 0; i < soLuongDong; i++) {
				String tenTinh = model_table.getValueAt(i, 3) + "";
				String id = model_table.getValueAt(i, 0) + "";
				if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}

		if (maSinhVienTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maSinhVienTimKiem)) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}

		for (Integer idCanXoa : idCuaSinhVienCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void loadLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0) {
				break;
			}else {
				model_table.removeRow(0);
			}
		}
		for (SinhVienModel sv : this.qlsvModel.getDsSinhVien()) {
			this.themSinhVienVaoTable(sv);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm 1.0");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát?",
				"Exit",
				JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void saveFile(String path) {
		try {
			this.qlsvModel.setTenFile(path);
			OutputStream os = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (SinhVienModel sv : this.qlsvModel.getDsSinhVien()) {
				oos.writeObject(sv);
			}
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void thucHienSave() {
		JFileChooser fc = new JFileChooser();
		if(this.qlsvModel.getTenFile().length()>0) {
			saveFile(this.qlsvModel.getTenFile());
		}else {
			int returnVal = fc.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}
	
	
	public void openFile(File file) {
		ArrayList<SinhVienModel> ds = new ArrayList<SinhVienModel>();
		try {
			InputStream is = new FileInputStream(file.getAbsolutePath());
			ObjectInputStream ois = new ObjectInputStream(is);
			SinhVienModel sv = null;
			while((sv = (SinhVienModel) ois.readObject()) != null) {
				ds.add(sv);
			}
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.qlsvModel.setDsSinhVien(ds);
	}

	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			this.loadLaiDuLieu();
		}
	}

}
