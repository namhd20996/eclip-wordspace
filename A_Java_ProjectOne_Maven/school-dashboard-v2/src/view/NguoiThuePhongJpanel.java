package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.NguoiThuePhongCTL;
import dao.NguoiThuePhongDao;
import dao.PhongDao;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import lib.XImage;
import model.NguoiThuePhongModel;
import model.PhieuChiModel;
import model.PhongModel;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.JobAttributes;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;

public class NguoiThuePhongJpanel extends JPanel {
	private JTextField txtSoCCCD;
	private JTextField txtMaNhanVien;
	private JTextField txtNgayBatDauThue;
	private JTextField txtNgayHetHanThue;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txtMaNguoiThue;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtTienCoc;
	private JTextField txtPhuong;
	private JTextField txtQuan;
	private JTextField txtNoiSinh;
	private JTextField txtHoKhauThuongTru;
	private JTextField txtNgayCapCC;
	private JTextField txtTinh;
	private JTextField txtNoiCap;
	private JTable table;
	private JRadioButton rdoNam;
	private JTextArea txtGhiChu;
	private JRadioButton rdoNu;
	private ButtonGroup buttonGroup;
	private JComboBox cboMaPhongThue;
	private byte[] arr_NT;
	private byte[] arr_MT;
	private byte[] arr_MS;
	private int count = 0;
	private JButton btnFirst;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnLamMoi;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private JLabel lbl_IMG_HinhNguoiThue;
	private JLabel lbl_IMG_MatTruocCC;
	private JLabel lbl_IMG_MatSauCC;
	private JTabbedPane tabbedPane;
	private JTextField txtTongSoNT;
	private JTextField txtFindName;

