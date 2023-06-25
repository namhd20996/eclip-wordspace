package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BookCTL;
import model.BookModel;
import model.Data;
import model.QLBookModel;

import javax.swing.JScrollPane;
import java.awt.Font;
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
import java.awt.Color;

public class BookView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MaSach;
	private JTextField textField_TenSach;
	private JTextField textField_NamXuatBan;
	private JTable table;
	private JButton btn_Them;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnMoi;
	private JButton btnFirst;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private QLBookModel qlBookModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					BookView frame = new BookView();
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
	public BookView() {
		this.qlBookModel = new QLBookModel();
		BookCTL ctl = new BookCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Danh Mục Sách");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(199, 11, 256, 51);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã sách:");
		lblNewLabel_1.setBounds(34, 72, 48, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên sách:");
		lblNewLabel_2.setBounds(34, 116, 48, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Năm xuất bản:");
		lblNewLabel_3.setBounds(34, 165, 89, 14);
		contentPane.add(lblNewLabel_3);

		textField_MaSach = new JTextField();
		textField_MaSach.setBounds(136, 72, 164, 20);
		contentPane.add(textField_MaSach);
		textField_MaSach.setColumns(10);

		textField_TenSach = new JTextField();
		textField_TenSach.setColumns(10);
		textField_TenSach.setBounds(136, 113, 164, 20);
		contentPane.add(textField_TenSach);

		textField_NamXuatBan = new JTextField();
		textField_NamXuatBan.setColumns(10);
		textField_NamXuatBan.setBounds(136, 162, 164, 20);
		contentPane.add(textField_NamXuatBan);

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(ctl);
		btnNewButton.setBounds(431, 68, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(ctl);
		btnsave.setBounds(431, 112, 89, 23);
		contentPane.add(btnsave);

		JButton btnNewButton_2 = new JButton("ReadFile");
		btnNewButton_2.addActionListener(ctl);
		btnNewButton_2.setBounds(431, 161, 89, 23);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("SaveFile");
		btnNewButton_3.addActionListener(ctl);
		btnNewButton_3.setBounds(431, 204, 89, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Exit");
		btnNewButton_4.addActionListener(ctl);
		btnNewButton_4.setBounds(431, 247, 89, 23);
		contentPane.add(btnNewButton_4);

		JButton btn_Find = new JButton("Find");
		btn_Find.addActionListener(ctl);
		btn_Find.setBounds(34, 247, 89, 23);
		contentPane.add(btn_Find);

		JButton btnNewButton_6 = new JButton("Next");
		btnNewButton_6.addActionListener(ctl);
		btnNewButton_6.setBounds(182, 247, 89, 23);
		contentPane.add(btnNewButton_6);

		table = new JTable();
		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Mã sách", "Tên sách", "Năm xuất bản" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 310, 568, 172);
		contentPane.add(scrollPane);
		
		this.setLocationRelativeTo(null);
	}

	public void insertTable(BookModel b) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { b.getMaSach(), b.getTenSach(), b.getNamXuatBan() });
	}

	public void themvao(BookModel b) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		System.out.println(!this.qlBookModel.kiemTraTonTai(b));
		if (!this.qlBookModel.kiemTraTonTai(b)) {
			this.qlBookModel.insert(b);
			this.insertTable(b);
		} else {
			if (JOptionPane.showConfirmDialog(this, "Nhân viên đã tồn tại bạn muốn cập nhật?", "Update",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
			int soLuongDong = model_table.getRowCount();
			System.out.println(soLuongDong);
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(b.getMaSach())) {
					this.qlBookModel.update(i, b);
					model_table.setValueAt(b.getMaSach(), i, 0);
					model_table.setValueAt(b.getTenSach(), i, 1);
					model_table.setValueAt(b.getNamXuatBan(), i, 2);
					table.setRowSelectionInterval(i, i);
				}
			}
		}
	}

	public void getValueForm() {
		String maSach = this.textField_MaSach.getText();
		System.out.println(Data.isMaSach(maSach));
		if(!Data.isMaSach(maSach)) {
			JOptionPane.showMessageDialog(this, "Sai định dạng");
			return;
		}
		String tenSach = this.textField_TenSach.getText();
		int namXuatBan = Integer.valueOf(this.textField_NamXuatBan.getText());
		BookModel b = new BookModel(maSach, tenSach, namXuatBan);
		this.themvao(b);
	}
	
	
	public void resetForm() {
		this.textField_MaSach.setText("");
		this.textField_TenSach.setText("");
		this.textField_NamXuatBan.setText("");
		this.textField_MaSach.requestFocus();
		this.table.getSelectionModel().clearSelection();
	}
	
	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát?", "Exit", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void thucHienTim() {
		this.textField_TenSach.setText("");
		this.textField_NamXuatBan.setText("");
		// Gọi hàm hủy tìm để dữ liệu tìm trả về ban đầu
		this.loadLaiDuLieu();
		// Thực hiện tìm
		String maNhanVienTimKiem = this.textField_MaSach.getText();
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
	

	public void saveFile(String path) {
		try {
			this.qlBookModel.setTenFile(path);
			OutputStream os = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (BookModel nv : this.qlBookModel.getList()) {
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
		if (this.qlBookModel.getTenFile().length() > 0) {
			System.out.println(this.qlBookModel.getTenFile());
			saveFile(this.qlBookModel.getTenFile());
		} else {
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void openFile(File file) {
		ArrayList<BookModel> ds = new ArrayList<BookModel>();
		try {
			this.qlBookModel.setTenFile(file.getAbsolutePath());
			InputStream is = new FileInputStream(file.getAbsolutePath());
			ObjectInputStream ois = new ObjectInputStream(is);
			BookModel nv = null;
			while ((nv = (BookModel) ois.readObject()) != null) {
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
		this.qlBookModel.setList(ds);
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
		for (BookModel nv : this.qlBookModel.getList()) {
			System.out.println(nv);
			this.insertTable(nv);
		}
	}
}
