package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Form_NhanVienCTL;
import dao.NhanVienDao;
import lib.DataValidator;
import lib.MaHoa;
import lib.MsgBox;
import lib.XImage;
import model.NhanVienModel;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class Form_NhanVien extends JPanel {
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtEmail;
	private JTable table;
	private JTextField txtFind;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPre;
	private JButton btnFirst;
	private JButton btnLamMoi;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private JRadioButton rdoUser;
	private JRadioButton rdoAdmin;
	private JRadioButton rdoNu;
	private JRadioButton rdoNam;
	private ButtonGroup btnGroup_Gender;
	private ButtonGroup btnGroup_Role;
	private int count = 0;
	private JPasswordField txtMatKhau;
	private byte[] arr_IMG;
	private JLabel lbl_IMG;

	/**
	 * Create the panel.
	 */
	public Form_NhanVien() {
		Form_NhanVienCTL ctl = new Form_NhanVienCTL(this);
		setBounds(0, 11, 1200, 920);
		setBackground(new Color(255, 255, 255));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã nhân viên:");
		lblNewLabel.setBounds(10, 11, 92, 14);
		add(lblNewLabel);

		JLabel lblTnNhnVin = new JLabel("Tên nhân viên:");
		lblTnNhnVin.setBounds(10, 48, 74, 14);
		add(lblTnNhnVin);

		JLabel lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setBounds(10, 87, 48, 14);
		add(lblGiiTnh);

		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setBounds(267, 11, 64, 14);
		add(lblMtKhu);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(267, 48, 48, 14);
		add(lblEmail);

		JLabel lblVaiTr = new JLabel("Vai trò:");
		lblVaiTr.setBounds(267, 87, 48, 14);
		add(lblVaiTr);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(87, 8, 170, 20);
		add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(87, 45, 170, 20);
		add(txtTenNhanVien);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(325, 45, 187, 20);
		add(txtEmail);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(87, 83, 55, 23);
		add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(209, 83, 48, 23);
		add(rdoNu);

		btnGroup_Gender = new ButtonGroup();
		btnGroup_Gender.add(rdoNu);
		btnGroup_Gender.add(rdoNam);

		rdoAdmin = new JRadioButton("Admin");
		rdoAdmin.setBounds(325, 83, 64, 23);
		add(rdoAdmin);

		rdoUser = new JRadioButton("User");
		rdoUser.setBounds(457, 83, 55, 23);
		add(rdoUser);

		btnGroup_Role = new ButtonGroup();
		btnGroup_Role.add(rdoAdmin);
		btnGroup_Role.add(rdoUser);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã nhân viên", "Tên nhân viên", "Mật khẩu", "Giới tính", "Vai trò", "Email" }));
		table.setName("tblNhanVien");
		table.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 179, 947, 337);
		add(scrollPane);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(10, 557, 89, 23);
		add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(87, 557, 89, 23);
		add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(168, 557, 89, 23);
		add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(253, 557, 89, 23);
		add(btnLamMoi);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(607, 557, 89, 23);
		add(btnFirst);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(695, 557, 89, 23);
		add(btnPre);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(776, 557, 89, 23);
		add(btnNext);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(861, 557, 89, 23);
		add(btnLast);

		JLabel lblTmTheoM = new JLabel("Tìm theo mã nhân viên:");
		lblTmTheoM.setBounds(10, 151, 132, 14);
		add(lblTmTheoM);

		txtFind = new JTextField();
		txtFind.setColumns(10);
		txtFind.setBounds(172, 148, 170, 20);
		add(txtFind);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 124, 502, 14);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 532, 947, 14);
		add(separator_1);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Form_NhanVien.class.getResource("/IMG_JPG/BG_NhanVien.png")));
		lblNewLabel_1.setBounds(739, 8, 215, 160);
		add(lblNewLabel_1);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 10));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setBounds(325, 8, 187, 20);
		add(txtMatKhau);

		lbl_IMG = new JLabel("New label");
		lbl_IMG.setName("lbl_IMG");
		lbl_IMG.addMouseListener(ctl);
		lbl_IMG.setBounds(522, 8, 215, 160);
		add(lbl_IMG);
		loadDataTable();
		upStatus();
	}

	public void resetForm() {
		txtMaNhanVien.setText("");
		txtTenNhanVien.setText("");
		txtEmail.setText("");
		txtFind.setText("");
		txtMatKhau.setText("");
		btnGroup_Gender.clearSelection();
		btnGroup_Role.clearSelection();
		table.getSelectionModel().clearSelection();
		count = -1;
		upStatus();
	}

	public void insertTableNhanVien() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaNhanVien, sb, "Mã nhân viên null");
		DataValidator.validateIsHoTen(txtTenNhanVien, sb, "Tên nhân viên null");
		DataValidator.validatePassword(txtMatKhau, sb, "Mật khẩu null");
		DataValidator.validateIsEmail(txtEmail, sb, "Email null");
		DataValidator.validateChecked(btnGroup_Gender, sb, "Chưa chọn giới tính");
		DataValidator.validateChecked(btnGroup_Role, sb, "Chưa chọn vai trò");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maNhanVien = txtMaNhanVien.getText();
		String tenNhanVien = txtTenNhanVien.getText();
		String matKhau = new String(txtMatKhau.getText());
		String email = txtEmail.getText();
		String gioiTinh = rdoNam.isSelected() ? "Nam" : "Nữ";
		boolean vaiTro = rdoAdmin.isSelected() ? true : false;
		String maXacThuc = null;
		Timestamp thoiGianHieuLucMaXacThuc = new Timestamp(System.currentTimeMillis());
		boolean trangThaiXacThuc = true;
		byte[] hinhAnh = arr_IMG;
		NhanVienModel nv = new NhanVienModel(maNhanVien, MaHoa.toSHA1(matKhau), tenNhanVien, gioiTinh, vaiTro, email,
				maXacThuc, thoiGianHieuLucMaXacThuc, trangThaiXacThuc, hinhAnh);
		if (NhanVienDao.getInstance().selectByID(nv) != null) {
			if (MsgBox.showConfirmDialog(this, "Mã nhân viên đã tồn tại bạn muốn cập nhật",
					"Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			if (NhanVienDao.getInstance().update(nv) > 0) {
				MsgBox.showMessageDialog(this, "Success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Fail", "Notification");
			}
		} else {
			if (NhanVienDao.getInstance().insert(nv) > 0) {
				MsgBox.showMessageDialog(this, "Success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Fail", "Notification");
			}
		}
		loadDataTable();
	}

	public void deleteTable() {
		NhanVienModel nv = getValueForm();
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa?", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		if (NhanVienDao.getInstance().delete(nv) > 0) {
			MsgBox.showMessageDialog(this, "Success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Fail", "Notification");
		}
		loadDataTable();
	}

	public void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		ArrayList<NhanVienModel> list = NhanVienDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (NhanVienModel nhanVienModel : list) {
			model_table.addRow(new Object[] { nhanVienModel.getMaNhanVien(), nhanVienModel.getTenNhanVien(),
					nhanVienModel.getMatKhau(), nhanVienModel.getGioiTinh(),
					nhanVienModel.isVaiTro() ? "Admin" : "User", nhanVienModel.getEmail() });
		}
	}

	public NhanVienModel getValueForm() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maNhanVien = model_table.getValueAt(i_row, 0) + "";
		NhanVienModel n = new NhanVienModel();
		n.setMaNhanVien(maNhanVien);
		NhanVienModel nv = NhanVienDao.getInstance().selectByID(n);
		return nv;
	}

	public void displayOnForm() {
		try {
			NhanVienModel nv = getValueForm();
			txtMaNhanVien.setText(nv.getMaNhanVien());
			txtTenNhanVien.setText(nv.getTenNhanVien());
			txtEmail.setText(nv.getEmail());
			txtMatKhau.setText(nv.getMatKhau());
			String gioiTinhStr = nv.getGioiTinh();
			if (gioiTinhStr != null) {
				if (gioiTinhStr.equals("Nam")) {
					rdoNam.setSelected(true);
				} else {
					rdoNu.setSelected(true);
				}
			}
			if (nv.isVaiTro()) {
				rdoAdmin.setSelected(true);
			} else {
				rdoUser.setSelected(true);
			}
			if (nv.getHinhAnh() != null) {
				Image img = XImage.createImageFromByteArray(nv.getHinhAnh(), "jpg");
				this.lbl_IMG.setIcon(new ImageIcon(img));
				this.arr_IMG = nv.getHinhAnh();
			} else {
				arr_IMG = nv.getHinhAnh();
				lbl_IMG.setIcon(new ImageIcon(Form_ToaNha.class.getResource("/icon/BGToaNha.png")));
			}
			int i_row = table.getSelectedRow();
			count = i_row;
			upStatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txtMaNhanVien.setEditable(!edit);
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
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count > table.getRowCount() - 1) {
			count = table.getRowCount() - 1;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		count = model_table.getRowCount() - 1;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
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
			Image img = XImage.resize(icon.getImage(), 215, 160);
			ImageIcon resize = new ImageIcon(img);
			this.lbl_IMG.setIcon(resize);
			this.arr_IMG = XImage.toByteArray(img, "jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
