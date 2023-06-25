package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ListenerQLNV;
import model.QLNVModel;
import model.SinhVienModel;
import model.Staff;
import model.XFile;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.awt.Color;

public class QLNVView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_hoVaTen;
	private JTextField textField_luong;
	private QLNVModel qlnvModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNVView frame = new QLNVView();
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
	public QLNVView() {
		this.qlnvModel = new QLNVModel();
		ListenerQLNV ls = new ListenerQLNV(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý nhân viên");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(142, 11, 211, 38);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Họ và tên");
		lblNewLabel_1.setBounds(38, 67, 48, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Lương");
		lblNewLabel_2.setBounds(38, 96, 48, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(96, 132, 89, 23);
		contentPane.add(btnThem);
		btnThem.addActionListener(ls);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(217, 132, 89, 23);
		contentPane.add(btnLuu);
		btnLuu.addActionListener(ls);

		JButton btnDoc = new JButton("Đọc");
		btnDoc.setBounds(339, 132, 89, 23);
		contentPane.add(btnDoc);
		btnDoc.addActionListener(ls);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Họ và tên", "Lương" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 175, 418, 79);
		contentPane.add(scrollPane);

		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setBounds(96, 64, 332, 20);
		contentPane.add(textField_hoVaTen);
		textField_hoVaTen.setColumns(10);

		textField_luong = new JTextField();
		textField_luong.setColumns(10);
		textField_luong.setBounds(96, 93, 332, 20);
		contentPane.add(textField_luong);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void insertForm() {
		String name = this.textField_hoVaTen.getText();
		double salary = Double.valueOf(this.textField_luong.getText());
		Staff st = new Staff(name, salary);
		this.themHoacCapNhat(st);
	}

	private void themHoacCapNhat(Staff st) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.qlnvModel.kiemTraTonTai(st)) {
			this.insertTable(st);
			this.qlnvModel.insert(st);
		} else {
			this.qlnvModel.update(st);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String check = model_table.getValueAt(i, 0) + "";
				if (check.equals(st.getName())) {
					model_table.setValueAt(st.getName(), i, 0);
					model_table.setValueAt(st.getSalary(), i, 1);
				}
			}
		}
	}

	private void insertTable(Staff st) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { st.getName(), st.getSalary() });
	}

	public void saveFile(String path) {
		try {
			this.qlnvModel.setTenFile(path);
			ArrayList<Staff> list = this.qlnvModel.getDsNhanVien();
			XFile.writeObject(path, list);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void actionSaveFile() {
		JFileChooser fc = new JFileChooser();	
		if (this.qlnvModel.getTenFile().length() > 0) {
			this.saveFile(this.qlnvModel.getTenFile());
		} else {
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}
	
	public void openFile(String path) {
		ArrayList<Staff> list = new ArrayList<>();
		try {
			list = (ArrayList<Staff>) XFile.readObject(path);
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.qlnvModel.setDsNhanVien(list);
	}
	
	public void actionOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file.getAbsolutePath());
			this.loadLaiDuLieu();
		}
	}

	private void loadLaiDuLieu() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if(soLuongDong==0) {
				break;
			}else {
				model_table.removeRow(0);
			}
		}
		for (Staff nv : this.qlnvModel.getDsNhanVien()) {
			this.insertTable(nv);
		}
	}
}
