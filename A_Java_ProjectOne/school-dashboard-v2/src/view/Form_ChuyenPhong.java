package view;

import java.awt.Color;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controller.Form_ChuyenPhongCTL;
import dao.ChiTietDichVuDao;
import dao.ChuyenPhongDao;
import dao.LichSuPhongThueDao;
import dao.NguoiThuePhongDao;
import dao.PhongDao;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import model.ChiTietDichVuModel;
import model.ChuyenPhongModel;
import model.LichSuPhongThueModel;
import model.NguoiThuePhongModel;
import model.PhongModel;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Form_ChuyenPhong extends JPanel {
	private JTextField txtMaChuyenPhong;
	private JTextField txtNgayChuyen;
	private JTable tblPhongChuyen;
	private JTextField txtMaNhanVien;
	private JTable tblPhongTrong;
	private JTextField txtFind;
	private JComboBox cboMaPhongCu;
	private JComboBox cboMaPhongMoi;
	private JTextField txtSoCCCD;
	private JTextArea txtGhiChu;
	private JButton btnFind;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPre;
	private JButton btnFirst;
	private JButton btnLamMoi;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnChuyen;
	private int count = 0;
	private JTextField txtFindMaPhongTrong;
	private JButton btnFindMaPhongTrong;

	/**
	 * Create the panel.
	 */
	public Form_ChuyenPhong() {
		Form_ChuyenPhongCTL ctl = new Form_ChuyenPhongCTL(this);
		setBounds(0, 11, 1200, 652);
		setBackground(new Color(227, 227, 227));
		setOpaque(false);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 1200, 600);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã chuyển phòng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(0, 0, 160));
		lblNewLabel.setBounds(276, 8, 131, 14);
		panel.add(lblNewLabel);

		JLabel lblMPhngC = new JLabel("Mã phòng cũ:");
		lblMPhngC.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMPhngC.setForeground(new Color(0, 0, 160));
		lblMPhngC.setBounds(10, 36, 91, 14);
		panel.add(lblMPhngC);

		JLabel lblMPhngMi = new JLabel("Mã phòng mới:");
		lblMPhngMi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMPhngMi.setForeground(new Color(0, 0, 160));
		lblMPhngMi.setBounds(276, 36, 91, 14);
		panel.add(lblMPhngMi);

		JLabel lblNgyChuyn = new JLabel("Ngày chuyển:");
		lblNgyChuyn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgyChuyn.setForeground(new Color(0, 0, 160));
		lblNgyChuyn.setBounds(276, 61, 91, 14);
		panel.add(lblNgyChuyn);

		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(
				new ImageIcon(Form_ChuyenPhong.class.getResource("/icon/name address contact no. signature.png")));
		lblNewLabel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_4.setBounds(542, 5, 421, 137);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_3_1 = new JLabel("Ghi chú:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_1.setBounds(10, 89, 91, 14);
		panel.add(lblNewLabel_3_1);

		txtMaChuyenPhong = new JTextField();
		txtMaChuyenPhong.setBounds(377, 5, 155, 20);
		panel.add(txtMaChuyenPhong);
		txtMaChuyenPhong.setColumns(10);

		txtNgayChuyen = new JTextField();
		txtNgayChuyen.setColumns(10);
		txtNgayChuyen.setBounds(377, 58, 155, 20);
		panel.add(txtNgayChuyen);

		cboMaPhongCu = new JComboBox();
		cboMaPhongCu.setBounds(111, 32, 155, 22);
		panel.add(cboMaPhongCu);

		cboMaPhongMoi = new JComboBox();
		cboMaPhongMoi.setBounds(377, 32, 155, 22);
		panel.add(cboMaPhongMoi);

		tblPhongChuyen = new JTable();
		tblPhongChuyen.setShowVerticalLines(false);
		tblPhongChuyen.setSelectionBackground(new Color(255, 128, 0));
		tblPhongChuyen.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã chuyển phòng",
				"Mã phòng cũ", "Mã phòng mới", "Mã nhân viên", "Số CCCD", "Ngày chuyển", "Ghi chú" }));
		tblPhongChuyen.setName("tblPhongChuyen");
		tblPhongChuyen.addMouseListener(ctl);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(111, 89, 421, 53);
		panel.add(txtGhiChu);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMNhnVin.setForeground(new Color(0, 0, 160));
		lblMNhnVin.setBounds(10, 64, 91, 14);
		panel.add(lblMNhnVin);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(111, 61, 155, 20);
		panel.add(txtMaNhanVien);

		JLabel lblNewLabel_3_1_1 = new JLabel("Danh sách chuyển phòng:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_1_1.setBounds(10, 193, 142, 14);
		panel.add(lblNewLabel_3_1_1);

		tblPhongTrong = new JTable();
		tblPhongTrong.setSelectionBackground(new Color(255, 128, 0));
		tblPhongTrong.setShowVerticalLines(false);
		tblPhongTrong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phòng", "Mã tòa nhà", "Loại phòng", "Tầng", "Số lượng người", "Trạng thái" }));
		tblPhongTrong.setName("tblPhongTrong");
		tblPhongTrong.addMouseListener(ctl);
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Danh sách phòng trống:");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3_1_1_1.setForeground(new Color(0, 0, 160));
		lblNewLabel_3_1_1_1.setBounds(542, 193, 142, 14);
		panel.add(lblNewLabel_3_1_1_1);

		btnChuyen = new JButton("Chuyển");
		btnChuyen.addActionListener(ctl);
		btnChuyen.setBounds(10, 551, 69, 23);
		panel.add(btnChuyen);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(78, 551, 61, 23);
		panel.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(137, 551, 61, 23);
		panel.add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(197, 551, 75, 23);
		panel.add(btnLamMoi);

		JLabel lblTmTheoM = new JLabel("Mã phòng:");
		lblTmTheoM.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTmTheoM.setForeground(new Color(0, 0, 160));
		lblTmTheoM.setBounds(10, 165, 99, 14);
		panel.add(lblTmTheoM);

		txtFind = new JTextField();
		txtFind.setName("txtFind");
		txtFind.addKeyListener(ctl);
		txtFind.setColumns(10);
		txtFind.setBounds(111, 162, 273, 20);
		panel.add(txtFind);

		btnFind = new JButton("Tìm");
		btnFind.addActionListener(ctl);
		btnFind.setBounds(442, 161, 89, 23);
		panel.add(btnFind);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(484, 551, 48, 23);
		panel.add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(437, 551, 49, 23);
		panel.add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(389, 551, 49, 23);
		panel.add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(345, 551, 49, 23);
		panel.add(btnFirst);

		JScrollPane scrollPane = new JScrollPane(tblPhongTrong);
		scrollPane.setBounds(542, 221, 421, 289);
		panel.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane(tblPhongChuyen);
		scrollPane_1.setBounds(10, 221, 522, 289);
		panel.add(scrollPane_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 532, 953, 8);
		panel.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 146, 953, 8);
		panel.add(separator_1);

		JLabel lblSocccdnt = new JLabel("SoCCCDNT:");
		lblSocccdnt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSocccdnt.setForeground(new Color(0, 0, 160));
		lblSocccdnt.setBounds(10, 8, 91, 14);
		panel.add(lblSocccdnt);

		txtSoCCCD = new JTextField();
		txtSoCCCD.addKeyListener(ctl);
		txtSoCCCD.setColumns(10);
		txtSoCCCD.setBounds(111, 5, 155, 20);
		panel.add(txtSoCCCD);

		this.tblPhongChuyen.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.tblPhongChuyen.getTableHeader().setOpaque(false);
		this.tblPhongChuyen.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblPhongChuyen.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblPhongChuyen.setRowHeight(25);

		this.tblPhongTrong.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.tblPhongTrong.getTableHeader().setOpaque(false);
		this.tblPhongTrong.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblPhongTrong.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblPhongTrong.setRowHeight(25);

		txtNgayChuyen.setText(XDate.dateString(XDate.now()));

		JLabel lblMaPhongTrong = new JLabel("Mã phòng trống:");
		lblMaPhongTrong.setForeground(new Color(0, 0, 160));
		lblMaPhongTrong.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaPhongTrong.setBounds(542, 165, 99, 14);
		panel.add(lblMaPhongTrong);

		txtFindMaPhongTrong = new JTextField();
		txtFindMaPhongTrong.setName("txtFindMaPhongTrong");
		txtFindMaPhongTrong.addKeyListener(ctl);
		txtFindMaPhongTrong.setColumns(10);
		txtFindMaPhongTrong.setBounds(651, 162, 178, 20);
		panel.add(txtFindMaPhongTrong);

		btnFindMaPhongTrong = new JButton("Tìm");
		btnFindMaPhongTrong.setActionCommand("find");
		btnFindMaPhongTrong.addActionListener(ctl);
		btnFindMaPhongTrong.setBounds(874, 161, 89, 23);
		panel.add(btnFindMaPhongTrong);
		loadComboboxMPM();
		loadDataTableCP();
		loadDataTablePT();
		upStatus();
	}

	public void loadComboboxMPC() {
		String soCCCDNT = txtSoCCCD.getText();
		ArrayList<NguoiThuePhongModel> list = NguoiThuePhongDao.getInstance()
				.selectByCondition("soCCCDNT like '" + soCCCDNT + "%'");
		cboMaPhongCu.removeAllItems();
		cboMaPhongCu.addItem("");
		for (NguoiThuePhongModel nguoiThuePhongModel : list) {
			System.out.println(nguoiThuePhongModel.getMaPhong());
			cboMaPhongCu.addItem(nguoiThuePhongModel.getMaPhong());
		}
	}

	public void loadComboboxMPM() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectByCondition("trangThai is null");
		cboMaPhongMoi.addItem("");
		for (PhongModel phongModel : list) {
			cboMaPhongMoi.addItem(phongModel.getMaPhong());
		}
	}

	public void loadDataTablePT() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectByCondition("trangThai is null");
		DefaultTableModel model_table = (DefaultTableModel) tblPhongTrong.getModel();
		model_table.setRowCount(0);
		for (PhongModel pModel : list) {
			model_table.addRow(
					new Object[] { pModel.getMaPhong(), pModel.getMaToaNha(), pModel.getLoaiPhong(), pModel.getTang(),
							pModel.getSoLuongNguoi(), pModel.getTrangThai() != null ? "Đang sử dụng" : "Trống" });
		}
	}

	public void loadDataTable() {
		String maPhong = txtFindMaPhongTrong.getText();
		ArrayList<PhongModel> list = PhongDao.getInstance().selectByKeyWord("'%" + maPhong + "%'");
		DefaultTableModel model_table = (DefaultTableModel) tblPhongTrong.getModel();
		model_table.setRowCount(0);
		for (PhongModel pModel : list) {
			model_table.addRow(
					new Object[] { pModel.getMaPhong(), pModel.getMaToaNha(), pModel.getLoaiPhong(), pModel.getTang(),
							pModel.getSoLuongNguoi(), pModel.getTrangThai() != null ? "Đang sử dụng" : "Trống" });
		}
	}

	public void loadDataTableCP() {
		ArrayList<ChuyenPhongModel> list = ChuyenPhongDao.getInstance().selectAll();
		DefaultTableModel model_table = (DefaultTableModel) tblPhongChuyen.getModel();
		model_table.setRowCount(0);
		for (ChuyenPhongModel chuyenPhongModel : list) {
			model_table.addRow(new Object[] { chuyenPhongModel.getMaChuyenPhong(), chuyenPhongModel.getMaPhongCu(),
					chuyenPhongModel.getMaPhongMoi(), chuyenPhongModel.getMaNhanVien(), chuyenPhongModel.getSoCCCDNT(),
					XDate.dateString(chuyenPhongModel.getNgayChuyen()), chuyenPhongModel.getGhiChu() });
		}
	}

	public void chuyenPhong() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateSoCCCD(txtSoCCCD, sb, "Số căn cước null");
		DataValidator.validateIsID(txtMaChuyenPhong, sb, "Mã chuyển null");
		DataValidator.validateCombobox(cboMaPhongCu, sb, "Chưa chọn phòng cũ");
		DataValidator.validateCombobox(cboMaPhongMoi, sb, "Chưa chọn phòng mới");
		DataValidator.validateIsID(txtMaNhanVien, sb, "Mã nhân viên null");
		DataValidator.validateDateNow(txtNgayChuyen, sb, "Ngày chuyển null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notificaiton");
			return;
		}
		String soCCCDNT = txtSoCCCD.getText();
		String maChuyenPhong = txtMaChuyenPhong.getText();
		String maPhongCu = cboMaPhongCu.getSelectedItem() + "";
		String maPhongMoi = cboMaPhongMoi.getSelectedItem() + "";
		String maNhanVien = txtMaNhanVien.getText();
		Date ngayChuyen = XDate.dateFormat(txtNgayChuyen.getText());
		String ghiChu = txtGhiChu.getText();

		NguoiThuePhongModel n = NguoiThuePhongDao.getInstance().selectByMaPhong(maPhongCu);
		n.setMaPhong(maPhongMoi);
		if (NguoiThuePhongDao.getInstance().update(n) > 0) {
			// Khi cập nhật thành công người thuê phòng sang phòng khác thì sử lí tiếp
			// Cập nhật trạng thái phòng
			PhongModel p = new PhongModel();
			p.setMaPhong(maPhongCu);
			p.setTrangThai(null);
			PhongDao.getInstance().updateInformation(p);
			PhongModel pm = new PhongModel();
			pm.setMaPhong(maPhongMoi);
			pm.setTrangThai("Đang thuê");
			PhongDao.getInstance().updateInformation(pm);
			ChuyenPhongModel c = new ChuyenPhongModel(maChuyenPhong, maPhongCu, maPhongMoi, maNhanVien, soCCCDNT,
					ngayChuyen, ghiChu);
			ChuyenPhongDao.getInstance().insert(c);
			// Tạo các dịch vụ của phòng cũ cho phòng mới
			// Lấy mã phòng mới add các thông tin dịch vụ của phòng mã phòng cũ
			ArrayList<ChiTietDichVuModel> list = ChiTietDichVuDao.getInstance()
					.selectByMaPhongAll(new ChiTietDichVuModel(maPhongCu));
			for (ChiTietDichVuModel chiTietDichVuModel : list) {
				ChiTietDichVuModel ctm = new ChiTietDichVuModel(maPhongMoi, chiTietDichVuModel.getMaDichVu(),
						chiTietDichVuModel.getGhiChu());
				ChiTietDichVuDao.getInstance().insert(ctm);
			}
			// Xóa các dịch vụ hiện có của phòng cũ
			ChiTietDichVuModel ct = new ChiTietDichVuModel();
			ct.setMaPhong(maPhongCu);
			ChiTietDichVuDao.getInstance().delete(ct);
			// Cập nhật lịch sử thuê cho phòng mới và phòng cũ
			LichSuPhongThueModel ls = new LichSuPhongThueModel();
			ls.setMaNguoiThue(n.getMaNguoiThue());
			ls.setNgayTraPhong(XDate.now());
			LichSuPhongThueDao.getInstance().update(ls);
			// Tạo lịch sử thuê phòng mới cho cho phòng mới
			LichSuPhongThueModel lsm = new LichSuPhongThueModel(n.getMaNguoiThue(), maPhongMoi, soCCCDNT,
					n.getNgayBatDauThue(), null);
			LichSuPhongThueDao.getInstance().insert(lsm);
			MsgBox.showMessageDialog(this, "Chuyển phòng success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Chuyển phòng fail", "Notification");
		}
		loadDataTableCP();
	}

	public void updateChuyenPhong() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateSoCCCD(txtSoCCCD, sb, "Số căn cước null");
		DataValidator.validateIsID(txtMaChuyenPhong, sb, "Mã chuyển null");
		DataValidator.validateCombobox(cboMaPhongCu, sb, "Chưa chọn phòng cũ");
		DataValidator.validateCombobox(cboMaPhongMoi, sb, "Chưa chọn phòng mới");
		DataValidator.validateIsID(txtMaNhanVien, sb, "Mã nhân viên null");
		DataValidator.validateDateNow(txtNgayChuyen, sb, "Ngày chuyển null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notificaiton");
			return;
		}
		String soCCCDNT = txtSoCCCD.getText();
		String maChuyenPhong = txtMaChuyenPhong.getText();
		String maPhongCu = cboMaPhongCu.getSelectedItem() + "";
		String maPhongMoi = cboMaPhongMoi.getSelectedItem() + "";
		String maNhanVien = txtMaNhanVien.getText();
		Date ngayChuyen = XDate.dateFormat(txtNgayChuyen.getText());
		String ghiChu = txtGhiChu.getText();

		// Lấy mã phòng
		ChuyenPhongModel c = getValueForm();
		// Xử lí các thông tin dịch vụ của phòng
		ArrayList<ChiTietDichVuModel> list = ChiTietDichVuDao.getInstance()
				.selectByMaPhongAll(new ChiTietDichVuModel(c.getMaPhongMoi()));
		for (ChiTietDichVuModel chiTietDichVuModel : list) {
			ChiTietDichVuModel ct = new ChiTietDichVuModel(c.getMaPhongCu(), chiTietDichVuModel.getMaDichVu(),
					chiTietDichVuModel.getGhiChu());
			ChiTietDichVuDao.getInstance().insert(ct);
		}
		ChiTietDichVuDao.getInstance().delete(new ChiTietDichVuModel(c.getMaPhongMoi()));
		// Xử lí trạng thái phòng
		PhongModel p = new PhongModel();
		p.setMaPhong(c.getMaPhongMoi());
		p.setTrangThai(null);
		PhongDao.getInstance().updateInformation(p);
		PhongModel pn = new PhongModel();
		p.setMaPhong(c.getMaPhongCu());
		p.setTrangThai("Đang thuê");
		// Xử người thuê
		NguoiThuePhongModel n = NguoiThuePhongDao.getInstance().selectByMaPhong(c.getMaPhongMoi());
		n.setMaPhong(c.getMaPhongCu());
		n.setMaNhanVien(maNhanVien);
		NguoiThuePhongDao.getInstance().updateTraPhong(n);

		// Xủ lí chuyển phòng
		NguoiThuePhongModel nn = NguoiThuePhongDao.getInstance().selectByMaPhong(maPhongCu);
		n.setMaPhong(maPhongMoi);
		if (NguoiThuePhongDao.getInstance().updateTraPhong(nn) > 0) {
			// Khi cập nhật thành công người thuê phòng sang phòng khác thì sử lí tiếp
			// Cập nhật trạng thái phòng
			PhongModel pp = new PhongModel();
			pp.setMaPhong(maPhongCu);
			pp.setTrangThai(null);
			PhongDao.getInstance().updateInformation(p);
			PhongModel pm = new PhongModel();
			pm.setMaPhong(maPhongMoi);
			pm.setTrangThai("Đang thuê");
			PhongDao.getInstance().updateInformation(pm);
			ChuyenPhongModel cc = new ChuyenPhongModel(maChuyenPhong, maPhongCu, maPhongMoi, maNhanVien, soCCCDNT,
					ngayChuyen, ghiChu);
			ChuyenPhongDao.getInstance().insert(cc);
			// Tạo các dịch vụ của phòng cũ cho phòng mới
			// Lấy mã phòng mới add các thông tin dịch vụ của phòng mã phòng cũ
			ArrayList<ChiTietDichVuModel> listCT = ChiTietDichVuDao.getInstance()
					.selectByMaPhongAll(new ChiTietDichVuModel(maPhongCu));
			for (ChiTietDichVuModel chiTietDichVuModel : listCT) {
				ChiTietDichVuModel ctm = new ChiTietDichVuModel(maPhongMoi, chiTietDichVuModel.getMaDichVu(),
						chiTietDichVuModel.getGhiChu());
				ChiTietDichVuDao.getInstance().insert(ctm);
			}
			// Xóa các dịch vụ hiện có của phòng cũ
			ChiTietDichVuModel ct = new ChiTietDichVuModel();
			ct.setMaPhong(maPhongCu);
			ChiTietDichVuDao.getInstance().delete(ct);
			// Cập nhật lịch sử thuê cho phòng mới và phòng cũ
			LichSuPhongThueModel ls = new LichSuPhongThueModel();
			ls.setMaNguoiThue(n.getMaNguoiThue());
			ls.setNgayTraPhong(XDate.now());
			LichSuPhongThueDao.getInstance().update(ls);
			// Tạo lịch sử thuê phòng mới cho cho phòng mới
			LichSuPhongThueModel lsm = new LichSuPhongThueModel(n.getMaNguoiThue(), maPhongMoi, soCCCDNT,
					n.getNgayBatDauThue(), null);
			LichSuPhongThueDao.getInstance().insert(lsm);
			MsgBox.showMessageDialog(this, "Chuyển phòng success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Chuyển phòng fail", "Notification");
		}
		loadDataTableCP();

	}

	public ChuyenPhongModel getValueForm() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhongChuyen.getModel();
		int i_row = tblPhongChuyen.getSelectedRow();
		String maPhongChuyen = model_table.getValueAt(i_row, 0) + "";
		ChuyenPhongModel c = ChuyenPhongDao.getInstance().selectByID(new ChuyenPhongModel(maPhongChuyen));
		return c;
	}

	public void displayOnForm() {
		try {
			ChuyenPhongModel c = getValueForm();
//			System.out.println(c);
			txtSoCCCD.setText(c.getSoCCCDNT());
			loadComboboxMPC();
			txtMaChuyenPhong.setText(c.getMaChuyenPhong());
//			cboMaPhongCu.removeAllItems();
//			cboMaPhongMoi.removeAllItems();
			cboMaPhongCu.addItem(c.getMaPhongCu());
			cboMaPhongCu.setSelectedItem(c.getMaPhongCu());
			cboMaPhongMoi.addItem(c.getMaPhongMoi());
			cboMaPhongMoi.setSelectedItem(c.getMaPhongMoi());
			txtMaNhanVien.setText(c.getMaNhanVien());
			txtNgayChuyen.setText(XDate.dateString(c.getNgayChuyen()));
			txtGhiChu.setText(c.getGhiChu());
			int i_row = tblPhongChuyen.getSelectedRow();
			count = i_row;
			upStatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteForm() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaChuyenPhong, sb, "Mã chuyển phòng null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maChuyenPhong = txtMaChuyenPhong.getText();
		ChuyenPhongModel cp = new ChuyenPhongModel();
		cp.setMaChuyenPhong(maChuyenPhong);
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa?", "Notificaiton") == JOptionPane.NO_OPTION) {
			return;
		}
		if (ChuyenPhongDao.getInstance().delete(cp) > 0) {
			MsgBox.showMessageDialog(this, "Delete success", "Notificaiton");
		} else {
			MsgBox.showMessageDialog(this, "Delete fail", "Notificaiton");
		}
		loadDataTableCP();
	}

	public void resetForm() {
		txtSoCCCD.setText("");
		txtMaChuyenPhong.setText("");
		cboMaPhongCu.removeAllItems();
		cboMaPhongMoi.removeAllItems();
		loadComboboxMPM();
		txtMaNhanVien.setText("");
		txtGhiChu.setText("");
		txtNgayChuyen.setText(XDate.dateString(XDate.now()));
		txtSoCCCD.requestFocus();
		count = -1;
		upStatus();
	}

	public void upStatus() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == tblPhongChuyen.getRowCount() - 1;

		txtMaChuyenPhong.setEditable(!edit);
		btnChuyen.setEnabled(!edit);
		btnSua.setEnabled(edit);
		btnXoa.setEnabled(edit);

		btnFirst.setEnabled(edit && !first);
		btnPre.setEnabled(edit && !first);
		btnNext.setEnabled(edit && !last);
		btnLast.setEnabled(edit && !last);
	}

	public void firstElement() {
		count = 0;
		tblPhongChuyen.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		tblPhongChuyen.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblPhongChuyen.getSelectedRow();
		count = i_row;
		count++;
		if (count > tblPhongChuyen.getRowCount() - 1) {
			count = tblPhongChuyen.getRowCount() - 1;
		}
		tblPhongChuyen.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void lastElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		count = tblPhongChuyen.getRowCount() - 1;
		tblPhongChuyen.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public PhongModel getInstanceMPM() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhongTrong.getModel();
		int i_row = tblPhongTrong.getSelectedRow();
		String maPhong = model_table.getValueAt(i_row, 0) + "";
		PhongModel p = new PhongModel();
		p.setMaPhong(maPhong);
		PhongModel pd = PhongDao.getInstance().selectByID(p);
		return pd;
	}

	public void displayOnComboboxMPM() {
		PhongModel p = getInstanceMPM();
		System.out.println(p.getMaPhong());
		cboMaPhongMoi.setSelectedItem(p.getMaPhong());
	}
}
