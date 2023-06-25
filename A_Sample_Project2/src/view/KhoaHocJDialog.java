package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.sql.Date;
import java.time.chrono.JapaneseDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.KhoaHocJDialogCTL;
import dao.ChuyenDeDAO;
import dao.KhoaHocDAO;
import dao.NhanVienDAO;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import lib.XDate;
import model.ChuyenDeModel;
import model.KhoaHocModel;
import model.NhanVienModel;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.border.MatteBorder;

public class KhoaHocJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_NgayKG;
	private JTextField textField_ThoiLuong;
	private JTextField textField_NgayTao;
	private JTextField textField_HocPhi;
	private JTextField textField_NguoiTao;
	private JTextArea textArea;
	private JButton btnFirst;
	private JTable table;
	private JComboBox<String> comboBox;
	private JTabbedPane tabbedPane;
	private int count = 0;
	private JButton btnHocVien;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btn_Them;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnMoi;
	private int i_row;
	private HocVienJDialog hocVienJDialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			if(Auth.isLogin()) {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			KhoaHocJDialog dialog = new KhoaHocJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
//			}else {
//				MsgBox.showMessageDialog(dialog, "Please login", "Notification");
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public KhoaHocJDialog() {
		hocVienJDialog = new HocVienJDialog();
		setIconImage(Toolkit.getDefaultToolkit().getImage(KhoaHocJDialog.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
		KhoaHocJDialogCTL ctl = new KhoaHocJDialogCTL(this);
		setBounds(100, 100, 675, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Khóa Học");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 174, 22);
		contentPanel.add(lblNewLabel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 36, 655, 486);
		contentPanel.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Cập nhật", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Chuyên đề");
		lblNewLabel_1.setBounds(10, 11, 140, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ngày khai giảng");
		lblNewLabel_1_1.setBounds(279, 11, 195, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Học phí");
		lblNewLabel_1_2.setBounds(10, 69, 48, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Thời lượng(giờ)");
		lblNewLabel_1_3.setBounds(279, 69, 119, 14);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Người tạo");
		lblNewLabel_1_4.setBounds(10, 125, 48, 14);
		panel.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Ngày tạo");
		lblNewLabel_1_5.setBounds(279, 125, 48, 14);
		panel.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("Ghi chú");
		lblNewLabel_1_6.setBounds(10, 193, 48, 14);
		panel.add(lblNewLabel_1_6);

		comboBox = new JComboBox();
		comboBox.setActionCommand("C");
		comboBox.addActionListener(ctl);
		comboBox.setBounds(10, 36, 218, 22);
		panel.add(comboBox);

		textField_NgayKG = new JTextField();
		textField_NgayKG.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_NgayKG.setBackground(new Color(255, 255, 255));
		textField_NgayKG.setBounds(278, 37, 350, 20);
		panel.add(textField_NgayKG);
		textField_NgayKG.setColumns(10);

		textField_ThoiLuong = new JTextField();
		textField_ThoiLuong.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_ThoiLuong.setBackground(new Color(255, 255, 255));
		textField_ThoiLuong.setColumns(10);
		textField_ThoiLuong.setBounds(279, 94, 350, 20);
		panel.add(textField_ThoiLuong);

		textField_NgayTao = new JTextField();
		textField_NgayTao.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_NgayTao.setBackground(new Color(255, 255, 255));
		textField_NgayTao.setColumns(10);
		textField_NgayTao.setBounds(278, 150, 350, 20);
		panel.add(textField_NgayTao);

		textField_HocPhi = new JTextField();
		textField_HocPhi.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_HocPhi.setBackground(new Color(255, 255, 255));
		textField_HocPhi.setBounds(10, 94, 218, 20);
		panel.add(textField_HocPhi);
		textField_HocPhi.setColumns(10);

		textField_NguoiTao = new JTextField();
		textField_NguoiTao.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_NguoiTao.setBackground(new Color(255, 255, 255));
		textField_NguoiTao.setColumns(10);
		textField_NguoiTao.setBounds(10, 150, 218, 20);
		panel.add(textField_NguoiTao);

		textArea = new JTextArea();
		textArea.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 218, 618, 191);
		panel.add(scrollPane);

		btn_Them = new JButton("Thêm");
		btn_Them.addActionListener(ctl);
		btn_Them.setBounds(10, 420, 61, 23);
		panel.add(btn_Them);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(81, 420, 51, 23);
		panel.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(142, 420, 51, 23);
		panel.add(btnXoa);

		btnMoi = new JButton("Mới");
		btnMoi.addActionListener(ctl);
		btnMoi.setBounds(203, 420, 49, 23);
		panel.add(btnMoi);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(413, 420, 45, 23);
		panel.add(btnFirst);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(468, 420, 49, 23);
		panel.add(btnPre);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(527, 420, 49, 23);
		panel.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(586, 420, 45, 23);
		panel.add(btnLast);

		btnHocVien = new JButton("Học viên");
		btnHocVien.addActionListener(ctl);
		btnHocVien.setBounds(262, 416, 89, 31);
		panel.add(btnHocVien);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Danh sách", null, panel_1, null);
		panel_1.setLayout(null);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã KH", "Chuyên đề", "Thời Lượng",
				"Học phí", "Khai giảng", "Ghi chú", "Tạo bởi", "Ngày tạo" }));
		table.addMouseListener(ctl);
		
		

		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(10, 11, 618, 436);
		panel_1.add(scrollPane_1);
		
		JLabel lbl_Exit = new JLabel("X");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setForeground(new Color(255, 0, 0));
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setBounds(627, 11, 48, 23);
		contentPanel.add(lbl_Exit);
		
		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255,255,255));
		this.table.setRowHeight(25);

		this.textField_HocPhi.setEditable(false);
		this.textField_ThoiLuong.setEditable(false);
		this.textField_NguoiTao.setEditable(false);
		this.textField_NgayTao.setEditable(false);
		this.btnHocVien.setVisible(false);
		this.upstatus();
		this.loadChuyenDe();
		this.loadDataTable();
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}

	public void loadChuyenDe() {
		try {
			ArrayList<ChuyenDeModel> listCD = ChuyenDeDAO.getInstance().selectAll();
			this.comboBox.addItem("");
			for (ChuyenDeModel chuyenDeModel : listCD) {
				this.comboBox.addItem(chuyenDeModel.getTenChuyenDe());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadDataTable() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			ArrayList<KhoaHocModel> list = KhoaHocDAO.getInstance().selectAll();
			model_table.setRowCount(0);
			for (KhoaHocModel kh : list) {
				model_table.addRow(new Object[] { kh.getMaKhoaHoc(), kh.getMaChuyenDe(), kh.getThoiLuong(),
						kh.getHocPhi(), XDate.dateString(kh.getNgayKhaiGiang()), kh.getGhiChu(), kh.getMaNV(),
						XDate.dateString(kh.getNgayTao()) });
			}
			model_table.fireTableDataChanged();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void loadDataTableN() {
//		try {
//			if (this.comboBox.getSelectedIndex() == 0) {
//				this.loadDataTable();
//				return;
//			}
//			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//			ChuyenDeModel cd = new ChuyenDeModel();
//			cd.setTenChuyenDe((String) this.comboBox.getSelectedItem());
//			ChuyenDeModel cdd = ChuyenDeDAO.getInstance().selectByTen(cd);
//			KhoaHocModel khm = new KhoaHocModel();
//			khm.setMaChuyenDe(cdd.getMaChuyenDe());
//			if (!KhoaHocDAO.getInstance().selectByMaChuyenDe(khm).isEmpty()) {
//				ArrayList<KhoaHocModel> list = KhoaHocDAO.getInstance().selectByMaChuyenDe(khm);
//				model_table.setRowCount(0);
//				for (KhoaHocModel kh : list) {
//					model_table.addRow(new Object[] { kh.getMaKhoaHoc(), kh.getMaChuyenDe(), kh.getThoiLuong(),
//							kh.getHocPhi(), XDate.dateString(kh.getNgayKhaiGiang()), kh.getGhiChu(), kh.getMaNV(),
//							XDate.dateString(kh.getNgayTao()) });
//				}
//				model_table.fireTableDataChanged();
//				this.tabbedPane.setSelectedIndex(1);
//			} else {
//				this.textField_HocPhi.setText(cdd.getHocPhi() + "");
//				this.textField_ThoiLuong.setText(cdd.getThoiLuong() + "");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
////			e.printStackTrace();
//		}
//
//	}

	public void selectCombobox() {
		try {
			if (this.comboBox.getSelectedIndex() == 0) {
				this.loadDataTable();
			} else {
				ChuyenDeModel cd = new ChuyenDeModel();
				cd.setTenChuyenDe((String) this.comboBox.getSelectedItem());
				ChuyenDeModel cdd = ChuyenDeDAO.getInstance().selectByTen(cd);
				this.textField_HocPhi.setText(cdd.getHocPhi() + "");
				this.textField_ThoiLuong.setText(cdd.getThoiLuong() + "");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void displayHocVienJDialog() {
		KhoaHocModel kh = this.getValueTable();
		HocVienJDialog hv = new HocVienJDialog();
		hv.maKhoaHoc = kh.getMaKhoaHoc();
		hv.loadDataTable();
		hv.loadCombobox();
//		System.out.println(hv.maKhoaHoc);
		hv.setModal(true);
		hv.setVisible(true);
	}

	public void disPlayForm() {
		try {
			KhoaHocModel kh = this.getValueTable();
			// this.hocVienJDialog.maKhoaHoc = kh.getMaKhoaHoc();
			this.comboBox.setSelectedItem(
					ChuyenDeDAO.getInstance().selectByStringTenCD(kh.getMaChuyenDe()).getTenChuyenDe());
			this.textField_NgayKG.setText(XDate.dateString(kh.getNgayKhaiGiang()));
			this.textField_HocPhi.setText(kh.getHocPhi() + "");
			this.textField_ThoiLuong.setText(kh.getThoiLuong() + "");
			this.textField_NguoiTao.setText(kh.getMaNV());
			this.textField_NgayTao.setText(XDate.dateString(kh.getNgayTao()));
			this.textArea.setText(kh.getGhiChu());
			this.tabbedPane.setSelectedIndex(0);
			this.btnHocVien.setVisible(true);
			this.count = i_row;
			this.upstatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public KhoaHocModel getValueTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		i_row = table.getSelectedRow();
//		System.out.println(i_row);
		KhoaHocModel khm = new KhoaHocModel();
		khm.setMaKhoaHoc(Integer.valueOf((Integer) model_table.getValueAt(i_row, 0)));
		KhoaHocModel khd = KhoaHocDAO.getInstance().selectByID(khm);
		return khd;
	}

	public void upstatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		this.btn_Them.setEnabled(!edit);
		this.btnSua.setEnabled(edit);
		this.btnXoa.setEnabled(edit);

		this.btnFirst.setEnabled(edit && !first);
		this.btnPre.setEnabled(edit && !first);
		this.btnNext.setEnabled(edit && !last);
		this.btnLast.setEnabled(edit && !last);
	}

	public void resetForm() {
		try {
			this.textField_NgayTao.setText(XDate.dateString(XDate.now()));
			this.textField_NgayKG.setText(XDate.dateString(XDate.addDays(30)));
			this.textField_HocPhi.setText("");
			this.textField_ThoiLuong.setText("");
			this.textField_NguoiTao.setText("");
			this.comboBox.setSelectedIndex(-1);
			this.textField_NguoiTao.setText(Auth.user.getMaNV());
			this.btnHocVien.setVisible(false);
			this.count = -1;
			this.upstatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertTable() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateDateNow(this.textField_NgayKG, sb, "Ngày khai giảng null");
			DataValidator.validateDay(this.textField_NgayTao, this.textField_NgayKG, sb, "");
			DataValidator.validateIsHocPhi(this.textField_HocPhi, sb, "Học phí null");
			DataValidator.validateIsThoiLuong(this.textField_ThoiLuong, sb, "Thời lượng null");
			DataValidator.validateCombobox(this.comboBox, sb, "Chưa chọn chuyên đề");
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Error");
				return;
			}
			String tenChuyenDe = (String) this.comboBox.getSelectedItem();
			ChuyenDeModel cd = new ChuyenDeModel();
			cd.setTenChuyenDe(tenChuyenDe);
			String maChuyenDe = ChuyenDeDAO.getInstance().selectByTen(cd).getMaChuyenDe();
			System.out.println(maChuyenDe);
			double hocPhi = Double.valueOf(this.textField_HocPhi.getText());
			int thoiLuong = Integer.valueOf(this.textField_ThoiLuong.getText());
			Date ngayKhaiGiang = XDate.dateFormat(this.textField_NgayKG.getText());
			String ghiChu = this.textArea.getText();
			String maNV = this.textField_NguoiTao.getText();
			Date ngayTao = XDate.dateFormat(this.textField_NgayTao.getText());
			KhoaHocModel kh = new KhoaHocModel(maChuyenDe, hocPhi, thoiLuong, ngayKhaiGiang, ghiChu, maNV, ngayTao);
			if (KhoaHocDAO.getInstance().insert(kh) > 0) {
				MsgBox.showMessageDialog(this, "Insert Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert Fail", "Notification");
			}
//			this.loadDataTableN();
			this.loadDataTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateTable() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateDateNow(this.textField_NgayKG, sb, "Ngày khai giảng null");
			DataValidator.validateDay(this.textField_NgayTao, this.textField_NgayKG, sb, "");
			DataValidator.validateIsHocPhi(this.textField_HocPhi, sb, "Học phí null");
			DataValidator.validateIsThoiLuong(this.textField_ThoiLuong, sb, "Thời lượng null");
			DataValidator.validateCombobox(this.comboBox, sb, "Chưa chọn chuyên đề");
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Error");
				return;
			}
			if (MsgBox.showConfirmDialog(this, "Do you want to Update", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//			int i_row = table.getSelectedRow();
//			System.out.println(i_row);
			int maKhoaHoc = (int) model_table.getValueAt(i_row, 0);
			String tenChuyenDe = (String) this.comboBox.getSelectedItem();
			ChuyenDeModel cd = new ChuyenDeModel();
			cd.setTenChuyenDe(tenChuyenDe);
			String maChuyenDe = ChuyenDeDAO.getInstance().selectByTen(cd).getMaChuyenDe();
			System.out.println(maChuyenDe);
			double hocPhi = Double.valueOf(this.textField_HocPhi.getText());
			int thoiLuong = Integer.valueOf(this.textField_ThoiLuong.getText());
			Date ngayKhaiGiang = XDate.dateFormat(this.textField_NgayKG.getText());
			String ghiChu = this.textArea.getText();
			String maNV = this.textField_NguoiTao.getText();
			Date ngayTao = XDate.dateFormat(this.textField_NgayTao.getText());
			KhoaHocModel kh = new KhoaHocModel(maKhoaHoc, maChuyenDe, hocPhi, thoiLuong, ngayKhaiGiang, ghiChu, maNV,
					ngayTao);
			System.out.println(kh);
			if (KhoaHocDAO.getInstance().update(kh) > 0) {
				MsgBox.showMessageDialog(this, "Update Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update Fail", "Notification");
			}
//			this.loadDataTable();
			this.loadDataTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTable() {
		try {
			if (MsgBox.showConfirmDialog(this, "Do you want to Delete", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			System.out.println(i_row);
			int maKhoaHoc = (int) model_table.getValueAt(i_row, 0);
			System.out.println(maKhoaHoc);
			KhoaHocModel kh = new KhoaHocModel();
			kh.setMaKhoaHoc(maKhoaHoc);
			if (KhoaHocDAO.getInstance().delete(kh) > 0) {
				MsgBox.showMessageDialog(this, "Delete successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Delete fail", "Notification");
			}
			this.loadDataTable();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void firstElement() {
		this.count = 0;
		table.setRowSelectionInterval(count, count);
		this.disPlayForm();
	}

	public void previousElement() {
		this.count--;
		if (this.count < 0) {
			this.count = 0;
		}
		table.setRowSelectionInterval(count, count);
		this.disPlayForm();
	}

	public void nextElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
//		int i_row = table.getSelectedRow();
		this.count = i_row;
		this.count++;
		System.out.println(count);
		if (this.count > model_table.getRowCount() - 1) {
			this.count = model_table.getRowCount() - 1;
		}
		table.setRowSelectionInterval(count, count);
		this.disPlayForm();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		this.count = model_table.getRowCount() - 1;
		table.setRowSelectionInterval(count, count);
		this.disPlayForm();
	}
	
	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}
}