	/**
	 * Create the panel.
	 */
	public NguoiThuePhongJpanel() {
		NguoiThuePhongCTL ctl = new NguoiThuePhongCTL(this);
		setBounds(100, 100, 1047, 600);
		setBackground(new Color(227, 227, 227));
		setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 5, 962, 584);
		add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 0, 0));
		panel.setBackground(new Color(227, 227, 227));
		tabbedPane.addTab("Người thuê", null, panel, null);
		panel.setLayout(null);

		txtSoCCCD = new JTextField();
		txtSoCCCD.setColumns(10);
		txtSoCCCD.setBounds(437, 3, 203, 20);
		panel.add(txtSoCCCD);

		JLabel lblNewLabel = new JLabel("Số CMND/CCCD(*):");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(330, 3, 101, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã phòng thuê:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(10, 34, 107, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên(*):");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(10, 59, 88, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Hình mặt trước CC:");
		lblNewLabel_3.setBounds(650, 155, 107, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Hình mặt sau CC:");
		lblNewLabel_4.setBounds(650, 313, 96, 14);
		panel.add(lblNewLabel_4);

		cboMaPhongThue = new JComboBox();
		cboMaPhongThue.setEnabled(false);
		cboMaPhongThue.setBounds(127, 30, 197, 22);
		panel.add(cboMaPhongThue);

		JLabel lblNewLabel_8_5 = new JLabel("Số điện thoại(*):");
		lblNewLabel_8_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_8_5.setBounds(330, 31, 101, 14);
		panel.add(lblNewLabel_8_5);

		JLabel lblNewLabel_8_6 = new JLabel("Email:");
		lblNewLabel_8_6.setBounds(330, 56, 78, 14);
		panel.add(lblNewLabel_8_6);

		JLabel lblNewLabel_8_6_3 = new JLabel("Ngày bắt đầu thuê:");
		lblNewLabel_8_6_3.setBounds(10, 265, 120, 14);
		panel.add(lblNewLabel_8_6_3);

		JLabel lblNewLabel_8_6_4 = new JLabel("Ngày hết hạn thuê:");
		lblNewLabel_8_6_4.setBounds(324, 265, 134, 14);
		panel.add(lblNewLabel_8_6_4);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(127, 56, 197, 20);
		panel.add(txtMaNhanVien);

		lbl_IMG_MatTruocCC = new JLabel("New label");
		lbl_IMG_MatTruocCC.setName("lbl_IMG_MatTruoc");
		lbl_IMG_MatTruocCC.addMouseListener(ctl);
		lbl_IMG_MatTruocCC.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_IMG_MatTruocCC.setBounds(752, 155, 194, 147);
		panel.add(lbl_IMG_MatTruocCC);

		lbl_IMG_MatSauCC = new JLabel("New label");
		lbl_IMG_MatSauCC.setName("lbl_IMG_MatSau");
		lbl_IMG_MatSauCC.addMouseListener(ctl);
		lbl_IMG_MatSauCC.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_IMG_MatSauCC.setBounds(753, 313, 193, 147);
		panel.add(lbl_IMG_MatSauCC);

		txtNgayBatDauThue = new JTextField();
		txtNgayBatDauThue.setEnabled(false);
		txtNgayBatDauThue.setColumns(10);
		txtNgayBatDauThue.setBounds(127, 262, 194, 20);
		panel.add(txtNgayBatDauThue);

		txtNgayHetHanThue = new JTextField();
		txtNgayHetHanThue.setEnabled(false);
		txtNgayHetHanThue.setColumns(10);
		txtNgayHetHanThue.setBounds(437, 262, 203, 20);
		panel.add(txtNgayHetHanThue);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(438, 28, 202, 20);
		panel.add(txtSDT);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(439, 53, 201, 20);
		panel.add(txtEmail);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(227, 227, 227));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 486, 947, 59);
		panel.add(panel_1);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(0, 32, 89, 23);
		panel_1.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(89, 32, 89, 23);
		panel_1.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(177, 32, 89, 23);
		panel_1.add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(264, 32, 89, 23);
		panel_1.add(btnLamMoi);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(856, 32, 89, 23);
		panel_1.add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(769, 32, 89, 23);
		panel_1.add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(681, 32, 89, 23);
		panel_1.add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(592, 32, 89, 23);
		panel_1.add(btnFirst);

		JLabel lblMH = new JLabel("Mã người thuê(*):");
		lblMH.setForeground(new Color(255, 0, 0));
		lblMH.setBounds(10, 6, 88, 14);
		panel.add(lblMH);

		txtMaNguoiThue = new JTextField();
		txtMaNguoiThue.setColumns(10);
		txtMaNguoiThue.setBounds(127, 3, 197, 20);
		panel.add(txtMaNguoiThue);

		JLabel lblNewLabel_3_1 = new JLabel("Hình người thuê:");
		lblNewLabel_3_1.setBounds(650, 3, 107, 14);
		panel.add(lblNewLabel_3_1);

		lbl_IMG_HinhNguoiThue = new JLabel("New label");
		lbl_IMG_HinhNguoiThue.setName("lbl_IMG_NguoiThue");
		lbl_IMG_HinhNguoiThue.addMouseListener(ctl);
		lbl_IMG_HinhNguoiThue.setBorder(new LineBorder(new Color(0, 0, 0)));
		lbl_IMG_HinhNguoiThue.setBounds(752, 3, 194, 144);
		panel.add(lbl_IMG_HinhNguoiThue);

		JLabel lblNewLabel_5 = new JLabel("Họ tên(*):");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setBounds(10, 84, 78, 14);
		panel.add(lblNewLabel_5);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(127, 81, 197, 20);
		panel.add(txtHoTen);

		JLabel lblNewLabel_6 = new JLabel("Ngày sinh(*):");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setBounds(330, 87, 78, 14);
		panel.add(lblNewLabel_6);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(439, 81, 201, 20);
		panel.add(txtNgaySinh);

		JLabel lblNewLabel_8 = new JLabel("Giới tính(*):");
		lblNewLabel_8.setForeground(new Color(255, 0, 0));
		lblNewLabel_8.setBounds(10, 118, 78, 14);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_8_6_5 = new JLabel("Tiền cọc(*):");
		lblNewLabel_8_6_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_8_6_5.setBounds(330, 118, 78, 14);
		panel.add(lblNewLabel_8_6_5);

		JLabel lblNewLabel_8_1 = new JLabel("Phường/Xã:");
		lblNewLabel_8_1.setBounds(10, 149, 77, 14);
		panel.add(lblNewLabel_8_1);

		txtTienCoc = new JTextField();
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(439, 112, 201, 20);
		panel.add(txtTienCoc);

		txtPhuong = new JTextField();
		txtPhuong.setColumns(10);
		txtPhuong.setBounds(127, 143, 197, 20);
		panel.add(txtPhuong);

		txtQuan = new JTextField();
		txtQuan.setColumns(10);
		txtQuan.setBounds(127, 174, 197, 20);
		panel.add(txtQuan);

		txtNoiSinh = new JTextField();
		txtNoiSinh.setColumns(10);
		txtNoiSinh.setBounds(439, 143, 201, 20);
		panel.add(txtNoiSinh);

		JLabel lblNewLabel_8_2 = new JLabel("Quận/Huyện:");
		lblNewLabel_8_2.setBounds(10, 174, 77, 14);
		panel.add(lblNewLabel_8_2);

		JLabel lblNewLabel_7 = new JLabel("Nơi sinh:");
		lblNewLabel_7.setBounds(330, 149, 77, 14);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8_4 = new JLabel("Hộ khẩu thường trú:");
		lblNewLabel_8_4.setBounds(10, 235, 120, 14);
		panel.add(lblNewLabel_8_4);

		txtHoKhauThuongTru = new JTextField();
		txtHoKhauThuongTru.setColumns(10);
		txtHoKhauThuongTru.setBounds(127, 232, 513, 20);
		panel.add(txtHoKhauThuongTru);

		txtNgayCapCC = new JTextField();
		txtNgayCapCC.setColumns(10);
		txtNgayCapCC.setBounds(439, 174, 201, 20);
		panel.add(txtNgayCapCC);

		JLabel lblNewLabel_8_6_1 = new JLabel("Ngày cấp CC:");
		lblNewLabel_8_6_1.setBounds(330, 177, 78, 14);
		panel.add(lblNewLabel_8_6_1);

		JLabel lblNewLabel_8_6_2 = new JLabel("Nơi cấp:");
		lblNewLabel_8_6_2.setBounds(330, 207, 78, 14);
		panel.add(lblNewLabel_8_6_2);

		JLabel lblNewLabel_8_3 = new JLabel("Tỉnh/TP:");
		lblNewLabel_8_3.setBounds(10, 210, 77, 14);
		panel.add(lblNewLabel_8_3);

		txtTinh = new JTextField();
		txtTinh.setColumns(10);
		txtTinh.setBounds(127, 204, 197, 20);
		panel.add(txtTinh);

		txtNoiCap = new JTextField();
		txtNoiCap.setColumns(10);
		txtNoiCap.setBounds(438, 205, 202, 20);
		panel.add(txtNoiCap);

		JLabel lblNewLabel_8_6_5_1 = new JLabel("Ghi chú:");
		lblNewLabel_8_6_5_1.setBounds(10, 298, 630, 14);
		panel.add(lblNewLabel_8_6_5_1);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(108, 293, 532, 167);
		panel.add(txtGhiChu);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(127, 108, 64, 23);
		panel.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(200, 108, 64, 23);
		panel.add(rdoNu);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 481, 936, 4);
		panel.add(separator);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Danh sách", null, panel_2, null);
		panel_2.setLayout(null);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã người thuê", "Số CCCD", "Mã phòng", "Mã nhân viên", "Tên NT", "Ngày sinh",
						"Nơi sinh", "Giới tính", "Phường/xã", "Quận/huyện", "Tỉnh/tp", "Nơi ĐKHK", "Số ĐT", "Email",
						"Ngày Cấp CC", "Nơi cấp", "Ngày thuê", "Ngày trả", "Tiền cọc", "Ghi chú" }));
		table.setName("tblNguoiThuePhong");
		table.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 191, 937, 354);
		panel_2.add(scrollPane);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 8));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);
		
		JLabel lbl_IMG = new JLabel("New label");
		lbl_IMG.setIcon(new ImageIcon(NguoiThuePhongJpanel.class.getResource("/IMG_JPG/BGNguoiThue.png")));
		lbl_IMG.setBounds(478, 11, 469, 169);
		panel_2.add(lbl_IMG);
		
		txtTongSoNT = new JTextField();
		txtTongSoNT.setEnabled(false);
		txtTongSoNT.setBounds(144, 11, 324, 20);
		panel_2.add(txtTongSoNT);
		txtTongSoNT.setColumns(10);
		
		JLabel lblTongSoNT = new JLabel("Tổng số người thuê:");
		lblTongSoNT.setBounds(10, 14, 124, 14);
		panel_2.add(lblTongSoNT);
		
		JLabel lblTmTheoM = new JLabel("Tìm theo tên người thuê:");
		lblTmTheoM.setBounds(10, 163, 124, 14);
		panel_2.add(lblTmTheoM);
		
		txtFindName = new JTextField();
		txtFindName.addKeyListener(ctl);
		txtFindName.setColumns(10);
		txtFindName.setBounds(144, 160, 324, 20);
		panel_2.add(txtFindName);
		
		JLabel lbl_Left_IMG = new JLabel("New label");
		lbl_Left_IMG.setIcon(new ImageIcon(NguoiThuePhongJpanel.class.getResource("/IMG_JPG/BGLeftNguoiThue.png")));
		lbl_Left_IMG.setBounds(10, 37, 458, 115);
		panel_2.add(lbl_Left_IMG);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/icon/Noel.jpg"));
		Image img = XImage.resize(icon.getImage(), 193, 147);
		lbl_IMG_MatSauCC.setIcon(new ImageIcon(img));
		
		lbl_IMG_MatTruocCC.setIcon(new ImageIcon(img));
		lbl_IMG_HinhNguoiThue.setIcon(new ImageIcon(img));
		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setText(Auth.user.getMaNhanVien());
		
		upStatus();
		loadDataTable();
		loadCombobox();
	}

	public void resetForm() {
		cboMaPhongThue.setSelectedIndex(-1);
		txtEmail.setText("");
		txtHoKhauThuongTru.setText("");
		txtHoTen.setText("");
		txtMaNguoiThue.setText("");
		txtMaNhanVien.setText(Auth.user.getMaNhanVien());
//		txtMaNhanVien.setText("");
		txtNgayBatDauThue.setText("");
		txtNgayCapCC.setText("");
		txtNgayHetHanThue.setText("");
		txtNgaySinh.setText("");
		txtNoiCap.setText("");
		txtNoiSinh.setText("");
		txtPhuong.setText("");
		txtQuan.setText("");
		txtSDT.setText("");
		txtSoCCCD.setText("");
		txtTienCoc.setText("");
		txtTinh.setText("");
		buttonGroup.clearSelection();
		txtGhiChu.setText("");
		txtMaNguoiThue.requestFocus();
		table.getSelectionModel().clearSelection();
		count = -1;
		upStatus();
	}

	public void insertTableNguoiThue() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaNguoiThue, sb, "Mã người thuê null");
		DataValidator.validateSoCCCD(txtSoCCCD, sb, "Số CCCD null");
