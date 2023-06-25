package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.Form_DoanhThuCTL;
import dao.PhieuThuTienPhongDao;
import lib.DataValidator;
import lib.MsgBox;
import model.PhieuThuTienPhongModel;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Form_DoanhThu extends JPanel {

	private JPanel panel;
	private JComboBox cboThongKe;
	private JComboBox cboNam;
	private JComboBox cboThang;
	private JButton btnThongKe;
	private JComboBox cboTuNam;
	private JComboBox cboDenNam;

	/**
	 * Create the panel.
	 */
	public Form_DoanhThu() {
		Form_DoanhThuCTL ctl = new Form_DoanhThuCTL(this);
		setBounds(0, 11, 1200, 920);
		setBackground(new Color(227, 227, 227));
		setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 11, 952, 445);
		add(panel);

		JLabel lblNewLabel = new JLabel("Thống kê theo:");
		lblNewLabel.setBounds(326, 467, 88, 14);
		add(lblNewLabel);

		cboThongKe = new JComboBox();
		cboThongKe.setBounds(326, 492, 88, 22);
		add(cboThongKe);

		JLabel lblNm = new JLabel("Năm");
		lblNm.setBounds(10, 467, 88, 14);
		add(lblNm);

		JLabel lblThng = new JLabel("Tháng:");
		lblThng.setBounds(179, 467, 88, 14);
		add(lblThng);

		cboNam = new JComboBox();
		cboNam.setBounds(10, 492, 88, 22);
		add(cboNam);

		cboThang = new JComboBox();
		cboThang.setBounds(179, 492, 88, 22);
		add(cboThang);

		btnThongKe = new JButton("Thống Kê");
		btnThongKe.addActionListener(ctl);
		btnThongKe.setBounds(326, 525, 88, 48);
		add(btnThongKe);

		cboTuNam = new JComboBox();
		cboTuNam.setBounds(10, 551, 88, 22);
		add(cboTuNam);

		cboDenNam = new JComboBox();
		cboDenNam.setBounds(179, 551, 88, 22);
		add(cboDenNam);

		JLabel lblTNm = new JLabel("Từ năm:");
		lblTNm.setBounds(10, 525, 88, 14);
		add(lblTNm);

		JLabel lblnNm = new JLabel("Đến năm");
		lblnNm.setBounds(179, 525, 88, 14);
		add(lblnNm);
		panel.setLayout(new BorderLayout());

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Form_DoanhThu.class.getResource("/icon/Hoàng Duy Nam.png")));
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(424, 467, 538, 110);
		add(lblNewLabel_1);

//		Form_DT_YearJPanel	panel_1 = new Form_DT_YearJPanel();
//		panel_1.setPreferredSize(new Dimension(952, 445));
//		panel.add(panel_1, BorderLayout.NORTH);
//		loadDoanhThuNam();
		loadDoanhThuAllNam();
