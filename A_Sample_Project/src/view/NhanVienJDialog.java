package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.NhanVienDialogCTL;
import dao.NhanVienDAO;
import lib.Auth;
import lib.DataValidator;
import lib.MsgBox;
import model.NhanVienModel;

import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class NhanVienJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_MaNhanVien;
	private JTextField textField_HoTen;
	private JButton btnFirst;
	private JRadioButton rdo_TP;
	private Component rdo_NV;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_Confirm;
	private int count = 0;
	private ButtonGroup buttonGroup;
	private AbstractButton btn_Them;
	private AbstractButton btnSua;
	private JButton btnXoa;
	private AbstractButton btnMoi;
	private AbstractButton btnPre;
	private JButton btnNext;
	private JButton btnLast;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			NhanVienJDialog dialog = new NhanVienJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NhanVienJDialog() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(NhanVienJDialog.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
		NhanVienDialogCTL ctl = new NhanVienDialogCTL(this);
		setBounds(100, 100, 675, 464);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 38, 655, 415);
		contentPanel.add(tabbedPane);

		buttonGroup = new ButtonGroup();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Cập nhật", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setBounds(10, 11, 175, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu");
		lblNewLabel_1_1.setBounds(10, 76, 142, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Xác nhân mật khẩu");
		lblNewLabel_1_2.setBounds(10, 131, 142, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Họ tên");
		lblNewLabel_1_3.setBounds(10, 194, 48, 14);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Vai trò");
		lblNewLabel_1_4.setBounds(10, 298, 142, 14);
		panel.add(lblNewLabel_1_4);

		textField_MaNhanVien = new JTextField();
//		textField_MaNhanVien.addFocusListener(ctl);
		textField_MaNhanVien.addKeyListener(ctl);
		textField_MaNhanVien.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_MaNhanVien.setBackground(new Color(255, 255, 255));
		textField_MaNhanVien.setBounds(10, 32, 619, 20);
		panel.add(textField_MaNhanVien);
		textField_MaNhanVien.setColumns(10);

		textField_HoTen = new JTextField();
		textField_HoTen.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		textField_HoTen.setBounds(10, 219, 619, 20);
		textField_HoTen.setColumns(10);
		panel.add(textField_HoTen);

		rdo_TP = new JRadioButton("Trưởng phòng");
		rdo_TP.setBackground(new Color(255, 255, 255));
		rdo_TP.setBounds(10, 319, 109, 23);
		panel.add(rdo_TP);

		rdo_NV = new JRadioButton("Nhân viên");
		rdo_NV.setBackground(new Color(255, 255, 255));
		rdo_NV.setBounds(154, 319, 109, 23);
		panel.add(rdo_NV);
		buttonGroup.add(rdo_TP);
		buttonGroup.add((AbstractButton) rdo_NV);

		btn_Them = new JButton("Thêm");
		btn_Them.setBounds(10, 353, 66, 23);
		btn_Them.addActionListener(ctl);
		panel.add(btn_Them);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(86, 353, 66, 23);
		btnSua.addActionListener(ctl);
		panel.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(162, 353, 66, 23);
		btnXoa.addActionListener(ctl);
		panel.add(btnXoa);

		btnMoi = new JButton("Mới");
		btnMoi.setBounds(238, 353, 66, 23);
		btnMoi.addActionListener(ctl);
		panel.add(btnMoi);

		btnFirst = new JButton("|<");
		btnFirst.setBounds(354, 353, 60, 23);
		btnFirst.addActionListener(ctl);
		panel.add(btnFirst);

		btnPre = new JButton("<<");
		btnPre.setBounds(424, 353, 60, 23);
		btnPre.addActionListener(ctl);
		panel.add(btnPre);

		btnNext = new JButton(">>");
		btnNext.setBounds(499, 353, 60, 23);
		btnNext.addActionListener(ctl);
		panel.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.setBounds(569, 353, 60, 23);
		btnLast.addActionListener(ctl);
		panel.add(btnLast);

		passwordField = new JPasswordField();
		passwordField.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		passwordField.setBounds(10, 101, 619, 20);
		panel.add(passwordField);

		passwordField_Confirm = new JPasswordField();
		passwordField_Confirm.setBorder(new MatteBorder(0, 0, 2, 1, (Color) new Color(0, 128, 255)));
		passwordField_Confirm.setBounds(10, 156, 619, 20);
		panel.add(passwordField_Confirm);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Danh sách", null, panel_1, null);
		panel_1.setLayout(null);

		table = new JTable();
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setShowVerticalLines(false);
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã Nhân viên", "Mật khẩu", "Họ và tên", "Vai trò" }));
		table.addMouseListener(ctl);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(10, 11, 619, 365);
		panel_1.add(scrollPane);

		JLabel lblNewLabel = new JLabel("Quản Lý Nhân Viên Quản Trị");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 286, 26);
		contentPanel.add(lblNewLabel);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);

		JLabel lbl_Exit = new JLabel("X");
		lbl_Exit.addMouseListener(ctl);
		lbl_Exit.setForeground(new Color(255, 0, 0));
		lbl_Exit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_Exit.setBackground(new Color(255, 0, 0));
		lbl_Exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Exit.setBounds(617, 11, 48, 26);
		contentPanel.add(lbl_Exit);
		// trả về mô hình nút đã chọn nếu chưa chọn trả về null
