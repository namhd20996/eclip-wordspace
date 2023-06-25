
package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import controller.PhongDonCTL;
import dao.PhongDao;
import lib.MsgBox;
import model.PhongModel;
import test.MainFrame;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;

public class PhongDon extends javax.swing.JPanel {

	private javax.swing.JButton btnTra;
	private javax.swing.JButton btnXem;
	private javax.swing.JButton btnSua;
	private javax.swing.JButton btnXoa;
	private javax.swing.JLabel lblPhong;
	private javax.swing.JLabel lblIMG;
	private javax.swing.JLabel lblHoTen;
	private javax.swing.JLabel lblGia;

	// Taoj biến sét cho phòng
	private String hoTen;
	private String gia;
	private Icon image;
	private String maPhong;
	private JButton btnThemKhach;
	private String trangThai;
	private String tang;
	private JLabel lblTang;
	private String maNguoiThue;
	private MainFrame mainFrame = new MainFrame();

	public PhongDon() {
		initComponents();
		btnXem.setVisible(false);
		btnTra.setVisible(false);
	}

	public String getMaNguoiThue() {
		return maNguoiThue;
	}

	public void setMaNguoiThue(String maNguoiThue) {
		this.maNguoiThue = maNguoiThue;
	}

	public String getTang() {
		return tang;
	}

	public void setTang(String tang) {
		this.tang = tang;
		lblTang.setText("Tầng: " + tang);
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
		try {
			if (trangThai == null) {
				setBackground(new Color(0, 128, 255));
			}
			if (trangThai.equals("Đang thuê")) {
				btnThemKhach.setVisible(false);
				btnXem.setVisible(true);
				btnTra.setVisible(true);
				setBackground(Color.YELLOW);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
		lblHoTen.setText("Họ tên: " + hoTen);
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
		lblGia.setText("Giá: " + gia);
	}

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
		lblIMG.setIcon(image);
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
		lblPhong.setText("Phòng: " + maPhong);
	}

	public void displayUpdatePhong() {
		ThemNguoiThueJDialog updatePhongJDialog = new ThemNguoiThueJDialog();
		updatePhongJDialog.displayMaPhong(maPhong);
		updatePhongJDialog.setModal(true);
		updatePhongJDialog.setVisible(true);
	}

	public void displayTraPhong() {
		TraPhongJDialog traPhongJDialog = new TraPhongJDialog();
		traPhongJDialog.displayMaNguoiThue(maNguoiThue);
		traPhongJDialog.setModal(true);
		traPhongJDialog.setVisible(true);
	}

	public void displayXemPhong() {
		ThemNguoiThueJDialog updatePhongJDialog = new ThemNguoiThueJDialog();
		updatePhongJDialog.displayNguoiThue(maNguoiThue);
		updatePhongJDialog.setModal(true);
		updatePhongJDialog.setVisible(true);
	}

	public void displayXoaPhong() {
		try {
			if (MsgBox.showConfirmDialog(mainFrame, "Bạn muốn xóa Phòng " + maPhong,
					"Notifcation") == JOptionPane.NO_OPTION) {
				return;
			}
			PhongModel p = new PhongModel();
			p.setMaPhong(maPhong);
			if (PhongDao.getInstance().delete(p) > 0) {
				MsgBox.showMessageDialog(mainFrame, "Delete success", "Notification");
			} else {
				MsgBox.showMessageDialog(mainFrame, "Delete fail", "Notification");
			}
			Form_Phong form_Phong = new Form_Phong();
			form_Phong.displayPhongAll();
			form_Phong.setVisible(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displaySuaPhong() {
		SuaPhongJDialog suaPhongJDialog = new SuaPhongJDialog();
		suaPhongJDialog.displaySuaPhong(maPhong);
		suaPhongJDialog.setModal(true);
		suaPhongJDialog.setVisible(true);
	}

	public void displayName() {
		JOptionPane.showMessageDialog(this, "Mã phòng " + maPhong);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		PhongDonCTL ctl = new PhongDonCTL(this);
		lblPhong = new javax.swing.JLabel();
		lblIMG = new javax.swing.JLabel();
		lblIMG.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoTen = new javax.swing.JLabel();
		lblGia = new javax.swing.JLabel();
		btnTra = new javax.swing.JButton();
		btnTra.addActionListener(ctl);
		btnXem = new javax.swing.JButton();
		btnXem.addActionListener(ctl);
		btnXoa = new javax.swing.JButton();
		btnXoa.addActionListener(ctl);
		btnSua = new javax.swing.JButton();
		btnSua.addActionListener(ctl);

		setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
		setPreferredSize(new Dimension(162, 217));

		lblPhong.setText("Phòng:");

		lblHoTen.setText("Họ tên:");

		lblGia.setText("Giá:");

		btnTra.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
		btnTra.setText("Trả");

		btnXem.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
		btnXem.setText("Xem");

		btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
		btnXoa.setText("Xóa");

		btnSua.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
		btnSua.setText("Sửa");

		btnThemKhach = new JButton();
		btnThemKhach.setText("Thêm Khách");
		btnThemKhach.addActionListener(ctl);
		btnThemKhach.setFont(new Font("Segoe UI", Font.PLAIN, 10));

		lblTang = new JLabel();
		lblTang.setText("Tầng:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIMG, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnThemKhach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnTra, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnXem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE)))
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(lblHoTen)
										.addComponent(lblGia))
								.addGap(0, 113, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(lblPhong, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
								.addComponent(lblTang, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
				.addGap(4)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(lblPhong).addComponent(lblTang))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblIMG, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblHoTen)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblGia)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(btnXem).addGroup(
						layout.createParallelGroup(Alignment.BASELINE).addComponent(btnTra).addComponent(btnThemKhach)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(btnXoa).addComponent(btnSua))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		this.setLayout(layout);
	}
}
