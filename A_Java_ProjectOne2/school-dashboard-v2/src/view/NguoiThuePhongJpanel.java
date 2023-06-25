package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.JRadioButton;

public class NguoiThuePhongJpanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public NguoiThuePhongJpanel() {
		setBounds(100, 100, 1047, 600);
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 5, 962, 584);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Người thuê", null, panel, null);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(428, 0, 212, 20);
		panel.add(textField);
		
		JLabel lblNewLabel = new JLabel("Số CMND/CCCD:");
		lblNewLabel.setBounds(330, 3, 88, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phòng thuê:");
		lblNewLabel_1.setBounds(10, 34, 88, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên:");
		lblNewLabel_2.setBounds(10, 59, 88, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hình mặt trước CC:");
		lblNewLabel_3.setBounds(650, 155, 107, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Hình mặt sau CC:");
		lblNewLabel_4.setBounds(650, 313, 96, 14);
		panel.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(108, 30, 212, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_8_5 = new JLabel("Số điện thoại:");
		lblNewLabel_8_5.setBounds(330, 31, 78, 14);
		panel.add(lblNewLabel_8_5);
		
		JLabel lblNewLabel_8_6 = new JLabel("Email:");
		lblNewLabel_8_6.setBounds(330, 56, 78, 14);
		panel.add(lblNewLabel_8_6);
		
		JLabel lblNewLabel_8_6_3 = new JLabel("Ngày bắt đầu thuê:");
		lblNewLabel_8_6_3.setBounds(6, 268, 107, 14);
		panel.add(lblNewLabel_8_6_3);
		
		JLabel lblNewLabel_8_6_4 = new JLabel("Ngày hết hạn thuê:");
		lblNewLabel_8_6_4.setBounds(326, 262, 107, 14);
		panel.add(lblNewLabel_8_6_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 56, 212, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9.setBounds(752, 155, 194, 147);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("New label");
		lblNewLabel_9_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_1.setBounds(753, 313, 193, 147);
		panel.add(lblNewLabel_9_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 262, 212, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(429, 259, 211, 20);
		panel.add(textField_3);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(429, 28, 211, 20);
		panel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(429, 53, 211, 20);
		panel.add(textField_16);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 128, 255));
		panel_1.setBounds(10, 470, 955, 66);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(0, 32, 61, 23);
		panel_1.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setBounds(59, 32, 61, 23);
		panel_1.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(122, 32, 61, 23);
		panel_1.add(btnSa);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setBounds(224, 32, 89, 23);
		panel_1.add(btnCpNht);
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.setBounds(632, 32, 61, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnXa_1 = new JButton("Xóa");
		btnXa_1.setBounds(691, 32, 61, 23);
		panel_1.add(btnXa_1);
		
		JButton btnSa_1 = new JButton("Sửa");
		btnSa_1.setBounds(754, 32, 61, 23);
		panel_1.add(btnSa_1);
		
		JButton btnCpNht_1 = new JButton("Cập nhật");
		btnCpNht_1.setBounds(856, 32, 89, 23);
		panel_1.add(btnCpNht_1);
		
		JLabel lblMH = new JLabel("Mã người thuê:");
		lblMH.setBounds(10, 6, 88, 14);
		panel.add(lblMH);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(108, 3, 212, 20);
		panel.add(textField_17);
		
		JLabel lblNewLabel_3_1 = new JLabel("Hình người thuê:");
		lblNewLabel_3_1.setBounds(650, 3, 107, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("New label");
		lblNewLabel_9_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_9_2.setBounds(752, 3, 194, 144);
		panel.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_5 = new JLabel("Họ tên:");
		lblNewLabel_5.setBounds(10, 84, 78, 14);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(108, 81, 212, 20);
		panel.add(textField_4);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày sinh:");
		lblNewLabel_6.setBounds(330, 87, 78, 14);
		panel.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(429, 81, 211, 20);
		panel.add(textField_5);
		
		JLabel lblNewLabel_8 = new JLabel("Giới tính:");
		lblNewLabel_8.setBounds(10, 118, 78, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_8_6_5 = new JLabel("Tiền cọc:");
		lblNewLabel_8_6_5.setBounds(330, 118, 48, 14);
		panel.add(lblNewLabel_8_6_5);
		
		JLabel lblNewLabel_8_1 = new JLabel("Phường/Xã:");
		lblNewLabel_8_1.setBounds(10, 149, 77, 14);
		panel.add(lblNewLabel_8_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(429, 112, 211, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(108, 143, 212, 20);
		panel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(108, 174, 212, 20);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(429, 143, 211, 20);
		panel.add(textField_10);
		
		JLabel lblNewLabel_8_2 = new JLabel("Quận/Huyện:");
		lblNewLabel_8_2.setBounds(6, 180, 77, 14);
		panel.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_7 = new JLabel("Nơi sinh:");
		lblNewLabel_7.setBounds(330, 149, 77, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8_4 = new JLabel("Hộ khẩu thường trú:");
		lblNewLabel_8_4.setBounds(10, 235, 120, 14);
		panel.add(lblNewLabel_8_4);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(108, 232, 532, 20);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(428, 174, 212, 20);
		panel.add(textField_12);
		
		JLabel lblNewLabel_8_6_1 = new JLabel("Ngày cấp CC:");
		lblNewLabel_8_6_1.setBounds(326, 177, 78, 14);
		panel.add(lblNewLabel_8_6_1);
		
		JLabel lblNewLabel_8_6_2 = new JLabel("Nơi cấp:");
		lblNewLabel_8_6_2.setBounds(326, 208, 78, 14);
		panel.add(lblNewLabel_8_6_2);
		
		JLabel lblNewLabel_8_3 = new JLabel("Tỉnh/TP:");
		lblNewLabel_8_3.setBounds(10, 210, 77, 14);
		panel.add(lblNewLabel_8_3);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(108, 204, 212, 20);
		panel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(428, 205, 212, 20);
		panel.add(textField_14);
		
		JLabel lblNewLabel_8_6_5_1 = new JLabel("Ghi chú:");
		lblNewLabel_8_6_5_1.setBounds(10, 298, 630, 14);
		panel.add(lblNewLabel_8_6_5_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(108, 293, 532, 167);
		panel.add(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(108, 114, 64, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setBounds(181, 114, 109, 23);
		panel.add(rdbtnN);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Danh sách", null, panel_2, null);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 191, 937, 354);
		panel_2.add(scrollPane);
		
	}
}
