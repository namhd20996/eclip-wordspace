package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SuaPhongJDialogCTL;
import dao.PhongDao;
import lib.DataValidator;
import lib.MsgBox;
import model.PhongModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class SuaPhongJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtLoaiPhong;
	private JTextField txtSoLNguoi;
	private JTextField txtTrangThai;
	private JTextField txtDienTich;
	private JTextField txtGiaPhong;
	private JTextField txtTang;
	private JComboBox cboMaPhong;
	private JTextArea txtGhiChu;
	private JTextArea txtMoTa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SuaPhongJDialog dialog = new SuaPhongJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SuaPhongJDialog() {
		SuaPhongJDialogCTL ctl = new SuaPhongJDialogCTL(this);
		setBounds(100, 100, 533, 283);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã phòng:");
		lblNewLabel.setBounds(10, 11, 80, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblLoiPhng = new JLabel("Loại phòng:");
		lblLoiPhng.setBounds(263, 10, 64, 14);
		contentPanel.add(lblLoiPhng);

		JLabel lblTng = new JLabel("Tầng:");
		lblTng.setBounds(369, 39, 64, 14);
		contentPanel.add(lblTng);

		JLabel lblSLngi = new JLabel("Số L.Người:");
		lblSLngi.setBounds(10, 39, 64, 14);
		contentPanel.add(lblSLngi);

		JLabel lblDinTch = new JLabel("Diện tích:");
		lblDinTch.setBounds(172, 39, 56, 14);
		contentPanel.add(lblDinTch);

		JLabel lblGiPhng = new JLabel("Giá phòng:");
		lblGiPhng.setBounds(263, 65, 64, 14);
		contentPanel.add(lblGiPhng);

		JLabel lblMT = new JLabel("Mô tả:");
		lblMT.setBounds(10, 95, 48, 14);
		contentPanel.add(lblMT);

		JLabel lblTrngThi = new JLabel("Trạng thái:");
		lblTrngThi.setBounds(10, 64, 64, 14);
		contentPanel.add(lblTrngThi);

		JLabel lblGhiCh = new JLabel("Ghi chú:");
		lblGhiCh.setBounds(263, 95, 48, 14);
		contentPanel.add(lblGhiCh);

		cboMaPhong = new JComboBox();
		cboMaPhong.setBounds(73, 7, 180, 22);
		contentPanel.add(cboMaPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setBounds(326, 7, 180, 20);
		contentPanel.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		txtSoLNguoi = new JTextField();
		txtSoLNguoi.setColumns(10);
		txtSoLNguoi.setBounds(73, 36, 89, 20);
		contentPanel.add(txtSoLNguoi);

		txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(73, 64, 180, 20);
		contentPanel.add(txtTrangThai);

		txtMoTa = new JTextArea();
		txtMoTa.setBounds(73, 95, 180, 69);
		contentPanel.add(txtMoTa);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(326, 95, 180, 69);
		contentPanel.add(txtGhiChu);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(ctl);
		btnCapNhat.setBounds(73, 193, 89, 23);
		contentPanel.add(btnCapNhat);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(164, 193, 89, 23);
		contentPanel.add(btnLamMoi);

		txtDienTich = new JTextField();
		txtDienTich.setColumns(10);
		txtDienTich.setBounds(263, 36, 80, 20);
		contentPanel.add(txtDienTich);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(326, 64, 180, 20);
		contentPanel.add(txtGiaPhong);

		txtTang = new JTextField();
		txtTang.setColumns(10);
		txtTang.setBounds(417, 36, 89, 20);
		contentPanel.add(txtTang);

		cboMaPhong.setEnabled(false);
		loadComboboxMaPhong();
		setLocationRelativeTo(null);
	}

	public void loadComboboxMaPhong() {
		ArrayList<PhongModel> list = PhongDao.getInstance().selectAll();
		cboMaPhong.addItem("");
		for (PhongModel phongModel : list) {
			cboMaPhong.addItem(phongModel.getMaPhong());
		}
	}

	public void displaySuaPhong(String maPhong) {
		cboMaPhong.setSelectedItem(maPhong);
		PhongModel p = new PhongModel();
		p.setMaPhong(maPhong);
		PhongModel pd = PhongDao.getInstance().selectByID(p);
		txtLoaiPhong.setText(pd.getLoaiPhong());
		txtDienTich.setText(pd.getDienTich() + "");
		txtGiaPhong.setText(pd.getGiaPhong() + "");
		txtSoLNguoi.setText(pd.getSoLuongNguoi() + "");
		txtTang.setText(pd.getTang() + "");
		txtGhiChu.setText(pd.getGhiChu());
		txtMoTa.setText(pd.getGhiChu());
		txtTrangThai.setText(pd.getTrangThai());
	}

	public void updateTablePhong() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateEmpty(txtLoaiPhong, sb, "Loại phòng null");
		DataValidator.validateEmpty(txtDienTich, sb, "Diện tích null");
		DataValidator.validateEmpty(txtGiaPhong, sb, "Giá phòng null");
		DataValidator.validateEmpty(txtSoLNguoi, sb, "Số lượng người null");
		DataValidator.validateEmpty(txtTang, sb, "Tầng null");
		DataValidator.validateEmpty(txtTrangThai, sb, "Trạng thái null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maPhong = cboMaPhong.getSelectedItem() + "";
		String loaiPhong = txtLoaiPhong.getText();
		double dienTich = Double.valueOf(txtDienTich.getText());
		double giaPhong = Double.valueOf(txtGiaPhong.getText());
		int soLuongNguoi = Integer.valueOf(txtSoLNguoi.getText());
		String trangThai = txtTrangThai.getText();
		int tang = Integer.valueOf(txtTang.getText());
		String moTa = txtMoTa.getText();
		String ghiChu = txtGhiChu.getText();
		PhongModel p = new PhongModel();
		p.setMaPhong(maPhong);
		p.setLoaiPhong(loaiPhong);
		p.setDienTich(dienTich);
		p.setGhiChu(ghiChu);
		p.setLoaiPhong(loaiPhong);
		p.setMoTa(moTa);
		p.setGhiChu(ghiChu);
		p.setSoLuongNguoi(soLuongNguoi);
		p.setGiaPhong(giaPhong);
		if (PhongDao.getInstance().updateSuaPhong(p) > 0) {
			MsgBox.showMessageDialog(this, "Update success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Update fail", "Notification");
		}
	}

	public void resetForm() {
		txtLoaiPhong.setText("");
		txtDienTich.setText("");
		txtGiaPhong.setText("");
		txtSoLNguoi.setText("");
		txtTang.setText("");
		txtGhiChu.setText("");
		txtMoTa.setText("");
		txtTrangThai.setText("");
	}
}
