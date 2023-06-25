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
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;

import controller.Form_PhongCTL;
import dao.PhongDao;
import lib.DataValidator;
import lib.MsgBox;
import lib.XImage;
import model.PhongModel;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Form_Phong extends JPanel {
	private ThemPhongNhanh themPhongNhanh;
	private JTabbedPane tabbedPane;
	private JComboBox cboTang;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;
//	private JTable table;
	private ListPhongJPanel pnlListPhong;
	private JRadioButton rdoTatCa;
	private JRadioButton rdoPTrong;
	private JRadioButton rdoDSD;
	private JTable tblPhong;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField txtMaPhong;
	private JTextField txtTenPhong;
	private JTextField txtMaToaNha;
	private JTextField txtLoaiPhong;
	private JTextField txtTang;
	private JTextField txtTrangThai;
	private JTextField txtSoLuongNguoi;
	private JTextField txtDienTich;
	private JTextField txtGiaPhong;
	private JTable table;
	private JLabel lbl_IMG;
	private JTextArea txtGhiChu;
	private JTextArea txtMoTa;
	private byte[] arr_IMG;

	/**
	 * Create the panel.
	 */
	public Form_Phong() {
		Form_PhongCTL ctl = new Form_PhongCTL(this);
		setBorder(null);
		setBounds(0, 11, 1200, 920);
		setBackground(new Color(128, 0, 255));
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
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Mã phòng:");
		lblNewLabel_3.setForeground(new Color(0, 0, 160));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 52, 63, 14);
		panel.add(lblNewLabel_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(78, 49, 214, 20);
		panel.add(textField_4);

		JLabel lblNewLabel_3_1 = new JLabel("Tìm Kiếm Theo");
		lblNewLabel_3_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(10, 11, 243, 27);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Danh sách phòng:");
		lblNewLabel_3_2.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_2.setBounds(10, 140, 158, 14);
		panel.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Tầng:");
		lblNewLabel_3_3.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_3.setBounds(10, 81, 63, 14);
		panel.add(lblNewLabel_3_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 77, 214, 22);
		panel.add(comboBox);

		JLabel lblNewLabel_3_4 = new JLabel("Trạng thái:");
		lblNewLabel_3_4.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_4.setBounds(10, 106, 63, 14);
		panel.add(lblNewLabel_3_4);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tất cả");
		rdbtnNewRadioButton.setBounds(78, 102, 57, 23);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnTrng = new JRadioButton("Trống");
		rdbtnTrng.setBounds(137, 102, 57, 23);
		panel.add(rdbtnTrng);

		JRadioButton rdbtnangSDng = new JRadioButton("Đang sử dụng");
		rdbtnangSDng.setBounds(196, 102, 96, 23);
		panel.add(rdbtnangSDng);

		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setForeground(new Color(0, 0, 160));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(305, 48, 89, 72);
		panel.add(btnNewButton);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Form_Phong.class.getResource("/icon/BackgroundFormPhong1.png")));
		lblNewLabel_4.setBounds(403, 11, 322, 143);
		panel.add(lblNewLabel_4);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phòng", "Tên phòng", "Mã tòa nhà", "Loại phòng", "Tầng", "Số L.Người", "Diện tích",
						"Giá phòng", "Mô tả", "Hình ảnh", "Trạng thái", "Ghi chú" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 165, 715, 387);
		panel.add(scrollPane);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
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

		txtMaToaNha = new JTextField();
		txtMaToaNha.setColumns(10);
		txtMaToaNha.setBounds(406, 87, 319, 20);
		panel_1.add(txtMaToaNha);

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

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(10, 490, 61, 23);
		panel_1.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(81, 490, 61, 23);
		panel_1.add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(152, 490, 61, 23);
		panel_1.add(btnXoa);

		JButton btnMoi = new JButton("Mới");
		btnMoi.setBounds(223, 490, 61, 23);
		panel_1.add(btnMoi);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 469, 715, 2);
		panel_1.add(separator_1);

		JButton btnFirst = new JButton("|<");
		btnFirst.setBounds(451, 490, 61, 23);
		panel_1.add(btnFirst);

		JButton btnPre = new JButton("<<");
		btnPre.setBounds(522, 490, 61, 23);
		panel_1.add(btnPre);

		JButton btnNext = new JButton(">>");
		btnNext.setBounds(593, 490, 61, 23);
		panel_1.add(btnNext);

		JButton btnLast = new JButton(">|");
		btnLast.setBounds(664, 490, 61, 23);
		panel_1.add(btnLast);

		JPanel pnlRight = new JPanel();
		pnlRight.setBackground(new Color(64, 128, 128));
		pnlRight.setBounds(756, 26, 333, 550);
		pnlMain.add(pnlRight);
		pnlRight.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tìm Kiếm Phòng");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 200, 32);
		pnlRight.add(lblNewLabel);

		cboTang = new JComboBox();
		cboTang.setActionCommand("CBO_Tang");
		cboTang.addActionListener(ctl);
		cboTang.setBounds(10, 89, 200, 22);
		pnlRight.add(cboTang);

		JComboBox cboSoNguoi = new JComboBox();
		cboSoNguoi.setBounds(10, 129, 200, 22);
		pnlRight.add(cboSoNguoi);

		rdoTatCa = new JRadioButton("Tất cả");
		rdoTatCa.addActionListener(ctl);
		rdoTatCa.setBackground(new Color(64, 128, 128));
		rdoTatCa.setBounds(10, 193, 66, 23);
		pnlRight.add(rdoTatCa);

		rdoPTrong = new JRadioButton("Trống");
		rdoPTrong.addActionListener(ctl);
		rdoPTrong.setBackground(new Color(64, 128, 128));
		rdoPTrong.setBounds(76, 193, 55, 23);
		pnlRight.add(rdoPTrong);

		rdoDSD = new JRadioButton("Sử dụng");
		rdoDSD.addActionListener(ctl);
		rdoDSD.setBackground(new Color(64, 128, 128));
		rdoDSD.setBounds(133, 193, 109, 23);
		pnlRight.add(rdoDSD);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoTatCa);
		buttonGroup.add(rdoPTrong);
		buttonGroup.add(rdoDSD);

		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 54, 153, 24);
		pnlRight.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Trạng thái phòng:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(10, 162, 153, 24);
		pnlRight.add(lblNewLabel_1_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 232, 313, 10);
		pnlRight.add(separator);

		JLabel lblThmPhng = new JLabel("Thông Tin Nhà Trọ");
		lblThmPhng.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmPhng.setForeground(Color.WHITE);
		lblThmPhng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThmPhng.setBounds(10, 241, 200, 32);
		pnlRight.add(lblThmPhng);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tên Nhà Trọ:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(10, 269, 77, 24);
		pnlRight.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_2.setBounds(10, 318, 66, 24);
		pnlRight.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Số lượng phòng:");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_3.setBounds(10, 363, 109, 24);
		pnlRight.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_4 = new JLabel("Hình ành:");
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_4.setBounds(10, 411, 77, 24);
		pnlRight.add(lblNewLabel_1_1_4);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 298, 200, 20);
		pnlRight.add(textField_2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 345, 200, 20);
		pnlRight.add(textField);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 390, 200, 20);
		pnlRight.add(textField_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 435, 200, 107);
		pnlRight.add(lblNewLabel_2);

		displayPhongAll();
		displayThemPCTN();
		loadComboboxTang();
	}

	public void loadComboboxTang() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectTangCBO();
		cboTang.addItem("Tầng");
		for (PhongModel phongModel : list) {
			cboTang.addItem(phongModel.getTang());
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

	public void displayPhongAll() {
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

	public void insertTableThemPhongCTiet() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtMaPhong, sb, "Mã phòng null");
		DataValidator.validateEmpty(txtTenPhong, sb, "Tên phòng null");
		DataValidator.validateEmpty(txtMaToaNha, sb, "Mã tòa nhà null");
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
		String maToaNha = txtMaToaNha.getText();
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
		if (PhongDao.getInstance().insert(p) > 0) {
			MsgBox.showMessageDialog(this, "Insert success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Insert fail", "Notification");
		}
	}
}
