package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CuaHangJDialogCTL;
import dao.CuaHangDao;
import lib.DataValidator;

import lib.MsgBox;
import lib.XImage;
import model.CuaHangModel;

import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.SwingConstants;

public class CuaHangJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_MaCuaHang;
	private JTextField txt_TenCuaHang;
	private JTextField txt_SDT;
	private JTextField txt_Email;
	private JTextField txt_NguoiDD;
	private JTable table;
	private JTextField txtFind;
	private JTextArea txtDiaChi;
	private byte[] arrIMG;
	private JLabel lbl_IMG;
	private JTabbedPane tabbedPane;
	private int count = 0;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnNew;
	private JButton btnLast;
	private JButton btnFirst;
	private Component btnNext;
	private JButton btnPre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			CuaHangJDialog dialog = new CuaHangJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CuaHangJDialog() {
		CuaHangJDialogCTL ctl = new CuaHangJDialogCTL(this);
		setBounds(100, 100, 675, 533);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lí Cửa Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(10, 11, 274, 25);
		contentPanel.add(lblNewLabel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 47, 655, 475);
		contentPanel.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Cập nhật", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Hình ảnh");
		lblNewLabel_1.setBounds(10, 11, 48, 14);
		panel.add(lblNewLabel_1);

		JLabel lbl_MaCuaHang = new JLabel("Mã cửa hàng");
		lbl_MaCuaHang.setBounds(223, 11, 97, 14);
		panel.add(lbl_MaCuaHang);

		JLabel lblNewLabel_1_2 = new JLabel("Tên cửa hàng");
		lblNewLabel_1_2.setBounds(223, 58, 134, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lbl_SDT = new JLabel("Số điện thoại");
		lbl_SDT.setBounds(223, 108, 204, 14);
		panel.add(lbl_SDT);

		JLabel lbl_Email = new JLabel("Email");
		lbl_Email.setBounds(223, 155, 179, 14);
		panel.add(lbl_Email);

		JLabel lblNewLabel_1_5 = new JLabel("Người đại diện");
		lblNewLabel_1_5.setBounds(223, 203, 204, 14);
		panel.add(lblNewLabel_1_5);

		JLabel lbl_DiaChi = new JLabel("Địa chỉ");
		lbl_DiaChi.setBounds(10, 251, 113, 14);
		panel.add(lbl_DiaChi);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 36, 187, 204);
		panel.add(panel_2);
		panel_2.setLayout(null);

		lbl_IMG = new JLabel("New label");
		lbl_IMG.setName("IMG");
		lbl_IMG.addMouseListener(ctl);
		lbl_IMG.setBackground(new Color(255, 255, 255));
		lbl_IMG.setBounds(10, 11, 167, 182);
		panel_2.add(lbl_IMG);

		txt_MaCuaHang = new JTextField();
		txt_MaCuaHang.setBounds(223, 36, 417, 20);
		panel.add(txt_MaCuaHang);
		txt_MaCuaHang.setColumns(10);

		txt_TenCuaHang = new JTextField();
		txt_TenCuaHang.setColumns(10);
		txt_TenCuaHang.setBounds(223, 77, 417, 20);
		panel.add(txt_TenCuaHang);

		txt_SDT = new JTextField();
		txt_SDT.setColumns(10);
		txt_SDT.setBounds(223, 133, 417, 20);
		panel.add(txt_SDT);

		txt_Email = new JTextField();
		txt_Email.setColumns(10);
		txt_Email.setBounds(223, 172, 417, 20);
		panel.add(txt_Email);

		txt_NguoiDD = new JTextField();
		txt_NguoiDD.setColumns(10);
		txt_NguoiDD.setBounds(223, 220, 417, 20);
		panel.add(txt_NguoiDD);

		txtDiaChi = new JTextArea();
		txtDiaChi.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		txtDiaChi.setBounds(10, 268, 630, 132);
		panel.add(txtDiaChi);

		JScrollPane scrollPane = new JScrollPane(txtDiaChi);
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 268, 630, 132);
		panel.add(scrollPane);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(ctl);
		btnAdd.setBounds(10, 413, 66, 23);
		panel.add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setBounds(79, 413, 73, 23);
		panel.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(ctl);
		btnDelete.setBounds(162, 413, 66, 23);
		panel.add(btnDelete);

		btnNew = new JButton("New");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(238, 413, 66, 23);
		panel.add(btnNew);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(574, 413, 66, 23);
		panel.add(btnLast);

		btnNext = new JButton(">>");
		((AbstractButton) btnNext).addActionListener(ctl);
		btnNext.setBounds(498, 413, 66, 23);
		panel.add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(422, 413, 66, 23);
		panel.add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(346, 413, 66, 23);
		panel.add(btnFirst);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Danh sách", null, panel_1, null);
		panel_1.setLayout(null);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã CH", "Tên CH", "Địa chỉ", "SĐT", "Email", "Người đại diện", "Hình ảnh" }));
		table.addMouseListener(ctl);

		JLabel lbl_TimKiem = new JLabel("Find");
		lbl_TimKiem.setBounds(10, 11, 48, 14);
		panel_1.add(lbl_TimKiem);

		txtFind = new JTextField();
		txtFind.addKeyListener(ctl);
		txtFind.setBounds(10, 27, 531, 20);
		panel_1.add(txtFind);
		txtFind.setColumns(10);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(ctl);
		btnFind.setBounds(551, 26, 89, 23);
		panel_1.add(btnFind);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(10, 58, 630, 378);
		panel_1.add(scrollPane_1);

		JLabel lbl_Exit = new JLabel("X");
		lbl_Exit.setName("Exit");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setForeground(new Color(255, 0, 0));
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setBounds(617, 11, 48, 18);
		contentPanel.add(lbl_Exit);

		ImageIcon icon = new ImageIcon(
				CuaHangJDialog.class.getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
		Image img = XImage.resize(icon.getImage(), 167, 182);
		lbl_IMG.setIcon(new ImageIcon(img));
		this.loadDataTable();
		this.upStatus();
	}

	public void displayImage() {
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
			Image img = XImage.resize(icon.getImage(), 167, 182);
			ImageIcon resize = new ImageIcon(img);
			this.lbl_IMG.setIcon(resize);
			this.arrIMG = XImage.toByteArray(img, "jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		ArrayList<CuaHangModel> list = CuaHangDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (CuaHangModel cuaHangModel : list) {
			model_table.addRow(new Object[] { cuaHangModel.getMaCuaHang(), cuaHangModel.getTenCuaHang(),
					cuaHangModel.getDiaChi(), cuaHangModel.getSoDienThoai(), cuaHangModel.getEmail(),
					cuaHangModel.getNguoiDaiDien(), cuaHangModel.getHinhAnh() });
		}
	}

	public void insertTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txt_MaCuaHang, sb, "Mã cửa hàng null");
		DataValidator.validateIsHoTen(txt_TenCuaHang, sb, "Tên cửa hàng null");
		DataValidator.validateIsSDT(txt_SDT, sb, "SĐT null");
		DataValidator.validateIsEmail(txt_Email, sb, "Email null");
		DataValidator.validateIsHoTen(txt_NguoiDD, sb, "Tên người đại diện null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maCuaHang = txt_MaCuaHang.getText();
		String tenCuaHang = txt_TenCuaHang.getText();
		String diaChi = txtDiaChi.getText();
		String soDienThoai = txt_SDT.getText();
		String email = txt_Email.getText();
		String nguoiDaiDien = txt_NguoiDD.getText();
		byte[] hinhAnh = arrIMG;
		CuaHangModel ch = new CuaHangModel(maCuaHang, tenCuaHang, diaChi, soDienThoai, email, nguoiDaiDien, hinhAnh);
		if (CuaHangDao.getInstance().selectByID(ch) != null) {
			if (MsgBox.showConfirmDialog(this, "Cửa hàng đã tồn tại bạn muốn update?",
					"Notificaiton") == JOptionPane.NO_OPTION) {
				return;
			}
			if (CuaHangDao.getInstance().update(ch) > 0) {
				MsgBox.showMessageDialog(this, "Update Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update Fail", "Notification");
			}

		} else {
			if (CuaHangDao.getInstance().insert(ch) > 0) {
				MsgBox.showMessageDialog(this, "Insert Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert Fail", "Notification");
			}
		}
		loadDataTable();
	}

	public void resetForm() {
		txt_MaCuaHang.setText("");
		txt_TenCuaHang.setText("");
		txtDiaChi.setText("");
		txt_SDT.setText("");
		txt_Email.setText("");
		txt_NguoiDD.setText("");
		arrIMG = null;
		ImageIcon icon = new ImageIcon(
				CuaHangJDialog.class.getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
		Image img = XImage.resize(icon.getImage(), 167, 182);
		lbl_IMG.setIcon(new ImageIcon(img));
		txt_MaCuaHang.requestFocus();
		count = -1;
		upStatus();
	}

	public void deleteTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txt_MaCuaHang, sb, "Mã cửa hàng null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maCuaHang = txt_MaCuaHang.getText();
		CuaHangModel ch = new CuaHangModel();
		ch.setMaCuaHang(maCuaHang);
		if (CuaHangDao.getInstance().delete(ch) > 0) {
			resetForm();
			MsgBox.showMessageDialog(this, "Delete Successfull", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete Fail", "Notification");
		}
	}

	public CuaHangModel getCuaHang() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maCuaHang = model_table.getValueAt(i_row, 0) + "";
		CuaHangModel ch = new CuaHangModel();
		ch.setMaCuaHang(maCuaHang);
		CuaHangModel chd = CuaHangDao.getInstance().selectByID(ch);
		return chd;
	}

	public void displayFormCapNhat() {
		try {
			CuaHangModel ch = getCuaHang();
			txt_MaCuaHang.setText(ch.getMaCuaHang());
			txt_TenCuaHang.setText(ch.getTenCuaHang());
			txtDiaChi.setText(ch.getDiaChi());
			txt_SDT.setText(ch.getSoDienThoai());
			txt_Email.setText(ch.getEmail());
			txt_NguoiDD.setText(ch.getNguoiDaiDien());
			if (ch.getHinhAnh() != null) {
				Image img = XImage.createImageFromByteArray(ch.getHinhAnh(), "jpg");
				this.lbl_IMG.setIcon(new ImageIcon(img));
				this.arrIMG = ch.getHinhAnh();
			} else {
				arrIMG = ch.getHinhAnh();
				ImageIcon icon = new ImageIcon(
						CuaHangJDialog.class.getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
				Image img = XImage.resize(icon.getImage(), 167, 182);
				lbl_IMG.setIcon(new ImageIcon(img));
			}
			tabbedPane.setSelectedIndex(0);
			int i_row = table.getSelectedRow();
			count = i_row;
			upStatus();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txt_MaCuaHang.setEditable(!edit);
		btnAdd.setEnabled(!edit);
		btnUpdate.setEnabled(edit);
		btnDelete.setEnabled(edit);

		btnFirst.setEnabled(edit && !first);
		btnPre.setEnabled(edit && !first);
		btnNext.setEnabled(edit && !last);
		btnLast.setEnabled(edit && !last);
	}

	public void firstElement() {
		count = 0;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void nextElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count > model_table.getRowCount() - 1) {
			count = model_table.getRowCount() - 1;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		count = model_table.getRowCount() - 1;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}
	
	public void findCuaHang() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String maCuaHang = this.txtFind.getText().trim();
		ArrayList<CuaHangModel> list = CuaHangDao.getInstance().selectByKeyWord(maCuaHang);
		model_table.setRowCount(0);
		for (CuaHangModel cuaHangModel : list) {
			model_table.addRow(new Object[] { cuaHangModel.getMaCuaHang(), cuaHangModel.getTenCuaHang(),
					cuaHangModel.getDiaChi(), cuaHangModel.getSoDienThoai(), cuaHangModel.getEmail(),
					cuaHangModel.getNguoiDaiDien(), cuaHangModel.getHinhAnh() });
		}
	}
}
