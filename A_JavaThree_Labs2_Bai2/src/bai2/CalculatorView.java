package bai2;

import java.awt.EventQueue;

import java.awt.GridLayout;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CalculatorView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private CalculatorModel calculatorModel;
	private JButton jButton_Chia;
	private JButton jButton_CanBac2;
	private JButton jButton_Nhan;
	private JButton jButton_ChiaLayDu;
	private JButton jButton_Tru;
	private JButton jButton_ChiaX;
	private JButton jButton_CongTru;
	private JButton jButton_Reset;
	private JButton jButton_Cong;
	private JButton jButton_Bang;
	private String result = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorView frame = new CalculatorView();
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
	public CalculatorView() {
		this.calculatorModel = new CalculatorModel();
		CalculatorController ctl = new CalculatorController(this);
		this.setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Casio");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(217, 11, 84, 24);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 46, 299, 31);
		contentPane.add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 5));
		panel.setBounds(10, 103, 299, 226);
		contentPane.add(panel);

		JButton jButton_1 = new JButton("1");
		jButton_1.addActionListener(ctl);
		JButton jButton_2 = new JButton("2");
		jButton_2.addActionListener(ctl);
		JButton jButton_3 = new JButton("3");
		jButton_3.addActionListener(ctl);
		jButton_Chia = new JButton("/");
		jButton_Chia.addActionListener(ctl);
		jButton_CanBac2 = new JButton("sqrt");
		jButton_CanBac2.addActionListener(ctl);
		JButton jButton_4 = new JButton("4");
		jButton_4.addActionListener(ctl);
		JButton jButton_5 = new JButton("5");
		jButton_5.addActionListener(ctl);
		JButton jButton_6 = new JButton("6");
		jButton_6.addActionListener(ctl);
		jButton_Nhan = new JButton("*");
		jButton_Nhan.addActionListener(ctl);
		jButton_ChiaLayDu = new JButton("%");
		jButton_ChiaLayDu.addActionListener(ctl);
		JButton jButton_7 = new JButton("7");
		jButton_7.addActionListener(ctl);
		JButton jButton_8 = new JButton("8");
		jButton_8.addActionListener(ctl);
		JButton jButton_9 = new JButton("9");
		jButton_9.addActionListener(ctl);
		jButton_Tru = new JButton("-");
		jButton_Tru.addActionListener(ctl);
		jButton_ChiaX = new JButton("1/x");
		jButton_ChiaX.addActionListener(ctl);
		JButton jButton_0 = new JButton("0");
		jButton_0.addActionListener(ctl);
		jButton_CongTru = new JButton("+/-");
		jButton_CongTru.addActionListener(ctl);
		jButton_Reset = new JButton("C");
		jButton_Reset.addActionListener(ctl);
		jButton_Cong = new JButton("+");
		jButton_Cong.addActionListener(ctl);
		jButton_Bang = new JButton("=");
		jButton_Bang.addActionListener(ctl);

		panel.add(jButton_1);
		panel.add(jButton_2);
		panel.add(jButton_3);
		panel.add(jButton_Chia);
		panel.add(jButton_CanBac2);
		panel.add(jButton_4);
		panel.add(jButton_5);
		panel.add(jButton_6);
		panel.add(jButton_Nhan);
		panel.add(jButton_ChiaLayDu);
		panel.add(jButton_7);
		panel.add(jButton_8);
		panel.add(jButton_9);
		panel.add(jButton_Tru);
		panel.add(jButton_ChiaX);
		panel.add(jButton_0);
		panel.add(jButton_CongTru);
		panel.add(jButton_Reset);
		panel.add(jButton_Cong);
		panel.add(jButton_Bang);

		getContentPane().add(panel);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void resetForm() {
		this.textField.setText("");
	}
	
	public void setValueForm(String value) {
		try {
			result += value;
			StringTokenizer stk = new StringTokenizer(result, "/");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void getValueForm() {
		double value = Double.valueOf(this.textField.getText());
		this.calculatorModel.setValueOne(value);
		if(this.jButton_Chia.getText().equals("/")) {
			this.textField.setText("");
		}
	}
}
