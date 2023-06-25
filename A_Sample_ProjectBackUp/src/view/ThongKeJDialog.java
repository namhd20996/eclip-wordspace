package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatDarculaLaf;

import controller.ThongKeJDialogCTL;
import dao.KhoaHocDAO;
import dao.NguoiHocDAO;
import dao.ThongKeDAO;
import lib.Auth;
import lib.XDate;
import model.KhoaHocModel;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

public class ThongKeJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table_NguoiHoc;
	private JTable table_BangDiem;
	private JTable table_TongHopDiem;
	private JTable table_DoanhThu;
	private JComboBox comboBox;
	private JComboBox comboBox_Nam;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			UIManager.setLookAndFeel(new FlatDarculaLaf());
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ThongKeJDialog dialog = new ThongKeJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThongKeJDialog() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ThongKeJDialog.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
		ThongKeJDialogCTL ctl = new ThongKeJDialogCTL(this);
		setBounds(100, 100, 675, 533);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tổng Hợp Thống Kê");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 236, 30);
		contentPanel.add(lblNewLabel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 52, 655, 470);
		contentPanel.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Người học", null, panel, null);
		panel.setLayout(null);

		table_NguoiHoc = new JTable();
		table_NguoiHoc.setRowHeight(25);
		table_NguoiHoc.setShowVerticalLines(false);
		table_NguoiHoc.setFocusable(false);
		table_NguoiHoc.setSelectionBackground(new Color(255, 128, 0));
		table_NguoiHoc.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Người học", "Bảng điểm", "Tổng hợp điểm", "Doanh thu" }));

		JScrollPane scrollPane = new JScrollPane(table_NguoiHoc);
		scrollPane.setBounds(10, 11, 630, 420);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Bảng điểm", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Khóa học:");
		lblNewLabel_1.setBounds(10, 11, 84, 14);
		panel_1.add(lblNewLabel_1);

		comboBox = new JComboBox();
		comboBox.setActionCommand("C");
		comboBox.addActionListener(ctl);
		comboBox.setBounds(65, 7, 575, 22);
		panel_1.add(comboBox);

		table_BangDiem = new JTable();
		table_BangDiem.setShowVerticalLines(false);
		table_BangDiem.setFocusable(false);
		table_BangDiem.setSelectionBackground(new Color(255, 128, 0));
		table_BangDiem.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã người học", "Họ và tên", "Điểm", "Xếp loại" }));

		JScrollPane scrollPane_1 = new JScrollPane(table_BangDiem);
		scrollPane_1.setBounds(10, 47, 630, 384);
		panel_1.add(scrollPane_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Tổng hợp điểm", null, panel_2, null);
		panel_2.setLayout(null);

		table_TongHopDiem = new JTable();
		table_TongHopDiem.setSelectionBackground(new Color(255, 128, 0));
		table_TongHopDiem.setShowVerticalLines(false);
		table_TongHopDiem.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Chuyên đề", "Tổng số HV", "Thấp nhất", "Cao nhất", "Điểm TB" }));

		JScrollPane scrollPane_2 = new JScrollPane(table_TongHopDiem);
		scrollPane_2.setBounds(10, 11, 630, 420);
		panel_2.add(scrollPane_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Doanh thu", null, panel_3, null);
		panel_3.setLayout(null);

		table_DoanhThu = new JTable();
		table_DoanhThu.setSelectionBackground(new Color(255, 128, 0));
		table_DoanhThu.setShowVerticalLines(false);
		table_DoanhThu.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Chuyên đề", "Số khóa", "Số HV",
				"Doanh thu", "HP cao nhất", "HP thấp nhất", "HP trung bình" }));

		JScrollPane scrollPane_3 = new JScrollPane(table_DoanhThu);
		scrollPane_3.setBounds(10, 36, 630, 395);
		panel_3.add(scrollPane_3);

		JLabel lblNewLabel_2 = new JLabel("Năm:");
		lblNewLabel_2.setBounds(10, 11, 48, 14);
		panel_3.add(lblNewLabel_2);

		comboBox_Nam = new JComboBox();
		comboBox_Nam.setActionCommand("CC");
		comboBox_Nam.addActionListener(ctl);
		comboBox_Nam.setBounds(43, 7, 597, 22);
		panel_3.add(comboBox_Nam);

		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(ctl);
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(627, 11, 48, 30);
		contentPanel.add(lblNewLabel_3);
		if (!Auth.isMangager()) {
			this.tabbedPane.remove(3);
		}
		this.table_NguoiHoc.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table_NguoiHoc.getTableHeader().setOpaque(false);
		this.table_NguoiHoc.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table_NguoiHoc.getTableHeader().setForeground(new Color(255,255,255));
		this.table_NguoiHoc.setRowHeight(25);
		
		
		this.table_BangDiem.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table_BangDiem.getTableHeader().setOpaque(false);
		this.table_BangDiem.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table_BangDiem.getTableHeader().setForeground(new Color(255,255,255));
		this.table_BangDiem.setRowHeight(25);
		
		this.table_TongHopDiem.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table_TongHopDiem.getTableHeader().setOpaque(false);
		this.table_TongHopDiem.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table_TongHopDiem.getTableHeader().setForeground(new Color(255,255,255));
		this.table_TongHopDiem.setRowHeight(25);
		
		this.table_DoanhThu.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 12));
		this.table_DoanhThu.getTableHeader().setOpaque(false);
		this.table_DoanhThu.getTableHeader().setBackground(new Color(32, 136, 203));
		this.table_DoanhThu.getTableHeader().setForeground(new Color(255,255,255));
		this.table_DoanhThu.setRowHeight(25);
		this.setUndecorated(true);
		// this.loadDataTableDT();
		this.loadComboxNam();
		this.loadDataTableTHD();
		this.loadDataTableNH();
		this.loadCombobox();
		this.setLocationRelativeTo(null);
	}

	public void loadCombobox() {
		try {
			ArrayList<KhoaHocModel> list = KhoaHocDAO.getInstance().selectAll();
			this.comboBox.addItem("");
			for (KhoaHocModel khoaHocModel : list) {
//				System.out.println(khoaHocModel.getMaChuyenDe() + " " + khoaHocModel.getNgayKhaiGiang());
//				this.comboBox.addItem(
//						khoaHocModel.getMaChuyenDe() + " " + XDate.dateString(khoaHocModel.getNgayKhaiGiang()));
				this.comboBox.addItem(khoaHocModel);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String getDiem(double diem) {
		if (diem < 5) {
			return "Chưa đạt";
		}

		if (diem < 6.5) {
			return "Trung bình";
		}

		if (diem < 7.5) {
			return "Khá";
		}

		if (diem < 9) {
			return "Giỏi";
		}
		return "Xuất xắc";
	}

	public void loadDataTableBD() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table_BangDiem.getModel();
			model_table.setRowCount(0);
			KhoaHocModel kh = (KhoaHocModel) this.comboBox.getSelectedItem();
//			System.out.println(kh.getMaKhoaHoc());
			List<Object[]> list = ThongKeDAO.getInstance().getBangDiem(kh.getMaKhoaHoc());
			for (Object[] objects : list) {
				double diem = (double) objects[2];
				model_table.addRow(new Object[] { objects[0], objects[1], objects[2], this.getDiem(diem) });
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadDataTableNH() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table_NguoiHoc.getModel();
			model_table.setRowCount(0);
			List<Object[]> list = ThongKeDAO.getInstance().getLuongNguoiHoc();
			for (Object[] objects : list) {
				model_table.addRow(objects);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadDataTableTHD() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table_TongHopDiem.getModel();
			model_table.setRowCount(0);
			List<Object[]> list = ThongKeDAO.getInstance().getDiemChuyenDe();
			for (Object[] objects : list) {
				model_table.addRow(new Object[] { objects[0], objects[1], objects[2], objects[3],
						String.format("%.1f", objects[4]) });
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void loadComboxNam() {
		try {
			this.comboBox_Nam.addItem("");
			ArrayList<Integer> list = KhoaHocDAO.getInstance().getYearKH();
			for (Integer integer : list) {
				System.out.println(integer);
				this.comboBox_Nam.addItem(integer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void loadDataTableDT() {
		try {
			DefaultTableModel model_table = (DefaultTableModel) table_DoanhThu.getModel();
			model_table.setRowCount(0);
			List<Object[]> listDT = ThongKeDAO.getInstance()
					.getDoanhThu(Integer.valueOf((Integer) this.comboBox_Nam.getSelectedItem()));
			for (Object[] objects : listDT) {
				model_table.addRow(objects);
			}

		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
	}

	public void selectTab(int index) {
		this.tabbedPane.setSelectedIndex(index);
	}

	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}
}