//		DataValidator.validateCombobox(cboMaPhongThue, sb, "Chưa chọn mã phòng");
		DataValidator.validateIsID(txtMaNhanVien, sb, "Mã nhân viên null");
		DataValidator.validateIsHoTen(txtHoTen, sb, "Họ tên null");
		DataValidator.validateDateNow(txtNgaySinh, sb, "Ngày sinh null");
		DataValidator.validateChecked(buttonGroup, sb, "Chưa chọn giới tính");
		DataValidator.validateIsSDT(txtSDT, sb, "Số điện thoại null");
//		DataValidator.validateDateNow(txtNgayBatDauThue, sb, "Ngày bắt đầu thuê null");
//		DataValidator.validateDateNow(txtNgayHetHanThue, sb, "Ngày hết hạn thuê null");
//		DataValidator.validateDay(txtNgayBatDauThue, txtNgayHetHanThue, sb, "");
		DataValidator.validateEmpty(txtTienCoc, sb, "Tiền cọc null");
		if (sb.length() > 0) {
			MsgBox.showMessageDialog(this, sb.toString(), "Notification");
			return;
		}
		String maNguoiThue = txtMaNguoiThue.getText();
		String soCCCDNT = txtSoCCCD.getText();
		String maPhong = (String) cboMaPhongThue.getSelectedItem();
		String maNhanVien = txtMaNhanVien.getText();
		byte[] hinhNT = arr_NT;
		byte[] matTruocCC = arr_MT;
		byte[] matSauCC = arr_MS;
		String tenNguoiThue = txtHoTen.getText();
		Date ngaySinh = XDate.dateFormat(txtNgaySinh.getText());
		String noiSinh = txtNoiSinh.getText();
		String gioiTinh = "";
		if (rdoNam.isSelected()) {
			gioiTinh = "Nam";
		} else if (rdoNu.isSelected()) {
			gioiTinh = "Nữ";
		}
		String phuong = txtPhuong.getText();
		String quan = txtQuan.getText();
		String tinh = txtTinh.getText();
		String noiDangKyHK = txtHoKhauThuongTru.getText();
		String soDienThoai = txtSDT.getText();
		String email = txtEmail.getText();
		Date ngayCap = XDate.dateFormat(txtNgayCapCC.getText());
		String noiCap = txtNoiCap.getText();
		Date ngayBatDauThue = XDate.dateFormat(txtNgayBatDauThue.getText());
		Date ngayHetHanThue = XDate.dateFormat(txtNgayHetHanThue.getText());
		double tienCoc = Double.valueOf(txtTienCoc.getText());
		String ghiChu = txtGhiChu.getText();

		NguoiThuePhongModel nt = new NguoiThuePhongModel(maNguoiThue, soCCCDNT, maPhong, maNhanVien, hinhNT, matTruocCC,
				matSauCC, tenNguoiThue, ngaySinh, noiSinh, gioiTinh, phuong, quan, tinh, noiDangKyHK, soDienThoai,
				email, ngayCap, noiCap, ngayBatDauThue, ngayHetHanThue, tienCoc, ghiChu);
		if (NguoiThuePhongDao.getInstance().selectByID(nt) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật?", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (NguoiThuePhongDao.getInstance().update(nt) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}
		} else {
			if (NguoiThuePhongDao.getInstance().insert(nt) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
		}
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txtMaNguoiThue.setEditable(!edit);
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
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count > table.getRowCount() - 1) {
			count = table.getRowCount() - 1;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void displayFormCapNhat() {
		try {
			NguoiThuePhongModel p = getValuesForm();

			txtMaNguoiThue.setText(p.getMaNguoiThue());
			txtSoCCCD.setText(p.getSoCCCDNT());
			cboMaPhongThue.setSelectedItem(p.getMaPhong());
			txtMaNhanVien.setText(p.getMaNhanVien());

			if (p.getHinhNT() != null) {
				Image img = XImage.createImageFromByteArray(p.getHinhNT(), "jpg");
				this.lbl_IMG_HinhNguoiThue.setIcon(new ImageIcon(img));
				this.arr_NT = p.getHinhNT();
			} else {
				arr_NT = p.getHinhNT();
				ImageIcon icon = new ImageIcon(getClass().getResource("/icon/Noel.jpg"));
				Image img = XImage.resize(icon.getImage(), 193, 147);
				lbl_IMG_HinhNguoiThue.setIcon(new ImageIcon(img));
			}

			if (p.getMatTruocCC() != null) {
				Image img = XImage.createImageFromByteArray(p.getMatTruocCC(), "jpg");
				this.lbl_IMG_MatTruocCC.setIcon(new ImageIcon(img));
				this.arr_MT = p.getMatTruocCC();
			} else {
				arr_MT = p.getMatTruocCC();
				ImageIcon icon = new ImageIcon(getClass().getResource("/icon/Noel.jpg"));
				Image img = XImage.resize(icon.getImage(), 193, 147);
				lbl_IMG_MatTruocCC.setIcon(new ImageIcon(img));
			}

			if (p.getMatSauCC() != null) {
				Image img = XImage.createImageFromByteArray(p.getMatSauCC(), "jpg");
				this.lbl_IMG_MatSauCC.setIcon(new ImageIcon(img));
				this.arr_MS = p.getMatSauCC();
			} else {
				arr_MS = p.getMatSauCC();
				ImageIcon icon = new ImageIcon(getClass().getResource("/icon/Noel.jpg"));
				Image img = XImage.resize(icon.getImage(), 193, 147);
				lbl_IMG_MatSauCC.setIcon(new ImageIcon(img));
			}

			txtHoTen.setText(p.getHoTen());
			if (p.getNgaySinh() != null) {
				txtNgaySinh.setText(XDate.dateString(p.getNgaySinh()));
			} else {
				txtNgaySinh.setText("Null");
			}
//			txtNgaySinh.setText(XDate.dateString(p.getNgaySinh()));
			txtNoiSinh.setText(p.getNoiSinh());
			if (p.getGioiTinh().equals("Nam")) {
				rdoNam.setSelected(true);
			} else {
				rdoNu.setSelected(true);
			}

			txtPhuong.setText(p.getPhuong_Xa());
			txtQuan.setText(p.getQuan_Huyen());
			txtTinh.setText(p.getTinh_TP());
			txtHoKhauThuongTru.setText(p.getNoiDangKyHK());
			txtSDT.setText(p.getSoDienThoai());
			txtEmail.setText(p.getEmail());
			if (p.getNgayCapCC() != null) {
				txtNgayCapCC.setText(XDate.dateString(p.getNgayCapCC()));
			} else {
				txtNgayCapCC.setText("");
			}
			txtNoiCap.setText(p.getNoiCap());
			if (p.getNgayBatDauThue() != null) {
				txtNgayBatDauThue.setText(XDate.dateString(p.getNgayBatDauThue()));
			} else {
				txtNgayBatDauThue.setText("");
			}
			if (p.getNgayHetHanThue() != null) {
				txtNgayHetHanThue.setText(XDate.dateString(p.getNgayHetHanThue()));
			} else {
				txtNgayHetHanThue.setText("");
			}
			txtTienCoc.setText(p.getTienCoc() + "");
			txtGhiChu.setText(p.getGhiChu());

			int i_row = table.getSelectedRow();
			count = i_row;
			upStatus();
			tabbedPane.setSelectedIndex(0);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public NguoiThuePhongModel getValuesForm() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maNguoiThue = model_table.getValueAt(i_row, 0) + "";
		NguoiThuePhongModel p = NguoiThuePhongDao.getInstance().selectByID(new NguoiThuePhongModel(maNguoiThue));
		return p;
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		count = model_table.getRowCount() - 1;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		ArrayList<NguoiThuePhongModel> list = NguoiThuePhongDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (NguoiThuePhongModel nguoiThuePhongModel : list) {
			System.out.println(nguoiThuePhongModel.getMaPhong());
			loadTableNT(nguoiThuePhongModel);
		}
	}

	public void loadTableNT(NguoiThuePhongModel nt) {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(new Object[] { nt.getMaNguoiThue(), nt.getSoCCCDNT(), nt.getMaPhong(),
					nt.getMaNhanVien(), nt.getHoTen(), nt.getNgaySinh(), nt.getNoiSinh(), nt.getGioiTinh(),
					nt.getPhuong_Xa(), nt.getQuan_Huyen(), nt.getTinh_TP(), nt.getNoiDangKyHK(), nt.getSoDienThoai(),
					nt.getEmail(), nt.getNgayCapCC() != null ? XDate.dateString(nt.getNgayCapCC()) : "Null",
					nt.getNoiCap(), nt.getNgayBatDauThue() != null ? XDate.dateString(nt.getNgayBatDauThue()) : "Null",
					nt.getNgayHetHanThue() != null ? XDate.dateString(nt.getNgayHetHanThue()) : "Null", nt.getTienCoc(),
					nt.getGhiChu() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadCombobox() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
		cboMaPhongThue.addItem("");
		for (PhongModel phongModel : list) {
			cboMaPhongThue.addItem(phongModel.getMaPhong());
		}
	}

	public void displayImage() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Image File (*.jpg)";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".jpg");
				}
			}
		});
		if (fc.showOpenDialog(this) == JFileChooser.CANCEL_OPTION) {
			return;
		}
		File file = fc.getSelectedFile();
		try {
			ImageIcon icon = new ImageIcon(file.getPath());
			Image img = XImage.resize(icon.getImage(), 193, 147);
			ImageIcon resize = new ImageIcon(img);
			this.lbl_IMG_HinhNguoiThue.setIcon(resize);
			this.arr_NT = XImage.toByteArray(img, "jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void displayImageMatTruoc() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Image File (*.jpg)";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".jpg");
				}
			}
		});
		if (fc.showOpenDialog(this) == JFileChooser.CANCEL_OPTION) {
			return;
		}
		File file = fc.getSelectedFile();
		try {
			ImageIcon icon = new ImageIcon(file.getPath());
			Image img = XImage.resize(icon.getImage(), 193, 147);
			ImageIcon resize = new ImageIcon(img);
			this.lbl_IMG_MatTruocCC.setIcon(resize);
			this.arr_MT = XImage.toByteArray(img, "jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void displayImageMatSau() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Image File (*.jpg)";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".jpg");
				}
			}
		});
		if (fc.showOpenDialog(this) == JFileChooser.CANCEL_OPTION) {
			return;
		}
		File file = fc.getSelectedFile();
		try {
			ImageIcon icon = new ImageIcon(file.getPath());
			Image img = XImage.resize(icon.getImage(), 193, 147);
			ImageIcon resize = new ImageIcon(img);
			this.lbl_IMG_MatSauCC.setIcon(resize);
			this.arr_MS = XImage.toByteArray(img, "jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void findByName() {
		String hoTen = txtFindName.getText();
		NguoiThuePhongModel nt = new NguoiThuePhongModel();
		nt.setHoTen(hoTen);
		
	}
}
