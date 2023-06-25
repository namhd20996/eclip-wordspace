package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.transaction.xa.Xid;

import controller.LoaiHangJDialogCTL;
import dao.LoaiHangDao;
import lib.DataValidator;
import lib.MsgBox;
import lib.XImage;
import model.LoaiHangModel;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class LoaiHangJDialog extends JDialog {
	private JTextField txt_MaLoaiHang;
	private JTextField txt_TenLoaiHang;
	private JTable table;
	private JLabel lbl_IMG;
	private JTextArea txt_GhiChu;
	private byte[] arrIMG;
	private JLabel lbl_BackG;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnNew;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnAdd;
	private JButton btnFirst;
	private JTabbedPane tabbedPane;
	private int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LoaiHangJDialog dialog = new LoaiHangJDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public LoaiHangJDialog() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		LoaiHangJDialogCTL ctl = new LoaiHangJDialogCTL(this);
		JLabel lbl_LoaiHang = new JLabel("Quản Lí Loại Hàng");
		lbl_LoaiHang.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_LoaiHang.setForeground(new Color(0, 0, 255));
		lbl_LoaiHang.setBounds(10, 11, 530, 27);
		getContentPane().add(lbl_LoaiHang);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(10, 49, 655, 473);
		getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Cập nhật", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hình ảnh");
		lblNewLabel.setBounds(10, 11, 48, 14);
		panel.add(lblNewLabel);

		JLabel lblMLoiHng = new JLabel("Mã loại hàng");
		lblMLoiHng.setBounds(253, 11, 101, 14);
		panel.add(lblMLoiHng);

		JLabel lblTnLoiHng = new JLabel("Tên loại hàng");
		lblTnLoiHng.setBounds(253, 64, 140, 14);
		panel.add(lblTnLoiHng);

		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setBounds(10, 247, 48, 14);
		panel.add(lblGhiCh);

		txt_MaLoaiHang = new JTextField();
		txt_MaLoaiHang.setBounds(253, 36, 387, 20);
		panel.add(txt_MaLoaiHang);
		txt_MaLoaiHang.setColumns(10);

		txt_TenLoaiHang = new JTextField();
		txt_TenLoaiHang.setColumns(10);
		txt_TenLoaiHang.setBounds(253, 89, 387, 20);
		panel.add(txt_TenLoaiHang);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 36, 219, 208);
		panel.add(panel_2);
		panel_2.setLayout(null);

		lbl_IMG = new JLabel("New label");
		lbl_IMG.setName("IMG");
		lbl_IMG.addMouseListener(ctl);
		lbl_IMG.setBounds(10, 11, 199, 186);
		panel_2.add(lbl_IMG);

		lbl_BackG = new JLabel("New label");
		lbl_BackG.setIcon(new ImageIcon(LoaiHangJDialog.class.getResource("/IMG_JPG/BackG.png")));
		lbl_BackG.setBounds(253, 120, 387, 125);
		panel.add(lbl_BackG);

		txt_GhiChu = new JTextArea();
		txt_GhiChu.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		txt_GhiChu.setBounds(10, 272, 630, 117);
		panel.add(txt_GhiChu);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(ctl);
		btnAdd.setBounds(10, 411, 58, 23);
		panel.add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setBounds(78, 411, 67, 23);
		panel.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(ctl);
		btnDelete.setBounds(155, 411, 67, 23);
		panel.add(btnDelete);

		btnNew = new JButton("New");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(232, 411, 58, 23);
		panel.add(btnNew);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(582, 411, 58, 23);
		panel.add(btnLast);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(514, 411, 58, 23);
		panel.add(btnNext);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(446, 411, 58, 23);
		panel.add(btnPre);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(378, 411, 58, 23);
		panel.add(btnFirst);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Danh sách", null, panel_1, null);
		panel_1.setLayout(null);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã loại hàng", "Tên loại hàng", "Ghi chú", "Hình ảnh" }));
		table.addMouseListener(ctl);

		setBounds(100, 100, 675, 533);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 630, 423);
		panel_1.add(scrollPane);

		JLabel lbl_Exit = new JLabel("X");
		lbl_Exit.setName("Exit");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setForeground(new Color(255, 0, 0));
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setBounds(617, 11, 48, 27);
		getContentPane().add(lbl_Exit);

		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
		Image img = XImage.resize(icon.getImage(), 199, 186);
		lbl_IMG.setIcon(new ImageIcon(img));
		
		upStatus();
		loadDataTable();
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);

	}

	public void resetForm() {
		txt_MaLoaiHang.setText("");
		txt_TenLoaiHang.setText("");
		txt_GhiChu.setText("");
		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
		Image img = XImage.resize(icon.getImage(), 199, 186);
		lbl_IMG.setIcon(new ImageIcon(img));
		txt_MaLoaiHang.requestFocus();
		count = -1;
		upStatus();
	}

	public void insertTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txt_MaLoaiHang, sb, "Mã loại hàng null");
		DataValidator.validateIsHoTen(txt_TenLoaiHang, sb, "Tên loại null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maLoaiHang = txt_MaLoaiHang.getText();
		String tenLoaiHang = txt_TenLoaiHang.getText();
		String ghiChu = txt_GhiChu.getText();
		byte[] hinhAnh = arrIMG;
		LoaiHangModel lh = new LoaiHangModel(maLoaiHang, tenLoaiHang, ghiChu, hinhAnh);
		if (LoaiHangDao.getInstance().selectByID(lh) != null) {
			if (MsgBox.showConfirmDialog(this, "Loại hàng đã tồn tại bạn muốn cập nhật?",
					"Notificaiton") == JOptionPane.NO_OPTION) {
				return;
			}
			if (LoaiHangDao.getInstance().update(lh) > 0) {
				MsgBox.showMessageDialog(this, "Update Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Update Fail", "Notification");
			}
		} else {
			if (LoaiHangDao.getInstance().insert(lh) > 0) {
				MsgBox.showMessageDialog(this, "Insert Successfull", "Notification");
			} else {
				MsgBox.showMessageDialog(this, "Insert Fail", "Notification");
			}
		}
		loadDataTable();
	}

	public void deleteTable() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txt_MaLoaiHang, sb, "Mã loại hàng null");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notification");
			return;
		}
		String maLoaiHang = txt_MaLoaiHang.getText();
		LoaiHangModel lh = new LoaiHangModel();
		lh.setMaLoaiHang(maLoaiHang);
		if (LoaiHangDao.getInstance().delete(lh) > 0) {
			MsgBox.showMessageDialog(this, "Delete Successfull", "Notification");
		} else {
			MsgBox.showMessageDialog(this, "Delete Faile", "Notification");
		}
		loadDataTable();
	}

	private void loadDataTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		ArrayList<LoaiHangModel> list = LoaiHangDao.getInstance().selectAll();
		model_table.setRowCount(0);
		for (LoaiHangModel loaiHangModel : list) {
			model_table.addRow(new Object[] { loaiHangModel.getMaLoaiHang(), loaiHangModel.getTenLoaiHang(),
					loaiHangModel.getGhiChu(), loaiHangModel.getHinhAnh() });
		}
		model_table.fireTableDataChanged();
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
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
			Image img = XImage.resize(icon.getImage(), 199, 186);
			ImageIcon resize = new ImageIcon(img);
			this.lbl_IMG.setIcon(resize);
			this.arrIMG = XImage.toByteArray(img, "jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void displayFormCapNhat() {
		try {
			LoaiHangModel lh = getLoaiHang();
			txt_MaLoaiHang.setText(lh.getMaLoaiHang());
			txt_TenLoaiHang.setText(lh.getTenLoaiHang());
			txt_GhiChu.setText(lh.getGhiChu());
			if (lh.getHinhAnh() != null) {
				arrIMG = lh.getHinhAnh();
				Image icon = XImage.createImageFromByteArray(lh.getHinhAnh(), "jpg");
				lbl_IMG.setIcon(new ImageIcon(icon));
			} else {
				arrIMG = lh.getHinhAnh();
				ImageIcon icon = new ImageIcon(
						LoaiHangJDialog.class.getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
				Image img = XImage.resize(icon.getImage(), 199, 186);
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

	public LoaiHangModel getLoaiHang() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maLoaiHang = model_table.getValueAt(i_row, 0) + "";
		LoaiHangModel lh = new LoaiHangModel();
		lh.setMaLoaiHang(maLoaiHang);
		LoaiHangModel lhd = LoaiHangDao.getInstance().selectByID(lh);
		return lhd;
	}

	public void upStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		txt_MaLoaiHang.setEditable(!edit);
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
}
