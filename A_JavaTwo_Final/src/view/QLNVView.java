package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import controller.ControllerMouse;
import controller.KeyListenerCTL;
import controller.QLNVController;
import model.Data;
import model.NhanVienModel;
import model.QLNVModel;

public class QLNVView extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField txtPs;
	private JTextField txtHongDuyNam;
	private JTextField textField_tuoi;
	private JTextField txtNamhdpsgmailcom;
	private JTextField textField_luong;
	private JTable table;
	private JLabel textLoi;
	private JLabel textLoi_1;
	private JLabel textLoi_1_1;
	private JLabel textLoi_1_2;
	private JLabel textLoi_1_3;
	private QLNVModel qlnvModel;
	private JLabel labelClock;
	private JLabel label_Index;
	private int count = 0;
	private JButton btnLuu;
	private JLabel lblNewLabel_8;
	private JLabel lbl_IMG;
	private byte[] arrIMG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNVView frame = new QLNVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLNVView() {
		this.qlnvModel = new QLNVModel();
		ControllerMouse ctl = new ControllerMouse(this);
		QLNVController qlnvController = new QLNVController(this);
		KeyListenerCTL key = new KeyListenerCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 561);

		URL url_title = QLNVView.class.getResource("/IMG_JavaIcon/calligra-krita-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url_title);
		this.setIconImage(img);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		mnNewMenu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(QLNVView.class.getResource("/IMG_JavaIcon/Very-Basic-Menu-icon.png"))));

		JMenuItem item_Open = new JMenuItem("Open");
		mnNewMenu.add(item_Open);
		item_Open.addActionListener(qlnvController);
		item_Open.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(QLNVView.class.getResource("/IMG_JavaIcon/open-file-icon.png"))));
		item_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

		JMenuItem item_Save = new JMenuItem("Save");
		mnNewMenu.add(item_Save);
		item_Save.addActionListener(qlnvController);
		item_Save.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(QLNVView.class.getResource("/IMG_JavaIcon/Save-icon.png"))));
		item_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

		JMenuItem item_Exit = new JMenuItem("Exit");
		mnNewMenu.add(item_Exit);
		item_Exit.addActionListener(qlnvController);
		item_Exit.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(QLNVView.class.getResource("/IMG_JavaIcon/Actions-dialog-close-icon.png"))));
		item_Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);

		JMenuItem item_About = new JMenuItem("About");
		mnNewMenu.add(item_About);
		contentPane = new JPanel();
		item_About.addActionListener(qlnvController);
		item_About.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(QLNVView.class.getResource("/IMG_JavaIcon/Actions-help-about-icon.png"))));
		item_About.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(129, 11, 178, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 74, 147, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Họ và tên");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 113, 103, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tuổi");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 149, 48, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 194, 48, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Lương");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 233, 48, 14);
		contentPane.add(lblNewLabel_5);

		txtPs = new JTextField();
		txtPs.addFocusListener(qlnvController);
		txtPs.setText("1");
		txtPs.addKeyListener(key);
		txtPs.setBounds(94, 71, 96, 20);
		contentPane.add(txtPs);
		txtPs.setColumns(10);

		txtHongDuyNam = new JTextField();
		txtHongDuyNam.addFocusListener(qlnvController);
		txtHongDuyNam.setText("Hoang Duy Nam");
		txtHongDuyNam.setBounds(94, 110, 195, 20);
		txtHongDuyNam.setColumns(10);
		contentPane.add(txtHongDuyNam);

		textField_tuoi = new JTextField();
		textField_tuoi.addFocusListener(qlnvController);
		textField_tuoi.setText("26");
		textField_tuoi.setBounds(94, 146, 96, 20);
		textField_tuoi.setColumns(10);
		contentPane.add(textField_tuoi);

		txtNamhdpsgmailcom = new JTextField();
		txtNamhdpsgmailcom.addFocusListener(qlnvController);
		txtNamhdpsgmailcom.setText("namhdps25979@gmail.com");
		txtNamhdpsgmailcom.setBounds(94, 191, 195, 20);
		txtNamhdpsgmailcom.setColumns(10);
		contentPane.add(txtNamhdpsgmailcom);

		textField_luong = new JTextField();
		textField_luong.addFocusListener(qlnvController);
		textField_luong.setText("5000000");
		textField_luong.setBounds(94, 230, 96, 20);
		textField_luong.setColumns(10);
		contentPane.add(textField_luong);

		JButton btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(QLNVView.class.getResource("/IMG_JavaIcon/Files-New-File-icon.png")));
		btnThem.setBounds(497, 88, 89, 23);
		contentPane.add(btnThem);
		btnThem.addActionListener(qlnvController);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon(QLNVView.class.getResource("/IMG_JavaIcon/File-Delete-icon.png")));
		btnXoa.setBounds(497, 156, 89, 23);
		contentPane.add(btnXoa);
		btnXoa.addActionListener(qlnvController);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(QLNVView.class.getResource("/IMG_JavaIcon/Save-icon.png")));
		btnLuu.setEnabled(false);
		btnLuu.setBounds(497, 122, 89, 23);
		contentPane.add(btnLuu);
		btnLuu.addKeyListener(key);
		btnLuu.addActionListener(qlnvController);

		JButton btnTim = new JButton("Tìm");
		btnTim.setIcon(new ImageIcon(QLNVView.class.getResource("/IMG_JavaIcon/Search-icon.png")));
		btnTim.setBounds(497, 190, 89, 23);
		contentPane.add(btnTim);
		btnTim.addActionListener(qlnvController);

		JButton btnFirst = new JButton("|<");
		btnFirst.setBounds(94, 263, 53, 23);
		contentPane.add(btnFirst);
		btnFirst.addActionListener(qlnvController);

		JButton btnPrew = new JButton("<<");
		btnPrew.setBounds(137, 263, 53, 23);
		contentPane.add(btnPrew);
		btnPrew.addActionListener(qlnvController);

		JButton btnNext = new JButton(">>");
		btnNext.setBounds(189, 263, 53, 23);
		contentPane.add(btnNext);
		btnNext.addActionListener(qlnvController);

		JButton btnLast = new JButton(">|");
		btnLast.setBounds(240, 263, 53, 23);
		contentPane.add(btnLast);
		btnLast.addActionListener(qlnvController);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã nhân viên", "Họ và tên", "Tuổi", "Email", "Lương", "IMG" }));
		table.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 320, 607, 166);
		contentPane.add(scrollPane);

		textLoi = new JLabel("");
		textLoi.setFont(new Font("Tahoma", Font.ITALIC, 10));
		textLoi.setBounds(94, 88, 116, 14);
		contentPane.add(textLoi);

		textLoi_1 = new JLabel("");
		textLoi_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		textLoi_1.setBounds(94, 125, 116, 20);
		contentPane.add(textLoi_1);

		JLabel lblNewLabel_6 = new JLabel("Record:");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setBounds(94, 297, 48, 14);
		contentPane.add(lblNewLabel_6);

		label_Index = new JLabel("");
		label_Index.setForeground(new Color(255, 0, 0));
		label_Index.setBounds(142, 297, 100, 14);
		contentPane.add(label_Index);

		textLoi_1_1 = new JLabel("");
		textLoi_1_1.setFont(new Font("Tahoma", Font.ITALIC, 10));
		textLoi_1_1.setBounds(94, 160, 116, 20);
		contentPane.add(textLoi_1_1);

		textLoi_1_2 = new JLabel("");
		textLoi_1_2.setFont(new Font("Tahoma", Font.ITALIC, 10));
		textLoi_1_2.setBounds(94, 210, 116, 20);
		contentPane.add(textLoi_1_2);

		textLoi_1_3 = new JLabel("");
		textLoi_1_3.setFont(new Font("Tahoma", Font.ITALIC, 10));
		textLoi_1_3.setBounds(94, 246, 116, 20);
		contentPane.add(textLoi_1_3);

		labelClock = new JLabel("00:00 AM");
		labelClock.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelClock.setForeground(new Color(255, 0, 0));
		labelClock.setBounds(514, 17, 103, 20);
		contentPane.add(labelClock);

		JButton btnHuyTim = new JButton("Hủy tìm");
		btnHuyTim.setIcon(new ImageIcon(QLNVView.class.getResource("/IMG_JavaIcon/Clear-icon.png")));
		btnHuyTim.setBounds(493, 224, 103, 23);
		contentPane.add(btnHuyTim);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "Function", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(470, 64, 147, 203);
		contentPane.add(panel);

		JButton btn_IMG = new JButton("IMG");
		btn_IMG.setIcon(new ImageIcon(QLNVView.class.getResource("/IMG_JavaIcon/open-file-icon.png")));
		btn_IMG.addActionListener(qlnvController);
		btn_IMG.setBounds(346, 229, 89, 23);
		contentPane.add(btn_IMG);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "IMG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(316, 64, 147, 203);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lbl_IMG = new JLabel("");
		lbl_IMG.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IMG.setIcon(new ImageIcon(QLNVView.class.getResource("/IMG_JavaIcon/Student-3-icon64.png")));
		lbl_IMG.setBounds(10, 21, 127, 125);
		panel_1.add(lbl_IMG);
		btnHuyTim.addActionListener(qlnvController);

		Thread thread = new Thread(this);
		thread.start();

