package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.HangHoaJDialogCTL;
import dao.HangHoaDao;
import dao.LoaiHangDao;
import lib.DataValidator;
import lib.MsgBox;
import model.HangHoaModel;
import model.LoaiHangModel;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class HangHoaJDialog extends JDialog {
	private JTable table;
	private JTextField txtMaMatHang;
	private JTextField txtTenMatHang;
	private JTextField txtDonViTinh;
	private JTextField txtDonGia;
	private JComboBox comboBox;
	private JButton btnFirst;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnNew;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnAdd;
	private int count = 0;
	private JLabel lbl_Exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					HangHoaJDialog dialog = new HangHoaJDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public HangHoaJDialog() {
		HangHoaJDialogCTL ctl = new HangHoaJDialogCTL(this);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 675, 533);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lí Hàng Hóa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(10, 11, 254, 22);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã mặt hàng");
		lblNewLabel_1.setBounds(10, 60, 99, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên mặt hàng");
		lblNewLabel_1_1.setBounds(297, 60, 78, 14);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Đơn vị tính");
		lblNewLabel_1_2.setBounds(10, 118, 99, 14);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Đơn giá");
		lblNewLabel_1_3.setBounds(297, 118, 48, 14);
		getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Mã loại hàng");
		lblNewLabel_1_4.setBounds(10, 166, 84, 14);
		getContentPane().add(lblNewLabel_1_4);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã HH", "Tên HH", "Đơn vị tính", "Đơn giá", "Mã LH" }));
		table.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 247, 655, 232);
		getContentPane().add(scrollPane);

		txtMaMatHang = new JTextField();
		txtMaMatHang.setBounds(10, 85, 254, 20);
		getContentPane().add(txtMaMatHang);
		txtMaMatHang.setColumns(10);

		txtTenMatHang = new JTextField();
		txtTenMatHang.setColumns(10);
		txtTenMatHang.setBounds(297, 85, 368, 20);
		getContentPane().add(txtTenMatHang);

		txtDonViTinh = new JTextField();
		txtDonViTinh.setColumns(10);
		txtDonViTinh.setBounds(10, 143, 254, 20);
		getContentPane().add(txtDonViTinh);

		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(297, 143, 368, 20);
		getContentPane().add(txtDonGia);

		comboBox = new JComboBox();
		comboBox.setBounds(10, 191, 254, 22);
		getContentPane().add(comboBox);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(ctl);
		btnAdd.setBounds(10, 499, 57, 23);
		getContentPane().add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setBounds(77, 499, 67, 23);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(ctl);
		btnDelete.setBounds(153, 499, 67, 23);
		getContentPane().add(btnDelete);

		btnNew = new JButton("New");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(230, 499, 57, 23);
		getContentPane().add(btnNew);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(608, 499, 57, 23);
		getContentPane().add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(541, 499, 57, 23);
		getContentPane().add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(474, 499, 57, 23);
		getContentPane().add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(407, 499, 57, 23);
		getContentPane().add(btnFirst);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		lbl_Exit = new JLabel("X");
		lbl_Exit.setName("Exit");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setForeground(new Color(255, 0, 0));
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setBounds(627, 11, 48, 23);
		getContentPane().add(lbl_Exit);

		upStatus();
		loadComBoBox();
		loadDataTable();
		this.setLocationRelativeTo(null);

	}

	public void resetForm() {
		txtMaMatHang.setText("");
		txtTenMatHang.setText("");
		txtDonViTinh.setText("");
		txtDonGia.setText("");
		comboBox.setSelectedIndex(-1);
		txtMaMatHang.requestFocus();
		count = -1;
		upStatus();
	}

	public void insertTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaMatHang, sb, "Mã mặt hàng null");
		DataValidator.validateIsHoTen(txtTenMatHang, sb, "Tên mặt hàng null");
		DataValidator.validateEmpty(txtDonViTinh, sb, "Đơn vị tính null");
		DataValidator.validateEmpty(txtDonGia, sb, "Đơn giá null");
		DataValidator.validateCombobox(comboBox, sb, "Chưa chọn mã loại hàng");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maMatHang = txtMaMatHang.getText();
		String tenMatHang = txtTenMatHang.getText();
		String donViTinh = txtDonViTinh.getText();
		double donGia = Double.valueOf(txtDonGia.getText());
		String maLoaiHang = comboBox.getSelectedItem().toString();
		HangHoaModel hh = new HangHoaModel(maMatHang, tenMatHang, donViTinh, donGia, maLoaiHang);
		if (HangHoaDao.getInstance().selectByID(hh) != null) {
			if (MsgBox.showConfirmDialog(this, "Mã mặt hàng đã tồn tại bạn muốn cập nhật?",
					"Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (HangHoaDao.getInstance().update(hh) > 0) {
				MsgBox.showMessageDialog(this, "Update Successfull", "Notificatin");
			} else {
				MsgBox.showMessageDialog(this, "Update Fail", "Notificatin");
			}
		} else {
			if (HangHoaDao.getInstance().insert(hh) > 0) {
				MsgBox.showMessageDialog(this, "Insert Successfull", "Notificatin");
			} else {
				MsgBox.showMessageDialog(this, "Insert Fail", "Notificatin");
			}
		}
		loadDataTable();
	}

	public void deleteTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaMatHang, null, "Mã mặt hàng null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maMatHang = txtMaMatHang.getText();
		HangHoaModel hh = new HangHoaModel();
		hh.setMaMatHang(maMatHang);
		if (HangHoaDao.getInstance().delete(hh) > 0) {
			MsgBox.showMessageDialog(this, "Delete Successfull", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete Fail", "Notification");
		}
	}

	private void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		ArrayList<HangHoaModel> list = HangHoaDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (HangHoaModel hangHoaModel : list) {
			model_table.addRow(new Object[] { hangHoaModel.getMaMatHang(), hangHoaModel.getTenMatHang(),
					hangHoaModel.getDonViTinh(), hangHoaModel.getDonGia(), hangHoaModel.getMaLoaiHang() });
		}
		model_table.fireTableDataChanged();
	}

	public void displayFormCapNhat() {
		HangHoaModel hh = getHangHoa();
		System.out.println(hh);
		txtMaMatHang.setText(hh.getMaMatHang());
		txtTenMatHang.setText(hh.getTenMatHang());
		txtDonViTinh.setText(hh.getDonViTinh());
		txtDonGia.setText(hh.getDonGia() + "");
//		System.out.println(hh.getMaLoaiHang());
		comboBox.setSelectedItem(hh.getMaLoaiHang());
		int i_row = table.getSelectedRow();
		count = i_row;
		upStatus();
	}

	public HangHoaModel getHangHoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maMatHang = model_table.getValueAt(i_row, 0) + "";
		HangHoaModel hh = new HangHoaModel();
		hh.setMaMatHang(maMatHang);
		HangHoaModel hhd = HangHoaDao.getInstance().selectByID(hh);
		return hhd;
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txtMaMatHang.setEditable(!edit);
		btnAdd.setEnabled(!edit);
		btnUpdate.setEnabled(edit);
		btnDelete.setEnabled(edit);

		btnFirst.setEnabled(edit && !first);
		btnPre.setEnabled(edit && !first);
		btnNext.setEnabled(edit && !last);
		btnLast.setEnabled(edit && !last);
	}

	public void firstElement() {
		count = 0;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void nextElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count > model_table.getRowCount() - 1) {
			count = model_table.getRowCount() - 1;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		count = model_table.getRowCount() - 1;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}

	public void loadComBoBox() {
		ArrayList<LoaiHangModel> list = LoaiHangDao.getInstance().selectAll();
		comboBox.addItem("");
		for (LoaiHangModel loaiHangModel : list) {
			comboBox.addItem(loaiHangModel.getMaLoaiHang());
		}
	}
}
