package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ThemNguoiThueCTL;
import dao.ChiTietDichVuDao;
import dao.DichVuDao;
import dao.LichSuPhongThueDao;
import dao.NguoiThuePhongDao;
import dao.PhongDao;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import model.ChiTietDichVuModel;
import model.DichVuModel;
import model.LichSuPhongThueModel;
import model.NguoiThuePhongModel;
import model.PhongModel;

public class ThemNguoiThueJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaNhanVien;
	private JTextField txtHoTen;
	private JTextField txtNgaySinh;
	private JTextField txtEmail;
	private JTextField txtDiaChi;
	private JTextField txtLoaiPhong;
	private JTextField txtTang;
	private JTextField txtGiaPhong;
	private JTextField txtTienCoc;
	private JTextField txtSDT;
	private JTextField txtNgayThue;
	private JTextField txtNgayHetHan;
	private JTextField txtCCCD;
	private JTable tblDichVu;
	private JTextField txtMaDichVu_Find;
	private JComboBox cboMaPhong;
	private JTextField txtDienTich;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private ButtonGroup buttonGroup;
	private JTextField txtFindMaPhong;
	private JTable tblChiTietDichVu;
	private JTextArea txtGhiChu;
	private JButton btnThemKhach;
	private JButton btnCapNhat;
	private JButton btnLamMoi;
	private JComboBox cboMaNguoiThue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ThemNguoiThueJDialog dialog = new ThemNguoiThueJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThemNguoiThueJDialog() {
		ThemNguoiThueCTL ctl = new ThemNguoiThueCTL(this);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/IMG_JavaIcon/VN-Vietnam-Flag-icon (1).png")));
		setBounds(100, 100, 939, 552);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel_8_6_3 = new JLabel("Ngày bắt đầu thuê:");
		lblNewLabel_8_6_3.setBounds(-682, 167, 107, 14);
		contentPanel.add(lblNewLabel_8_6_3);

		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 383, 479);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã người thuê:");
		lblNewLabel.setBounds(26, 14, 88, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã phòng thuê:");
		lblNewLabel_1.setBounds(26, 39, 88, 14);
		panel.add(lblNewLabel_1);

		cboMaPhong = new JComboBox();
		cboMaPhong.setEnabled(false);
//		cboMaPhong.setAlignmentY(CENTER_ALIGNMENT);
		cboMaPhong.setBounds(102, 35, 259, 22);
		panel.add(cboMaPhong);

		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_2.setBounds(26, 64, 88, 14);
		panel.add(lblNewLabel_2);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		txtMaNhanVien.setText("NV0");
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(102, 61, 259, 20);
		panel.add(txtMaNhanVien);

		JLabel lblNewLabel_5 = new JLabel("Họ tên:");
		lblNewLabel_5.setBounds(26, 113, 78, 14);
		panel.add(lblNewLabel_5);

		txtHoTen = new JTextField();
		txtHoTen.setHorizontalAlignment(SwingConstants.CENTER);
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(102, 113, 259, 20);
		panel.add(txtHoTen);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(102, 138, 78, 20);
		panel.add(txtNgaySinh);

		JLabel lblNewLabel_6 = new JLabel("Ngày sinh:");
		lblNewLabel_6.setBounds(26, 144, 78, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("Giới tính:");
		lblNewLabel_8.setBounds(209, 144, 78, 14);
		panel.add(lblNewLabel_8);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(262, 140, 49, 23);
		panel.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(313, 140, 48, 23);
		panel.add(rdoNu);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setColumns(10);
		txtEmail.setBounds(102, 169, 259, 20);
		panel.add(txtEmail);

		JLabel lblNewLabel_8_6 = new JLabel("Email:");
		lblNewLabel_8_6.setBounds(26, 169, 78, 14);
		panel.add(lblNewLabel_8_6);

		JLabel lblNewLabel_8_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_8_1_1.setBounds(26, 194, 77, 14);
		panel.add(lblNewLabel_8_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setText("Bàu bàng");
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(102, 191, 259, 20);
		panel.add(txtDiaChi);

		JLabel lblNewLabel_8_1_1_1 = new JLabel("Loại phòng:");
		lblNewLabel_8_1_1_1.setBounds(26, 222, 77, 14);
		panel.add(lblNewLabel_8_1_1_1);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(102, 219, 259, 20);
		panel.add(txtLoaiPhong);

		txtTang = new JTextField();
		txtTang.setColumns(10);
		txtTang.setBounds(102, 247, 78, 20);
		panel.add(txtTang);

		JLabel lblNewLabel_8_1_1_1_1 = new JLabel("Tầng:");
		lblNewLabel_8_1_1_1_1.setBounds(26, 250, 77, 14);
		panel.add(lblNewLabel_8_1_1_1_1);

		JLabel lblNewLabel_8_1_1_1_1_1 = new JLabel("Giá phòng:");
		lblNewLabel_8_1_1_1_1_1.setBounds(190, 250, 77, 14);
		panel.add(lblNewLabel_8_1_1_1_1_1);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(262, 247, 99, 20);
		panel.add(txtGiaPhong);

		txtTienCoc = new JTextField();
		txtTienCoc.setColumns(10);
		txtTienCoc.setBounds(102, 278, 78, 20);
		panel.add(txtTienCoc);

		JLabel lblNewLabel_8_6_5 = new JLabel("Tiền cọc:");
		lblNewLabel_8_6_5.setBounds(26, 281, 78, 14);
		panel.add(lblNewLabel_8_6_5);

		JLabel lblNewLabel_8_5 = new JLabel("Số điện thoại:");
		lblNewLabel_8_5.setBounds(26, 306, 78, 14);
		panel.add(lblNewLabel_8_5);

		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(102, 303, 259, 20);
		panel.add(txtSDT);

		txtNgayThue = new JTextField();
		txtNgayThue.setColumns(10);
		txtNgayThue.setBounds(102, 325, 76, 20);
		panel.add(txtNgayThue);

		JLabel lblNewLabel_8_6_4_1 = new JLabel("Ngày thuê:");
		lblNewLabel_8_6_4_1.setBounds(26, 331, 88, 14);
		panel.add(lblNewLabel_8_6_4_1);

		txtNgayHetHan = new JTextField();
		txtNgayHetHan.setColumns(10);
		txtNgayHetHan.setBounds(262, 325, 99, 20);
		panel.add(txtNgayHetHan);

		JLabel lblNewLabel_8_6_4 = new JLabel("Ngày hết hạn:");
		lblNewLabel_8_6_4.setBounds(188, 328, 88, 14);
		panel.add(lblNewLabel_8_6_4);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(102, 356, 259, 78);
		panel.add(txtGhiChu);

		JLabel lblNewLabel_8_6_5_1 = new JLabel("Ghi chú:");
		lblNewLabel_8_6_5_1.setBounds(26, 358, 48, 14);
		panel.add(lblNewLabel_8_6_5_1);

		btnThemKhach = new JButton("Thêm khách");
		btnThemKhach.addActionListener(ctl);
		btnThemKhach.setBounds(26, 445, 99, 23);
		panel.add(btnThemKhach);

		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(ctl);
		btnCapNhat.setBounds(143, 445, 103, 23);
		panel.add(btnCapNhat);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(263, 445, 99, 23);
		panel.add(btnLamMoi);

		JLabel lblNewLabel_2_1 = new JLabel("Số CCCD:");
		lblNewLabel_2_1.setBounds(26, 92, 88, 14);
		panel.add(lblNewLabel_2_1);

		txtCCCD = new JTextField();
		txtCCCD.setHorizontalAlignment(SwingConstants.CENTER);
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(102, 89, 259, 20);
		panel.add(txtCCCD);

		JLabel lblNewLabel_8_1_1_1_1_1_1 = new JLabel("Diện tích:");
		lblNewLabel_8_1_1_1_1_1_1.setBounds(190, 281, 77, 14);
		panel.add(lblNewLabel_8_1_1_1_1_1_1);

		txtDienTich = new JTextField();
		txtDienTich.setColumns(10);
		txtDienTich.setBounds(262, 278, 99, 20);
		panel.add(txtDienTich);

		JLabel lblThngTinKhch = new JLabel("Thông Tin Khách Hàng");
		lblThngTinKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinKhch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngTinKhch.setForeground(new Color(255, 0, 0));
		lblThngTinKhch.setBounds(10, 11, 381, 28);
		contentPanel.add(lblThngTinKhch);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(403, 41, 517, 479);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JTabbedPane tbpDichVu = new JTabbedPane(JTabbedPane.TOP);
		tbpDichVu.setBounds(10, 11, 497, 457);
		panel_1.add(tbpDichVu);

		JPanel pnlDichVu = new JPanel();
		tbpDichVu.addTab("Dịch vụ", null, pnlDichVu, null);
		pnlDichVu.setLayout(null);

		tblDichVu = new JTable();
		tblDichVu.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 d\u1ECBch v\u1EE5", "M\u00E3 nh\u00E2n vi\u00EAn", "T\u00EAn d\u1ECBch v\u1EE5",
						"Gi\u00E1", "Ghi ch\u00FA", "Ch\u1ECDn" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Object.class, Object.class,
					Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm theo mã dịch vụ");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 11, 190, 14);
		pnlDichVu.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Các dich vụ hiện có:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_3_1.setBounds(10, 67, 190, 14);
		pnlDichVu.add(lblNewLabel_3_1);

		txtMaDichVu_Find = new JTextField();
		txtMaDichVu_Find.setName("txtMaDichVu_Find");
		txtMaDichVu_Find.addKeyListener(ctl);
		txtMaDichVu_Find.setBounds(10, 31, 373, 20);
		pnlDichVu.add(txtMaDichVu_Find);
		txtMaDichVu_Find.setColumns(10);

		JButton btnFind = new JButton("Find");
		btnFind.setBounds(393, 30, 89, 23);
		pnlDichVu.add(btnFind);

		JScrollPane scrollPane = new JScrollPane(tblDichVu);
		scrollPane.setBounds(10, 92, 472, 326);
		pnlDichVu.add(scrollPane);

		JPanel pnlListDichVu = new JPanel();
		tbpDichVu.addTab("Dịch vụ phòng", null, pnlListDichVu, null);
		pnlListDichVu.setLayout(null);

		JPanel pnlDichVu_1 = new JPanel();
		pnlDichVu_1.setLayout(null);
		pnlDichVu_1.setBounds(0, 11, 492, 429);
		pnlListDichVu.add(pnlDichVu_1);

		JLabel lblNewLabel_3_2 = new JLabel("Tìm kiếm theo mã phòng:");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_2.setBounds(10, 11, 190, 14);
		pnlDichVu_1.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_1_1 = new JLabel("Dịch vụ của phòng hiện tại:");
		lblNewLabel_3_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1_1.setBounds(10, 67, 190, 14);
		pnlDichVu_1.add(lblNewLabel_3_1_1);

		txtFindMaPhong = new JTextField();
		txtFindMaPhong.setName("txtFindMaPhong");
		txtFindMaPhong.addKeyListener(ctl);
		txtFindMaPhong.setColumns(10);
		txtFindMaPhong.setBounds(10, 31, 373, 20);
		pnlDichVu_1.add(txtFindMaPhong);

		JButton btnFindMaPhong = new JButton("Find");
		btnFindMaPhong.setBounds(393, 30, 89, 23);
		pnlDichVu_1.add(btnFindMaPhong);

		tblChiTietDichVu = new JTable();
		tblChiTietDichVu.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "M\u00E3 ph\u00F2ng",
				"M\u00E3 d\u1ECBch v\u1EE5", "Ghi ch\u00FA", "X\u00F3a d\u1ECBch v\u1EE5" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Boolean.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane(tblChiTietDichVu);
		scrollPane_1.setBounds(10, 84, 472, 300);
		pnlDichVu_1.add(scrollPane_1);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(393, 395, 89, 23);
		pnlDichVu_1.add(btnXoa);

		JLabel lblThngTinDch = new JLabel("Thông Tin Dịch Vụ ");
		lblThngTinDch.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinDch.setForeground(Color.RED);
		lblThngTinDch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThngTinDch.setBounds(401, 11, 519, 28);
		contentPanel.add(lblThngTinDch);

		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setText(Auth.user.getMaNhanVien());
		txtNgayThue.setText(XDate.dateString(XDate.now()));
		txtNgayHetHan.setText(XDate.dateString(XDate.addDays(365)));

		cboMaNguoiThue = new JComboBox();
		cboMaNguoiThue.setActionCommand("cboMaNguoiThue");
		cboMaNguoiThue.addActionListener(ctl);
		cboMaNguoiThue.setBounds(102, 10, 259, 22);
		panel.add(cboMaNguoiThue);
		loadComboboxMaPhong();
		loadDataTableDichVu();
		loadDataTableCTDV();
		loadComboboxMaNguoiThue();
		setLocationRelativeTo(null);
	}

	public void loadComboboxMaPhong() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
		cboMaPhong.addItem("");
		for (PhongModel phongModel : list) {
			cboMaPhong.addItem(phongModel.getMaPhong());
		}
	}

	public void displayInformationPhong() {
		String maPhong = cboMaPhong.getSelectedItem() + "";
		System.out.println(maPhong);
		PhongModel p = new PhongModel();
		p.setMaPhong(maPhong);
		PhongModel pd = PhongDao.getInstance().selectByID(p);
		txtTang.setText(pd.getTang() + "");
		txtGiaPhong.setText(pd.getGiaPhong() + "");
		txtLoaiPhong.setText(pd.getLoaiPhong());
		txtDienTich.setText(pd.getDienTich() + "");
	}

	public void insertTableNguoiThuePhong() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateCombobox(cboMaNguoiThue, sb, "Mã người thuê null");
			DataValidator.validateCombobox(cboMaPhong, sb, "Mã phòng null");
			DataValidator.validateIsID(txtMaNhanVien, sb, "Mã nhân viên null");
			DataValidator.validateSoCCCD(txtCCCD, sb, "Số căn cước null");
			DataValidator.validateEmpty(txtHoTen, sb, "Họ tên null");
			DataValidator.validateDateNow(txtNgaySinh, sb, "Ngày sinh null");
			DataValidator.validateChecked(buttonGroup, sb, "Chưa chọn giới tính");
			DataValidator.validateIsEmail(txtEmail, sb, "Email null");
			DataValidator.validateEmpty(txtDiaChi, sb, "Địa chỉ null");
			DataValidator.validateEmpty(txtLoaiPhong, sb, "Loại phòng null");
			DataValidator.validateEmpty(txtTang, sb, "Tầng null");
			DataValidator.validateEmpty(txtGiaPhong, sb, "Giá phòng null");
			DataValidator.validateEmpty(txtTienCoc, sb, "Tiền cọc null");
			DataValidator.validateEmpty(txtDienTich, sb, "Diện tích null");
			DataValidator.validateIsSDT(txtSDT, sb, "Số điện thoại null");
			DataValidator.validateDateNow(txtNgayThue, sb, "Ngày thuê null");
			DataValidator.validateDateNow(txtNgayHetHan, sb, "Ngày hết hạn null");
			DataValidator.validateDay(txtNgayThue, txtNgayHetHan, sb, "");

			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Notification");
				return;
			}
			String maNguoiThue = (String) cboMaNguoiThue.getSelectedItem();
			String maPhong = (String) cboMaPhong.getSelectedItem();
			String maNhanVien = txtMaNhanVien.getText();
			String soCCCDNT = txtCCCD.getText();
			String hoTen = txtHoTen.getText();
			Date ngaySinh = XDate.dateFormat(txtNgaySinh.getText());
			String gioiTinh = "";
			if (rdoNam.isSelected()) {
				gioiTinh = "Nam";
			} else if (rdoNu.isSelected()) {
				gioiTinh = "Nữ";
			}
			String email = txtEmail.getText();
			String diaChi = txtDiaChi.getText();
			String loaiPhong = txtLoaiPhong.getText();
			double giaPhong = Double.valueOf(txtGiaPhong.getText());
			double tienCoc = Double.valueOf(txtTienCoc.getText());
			String soDienThoai = txtSDT.getText();
			Date ngayBatDauThue = XDate.dateFormat(txtNgayThue.getText());
			Date ngayHetHanThue = XDate.dateFormat(txtNgayHetHan.getText());
			String ghiChu = txtGhiChu.getText();
			DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
			NguoiThuePhongModel nguoiThuePhongModel = new NguoiThuePhongModel();
			nguoiThuePhongModel.setMaNguoiThue(maNguoiThue);
			nguoiThuePhongModel.setSoCCCDNT(soCCCDNT);
			nguoiThuePhongModel.setMaPhong(maPhong);
			nguoiThuePhongModel.setMaNhanVien(maNhanVien);
			nguoiThuePhongModel.setHoTen(hoTen);
			nguoiThuePhongModel.setNgaySinh(ngaySinh);
			nguoiThuePhongModel.setGioiTinh(gioiTinh);
			nguoiThuePhongModel.setEmail(email);
			nguoiThuePhongModel.setNoiDangKyHK(diaChi);
			nguoiThuePhongModel.setSoDienThoai(soDienThoai);
			nguoiThuePhongModel.setNgayBatDauThue(ngayBatDauThue);
			nguoiThuePhongModel.setNgayHetHanThue(ngayHetHanThue);
			nguoiThuePhongModel.setGhiChu(ghiChu);
			if(NguoiThuePhongDao.getInstance().findOneByMaPhongNullAndMaNguoiThue(nguoiThuePhongModel)!=null) {
			if (NguoiThuePhongDao.getInstance().findOneByMaPhongAndMaNguoiThue(nguoiThuePhongModel) != null) {
				if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật?", "Notificatiom") == JOptionPane.NO_OPTION) {
					return;
				}
				for (int i = 0; i < model_table.getRowCount(); i++) {
					String maDichVu = model_table.getValueAt(i, 0) + "";
					boolean confirm = (boolean) model_table.getValueAt(i, 5);
					if (confirm) {
						if (ChiTietDichVuDao.getInstance()
								.selectByMaPhongAndMaDichVu(new ChiTietDichVuModel(maPhong, maDichVu, "")) != null) {
							MsgBox.showErrorDialog(this, "Dịch vụ đã tồn tại Cập nhật fail", "Notificaiton");
							return;
						}
					}
				}
				if (NguoiThuePhongDao.getInstance().update(nguoiThuePhongModel) > 0) {
					PhongModel p = new PhongModel();
					p.setMaPhong(maPhong);
					p.setTrangThai("Đang thuê");
					PhongDao.getInstance().updateInformation(p);
					LichSuPhongThueModel l = new LichSuPhongThueModel(maNguoiThue, maPhong, soCCCDNT, ngayBatDauThue,
							ngayHetHanThue);
					LichSuPhongThueDao.getInstance().update(l);
					for (int i = 0; i < model_table.getRowCount(); i++) {
						String maDichVu = model_table.getValueAt(i, 0) + "";
						boolean confirm = (boolean) model_table.getValueAt(i, 5);
						if (confirm) {
							ChiTietDichVuModel chiTietDichVuModel = new ChiTietDichVuModel(maPhong, maDichVu, "Null");
							ChiTietDichVuDao.getInstance().insert(chiTietDichVuModel);
						}
					}
					MsgBox.showMessageDialog(this, "Update success", "Notification");
				} else {
					MsgBox.showMessageDialog(this, "Update fail", "Notification");
				}
			} else {
				if (NguoiThuePhongDao.getInstance().update(nguoiThuePhongModel) > 0) {
					PhongModel p = new PhongModel();
					p.setMaPhong(maPhong);
					p.setTrangThai("Đang thuê");
					PhongDao.getInstance().updateInformation(p);
					LichSuPhongThueModel l = new LichSuPhongThueModel(maNguoiThue, maPhong, soCCCDNT, ngayBatDauThue,
							ngayHetHanThue);
					LichSuPhongThueDao.getInstance().insert(l);
					for (int i = 0; i < model_table.getRowCount(); i++) {
						String maDichVu = model_table.getValueAt(i, 0) + "";
						boolean confirm = (boolean) model_table.getValueAt(i, 5);
						if (confirm) {
							ChiTietDichVuModel chiTietDichVuModel = new ChiTietDichVuModel(maPhong, maDichVu, "Null");
							ChiTietDichVuDao.getInstance().insert(chiTietDichVuModel);
						}
					}
					MsgBox.showMessageDialog(this, "Insert success", "Notification");
				} else {
					MsgBox.showMessageDialog(this, "Insert fail", "Notification");
				}
			}
			loadDataTableCTDV();
			}else {
				MsgBox.showMessageDialog(this, "Fail NT already exist", "Notification");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	public void updateTableNguoiThuePhong() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateCombobox(cboMaNguoiThue, sb, "Mã người thuê null");
			DataValidator.validateCombobox(cboMaPhong, sb, "Mã phòng null");
			DataValidator.validateIsID(txtMaNhanVien, sb, "Mã nhân viên null");
			DataValidator.validateSoCCCD(txtCCCD, sb, "Số căn cước null");
			DataValidator.validateEmpty(txtHoTen, sb, "Họ tên null");
			DataValidator.validateDateNow(txtNgaySinh, sb, "Ngày sinh null");
			DataValidator.validateChecked(buttonGroup, sb, "Chưa chọn giới tính");
			DataValidator.validateIsEmail(txtEmail, sb, "Email null");
			DataValidator.validateEmpty(txtDiaChi, sb, "Địa chỉ null");
			DataValidator.validateEmpty(txtLoaiPhong, sb, "Loại phòng null");
			DataValidator.validateEmpty(txtTang, sb, "Tầng null");
			DataValidator.validateEmpty(txtGiaPhong, sb, "Giá phòng null");
			DataValidator.validateEmpty(txtTienCoc, sb, "Tiền cọc null");
			DataValidator.validateEmpty(txtDienTich, sb, "Diện tích null");
			DataValidator.validateIsSDT(txtSDT, sb, "Số điện thoại null");
			DataValidator.validateDateNow(txtNgayThue, sb, "Ngày thuê null");
			DataValidator.validateDateNow(txtNgayHetHan, sb, "Ngày hết hạn null");
			DataValidator.validateDay(txtNgayThue, txtNgayHetHan, sb, "");

			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Notification");
				return;
			}
			String maNguoiThue = cboMaNguoiThue.getSelectedItem() + "";
			String maPhong = cboMaPhong.getSelectedItem() + "";
			String maNhanVien = txtMaNhanVien.getText();
			String soCCCDNT = txtCCCD.getText();
			String hoTen = txtHoTen.getText();
			Date ngaySinh = XDate.dateFormat(txtNgaySinh.getText());
			String gioiTinh = "";
			if (rdoNam.isSelected()) {
				gioiTinh = "Nam";
			} else if (rdoNu.isSelected()) {
				gioiTinh = "Nữ";
			}
			String email = txtEmail.getText();
			String diaChi = txtDiaChi.getText();
			String loaiPhong = txtLoaiPhong.getText();
			double giaPhong = Double.valueOf(txtGiaPhong.getText());
			double tienCoc = Double.valueOf(txtTienCoc.getText());
			String soDienThoai = txtSDT.getText();
			Date ngayBatDauThue = XDate.dateFormat(txtNgayThue.getText());
			Date ngayHetHanThue = XDate.dateFormat(txtNgayHetHan.getText());
			String ghiChu = txtGhiChu.getText();
			DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
			NguoiThuePhongModel nguoiThuePhongModel = new NguoiThuePhongModel();
			nguoiThuePhongModel.setMaNguoiThue(maNguoiThue);
			nguoiThuePhongModel.setSoCCCDNT(soCCCDNT);
			nguoiThuePhongModel.setMaPhong(maPhong);
			nguoiThuePhongModel.setMaNhanVien(maNhanVien);
			nguoiThuePhongModel.setHoTen(hoTen);
			nguoiThuePhongModel.setNgaySinh(ngaySinh);
			nguoiThuePhongModel.setGioiTinh(gioiTinh);
			nguoiThuePhongModel.setEmail(email);
			nguoiThuePhongModel.setNoiDangKyHK(diaChi);
			nguoiThuePhongModel.setSoDienThoai(soDienThoai);
			nguoiThuePhongModel.setNgayBatDauThue(ngayBatDauThue);
			nguoiThuePhongModel.setNgayHetHanThue(ngayHetHanThue);
			nguoiThuePhongModel.setGhiChu(ghiChu);
			if (NguoiThuePhongDao.getInstance().findOneByMaPhongAndMaNguoiThue(nguoiThuePhongModel) != null) {
				if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật?", "Notificatiom") == JOptionPane.NO_OPTION) {
					return;
				}
				for (int i = 0; i < model_table.getRowCount(); i++) {
					String maDichVu = model_table.getValueAt(i, 0) + "";
					boolean confirm = (boolean) model_table.getValueAt(i, 5);
					if (confirm) {
						if (ChiTietDichVuDao.getInstance()
								.selectByMaPhongAndMaDichVu(new ChiTietDichVuModel(maPhong, maDichVu, "")) != null) {
							MsgBox.showErrorDialog(this, "Dịch vụ đã tồn tại Cập nhật fail", "Notificaiton");
							return;
						}
					}
				}
				if (NguoiThuePhongDao.getInstance().update(nguoiThuePhongModel) > 0) {
					PhongModel p = new PhongModel();
					p.setMaPhong(maPhong);
					p.setTrangThai("Đang thuê");
					PhongDao.getInstance().updateInformation(p);
					LichSuPhongThueModel l = new LichSuPhongThueModel(maNguoiThue, maPhong, soCCCDNT, ngayBatDauThue,
							ngayHetHanThue);
					LichSuPhongThueDao.getInstance().update(l);
					for (int i = 0; i < model_table.getRowCount(); i++) {
						String maDichVu = model_table.getValueAt(i, 0) + "";
						boolean confirm = (boolean) model_table.getValueAt(i, 5);
						if (confirm) {
							ChiTietDichVuModel chiTietDichVuModel = new ChiTietDichVuModel(maPhong, maDichVu, "Null");
							ChiTietDichVuDao.getInstance().insert(chiTietDichVuModel);
						}
					}
					MsgBox.showMessageDialog(this, "Update success", "Notification");
				} else {
					MsgBox.showMessageDialog(this, "Update fail", "Notification");
				}
			} else {
				if (NguoiThuePhongDao.getInstance().update(nguoiThuePhongModel) > 0) {
					PhongModel p = new PhongModel();
					p.setMaPhong(maPhong);
					p.setTrangThai("Đang thuê");
					PhongDao.getInstance().updateInformation(p);
					LichSuPhongThueModel l = new LichSuPhongThueModel(maNguoiThue, maPhong, soCCCDNT, ngayBatDauThue,
							ngayHetHanThue);
					LichSuPhongThueDao.getInstance().insert(l);
					for (int i = 0; i < model_table.getRowCount(); i++) {
						String maDichVu = model_table.getValueAt(i, 0) + "";
						boolean confirm = (boolean) model_table.getValueAt(i, 5);
						if (confirm) {
							ChiTietDichVuModel chiTietDichVuModel = new ChiTietDichVuModel(maPhong, maDichVu, "Null");
							ChiTietDichVuDao.getInstance().insert(chiTietDichVuModel);
						}
					}
					MsgBox.showMessageDialog(this, "Insert success", "Notification");
				} else {
					MsgBox.showMessageDialog(this, "Insert fail", "Notification");
				}
			}
			loadDataTableCTDV();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	

	public void loadDataTableDichVu() {
		DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
		ArrayList<DichVuModel> list = DichVuDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (DichVuModel dichVuModel : list) {
			model_table.addRow(new Object[] { dichVuModel.getMaDichVu(), dichVuModel.getMaNhanVien(),
					dichVuModel.getTenDichVu(), dichVuModel.getGiaDichVu(), dichVuModel.getGhiChu(), false });
		}
	}

	public void loadDataTableCTDV() {
		DefaultTableModel model_table = (DefaultTableModel) tblChiTietDichVu.getModel();
		ArrayList<ChiTietDichVuModel> list = ChiTietDichVuDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (ChiTietDichVuModel chiTietDichVuModel : list) {
			model_table.addRow(new Object[] { chiTietDichVuModel.getMaPhong(), chiTietDichVuModel.getMaDichVu(),
					chiTietDichVuModel.getGhiChu(), false });
		}
	}

	public void findMaDichVu() {
		DefaultTableModel model_table = (DefaultTableModel) tblDichVu.getModel();
		String maDichVu = txtMaDichVu_Find.getText();
		System.out.println(maDichVu);
		ArrayList<DichVuModel> list = DichVuDao.getInstance().selectByKeyWord(new DichVuModel(maDichVu));
		model_table.setRowCount(0);
		for (DichVuModel dichVuModel : list) {
			model_table.addRow(new Object[] { dichVuModel.getMaDichVu(), dichVuModel.getMaNhanVien(),
					dichVuModel.getTenDichVu(), dichVuModel.getGiaDichVu(), dichVuModel.getGhiChu(), false });
		}
	}

	public void findMaPhong() {
		DefaultTableModel model_table = (DefaultTableModel) tblChiTietDichVu.getModel();
		String maPhong = txtFindMaPhong.getText();
		ArrayList<ChiTietDichVuModel> list = ChiTietDichVuDao.getInstance()
				.selectByKeyWordMaPhong(new ChiTietDichVuModel(maPhong));
		model_table.setRowCount(0);
		for (ChiTietDichVuModel chiTietDichVuModel : list) {
			model_table.addRow(new Object[] { chiTietDichVuModel.getMaPhong(), chiTietDichVuModel.getMaDichVu(),
					chiTietDichVuModel.getGhiChu(), false });
		}
	}

	public void displayMaPhong(String maPhong) {
		cboMaPhong.setSelectedItem(maPhong);
		displayInformationPhong();
	}

	public void displayNguoiThue(String maNguoiThue) {
		cboMaPhong.setEnabled(false);
		btnThemKhach.setVisible(false);
		btnLamMoi.setVisible(false);
		NguoiThuePhongModel nt = NguoiThuePhongDao.getInstance().selectByID(new NguoiThuePhongModel(maNguoiThue));
		cboMaNguoiThue.setSelectedItem(nt.getMaNguoiThue());
		cboMaPhong.setSelectedItem(nt.getMaPhong());
		txtMaNhanVien.setText(nt.getMaNhanVien());
		txtCCCD.setText(nt.getSoCCCDNT());
		txtHoTen.setText(nt.getHoTen());
		txtNgaySinh.setText(XDate.dateString(nt.getNgaySinh()));
		if (nt.getGioiTinh().equals("Nam")) {
			rdoNam.setSelected(true);
		} else if (nt.getGioiTinh().equals("Nữ")) {
			rdoNu.setSelected(true);
		}
		txtEmail.setText(nt.getEmail());
		txtDiaChi.setText(nt.getNoiDangKyHK());
		txtTienCoc.setText(nt.getTienCoc() + "");
		txtSDT.setText(nt.getSoDienThoai());
		txtNgayThue.setText(XDate.dateString(nt.getNgayBatDauThue()));
		txtNgayHetHan.setText(XDate.dateString(nt.getNgayHetHanThue()));
		txtGhiChu.setText(nt.getGhiChu());

		PhongModel pm = new PhongModel();
		pm.setMaPhong(nt.getMaPhong());
		PhongModel p = PhongDao.getInstance().selectByID(pm);
		txtLoaiPhong.setText(p.getLoaiPhong());
		txtTang.setText(p.getTang() + "");
		txtGiaPhong.setText(p.getGiaPhong() + "");
		txtDienTich.setText(p.getDienTich() + "");
	}

	public void resetForm() {
		cboMaNguoiThue.setSelectedIndex(-1);
		cboMaPhong.setSelectedIndex(-1);
		txtMaNhanVien.setText(Auth.user.getMaNhanVien());
		txtCCCD.setText("");
		txtHoTen.setText("");
		txtNgaySinh.setText("");
		buttonGroup.clearSelection();
		txtEmail.setText("");
		txtDiaChi.setText("");
		txtLoaiPhong.setText("");
		txtTienCoc.setText("");
		txtSDT.setText("");
		txtNgayThue.setText(XDate.dateString(XDate.now()));
		txtNgayHetHan.setText(XDate.dateString(XDate.addDays(365)));
	}

	public void loadComboboxMaNguoiThue() {
		ArrayList<NguoiThuePhongModel> list = NguoiThuePhongDao.getInstance().selectAll();
		cboMaNguoiThue.addItem("");
		list.forEach(item -> cboMaNguoiThue.addItem(item.getMaNguoiThue()));
	}

	public void displayInformationNguoiThue() {
		try {
			String maNguoiThue = cboMaNguoiThue.getSelectedItem() + "";
			NguoiThuePhongModel ntp = new NguoiThuePhongModel();
			ntp.setMaNguoiThue(maNguoiThue);
			NguoiThuePhongModel nt = NguoiThuePhongDao.getInstance().selectByID(ntp);
			txtCCCD.setText(nt.getSoCCCDNT());
			txtHoTen.setText(nt.getHoTen());
			txtNgaySinh.setText(XDate.dateString(nt.getNgaySinh()));
			if (nt.getGioiTinh().equals("Nam")) {
				rdoNam.setSelected(true);
			} else if (nt.getGioiTinh().equals("Nữ")) {
				rdoNu.setSelected(true);
			}
			txtEmail.setText(nt.getEmail());
			txtDiaChi.setText(nt.getNoiDangKyHK());
			txtTienCoc.setText(nt.getTienCoc() + "");
			txtSDT.setText(nt.getSoDienThoai());
		} catch (Exception e) {
		}
	}
}
