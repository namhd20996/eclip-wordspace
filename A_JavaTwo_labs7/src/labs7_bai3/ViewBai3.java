package labs7_bai3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ViewBai3 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Value1;
	private JTextField textField_Value2;
	private JTextField textField_Sqrt;
	private JTextField textField_LuyThua;
	private JTextField textField_Min;
	private JTextField textField_Max;
	private ModelBai3 modelBai3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ViewBai3 frame = new ViewBai3();
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
	public ViewBai3() {
		this.modelBai3 = new ModelBai3();
		ControllerBai3 c = new ControllerBai3(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số thứ 1");
		lblNewLabel.setBounds(30, 63, 80, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số thứ 2");
		lblNewLabel_1.setBounds(30, 99, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kết quả");
		lblNewLabel_2.setBounds(30, 131, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Căn bậc 2");
		lblNewLabel_3.setBounds(30, 159, 66, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Lũy thừa");
		lblNewLabel_4.setBounds(30, 189, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Số nhỏ nhất");
		lblNewLabel_5.setBounds(30, 222, 80, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Số lớn nhất");
		lblNewLabel_6.setBounds(30, 266, 80, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_Value1 = new JTextField();
		textField_Value1.setBounds(120, 60, 220, 20);
		contentPane.add(textField_Value1);
		textField_Value1.setColumns(10);
		
		textField_Value2 = new JTextField();
		textField_Value2.setColumns(10);
		textField_Value2.setBounds(120, 96, 220, 20);
		contentPane.add(textField_Value2);
		
		textField_Sqrt = new JTextField();
		textField_Sqrt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Sqrt.setEnabled(false);
		textField_Sqrt.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Sqrt.setText("0");
		textField_Sqrt.setColumns(10);
		textField_Sqrt.setBounds(120, 156, 220, 20);
		contentPane.add(textField_Sqrt);
		
		textField_LuyThua = new JTextField();
		textField_LuyThua.setEnabled(false);
		textField_LuyThua.setHorizontalAlignment(SwingConstants.CENTER);
		textField_LuyThua.setText("0");
		textField_LuyThua.setColumns(10);
		textField_LuyThua.setBounds(120, 186, 220, 20);
		contentPane.add(textField_LuyThua);
		
		textField_Min = new JTextField();
		textField_Min.setEnabled(false);
		textField_Min.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Min.setText("0");
		textField_Min.setColumns(10);
		textField_Min.setBounds(120, 219, 220, 20);
		contentPane.add(textField_Min);
		
		textField_Max = new JTextField();
		textField_Max.setEnabled(false);
		textField_Max.setText("0");
		textField_Max.setHorizontalAlignment(SwingConstants.CENTER);
		textField_Max.setColumns(10);
		textField_Max.setBounds(120, 263, 220, 20);
		contentPane.add(textField_Max);
		
		JButton btnNewButton = new JButton("Result");
		btnNewButton.setBounds(286, 329, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(c);
		
		JLabel lblNewLabel_7 = new JLabel("Hàm Số Học");
		lblNewLabel_7.setForeground(new Color(0, 0, 255));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(154, 11, 131, 38);
		contentPane.add(lblNewLabel_7);
		this.setLocationRelativeTo(null);
	}
	
	public void formClass() {
		try {
			double value1 = Double.valueOf(this.textField_Value1.getText());
			double value2 = Double.valueOf(this.textField_Value2.getText());
			this.modelBai3.setValue1(value1);
			this.modelBai3.setValue2(value2);
			this.textField_Sqrt.setText(this.modelBai3.sqrtA()+"");
			this.textField_LuyThua.setText(this.modelBai3.exponential()+"");
			this.textField_Min.setText(this.modelBai3.minNum()+"");
			this.textField_Max.setText(this.modelBai3.maxNum()+"");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Erorr Input");
		}
	}
}
