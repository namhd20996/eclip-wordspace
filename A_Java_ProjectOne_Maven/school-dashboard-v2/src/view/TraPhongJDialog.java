package view;

import java.awt.BorderLayout;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.TraPhongJDialogCTL;
import dao.ChiTietDichVuDao;
import dao.LichSuPhongThueDao;
import dao.NguoiThuePhongDao;
import dao.PhongDao;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import model.ChiTietDichVuModel;
import model.LichSuPhongThueModel;
import model.NguoiThuePhongModel;
import model.PhongModel;

public class TraPhongJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMaNguoiThue;
	private JTextField txtSoCCCDNT;
	private JTextField txtMaPhong;
	private JTextField txtNgayTra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TraPhongJDialog dialog = new TraPhongJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TraPhongJDialog() {
		TraPhongJDialogCTL ctl = new TraPhongJDialogCTL(this);
		setBounds(100, 100, 362, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã người thuê:");
		lblNewLabel.setBounds(10, 22, 92, 14);
		contentPanel.add(lblNewLabel);

		txtMaNguoiThue = new JTextField();
		txtMaNguoiThue.setBounds(93, 21, 247, 20);
		contentPanel.add(txtMaNguoiThue);
		txtMaNguoiThue.setColumns(10);

		JLabel lblSocccdnt = new JLabel("SoCCCDNT:");
		lblSocccdnt.setBounds(10, 47, 92, 14);
		contentPanel.add(lblSocccdnt);

		txtSoCCCDNT = new JTextField();
		txtSoCCCDNT.setColumns(10);
		txtSoCCCDNT.setBounds(93, 47, 247, 20);
		contentPanel.add(txtSoCCCDNT);

		JLabel lblMPhng = new JLabel("Mã phòng:");
		lblMPhng.setBounds(10, 72, 92, 14);
		contentPanel.add(lblMPhng);

		txtMaPhong = new JTextField();
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(93, 72, 247, 20);
		contentPanel.add(txtMaPhong);

		JLabel lblNgyTr = new JLabel("Ngày trả:");
		lblNgyTr.setBounds(10, 100, 92, 14);
		contentPanel.add(lblNgyTr);

		txtNgayTra = new JTextField();
		txtNgayTra.setColumns(10);
		txtNgayTra.setBounds(93, 97, 247, 20);
		contentPanel.add(txtNgayTra);

		JButton btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.addActionListener(ctl);
		btnTraPhong.setBounds(251, 140, 89, 23);
		contentPanel.add(btnTraPhong);

		String now = XDate.dateString(XDate.now());
		txtNgayTra.setText(now);
		setLocationRelativeTo(null);
	}

	public void displayMaNguoiThue(String maNguoiThue) {
		try {
			System.out.println(maNguoiThue);
			txtMaNguoiThue.setText(maNguoiThue);
			NguoiThuePhongModel nt = new NguoiThuePhongModel();
			nt.setMaNguoiThue(maNguoiThue);
			NguoiThuePhongModel ntd = NguoiThuePhongDao.getInstance().selectByID(nt);
			txtMaPhong.setText(ntd.getMaPhong());
			txtSoCCCDNT.setText(ntd.getSoCCCDNT());
		} catch (Exception e) {
		}
	}

	public void displayTraPhong() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateIsID(txtMaNguoiThue, sb, "Mã người thuê null");
			DataValidator.validateEmpty(txtMaPhong, sb, "Mã phòng null");
			DataValidator.validateSoCCCD(txtSoCCCDNT, sb, "Số CCCD null");
			DataValidator.validateDateNow(txtNgayTra, sb, "Ngày trả null");
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Notificaiton");
				return;
			}
			String maNguoiThue = txtMaNguoiThue.getText();
			String maPhong = txtMaPhong.getText();
			String soCCCDNT = txtSoCCCDNT.getText();
			Date ngayTra = XDate.dateFormat(txtNgayTra.getText());
			NguoiThuePhongModel nt = new NguoiThuePhongModel();
			nt.setMaNguoiThue(maNguoiThue);
			nt.setMaPhong("Null");
			if (NguoiThuePhongDao.getInstance().updateTraPhong(nt) > 0) {
				LichSuPhongThueModel ls = new LichSuPhongThueModel();
				ls.setMaNguoiThue(maNguoiThue);
				ls.setNgayTraPhong(ngayTra);
				LichSuPhongThueDao.getInstance().update(ls);
				ChiTietDichVuModel ct = new ChiTietDichVuModel();
				ct.setMaPhong(maPhong);
				ChiTietDichVuDao.getInstance().delete(ct);
				PhongModel p = new PhongModel();
				p.setMaPhong(maPhong);
				p.setTrangThai(null);
				PhongDao.getInstance().updateInformation(p);
				MsgBox.showMessageDialog(this, "Trả phòng success", "Notificaiton");
			} else {
				MsgBox.showMessageDialog(this, "Trả phòng fail", "Notificaiton");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
