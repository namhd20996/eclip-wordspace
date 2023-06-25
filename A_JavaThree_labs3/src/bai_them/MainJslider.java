package bai_them;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainJslider extends JFrame {

	private JPanel contentPane;
	private JSlider sldNgay;
	private JSlider sldThang;
	private JSlider sldNam;
	private JTextField txtNgay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainJslider frame = new MainJslider();
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
	public MainJslider() {
		MainCTL ctl = new MainCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		sldNgay = new JSlider();
		sldNgay.setName("sldNgay");
		sldNgay.addChangeListener(ctl);
		sldNgay.setPaintLabels(true);
		sldNgay.setBackground(new java.awt.Color(255, 204, 204));
		sldNgay.setForeground(new java.awt.Color(0, 51, 51));
		sldNgay.setMajorTickSpacing(7);
		sldNgay.setMaximum(31);
		sldNgay.setMinimum(1);
		sldNgay.setMinorTickSpacing(1);
		sldNgay.setPaintTicks(true);
		sldNgay.setSnapToTicks(true);
		sldNgay.setBounds(30, 41, 487, 45);
		contentPane.add(sldNgay);

		sldThang = new JSlider();
		sldThang.setName("sldThang");
		sldThang.addChangeListener(ctl);
		sldThang.setBackground(new java.awt.Color(153, 255, 153));
		sldThang.setMajorTickSpacing(3);
		sldThang.setMaximum(11);
		sldThang.setMinorTickSpacing(1);
		sldThang.setPaintLabels(true);
		sldThang.setPaintTicks(true);
		sldThang.setSnapToTicks(true);
		sldThang.setBounds(30, 125, 487, 45);
		contentPane.add(sldThang);

		sldNam = new JSlider();
		sldNam.setName("sldNam");
		sldNam.addChangeListener(ctl);
		sldNam.setBackground(new java.awt.Color(255, 255, 102));
		sldNam.setMajorTickSpacing(5);
		sldNam.setMaximum(2030);
		sldNam.setMinimum(2000);
		sldNam.setMinorTickSpacing(1);
		sldNam.setPaintLabels(true);
		sldNam.setPaintTicks(true);
		sldNam.setSnapToTicks(true);
		sldNam.setBounds(30, 213, 487, 45);
		contentPane.add(sldNam);
		
		txtNgay = new JTextField();
		txtNgay.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgay.setBounds(30, 296, 487, 34);
		txtNgay.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		txtNgay.setForeground(new java.awt.Color(255, 0, 102));
		contentPane.add(txtNgay);
		txtNgay.setColumns(10);

		Hashtable data = new Hashtable<>();
		String[] sMonths = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		for (int i = 0; i < 12; i++) {
			data.put(i, new JLabel(sMonths[i]));
		}
		sldThang.setLabelTable(data);

		// lay ngay thang nam hien tai set gia tri cho cac JSlider ngay, thang, nam
		Calendar can = Calendar.getInstance();
		sldNgay.setValue(can.get(Calendar.DAY_OF_MONTH));
		sldThang.setValue(can.get(Calendar.MONTH));
		sldNam.setValue(can.get(Calendar.YEAR));
		displayDate();
		this.setLocationRelativeTo(null);
	}

	public void displayDate() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd - MMM - yyyy");
			int dd = sldNgay.getValue();
			int mm = sldThang.getValue();
			int yy = sldNam.getValue() - 1900;
			Date d = new Date(yy, mm, dd);
			txtNgay.setText(sdf.format(d));
		} catch (Exception e) {
		
		}
	}
}
