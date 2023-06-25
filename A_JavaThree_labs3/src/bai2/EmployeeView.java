package bai2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class EmployeeView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Ho;
	private JTextField textField_BiDanh;
	private JTextField textField_Ten;
	private JTextField textField_MatMa;
	private ButtonGroup buttonGroup;
	private JComboBox comboBox;
	private JCheckBox chckAnChoi;
	private JCheckBox chckNhayMua;
	private JCheckBox checkNguNghi;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JRadioButton rdoKhongXacDinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					EmployeeView frame = new EmployeeView();
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
	public EmployeeView() {
		this.setTitle("Employee");
		EmployeeController ctl = new EmployeeController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Font font = new Font("arial", Font.ITALIC, 15);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Họ tên");
		title.setTitleFont(font);
		title.setTitleColor(Color.red);
		title.setTitleJustification(TitledBorder.CENTER);

		JPanel panel = new JPanel();
		panel.setBounds(10, 29, 418, 101);
		panel.setBorder(title);
		panel.setBackground(Color.green);

		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Họ:");
		lblNewLabel.setBounds(10, 30, 48, 14);
		panel.add(lblNewLabel);

		JLabel lblBDanh = new JLabel("Bí danh:");
		lblBDanh.setBounds(10, 62, 84, 14);
		panel.add(lblBDanh);

		JLabel lblNewLabel_1_1 = new JLabel("Tên:");
		lblNewLabel_1_1.setBounds(201, 30, 48, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mật mã:");
		lblNewLabel_1_2.setBounds(201, 62, 84, 14);
		panel.add(lblNewLabel_1_2);

		textField_Ho = new JTextField();
		textField_Ho.setBounds(77, 27, 96, 20);
		panel.add(textField_Ho);
		textField_Ho.setColumns(10);

		textField_BiDanh = new JTextField();
		textField_BiDanh.setColumns(10);
		textField_BiDanh.setBounds(77, 59, 96, 20);
		panel.add(textField_BiDanh);

		textField_Ten = new JTextField();
		textField_Ten.setColumns(10);
		textField_Ten.setBounds(278, 27, 96, 20);
		panel.add(textField_Ten);

		textField_MatMa = new JTextField();
		textField_MatMa.setColumns(10);
		textField_MatMa.setBounds(278, 59, 96, 20);
		panel.add(textField_MatMa);

		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder("Giới tính");
		title1.setTitleFont(font);
		title1.setTitleColor(Color.red);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 141, 418, 41);
		panel_1.setBorder(title1);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.yellow);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(70, 11, 109, 23);
		panel_1.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(181, 11, 73, 23);
		panel_1.add(rdoNu);

		rdoKhongXacDinh = new JRadioButton("Không xác định");
		rdoKhongXacDinh.setBounds(267, 11, 134, 23);
		panel_1.add(rdoKhongXacDinh);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);
		buttonGroup.add(rdoKhongXacDinh);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 193, 418, 213);
		contentPane.add(panel_2);

		TitledBorder title2;
		title2 = BorderFactory.createTitledBorder("Thông tin khác");
		title2.setTitleFont(font);
		title2.setTitleColor(Color.red);
		panel_2.setBorder(title2);
		panel_2.setBackground(Color.pink);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Quê quán");
		lblNewLabel_1.setBounds(10, 31, 48, 14);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_1_3 = new JLabel("Ghi chú");
		lblNewLabel_1_3.setBounds(10, 95, 48, 14);
		panel_2.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_3_1 = new JLabel("Sở thích");
		lblNewLabel_1_3_1.setBounds(10, 56, 48, 14);
		panel_2.add(lblNewLabel_1_3_1);

		comboBox = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDsTinh();
		comboBox.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox.addItem(tinh.getTenTinh());
		}

		comboBox.setBounds(85, 27, 111, 22);
		panel_2.add(comboBox);

		chckAnChoi = new JCheckBox("Ăn chơi");
		chckAnChoi.setBounds(85, 52, 78, 23);
		panel_2.add(chckAnChoi);

		chckNhayMua = new JCheckBox("Nhảy múa");
		chckNhayMua.setBounds(177, 52, 89, 23);
		panel_2.add(chckNhayMua);

		checkNguNghi = new JCheckBox("Ngủ nghỉ");
		checkNguNghi.setBounds(276, 52, 78, 23);
		panel_2.add(checkNguNghi);

		JTextArea textArea = new JTextArea();

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(85, 95, 267, 93);
		panel_2.add(scrollPane);

		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(80, 416, 89, 23);
		contentPane.add(btnOk);
		btnOk.addActionListener(ctl);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(188, 416, 89, 23);
		contentPane.add(btnReset);
		btnReset.addActionListener(ctl);

		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(305, 416, 89, 23);
		contentPane.add(btnExit);
		btnExit.addActionListener(ctl);

		this.setLocationRelativeTo(null);
	}

	public boolean checkForm() {
		if (this.textField_Ho.getText().equals("") || this.textField_Ten.getText().equals("")
				|| this.textField_BiDanh.getText().equals("") || this.textField_MatMa.getText().equals("")
				|| this.buttonGroup.isSelected(null) || (this.comboBox.getSelectedItem().toString().equals(""))
				|| (!this.chckAnChoi.isSelected() && !this.chckNhayMua.isSelected()
						&& !this.checkNguNghi.isSelected())) {
			System.out.println("test");
			return false;
		}
		return true;
	}

	public void displayForm() {
		if (this.checkForm()) {
			String str = "";
			str = str + "Họ tên: " + this.textField_Ho.getText() + " " + this.textField_Ten.getText() + "\n";
			if (this.rdoNam.isSelected()) {
				str = str + "Giới tính: Nam\n";
			}
			if (this.rdoNu.isSelected()) {
				str = str + "Giới tính: Nữ\n";
			}
			if (this.rdoKhongXacDinh.isSelected()) {
				str = str + "Giới tính: Null\n";
			}
			str = str + "Quê quán: " + this.comboBox.getSelectedItem();
			JOptionPane.showMessageDialog(this, str);
		}
	}

	public void exitForm() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát?", 
				"Exit", JOptionPane.YES_NO_OPTION);
		if(luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void resetForm() {
		this.textField_Ho.setText("");
		this.textField_Ten.setText("");
		this.textField_BiDanh.setText("");
		this.textField_MatMa.setText("");
		this.buttonGroup.clearSelection();
		this.comboBox.setSelectedIndex(-1);
		this.chckAnChoi.setSelected(false);
		this.chckNhayMua.setSelected(false);
		this.checkNguNghi.setSelected(false);
		this.textField_Ho.requestFocus();
	}
}
