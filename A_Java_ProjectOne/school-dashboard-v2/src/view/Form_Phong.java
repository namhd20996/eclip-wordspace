package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.ComponentOrientation;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

import controller.Form_PhongCTL;
import dao.LichSuPhongThueDao;
import dao.PhieuChiDao;
import dao.PhongDao;
import dao.ToaNhaDao;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import lib.XImage;
import model.LichSuPhongThueModel;
import model.PhieuChiModel;
import model.PhongModel;
import model.ToaNhaModel;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Form_Phong extends JPanel {
	private ThemPhongNhanh themPhongNhanh;
	private JTabbedPane tabbedPane;
	private JComboBox cboTang;
	private JTextField txtTenNhaTro;
	private JTextField txtDiaChiNhaTro;
	private JTextField txtSoLuongPhong;
	private ListPhongJPanel pnlListPhong;
	private JRadioButton rdoTatCa;
	private JRadioButton rdoPTrong;
	private JRadioButton rdoDSD;
	private JTextField txtFind_MaPhong;
	private JTextField txtMaPhong;
	private JTextField txtTenPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtTang;
	private JTextField txtTrangThai;
	private JTextField txtSoLuongNguoi;
	private JTextField txtDienTich;
	private JTextField txtGiaPhong;
	private JTable tblDanhSachPhong;
	private JLabel lbl_IMG;
	private JTextArea txtGhiChu;
	private JTextArea txtMoTa;
	private byte[] arr_IMG;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnMoi;
	private int count = 0;
	private int count_LSNT = 0;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPre;
	private JButton btnFirst;
	private JComboBox cboFind_Tang;
	private JRadioButton rdoTatCa_DSP;
	private JRadioButton rdoTrong_DSP;
	private JRadioButton rdoDangSuDung_DSP;
	private JTextField txtMaNguoiThue_LSNT;
	private JTextField txtNgayTra_LSNT;
	private JTextField txtNgayThue_LSNT;
	private JTextField txtSoCCCD_LSNT;
	private JTable tblLichSuNguoiThue;
	private JComboBox cboMaPhong_LSNT;
	private JButton btnLast_LSNT;
	private JButton btnNext_LSNT;
	private JButton btnPre_LSNT;

	private JButton btnMoi_LSNT;
	private JButton btnXoa_LSNT;
	private JButton btnSua_LSNT;
	private JButton btnThem_LSNT;
	private JButton btnFirst_LSNT;
	private JComboBox cboMaToaNha;
	private JComboBox cboMaToaNha_Find;
	private JLabel lbl_IMGNT;
	private ButtonGroup buttonGroup_N;

	/**
	 * Create the panel.
	 */
	public Form_Phong() {
		Form_PhongCTL ctl = new Form_PhongCTL(this);
		setBorder(null);
		setBounds(0, 11, 1200, 920);
		setBackground(new Color(227, 227, 227));
//		setBackground(new Color(128, 0, 255));
		setOpaque(false);
		setLayout(null);

		JPanel pnlMain = new JPanel();
		pnlMain.setBorder(null);
		pnlMain.setBackground(new Color(255, 255, 255));
		pnlMain.setBounds(0, 11, 1200, 769);
		add(pnlMain);
		pnlMain.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, 0, 740, 769);
		pnlMain.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(227, 227, 227));
		tabbedPane.addTab("Danh sách phòng", null, panel, null);
		panel.setLayout(null);

		JLabel lblMaPhongFind = new JLabel("Mã phòng:");
		lblMaPhongFind.setForeground(new Color(0, 0, 160));
		lblMaPhongFind.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaPhongFind.setBounds(10, 52, 63, 14);
		panel.add(lblMaPhongFind);

		txtFind_MaPhong = new JTextField();
		txtFind_MaPhong.addKeyListener(ctl);
		txtFind_MaPhong.setColumns(10);
		txtFind_MaPhong.setBounds(78, 49, 214, 20);
		panel.add(txtFind_MaPhong);

		JLabel lblTimKiem = new JLabel("Tìm Kiếm Theo");
		lblTimKiem.setForeground(new Color(0, 0, 160));
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimKiem.setBounds(10, 11, 243, 27);
		panel.add(lblTimKiem);

		JLabel lblDanhSachDSP = new JLabel("Danh sách phòng:");
		lblDanhSachDSP.setForeground(new Color(0, 0, 160));
		lblDanhSachDSP.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDanhSachDSP.setBounds(10, 140, 158, 14);
		panel.add(lblDanhSachDSP);

		JLabel lblTangDS = new JLabel("Tầng:");
		lblTangDS.setForeground(new Color(0, 0, 160));
		lblTangDS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTangDS.setBounds(10, 81, 63, 14);
		panel.add(lblTangDS);

		cboFind_Tang = new JComboBox();
		cboFind_Tang.setActionCommand("cbo_TangFind");
		cboFind_Tang.addActionListener(ctl);
		cboFind_Tang.setBounds(78, 77, 214, 22);
		panel.add(cboFind_Tang);

		JLabel lblTrangThaiDS = new JLabel("Trạng thái:");
		lblTrangThaiDS.setForeground(new Color(0, 0, 160));
		lblTrangThaiDS.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrangThaiDS.setBounds(10, 106, 63, 14);
		panel.add(lblTrangThaiDS);

		rdoTatCa_DSP = new JRadioButton("Tất cả");
		rdoTatCa_DSP.setActionCommand("All");
		rdoTatCa_DSP.addActionListener(ctl);
		rdoTatCa_DSP.setBounds(78, 102, 57, 23);
		panel.add(rdoTatCa_DSP);

		rdoTrong_DSP = new JRadioButton("Trống");
		rdoTrong_DSP.setActionCommand("Null");
		rdoTrong_DSP.addActionListener(ctl);
		rdoTrong_DSP.setBounds(137, 102, 57, 23);
		panel.add(rdoTrong_DSP);

		rdoDangSuDung_DSP = new JRadioButton("Đang sử dụng");
		rdoDangSuDung_DSP.setActionCommand("Not null");
		rdoDangSuDung_DSP.addActionListener(ctl);
		rdoDangSuDung_DSP.setBounds(196, 102, 96, 23);
		panel.add(rdoDangSuDung_DSP);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoTatCa_DSP);
		buttonGroup.add(rdoTrong_DSP);
		buttonGroup.add(rdoDangSuDung_DSP);

		JButton btnFind = new JButton("Tìm");
		btnFind.setForeground(new Color(0, 0, 160));
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnFind.setBounds(305, 48, 89, 72);
		panel.add(btnFind);

		JLabel lbl_IMGDS = new JLabel("New label");
		lbl_IMGDS.setIcon(new ImageIcon(Form_Phong.class.getResource("/icon/BackgroundFormPhong1.png")));
		lbl_IMGDS.setBounds(403, 11, 322, 143);
		panel.add(lbl_IMGDS);

		tblDanhSachPhong = new JTable();
		tblDanhSachPhong.setShowVerticalLines(false);
		tblDanhSachPhong.setSelectionBackground(new Color(255, 128, 0));
		tblDanhSachPhong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phòng", "Tên phòng", "Mã tòa nhà", "Loại phòng", "Tầng", "Số L.Người", "Diện tích",
						"Giá phòng", "Mô tả", "Hình ảnh", "Trạng thái", "Ghi chú" }));
		tblDanhSachPhong.setName("tbl_DanhSachPhong");
		tblDanhSachPhong.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(tblDanhSachPhong);
		scrollPane.setBounds(10, 165, 715, 387);
		panel.add(scrollPane);

		this.tblDanhSachPhong.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.tblDanhSachPhong.getTableHeader().setOpaque(false);
		this.tblDanhSachPhong.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblDanhSachPhong.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblDanhSachPhong.setRowHeight(25);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Thêm phòng chi tiết", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblMaPhong = new JLabel("Mã phòng:");
		lblMaPhong.setForeground(new Color(0, 0, 128));
		lblMaPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaPhong.setBounds(335, 11, 75, 27);
		panel_1.add(lblMaPhong);

		JLabel lblTenPhong = new JLabel("Tên phòng:");
		lblTenPhong.setForeground(new Color(0, 0, 128));
		lblTenPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenPhong.setBounds(335, 49, 75, 27);
		panel_1.add(lblTenPhong);

		JLabel lblMaToaNha = new JLabel("Mã tòa nhà:");
		lblMaToaNha.setForeground(new Color(0, 0, 128));
		lblMaToaNha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaToaNha.setBounds(335, 87, 75, 27);
		panel_1.add(lblMaToaNha);

		JLabel lblLoaiPhong = new JLabel("Loại phòng:");
		lblLoaiPhong.setForeground(new Color(0, 0, 128));
		lblLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoaiPhong.setBounds(335, 125, 75, 27);
		panel_1.add(lblLoaiPhong);

		JLabel lblTang = new JLabel("Tầng:");
		lblTang.setForeground(new Color(0, 0, 128));
		lblTang.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTang.setBounds(335, 163, 75, 27);
		panel_1.add(lblTang);

		JLabel txtSoLNguoi = new JLabel("Số l.người:");
		txtSoLNguoi.setForeground(new Color(0, 0, 128));
		txtSoLNguoi.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSoLNguoi.setBounds(335, 199, 113, 27);
		panel_1.add(txtSoLNguoi);

		JLabel lblDienTich = new JLabel("Diện tích:");
		lblDienTich.setForeground(new Color(0, 0, 128));
		lblDienTich.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDienTich.setBounds(10, 199, 75, 27);
		panel_1.add(lblDienTich);

		JLabel lblGiaPhong = new JLabel("Giá phòng:");
		lblGiaPhong.setForeground(new Color(0, 0, 128));
		lblGiaPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGiaPhong.setBounds(10, 237, 75, 27);
		panel_1.add(lblGiaPhong);

		JLabel lblMoTa = new JLabel("Mô tả:");
		lblMoTa.setForeground(new Color(0, 0, 128));
		lblMoTa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMoTa.setBounds(10, 275, 75, 27);
		panel_1.add(lblMoTa);

		JLabel lblHinhAnh = new JLabel("Hình ảnh:");
		lblHinhAnh.setForeground(new Color(0, 0, 128));
		lblHinhAnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHinhAnh.setBounds(10, 11, 75, 27);
		panel_1.add(lblHinhAnh);

		JLabel lblTrangThai = new JLabel("Trạng thái:");
		lblTrangThai.setForeground(new Color(0, 0, 128));
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrangThai.setBounds(335, 237, 75, 27);
		panel_1.add(lblTrangThai);

		JLabel lblGhiChu = new JLabel("Ghi chú:");
		lblGhiChu.setForeground(new Color(0, 0, 128));
		lblGhiChu.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGhiChu.setBounds(335, 275, 75, 27);
		panel_1.add(lblGhiChu);

		txtMaPhong = new JTextField();
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(406, 14, 319, 20);
		panel_1.add(txtMaPhong);

		txtTenPhong = new JTextField();
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(406, 49, 319, 20);
		panel_1.add(txtTenPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(406, 125, 319, 20);
		panel_1.add(txtLoaiPhong);

		txtTang = new JTextField();
		txtTang.setColumns(10);
		txtTang.setBounds(406, 166, 319, 20);
		panel_1.add(txtTang);

		txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(406, 240, 319, 20);
		panel_1.add(txtTrangThai);

		txtSoLuongNguoi = new JTextField();
		txtSoLuongNguoi.setColumns(10);
		txtSoLuongNguoi.setBounds(406, 202, 319, 20);
		panel_1.add(txtSoLuongNguoi);

		txtDienTich = new JTextField();
		txtDienTich.setColumns(10);
		txtDienTich.setBounds(68, 201, 257, 20);
		panel_1.add(txtDienTich);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(68, 240, 257, 20);
		panel_1.add(txtGiaPhong);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(68, 275, 257, 151);
		panel_1.add(txtMoTa);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(406, 276, 319, 151);
		panel_1.add(txtGhiChu);

		lbl_IMG = new JLabel("New label");
		lbl_IMG.setName("lbl_IMG");
		lbl_IMG.addMouseListener(ctl);
		lbl_IMG.setBounds(10, 39, 315, 151);
		panel_1.add(lbl_IMG);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(10, 490, 61, 23);
		panel_1.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(81, 490, 61, 23);
		panel_1.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(152, 490, 61, 23);
		panel_1.add(btnXoa);

		btnMoi = new JButton("Mới");
		btnMoi.addActionListener(ctl);
		btnMoi.setBounds(223, 490, 61, 23);
		panel_1.add(btnMoi);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 469, 715, 2);
		panel_1.add(separator_1);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(451, 490, 61, 23);
		panel_1.add(btnFirst);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(522, 490, 61, 23);
		panel_1.add(btnPre);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(593, 490, 61, 23);
		panel_1.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(664, 490, 61, 23);
		panel_1.add(btnLast);

		JPanel pnlRight = new JPanel();
		pnlRight.setBackground(new Color(64, 128, 128));
		pnlRight.setBounds(756, 26, 333, 550);
		pnlMain.add(pnlRight);
		pnlRight.setLayout(null);

		JLabel lblTitleTK = new JLabel("Tìm Kiếm Phòng");
		lblTitleTK.setForeground(new Color(255, 255, 255));
		lblTitleTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTK.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitleTK.setBounds(10, 11, 200, 32);
		pnlRight.add(lblTitleTK);

		cboTang = new JComboBox();
