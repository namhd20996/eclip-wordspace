package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import controller.ThemPhongNhanhCTL;
import dao.PhongDao;
import lib.DataValidator;
import lib.MsgBox;
import model.PhongModel;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;

public class ThemPhongNhanh extends JPanel {
	private JTextField txtTuPhong;
	private JTextField txtMaToaNha;
	private JTextField txtDienTich;
	private JTextField txtDenPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoLNguoi;
	private JTextField txtMaPhong;
	private JTextArea txtMoTa;
	private JTextField txtTang;
	private JTextField txtLoaiPhong;

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
		lblNewLabel_1.setBounds(342, 11, 78, 21);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Mã tòa nhà:");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 69, 78, 21);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Giá phòng:");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(342, 69, 78, 21);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Diện tích:");
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 122, 78, 21);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Số L.Người");
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(342, 122, 78, 21);
		add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Mô tả:");
		lblNewLabel_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(10, 305, 78, 21);
		add(lblNewLabel_6);

		txtTuPhong = new JTextField();
		txtTuPhong.setBounds(10, 38, 273, 20);
		add(txtTuPhong);
		txtTuPhong.setColumns(10);

		txtMaToaNha = new JTextField();
		txtMaToaNha.setColumns(10);
		txtMaToaNha.setBounds(10, 91, 273, 20);
		add(txtMaToaNha);

		txtDienTich = new JTextField();
		txtDienTich.setColumns(10);
		txtDienTich.setBounds(10, 154, 273, 20);
		add(txtDienTich);

		txtDenPhong = new JTextField();
		txtDenPhong.setColumns(10);
		txtDenPhong.setBounds(342, 38, 383, 20);
		add(txtDenPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(342, 91, 383, 20);
		add(txtGiaPhong);

		txtSoLNguoi = new JTextField();
		txtSoLNguoi.setColumns(10);
		txtSoLNguoi.setBounds(342, 154, 383, 20);
		add(txtSoLNguoi);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(10, 329, 715, 215);
		add(txtMoTa);

		JLabel lblNewLabel_4_1 = new JLabel("Mã phòng:");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(10, 185, 103, 21);
		add(lblNewLabel_4_1);

		txtMaPhong = new JTextField();
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(10, 217, 273, 20);
		add(txtMaPhong);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(342, 277, 68, 23);
		add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(439, 277, 68, 23);
		add(btnSua);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(534, 277, 68, 23);
		add(btnXoa);

		JButton btnNew = new JButton("Làm mới");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(636, 277, 89, 23);
		add(btnNew);

		JLabel lblNewLabel_4_1_1 = new JLabel("Tầng:");
		lblNewLabel_4_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_1.setBounds(342, 185, 103, 21);
		add(lblNewLabel_4_1_1);

		txtTang = new JTextField();
		txtTang.setColumns(10);
		txtTang.setBounds(342, 217, 383, 20);
		add(txtTang);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Loại phòng:");
		lblNewLabel_4_1_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1_2.setBounds(10, 248, 103, 21);
		add(lblNewLabel_4_1_2);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(10, 280, 273, 20);
		add(txtLoaiPhong);
	}

	public void insertTablePhong() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtTuPhong, sb, "Từ phòng null");
		DataValidator.validateEmpty(txtDenPhong, sb, "Đến phòng null");
		DataValidator.validateEmpty(txtMaToaNha, sb, "Mã tòa nhà null");
		DataValidator.validateEmpty(txtGiaPhong, sb, "Giá phòng null");
		DataValidator.validateEmpty(txtDienTich, sb, "Diện tích null");
		DataValidator.validateEmpty(txtSoLNguoi, sb, "Số lượng người null");
		DataValidator.validateEmpty(txtMaPhong, sb, "Mã phòng null");
		DataValidator.validateEmpty(txtTang, sb, "Tầng null");
		DataValidator.validateEmpty(txtLoaiPhong, sb, "Loại phòng null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		int tuPhong = Integer.valueOf(txtTuPhong.getText());
		int denPhong = Integer.valueOf(txtDenPhong.getText());
		String maToaNha = txtMaToaNha.getText();
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
			MsgBox.showMessageDialog(this, "Insert success", "Notification");
		} else {
			MsgBox.showErrorDialog(this, "Insert fail", "Notification");
		}
	}
}
