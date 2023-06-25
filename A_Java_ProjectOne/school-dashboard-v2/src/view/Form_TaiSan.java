package view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controller.Form_TaiSanCTL;
import dao.ChiTietTaiSanDao;
import dao.PhongDao;
import dao.TaiSanDao;
import lib.DataValidator;
import lib.MsgBox;
import model.ChiTietTaiSan;
import model.PhongModel;
import model.TaiSanModel;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;

public class Form_TaiSan extends JPanel {
	private int count = 0;
	private int count_CT = 0;
	private JTextField txtMaTaiSan;
	private JTextField txtTenTaiSan;
	private JTextField txtMaPhong_Find;
	private JTextField txtGiaTien;
	private JTextArea txtGhiChu;
	private JTable tblTaiSan;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnFirst;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private JTabbedPane tabbedPane_1;
	private JTextField txtSoLuong_CT;
	private JTextField txtTaiSanFind_CT;
	private JComboBox cboMaTaiSan;
	private JComboBox cboMaPhong;
	private JButton btnLast_CT;
	private JButton btnNext_CT;
	private JButton btnPre_CT;
	private JButton btnFirst_CT;
	private JButton btnLamMoi_CT;
	private JButton btnSua_CT;
	private JButton btnXoa_CT;
	private JButton btnThem_CT;
	private JTable tblTaiSan_CT;
	private JScrollPane scrollPane_1;
	private JTextArea txtGhiChu_CT;

