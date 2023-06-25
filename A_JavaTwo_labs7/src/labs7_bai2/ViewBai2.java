package labs7_bai2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;

public class ViewBai2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Value1;
	private JTextField textField_Value2;
	private ModelBai2 modelBai2;
	private JLabel lable_Result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ViewBai2 frame = new ViewBai2();
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
	public ViewBai2() {
		this.modelBai2 = new ModelBai2();
		ControllerBai2 c = new ControllerBai2(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Số 1");
		lblNewLabel.setBounds(51, 75, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblS = new JLabel("Số 2");
		lblS.setBounds(51, 118, 48, 14);
		contentPane.add(lblS);
		
		textField_Value1 = new JTextField();
		textField_Value1.setBounds(109, 72, 182, 20);
		contentPane.add(textField_Value1);
		textField_Value1.setColumns(10);
		
		textField_Value2 = new JTextField();
		textField_Value2.setColumns(10);
		textField_Value2.setBounds(109, 115, 182, 20);
		contentPane.add(textField_Value2);
		
		JLabel lblTnhTng = new JLabel("Tính Tổng 2 Số");
		lblTnhTng.setForeground(new Color(0, 0, 255));
		lblTnhTng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnhTng.setBounds(124, 11, 141, 50);
		contentPane.add(lblTnhTng);
		
		JButton btnNewButton = new JButton("Tính Tổng");
		btnNewButton.setBounds(51, 191, 114, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(c);
		
		lable_Result = new JLabel("Result");
		lable_Result.setBounds(209, 195, 48, 14);
		contentPane.add(lable_Result);
		this.setLocationRelativeTo(null);
	}
	
	public void sumValueView() {
		try {
			double value1 = Double.valueOf(this.textField_Value1.getText());
			double value2 = Double.valueOf(this.textField_Value2.getText());
			this.modelBai2.setValue1(value1);
			this.modelBai2.setValue2(value2);
			this.modelBai2.sumValue();
			this.lable_Result.setText(this.modelBai2.getResult()+"");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Lỗi giá trị nhập");
		}
		
	}
}
