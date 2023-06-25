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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ChuyenDeJDialogCTL;
import dao.ChuyenDeDAO;
import lib.DataValidator;
import lib.MsgBox;
import lib.XImage;
import model.ChuyenDeModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class ChuyenDeJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnFirst;
	private JTextField textField_MaCD;
	private JTextField textField_TenCD;
	private JTextField textField_ThoiLuong;
	private JTextField textField_HocPhi;
	private JTable table;
	private JLabel lbl_IMG;
	private File file = null;
	private JTabbedPane tabbedPane;
	private JButton btn_Them;
	private Component btnSua;
	private JButton btnXoa;
	private JButton btnMoi;
	private JButton btnPre;
	private JButton btnNext;
	private JButton btnLast;
	private int count = 0;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ChuyenDeJDialog dialog = new ChuyenDeJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChuyenDeJDialog() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChuyenDeJDialog.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
		ChuyenDeJDialogCTL ctl = new ChuyenDeJDialogCTL(this);
		setBounds(100, 100, 675, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý Chuyên Đề");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 223, 28);
		contentPanel.add(lblNewLabel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 40, 655, 482);
		contentPanel.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Cập nhật", null, panel, null);
		panel.setLayout(null);

		btn_Them = new JButton("Thêm");
		btn_Them.addActionListener(ctl);
		btn_Them.setBounds(10, 420, 61, 23);
		panel.add(btn_Them);

		btnSua = new JButton("Sửa");
		((AbstractButton) btnSua).addActionListener(ctl);
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
		btnFirst.setBounds(422, 420, 45, 23);
		panel.add(btnFirst);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(477, 420, 49, 23);
		panel.add(btnPre);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(536, 420, 49, 23);
		panel.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(595, 420, 45, 23);
		panel.add(btnLast);

		JLabel lblNewLabel_1 = new JLabel("Hình logo");
		lblNewLabel_1.setBounds(10, 0, 107, 25);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mã chuyên đề");
		lblNewLabel_1_1.setBounds(204, 5, 130, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Tên chuyên đề");
		lblNewLabel_1_1_1.setBounds(204, 63, 146, 14);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Thời lượng");
		lblNewLabel_1_1_2.setBounds(203, 119, 147, 14);
		panel.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Học phí");
		lblNewLabel_1_1_3.setBounds(203, 176, 107, 14);
		panel.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_4 = new JLabel("Mô tả chuyên đề");
		lblNewLabel_1_1_4.setBounds(10, 236, 154, 14);
		panel.add(lblNewLabel_1_1_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setForeground(new Color(0, 0, 255));
		panel_2.setBorder(null);
		panel_2.setBounds(10, 27, 184, 198);
		panel.add(panel_2);
		panel_2.setLayout(null);

		lbl_IMG = new JLabel("");
		lbl_IMG.setName("IMG");
		lbl_IMG.addMouseListener(ctl);
		lbl_IMG.setBounds(10, 11, 164, 176);
		panel_2.add(lbl_IMG);

		textField_MaCD = new JTextField();
		textField_MaCD.addKeyListener(ctl);
		textField_MaCD.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_MaCD.setBackground(new Color(255, 255, 255));
		textField_MaCD.setBounds(202, 30, 438, 20);
		panel.add(textField_MaCD);
		textField_MaCD.setColumns(10);

		textField_TenCD = new JTextField();
		textField_TenCD.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_TenCD.setColumns(10);
		textField_TenCD.setBounds(203, 88, 437, 20);
		panel.add(textField_TenCD);

		textField_ThoiLuong = new JTextField();
		textField_ThoiLuong.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_ThoiLuong.setColumns(10);
		textField_ThoiLuong.setBounds(203, 145, 437, 20);
		panel.add(textField_ThoiLuong);

		textField_HocPhi = new JTextField();
		textField_HocPhi.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_HocPhi.setColumns(10);
		textField_HocPhi.setBounds(204, 205, 436, 20);
		panel.add(textField_HocPhi);

//		textArea = new JTextArea();

//		JScrollPane scrollPane = new JScrollPane(textArea);
//		scrollPane.setBounds(10, 261, 621, 117);
//		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Danh sách", null, panel_1, null);
		panel_1.setLayout(null);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Chuyên đề", "Tên Chuyên đề", "Học phí", "Thời lượng", "Hình", "Mô tả CD" }));
		table.addMouseListener(ctl);

		JScrollPane scrollPane_1 = new JScrollPane(table);
		scrollPane_1.setBounds(10, 11, 630, 432);
		panel_1.add(scrollPane_1);

		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
		Image img = XImage.resize(icon.getImage(), 164, 176);
		this.lbl_IMG.setIcon(new ImageIcon(img));

		textArea = new JTextArea();
		textArea.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBorder(null);
		scrollPane.setBounds(10, 268, 630, 141);
		panel.add(scrollPane);

//		this.file = new File("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg");

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setName("Exit");
		lblNewLabel_2.addMouseListener(ctl);
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(617, 11, 48, 28);
		contentPanel.add(lblNewLabel_2);

		this.setUndecorated(true);
		this.upstatus();
		this.loadDataTable();
		this.setLocationRelativeTo(null);
	}

	public void loadDataTable() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			ArrayList<ChuyenDeModel> list = ChuyenDeDAO.getInstance().selectAll();
			model_table.setRowCount(0);
			for (ChuyenDeModel cd : list) {
				model_table.addRow(new Object[] { cd.getMaChuyenDe(), cd.getTenChuyenDe(), cd.getHocPhi(),
						cd.getThoiLuong(), cd.getHinhLogo(), cd.getMoTa() });
			}
			model_table.fireTableDataChanged();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ChuyenDeModel getChuyenDe() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String id = model_table.getValueAt(i_row, 0) + "";
		ChuyenDeModel cd = new ChuyenDeModel();
		cd.setMaChuyenDe(id);
		ChuyenDeModel cdd = ChuyenDeDAO.getInstance().selectByID(cd);
		return cdd;
	}

	public void updateForm() {
		try {
			ChuyenDeModel cd = this.getChuyenDe();
			this.textField_MaCD.setText(cd.getMaChuyenDe());
			this.textField_TenCD.setText(cd.getTenChuyenDe());
			this.textField_ThoiLuong.setText(cd.getThoiLuong() + "");
			this.textField_HocPhi.setText(cd.getHocPhi() + "");
			this.textArea.setText(cd.getMoTa());
			this.lbl_IMG.setIcon(this.uploadLogo(cd.getHinhLogo()));
			this.tabbedPane.setSelectedIndex(0);
			int i_row = table.getSelectedRow();
			this.count = i_row;
			this.upstatus();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ImageIcon uploadLogo(String str) {
		ImageIcon icon = XImage.readImage(str);
		Image img = XImage.resize(icon.getImage(), 164, 176);
		ImageIcon resize = new ImageIcon(img);
//		this.lbl_IMG.setIcon(new ImageIcon(img));
		return resize;
	}

	public void imageFrom() {
		try {
			JFileChooser fc = new JFileChooser();
			int option = fc.showOpenDialog(this);
			if (option == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
//				System.out.println(file.getAbsolutePath());
//				System.out.println(file.getAbsoluteFile());
				System.out.println(file.getAbsoluteFile().getName());
				XImage.saveImage(file.getAbsoluteFile().getName());
				ImageIcon icon = new ImageIcon(file.getPath());
				Image img = lib.XImage.resize(icon.getImage(), 164, 176);
				this.lbl_IMG.setIcon(new ImageIcon(img));
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertTable() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateIsMaChuyenDe(this.textField_MaCD, sb, "Mã CD null");
			DataValidator.validateIsHoTen(this.textField_TenCD, sb, "Tên CD null");
			DataValidator.validateIsHocPhi(this.textField_HocPhi, sb, " Học phí null");
			DataValidator.validateIsThoiLuong(this.textField_ThoiLuong, sb, "Thời lượng null");
			if (this.file == null) {
				sb.append("Hình null").append("\n");
			}
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Error");
				return;
			}
			String maChuyenDe = this.textField_MaCD.getText();
			String tenChuyenDe = this.textField_TenCD.getText();
			double hocPhi = Double.valueOf(this.textField_HocPhi.getText() + "");
			int thoiLuong = Integer.valueOf(this.textField_ThoiLuong.getText() + "");
			String hinhLogo = "";
//			if (!file.getAbsoluteFile().getName().equals("")) {
//				hinhLogo = file.getName();
//			}
			if (file != null) {
				hinhLogo = file.getName();
			}

			String moTa = this.textArea.getText();
			ChuyenDeModel cd = new ChuyenDeModel(maChuyenDe, tenChuyenDe, hocPhi, thoiLuong, hinhLogo, moTa);
			if (ChuyenDeDAO.getInstance().selectByID(cd) != null) {
				if (MsgBox.showConfirmDialog(this, "CD đã tồn tại bạn muốn update",
						"Notification") == JOptionPane.NO_OPTION) {
					return;
				}
				if (ChuyenDeDAO.getInstance().update(cd) > 0) {
					MsgBox.showMessageDialog(this, "Update successfull", "Update");
				} else {
					MsgBox.showMessageDialog(this, "Update fail", "Update");
				}
			} else {
				if (ChuyenDeDAO.getInstance().insert(cd) > 0) {
					MsgBox.showMessageDialog(this, "Insert successfull", "Insert");
				} else {
					MsgBox.showMessageDialog(this, "Insert fail", "Insert");
				}
			}
			this.loadDataTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upstatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		this.textField_MaCD.setEditable(!edit);
		this.btn_Them.setEnabled(!edit);
		this.btnSua.setEnabled(edit);
		this.btnXoa.setEnabled(edit);

		this.btnFirst.setEnabled(edit && !first);
		this.btnPre.setEnabled(edit && !first);
		this.btnNext.setEnabled(edit && !last);
		this.btnLast.setEnabled(edit && !last);
	}

	public void firstElement() {
		this.count = 0;
		table.setRowSelectionInterval(count, count);
		this.updateForm();
	}

	public void previousElement() {
		this.count--;
		if (this.count < 0) {
			this.count = 0;
		}
		table.setRowSelectionInterval(count, count);
		this.updateForm();
	}

	public void nextElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = this.table.getSelectedRow();
		System.out.println(i_row);
		count = i_row;
		this.count++;
		System.out.println(count);
		if (this.count > model_table.getRowCount() - 1) {
			this.count = model_table.getRowCount() - 1;
		}
		table.setRowSelectionInterval(count, count);
		this.updateForm();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		this.count = model_table.getRowCount() - 1;
		table.setRowSelectionInterval(count, count);
		this.updateForm();
	}

	public void resetForm() {
		this.textField_MaCD.setText("");
		this.textField_TenCD.setText("");
		this.textField_ThoiLuong.setText("");
		this.textField_HocPhi.setText("");
		this.textArea.setText("");
		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
		Image img = XImage.resize(icon.getImage(), 164, 176);
		this.lbl_IMG.setIcon(new ImageIcon(img));
		this.textField_MaCD.requestFocus();
		this.count = -1;
		this.upstatus();
	}

	public void deleteTable() {
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateIsID(this.textField_MaCD, sb, "Mã Chuyên đề null");
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Error");
				return;
			}
			if (MsgBox.showConfirmDialog(this, "Do you want to delete", "Notification") == JOptionPane.NO_OPTION) {
				return;
			}
			String maChuyenDe = this.textField_MaCD.getText();
			ChuyenDeModel cd = new ChuyenDeModel();
			cd.setMaChuyenDe(maChuyenDe);
			if (ChuyenDeDAO.getInstance().delete(cd) > 0) {
				MsgBox.showMessageDialog(this, "Delete successful", "Delete");
			} else {
				MsgBox.showMessageDialog(this, "Delete fail", "Delete");
			}
			this.loadDataTable();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}

	public boolean checkMaChuyenDe() {
		try {
			String maChuyenDe = this.textField_MaCD.getText().trim();
			ChuyenDeModel cd = new ChuyenDeModel();
			cd.setMaChuyenDe(maChuyenDe);
			if (ChuyenDeDAO.getInstance().selectByID(cd) != null) {
				this.textField_MaCD.setBackground(Color.orange);
				MsgBox.showErrorDialog(this, "Mã chuyên đề đã tồn tại", "Notification");
				return true;
			} else {
				this.textField_MaCD.setBackground(Color.white);
			}
		} catch (Exception e) {
			// TODO: handle exceptio
			e.printStackTrace();
		}
		return false;
	}
}
