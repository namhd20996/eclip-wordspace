package view;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.Form_PhieuThuTienPhongCTL;
import dao.ChiTietDichVuDao;
import dao.DichVuDao;
import dao.PhieuThuTienPhongDao;
import dao.PhongDao;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import model.ChiTietDichVuModel;
import model.DichVuModel;
import model.PhieuThuTienPhongModel;
import model.PhongModel;

public class Form_PhieuThuTienPhong extends JPanel {
	private JTextField txtMaPhieuThu;
	private JTextField txtMaNhanVien;
	private JTextField txtSoDienTruoc;
	private JTextField txtSoNuocTruoc;
	private JTextField txtThangThu;
	private JTextField txtDonGiaDien;
	private JTextField txtSoDien;
	private JTextField txtSoNuoc;
	private JTextField txtTienDichVu;
	private JTextField txtDonGiaPhong;
	private JTextField txtDonGiaNuoc;
	private JTextField txtThanhTienDien;
	private JTextField txtThanhTienNuoc;
	private JTextField txtThanhTien;
	private JTable tblPhieuThuTienPhong;
	private JTextField txtFind;
	private JButton btnFirst;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnLamMoi;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private JTextArea txtGhiChu;
	private JComboBox cboMaPhong;
	private int count = 0;

	/**
	 * Create the panel.
	 */
	public Form_PhieuThuTienPhong() {
		Form_PhieuThuTienPhongCTL ctl = new Form_PhieuThuTienPhongCTL(this);
		setBounds(0, 11, 1200, 920);
		setBackground(new Color(227, 227, 227));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã phiếu thu:");
		lblNewLabel.setBounds(10, 11, 85, 14);
		add(lblNewLabel);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setBounds(10, 36, 85, 14);
		add(lblMNhnVin);

		JLabel lblThngThu = new JLabel("Tháng thu:");
		lblThngThu.setBounds(10, 111, 85, 14);
		add(lblThngThu);

		JLabel lblSinTrc = new JLabel("Số điện trước:");
		lblSinTrc.setBounds(10, 61, 85, 14);
		add(lblSinTrc);

		JLabel lblNewLabel_3_1 = new JLabel("Ghi chú:");
		lblNewLabel_3_1.setBounds(10, 136, 48, 14);
		add(lblNewLabel_3_1);

		JLabel lblNewLabel_2_1 = new JLabel("Tiền dịch vụ:");
		lblNewLabel_2_1.setBounds(382, 111, 85, 14);
		add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1 = new JLabel("Thành tiền điện:");
		lblNewLabel_1_1.setBounds(687, 64, 85, 14);
		add(lblNewLabel_1_1);

		JLabel lblSinTrc_1 = new JLabel("Số nước trước:");
		lblSinTrc_1.setBounds(10, 86, 85, 14);
		add(lblSinTrc_1);

		JLabel lblNewLabel_3_1_3 = new JLabel("Số nước:");
		lblNewLabel_3_1_3.setBounds(382, 86, 48, 14);
		add(lblNewLabel_3_1_3);

		JLabel lblNewLabel_2_1_3 = new JLabel("Đơn giá điện:");
		lblNewLabel_2_1_3.setBounds(382, 36, 85, 14);
		add(lblNewLabel_2_1_3);

		JLabel lblNewLabel_1_1_3 = new JLabel("Đơn giá phòng:");
		lblNewLabel_1_1_3.setBounds(687, 14, 85, 14);
		add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_4_3 = new JLabel("Mã phòng:");
		lblNewLabel_4_3.setBounds(382, 11, 68, 14);
		add(lblNewLabel_4_3);

		JLabel lblNewLabel_3_1_4 = new JLabel("Đơn giá nước:");
		lblNewLabel_3_1_4.setBounds(687, 39, 85, 14);
		add(lblNewLabel_3_1_4);

		JLabel lblNewLabel_2_1_4 = new JLabel("Thành tiền:");
		lblNewLabel_2_1_4.setBounds(687, 114, 85, 14);
		add(lblNewLabel_2_1_4);

		JLabel lblNewLabel_1_1_4 = new JLabel("Thành tiền nước:");
		lblNewLabel_1_1_4.setBounds(687, 89, 85, 14);
		add(lblNewLabel_1_1_4);

		JLabel lblNewLabel_4_4 = new JLabel("Số điện:");
		lblNewLabel_4_4.setBounds(382, 61, 48, 14);
		add(lblNewLabel_4_4);

		txtMaPhieuThu = new JTextField();
		txtMaPhieuThu.setBounds(92, 8, 249, 20);
		add(txtMaPhieuThu);
		txtMaPhieuThu.setColumns(10);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEnabled(false);
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(92, 33, 249, 20);
		add(txtMaNhanVien);

		txtSoDienTruoc = new JTextField();
		txtSoDienTruoc.setEnabled(false);
		txtSoDienTruoc.setColumns(10);
		txtSoDienTruoc.setBounds(92, 61, 249, 20);
		add(txtSoDienTruoc);

		txtSoNuocTruoc = new JTextField();
		txtSoNuocTruoc.setEnabled(false);
		txtSoNuocTruoc.setColumns(10);
		txtSoNuocTruoc.setBounds(92, 86, 249, 20);
		add(txtSoNuocTruoc);

		txtThangThu = new JTextField();
		txtThangThu.setColumns(10);
		txtThangThu.setBounds(92, 111, 249, 20);
		add(txtThangThu);

		txtDonGiaDien = new JTextField();
		txtDonGiaDien.setEnabled(false);
		txtDonGiaDien.setColumns(10);
		txtDonGiaDien.setBounds(451, 33, 189, 20);
		add(txtDonGiaDien);

		txtSoDien = new JTextField();
		txtSoDien.setName("soDien");
		txtSoDien.addKeyListener(ctl);
		txtSoDien.setColumns(10);
		txtSoDien.setBounds(451, 58, 189, 20);
		add(txtSoDien);

		txtSoNuoc = new JTextField();
		txtSoNuoc.setName("soNuoc");
		txtSoNuoc.addKeyListener(ctl);
		txtSoNuoc.setColumns(10);
		txtSoNuoc.setBounds(451, 83, 189, 20);
		add(txtSoNuoc);

		txtTienDichVu = new JTextField();
		txtTienDichVu.setEnabled(false);
		txtTienDichVu.setColumns(10);
		txtTienDichVu.setBounds(451, 108, 189, 20);
		add(txtTienDichVu);

		txtDonGiaPhong = new JTextField();
		txtDonGiaPhong.setEnabled(false);
		txtDonGiaPhong.setColumns(10);
		txtDonGiaPhong.setBounds(778, 11, 189, 20);
		add(txtDonGiaPhong);

		txtDonGiaNuoc = new JTextField();
		txtDonGiaNuoc.setEnabled(false);
		txtDonGiaNuoc.setColumns(10);
		txtDonGiaNuoc.setBounds(778, 36, 189, 20);
		add(txtDonGiaNuoc);

		txtThanhTienDien = new JTextField();
		txtThanhTienDien.setEnabled(false);
		txtThanhTienDien.setColumns(10);
		txtThanhTienDien.setBounds(778, 61, 189, 20);
		add(txtThanhTienDien);

		txtThanhTienNuoc = new JTextField();
		txtThanhTienNuoc.setEnabled(false);
		txtThanhTienNuoc.setColumns(10);
		txtThanhTienNuoc.setBounds(778, 86, 189, 20);
		add(txtThanhTienNuoc);

		txtThanhTien = new JTextField();
		txtThanhTien.setEnabled(false);
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(778, 111, 189, 20);
		add(txtThanhTien);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(92, 136, 249, 69);
		add(txtGhiChu);

		cboMaPhong = new JComboBox();
		cboMaPhong.setActionCommand("cboMaPhong");
		cboMaPhong.addActionListener(ctl);
		cboMaPhong.setBounds(451, 7, 189, 22);
		add(cboMaPhong);

		JLabel lblNewLabel_3_1_1 = new JLabel("Danh sách:");
		lblNewLabel_3_1_1.setBounds(10, 219, 68, 14);
		add(lblNewLabel_3_1_1);

		tblPhieuThuTienPhong = new JTable();
		tblPhieuThuTienPhong.setShowVerticalLines(false);
		tblPhieuThuTienPhong.setSelectionBackground(new Color(255, 128, 0));
		tblPhieuThuTienPhong.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã phiếu thu", "Mã phòng", "Mã nhân viên", "Đơn giá phòng", "Tháng thu",
						"Số điện trước", "Số điện", "Số nước trước", "Số nước", "Đơn giá điện", "Đơn giá nước",
						"Thành tiền điện", "Thành tiền nước", "Tiền dịch vụ", "Thành tiền", "Ghi chú" }));
		tblPhieuThuTienPhong.addMouseListener(ctl);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(10, 549, 89, 23);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(92, 549, 89, 23);
		add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(180, 549, 89, 23);
		add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(266, 549, 89, 23);
		add(btnLamMoi);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(878, 549, 89, 23);
		add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(792, 549, 89, 23);
		add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(704, 549, 89, 23);
		add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(622, 549, 89, 23);
		add(btnFirst);

		JLabel lblNewLabel_2_1_1 = new JLabel("Tìm theo mã:");
		lblNewLabel_2_1_1.setBounds(92, 219, 85, 14);
		add(lblNewLabel_2_1_1);

		txtFind = new JTextField();
		txtFind.setName("maPhongFind");
		txtFind.addKeyListener(ctl);
		txtFind.setColumns(10);
		txtFind.setBounds(161, 216, 180, 20);
		add(txtFind);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 536, 957, 2);
		add(separator);

		JLabel lblNewLabel_2_1_4_1 = new JLabel("Thành tiền:");
		lblNewLabel_2_1_4_1.setIcon(new ImageIcon(Form_PhieuThuTienPhong.class.getResource("/icon/BGPhieuThuP.png")));
		lblNewLabel_2_1_4_1.setBounds(382, 136, 585, 100);
		add(lblNewLabel_2_1_4_1);

		JScrollPane scrollPane = new JScrollPane(tblPhieuThuTienPhong);
		scrollPane.setBounds(10, 247, 957, 278);
		add(scrollPane);

		this.tblPhieuThuTienPhong.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.tblPhieuThuTienPhong.getTableHeader().setOpaque(false);
		this.tblPhieuThuTienPhong.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblPhieuThuTienPhong.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblPhieuThuTienPhong.setRowHeight(25);

		txtThangThu.setText(XDate.dateString(XDate.now()));
		txtMaNhanVien.setText(Auth.user.getMaNhanVien());
		loadComboboxMP();
		loadDataTablePhieuThuTP();
		loadTienDienAndTienNuoc();
		upStatus();
	}

	public void loadTienDienAndTienNuoc() {
		ArrayList<DichVuModel> listD = DichVuDao.getInstance().selectByNameDV("Dien");
		ArrayList<DichVuModel> listN = DichVuDao.getInstance().selectByNameDV("Nuoc");
		DichVuModel dv1 = listD.get(0);
		txtDonGiaDien.setText(dv1.getGiaDichVu() + "");
		DichVuModel dv2 = listN.get(0);
		txtDonGiaNuoc.setText(dv2.getGiaDichVu() + "");

	}

	public void resetForm() {
		txtMaPhieuThu.setText("");
		cboMaPhong.setSelectedIndex(-1);
//		txtDonGiaDien.setText("");
//		txtDonGiaNuoc.setText("");
		txtDonGiaPhong.setText("");
		txtFind.setText("");
		txtGhiChu.setText("");
		txtMaNhanVien.setText(Auth.user.getMaNhanVien());
		txtSoDien.setText("");
		txtSoDienTruoc.setText("0");
		txtSoNuoc.setText("");
		txtSoNuocTruoc.setText("0");
		txtThangThu.setText(XDate.dateString(XDate.now()));
		txtThanhTien.setText("");
		txtThanhTienDien.setText("");
		txtThanhTienNuoc.setText("");
		txtTienDichVu.setText("");
		txtMaPhieuThu.requestFocus();
		tblPhieuThuTienPhong.getSelectionModel().clearSelection();
		count = -1;
		upStatus();
	}

	public void insertTablePhieuThuTienPhong() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaPhieuThu, sb, "Mã phiếu thu null");
		DataValidator.validateEmpty(txtDonGiaDien, sb, "Đơn giá điện null");
		DataValidator.validateEmpty(txtDonGiaNuoc, sb, "Đơn giá nước null");
		DataValidator.validateEmpty(txtDonGiaPhong, sb, "Đơn giá phòng null");
		DataValidator.validateEmpty(txtMaNhanVien, sb, "Mã nhân viên null");
		DataValidator.validateEmpty(txtSoDien, sb, "Số điện null");
		DataValidator.validateEmpty(txtSoDienTruoc, sb, "Số điện trước null");
		DataValidator.validateEmpty(txtSoNuoc, sb, "Số nước null");
		DataValidator.validateEmpty(txtSoNuocTruoc, sb, "Số nước trước null");
		DataValidator.validateDateNow(txtThangThu, sb, "Tháng thu null");
		DataValidator.validateEmpty(txtThanhTien, sb, "Thành tiền null");
		DataValidator.validateEmpty(txtThanhTienDien, sb, "Thành tiền điện null");
		DataValidator.validateEmpty(txtThanhTienNuoc, sb, "Thành tiền nước null");
		DataValidator.validateEmpty(txtTienDichVu, sb, "Tiền dịch null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maPhieuTTP = txtMaPhieuThu.getText();
		String maPhong = cboMaPhong.getSelectedItem() + "";
		String maNhanVien = Auth.user.getMaNhanVien();
		double donGiaPhong = Double.valueOf(txtDonGiaPhong.getText());
		Date thangThu = XDate.dateFormat(txtThangThu.getText());
		double soDienTruoc = Double.valueOf(txtSoDienTruoc.getText());
		double soNuocTruoc = Double.valueOf(txtSoNuocTruoc.getText());
		double soDien = Double.valueOf(txtSoDien.getText());
		double soNuoc = Double.valueOf(txtSoNuoc.getText());
		double donGiaDien = Double.valueOf(txtDonGiaDien.getText());
		double donGiaNuoc = Double.valueOf(txtDonGiaNuoc.getText());
		double thanhTienDien = Double.valueOf(txtThanhTienDien.getText());
		double thanhTienNuoc = Double.valueOf(txtThanhTienNuoc.getText());
		double tienDichVu = Double.valueOf(txtTienDichVu.getText());
		double thanhTien = Double.valueOf(txtThanhTien.getText());
		String ghiChu = txtGhiChu.getText();

		PhieuThuTienPhongModel p = new PhieuThuTienPhongModel(maPhieuTTP, maPhong, maNhanVien, donGiaPhong, thangThu,
				soDienTruoc, soNuocTruoc, soDien, soNuoc, donGiaDien, donGiaNuoc, thanhTienDien, thanhTienNuoc,
				tienDichVu, thanhTien, ghiChu);
		if (PhieuThuTienPhongDao.getInstance().selectByID(p) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (PhieuThuTienPhongDao.getInstance().update(p) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}
		} else {
			if (PhieuThuTienPhongDao.getInstance().insert(p) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
		}
		loadDataTablePhieuThuTP();
	}

	private void loadDataTablePhieuThuTP() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuThuTienPhong.getModel();
		ArrayList<PhieuThuTienPhongModel> list = PhieuThuTienPhongDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (PhieuThuTienPhongModel phieuThuTienPhongModel : list) {
			model_table.addRow(new Object[] { phieuThuTienPhongModel.getMaPhieuTTP(),
					phieuThuTienPhongModel.getMaPhong(), phieuThuTienPhongModel.getMaNhanVien(),
					phieuThuTienPhongModel.getDonGiaPhong(), XDate.dateString(phieuThuTienPhongModel.getThangThu()),
					phieuThuTienPhongModel.getSoDienTruoc(), phieuThuTienPhongModel.getSoDien(),
					phieuThuTienPhongModel.getSoNuocTruoc(), phieuThuTienPhongModel.getSoNuoc(),
					phieuThuTienPhongModel.getDonGiaDien(), phieuThuTienPhongModel.getDonGiaNuoc(),
					phieuThuTienPhongModel.getThanhTienDien(), phieuThuTienPhongModel.getThanhTienNuoc(),
					phieuThuTienPhongModel.getTienDichVu(), phieuThuTienPhongModel.getThanhTien(),
					phieuThuTienPhongModel.getGhiChu(), });
		}

	}

	public void setInformation() {
		try {
			txtSoDienTruoc.setText("0");
			txtSoNuocTruoc.setText("0");
			String giaString = "";
			String maPhong = cboMaPhong.getSelectedItem() + "";
			PhongModel pm = new PhongModel();
			pm.setMaPhong(maPhong);
			PhongModel p = PhongDao.getInstance().selectByID(pm);
			txtDonGiaPhong.setText(p.getGiaPhong() + "");
			List<Object[]> list = ChiTietDichVuDao.getInstance().selectByStoreProc(new ChiTietDichVuModel(maPhong));
			for (Object[] objects : list) {
				giaString += objects[1];
			}
			if (giaString.equals("")) {
				giaString = "0";
			}
			if (!maPhong.equals("")) {
				ArrayList<PhieuThuTienPhongModel> listPTTP = PhieuThuTienPhongDao.getInstance()
						.selectByCondition("maPhong="+"'"+maPhong+"'");
				int size = listPTTP.size();
				PhieuThuTienPhongModel pttp = listPTTP.get(size-1);
				txtSoDienTruoc.setText(pttp.getSoDienTruoc() + "");
				txtSoNuocTruoc.setText(pttp.getSoDienTruoc() + "");
			} 
			txtTienDichVu.setText(giaString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadComboboxMP() {
		ArrayList<PhongModel> list = PhongDao.getInstance().findByTrangThaiIsNotNull();
		cboMaPhong.addItem("");
		for (PhongModel phongModel : list) {
			cboMaPhong.addItem(phongModel.getMaPhong());
		}
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuThuTienPhong.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txtMaPhieuThu.setEditable(!edit);
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
		tblPhieuThuTienPhong.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		tblPhieuThuTienPhong.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblPhieuThuTienPhong.getSelectedRow();
		count = i_row;
		count++;
		if (count > tblPhieuThuTienPhong.getRowCount() - 1) {
			count = tblPhieuThuTienPhong.getRowCount() - 1;
		}
		tblPhieuThuTienPhong.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void displayFormCapNhat() {
		PhieuThuTienPhongModel p = getValuesForm();
		txtMaPhieuThu.setText(p.getMaPhieuTTP());
		cboMaPhong.setSelectedItem(p.getMaPhong());
		txtMaNhanVien.setText(p.getMaNhanVien());
		txtDonGiaPhong.setText(p.getDonGiaPhong() + "");
		txtThangThu.setText(XDate.dateString(p.getThangThu()));
		txtSoDienTruoc.setText(p.getSoDienTruoc() + "");
		txtSoNuocTruoc.setText(p.getSoNuocTruoc() + "");
		txtSoDien.setText(p.getSoDien() + "");
		txtSoNuoc.setText(p.getSoNuoc() + "");
		txtDonGiaDien.setText(p.getDonGiaDien() + "");
		txtDonGiaNuoc.setText(p.getDonGiaNuoc() + "");
		txtThanhTienDien.setText(p.getThanhTienDien() + "");
		txtThanhTienNuoc.setText(p.getThanhTienNuoc() + "");
		txtTienDichVu.setText(p.getTienDichVu() + "");
		txtThanhTien.setText(p.getThanhTien() + "");
		txtGhiChu.setText(p.getGhiChu());

		int i_row = tblPhieuThuTienPhong.getSelectedRow();
		count = i_row;
		upStatus();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuThuTienPhong.getModel();
		count = model_table.getRowCount() - 1;
		tblPhieuThuTienPhong.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public PhieuThuTienPhongModel getValuesForm() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuThuTienPhong.getModel();
		int i_row = tblPhieuThuTienPhong.getSelectedRow();
		String maPhieuTTP = model_table.getValueAt(i_row, 0) + "";
		PhieuThuTienPhongModel p = PhieuThuTienPhongDao.getInstance()
				.selectByID(new PhieuThuTienPhongModel(maPhieuTTP));
		return p;
	}

	public void deleteTablePhieuChi() {
		PhieuThuTienPhongModel p = getValuesForm();
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa?", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		if (PhieuThuTienPhongDao.getInstance().delete(p) > 0) {
			MsgBox.showMessageDialog(this, "Delete success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete fail", "Notification");
		}
		loadDataTablePhieuThuTP();
	}

	public void displaySoDien() {
		double donGiaDien = Double.valueOf(txtDonGiaDien.getText());
		double soDienTruoc = Double.valueOf(txtSoDienTruoc.getText());
		double soDien = Double.valueOf(txtSoDien.getText());
		double sumSoDien = soDien - soDienTruoc;
		txtThanhTienDien.setText(sumSoDien * donGiaDien + "");
		txtThanhTien.setText(String.valueOf(displayTongTien()));
	}

	public void displaySoNuoc() {
		double donGiaNuoc = Double.valueOf(txtDonGiaNuoc.getText());
		double soNuocTruoc = Double.valueOf(txtSoNuocTruoc.getText());
		double soNuoc = Double.valueOf(txtSoNuoc.getText());
		double sumSoNuoc = soNuoc - soNuocTruoc;
		txtThanhTienNuoc.setText(sumSoNuoc * donGiaNuoc + "");
		txtThanhTien.setText(String.valueOf(displayTongTien()));
	}

	public double displayTongTien() {
		double tongTien = 0;
		double tienNuoc = txtThanhTienNuoc.getText() != null ? Double.valueOf(txtThanhTienNuoc.getText()) : 0;
		double tienDien = txtThanhTienDien.getText() != null ? Double.valueOf(txtThanhTienDien.getText()) : 0;
		double tienPhong = txtDonGiaPhong.getText() != null ? Double.valueOf(txtDonGiaPhong.getText()) : 0;
		double tienDichVu = txtTienDichVu.getText() != null ? Double.valueOf(txtTienDichVu.getText()) : 0;
		return tongTien = tienNuoc + tienDien + tienDichVu + tienPhong;
	}

	public void findMaPhong() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuThuTienPhong.getModel();
		String maPhong = txtFind.getText();
		ArrayList<PhieuThuTienPhongModel> list = PhieuThuTienPhongDao.getInstance()
				.selectByCondition("maPhong like '" + maPhong + "%'");
		model_table.setRowCount(0);
		for (PhieuThuTienPhongModel phieuThuTienPhongModel : list) {
			model_table.addRow(new Object[] { phieuThuTienPhongModel.getMaPhieuTTP(),
					phieuThuTienPhongModel.getMaPhong(), phieuThuTienPhongModel.getMaNhanVien(),
					phieuThuTienPhongModel.getDonGiaPhong(), XDate.dateString(phieuThuTienPhongModel.getThangThu()),
					phieuThuTienPhongModel.getSoDienTruoc(), phieuThuTienPhongModel.getSoDien(),
					phieuThuTienPhongModel.getSoNuocTruoc(), phieuThuTienPhongModel.getSoNuoc(),
					phieuThuTienPhongModel.getDonGiaDien(), phieuThuTienPhongModel.getDonGiaNuoc(),
					phieuThuTienPhongModel.getThanhTienDien(), phieuThuTienPhongModel.getThanhTienNuoc(),
					phieuThuTienPhongModel.getTienDichVu(), phieuThuTienPhongModel.getThanhTien(),
					phieuThuTienPhongModel.getGhiChu(), });
		}
	}
}