//		loadDoanhThuThang(9, 2022);
		loadComboboxThongKeTheo();
		loadComboboxMonth();
		loadComboboxYear();

	}

	public void loadDoanhThuAllNam() {
		List<Object[]> list = PhieuThuTienPhongDao.getInstance().selectDoanhThuAllYear();
		DefaultCategoryDataset datos = new DefaultCategoryDataset();
		for (Object[] objects : list) {
			double value = Double.valueOf(objects[0] + "");
			int str = Integer.valueOf(objects[1] + "");

			datos.setValue(value, "Năm " + str, "" + str);

		}
		JFreeChart g = ChartFactory.createStackedBarChart3D("Doanh Thu", "Theo từng năm", "", datos,
				PlotOrientation.VERTICAL, true, true, false);
		ChartPanel p = new ChartPanel(g);
		p.setMouseWheelEnabled(true);
		p.setPreferredSize(new Dimension(952, 445));

		panel.add(p, BorderLayout.NORTH);
		repaint();
	}

	public void loadDoanhThuThang(int thang, int nam) {
		List<Object[]> list = PhieuThuTienPhongDao.getInstance().selectByThang(thang, nam);
		DefaultCategoryDataset datos = new DefaultCategoryDataset();
		double value = 0;
		int str = 0;
		for (Object[] objects : list) {
			value = Double.valueOf(objects[0] + "");
			str = Integer.valueOf(objects[1] + "");
			datos.setValue(value, "Ngày " + str, "" + str);
		}
//		for (int i = 1; i <= 31; i++) {
//			if (i == str) {
//				datos.setValue(value, str + "", "" + str);
//			} else {
//				datos.setValue(0, i + "", i + "");
//			}
//		}
		JFreeChart g = ChartFactory.createStackedBarChart3D("Doanh Thu", "Tháng " + thang + " Năm " + nam, "", datos,
				PlotOrientation.VERTICAL, true, true, false);

		ChartPanel p = new ChartPanel(g);
		p.setMouseWheelEnabled(true);
		p.setForeground(Color.blue);
		p.setPreferredSize(new Dimension(952, 445));
		panel.setLayout(new BorderLayout());
		panel.add(p, BorderLayout.NORTH);
		repaint();
	}

	public void loadComboboxThongKeTheo() {
		cboThongKe.addItem("");
		cboThongKe.addItem("Tháng");
		cboThongKe.addItem("Năm");
		cboThongKe.addItem("Theo khoảng năm");
	}

	public void loadComboboxYear() {
		cboDenNam.addItem("");
		cboNam.addItem("");
		cboTuNam.addItem("");
		List<Object[]> list = PhieuThuTienPhongDao.getInstance().selectAllYear();
		for (Object[] objects : list) {
			cboDenNam.addItem(objects[0]);
			cboNam.addItem(objects[0]);
			cboTuNam.addItem(objects[0]);
		}
	}

	public void loadComboboxMonth() {
		cboThang.addItem("");
		List<Object[]> list = PhieuThuTienPhongDao.getInstance().selectAllMonth();
		for (Object[] objects : list) {
			cboThang.addItem(objects[0]);

		}
	}

	public void displayThongKeAll() {
		try {
			StringBuilder sb = new StringBuilder();
			String thongKe = cboThongKe.getSelectedItem() + "";
			if (thongKe.equals("Năm")) {
//				Form_DT_YearJPanel form = new Form_DT_YearJPanel();
//				cboDenNam.setEnabled(false);
//				cboTuNam.setEnabled(false);
//				cboThang.setEnabled(false);
				DataValidator.validateCombobox(cboNam, sb, "Chưa chọn năm");
				if (sb.length() > 0) {
					MsgBox.showErrorDialog(this, sb.toString(), "Notificatiom");
					return;
				}
				int nam = Integer.valueOf(cboNam.getSelectedItem() + "");
				System.out.println(nam);
				Form_DT_YearJDialog dialog = new Form_DT_YearJDialog();
				dialog.loadDoanhThuNam(nam);
				dialog.setModal(true);
				dialog.setLocationRelativeTo(null);
				dialog.setVisible(true);
			} else if (thongKe.equals("Tháng")) {
				DataValidator.validateCombobox(cboNam, sb, "Chưa chọn năm");
				DataValidator.validateCombobox(cboThang, sb, "Chưa chọn tháng");
				if (sb.length() > 0) {
					MsgBox.showErrorDialog(this, sb.toString(), "Notificatiom");
					return;
				}
				int thang = Integer.valueOf(cboThang.getSelectedItem() + "");
				int nam = Integer.valueOf(cboNam.getSelectedItem() + "");
				Form_DT_MonthJDialog form_DT_MonthJDialog = new Form_DT_MonthJDialog();
				form_DT_MonthJDialog.loadDoanhThuThang(thang, nam);
				form_DT_MonthJDialog.setModal(true);
				form_DT_MonthJDialog.setLocationRelativeTo(null);
				form_DT_MonthJDialog.setVisible(true);
			} else if (thongKe.equals("")) {
				MsgBox.showMessageDialog(this, "Chọn thống kê null", "Notification");
			} else if (thongKe.equals("Theo khoảng năm")) {
				DataValidator.validateCombobox(cboTuNam, sb, "Chưa chọn tù năm");
				DataValidator.validateCombobox(cboDenNam, sb, "Chưa chọn đến năm");
				if (sb.length() > 0) {
					MsgBox.showErrorDialog(this, sb.toString(), "Notificatiom");
					return;
				}
				int from = Integer.valueOf(cboTuNam.getSelectedItem() + "");
				int to = Integer.valueOf(cboDenNam.getSelectedItem() + "");
				Form_DT_From_ToJDialog form_DT_From_ToJDialog = new Form_DT_From_ToJDialog();
				form_DT_From_ToJDialog.loadDoanhThuNam(from, to);
				form_DT_From_ToJDialog.setModal(true);
				form_DT_From_ToJDialog.setLocationRelativeTo(null);
				form_DT_From_ToJDialog.setVisible(true);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
