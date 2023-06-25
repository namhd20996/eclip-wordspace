package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ChiTietPhieuXuatJDialogCTL;
import dao.ChiTietPhieuXuatDao;
import dao.CuaHangDao;
import dao.HangHoaDao;
import dao.PhieuXuatKhoDao;
import lib.DataValidator;
import lib.MsgBox;
import model.ChiTietPhieuXuatModel;
import model.CuaHangModel;
import model.HangHoaModel;
import model.PhieuXuatKhoModel;

import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ChiTietPhieuXuatJDialog extends JDialog {
	private JTextField txtSoLuong;
	private JTable table;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnNew;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPre;
	private JButton btnFirst;
	private JComboBox cboMaPhieuXuat;
	private JComboBox cboMaMatHang;
	private JTextArea txt_GhiChu;
	private JLabel lbl_Exit;
	private int count =0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ChiTietPhieuXuatJDialog dialog = new ChiTietPhieuXuatJDialog();
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
	public ChiTietPhieuXuatJDialog() {
		ChiTietPhieuXuatJDialogCTL ctl = new ChiTietPhieuXuatJDialogCTL(this);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Chi Tiết Phiếu Xuất");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 401, 25);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã phiếu xuất");
		lblNewLabel_1.setBounds(10, 47, 133, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mã mặt hàng");
		lblNewLabel_1_1.setBounds(348, 47, 115, 14);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Số lượng");
		lblNewLabel_1_2.setBounds(10, 102, 48, 14);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Ghi chú");
		lblNewLabel_1_3.setBounds(10, 157, 48, 14);
		getContentPane().add(lblNewLabel_1_3);

		cboMaPhieuXuat = new JComboBox();
		cboMaPhieuXuat.setBounds(10, 72, 312, 22);
		getContentPane().add(cboMaPhieuXuat);

		cboMaMatHang = new JComboBox();
		cboMaMatHang.setBounds(348, 72, 312, 22);
		getContentPane().add(cboMaMatHang);

		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(10, 126, 312, 20);
		getContentPane().add(txtSoLuong);
		txtSoLuong.setColumns(10);

		txt_GhiChu = new JTextArea();
		txt_GhiChu.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		txt_GhiChu.setBounds(10, 182, 650, 66);
		getContentPane().add(txt_GhiChu);

		JLabel lblNewLabel_1_3_1 = new JLabel("Danh sách");
		lblNewLabel_1_3_1.setBounds(10, 256, 115, 14);
		getContentPane().add(lblNewLabel_1_3_1);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phiếu xuất", "Mã mặt hàng", "Số lượng", "Ghi chú" }));
		table.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 291, 655, 190);
		getContentPane().add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 182, 650, 66);
		getContentPane().add(scrollPane_1);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(ctl);
		btnAdd.setBounds(10, 499, 61, 23);
		getContentPane().add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setBounds(81, 499, 73, 23);
		getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(ctl);
		btnDelete.setBounds(164, 499, 73, 23);
		getContentPane().add(btnDelete);

		btnNew = new JButton("New");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(247, 499, 61, 23);
		getContentPane().add(btnNew);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(604, 499, 61, 23);
		getContentPane().add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(533, 499, 61, 23);
		getContentPane().add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(462, 499, 61, 23);
		getContentPane().add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(391, 499, 61, 23);
		getContentPane().add(btnFirst);
		setBounds(100, 100, 675, 533);

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
		lbl_Exit.setBounds(627, 11, 48, 25);
		getContentPane().add(lbl_Exit);

		upStatus();
		loadCombobox();
		loadDataTable();
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);

	}

	public void resetForm() {
		cboMaPhieuXuat.setSelectedIndex(-1);
		cboMaMatHang.setSelectedIndex(-1);
		txtSoLuong.setText("");
		txt_GhiChu.setText("");
		count = -1;
		upStatus();
	}

	public void insertTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateCombobox(cboMaPhieuXuat, sb, "Chưa chọn mã phiếu xuất");
		DataValidator.validateCombobox(cboMaMatHang, sb, "Chưa chọn mã mặt hàng");
		DataValidator.validateEmpty(txtSoLuong, sb, "Số lượng null");
		if (sb.length() > 0) {
			MsgBox.showMessageDialog(this, sb.toString(), "Notification");
			return;
		}
		String maPhieuXuat = cboMaPhieuXuat.getSelectedItem().toString();
		String maMatHang = cboMaMatHang.getSelectedItem().toString();
		int soLuong = Integer.valueOf(txtSoLuong.getText());
		String ghiChu = txt_GhiChu.getText();
		ChiTietPhieuXuatModel ctpx = new ChiTietPhieuXuatModel(maPhieuXuat, maMatHang, soLuong, ghiChu);
		if (ChiTietPhieuXuatDao.getInstance().selectByID(ctpx) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn có muốn cập nhật", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (ChiTietPhieuXuatDao.getInstance().update(ctpx) > 0) {
				MsgBox.showMessageDialog(this, "Update Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update Fail", "Notification");
			}
		} else {
			MsgBox.showMessageDialog(this, "Mã phiếu xuất chưa tồn tại", "Notification");
		}
		loadDataTable();
	}

	public void deleteTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateCombobox(cboMaPhieuXuat, sb, "Chưa chọn mã phiếu xuất");
		if (sb.length() > 0) {
			MsgBox.showMessageDialog(this, sb.toString(), "Notification");
			return;
		}
		String maPhieuXuat = cboMaPhieuXuat.getSelectedItem().toString();
		ChiTietPhieuXuatModel ctpx = new ChiTietPhieuXuatModel();
		ctpx.setMaPhieuXuat(maPhieuXuat);
		if (ChiTietPhieuXuatDao.getInstance().delete(ctpx) > 0) {
			MsgBox.showMessageDialog(this, "Delete Successfull", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete Fail", "Notification");
		}
		loadDataTable();
	}

	private void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		ArrayList<ChiTietPhieuXuatModel> list = ChiTietPhieuXuatDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (ChiTietPhieuXuatModel ctpxk : list) {
			model_table.addRow(new Object[] { ctpxk.getMaPhieuXuat(), ctpxk.getMaMatHang(), ctpxk.getSoLuong(),
					ctpxk.getGhiChu() });
		}
		model_table.fireTableDataChanged();
	}

	public void loadCombobox() {
		ArrayList<PhieuXuatKhoModel> listPx = PhieuXuatKhoDao.getInstance().selectAll();
		ArrayList<HangHoaModel> listHh = HangHoaDao.getInstance().selectAll();
		cboMaPhieuXuat.addItem("");
		for (PhieuXuatKhoModel pxk : listPx) {
			cboMaPhieuXuat.addItem(pxk.getMaPhieuXuat());
		}

		cboMaMatHang.addItem("");
		for (HangHoaModel ch : listHh) {
			cboMaMatHang.addItem(ch.getMaMatHang());
		}
	}

	public void displayFormCapNhat() {
		ChiTietPhieuXuatModel ctpx = getChiTietPhieuXuat();
		cboMaPhieuXuat.setSelectedItem(ctpx.getMaPhieuXuat());
		System.out.println(ctpx.getMaMatHang());
		cboMaMatHang.setSelectedItem(ctpx.getMaMatHang());
		txtSoLuong.setText(ctpx.getSoLuong()+"");
		txt_GhiChu.setText(ctpx.getGhiChu());
		int i_row = table.getSelectedRow();
		count  = i_row;
		upStatus();
	}

	public ChiTietPhieuXuatModel getChiTietPhieuXuat() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maPhieuXuat = model_table.getValueAt(i_row, 0) + "";
		ChiTietPhieuXuatModel ctpx = new ChiTietPhieuXuatModel();
		ctpx.setMaPhieuXuat(maPhieuXuat);
		ChiTietPhieuXuatModel ctpxd = ChiTietPhieuXuatDao.getInstance().selectByID(ctpx);
		return ctpxd;
	}

	
	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

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
}