//		URL url_title = QLNVView.class.getResource("me.jpg");
//		Image img = Toolkit.getDefaultToolkit().createImage(url_title);
//		this.setIconImage(img);

		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(0, -73, 627, 593);
		contentPane.add(lblNewLabel_8);

		ImageIcon icon = new ImageIcon(QLNVView.class.getResource("/IMG_JavaIcon/imager_14_53459_700.jpg"));
		Image img1 = model.ImageHelper.resize(icon.getImage(), 627, 593);
		ImageIcon resizeIcon = new ImageIcon(img1);
		this.lblNewLabel_8.setIcon(resizeIcon);

		this.setTitle("Quản Lý Nhân Viên");
		this.setLocationRelativeTo(null);
		this.addWindowListener(qlnvController);
		this.setVisible(true);

	}

	public void resetForm() {
		this.txtPs.setText("");
		this.txtHongDuyNam.setText("");
		this.textField_tuoi.setText("");
		this.txtNamhdpsgmailcom.setText("");
		this.textField_luong.setText("");
		this.txtPs.requestFocus();
		this.textLoi.setText("");
		this.textLoi_1.setText("");
		this.textLoi_1_1.setText("");
		this.textLoi_1_2.setText("");
		this.textLoi_1_3.setText("");
		this.lbl_IMG.setIcon(new ImageIcon(getClass().getResource("/IMG_JavaIcon/Student-3-icon64.png")));
		this.table.getSelectionModel().clearSelection();
	}

	public void disEnabled() {
		this.btnLuu.setEnabled(true);
	}

	public void kiemForm() {
		if (this.txtPs.getText().equals("")) {
			this.textLoi.setText("Chưa nhập mã nhân viên");
			this.textLoi.setForeground(Color.red);
		} else {
			String maNhanVien = this.txtPs.getText();
			if (!Data.isSo(maNhanVien)) {
				this.textLoi.setText("Sai định dạng");
				this.textLoi.setForeground(Color.red);
			} else {
				this.textLoi.setText("");
			}
		}

		if (this.txtHongDuyNam.getText().equals("")) {
			((JLabel) this.textLoi_1).setText("Chưa nhập họ và tên");
			this.textLoi_1.setForeground(Color.red);
		} else {
			String hoVaTen = this.txtHongDuyNam.getText();
			if (!Data.isHoTen(hoVaTen)) {
				((JLabel) this.textLoi_1).setText("Sai định dạng");
				this.textLoi_1.setForeground(Color.red);
			} else {
				((JLabel) this.textLoi_1).setText("");
			}
		}

		if (this.txtNamhdpsgmailcom.getText().equals("")) {
			this.textLoi_1_2.setText("Chưa nhập email");
			this.textLoi_1_2.setForeground(Color.red);
		} else {
			String email = this.txtNamhdpsgmailcom.getText();
			if (!Data.isEmail(email)) {
				this.textLoi_1_2.setText("Nhập sai định dạng email");
				this.textLoi_1_2.setForeground(Color.red);
			} else {
				this.textLoi_1_2.setText("");
			}
		}

		if (this.textField_luong.getText().equals("")) {
			this.textLoi_1_3.setText("Chưa nhập lương");
			this.textLoi_1_3.setForeground(Color.red);
		} else {
			try {
				double luong = Double.valueOf(this.textField_luong.getText());
				if (luong < 5) {
					this.textLoi_1_3.setText("Nhập lương >=5");
					this.textLoi_1_3.setForeground(Color.red);
				} else {
					this.textLoi_1_3.setText("");
				}
			} catch (Exception e) {
				this.textLoi_1_3.setText("Nhập lương phải là số");
				this.textLoi_1_3.setForeground(Color.red);
			}
		}

		if (this.textField_tuoi.getText().equals("")) {
			this.textLoi_1_1.setText("Chưa nhập tuổi");
			this.textLoi_1_1.setForeground(Color.red);
		} else {
			try {
				double tuoi = Double.valueOf(this.textField_tuoi.getText());
				if (tuoi < 16 || tuoi > 55) {
					this.textLoi_1_1.setText("Nhập tuổi >16, tuổi <55");
					this.textLoi_1_1.setForeground(Color.red);
				} else {
					this.textLoi_1_1.setText("");
				}
			} catch (Exception e) {
				this.textLoi_1_1.setText("Tuổi phải là số");
				this.textLoi_1_1.setForeground(Color.red);
			}
		}

	}

	public boolean kiemFormBoolean() {
		if (this.txtPs.getText().equals("")) {
			return false;
		} else {
			String maNhanVien = this.txtPs.getText();
			if (!Data.isSo(maNhanVien)) {
				return false;
			}
		}

		if (this.txtHongDuyNam.getText().equals("")) {
			return false;
		} else {
			String hoVaTen = this.txtHongDuyNam.getText();
			if (!Data.isHoTen(hoVaTen)) {
				return false;
			}
		}

		if (this.txtNamhdpsgmailcom.getText().equals("")) {
			return false;
		} else {
			String email = this.txtNamhdpsgmailcom.getText();
			if (!Data.isEmail(email)) {
				return false;
			}
		}

		if (this.textField_luong.getText().equals("")) {
			return false;
		} else {
			try {
				double luong = Double.valueOf(this.textField_luong.getText());
				if (luong < 5) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}

		if (this.textField_tuoi.getText().equals("")) {
			return false;
		} else {
			try {
				double tuoi = Double.valueOf(this.textField_tuoi.getText());
				if (tuoi < 16 || tuoi > 55) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public void luuDoiTuong() {
		String maNhanVien = this.txtPs.getText();
		String hoVaTen = this.txtHongDuyNam.getText();
		int tuoi = Integer.valueOf(this.textField_tuoi.getText());
		String email = this.txtNamhdpsgmailcom.getText();
		double luong = Double.valueOf(this.textField_luong.getText());
		byte[] hinh = this.arrIMG;
		NhanVienModel nv = new NhanVienModel(maNhanVien, hoVaTen, tuoi, email, luong, hinh);
		if (this.kiemFormBoolean()) {
			this.themHoacCapNhatNV(nv);
		}
	}

	public void themHoacCapNhatNV(NhanVienModel nv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.qlnvModel.kiemTraTonTai(nv)) {
			this.qlnvModel.insert(nv);
			this.themVaoTable(nv);
			this.lastElement();
		} else {
			if (JOptionPane.showConfirmDialog(this, "Nhân viên đã tồn tại bạn muốn cập nhật?", "Update",
					JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
				return;
			}
			int soLuongDong = model_table.getRowCount();
			System.out.println(soLuongDong);
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(nv.getMaNhanVien())) {
					this.qlnvModel.update(i, nv);
					model_table.setValueAt(nv.getMaNhanVien(), i, 0);
					model_table.setValueAt(nv.getHoVaTen(), i, 1);
					model_table.setValueAt(nv.getTuoi(), i, 2);
					model_table.setValueAt(nv.getEmail(), i, 3);
					model_table.setValueAt(nv.getLuong(), i, 4);
					model_table.setValueAt(nv.getHinh(), i, 5);
					table.setRowSelectionInterval(i, i);
				}
			}
		}
	}

	public void themVaoTable(NhanVienModel nv) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { nv.getMaNhanVien(), nv.getHoVaTen(), nv.getTuoi(), nv.getEmail(),
				nv.getLuong(), nv.getHinh() });
	}

