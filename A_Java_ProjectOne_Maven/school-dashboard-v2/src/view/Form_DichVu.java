package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

import controller.Form_DichVuCTL;
import dao.ChiTietDichVuDao;
import dao.DichVuDao;
import dao.PhongDao;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import model.ChiTietDichVuModel;
import model.DichVuModel;
import model.PhieuChiModel;
import model.PhongModel;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class Form_DichVu extends JPanel {
	private JTextField txtMaDichVu;
	private JTextField txtMaNhanVien;
	private JTextField txtGiaDichVu;
	private JTextField txtTenDichVu;
	private JTable tblDichVu;
	private JTable tblChiTietDichVu;
	private JTextField txtFindMaPhong;
	private JTextField txtFindMaDV;
	private JTextArea txtGhiChu;
	private JTextArea txtGhiChu_CTDV;
	private JComboBox cboMaPhong;
	private JButton btnFirst;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnLamMoi;

	private JButton btnXoa;
	private JButton btnNext_CTDV;
	private JButton btnLast_CTDV;
	private JButton btnLamMoi_CTDV;
	private JButton btnSua_CTDV;
	private JButton btnPre_CTDV;
	private JButton btnFirst_CTDV;
	private JButton btnThem_CTDV;
	private JButton btnXoa_CTDV;
	private JButton btnFindMaPhong;
	private JButton btnThem;
	private JButton btnSua;

	private int count_DV = 0;
	private int count_CTDV = 0;
	private JComboBox cboMaDichVu;

	/**
	 * Create the panel.
	 */
	public Form_DichVu() {
		Form_DichVuCTL ctl = new Form_DichVuCTL(this);
		setBounds(0, 11, 1200, 920);
		setBackground(new Color(227, 227, 227));
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 509, 578);
		add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Quản lý dịch vụ", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã dịch vụ:");
		lblNewLabel.setBounds(10, 14, 81, 14);
		panel.add(lblNewLabel);

		txtMaDichVu = new JTextField();
		txtMaDichVu.setColumns(10);
		txtMaDichVu.setBounds(71, 11, 146, 20);
		panel.add(txtMaDichVu);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(344, 11, 146, 20);
		panel.add(txtMaNhanVien);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setBounds(274, 14, 94, 14);
		panel.add(lblMNhnVin);

		JLabel lblNewLabel_2 = new JLabel("Giá dịch vụ:");
		lblNewLabel_2.setBounds(274, 39, 81, 14);
		panel.add(lblNewLabel_2);

		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setColumns(10);
		txtGiaDichVu.setBounds(344, 36, 146, 20);
		panel.add(txtGiaDichVu);

		txtTenDichVu = new JTextField();
		txtTenDichVu.setColumns(10);
		txtTenDichVu.setBounds(71, 36, 146, 20);
		panel.add(txtTenDichVu);

		JLabel lblTnDchV = new JLabel("Tên dịch vụ:");
		lblTnDchV.setBounds(10, 39, 81, 14);
		panel.add(lblTnDchV);

		JLabel lblNewLabel_2_1 = new JLabel("Ghi chú:");
		lblNewLabel_2_1.setBounds(10, 64, 81, 14);
		panel.add(lblNewLabel_2_1);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(10, 80, 480, 45);
		panel.add(txtGhiChu);

		JLabel lblNewLabel_2_1_1 = new JLabel("Danh sách:");
		lblNewLabel_2_1_1.setBounds(10, 136, 81, 14);
		panel.add(lblNewLabel_2_1_1);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(10, 482, 89, 23);
		panel.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(97, 482, 89, 23);
		panel.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(317, 482, 89, 23);
		panel.add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(405, 482, 89, 23);
		panel.add(btnLamMoi);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(405, 516, 89, 23);
		panel.add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(317, 516, 89, 23);
		panel.add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(97, 516, 89, 23);
		panel.add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(10, 516, 89, 23);
		panel.add(btnFirst);

		tblDichVu = new JTable();
		tblDichVu.setShowVerticalLines(false);
		tblDichVu.setSelectionBackground(new Color(255, 128, 0));
		tblDichVu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã dịch vụ", "Mã nhân viên", "Tên dịch vụ", "Giá dịch vụ", "Ghi chú" }));
		tblDichVu.setName("tblDichVu");
		tblDichVu.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(tblDichVu);
		scrollPane.setBounds(10, 190, 484, 268);
		panel.add(scrollPane);

		JLabel lblNewLabel_1 = new JLabel("Mã dịch vụ:");
		lblNewLabel_1.setBounds(10, 165, 81, 14);
		panel.add(lblNewLabel_1);

		txtFindMaDV = new JTextField();
		txtFindMaDV.setColumns(10);
		txtFindMaDV.setBounds(71, 162, 324, 20);
		panel.add(txtFindMaDV);

		JButton btnFindMaDV = new JButton("Tìm");
		btnFindMaDV.setBounds(401, 159, 89, 23);
		panel.add(btnFindMaDV);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(529, 11, 438, 578);
		add(tabbedPane_1);

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Chi tiết dịch vụ", null, panel_1, null);
		panel_1.setLayout(null);

		txtGhiChu_CTDV = new JTextArea();
		txtGhiChu_CTDV.setBounds(10, 80, 413, 45);
		panel_1.add(txtGhiChu_CTDV);

		JLabel lblMNhnVin_1_3 = new JLabel("Ghi chú:");
		lblMNhnVin_1_3.setBounds(10, 64, 94, 14);
		panel_1.add(lblMNhnVin_1_3);

		JLabel lblMNhnVin_1_2 = new JLabel("Mã dịch vụ:");
		lblMNhnVin_1_2.setBounds(10, 39, 94, 14);
		panel_1.add(lblMNhnVin_1_2);

		JLabel lblMNhnVin_1_1 = new JLabel("Mã phòng:");
		lblMNhnVin_1_1.setBounds(10, 14, 94, 14);
		panel_1.add(lblMNhnVin_1_1);

		JLabel lblMNhnVin_1_3_1 = new JLabel("Danh sách:");
		lblMNhnVin_1_3_1.setBounds(6, 136, 94, 14);
		panel_1.add(lblMNhnVin_1_3_1);

		tblChiTietDichVu = new JTable();
		tblChiTietDichVu.setShowVerticalLines(false);
		tblChiTietDichVu.setSelectionBackground(new Color(255, 128, 0));
		tblChiTietDichVu.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "Mã phòng", "Mã dịch vụ", "Ghi chú" }));
		tblChiTietDichVu.setName("tblCTDV");
		tblChiTietDichVu.addMouseListener(ctl);

		JScrollPane scrollPane_1 = new JScrollPane(tblChiTietDichVu);
		scrollPane_1.setBounds(6, 190, 417, 268);
		panel_1.add(scrollPane_1);

		txtFindMaPhong = new JTextField();
		txtFindMaPhong.setColumns(10);
		txtFindMaPhong.setBounds(68, 159, 256, 20);
		panel_1.add(txtFindMaPhong);

		JLabel lblMNhnVin_1_1_1 = new JLabel("Mã phòng:");
		lblMNhnVin_1_1_1.setBounds(6, 162, 94, 14);
		panel_1.add(lblMNhnVin_1_1_1);

		btnFindMaPhong = new JButton("Tìm");
		btnFindMaPhong.setActionCommand("find");
		btnFindMaPhong.addActionListener(ctl);
		btnFindMaPhong.setBounds(334, 156, 89, 23);
		panel_1.add(btnFindMaPhong);

		btnXoa_CTDV = new JButton("Xóa");
		btnXoa_CTDV.setActionCommand("delete");
		btnXoa_CTDV.addActionListener(ctl);
		btnXoa_CTDV.setBounds(93, 483, 89, 23);
		panel_1.add(btnXoa_CTDV);

		btnThem_CTDV = new JButton("Thêm");
		btnThem_CTDV.setActionCommand("add");
		btnThem_CTDV.addActionListener(ctl);
		btnThem_CTDV.setBounds(6, 483, 89, 23);
		panel_1.add(btnThem_CTDV);

		btnFirst_CTDV = new JButton("|<");
		btnFirst_CTDV.setActionCommand("first");
		btnFirst_CTDV.addActionListener(ctl);
		btnFirst_CTDV.setBounds(6, 517, 89, 23);
		panel_1.add(btnFirst_CTDV);

		btnPre_CTDV = new JButton("<<");
		btnPre_CTDV.setActionCommand("pre");
		btnPre_CTDV.addActionListener(ctl);
		btnPre_CTDV.setBounds(93, 517, 89, 23);
		panel_1.add(btnPre_CTDV);

		btnSua_CTDV = new JButton("Sửa");
		btnSua_CTDV.setActionCommand("update");
		btnSua_CTDV.addActionListener(ctl);
		btnSua_CTDV.setBounds(246, 483, 89, 23);
		panel_1.add(btnSua_CTDV);

		btnLamMoi_CTDV = new JButton("Làm mới");
		btnLamMoi_CTDV.setActionCommand("new");
		btnLamMoi_CTDV.addActionListener(ctl);
		btnLamMoi_CTDV.setBounds(334, 483, 89, 23);
		panel_1.add(btnLamMoi_CTDV);

		btnLast_CTDV = new JButton(">|");
		btnLast_CTDV.setActionCommand("last");
		btnLast_CTDV.addActionListener(ctl);
		btnLast_CTDV.setBounds(334, 517, 89, 23);
		panel_1.add(btnLast_CTDV);

		btnNext_CTDV = new JButton(">>");
		btnNext_CTDV.setActionCommand("next");
		btnNext_CTDV.addActionListener(ctl);
		btnNext_CTDV.setBounds(246, 517, 89, 23);
		panel_1.add(btnNext_CTDV);

		this.tblChiTietDichVu.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.tblChiTietDichVu.getTableHeader().setOpaque(false);
		this.tblChiTietDichVu.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblChiTietDichVu.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblChiTietDichVu.setRowHeight(25);

		cboMaPhong = new JComboBox();
		cboMaPhong.setBounds(82, 6, 146, 22);
		panel_1.add(cboMaPhong);

		cboMaDichVu = new JComboBox();
		cboMaDichVu.setBounds(82, 35, 146, 22);
		panel_1.add(cboMaDichVu);

		this.tblDichVu.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.tblDichVu.getTableHeader().setOpaque(false);
		this.tblDichVu.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblDichVu.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblDichVu.setRowHeight(25);

		if(Auth.isLogin()) {
			txtMaNhanVien.setText(Auth.user.getMaNhanVien());
		}
		loadDataTableCTDichVu();
		loadDataTableDichVu();
		loadComboboxMaPhong();
		loadComboboxMaDichVu();
		upStatus();
		upStatusCTDV();
	}

	public void resetFormDichVu() {
		txtMaDichVu.setText("");
		txtMaNhanVien.setText(Auth.user.getMaNhanVien());
		txtTenDichVu.setText("");
		txtGiaDichVu.setText("");
		txtGhiChu.setText("");
		txtMaDichVu.requestFocus();
		tblDichVu.getSelectionModel().clearSelection();
		count_DV = -1;
		upStatus();
	}

	public void insertTableDichVu() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaDichVu, sb, "Mã dịch vụ null");
		DataValidator.validateIsID(txtMaNhanVien, sb, "Mã nhân viên null");
		DataValidator.validateIsHoTen(txtTenDichVu, sb, "Tên dịch vụ null");
		DataValidator.validateEmpty(txtGiaDichVu, sb, "Giá dịch vụ null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maDichVu = txtMaDichVu.getText();
		String maNhanVien = Auth.user.getMaNhanVien();
		String tenDichVu = txtTenDichVu.getText();
		double giaDichVu = Double.valueOf(txtGiaDichVu.getText());
		String ghiChu = txtGhiChu.getText();

		DichVuModel dv = new DichVuModel(maDichVu, maNhanVien, tenDichVu, giaDichVu, ghiChu);
		if (DichVuDao.getInstance().selectByID(dv) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (DichVuDao.getInstance().update(dv) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}
		} else {
			if (DichVuDao.getInstance().insert(dv) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
		}
		loadDataTableDichVu();
		loadComboboxMaDichVu();
	}

	public void loadDataTableDichVu() {
		DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
		ArrayList<DichVuModel> list = DichVuDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (DichVuModel dichVuModel : list) {
			loadTableDichVu(dichVuModel);
		}
	}

	public void loadTableDichVu(DichVuModel dv) {
		DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
		model_table.addRow(new Object[] { dv.getMaDichVu(), dv.getMaNhanVien(), dv.getTenDichVu(), dv.getGiaDichVu(),
				dv.getGhiChu() });
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
		boolean edit = this.count_DV >= 0;
		boolean first = this.count_DV == 0;
		boolean last = this.count_DV == model_table.getRowCount() - 1;

		txtMaDichVu.setEditable(!edit);
		btnThem.setEnabled(!edit);
		btnSua.setEnabled(edit);
		btnXoa.setEnabled(edit);

		btnFirst.setEnabled(edit && !first);
		btnPre.setEnabled(edit && !first);
		btnNext.setEnabled(edit && !last);
		btnLast.setEnabled(edit && !last);
	}

	public void firstElement() {
		count_DV = 0;
		tblDichVu.setRowSelectionInterval(count_DV, count_DV);
		upStatus();
		displayFormCapNhat();
	}

	public void previousElement() {
		count_DV--;
		if (count_DV < 0) {
			count_DV = 0;
		}
		tblDichVu.setRowSelectionInterval(count_DV, count_DV);
		upStatus();
		displayFormCapNhat();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblDichVu.getSelectedRow();
		count_DV = i_row;
		count_DV++;
		if (count_DV > tblDichVu.getRowCount() - 1) {
			count_DV = tblDichVu.getRowCount() - 1;
		}
		tblDichVu.setRowSelectionInterval(count_DV, count_DV);
		upStatus();
		displayFormCapNhat();
	}

	public void displayFormCapNhat() {
		DichVuModel d = getValuesDichVu();
		txtMaDichVu.setText(d.getMaDichVu());
		txtMaNhanVien.setText(d.getMaNhanVien());
		txtTenDichVu.setText(d.getTenDichVu());
		txtGiaDichVu.setText(d.getGiaDichVu() + "");
		txtGhiChu.setText(d.getGhiChu());
		int i_row = tblDichVu.getSelectedRow();
		count_DV = i_row;
		upStatus();
	}

	public DichVuModel getValuesDichVu() {
		DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
		int i_row = tblDichVu.getSelectedRow();
		String maDichVu = model_table.getValueAt(i_row, 0) + "";
		DichVuModel d = DichVuDao.getInstance().selectByID(new DichVuModel(maDichVu));
		return d;
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
		count_DV = model_table.getRowCount() - 1;
		tblDichVu.setRowSelectionInterval(count_DV, count_DV);
		upStatus();
		displayFormCapNhat();
	}

	// Form Chi tiết dịch vụ

	public void upStatusCTDV() {
		DefaultTableModel model_table = (DefaultTableModel) tblChiTietDichVu.getModel();
		boolean edit = this.count_CTDV >= 0;
		boolean first = this.count_CTDV == 0;
		boolean last = this.count_CTDV == model_table.getRowCount() - 1;

		btnThem_CTDV.setEnabled(!edit);
		btnSua_CTDV.setEnabled(edit);
		btnXoa_CTDV.setEnabled(edit);

		btnFirst_CTDV.setEnabled(edit && !first);
		btnPre_CTDV.setEnabled(edit && !first);
		btnNext_CTDV.setEnabled(edit && !last);
		btnLast_CTDV.setEnabled(edit && !last);
	}

	public void firstElementCTDV() {
		count_CTDV = 0;
		tblChiTietDichVu.setRowSelectionInterval(count_CTDV, count_CTDV);
		upStatusCTDV();
		displayFormCapNhatCTDV();
	}

	public void previousElementCTDV() {
		count_CTDV--;
		if (count_CTDV < 0) {
			count_CTDV = 0;
		}
		tblChiTietDichVu.setRowSelectionInterval(count_CTDV, count_CTDV);
		upStatus();
		displayFormCapNhatCTDV();
	}

	public void nextElementCTDV() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblChiTietDichVu.getSelectedRow();
		count_CTDV = i_row;
		count_CTDV++;
		if (count_CTDV > tblChiTietDichVu.getRowCount() - 1) {
			count_CTDV = tblChiTietDichVu.getRowCount() - 1;
		}
		tblChiTietDichVu.setRowSelectionInterval(count_CTDV, count_CTDV);
		upStatusCTDV();
		displayFormCapNhatCTDV();
	}

	public void lastElementCTDV() {
		DefaultTableModel model_table = (DefaultTableModel) tblChiTietDichVu.getModel();
		count_CTDV = model_table.getRowCount() - 1;
		tblChiTietDichVu.setRowSelectionInterval(count_CTDV, count_CTDV);
		upStatusCTDV();
		displayFormCapNhatCTDV();
	}

	public void displayFormCapNhatCTDV() {
		ChiTietDichVuModel c = getValuesCTDV();
		cboMaPhong.setSelectedItem(c.getMaPhong());
		cboMaDichVu.setSelectedItem(c.getMaDichVu());
		txtGhiChu_CTDV.setText(c.getGhiChu());
		int i_row = tblChiTietDichVu.getSelectedRow();
		count_CTDV = i_row;
		upStatusCTDV();
	}

	public ChiTietDichVuModel getValuesCTDV() {
		DefaultTableModel model_table = (DefaultTableModel) tblChiTietDichVu.getModel();
		int i_row = tblChiTietDichVu.getSelectedRow();
		String maDichVu = model_table.getValueAt(i_row, 1) + "";
		ChiTietDichVuModel c = new ChiTietDichVuModel();
		c.setMaDichVu(maDichVu);
		ChiTietDichVuModel ct = ChiTietDichVuDao.getInstance().selectByMaDichVu(c);
		return ct;
	}

	public void insertTableCTDichVu() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateCombobox(cboMaPhong, sb, "Chưa chọn mã phòng");
		DataValidator.validateCombobox(cboMaDichVu, sb, "Chưa chọn mã dịch vụ");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maDichVu = cboMaDichVu.getSelectedItem() + "";
		String maPhong = cboMaPhong.getSelectedItem() + "";
		String ghiChu = txtGhiChu_CTDV.getText();
		ChiTietDichVuModel ct = new ChiTietDichVuModel(maPhong, maDichVu, ghiChu);
		if (ChiTietDichVuDao.getInstance().selectByID(ct) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (ChiTietDichVuDao.getInstance().update(ct) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}
		} else {
			if (ChiTietDichVuDao.getInstance().insert(ct) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
		}
		loadDataTableCTDichVu();
	}

	public void loadDataTableCTDichVu() {
		DefaultTableModel model_table = (DefaultTableModel) tblChiTietDichVu.getModel();
		ArrayList<ChiTietDichVuModel> list = ChiTietDichVuDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (ChiTietDichVuModel chiTietDichVuModel : list) {
			loadTableCTDichVu(chiTietDichVuModel);
		}
	}

	public void loadTableCTDichVu(ChiTietDichVuModel ctdv) {
		DefaultTableModel model_table = (DefaultTableModel) tblChiTietDichVu.getModel();
		model_table.addRow(new Object[] { ctdv.getMaPhong(), ctdv.getMaDichVu(), ctdv.getGhiChu() });
	}

	public void loadComboboxMaPhong() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
		cboMaPhong.addItem("");
		for (PhongModel phongModel : list) {
			cboMaPhong.addItem(phongModel.getMaPhong());
		}
	}

	public void loadComboboxMaDichVu() {
		ArrayList<DichVuModel> list = DichVuDao.getInstance().selectAll();
		cboMaDichVu.addItem("");
		for (DichVuModel dv : list) {
			cboMaDichVu.addItem(dv.getMaDichVu());
		}
	}

	public void resetFormCTDichVu() {
		cboMaPhong.setSelectedIndex(-1);
		cboMaDichVu.setSelectedIndex(-1);
		txtGhiChu_CTDV.setText("");
		tblChiTietDichVu.getSelectionModel().clearSelection();
		count_CTDV = -1;
		upStatusCTDV();
	}
}