	/**
	 * Create the panel.
	 */
	public Form_TaiSan() {
		Form_TaiSanCTL ctl = new Form_TaiSanCTL(this);
		setBounds(0, 11, 1200, 920);
		setBackground(new Color(227, 227, 227));
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 9, 505, 611);
		add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Tài sản", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã tài sản:");
		lblNewLabel.setBounds(10, 17, 70, 14);
		panel.add(lblNewLabel);

		txtMaTaiSan = new JTextField();
		txtMaTaiSan.setEditable(true);
		txtMaTaiSan.setColumns(10);
		txtMaTaiSan.setBounds(68, 11, 140, 20);
		panel.add(txtMaTaiSan);

		JLabel lblTnTiSn = new JLabel("Tên tài sản:");
		lblTnTiSn.setBounds(300, 17, 70, 14);
		panel.add(lblTnTiSn);

		txtTenTaiSan = new JTextField();
		txtTenTaiSan.setColumns(10);
		txtTenTaiSan.setBounds(380, 14, 140, 20);
		panel.add(txtTenTaiSan);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(68, 61, 445, 49);
		panel.add(txtGhiChu);

		JLabel lblNewLabel_2_1 = new JLabel("Ghi chú:");
		lblNewLabel_2_1.setBounds(10, 61, 48, 14);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Danh sách:");
		lblNewLabel_2_1_1.setBounds(10, 124, 70, 14);
		panel.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Tìm theo mã phòng:");
		lblNewLabel_2_1_1_1.setBounds(271, 124, 99, 14);
		panel.add(lblNewLabel_2_1_1_1);

		txtMaPhong_Find = new JTextField();
		txtMaPhong_Find.setColumns(10);
		txtMaPhong_Find.setBounds(373, 121, 140, 20);
		panel.add(txtMaPhong_Find);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setEnabled(true);
		btnThem.setBounds(10, 505, 61, 23);
		panel.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setEnabled(false);
		btnXoa.setBounds(70, 505, 61, 23);
		panel.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setEnabled(false);
		btnSua.setBounds(130, 505, 61, 23);
		panel.add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(188, 505, 75, 23);
		panel.add(btnLamMoi);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setEnabled(false);
		btnFirst.setBounds(304, 505, 48, 23);
		panel.add(btnFirst);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setEnabled(false);
		btnPre.setBounds(349, 505, 48, 23);
		panel.add(btnPre);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setEnabled(false);
		btnNext.setBounds(395, 505, 48, 23);
		panel.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setEnabled(false);
		btnLast.setBounds(442, 505, 48, 23);
		panel.add(btnLast);

		txtGiaTien = new JTextField();
		txtGiaTien.setColumns(10);
		txtGiaTien.setBounds(68, 36, 140, 20);
		panel.add(txtGiaTien);

		JLabel lblGiTin = new JLabel("Giá tiền:");
		lblGiTin.setBounds(10, 36, 48, 14);
		panel.add(lblGiTin);

		tblTaiSan = new JTable();
		tblTaiSan.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã tài sản", "Tên tài sản", "Giá tiền", "Ghi chú" }));

		JScrollPane scrollPane = new JScrollPane(tblTaiSan);
		scrollPane.setBounds(10, 161, 480, 291);
		panel.add(scrollPane);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 470, 480, 8);
		panel.add(separator);

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(525, 9, 455, 611);
		add(tabbedPane_1);

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Chi tiết tài sản", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã tài sản:");
		lblNewLabel_1.setBounds(10, 21, 64, 14);
		panel_1.add(lblNewLabel_1);

		cboMaTaiSan = new JComboBox();
		cboMaTaiSan.setBounds(71, 19, 140, 22);
		panel_1.add(cboMaTaiSan);

		JLabel lblNewLabel_1_2 = new JLabel("Mã phòng:");
		lblNewLabel_1_2.setBounds(231, 21, 64, 14);
		panel_1.add(lblNewLabel_1_2);

		cboMaPhong = new JComboBox();
		cboMaPhong.setBounds(289, 17, 135, 22);
		panel_1.add(cboMaPhong);

		JLabel lblNewLabel_1_4 = new JLabel("Số lượng:");
		lblNewLabel_1_4.setBounds(10, 51, 64, 14);
		panel_1.add(lblNewLabel_1_4);

		txtSoLuong_CT = new JTextField();
		txtSoLuong_CT.setColumns(10);
		txtSoLuong_CT.setBounds(71, 48, 140, 20);
		panel_1.add(txtSoLuong_CT);

		JLabel lblNewLabel_1_3 = new JLabel("Ghi chú:");
		lblNewLabel_1_3.setBounds(10, 79, 64, 14);
		panel_1.add(lblNewLabel_1_3);

		txtGhiChu_CT = new JTextArea();
		txtGhiChu_CT.setBounds(71, 74, 353, 43);
		panel_1.add(txtGhiChu_CT);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("Danh sách:");
		lblNewLabel_2_1_1_2.setBounds(10, 128, 70, 14);
		panel_1.add(lblNewLabel_2_1_1_2);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Tìm theo mã tài sản:");
		lblNewLabel_2_1_1_1_1.setBounds(161, 128, 119, 14);
		panel_1.add(lblNewLabel_2_1_1_1_1);

		txtTaiSanFind_CT = new JTextField();
		txtTaiSanFind_CT.setColumns(10);
		txtTaiSanFind_CT.setBounds(283, 125, 140, 20);
		panel_1.add(txtTaiSanFind_CT);

		btnThem_CT = new JButton("Thêm");
		btnThem_CT.addActionListener(ctl);
		btnThem_CT.setEnabled(true);
		btnThem_CT.setActionCommand("add");
		btnThem_CT.setBounds(10, 505, 61, 23);
		panel_1.add(btnThem_CT);

		btnXoa_CT = new JButton("Xóa");
		btnXoa_CT.addActionListener(ctl);
		btnXoa_CT.setEnabled(false);
		btnXoa_CT.setActionCommand("delete");
		btnXoa_CT.setBounds(70, 505, 61, 23);
		panel_1.add(btnXoa_CT);

		btnSua_CT = new JButton("Sửa");
		btnSua_CT.addActionListener(ctl);
		btnSua_CT.setEnabled(false);
		btnSua_CT.setActionCommand("update");
		btnSua_CT.setBounds(117, 505, 61, 23);
		panel_1.add(btnSua_CT);

		btnLamMoi_CT = new JButton("Làm mới");
		btnLamMoi_CT.addActionListener(ctl);
		btnLamMoi_CT.setActionCommand("new");
		btnLamMoi_CT.setBounds(175, 505, 75, 23);
		panel_1.add(btnLamMoi_CT);

		btnFirst_CT = new JButton("|<");
		btnFirst_CT.addActionListener(ctl);
		btnFirst_CT.setEnabled(false);
		btnFirst_CT.setActionCommand("first");
		btnFirst_CT.setBounds(243, 505, 48, 23);
		panel_1.add(btnFirst_CT);

		btnPre_CT = new JButton("<<");
		btnPre_CT.addActionListener(ctl);
		btnPre_CT.setEnabled(false);
		btnPre_CT.setActionCommand("pre");
		btnPre_CT.setBounds(288, 505, 48, 23);
		panel_1.add(btnPre_CT);

		btnNext_CT = new JButton(">>");
		btnNext_CT.addActionListener(ctl);
		btnNext_CT.setEnabled(false);
		btnNext_CT.setActionCommand("next");
		btnNext_CT.setBounds(334, 505, 48, 23);
		panel_1.add(btnNext_CT);

		btnLast_CT = new JButton(">|");
		btnLast_CT.addActionListener(ctl);
		btnLast_CT.setEnabled(false);
		btnLast_CT.setActionCommand("last");
		btnLast_CT.setBounds(381, 505, 48, 23);
		panel_1.add(btnLast_CT);

		tblTaiSan_CT = new JTable();
		tblTaiSan_CT.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã tài sản", "Mã phòng", "Số lượng", "Ghi chú" }));

		scrollPane_1 = new JScrollPane(tblTaiSan_CT);
		scrollPane_1.setBounds(10, 160, 413, 291);
		panel_1.add(scrollPane_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 474, 414, 2);
		panel_1.add(separator_1);
		
		
		this.tblTaiSan.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.tblTaiSan.getTableHeader().setOpaque(false);
		this.tblTaiSan.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblTaiSan.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblTaiSan.setRowHeight(25);
		
		
		this.tblTaiSan_CT.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.tblTaiSan_CT.getTableHeader().setOpaque(false);
		this.tblTaiSan_CT.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblTaiSan_CT.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblTaiSan_CT.setRowHeight(25);

		loadDataTable();
		loadCBOMaTaiSan();
		loadCBOMaPhong();
		loadTableTaiSan_CT();
		upStatus();
		upStatus_CT();
	}

	public void resetForm() {
		txtGhiChu.setText("");
		txtGiaTien.setText("");
		txtMaPhong_Find.setText("");
		txtMaTaiSan.setText("");
		txtTenTaiSan.setText("");
		txtMaTaiSan.requestFocus();
		count = -1;
		upStatus();
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) tblTaiSan.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txtMaTaiSan.setEditable(!edit);
		btnThem.setEnabled(!edit);
		btnSua.setEnabled(edit);
		btnXoa.setEnabled(edit);

		btnFirst.setEnabled(edit && !first);
		btnPre.setEnabled(edit && !first);
		btnNext.setEnabled(edit && !last);
		btnLast.setEnabled(edit && !last);
	}

	public void firstElement() {
		count = 0;
		tblTaiSan.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		tblTaiSan.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblTaiSan.getSelectedRow();
		count = i_row;
		count++;
		if (count > tblTaiSan.getRowCount() - 1) {
			count = tblTaiSan.getRowCount() - 1;
		}
		tblTaiSan.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) tblTaiSan.getModel();
		count = model_table.getRowCount() - 1;
		tblTaiSan.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void displayFormCapNhat() {
		TaiSanModel ts = getValuesForm();
		txtMaTaiSan.setText(ts.getMaTaiSan());
		txtTenTaiSan.setText(ts.getTenTaiSan());
		txtGiaTien.setText(ts.getGiaTien() + "");
		txtGhiChu.setText(ts.getGhiChu());
		int i_row = tblTaiSan.getSelectedRow();
		count = i_row;
		upStatus();
	}

	public TaiSanModel getValuesForm() {
		DefaultTableModel model_table = (DefaultTableModel) tblTaiSan.getModel();
		int i_row = tblTaiSan.getSelectedRow();
		String maTaiSan = model_table.getValueAt(i_row, 0) + "";
		TaiSanModel ts = TaiSanDao.getInstance().selectByID(new TaiSanModel(maTaiSan));
		return ts;
	}

	public void insertTableTaiSan() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaTaiSan, sb, "Mã tài sản null");
		DataValidator.validateEmpty(txtTenTaiSan, sb, "Tên tài sản null");
		DataValidator.validateEmpty(txtGiaTien, sb, "Giá tiền null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maTaiSan = txtMaTaiSan.getText();
		String tenTaiSan = txtTenTaiSan.getText();
		double giaTien = Double.valueOf(txtGiaTien.getText());
		String ghiChu = txtGhiChu.getText();
		TaiSanModel ts = new TaiSanModel(maTaiSan, tenTaiSan, giaTien, ghiChu);
		if (TaiSanDao.getInstance().selectByID(ts) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (TaiSanDao.getInstance().update(ts) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}
		} else {
			if (TaiSanDao.getInstance().insert(ts) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
		}
		loadDataTable();
	}

	public void deleteTableTaiSan() {
		TaiSanModel ts = getValuesForm();
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa?", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		if (TaiSanDao.getInstance().delete(ts) > 0) {
			MsgBox.showMessageDialog(this, "Delete success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete success", "Notification");
		}
		loadDataTable();
	}

	public void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) tblTaiSan.getModel();
		ArrayList<TaiSanModel> list = TaiSanDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (TaiSanModel taiSanModel : list) {
			model_table.addRow(new Object[] { taiSanModel.getMaTaiSan(), taiSanModel.getTenTaiSan(),
					taiSanModel.getGiaTien(), taiSanModel.getGhiChu(), });
		}
	}

	public void loadCBOMaTaiSan() {
		ArrayList<TaiSanModel> list = TaiSanDao.getInstance().selectAll();
		for (TaiSanModel taiSanModel : list) {
			cboMaTaiSan.addItem(taiSanModel.getMaTaiSan());
		}
	}

	public void loadCBOMaPhong() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
		for (PhongModel phongModel : list) {
			cboMaPhong.addItem(phongModel.getMaPhong());
		}
	}

	public void loadTableTaiSan_CT() {
		DefaultTableModel model_table = (DefaultTableModel) tblTaiSan_CT.getModel();
		ArrayList<ChiTietTaiSan> list = ChiTietTaiSanDao.getInstance().selectAll();
		for (ChiTietTaiSan chiTietTaiSan : list) {
			model_table.addRow(new Object[] { chiTietTaiSan.getMaTaiSan(), chiTietTaiSan.getMaPhong(),
					chiTietTaiSan.getSoLuong(), chiTietTaiSan.getGhiChu() });
		}
	}

	public void insertTableTaiSanCT() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateCombobox(cboMaTaiSan, sb, "Mã tài sản null");
		DataValidator.validateCombobox(cboMaPhong, sb, "Mã phòng null");
		DataValidator.validateNumber(txtSoLuong_CT, sb, "Số lượng null");
		if (sb.length() > 0) {
			MsgBox.showMessageDialog(this, sb.toString(), "Error");
			return;
		}
		String maTaiSan = cboMaTaiSan.getSelectedItem() + "";
		String maPhong = cboMaPhong.getSelectedItem() + "";
		int soLuong = Integer.valueOf(txtSoLuong_CT.getText());
		String ghiChu = txtGhiChu_CT.getText();
		ChiTietTaiSan ct = new ChiTietTaiSan(maPhong, maTaiSan, ghiChu, soLuong);
		if (ChiTietTaiSanDao.getInstance().selectByID(ct) != null) {
			if (MsgBox.showConfirmDialog(this, "CTTS đã tồn tại bạn muốn cập nhật",
					"Notification") == JOptionPane.NO_OPTION) {
				if (ChiTietTaiSanDao.getInstance().update(ct) > 0) {
					MsgBox.showMessageDialog(this, "Success", "Notification");
				} else {
					MsgBox.showMessageDialog(this, "Fail", "Notification");
				}
			}

		} else {
			if (ChiTietTaiSanDao.getInstance().insert(ct) > 0) {
				MsgBox.showMessageDialog(this, "Success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Fail", "Notification");
			}
		}
		loadTableTaiSan_CT();
	}

	public ChiTietTaiSan getValueFormCT() {
		DefaultTableModel model_table = (DefaultTableModel) tblTaiSan_CT.getModel();
		int i_row = tblTaiSan_CT.getSelectedRow();
		String maTaiSan = model_table.getValueAt(i_row, 0) + "";
		String maPhong = model_table.getValueAt(i_row, 1) + "";
		ChiTietTaiSan c = new ChiTietTaiSan();
		c.setMaTaiSan(maTaiSan);
		c.setMaPhong(maPhong);
		ChiTietTaiSan ct = ChiTietTaiSanDao.getInstance().selectByID(c);
		return ct;
	}

	public void displayOnFormTaiSan_CT() {
		ChiTietTaiSan t = getValueFormCT();
		cboMaTaiSan.setSelectedItem(t.getMaTaiSan());
		cboMaPhong.setSelectedItem(t.getMaPhong());
		txtSoLuong_CT.setText(t.getSoLuong() + "");
		txtGhiChu.setText(t.getGhiChu());
		int i_row = tblTaiSan_CT.getSelectedRow();
		count_CT = i_row;
		upStatus_CT();
	}

	public void deleteTaiSan_CT() {
		ChiTietTaiSan ct = getValueFormCT();
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		if (ChiTietTaiSanDao.getInstance().delete(ct) > 0) {
			MsgBox.showMessageDialog(this, "Success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Fail", "Notification");
		}
	}

	public void upStatus_CT() {
		DefaultTableModel model_table = (DefaultTableModel) tblTaiSan_CT.getModel();
		boolean edit = this.count_CT >= 0;
		boolean first = this.count_CT == 0;
		boolean last = this.count_CT == model_table.getRowCount() - 1;

//		txtMaTaiSan.setEditable(!edit);
		btnThem_CT.setEnabled(!edit);
		btnSua_CT.setEnabled(edit);
		btnXoa_CT.setEnabled(edit);

		btnFirst_CT.setEnabled(edit && !first);
		btnPre_CT.setEnabled(edit && !first);
		btnNext_CT.setEnabled(edit && !last);
		btnLast_CT.setEnabled(edit && !last);
	}

	public void firstElement_CT() {
		count_CT = 0;
		tblTaiSan_CT.setRowSelectionInterval(count_CT, count_CT);
		upStatus_CT();
		displayOnFormTaiSan_CT();
	}

	public void previousElement_CT() {
		count_CT--;
		if (count_CT < 0) {
			count_CT = 0;
		}
		tblTaiSan_CT.setRowSelectionInterval(count_CT, count_CT);
		upStatus_CT();
		displayOnFormTaiSan_CT();
	}

	public void nextElement_CT() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblTaiSan_CT.getSelectedRow();
		count_CT = i_row;
		count++;
		if (count_CT > tblTaiSan_CT.getRowCount() - 1) {
			count_CT = tblTaiSan_CT.getRowCount() - 1;
		}
		tblTaiSan_CT.setRowSelectionInterval(count_CT, count_CT);
		upStatus_CT();
		displayOnFormTaiSan_CT();
	}

	public void lastElement_CT() {
		DefaultTableModel model_table = (DefaultTableModel) tblTaiSan_CT.getModel();
		count_CT = model_table.getRowCount() - 1;
		tblTaiSan_CT.setRowSelectionInterval(count_CT, count_CT);
		upStatus_CT();
		displayOnFormTaiSan_CT();
	}

	public void resetForm_CT() {
		cboMaTaiSan.setSelectedIndex(-1);
		cboMaPhong.setSelectedIndex(-1);
		txtSoLuong_CT.setText("");
		txtGhiChu_CT.setText("");
		count_CT = -1;
		upStatus_CT();
		tblTaiSan_CT.getSelectionModel().clearSelection();
	}
}
