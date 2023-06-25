package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

import controller.Form_ChuyenPhongCTL;
import controller.Form_ToaNhaCTL;
import dao.ToaNhaDao;
import lib.DataValidator;
import lib.MsgBox;
import lib.XImage;
import model.ToaNhaModel;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Form_ToaNha extends JPanel {
	private JTable tblToaNha;
	private JTextField txtMaToaNha;
	private JTextField txtTenToaNha;
	private JTextField txtPhuong;
	private JTextField txtQuan;
	private JTextField txtTinh;
	private JTextField txtSoPhong;
	private JTextArea txtGhiChu;
	private JLabel lbl_IMG_Left;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLamMoi;
	private byte[] arr_IMG;
	private int count = 0;
	private JButton btnNext;
	private JButton btnPre;
	private JButton btnFirst;
	private JButton btnLast;

	/**
	 * Create the panel.
	 */
	public Form_ToaNha() {
		Form_ToaNhaCTL ctl = new Form_ToaNhaCTL(this);
		setBounds(0, 0, 1200, 600);
		setBackground(new Color(227, 227, 227));
		setOpaque(false);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(227, 227, 227));
		panel.setBounds(0, 0, 1200, 600);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 548, 1200, 41);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.addActionListener(ctl);
		btnThem.setBounds(0, 11, 89, 23);
		panel_1.add(btnThem);

		btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(ctl);
		btnXoa.setBounds(88, 11, 89, 23);
		panel_1.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.addActionListener(ctl);
		btnSua.setBounds(177, 11, 89, 23);
		panel_1.add(btnSua);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.addActionListener(ctl);
		btnLamMoi.setBounds(265, 11, 89, 23);
		panel_1.add(btnLamMoi);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(875, 11, 89, 23);
		panel_1.add(btnLast);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(610, 11, 89, 23);
		panel_1.add(btnFirst);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(698, 11, 89, 23);
		panel_1.add(btnPre);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(787, 11, 89, 23);
		panel_1.add(btnNext);

		tblToaNha = new JTable();
		tblToaNha.setShowVerticalLines(false);
		tblToaNha.setSelectionBackground(new Color(255, 128, 0));
		tblToaNha.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mã tòa nhà", "Tên tòa nhà",
				"Hình ảnh", "Số phòng", "Phường, xã", "Quận, huyện", "Tỉnh, TP", "Ghi chú" }));
		tblToaNha.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(tblToaNha);
		scrollPane.setBounds(10, 252, 953, 282);
		panel.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Mã tòa nhà:");
		lblNewLabel.setBounds(261, 11, 65, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Hình ảnh:");
		lblNewLabel_1.setBounds(10, 11, 48, 14);
		panel.add(lblNewLabel_1);

		JLabel lblTnTaNh = new JLabel("Tên tòa nhà:");
		lblTnTaNh.setBounds(261, 36, 65, 14);
		panel.add(lblTnTaNh);

		JLabel lblNewLabel_3 = new JLabel("Quận, huyện:");
		lblNewLabel_3.setBounds(261, 86, 79, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Số phòng:");
		lblNewLabel_4.setBounds(261, 136, 65, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tỉnh, TP:");
		lblNewLabel_5.setBounds(261, 111, 48, 14);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Phường, xã:");
		lblNewLabel_6.setBounds(261, 61, 65, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Ghi chú:");
		lblNewLabel_7.setBounds(261, 161, 48, 14);
		panel.add(lblNewLabel_7);

		lbl_IMG_Left = new JLabel("New label");
		lbl_IMG_Left.setName("lbl_IMG");
		lbl_IMG_Left.addMouseListener(ctl);
		lbl_IMG_Left.setIcon(new ImageIcon(Form_ToaNha.class.getResource("/icon/BGToaNha.png")));
		lbl_IMG_Left.setBounds(10, 36, 241, 205);
		panel.add(lbl_IMG_Left);

		txtMaToaNha = new JTextField();
		txtMaToaNha.setBounds(336, 8, 268, 20);
		panel.add(txtMaToaNha);
		txtMaToaNha.setColumns(10);

		txtTenToaNha = new JTextField();
		txtTenToaNha.setColumns(10);
		txtTenToaNha.setBounds(336, 33, 268, 20);
		panel.add(txtTenToaNha);

		txtPhuong = new JTextField();
		txtPhuong.setColumns(10);
		txtPhuong.setBounds(336, 58, 268, 20);
		panel.add(txtPhuong);

		txtQuan = new JTextField();
		txtQuan.setColumns(10);
		txtQuan.setBounds(336, 83, 268, 20);
		panel.add(txtQuan);

		txtTinh = new JTextField();
		txtTinh.setColumns(10);
		txtTinh.setBounds(336, 108, 268, 20);
		panel.add(txtTinh);

		txtSoPhong = new JTextField();
		txtSoPhong.setColumns(10);
		txtSoPhong.setBounds(336, 133, 268, 20);
		panel.add(txtSoPhong);

		txtGhiChu = new JTextArea();
		txtGhiChu.setBounds(336, 156, 268, 85);
		panel.add(txtGhiChu);

		JLabel lbl_IMG_Right = new JLabel("New label");
		lbl_IMG_Right.setIcon(new ImageIcon(Form_ToaNha.class.getResource("/icon/BGToaNhaR.png")));
		lbl_IMG_Right.setBounds(614, 8, 347, 233);
		panel.add(lbl_IMG_Right);

		this.tblToaNha.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.tblToaNha.getTableHeader().setOpaque(false);
		this.tblToaNha.getTableHeader().setBackground(new Color(32, 136, 203));
		this.tblToaNha.getTableHeader().setForeground(new Color(255, 255, 255));
		this.tblToaNha.setRowHeight(25);

		upStatus();
		loadDataTableToaNha();
	}

	public void resetForm() {
		txtGhiChu.setText("");
		txtMaToaNha.setText("");
		txtPhuong.setText("");
		txtQuan.setText("");
		txtSoPhong.setText("");
		txtTenToaNha.setText("");
		txtTinh.setText("");
		txtMaToaNha.requestFocus();
		lbl_IMG_Left.setIcon(new ImageIcon(Form_ToaNha.class.getResource("/icon/BGToaNha.png")));
		count = -1;
		upStatus();
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
			Image img = XImage.resize(icon.getImage(), 241, 205);
			ImageIcon resize = new ImageIcon(img);
			this.lbl_IMG_Left.setIcon(resize);
			this.arr_IMG = XImage.toByteArray(img, "jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void insertTableToaNha() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaToaNha, sb, "Mã tòa nhà null");
		DataValidator.validateEmpty(txtTenToaNha, sb, "Tên tòa nhà null");
		DataValidator.validateEmpty(txtPhuong, sb, "Phường, xã null");
		DataValidator.validateEmpty(txtQuan, sb, "Phường, xã null");
		DataValidator.validateEmpty(txtTinh, sb, "Phường, xã null");
		DataValidator.validateEmpty(txtSoPhong, sb, "Phường, xã null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maToaNha = txtMaToaNha.getText();
		String tenToaNha = txtTenToaNha.getText();
		byte[] hinhAnh = arr_IMG;
		String phuong = txtPhuong.getText();
		String quan = txtQuan.getText();
		String tinh = txtTinh.getText();
		int soPhong = Integer.valueOf(txtSoPhong.getText());
		String ghiChu = txtGhiChu.getText();
		ToaNhaModel t = new ToaNhaModel(maToaNha, tenToaNha, hinhAnh, soPhong, phuong, quan, tinh, ghiChu);
		if (ToaNhaDao.getInstance().selectByID(t) != null) {
			if(MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật", "Notification")==JOptionPane.NO_OPTION) {
				return;
			}
			if (ToaNhaDao.getInstance().update(t) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notification");
			}

		} else {
			if (ToaNhaDao.getInstance().insert(t) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert fail", "Notification");
			}
		}
		loadDataTableToaNha();
	}

	public ToaNhaModel getValuesForm() {
		DefaultTableModel model_table = (DefaultTableModel) tblToaNha.getModel();
		int i_row = tblToaNha.getSelectedRow();
		String maToaNha = model_table.getValueAt(i_row, 0) + "";
		ToaNhaModel t = ToaNhaDao.getInstance().selectByID(new ToaNhaModel(maToaNha));
		return t;
	}

	public void displayOnForm() {
		try {
			ToaNhaModel t = getValuesForm();
			txtMaToaNha.setText(t.getMaToaNha());
			txtTenToaNha.setText(t.getTenToaNha());
			txtPhuong.setText(t.getPhuong());
			txtQuan.setText(t.getQuan());
			txtTinh.setText(t.getTinh());
			txtSoPhong.setText(t.getSoPhong() + "");
			txtGhiChu.setText(t.getGhiChu());
			if (t.getHinhAnh() != null) {
				Image img = XImage.createImageFromByteArray(t.getHinhAnh(), "jpg");
				this.lbl_IMG_Left.setIcon(new ImageIcon(img));
				this.arr_IMG = t.getHinhAnh();
			} else {
				arr_IMG = t.getHinhAnh();
				lbl_IMG_Left.setIcon(new ImageIcon(Form_ToaNha.class.getResource("/icon/BGToaNha.png")));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) tblToaNha.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txtMaToaNha.setEditable(!edit);
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
		tblToaNha.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void previousElement() {
		count--;
		if (count < 0) {
			count = 0;
		}
		tblToaNha.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void nextElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = tblToaNha.getSelectedRow();
		count = i_row;
		count++;
		if (count > tblToaNha.getRowCount() - 1) {
			count = tblToaNha.getRowCount() - 1;
		}
		tblToaNha.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) tblToaNha.getModel();
		count = model_table.getRowCount() - 1;
		tblToaNha.setRowSelectionInterval(count, count);
		upStatus();
		displayOnForm();
	}

	public void deleteTableToaNha() {
		ToaNhaModel t = getValuesForm();
		if (MsgBox.showConfirmDialog(this, "Bạn muốn xóa?", "Notification") == JOptionPane.NO_OPTION) {
			return;
		}
		if (ToaNhaDao.getInstance().delete(t) > 0) {
			MsgBox.showMessageDialog(this, "Delete success", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete fail", "Notification");
		}
		loadDataTableToaNha();
	}

	public void loadDataTableToaNha() {
		DefaultTableModel model_table = (DefaultTableModel) tblToaNha.getModel();
		ArrayList<ToaNhaModel> list = ToaNhaDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (ToaNhaModel toaNhaModel : list) {
			model_table.addRow(new Object[] { toaNhaModel.getMaToaNha(), toaNhaModel.getTenToaNha(),
					toaNhaModel.getHinhAnh(), toaNhaModel.getSoPhong(), toaNhaModel.getPhuong(), toaNhaModel.getQuan(),
					toaNhaModel.getTinh(), toaNhaModel.getGhiChu() });
		}
	}
}
