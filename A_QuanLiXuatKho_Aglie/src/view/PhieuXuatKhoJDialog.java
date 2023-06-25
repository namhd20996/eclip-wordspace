package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.PhieuXuatKhoJDialogCTL;
import dao.CuaHangDao;
import dao.PhieuXuatKhoDao;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import model.CuaHangModel;
import model.PhieuXuatKhoModel;

import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class PhieuXuatKhoJDialog extends JDialog {
	private JTextField txtMaPhieuXuat;
	private JTextField txtNgayLap;
	private JTextField txtNgayXuat;
	private JTable table;
	private JTextField txtMaNV;
	private JComboBox comboBox;
	private Component btnUpdate;
	private JButton btnDelete;
	private JButton btnNew;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPre;
	private JButton btnFirst;
	private JButton btnAdd;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					PhieuXuatKhoJDialog dialog = new PhieuXuatKhoJDialog();
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
	public PhieuXuatKhoJDialog() {
		PhieuXuatKhoJDialogCTL ctl = new PhieuXuatKhoJDialogCTL(this);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 675, 533);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lí Phiếu Xuất Kho");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 265, 22);
		getContentPane().add(lblNewLabel);

		JLabel lbl_MaPhieuXuat = new JLabel("Mã phiếu xuất");
		lbl_MaPhieuXuat.setBounds(10, 44, 98, 14);
		getContentPane().add(lbl_MaPhieuXuat);

		JLabel lblNgayLap = new JLabel("Ngày lập");
		lblNgayLap.setBounds(292, 44, 48, 14);
		getContentPane().add(lblNgayLap);

		JLabel lblMaCuaHang = new JLabel("Mã cửa hàng");
		lblMaCuaHang.setBounds(10, 94, 136, 14);
		getContentPane().add(lblMaCuaHang);

		JLabel lblNgayXuat = new JLabel("Ngày xuất");
		lblNgayXuat.setBounds(292, 94, 135, 14);
		getContentPane().add(lblNgayXuat);

		txtMaPhieuXuat = new JTextField();
		txtMaPhieuXuat.setBounds(10, 69, 265, 20);
		getContentPane().add(txtMaPhieuXuat);
		txtMaPhieuXuat.setColumns(10);

		txtNgayLap = new JTextField();
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(292, 69, 373, 20);
		getContentPane().add(txtNgayLap);

		txtNgayXuat = new JTextField();
		txtNgayXuat.setColumns(10);
		txtNgayXuat.setBounds(292, 119, 373, 20);
		getContentPane().add(txtNgayXuat);

		comboBox = new JComboBox();
		comboBox.setBounds(10, 119, 265, 22);
		getContentPane().add(comboBox);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phiếu xuất", "Ngày lập", "Ngày xuất", "Mã cửa hàng", "Mã nhân viên" }));
		table.addMouseListener(ctl);

		JLabel lblDanhSach = new JLabel("Danh sách");
		lblDanhSach.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDanhSach.setForeground(new Color(0, 0, 255));
		lblDanhSach.setBounds(10, 200, 125, 31);
		getContentPane().add(lblDanhSach);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 242, 655, 246);
		getContentPane().add(scrollPane);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(ctl);
		btnAdd.setBounds(10, 499, 59, 23);
		getContentPane().add(btnAdd);

		btnUpdate = new JButton("Update");
		((AbstractButton) btnUpdate).addActionListener(ctl);
		btnUpdate.setBounds(79, 499, 67, 23);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(ctl);
		btnDelete.setBounds(156, 499, 67, 23);
		getContentPane().add(btnDelete);

		btnNew = new JButton("New");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(233, 499, 59, 23);
		getContentPane().add(btnNew);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(606, 499, 59, 23);
		getContentPane().add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(537, 499, 59, 23);
		getContentPane().add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(468, 499, 59, 23);
		getContentPane().add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(399, 499, 59, 23);
		getContentPane().add(btnFirst);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setBounds(10, 152, 136, 14);
		getContentPane().add(lblMaNhanVien);

		txtMaNV = new JTextField();
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(10, 177, 265, 20);
		getContentPane().add(txtMaNV);

		JLabel lbl_Exit = new JLabel("X");
		lbl_Exit.setName("Exit");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setForeground(new Color(255, 0, 0));
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setBounds(617, 11, 48, 22);
		getContentPane().add(lbl_Exit);

		upStatus();
		loadDataTable();
		loadCombobox();
	}

	public void resetForm() {
		txtMaPhieuXuat.setText("");
		txtNgayLap.setText("");
		txtNgayXuat.setText("");
		comboBox.setSelectedIndex(-1);
		txtMaNV.setText(Auth.user.getUser());
		txtMaPhieuXuat.requestFocus();
		count = -1;
		upStatus();
	}

	public void insertTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaPhieuXuat, sb, "Mã phiếu xuất null");
		DataValidator.validateDateNow(txtNgayLap, sb, "Ngày lập null");
		DataValidator.validateDateNow(txtNgayXuat, sb, "Ngày xuất null");
		DataValidator.validateDay(txtNgayLap, txtMaPhieuXuat, sb, "");
		DataValidator.validateCombobox(comboBox, sb, "Chưa chọn mã cửa hàng");
		DataValidator.validateEmpty(txtMaNV, sb, "Mã nhân viên null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maPhieuXuat = txtMaPhieuXuat.getText();
		Date ngayLap = XDate.dateFormat(txtNgayLap.getText());
		Date ngayXuat = XDate.dateFormat(txtNgayXuat.getText());
		String maCuaHang = comboBox.getSelectedItem().toString();
		String user = txtMaNV.getText();
		PhieuXuatKhoModel pxk = new PhieuXuatKhoModel(maPhieuXuat, ngayLap, ngayXuat, maCuaHang, user);
		if (PhieuXuatKhoDao.getInstance().selectByID(pxk) != null) {
			if (MsgBox.showConfirmDialog(this, "Phiếu xuất đã tồn tại bạn muốn cập nhật?",
					"Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (PhieuXuatKhoDao.getInstance().update(pxk) > 0) {
				MsgBox.showMessageDialog(this, "Update Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update Fail", "Notification");
			}
		}
		loadDataTable();
	}

	public void deleteTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaPhieuXuat, sb, "Mã phiếu xuất null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maPhieuXuat = txtMaPhieuXuat.getText();
		PhieuXuatKhoModel pxk = new PhieuXuatKhoModel();
		pxk.setMaPhieuXuat(maPhieuXuat);
		if (PhieuXuatKhoDao.getInstance().delete(pxk) > 0) {
			MsgBox.showMessageDialog(this, "Delete Successfull", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete Fail", "Notification");
		}
		loadDataTable();
	}

	private void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		ArrayList<PhieuXuatKhoModel> list = PhieuXuatKhoDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (PhieuXuatKhoModel phieuXuatKhoModel : list) {
			model_table.addRow(new Object[] { phieuXuatKhoModel.getMaPhieuXuat(),
					XDate.dateString(phieuXuatKhoModel.getNgayLap()), XDate.dateString(phieuXuatKhoModel.getNgayXuat()),
					phieuXuatKhoModel.getMaCuaHang(), phieuXuatKhoModel.getUser() });
		}
	}

	public void loadCombobox() {
		ArrayList<CuaHangModel> list = CuaHangDao.getInstance().selectAll();
		comboBox.addItem("");
		for (CuaHangModel cuaHangModel : list) {
			comboBox.addItem(cuaHangModel.getMaCuaHang());
		}
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}

	public void displayFormCapNhat() {
		PhieuXuatKhoModel pxk = getPhieuXuatKho();
		txtMaPhieuXuat.setText(pxk.getMaPhieuXuat());
		txtNgayLap.setText(XDate.dateString(pxk.getNgayLap()));
		txtNgayXuat.setText(XDate.dateString(pxk.getNgayXuat()));
		comboBox.setSelectedItem(pxk.getMaCuaHang());
		txtMaNV.setText(pxk.getUser());
		int i_row = table.getSelectedRow();
		count = i_row;
		upStatus();
	}

	public PhieuXuatKhoModel getPhieuXuatKho() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maPhieuXuat = model_table.getValueAt(i_row, 0) + "";
		PhieuXuatKhoModel pxk = new PhieuXuatKhoModel();
		pxk.setMaPhieuXuat(maPhieuXuat);
		PhieuXuatKhoModel pxkd = PhieuXuatKhoDao.getInstance().selectByID(pxk);
		return pxkd;
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txtMaPhieuXuat.setEditable(!edit);
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
}
