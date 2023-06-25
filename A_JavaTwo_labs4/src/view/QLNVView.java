 package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ListenerQLNV;
import model.XDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;

public class QLNVView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_hoVaTen;
	private JTextField textField_ngaySinh;
	private JTextField textField_luong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLNVView frame = new QLNVView();
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
	public QLNVView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ListenerQLNV listenerQLNV = new ListenerQLNV(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản lý nhân viên");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(111, 11, 179, 23);
		contentPane.add(lblNewLabel);

		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setBounds(39, 61, 62, 14);
		contentPane.add(lblHVTn);

		JLabel lblNgySinh = new JLabel("Ngày sinh");
		lblNgySinh.setBounds(39, 96, 73, 14);
		contentPane.add(lblNgySinh);

		JLabel lblLng = new JLabel("Lương");
		lblLng.setBounds(39, 133, 48, 14);
		contentPane.add(lblLng);

		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.setBounds(111, 161, 89, 23);
		contentPane.add(btnKiemTra);
		btnKiemTra.addActionListener(listenerQLNV);

		textField_hoVaTen = new JTextField();
		textField_hoVaTen.setBounds(111, 58, 233, 20);
		contentPane.add(textField_hoVaTen);
		textField_hoVaTen.setColumns(10);

		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(111, 93, 233, 20);
		contentPane.add(textField_ngaySinh);

		textField_luong = new JTextField();
		textField_luong.setColumns(10);
		textField_luong.setBounds(111, 130, 233, 20);
		contentPane.add(textField_luong);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void checkForm() {
		if (this.textField_hoVaTen.getText().equals("")) {
			textField_hoVaTen.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(this, "Chưa nhập họ và tên", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			textField_hoVaTen.setBackground(Color.white);
		}

		if (this.textField_luong.getText().equals("")) {
			textField_luong.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(this, "Chưa nhập lương", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			textField_luong.setBackground(Color.white);
		}

		try {
			double luong = Double.valueOf(this.textField_luong.getText());
			if (luong <= 0) {
				textField_luong.setBackground(Color.yellow);
				JOptionPane.showMessageDialog(this, "Lương >0", 
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
		} catch (Exception e) {
			textField_luong.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(this, "Lương phải là số", 
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (this.textField_ngaySinh.getText().equals("")) {
			this.textField_ngaySinh.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(this, "Chưa nhập ngày sinh", 
					"Error", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}

//		SimpleDateFormat sdf = new SimpleDateFormat();
//		sdf.applyPattern("dd-mm-yyyy");
//		try {
//			Date date = sdf.parse(this.textField_ngaySinh.getText());
//			this.textField_ngaySinh.setBackground(Color.white);
//		} catch (Exception e) {
//			this.textField_ngaySinh.setBackground(Color.yellow);
//			JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ", "Error", 
//					JOptionPane.ERROR_MESSAGE);
//			return;
//		}

		try {
			XDate.parse(this.textField_ngaySinh.getText());
			this.textField_ngaySinh.setBackground(Color.white);
		} catch (ParseException e) {
			this.textField_ngaySinh.setBackground(Color.yellow);
			JOptionPane.showMessageDialog(this, "Ngày sinh không hợp lệ", 
					"Error", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		JOptionPane.showMessageDialog(this, "Đăng nhập thành công",
				"Confirm", JOptionPane.PLAIN_MESSAGE);
	}
}
