package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.QLBHCTL;
import lib.DataValidator;
import lib.MsgBox;

import model.MatHangModel;

import model.QLBHModel;

import javax.swing.JScrollPane;
import java.awt.Font;

public class QLBHView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaHang;
	private JTextField textField_TenHang;
	private JTextField textField_Dongia;
	private JTable table;
	private JLabel lblNewLabel_1_2;
	private QLBHModel qlbhModel;
	private JLabel lsblTong;
	private JButton Next;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					QLBHView frame = new QLBHView();
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
	public QLBHView() {
		QLBHCTL ctl = new QLBHCTL(this);
		this.qlbhModel = new QLBHModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lí Bán Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(114, 10, 275, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã hàng");
		lblNewLabel_1.setBounds(32, 61, 48, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên hàng");
		lblNewLabel_1_1.setBounds(32, 106, 48, 14);
		contentPane.add(lblNewLabel_1_1);

		lblNewLabel_1_2 = new JLabel("Tổng số mặt hàng:");
		lblNewLabel_1_2.setBounds(0, 154, 109, 14);
		contentPane.add(lblNewLabel_1_2);

		textField_MaHang = new JTextField();
		textField_MaHang.setBounds(103, 58, 96, 20);
		contentPane.add(textField_MaHang);
		textField_MaHang.setColumns(10);

		textField_TenHang = new JTextField();
		textField_TenHang.setColumns(10);
		textField_TenHang.setBounds(103, 103, 96, 20);
		contentPane.add(textField_TenHang);

		textField_Dongia = new JTextField();
		textField_Dongia.setColumns(10);
		textField_Dongia.setBounds(103, 151, 96, 20);
		contentPane.add(textField_Dongia);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(379, 57, 89, 23);
		contentPane.add(btnNew);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(ctl);
		btnSave.setBounds(379, 80, 89, 23);
		contentPane.add(btnSave);

		JButton btnReadF = new JButton("ReadF");
		btnReadF.addActionListener(ctl);
		btnReadF.setBounds(379, 106, 89, 23);
		contentPane.add(btnReadF);

		JButton btnSaveF = new JButton("SaveF");
		btnSaveF.addActionListener(ctl);
		btnSaveF.setBounds(379, 128, 89, 23);
		contentPane.add(btnSaveF);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(ctl);
		btnExit.setBounds(379, 150, 89, 23);
		contentPane.add(btnExit);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(ctl);
		btnFind.setBounds(32, 203, 89, 23);
		contentPane.add(btnFind);

		 Next = new JButton("Next");
		Next.addActionListener(ctl);
		Next.setBounds(147, 203, 89, 23);
		contentPane.add(Next);

		 lsblTong = new JLabel("");
		lsblTong.setBounds(245, 391, 195, 14);
		contentPane.add(lsblTong);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã hàng", "Tên hàng", "Giá" }));
		table.addMouseListener(ctl);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 244, 519, 131);
		contentPane.add(scrollPane);

		this.setLocationRelativeTo(null);
	}

	public void resetForm() {
		this.textField_MaHang.setText("");
		this.textField_TenHang.setText("");
		this.textField_TenHang.setText("");
		table.getSelectionModel().clearSelection();
		this.textField_MaHang.requestFocus();
	}

	public boolean checkGia() {
		try {
			double donGia = Double.valueOf(this.textField_Dongia.getText());
			if (donGia < 0 || donGia >= 40000) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	public void getValueForm() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(this.textField_MaHang, sb, "Tên hàng null");
		DataValidator.validateEmpty(this.textField_TenHang, sb, "Mã hàng null");
		DataValidator.validateEmpty(this.textField_Dongia, sb, "Đơn giá null");
		if (sb.length() > 0) {
			MsgBox.showMessageDialog(this, sb.toString(), "Notification");
			return;
		}

		String maHang = this.textField_MaHang.getText();
		String tenHang = this.textField_TenHang.getText();
		double donGia = Double.valueOf(this.textField_Dongia.getText());
		MatHangModel mh = new MatHangModel(maHang, tenHang, donGia);
		if (this.checkGia()) {
			this.themvao(mh);
		}
	}

	public void insertTable(MatHangModel b) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { b.getMaHang(), b.getTenHang(), b.getGia() });
	}

	public void themvao(MatHangModel b) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();

		if (!this.qlbhModel.kiemTraTonTai(b)) {
			this.qlbhModel.insert(b);
			this.insertTable(b);
			this.labelTT();
		} else {
			if (JOptionPane.showConfirmDialog(this, "Nhân viên đã tồn tại bạn muốn cập nhật?", "Update",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
			int soLuongDong = model_table.getRowCount();
			System.out.println(soLuongDong);
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(b.getMaHang())) {
					this.qlbhModel.update(i, b);
					model_table.setValueAt(b.getMaHang(), i, 0);
					model_table.setValueAt(b.getTenHang(), i, 1);
					model_table.setValueAt(b.getGia(), i, 2);
					table.setRowSelectionInterval(i, i);
				}
			}
		}
	}

	public void saveFile(String path) {
		try {
			this.qlbhModel.setTenFile(path);
			OutputStream os = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (MatHangModel nv : this.qlbhModel.getList()) {
				oos.writeObject(nv);
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
		if (this.qlbhModel.getTenFile().length() > 0) {
			System.out.println(this.qlbhModel.getTenFile());
			saveFile(this.qlbhModel.getTenFile());
		} else {
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void openFile(File file) {
		ArrayList<MatHangModel> ds = new ArrayList<MatHangModel>();
		try {
			this.qlbhModel.setTenFile(file.getAbsolutePath());
			InputStream is = new FileInputStream(file.getAbsolutePath());
			ObjectInputStream ois = new ObjectInputStream(is);
			MatHangModel nv = null;
			while ((nv = (MatHangModel) ois.readObject()) != null) {
				ds.add(nv);
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
		this.qlbhModel.setList(ds);
	}

	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			this.loadLaiDuLieu();
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
		for (MatHangModel nv : this.qlbhModel.getList()) {
			System.out.println(nv);
			this.insertTable(nv);
		}
	}

	public void thucHienTim() {
//		this.textField_MaHang.setText("");
		this.textField_TenHang.setText("");
		
		// Gọi hàm hủy tìm để dữ liệu tìm trả về ban đầu
		this.loadLaiDuLieu();
		// Thực hiện tìm
		String maNhanVienTimKiem = this.textField_MaHang.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaSinhVienCanXoa = new TreeSet<>();

		if (maNhanVienTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maNhanVienTimKiem)) {
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

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát?", "Exit", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void labelTT() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		this.lsblTong.setText("Tổng số "+model_table.getRowCount()+"");
	}
	

	public MatHangModel getNhanVienDangChon() {
		int i_Row = table.getSelectedRow();
		MatHangModel nv = this.qlbhModel.getList().get(i_Row);
		return nv;
	}
	
	public void updateForm() {
		MatHangModel nv = this.getNhanVienDangChon();
			this.textField_MaHang.setText(nv.getMaHang());
			this.textField_TenHang.setText(nv.getTenHang());
			this.textField_Dongia.setText(nv.getGia() + "");
			this.labelTT();
	}
	
	public void next() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		count = i_row;
		if(count > model_table.getRowCount()-1) {
			count = model_table.getRowCount()-1;
			
		}
		table.setRowSelectionInterval(count, count);
	}
}
