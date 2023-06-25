package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import constant.SystemConstant;
import dao.PhieuThuTienPhongDao;
import lib.MsgBox;

public class Form_DT_MonthJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private int year;
	private int month;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Form_DT_MonthJDialog dialog = new Form_DT_MonthJDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Form_DT_MonthJDialog() {
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 0, 960, 500);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnXuatFile = new JButton("Xuất File Excel");
		btnXuatFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertTExcel();
			}
		});
		btnXuatFile.setBounds(851, 511, 119, 23);
		contentPanel.add(btnXuatFile);
	}
	
	public void loadDoanhThuThang(int thang, int nam) {
		List<Object[]> list = PhieuThuTienPhongDao.getInstance().selectByThang(thang, nam);
		month = thang;
		year = nam;
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
		p.setPreferredSize(new Dimension(960, 500));
		panel.setLayout(new BorderLayout());
		panel.add(p, BorderLayout.NORTH);
		repaint();
	}
	
	public void insertTExcel() {
		try {
			List<Object[]> list = PhieuThuTienPhongDao.getInstance().selectByThang(month, year);
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Doanh thu");
			XSSFRow row = null;
			Cell cell = null;
			// Tạo 3 dòng trống và 1 một dòng để add các title dòng trong java dòng đầu = 0
			row = sheet.createRow(3);
			cell = row.createCell(0, CellType.STRING);
			cell.setCellValue("STT");

			cell = row.createCell(1, CellType.STRING);
			cell.setCellValue("Doanh Thu");

			cell = row.createCell(2, CellType.STRING);
			cell.setCellValue("Ngày");

			int i = 0;
			for (Object[] objects : list) {
				String value = objects[0] + "";
				String yearStr = objects[1] + "";

				row = sheet.createRow(4 + i);

				cell = row.createCell(0, CellType.NUMERIC);
				cell.setCellValue(i + 1);

				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue(value);

				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue(yearStr);

				i++;

			}

			File f = new File(SystemConstant.URL_FOLDER_EXCEL+"\\DoanhThuThang.xlsx");
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
			fos.close();
			MsgBox.showMessageDialog(this, "Xuất file success", "Notification");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