//		System.out.println(this.buttonGroup.getSelection());
		this.loadDataTable();
		this.updateStatus();
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}

	public void loadDataTable() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			ArrayList<NhanVienModel> list = NhanVienDAO.getInstance().selectAll();
			model_table.setRowCount(0);
			for (NhanVienModel nv : list) {
				model_table.addRow(new Object[] { nv.getMaNV(), nv.getPassWord(), nv.getName(),
						(nv.isRole() ? "Trưởng phòng" : "Nhân viên") });
			}
			model_table.fireTableDataChanged();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public NhanVienModel getNhanVien() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maNV = model_table.getValueAt(i_row, 0) + "";
		NhanVienModel nv = new NhanVienModel();
		nv.setMaNV(maNV);
		NhanVienModel nvR = NhanVienDAO.getInstance().selectByID(nv);
		return nvR;
	}

	public void updateOnForm() {
		NhanVienModel nv = this.getNhanVien();
		this.textField_MaNhanVien.setText(nv.getMaNV());
		this.passwordField.setText(nv.getPassWord());
		this.textField_HoTen.setText(nv.getName());
		if (nv.isRole()) {
			this.rdo_TP.setSelected(true);
		} else {
			((AbstractButton) this.rdo_NV).setSelected(true);
		}
		this.count = table.getSelectedRow();
		this.updateStatus();
		this.tabbedPane.setSelectedIndex(0);
	}

	public void firstElement() {
		this.table.setRowSelectionInterval(0, 0);
		this.count = 0;
		this.updateOnForm();
	}

	public void previousElement() {
		this.count--;
		if (this.count < 0) {
			this.count = 0;
		}
		System.out.println(count);
		this.table.setRowSelectionInterval(count, count);
		this.updateOnForm();
	}

	public void nextElement() {
		int i_row = table.getSelectedRow();
//		System.out.println(i_row);
		count = i_row;
		this.count++;
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int rowCount = model_table.getRowCount();
//		System.out.println(rowCount);
		if (this.count > rowCount - 1) {
			this.count = rowCount - 1;
		}
		System.out.println(count);
		this.table.setRowSelectionInterval(count, count);
		this.updateOnForm();
	}

	public void lastElement() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int rowCount = model_table.getRowCount();
		System.out.println(rowCount);
		this.count = rowCount - 1;
		this.table.setRowSelectionInterval(count, count);
		this.updateOnForm();
	}

	public boolean checkMaNV() {
		String maNV = this.textField_MaNhanVien.getText().trim();
		NhanVienModel nv = new NhanVienModel();
		nv.setMaNV(maNV);
		if (NhanVienDAO.getInstance().selectByID(nv) != null) {
			this.textField_MaNhanVien.setBackground(Color.orange);
			MsgBox.showErrorDialog(this, "Mã nhân viên đã tồn tại", "Notification");
			return true;
		}else {
			this.textField_MaNhanVien.setBackground(Color.white);
		}
		return false;
	}

	public void insertTableNhanVien() {
//		if(this.checkMaNV()) {
//			MsgBox.showErrorDialog(this, "Mã nhân viên đã tồn tại", "Notification");
//			return;
//		}
		try {
			StringBuilder sb = new StringBuilder();
			DataValidator.validateEmpty(this.textField_MaNhanVien, sb, "Mã nhân viên null");
			DataValidator.validatePassword(this.passwordField, sb, "Mật khẩu null");
			DataValidator.validateEmpty(this.passwordField_Confirm, sb, "Xác nhận mật khẩu null");
			DataValidator.validateConfirmPass(passwordField, passwordField_Confirm, sb, "Lỗi xác nhận mật khẩu");
			DataValidator.validateIsHoTen(this.textField_HoTen, sb, "Họ tên nhân viên null");
			DataValidator.validateChecked(this.buttonGroup, sb, "Chưa chọn vai trò");
			if (sb.length() > 0) {
				MsgBox.showErrorDialog(this, sb.toString(), "Error");
				return;
			}
			String maNV = this.textField_MaNhanVien.getText();
			String passWord = new String(this.passwordField.getText());
			String passWordC = new String(this.passwordField_Confirm.getText());
			String name = this.textField_HoTen.getText();
			boolean role = true;
			if (this.rdo_TP.isSelected()) {
				role = true;
			} else if (((AbstractButton) this.rdo_NV).isSelected()) {
				role = false;
			}
			NhanVienModel n = new NhanVienModel(maNV, passWordC, name, role);
			if (NhanVienDAO.getInstance().selectByID(n) != null) {
				if (MsgBox.showConfirmDialog(this, "Nhân viên đã tồn tại bạn muốn update?",
						"Update") == JOptionPane.NO_OPTION) {
					return;
				}
				if (NhanVienDAO.getInstance().update(n) > 0) {
					MsgBox.showMessageDialog(this, "Update successful", "Update");
				} else {
					MsgBox.showMessageDialog(this, "Update fail", "Update");
				}
			} else {
				if (NhanVienDAO.getInstance().insert(n) > 0) {
					MsgBox.showMessageDialog(this, "Insert successful", "Insert");
				} else {
					MsgBox.showMessageDialog(this, "Insert fail", "Insert");
				}
			}
			this.loadDataTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTableNhanVien() {
		if (this.textField_MaNhanVien.getText().equalsIgnoreCase(Auth.user.getMaNV())) {
			MsgBox.showErrorDialog(this, "Không được xóa chính mình!", "Notification");
		} else {
			try {
				StringBuilder sb = new StringBuilder();
				DataValidator.validateEmpty(this.textField_MaNhanVien, sb, "Mã nhân viên null");
				if (sb.length() > 0) {
					MsgBox.showErrorDialog(this, sb.toString(), "Error");
					return;
				}
				if (MsgBox.showConfirmDialog(this, "Do you want to delete", "Delete") == JOptionPane.NO_OPTION) {
					return;
				}
				String maNV = this.textField_MaNhanVien.getText();
				NhanVienModel nv = new NhanVienModel();
				nv.setMaNV(maNV);
				if (NhanVienDAO.getInstance().delete(nv) > 0) {
					MsgBox.showMessageDialog(this, "Delete successful", "Delete");
				} else {
					MsgBox.showMessageDialog(this, "Delete fail", "Delete");
				}
				this.loadDataTable();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void resetForm() {
		this.textField_MaNhanVien.setText("");
		this.passwordField.setText("");
		this.passwordField_Confirm.setText("");
		this.textField_HoTen.setText("");
		this.buttonGroup.clearSelection();
		this.textField_MaNhanVien.requestFocus();
		this.count = -1;
		updateStatus();
	}

	public void updateStatus() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == model_table.getRowCount() - 1;

		this.textField_MaNhanVien.setEditable(!edit);
		this.btn_Them.setEnabled(!edit);
		this.btnSua.setEnabled(edit);
		this.btnXoa.setEnabled(edit);

		this.btnFirst.setEnabled(edit && !first);
		this.btnPre.setEnabled(edit && !first);
		this.btnNext.setEnabled(edit && !last);
		this.btnLast.setEnabled(edit && !last);
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}
}