//	public NhanVienModel getNhanVienDangChon() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//		int i_Row = table.getSelectedRow();
//		String maNhanVien = model_table.getValueAt(i_Row, 0) + "";
//		String hoVaTen = model_table.getValueAt(i_Row, 1) + "";
//		int tuoi = Integer.valueOf(model_table.getValueAt(i_Row, 2) + "");
//		String email = model_table.getValueAt(i_Row, 3) + "";
//		double luong = Double.valueOf(model_table.getValueAt(i_Row, 4) + "");
//		byte[] hinh = this.arrIMG;
//		NhanVienModel nv = new NhanVienModel(maNhanVien, hoVaTen, tuoi, email, luong, hinh);
//		return nv;
//	}

	public NhanVienModel getNhanVienDangChon() {
		int i_Row = table.getSelectedRow();
		NhanVienModel nv = this.qlnvModel.getDsNhanVien().get(i_Row);
		return nv;
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng đang chọn", "Delete",
				JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			NhanVienModel nv = this.getNhanVienDangChon();
			this.qlnvModel.delete(nv);
			model_table.removeRow(i_row);
			int soLuongDong = model_table.getRowCount();
			i_row--;
			System.out.println(i_row);
			if (i_row > 0) {
				table.setRowSelectionInterval(i_row, i_row);
				this.lableIndex(i_row, soLuongDong);
				this.updateForm();
			} else {
				this.firstElement();
				this.updateForm();
			}
		}
	}

	public void loadLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0) {
				break;
			} else {
				model_table.removeRow(0);
			}
		}
		for (NhanVienModel nv : this.qlnvModel.getDsNhanVien()) {
			System.out.println(nv);
			this.themVaoTable(nv);
		}
	}

	public void updateForm() {
		try {
			NhanVienModel nv = this.getNhanVienDangChon();
			this.txtPs.setText(nv.getMaNhanVien());
			this.txtHongDuyNam.setText(nv.getHoVaTen());
			this.textField_tuoi.setText(nv.getTuoi() + "");
			this.txtNamhdpsgmailcom.setText(nv.getEmail());
			this.textField_luong.setText(nv.getLuong() + "");
			if (nv.getHinh() != null) {
				Image img = model.ImageHelper.createImageFromByteArray(nv.getHinh(), "jpg");
				this.lbl_IMG.setIcon(new ImageIcon(img));
				this.arrIMG = nv.getHinh();

			} else {
				this.arrIMG = nv.getHinh();
				ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JavaIcon/Student-3-icon64.png"));
				this.lbl_IMG.setIcon(icon);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveFile(String path) {
		try {
			this.qlnvModel.setTenFile(path);
			OutputStream os = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (NhanVienModel nv : this.qlnvModel.getDsNhanVien()) {
				oos.writeObject(nv);
			}
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void thucHienSave() {
		JFileChooser fc = new JFileChooser();
		if (this.qlnvModel.getTenFile().length() > 0) {
			System.out.println(this.qlnvModel.getTenFile());
			saveFile(this.qlnvModel.getTenFile());
		} else {
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			}
		}
	}

	public void openFile(File file) {
		ArrayList<NhanVienModel> ds = new ArrayList<NhanVienModel>();
		try {
			this.qlnvModel.setTenFile(file.getAbsolutePath());
			InputStream is = new FileInputStream(file.getAbsolutePath());
			ObjectInputStream ois = new ObjectInputStream(is);
			NhanVienModel nv = null;
			while ((nv = (NhanVienModel) ois.readObject()) != null) {
				ds.add(nv);
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.qlnvModel.setDsNhanVien(ds);
	}

	public void thucHienOpen() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			this.loadLaiDuLieu();
		}
	}

	public void thucHienTim() {
		this.txtHongDuyNam.setText("");
		this.textField_tuoi.setText("");
		this.txtNamhdpsgmailcom.setText("");
		this.textField_luong.setText("");
		// Gọi hàm hủy tìm để dữ liệu tìm trả về ban đầu
		this.loadLaiDuLieu();
		// Thực hiện tìm
		String maNhanVienTimKiem = this.txtPs.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		Set<Integer> idCuaSinhVienCanXoa = new TreeSet<>();

		if (maNhanVienTimKiem.length() > 0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (!id.equals(maNhanVienTimKiem)) {
					idCuaSinhVienCanXoa.add(Integer.valueOf(id));
				}
			}
		}

		for (Integer idCanXoa : idCuaSinhVienCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public int soLuongDongTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		return soLuongDong;
	}

	public void lableIndex(int count, int soLuongDong) {
		this.label_Index.setText((count + 1) + " of " + soLuongDong);
	}

	public void indexMouse() {
		int i_row = table.getSelectedRow();
		int soLuongDong = this.soLuongDongTable();
		this.lableIndex(i_row, soLuongDong);
	}

	public void firstElement() {
		int soLuongDong = this.soLuongDongTable();
		table.setRowSelectionInterval(0, 0);
		this.lableIndex(0, soLuongDong);
		this.updateForm();
	}

	public void lastElement() {
		int soLuongDong = this.soLuongDongTable();
//		System.out.println(soLuongDong);
		this.lableIndex(soLuongDong - 1, soLuongDong);
		table.setRowSelectionInterval(soLuongDong - 1, soLuongDong - 1);
		this.updateForm();
	}

	public void nextElement() {
		int soLuongDong = this.soLuongDongTable();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count < soLuongDong) {
			this.lableIndex(count, soLuongDong);
		}
		table.setRowSelectionInterval(count, count);
		this.updateForm();
		System.out.println(count);
	}

	public void prewElement() {
		int soLuongDong = this.soLuongDongTable();
		int i_row = table.getSelectedRow();
		count = i_row;
		count--;
		if (count >= 0) {
			this.lableIndex(count, soLuongDong);
		} else {
			count = 0;
		}
		table.setRowSelectionInterval(count, count);
		this.updateForm();
		System.out.println(count);
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm 1.0");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát?", "Exit", JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void run() {
		while (true) {
			Date now = new Date();
			SimpleDateFormat fm = new SimpleDateFormat("hh:mm:ss aa");
			this.labelClock.setText(fm.format(now));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public void disPlayImage() {
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
			Image img = model.ImageHelper.resize(icon.getImage(), 127, 125);
			ImageIcon resizeIcon = new ImageIcon(img);
			this.lbl_IMG.setIcon(resizeIcon);
			arrIMG = model.ImageHelper.toByteArray(img, "jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void introduceModal() {
		IntroduceDialog itr = new IntroduceDialog();
		itr.setModal(true);
		itr.setDefaultCloseOperation(0);
		itr.setVisible(true);
	}
}
