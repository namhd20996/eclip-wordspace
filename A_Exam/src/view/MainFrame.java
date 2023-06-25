package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.MainFrameCTL;
import dao.SinhVienDao;
import lib.DataValidator;
import lib.MsgBox;
import model.SinhVienModel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSV;
	private JTable table;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnLast;
	private JButton btnNext;
	private JButton btnPre;
	private JButton btnFirst;
	private JButton btnNew;
	private JButton btnUpdate;
	private int count = 0;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSoDT;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private ButtonGroup buttonGroup;
	private JTextArea txtDiaChi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		MainFrameCTL ctl = new MainFrameCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã SV:");
		lblNewLabel.setBounds(10, 11, 48, 14);
		contentPane.add(lblNewLabel);

		JLabel lblHTn = new JLabel("Họ tên:");
		lblHTn.setBounds(10, 47, 48, 14);
		contentPane.add(lblHTn);

		JLabel lblNgySinh = new JLabel("Số ĐT:");
		lblNgySinh.setBounds(321, 50, 66, 14);
		contentPane.add(lblNgySinh);

		JLabel lblLp = new JLabel("Email:");
		lblLp.setBounds(321, 14, 48, 14);
		contentPane.add(lblLp);

		txtMaSV = new JTextField();
		txtMaSV.setBackground(new Color(255, 255, 255));
		txtMaSV.setBorder(new MatteBorder(0, 0, 1, 2, (Color) new Color(0, 0, 255)));
		txtMaSV.setBounds(49, 8, 197, 20);
		contentPane.add(txtMaSV);
		txtMaSV.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Danh sách:");
		lblNewLabel_1.setBounds(10, 139, 74, 14);
		contentPane.add(lblNewLabel_1);

		table = new JTable();
		table.setShowVerticalLines(false);
		table.setSelectionBackground(new Color(255, 128, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã SV", "Họ tên", "Email", "SốĐT", "Giới tính", "Địa chí" }));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 384, 564, 48);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(ctl);
		btnAdd.setBounds(0, 11, 51, 23);
		panel.add(btnAdd);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(ctl);
		btnDelete.setBounds(47, 11, 75, 23);
		panel.add(btnDelete);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setBounds(114, 11, 75, 23);
		panel.add(btnUpdate);

		btnNew = new JButton("New");
		btnNew.addActionListener(ctl);
		btnNew.setBounds(187, 11, 55, 23);
		panel.add(btnNew);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(ctl);
		btnFirst.setBounds(321, 11, 51, 23);
		panel.add(btnFirst);

		btnPre = new JButton("<<");
		btnPre.addActionListener(ctl);
		btnPre.setBounds(369, 11, 75, 23);
		panel.add(btnPre);

		btnNext = new JButton(">>");
		btnNext.addActionListener(ctl);
		btnNext.setBounds(436, 11, 75, 23);
		panel.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.addActionListener(ctl);
		btnLast.setBounds(509, 11, 55, 23);
		panel.add(btnLast);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 164, 564, 209);
		contentPane.add(scrollPane);

		JLabel lblHTn_1 = new JLabel("Giới tính:");
		lblHTn_1.setBounds(10, 75, 48, 14);
		contentPane.add(lblHTn_1);

		this.table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table.getTableHeader().setOpaque(false);
		this.table.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table.getTableHeader().setForeground(new Color(255, 255, 255));
		this.table.setRowHeight(25);
		table.addMouseListener(ctl);

		txtHoTen = new JTextField();
		txtHoTen.setEditable(true);
		txtHoTen.setColumns(10);
		txtHoTen.setBorder(new MatteBorder(0, 0, 1, 2, (Color) new Color(0, 0, 255)));
		txtHoTen.setBackground(Color.WHITE);
		txtHoTen.setBounds(49, 41, 197, 20);
		contentPane.add(txtHoTen);

		txtEmail = new JTextField();
		txtEmail.setEditable(true);
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 2, (Color) new Color(0, 0, 255)));
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(377, 8, 197, 20);
		contentPane.add(txtEmail);

		txtSoDT = new JTextField();
		txtSoDT.setEditable(true);
		txtSoDT.setColumns(10);
		txtSoDT.setBorder(new MatteBorder(0, 0, 1, 2, (Color) new Color(0, 0, 255)));
		txtSoDT.setBackground(Color.WHITE);
		txtSoDT.setBounds(377, 44, 197, 20);
		contentPane.add(txtSoDT);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(59, 71, 109, 23);
		contentPane.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(176, 71, 109, 23);
		contentPane.add(rdoNu);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);

		JLabel lblHTn_1_1 = new JLabel("Địa chỉ:");
		lblHTn_1_1.setBounds(321, 75, 48, 14);
		contentPane.add(lblHTn_1_1);

		txtDiaChi = new JTextArea();
		txtDiaChi.setBounds(377, 75, 197, 66);
		contentPane.add(txtDiaChi);
		upStatus();
		loadDataTable();
		setLocationRelativeTo(null);
	}

	public void upStatus() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		boolean edit = this.count >= 0;
		boolean first = this.count == 0;
		boolean last = this.count == table.getRowCount() - 1;

		txtMaSV.setEditable(!edit);
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
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		count = i_row;
		count++;
		if (count > table.getRowCount() - 1) {
			count = table.getRowCount() - 1;
		}
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void lastElement() {
//		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		count = table.getRowCount() - 1;
		table.setRowSelectionInterval(count, count);
		upStatus();
		displayFormCapNhat();
	}

	public void displayFormCapNhat() {
		SinhVienModel sv = getValueForm();
		txtMaSV.setText(sv.getMaSV());
		txtHoTen.setText(sv.getHoTen());
		txtSoDT.setText(sv.getSoDT());
		txtEmail.setText(sv.getEmail());
		txtDiaChi.setText(sv.getDiaChi());
		if (sv.isGioiTinh()) {
			rdoNam.setSelected(true);
		} else {
			rdoNu.setSelected(true);
		}

		int i_row = table.getSelectedRow();
		count = i_row;
		upStatus();
	}

	public void loadDataTable() {
		ArrayList<SinhVienModel> list = SinhVienDao.getInstance().selectAll();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.setRowCount(0);
		for (SinhVienModel sinhVienModel : list) {
			model_table.addRow(new Object[] { sinhVienModel.getMaSV(), sinhVienModel.getHoTen(),
					sinhVienModel.getEmail(), sinhVienModel.getSoDT(), sinhVienModel.isGioiTinh() ? "Nam" : "Nữ",
					sinhVienModel.getDiaChi() });
		}

	}

	public void resetForm() {
		txtMaSV.setText("");
		txtHoTen.setText("");
		txtSoDT.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
		buttonGroup.clearSelection();
		
		count = -1;
		upStatus();
	}

	public void inserTableSV() {
		StringBuilder sb = new StringBuilder();
		DataValidator.validateIsID(txtMaSV, sb, "Mã sinh viên null");
		DataValidator.validateIsHoTen(txtHoTen, sb, "Họ tên null");
		DataValidator.validateIsEmail(txtEmail, sb, "Email null");
		DataValidator.validateIsSDT(txtSoDT, sb, "Số ĐT null");
		DataValidator.validateChecked(buttonGroup, sb, "Chưa chọn giới tính");
		if (sb.length() > 0) {
			MsgBox.showErrorDialog(this, sb.toString(), "Notificaiton");
			return;
		}
		String maSV = txtMaSV.getText();
		String hoTen = txtHoTen.getText();
		String email = txtEmail.getText();
		String soDT = txtSoDT.getText();
		boolean gioiTinh = true;
		if (rdoNam.isSelected()) {
			gioiTinh = true;
		} else {
			gioiTinh = false;
		}
		String diaChi = txtDiaChi.getText();
		SinhVienModel sv = new SinhVienModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
		if (SinhVienDao.getInstance().selectByID(sv) != null) {
			if (MsgBox.showConfirmDialog(this, "Bạn muốn cập nhật", "Notificaiton") == JOptionPane.NO_OPTION) {
				return;
			}
			if (SinhVienDao.getInstance().update(sv) > 0) {
				MsgBox.showMessageDialog(this, "Update success", "Notificaiton");
			} else {
				MsgBox.showMessageDialog(this, "Update fail", "Notificaiton");
			}
		} else {
			if (SinhVienDao.getInstance().insert(sv) > 0) {
				MsgBox.showMessageDialog(this, "Insert success", "Notificaiton");
			} else {
				MsgBox.showMessageDialog(this, "Insert success", "Notificaiton");
			}
		}
		loadDataTable();
	}

	public SinhVienModel getValueForm() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String maSV = model_table.getValueAt(i_row, 0) + "";
		SinhVienModel s = new SinhVienModel();
		s.setMaSV(maSV);
		SinhVienModel sv = SinhVienDao.getInstance().selectByID(s);
		return sv;
	}

	public void deleteTable() {
		SinhVienModel s = getValueForm();
		int c = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa", "Notificaiton", JOptionPane.YES_NO_OPTION);
		if (c == JOptionPane.NO_OPTION) {
			return;
		}
		if (SinhVienDao.getInstance().delete(s) > 0) {
			MsgBox.showMessageDialog(this, "Delete success", "Nottification");
		} else {
			MsgBox.showMessageDialog(this, "Delete success", "Nottification");
		}
	}

}
