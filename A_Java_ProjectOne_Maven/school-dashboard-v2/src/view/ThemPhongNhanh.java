package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;

import controller.ThemPhongNhanhCTL;
import dao.PhongDao;
import dao.ToaNhaDao;
import lib.DataValidator;
import lib.MsgBox;
import model.PhongModel;
import model.ToaNhaModel;
import test.MainFrame;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class ThemPhongNhanh extends JPanel {
	private JTextField txtTuPhong;
	private JTextField txtDienTich;
	private JTextField txtDenPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoLNguoi;
	private JTextField txtMaPhong;
	private JTextArea txtMoTa;
	private JTextField txtTang;
	private JTextField txtLoaiPhong;
	private MainFrame mainFrame = new MainFrame();
	private JComboBox cboMaToaNha;

	/**
	 * Create the panel.
	 */
	public ThemPhongNhanh() {
		ThemPhongNhanhCTL ctl = new ThemPhongNhanhCTL(this);
		setBackground(new Color(227, 227, 227));
		setForeground(new Color(0, 0, 255));
		setBounds(0, 0, 735, 555);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Từ phòng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(10, 11, 78, 21);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Đến phòng:");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(158, 11, 140, 21);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mã tòa nhà:");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 69, 78, 21);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Giá phòng:");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(158, 69, 140, 21);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Diện tích:");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 122, 78, 21);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Số L.Người");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(158, 122, 140, 21);
		add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Mô tả:");
		lblNewLabel_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(308, 69, 78, 21);
		add(lblNewLabel_6);

		txtTuPhong = new JTextField();
		txtTuPhong.setBounds(10, 38, 138, 20);
		add(txtTuPhong);
		txtTuPhong.setColumns(10);

		txtDienTich = new JTextField();
		txtDienTich.setColumns(10);
		txtDienTich.setBounds(10, 154, 138, 20);
		add(txtDienTich);

		txtDenPhong = new JTextField();
		txtDenPhong.setColumns(10);
		txtDenPhong.setBounds(158, 38, 140, 20);
		add(txtDenPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(158, 91, 140, 20);
		add(txtGiaPhong);

		txtSoLNguoi = new JTextField();
		txtSoLNguoi.setColumns(10);
		txtSoLNguoi.setBounds(158, 154, 140, 20);
		add(txtSoLNguoi);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(308, 91, 399, 146);
		add(txtMoTa);

		JLabel lblNewLabel_4_1 = new JLabel("Mã phòng:");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(10, 185, 103, 21);
		add(lblNewLabel_4_1);

		txtMaPhong = new JTextField();
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(10, 217, 138, 20);
		add(txtMaPhong);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(10, 521, 68, 23);
		add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(74, 521, 68, 23);
		add(btnXoa);

		JButton btnNew = new JButton("Làm mới");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(139, 521, 78, 23);
		add(btnNew);

		JLabel lblNewLabel_4_1_1 = new JLabel("Tầng:");
		lblNewLabel_4_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1.setBounds(158, 185, 140, 21);
		add(lblNewLabel_4_1_1);

		txtTang = new JTextField();
		txtTang.setColumns(10);
		txtTang.setBounds(158, 217, 140, 20);
		add(txtTang);

		JLabel lblNewLabel_4_1_2 = new JLabel("Loại phòng:");
		lblNewLabel_4_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_2.setBounds(308, 6, 103, 21);
		add(lblNewLabel_4_1_2);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(308, 38, 399, 20);
		add(txtLoaiPhong);

		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(ThemPhongNhanh.class.getResource("/icon/my project (1).png")));
		lblNewLabel_7.setBounds(10, 263, 697, 217);
		add(lblNewLabel_7);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 248, 703, 21);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 499, 703, 21);
		add(separator_1);
		
		 cboMaToaNha = new JComboBox();
		cboMaToaNha.setBounds(10, 90, 138, 22);
		add(cboMaToaNha);
		
		loadComboboxMaToaNha();
	}
	
	public void loadComboboxMaToaNha() {
		ArrayList<ToaNhaModel> list = ToaNhaDao.getInstance().selectAll();
		cboMaToaNha.addItem("");
		for (ToaNhaModel toaNhaModel : list) {
			cboMaToaNha.addItem(toaNhaModel.getMaToaNha());
		}
	}

	public void insertTablePhong() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtTuPhong, sb, "Từ phòng null");
		DataValidator.validateEmpty(txtDenPhong, sb, "Đến phòng null");
		DataValidator.validateCombobox(cboMaToaNha, sb, "Chưa chọn mã tòa nhà");
		DataValidator.validateEmpty(txtGiaPhong, sb, "Giá phòng null");
		DataValidator.validateEmpty(txtDienTich, sb, "Diện tích null");
		DataValidator.validateEmpty(txtSoLNguoi, sb, "Số lượng người null");
		DataValidator.validateEmpty(txtMaPhong, sb, "Mã phòng null");
		DataValidator.validateEmpty(txtTang, sb, "Tầng null");
		DataValidator.validateEmpty(txtLoaiPhong, sb, "Loại phòng null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(mainFrame, sb.toString(), "Notification");
			return;
		}
		int tuPhong = Integer.valueOf(txtTuPhong.getText());
		int denPhong = Integer.valueOf(txtDenPhong.getText());
		String maToaNha = cboMaToaNha.getSelectedItem()+"";
		double giaPhong = Double.valueOf(txtGiaPhong.getText());
		double dienTich = Double.valueOf(txtDienTich.getText());
		int soLuongNguoi = Integer.valueOf(txtSoLNguoi.getText());
		String maPhong = txtMaPhong.getText();
		int tang = Integer.valueOf(txtTang.getText());
		String moTa = txtMoTa.getText();
		String loaiPhong = txtLoaiPhong.getText();
		PhongModel pm = new PhongModel();
		pm.setMaPhong(maPhong + tuPhong);
		if (PhongDao.getInstance().selectByID(pm) == null) {
			for (int i = tuPhong; i <= denPhong; i++) {
				PhongModel pmd = new PhongModel();
				pmd.setMaPhong(maPhong + i);
				pmd.setMaToaNha(maToaNha);
				pmd.setGiaPhong(giaPhong);
				pmd.setDienTich(dienTich);
				pmd.setSoLuongNguoi(soLuongNguoi);
				pmd.setTang(tang);
				pmd.setMoTa(moTa);
				pmd.setLoaiPhong(loaiPhong);
				PhongDao.getInstance().insert(pmd);
			}
			MsgBox.showMessageDialog(mainFrame, "Insert success", "Notification");
		} else {
			MsgBox.showErrorDialog(mainFrame, "Insert fail", "Notification");
		}
	}

	public void deleteTablePhong() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtTuPhong, sb, "Từ phòng null");
		DataValidator.validateEmpty(txtDenPhong, sb, "Đến phòng null");
		DataValidator.validateCombobox(cboMaToaNha, sb, "Chưa chọn mã tòa nhà");
		DataValidator.validateEmpty(txtMaPhong, sb, "Mã phòng null");

		if (sb.length() > 0) {
			MsgBox.showErrorDialog(mainFrame, sb.toString(), "Notification");
			return;
		}
		int tuPhong = Integer.valueOf(txtTuPhong.getText());
		int denPhong = Integer.valueOf(txtDenPhong.getText());
		String maToaNha = cboMaToaNha.getSelectedItem()+"";
		String maPhong = txtMaPhong.getText();
		int count = 0;
		for (int i = tuPhong; i <= denPhong; i++) {
			PhongModel pmd = new PhongModel();
			pmd.setMaPhong(maPhong + i);
			pmd.setMaToaNha(maToaNha);
			PhongDao.getInstance().delete(pmd);
			count++;
		}
		if (count > 0) {
			MsgBox.showMessageDialog(mainFrame, "Delete success", "Notification");
		} else {
			MsgBox.showMessageDialog(mainFrame, "Delete fail", "Notification");
		}
	}

	public void resetForm() {
		this.txtDenPhong.setText("");
		this.txtDienTich.setText("");
		this.txtGiaPhong.setText("");
		this.txtLoaiPhong.setText("");
		this.txtMaPhong.setText("");
		this.cboMaToaNha.setSelectedIndex(-1);
		this.txtMoTa.setText("");
		this.txtSoLNguoi.setText("");
		this.txtTang.setText("");
		this.txtTuPhong.setText("");
		this.txtTuPhong.requestFocus();
	}

}
