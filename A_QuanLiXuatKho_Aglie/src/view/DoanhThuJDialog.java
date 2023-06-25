package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DoanhThuCTL;
import dao.CuaHangDao;
import dao.ThongKeDao;
import model.CuaHangModel;

import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import java.awt.Color;

public class DoanhThuJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JComboBox cbo_maCuaHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DoanhThuJDialog dialog = new DoanhThuJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DoanhThuJDialog() {
		DoanhThuCTL ctl = new DoanhThuCTL(this);
		setBounds(100, 100, 557, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		cbo_maCuaHang = new JComboBox();
		cbo_maCuaHang.setActionCommand("C");
		cbo_maCuaHang.addActionListener(ctl);
		cbo_maCuaHang.setBounds(10, 48, 537, 22);
		contentPanel.add(cbo_maCuaHang);

		JLabel lbl_maCuaHang = new JLabel("Mã cửa hàng");
		lbl_maCuaHang.setBounds(10, 11, 110, 27);
		contentPanel.add(lbl_maCuaHang);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Tên cửa hàng", "Địa chỉ", "Số điện thoại", "Tên mặt hàng", "Số lương", "Tổng tiền" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 116, 537, 315);
		contentPanel.add(scrollPane);
		
		JLabel lbl_thongKe = new JLabel("Thống kê");
		lbl_thongKe.setBounds(10, 81, 110, 27);
		contentPanel.add(lbl_thongKe);
		
		JLabel lbl_exit = new JLabel("X");
		lbl_exit.setName("Exit");
		lbl_exit.addMouseListener(ctl);
		lbl_exit.setForeground(new Color(255, 0, 0));
		lbl_exit.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_exit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_exit.setBounds(519, 0, 28, 37);
		contentPanel.add(lbl_exit);
		loadComBoBox();
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
	}

	public void loadComBoBox() {
		ArrayList<CuaHangModel> listCH = CuaHangDao.getInstance().selectAll();
		cbo_maCuaHang.addItem("");
		for (CuaHangModel cuaHangModel : listCH) {
			cbo_maCuaHang.addItem(cuaHangModel.getMaCuaHang());
		}
	}

	public void loadTable() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		String maCuaHang = cbo_maCuaHang.getSelectedItem() + "";
		List<Object[]> list = ThongKeDao.getInstance().getDoanhThu(maCuaHang);
		model_table.setRowCount(0);
		for (Object[] objects : list) {
			model_table.addRow(objects);
		}
		model_table.fireTableDataChanged();
	}
	
	public void exitForm() {
		WindowEvent close = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close);
	}
}