//		cboTang.setActionCommand("CBO_Tang");
//		cboTang.addActionListener(ctl);
		cboTang.setBounds(10, 77, 200, 22);
		pnlRight.add(cboTang);

		cboMaToaNha_Find = new JComboBox();
//		cboMaToaNha_Find.setActionCommand("cboMaToaNha_Find");
//		cboMaToaNha_Find.addActionListener(ctl);
//		cboMaToaNha_Find.setName("cboMaToaNha_Find");

		cboMaToaNha_Find.setBounds(10, 110, 200, 22);
		pnlRight.add(cboMaToaNha_Find);

		rdoTatCa = new JRadioButton("Tất cả");
//		rdoTatCa.addActionListener(ctl);
		rdoTatCa.setBackground(new Color(64, 128, 128));
		rdoTatCa.setBounds(10, 170, 66, 23);
		pnlRight.add(rdoTatCa);

		rdoPTrong = new JRadioButton("Trống");
//		rdoPTrong.addActionListener(ctl);
		rdoPTrong.setBackground(new Color(64, 128, 128));
		rdoPTrong.setBounds(76, 170, 55, 23);
		pnlRight.add(rdoPTrong);

		rdoDSD = new JRadioButton("Sử dụng");
//		rdoDSD.addActionListener(ctl);
		rdoDSD.setBackground(new Color(64, 128, 128));
		rdoDSD.setBounds(133, 170, 109, 23);
		pnlRight.add(rdoDSD);

		buttonGroup_N = new ButtonGroup();
		buttonGroup_N.add(rdoTatCa);
		buttonGroup_N.add(rdoPTrong);
		buttonGroup_N.add(rdoDSD);

		JLabel lblTimKiemtheo = new JLabel("Tìm kiếm theo:");
		lblTimKiemtheo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTimKiemtheo.setForeground(new Color(255, 255, 255));
		lblTimKiemtheo.setBounds(10, 54, 153, 24);
		pnlRight.add(lblTimKiemtheo);

		JLabel lblTrangThaiPhong = new JLabel("Trạng thái phòng:");
		lblTrangThaiPhong.setForeground(Color.WHITE);
		lblTrangThaiPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTrangThaiPhong.setBounds(10, 139, 153, 24);
		pnlRight.add(lblTrangThaiPhong);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 232, 313, 10);
		pnlRight.add(separator);

		JLabel lblTitleTTNT = new JLabel("Thông Tin Nhà Trọ");
		lblTitleTTNT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleTTNT.setForeground(Color.WHITE);
		lblTitleTTNT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitleTTNT.setBounds(10, 241, 200, 32);
		pnlRight.add(lblTitleTTNT);

		JLabel lblTenNT = new JLabel("Tên Nhà Trọ:");
		lblTenNT.setForeground(Color.WHITE);
		lblTenNT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTenNT.setBounds(10, 269, 77, 24);
		pnlRight.add(lblTenNT);

		JLabel lblDiaChiNT = new JLabel("Địa chỉ:");
		lblDiaChiNT.setForeground(Color.WHITE);
		lblDiaChiNT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDiaChiNT.setBounds(10, 318, 66, 24);
		pnlRight.add(lblDiaChiNT);

		JLabel lblSoLuongPhong = new JLabel("Số lượng phòng:");
		lblSoLuongPhong.setForeground(Color.WHITE);
		lblSoLuongPhong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSoLuongPhong.setBounds(10, 363, 109, 24);
		pnlRight.add(lblSoLuongPhong);

		JLabel lblHinhAnhNT = new JLabel("Hình ảnh:");
		lblHinhAnhNT.setForeground(Color.WHITE);
		lblHinhAnhNT.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHinhAnhNT.setBounds(10, 411, 77, 24);
		pnlRight.add(lblHinhAnhNT);

		txtTenNhaTro = new JTextField();
		txtTenNhaTro.setColumns(10);
		txtTenNhaTro.setBounds(10, 298, 200, 20);
		pnlRight.add(txtTenNhaTro);

		txtDiaChiNhaTro = new JTextField();
		txtDiaChiNhaTro.setColumns(10);
		txtDiaChiNhaTro.setBounds(10, 345, 200, 20);
		pnlRight.add(txtDiaChiNhaTro);

		txtSoLuongPhong = new JTextField();
		txtSoLuongPhong.setColumns(10);
		txtSoLuongPhong.setBounds(10, 390, 200, 20);
		pnlRight.add(txtSoLuongPhong);

		lbl_IMGNT = new JLabel("New label");
		lbl_IMGNT.setBounds(10, 435, 200, 107);
		pnlRight.add(lbl_IMGNT);

		ImageIcon icon = new ImageIcon(getClass().getResource("/icon/BackgroundFormPhong1.png"));
		Image img = XImage.resize(icon.getImage(), 315, 151);
		lbl_IMG.setIcon(new ImageIcon(img));

		cboMaToaNha = new JComboBox();
		cboMaToaNha.setBounds(406, 89, 319, 22);
		panel_1.add(cboMaToaNha);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Lịch sử người thuê", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã người thuê:");
		lblNewLabel.setBounds(10, 11, 98, 14);
		panel_2.add(lblNewLabel);

		JLabel lblMPhng = new JLabel("Mã phòng:");
		lblMPhng.setBounds(180, 11, 98, 14);
		panel_2.add(lblMPhng);

		JLabel lblSCccd = new JLabel("Số CCCD:");
		lblSCccd.setBounds(10, 121, 98, 14);
		panel_2.add(lblSCccd);

		JLabel lblNgyTr = new JLabel("Ngày trả:");
		lblNgyTr.setBounds(180, 64, 98, 14);
		panel_2.add(lblNgyTr);

		JLabel lblNgyThu = new JLabel("Ngày thuê:");
		lblNgyThu.setBounds(10, 64, 98, 14);
		panel_2.add(lblNgyThu);

		txtMaNguoiThue_LSNT = new JTextField();
		txtMaNguoiThue_LSNT.setBounds(10, 33, 160, 20);
		panel_2.add(txtMaNguoiThue_LSNT);
		txtMaNguoiThue_LSNT.setColumns(10);

		txtNgayTra_LSNT = new JTextField();
		txtNgayTra_LSNT.setColumns(10);
		txtNgayTra_LSNT.setBounds(180, 90, 161, 20);
		panel_2.add(txtNgayTra_LSNT);

		txtNgayThue_LSNT = new JTextField();
		txtNgayThue_LSNT.setColumns(10);
		txtNgayThue_LSNT.setBounds(10, 90, 160, 20);
		panel_2.add(txtNgayThue_LSNT);

		txtSoCCCD_LSNT = new JTextField();
		txtSoCCCD_LSNT.setColumns(10);
		txtSoCCCD_LSNT.setBounds(10, 146, 160, 20);
		panel_2.add(txtSoCCCD_LSNT);

		cboMaPhong_LSNT = new JComboBox();
		cboMaPhong_LSNT.setBounds(180, 33, 161, 20);
		panel_2.add(cboMaPhong_LSNT);

		JLabel lblDanhSch = new JLabel("Danh sách:");
		lblDanhSch.setBounds(10, 177, 98, 14);
		panel_2.add(lblDanhSch);

		tblLichSuNguoiThue = new JTable();
		tblLichSuNguoiThue.setShowVerticalLines(false);
		tblLichSuNguoiThue.setSelectionBackground(new Color(255, 128, 0));
		tblLichSuNguoiThue.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã người thuê", "Mã phòng", "Số CCCD", "Ngày thuê", "Ngày trả" }));
		tblLichSuNguoiThue.setName("tbl_LSNT");
		tblLichSuNguoiThue.addMouseListener(ctl);

		JScrollPane scrollPane_1 = new JScrollPane(tblLichSuNguoiThue);
		scrollPane_1.setBounds(10, 202, 715, 297);
		panel_2.add(scrollPane_1);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Form_Phong.class.getResource("/icon/BackgroundLichSuPhongThue.png")));
		lblNewLabel_1.setBounds(363, 11, 362, 180);
		panel_2.add(lblNewLabel_1);

		btnThem_LSNT = new JButton("Thêm");
		btnThem_LSNT.setActionCommand("add");
		btnThem_LSNT.addActionListener(ctl);
		btnThem_LSNT.setBounds(10, 515, 61, 23);
		panel_2.add(btnThem_LSNT);

		btnSua_LSNT = new JButton("Sửa");
		btnSua_LSNT.setActionCommand("update");
		btnSua_LSNT.addActionListener(ctl);
		btnSua_LSNT.setBounds(69, 515, 61, 23);
		panel_2.add(btnSua_LSNT);

		btnXoa_LSNT = new JButton("Xóa");
		btnXoa_LSNT.setActionCommand("delete");
		btnXoa_LSNT.addActionListener(ctl);
		btnXoa_LSNT.setBounds(128, 515, 61, 23);
		panel_2.add(btnXoa_LSNT);

		btnMoi_LSNT = new JButton("Làm mới");
		btnMoi_LSNT.setActionCommand("new");
		btnMoi_LSNT.addActionListener(ctl);
		btnMoi_LSNT.setBounds(185, 515, 75, 23);
		panel_2.add(btnMoi_LSNT);

		btnFirst_LSNT = new JButton("|<");
		btnFirst_LSNT.setActionCommand("first");
		btnFirst_LSNT.addActionListener(ctl);
		btnFirst_LSNT.setBounds(473, 515, 67, 23);
		panel_2.add(btnFirst_LSNT);

		btnPre_LSNT = new JButton("<<");
		btnPre_LSNT.setActionCommand("pre");
		btnPre_LSNT.addActionListener(ctl);
		btnPre_LSNT.setBounds(538, 515, 67, 23);
		panel_2.add(btnPre_LSNT);

		btnNext_LSNT = new JButton(">>");
		btnNext_LSNT.setActionCommand("next");
		btnNext_LSNT.addActionListener(ctl);
		btnNext_LSNT.setBounds(600, 515, 61, 23);
		panel_2.add(btnNext_LSNT);

		btnLast_LSNT = new JButton(">|");
		btnLast_LSNT.setActionCommand("last");
		btnLast_LSNT.addActionListener(ctl);
		btnLast_LSNT.setBounds(658, 515, 67, 23);
		panel_2.add(btnLast_LSNT);

		this.tblLichSuNguoiThue.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.tblLichSuNguoiThue.getTableHeader().setOpaque(false);
		this.tblLichSuNguoiThue.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblLichSuNguoiThue.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblLichSuNguoiThue.setRowHeight(25);

		ImageIcon icon_NT = new ImageIcon(getClass().getResource("/icon/BGPhieuChi.png"));
		Image img_NT = XImage.resize(icon_NT.getImage(), 200, 107);
		lbl_IMGNT.setIcon(new ImageIcon(img_NT));

		JButton btnTim = new JButton("Tìm");
		btnTim.setActionCommand("timListPhong");
		btnTim.addActionListener(ctl);
		btnTim.setBounds(10, 200, 200, 23);
		pnlRight.add(btnTim);

		displayPhongAll();
		displayThemPCTN();
		loadComboboxTang();
		loadDataTablePhong();
		upStatus();
		findMaPhong();
		loadDataTableLSNT();
		loadComboboxMaToaNha();
		// Form Lịch sử người thuê
		upStatusLSNT();
		loadComboboxLSNT();
	}

	public void displayInformationToaNha() {
		try {
			String maToaNha = cboMaToaNha_Find.getSelectedItem() + "";
			ToaNhaModel t = ToaNhaDao.getInstance().selectByID(new ToaNhaModel(maToaNha));
			txtTenNhaTro.setText(t.getTenToaNha());
			txtDiaChiNhaTro.setText(t.getPhuong() + ", " + t.getQuan() + ", " + t.getTinh());
			txtSoLuongPhong.setText(t.getSoPhong() + "");
			if (t.getHinhAnh() != null) {
				Image img = XImage.createImageFromByteArray(t.getHinhAnh(), "jpg");
				Image icon = XImage.resize(img, 200, 107);
				this.lbl_IMGNT.setIcon(new ImageIcon(icon));
			} else {
				ImageIcon icon = new ImageIcon(getClass().getResource("/icon/BGPhieuChi.png"));
				Image img = XImage.resize(icon.getImage(), 200, 107);
				lbl_IMGNT.setIcon(new ImageIcon(img));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void loadComboboxTang() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectTangCBO();
		cboTang.addItem("Tầng");
		cboFind_Tang.addItem("Tầng");
		for (PhongModel phongModel : list) {
			cboTang.addItem(phongModel.getTang());
			cboFind_Tang.addItem(phongModel.getTang());

		}
	}

	public void loadTableTang() {
		try {
			System.out.println("CBO1111");
			DefaultTableModel model_table = (DefaultTableModel) tblDanhSachPhong.getModel();
			int tang = Integer.valueOf(cboFind_Tang.getSelectedItem() + "");
			ArrayList<PhongModel> list = PhongDao.getInstance().selectByTang(new PhongModel(tang));
			model_table.setRowCount(0);
			for (PhongModel phongModel : list) {
				loadTablePhong(phongModel);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}

	}

	public void loadTablePhongTrangThai() {
		DefaultTableModel model_table = (DefaultTableModel) tblDanhSachPhong.getModel();
		model_table.setRowCount(0);
		String trangThai = "";
		if (rdoTrong_DSP.isSelected()) {
			trangThai = "trangThai is null";
		} else if (rdoDangSuDung_DSP.isSelected()) {
			trangThai = "trangThai = N'Đang thuê'";
		} else if (rdoTatCa_DSP.isSelected()) {
			ArrayList<PhongModel> listP = PhongDao.getInstance().selectAll();
			for (PhongModel phongModel : listP) {
				loadTablePhong(phongModel);
			}
		}
		ArrayList<PhongModel> list = PhongDao.getInstance().selectByCondition(trangThai);
		for (PhongModel phongModel : list) {
			loadTablePhong(phongModel);
		}
	}

	public void displayListPhong() {
		try {
			int floor = Integer.valueOf(cboTang.getSelectedItem() + "");
//			tabbedPane.removeAll();
			tabbedPane.remove(pnlListPhong);
			pnlListPhong = new ListPhongJPanel();
			pnlListPhong.loadIMG(floor);
			pnlListPhong.setBounds(0, 0, 1200, 600);
			pnlListPhong.setForeground(new Color(255, 255, 255));
			pnlListPhong.setBorder(null);
			pnlListPhong.setAutoscrolls(true);
//			tabbedPane.addTab("Quản lý phòng", pnlListPhong);
			tabbedPane.add(pnlListPhong, "Quản lý phòng", 0);
			tabbedPane.setSelectedComponent(pnlListPhong);
//			tabbedPane.setSelectedIndex(floor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void displayListPhongTrangThai() {
		try {
			String trangThai = "";
			if (rdoPTrong.isSelected()) {
				trangThai = "trangThai is null";
			} else if (rdoDSD.isSelected()) {
				trangThai = "trangThai = N'Đang thuê'";
			}
			tabbedPane.remove(pnlListPhong);
			pnlListPhong = new ListPhongJPanel();
			pnlListPhong.loadIMG(trangThai);
			pnlListPhong.setBounds(0, 0, 1200, 600);
			pnlListPhong.setForeground(new Color(255, 255, 255));
			pnlListPhong.setBorder(null);
			pnlListPhong.setAutoscrolls(true);
//			tabbedPane.addTab("Quản lý phòng", pnlListPhong);
			tabbedPane.add(pnlListPhong, "Quản lý phòng", 0);
			tabbedPane.setSelectedComponent(pnlListPhong);
//			tabbedPane.setSelectedIndex(floor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void displayListPhongFindAll() {
		try {
			String result = "";
			String resultAll = "";

			String trangThai = "";

			String tangStr = cboTang.getSelectedItem() + "";
			String maToaNhaStr = cboMaToaNha_Find.getSelectedItem() + "";
			int tang = 0;
			String maToaNha = "";

			if (!tangStr.equals("Tầng")) {
				tang = Integer.valueOf(cboTang.getSelectedItem() + "");
				result += "tang='" + tang + "'";
			}

			if (!maToaNhaStr.equals("Mã tòa nhà")) {
				maToaNha = cboMaToaNha_Find.getSelectedItem() + "";
				result += "maToaNha='" + maToaNha + "'";
			}

			if (rdoPTrong.isSelected()) {
				trangThai = "trangThai is null";
			} else if (rdoDSD.isSelected()) {
				trangThai = "trangThai = N'Đang thuê'";
			}

			resultAll = "tang='" + tang + "' and" + " maToaNha='" + maToaNha + "' and " + trangThai;
			if (tangStr.equals("Tầng")) {
				resultAll = "maToaNha='" + maToaNha + "' and " + trangThai;
			}

			if (maToaNhaStr.equals("Mã tòa nhà")) {
//				resultAll = trangThai; 
				resultAll = "tang='" + tang + "' and" + trangThai;
			}

			if (trangThai.equals("")) {
				resultAll = "tang='" + tang + "' and" + " maToaNha='" + maToaNha + "'";
			}

			if (tangStr.equals("Tầng") && maToaNhaStr.equals("Mã tòa nhà") && trangThai.equals("")) {
				displayPhongAll();
				return;
			}

			System.out.println(resultAll);
			tabbedPane.remove(pnlListPhong);
			pnlListPhong = new ListPhongJPanel();
			pnlListPhong.loadIMG(resultAll);
			pnlListPhong.setBounds(0, 0, 1200, 600);
			pnlListPhong.setForeground(new Color(255, 255, 255));
			pnlListPhong.setBorder(null);
			pnlListPhong.setAutoscrolls(true);
//			tabbedPane.addTab("Quản lý phòng", pnlListPhong);
			tabbedPane.add(pnlListPhong, "Quản lý phòng", 0);
			tabbedPane.setSelectedComponent(pnlListPhong);
//			tabbedPane.setSelectedIndex(floor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void displayListPhongByMaToaNha() {
		try {
			String maToaNha = cboMaToaNha_Find.getSelectedItem() + "";
			tabbedPane.remove(pnlListPhong);
			pnlListPhong = new ListPhongJPanel();
			pnlListPhong.loadByMaToaNha("maToaNha='" + maToaNha + "'");
			pnlListPhong.setBounds(0, 0, 1200, 600);
			pnlListPhong.setForeground(new Color(255, 255, 255));
			pnlListPhong.setBorder(null);
			pnlListPhong.setAutoscrolls(true);
//			tabbedPane.addTab("Quản lý phòng", pnlListPhong);
			tabbedPane.add(pnlListPhong, "Quản lý phòng", 0);
			tabbedPane.setSelectedComponent(pnlListPhong);
//			tabbedPane.setSelectedIndex(floor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void displayPhongAll() {
		System.out.println("Đã Vào");
		tabbedPane.remove(pnlListPhong);
		pnlListPhong = new ListPhongJPanel();
		pnlListPhong.loadIMG();
		pnlListPhong.setBounds(0, 0, 1200, 600);
		pnlListPhong.setForeground(new Color(255, 255, 255));
		pnlListPhong.setBorder(null);
		pnlListPhong.setAutoscrolls(true);
		tabbedPane.add(pnlListPhong, "Quản lý phòng", 0);
		tabbedPane.setSelectedComponent(pnlListPhong);
	}

	public void displayThemPCTN() {
		if (themPhongNhanh == null) {
			themPhongNhanh = new ThemPhongNhanh();
			themPhongNhanh.setBounds(0, 0, 1200, 600);
			themPhongNhanh.setForeground(new Color(255, 255, 255));
			themPhongNhanh.setBorder(null);
			themPhongNhanh.setAutoscrolls(true);
			tabbedPane.addTab("Thêm phòng nhanh", themPhongNhanh);
		}
	}

	public void disPlayImage() {
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
			Image img = XImage.resize(icon.getImage(), 315, 151);
			ImageIcon resizeIcon = new ImageIcon(img);
			this.lbl_IMG.setIcon(resizeIcon);
			arr_IMG = XImage.toByteArray(img, "jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTablePCT() {
		PhongModel p = getValueFormPhong();
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa?", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		if (PhongDao.getInstance().delete(p) > 0) {
			MsgBox.showMessageDialog(this, "Delete success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete fail", "Notification");
		}
		loadDataTablePhong();
	}

	public void insertTableThemPhongCTiet() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtMaPhong, sb, "Mã phòng null");
		DataValidator.validateEmpty(txtTenPhong, sb, "Tên phòng null");
		DataValidator.validateCombobox(cboMaToaNha, sb, "Chưa chọn mã tòa nhà");
		DataValidator.validateEmpty(txtLoaiPhong, sb, "Loại phòng null");
		DataValidator.validateEmpty(txtTang, sb, "Tầng null");
		DataValidator.validateEmpty(txtSoLuongNguoi, sb, "Số lượng người null");
		DataValidator.validateEmpty(txtDienTich, sb, "Diện tích null");
		DataValidator.validateEmpty(txtGiaPhong, sb, "Giá phòng null");
		DataValidator.validateEmpty(txtTrangThai, sb, "Trạng thái null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maPhong = txtMaPhong.getText();
		String tenPhong = txtTenPhong.getText();
		String maToaNha = cboMaToaNha.getSelectedItem() + "";
		String loaiPhong = txtLoaiPhong.getText();
		int tang = Integer.valueOf(txtTang.getText());
		int soLuongNguoi = Integer.valueOf(txtSoLuongNguoi.getText());
		double dienTich = Double.valueOf(txtDienTich.getText());
		double giaPhong = Double.valueOf(txtGiaPhong.getText());
		String moTa = txtMoTa.getText();
		byte[] hinhAnh = arr_IMG;
		String trangThai = txtTrangThai.getText();
		String ghiChu = txtGhiChu.getText();
		PhongModel p = new PhongModel(maPhong, tenPhong, maToaNha, loaiPhong, tang, soLuongNguoi, dienTich, giaPhong,
				moTa, hinhAnh, trangThai, ghiChu);
		if (PhongDao.getInstance().selectByID(p) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật?", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (PhongDao.getInstance().update(p) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}
		} else {
			if (PhongDao.getInstance().insert(p) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
		}
	}

	public void loadTablePhong(PhongModel phongModel) {
		DefaultTableModel model_table = (DefaultTableModel) tblDanhSachPhong.getModel();

		model_table.addRow(new Object[] { phongModel.getMaPhong(), phongModel.getTenPhong(), phongModel.getMaToaNha(),
				phongModel.getLoaiPhong(), phongModel.getTang(), phongModel.getSoLuongNguoi(), phongModel.getDienTich(),
				phongModel.getGiaPhong(), phongModel.getMoTa(), phongModel.getHinhAnh(), phongModel.getTrangThai(),
				phongModel.getGhiChu() });

	}

	public void loadDataTablePhong() {
		DefaultTableModel model_table = (DefaultTableModel) tblDanhSachPhong.getModel();
		model_table.setRowCount(0);
		ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
		for (PhongModel phongModel : list) {
			loadTablePhong(phongModel);
		}
	}

	public PhongModel getValueFormPhong() {
		DefaultTableModel model_table = (DefaultTableModel) tblDanhSachPhong.getModel();
		int i_row = tblDanhSachPhong.getSelectedRow();
		String maPhong = model_table.getValueAt(i_row, 0) + "";
		PhongModel p = new PhongModel();
		p.setMaPhong(maPhong);
		PhongModel pd = PhongDao.getInstance().selectByID(p);
		return pd;
	}

	public void displayOnFormPhong() {
		try {
			PhongModel p = getValueFormPhong();
			txtMaPhong.setText(p.getMaPhong());
			txtTenPhong.setText(p.getTenPhong());
			cboMaToaNha.setSelectedItem(p.getMaToaNha());
			txtLoaiPhong.setText(p.getLoaiPhong());
			txtTang.setText(p.getTang() + "");
			txtSoLuongNguoi.setText(p.getSoLuongNguoi() + "");
			txtTrangThai.setText(p.getTrangThai());
			txtDienTich.setText(p.getDienTich() + "");
			txtGiaPhong.setText(p.getGiaPhong() + "");
			txtMoTa.setText(p.getMoTa());
			txtGhiChu.setText(p.getGhiChu());
			if (p.getHinhAnh() != null) {
				Image img = XImage.createImageFromByteArray(p.getHinhAnh(), "jpg");
				lbl_IMG.setIcon(new ImageIcon(img));
				arr_IMG = p.getHinhAnh();
			} else {
				arr_IMG = p.getHinhAnh();
				ImageIcon icon = new ImageIcon(getClass().getResource("/icon/BackgroundFormPhong1.png"));
				Image img = XImage.resize(icon.getImage(), 315, 151);
				lbl_IMG.setIcon(new ImageIcon(img));
			}
			int i_row = tblDanhSachPhong.getSelectedRow();
			count = i_row;
			upStatus();
			tabbedPane.setSelectedIndex(2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upStatus() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == tblDanhSachPhong.getRowCount() - 1;

		txtMaPhong.setEditable(!edit);
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
		tblDanhSachPhong.setRowSelectionInterval(count, count);
		upStatus();
		displayOnFormPhong();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		tblDanhSachPhong.setRowSelectionInterval(count, count);
		upStatus();
		displayOnFormPhong();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblDanhSachPhong.getSelectedRow();
		count = i_row;
		count++;
		if (count > tblDanhSachPhong.getRowCount() - 1) {
			count = tblDanhSachPhong.getRowCount() - 1;
		}
		tblDanhSachPhong.setRowSelectionInterval(count, count);
		upStatus();
		displayOnFormPhong();
	}

	public void lastElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		count = tblDanhSachPhong.getRowCount() - 1;
		tblDanhSachPhong.setRowSelectionInterval(count, count);
		upStatus();
		displayOnFormPhong();
	}

	public void resetFormPCT() {
		txtMaPhong.setText("");
		txtTenPhong.setText("");
		cboMaToaNha.setSelectedIndex(-1);
		txtLoaiPhong.setText("");
		txtTang.setText("");
		txtSoLuongNguoi.setText("");
		txtTrangThai.setText("");
		txtDienTich.setText("");
		txtGiaPhong.setText("");
		txtMoTa.setText("");
		txtGhiChu.setText("");
		ImageIcon icon = new ImageIcon(getClass().getResource("/icon/BackgroundFormPhong1.png"));
		Image img = XImage.resize(icon.getImage(), 315, 151);
		lbl_IMG.setIcon(new ImageIcon(img));
		count = -1;
		upStatus();
	}

	public void loadComboboxMaToaNha() {
		ArrayList<ToaNhaModel> list = ToaNhaDao.getInstance().selectAll();
		cboMaToaNha.addItem("Mã tòa nhà");
		cboMaToaNha_Find.addItem("Mã tòa nhà");
		for (ToaNhaModel toaNhaModel : list) {
			cboMaToaNha.addItem(toaNhaModel.getMaToaNha());
			cboMaToaNha_Find.addItem(toaNhaModel.getMaToaNha());
		}
	}

	public void findMaPhong() {
		String maPhong = txtFind_MaPhong.getText();
		DefaultTableModel model_table = (DefaultTableModel) tblDanhSachPhong.getModel();
		model_table.setRowCount(0);
		ArrayList<PhongModel> list = PhongDao.getInstance().selectByCondition("maPhong like '%" + maPhong + "%'");
		for (PhongModel phongModel : list) {
			loadTablePhong(phongModel);
		}
	}

	public void loadDataTableLSNT() {
		DefaultTableModel model_table = (DefaultTableModel) tblLichSuNguoiThue.getModel();
		ArrayList<LichSuPhongThueModel> list = LichSuPhongThueDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (LichSuPhongThueModel lichSuPhongThueModel : list) {
			model_table.addRow(new Object[] { lichSuPhongThueModel.getMaNguoiThue(), lichSuPhongThueModel.getMaPhong(),
					lichSuPhongThueModel.getSoCCCDNT(),
					lichSuPhongThueModel.getNgayThue() != null ? XDate.dateString(lichSuPhongThueModel.getNgayThue())
							: "Null",
					lichSuPhongThueModel.getNgayTraPhong() != null
							? XDate.dateString(lichSuPhongThueModel.getNgayTraPhong())
							: "Null" });
		}
	}

	// Form Lịch sử người thuê

	public void resetFormLSNT() {
		txtMaNguoiThue_LSNT.setText("");
		cboMaPhong_LSNT.setSelectedIndex(-1);
		txtSoCCCD_LSNT.setText("");
		txtNgayThue_LSNT.setText("");
		txtNgayTra_LSNT.setText("");
		txtMaNguoiThue_LSNT.requestFocus();
		tblLichSuNguoiThue.getSelectionModel().clearSelection();
		count_LSNT = -1;
		upStatusLSNT();
	}

	public void upStatusLSNT() {
		DefaultTableModel model_table = (DefaultTableModel) tblLichSuNguoiThue.getModel();
		boolean edit = this.count_LSNT >= 0;
		boolean first = this.count_LSNT == 0;
		boolean last = this.count_LSNT == model_table.getRowCount() - 1;

		txtMaNguoiThue_LSNT.setEditable(!edit);
		btnThem_LSNT.setEnabled(!edit);
		btnSua_LSNT.setEnabled(edit);
		btnXoa.setEnabled(edit);

		btnFirst_LSNT.setEnabled(edit && !first);
		btnPre_LSNT.setEnabled(edit && !first);
		btnNext_LSNT.setEnabled(edit && !last);
		btnLast_LSNT.setEnabled(edit && !last);
	}

	public void firstElementLSNT() {
		count_LSNT = 0;
		tblLichSuNguoiThue.setRowSelectionInterval(count_LSNT, count_LSNT);
		upStatusLSNT();
		displayFormCapNhatLSNT();
	}

	public void previousElementLSNT() {
		count_LSNT--;
		if (count_LSNT < 0) {
			count_LSNT = 0;
		}
		tblLichSuNguoiThue.setRowSelectionInterval(count_LSNT, count_LSNT);
		upStatusLSNT();
		displayFormCapNhatLSNT();
	}

	public void nextElementLSNT() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblLichSuNguoiThue.getSelectedRow();
		count_LSNT = i_row;
		count_LSNT++;
		if (count_LSNT > tblLichSuNguoiThue.getRowCount() - 1) {
			count_LSNT = tblLichSuNguoiThue.getRowCount() - 1;
		}
		tblLichSuNguoiThue.setRowSelectionInterval(count_LSNT, count_LSNT);
		upStatusLSNT();
		displayFormCapNhatLSNT();
	}

	public void displayFormCapNhatLSNT() {
		try {
			LichSuPhongThueModel ls = getValuesLSNT();
			txtMaNguoiThue_LSNT.setText(ls.getMaNguoiThue());
			cboMaPhong_LSNT.setSelectedItem(ls.getMaPhong());
			txtSoCCCD_LSNT.setText(ls.getSoCCCDNT());
			txtNgayThue_LSNT.setText(XDate.dateString(ls.getNgayThue()));
			txtNgayTra_LSNT.setText(XDate.dateString(ls.getNgayTraPhong()));
			int i_row = tblLichSuNguoiThue.getSelectedRow();
			count_LSNT = i_row;
			upStatusLSNT();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public LichSuPhongThueModel getValuesLSNT() {
		DefaultTableModel model_table = (DefaultTableModel) tblLichSuNguoiThue.getModel();
		int i_row = tblLichSuNguoiThue.getSelectedRow();
		String maNguoiThue = model_table.getValueAt(i_row, 0) + "";
		LichSuPhongThueModel ls = LichSuPhongThueDao.getInstance().selectByID(new LichSuPhongThueModel(maNguoiThue));
		return ls;
	}

	public void lastElementLSNT() {
		DefaultTableModel model_table = (DefaultTableModel) tblLichSuNguoiThue.getModel();
		count_LSNT = model_table.getRowCount() - 1;
		tblLichSuNguoiThue.setRowSelectionInterval(count_LSNT, count_LSNT);
		upStatusLSNT();
		displayFormCapNhatLSNT();
	}

	public void loadComboboxLSNT() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
		cboMaPhong_LSNT.addItem("");
		for (PhongModel phongModel : list) {
			cboMaPhong_LSNT.addItem(phongModel.getMaPhong());
		}
	}

	public void insertTableLSNT() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaNguoiThue_LSNT, sb, "Mã người thuê null");
		DataValidator.validateCombobox(cboMaPhong_LSNT, sb, "Chưa chọn mã phòng");
		DataValidator.validateSoCCCD(txtSoCCCD_LSNT, sb, "Số CCCD null");
		DataValidator.validateDateNow(txtNgayThue_LSNT, sb, "Ngày thuê null");
		DataValidator.validateDateNow(txtNgayTra_LSNT, sb, "Ngày trả null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maNguoiThue = txtMaNguoiThue_LSNT.getText();
		String maPhong = cboMaPhong_LSNT.getSelectedItem() + "";
		String soCCCD = txtSoCCCD_LSNT.getText();
		Date ngayThue = XDate.dateFormat(txtNgayThue_LSNT.getText());
		Date ngayTra = XDate.dateFormat(txtNgayTra_LSNT.getText());
		LichSuPhongThueModel ls = new LichSuPhongThueModel(maNguoiThue, maPhong, soCCCD, ngayThue, ngayTra);
		if (LichSuPhongThueDao.getInstance().selectByID(ls) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật?", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (LichSuPhongThueDao.getInstance().update(ls) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}
		} else {
			if (LichSuPhongThueDao.getInstance().insert(ls) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
		}
		loadDataTableLSNT();
	}

	public void deleteTableLSNT() {
		LichSuPhongThueModel ls = getValuesLSNT();
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa?", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		if (LichSuPhongThueDao.getInstance().delete(ls) > 0) {
			MsgBox.showMessageDialog(this, "Delete success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete fail", "Notification");
		}
		loadDataTableLSNT();
	}
}
