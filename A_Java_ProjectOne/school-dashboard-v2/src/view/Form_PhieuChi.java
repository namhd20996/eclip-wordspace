package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controller.Form_PhieuChiCTL;
import dao.PhieuChiDao;
import dao.PhongDao;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import model.PhieuChiModel;
import model.PhongModel;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Form_PhieuChi extends JPanel {
	private JTextField txtMaPhieuChi;
	private JTextField txtTongTien;
	private JTextField txtHinhThuc;
	private JTextField txtTenPhieuChi;
	private JTextField txtMaNhanVien;
	private JTextField txtNgayLap;
	private JTable tblPhieuChi;
	private JTextField txtFind;
	private int count = 0;
	private JButton btnFirst;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnLamMoi;

	private JButton btnThem;
	private JTextArea txtGhiChu;
	private JButton btnXoa;
	private JButton btnSua;
	private JComboBox cboMaPhong;

	/**
	 * Create the panel.
	 */
	public Form_PhieuChi() {
		Form_PhieuChiCTL ctl = new Form_PhieuChiCTL(this);
		setBounds(0, 11, 1200, 920);
		setBackground(new Color(227, 227, 227));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã phiếu chi:");
		lblNewLabel.setBounds(10, 11, 78, 14);
		add(lblNewLabel);

		JLabel lblTnPhiuChi = new JLabel("Tên phiếu chi:");
		lblTnPhiuChi.setBounds(301, 11, 78, 14);
		add(lblTnPhiuChi);

		JLabel lblMPhng = new JLabel("Mã phòng:");
		lblMPhng.setBounds(10, 36, 78, 14);
		add(lblMPhng);

		JLabel lblMNhnVin = new JLabel("Mã nhân viên:");
		lblMNhnVin.setBounds(301, 36, 78, 14);
		add(lblMNhnVin);

		JLabel lblNewLabel_3_1 = new JLabel("Tổng tiền:");
		lblNewLabel_3_1.setBounds(10, 61, 78, 14);
		add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Ngày lập phiếu:");
		lblNewLabel_3_2.setBounds(301, 61, 78, 14);
		add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Hình thức:");
		lblNewLabel_3_3.setBounds(10, 86, 78, 14);
		add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("Danh sách:");
		lblNewLabel_3_4.setBounds(10, 212, 78, 14);
		add(lblNewLabel_3_4);

		JLabel lblNewLabel_3_5 = new JLabel("Ghi chú:");
		lblNewLabel_3_5.setBounds(10, 111, 48, 14);
		add(lblNewLabel_3_5);

		JLabel lblNewLabel_3_6 = new JLabel("New label");
		lblNewLabel_3_6.setIcon(new ImageIcon(Form_PhieuChi.class.getResource("/icon/BGPhieuChi.png")));
		lblNewLabel_3_6.setBounds(592, 8, 362, 218);
		add(lblNewLabel_3_6);

		txtMaPhieuChi = new JTextField();
		txtMaPhieuChi.setBounds(77, 8, 193, 20);
		add(txtMaPhieuChi);
		txtMaPhieuChi.setColumns(10);

		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(77, 58, 193, 20);
		add(txtTongTien);

		txtHinhThuc = new JTextField();
		txtHinhThuc.setColumns(10);
		txtHinhThuc.setBounds(77, 83, 193, 20);
		add(txtHinhThuc);

		txtTenPhieuChi = new JTextField();
		txtTenPhieuChi.setColumns(10);
		txtTenPhieuChi.setBounds(389, 8, 193, 20);
		add(txtTenPhieuChi);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(389, 33, 193, 20);
		add(txtMaNhanVien);

		txtNgayLap = new JTextField();
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(389, 58, 193, 20);
		add(txtNgayLap);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(77, 106, 505, 85);
		add(txtGhiChu);

		cboMaPhong = new JComboBox();
		cboMaPhong.setBounds(77, 32, 193, 22);
		add(cboMaPhong);

		tblPhieuChi = new JTable();
		tblPhieuChi.setShowVerticalLines(false);
		tblPhieuChi.setSelectionBackground(new Color(255, 128, 0));
		tblPhieuChi.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã phiếu chi", "Tên phiếu chi",
				"Mã phòng", "Mã nhân viên", "Tổng tiền", "Ngày lập", "Hình thức", "Ghi chú" }));
		tblPhieuChi.addMouseListener(ctl);

		JLabel lblNewLabel_3_3_1 = new JLabel("Tìm theo mã:");
		lblNewLabel_3_3_1.setBounds(301, 209, 78, 14);
		add(lblNewLabel_3_3_1);

		txtFind = new JTextField();
		txtFind.setColumns(10);
		txtFind.setBounds(389, 206, 193, 20);
		add(txtFind);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(77, 543, 89, 23);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(163, 543, 89, 23);
		add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(249, 543, 89, 23);
		add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(336, 543, 89, 23);
		add(btnLamMoi);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(865, 543, 89, 23);
		add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(778, 543, 89, 23);
		add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(692, 543, 89, 23);
		add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(606, 543, 89, 23);
		add(btnFirst);

		JScrollPane scrollPane = new JScrollPane(tblPhieuChi);
		scrollPane.setBounds(77, 237, 877, 286);
		add(scrollPane);

		this.tblPhieuChi.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.tblPhieuChi.getTableHeader().setOpaque(false);
		this.tblPhieuChi.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblPhieuChi.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblPhieuChi.setRowHeight(25);

		txtNgayLap.setText(XDate.dateString(XDate.now()));
		upStatus();
		loadDataTablePhieuChi();
		loadComboboxMP();
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuChi.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txtMaPhieuChi.setEditable(!edit);
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
		tblPhieuChi.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		tblPhieuChi.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblPhieuChi.getSelectedRow();
		count = i_row;
		count++;
		if (count > tblPhieuChi.getRowCount() - 1) {
			count = tblPhieuChi.getRowCount() - 1;
		}
		tblPhieuChi.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void displayFormCapNhat() {
		PhieuChiModel p = getValuesForm();
		txtGhiChu.setText(p.getGhiChu());
		txtHinhThuc.setText(p.getHinhThuc());
		txtMaNhanVien.setText(p.getMaNhanVien());
		txtMaPhieuChi.setText(p.getMaPhieuChi());
		txtNgayLap.setText(XDate.dateString(p.getNgayLap()));
		txtTenPhieuChi.setText(p.getTenPhieuChi());
		txtTongTien.setText(p.getTongTien() + "");
		txtMaPhieuChi.requestFocus();
		int i_row = tblPhieuChi.getSelectedRow();
		count = i_row;
		upStatus();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuChi.getModel();
		count = model_table.getRowCount() - 1;
		tblPhieuChi.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public PhieuChiModel getValuesForm() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuChi.getModel();
		int i_row = tblPhieuChi.getSelectedRow();
		String maPhieuChi = model_table.getValueAt(i_row, 0) + "";
		PhieuChiModel p = PhieuChiDao.getInstance().selectByID(new PhieuChiModel(maPhieuChi));
		return p;
	}

	public void deleteTablePhieuChi() {
		PhieuChiModel p = getValuesForm();
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa?", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		if (PhieuChiDao.getInstance().delete(p) > 0) {
			MsgBox.showMessageDialog(this, "Delete success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete fail", "Notification");
		}
		loadDataTablePhieuChi();
	}

	public void resetForm() {
		txtFind.setText("");
		txtHinhThuc.setText("");
		txtMaNhanVien.setText("");
		txtMaPhieuChi.setText("");
		txtNgayLap.setText("");
		txtTenPhieuChi.setText("");
		txtTongTien.setText("");
		txtGhiChu.setText("");
		cboMaPhong.setSelectedIndex(-1);
		txtMaPhieuChi.requestFocus();
		tblPhieuChi.getSelectionModel().clearSelection();
		count = -1;
		upStatus();
	}

	public void insertTablePhieuChi() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaPhieuChi, sb, "Mã phiếu chi null");
		DataValidator.validateEmpty(txtTenPhieuChi, sb, "Tên phiếu chi null");
		DataValidator.validateCombobox(cboMaPhong, sb, "Chưa chọn mã phòng");
		DataValidator.validateIsID(txtMaNhanVien, sb, "Mã nhân viên null");
		DataValidator.validateEmpty(txtTongTien, sb, "Tổng tiền null");
		DataValidator.validateDateNow(txtNgayLap, sb, "Ngày lập null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maPhieuChi = txtMaPhieuChi.getText();
		String maPhong = cboMaPhong.getSelectedItem() + "";
		String tenPhieuChi = txtTenPhieuChi.getText();
		String maNhanVien = Auth.user.getMaNhanVien();
		double tongTien = Double.valueOf(txtTongTien.getText());
		Date ngayLap = XDate.dateFormat(txtNgayLap.getText());
		String hinhThuc = txtHinhThuc.getText();
		String ghiChu = txtGhiChu.getText();

		PhieuChiModel p = new PhieuChiModel(maPhieuChi, maPhong, maNhanVien, tenPhieuChi, tongTien, ngayLap, hinhThuc,
				ghiChu);

		if (PhieuChiDao.getInstance().selectByID(p) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật?", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (PhieuChiDao.getInstance().update(p) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}
		} else {
			if (PhieuChiDao.getInstance().insert(p) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
			loadDataTablePhieuChi();
		}
	}

	public void loadDataTablePhieuChi() {
		DefaultTableModel model_table = (DefaultTableModel) tblPhieuChi.getModel();
		ArrayList<PhieuChiModel> list = PhieuChiDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (PhieuChiModel phieuChiModel : list) {
			model_table.addRow(new Object[] { phieuChiModel.getMaPhieuChi(), phieuChiModel.getTenPhieuChi(),
					phieuChiModel.getMaPhong(), phieuChiModel.getMaNhanVien(), phieuChiModel.getTongTien(),
					XDate.dateString(phieuChiModel.getNgayLap()), phieuChiModel.getHinhThuc(),
					phieuChiModel.getGhiChu(), });
		}
	}

	public void loadComboboxMP() {
		try {
			ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
			cboMaPhong.addItem("");
			for (PhongModel phongModel : list) {
//				System.out.println(phongModel.getMaPhong());
				cboMaPhong.addItem(phongModel.getMaPhong());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
