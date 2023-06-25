package labs1_bai2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {
	private CalculatorModel calculatorModel;
	private JTextField jTextField_first;
	private JTextField jTextField_second;
	private JTextField jTextField_result;

	public CalculatorView() {
		this.calculatorModel = new CalculatorModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.calculatorModel = new CalculatorModel();
		CalculatorController ctl = new CalculatorController(this);
		this.setTitle("Calculator");
		this.setSize(400, 140);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		Font font = new Font("arial", Font.ITALIC, 20);

		JPanel jPanel_Center = new JPanel();
		jPanel_Center.setLayout(new GridLayout(3, 2));
		JLabel jLabel_first = new JLabel("First value");
		jLabel_first.setFont(font);
		JLabel jLabel_second = new JLabel("Second value");
		jLabel_second.setFont(font);
		JLabel jLabel_result = new JLabel("Result value");
		jLabel_result.setFont(font);
		jTextField_first = new JTextField(20);
		jTextField_second = new JTextField(20);
		jTextField_result = new JTextField(20);

		jPanel_Center.add(jLabel_first);
		jPanel_Center.add(jTextField_first);
		jPanel_Center.add(jLabel_second);
		jPanel_Center.add(jTextField_second);
		jPanel_Center.add(jLabel_result);
		jPanel_Center.add(jTextField_result);

		JPanel jPanel_South = new JPanel();
		jPanel_South.setLayout(new FlowLayout());
		JButton jButton_Plus = new JButton("+");
		jButton_Plus.addActionListener(ctl);
		JButton jButton_Minus = new JButton("-");
		jButton_Minus.addActionListener(ctl);
		JButton jButton_Multiply = new JButton("*");
		jButton_Multiply.addActionListener(ctl);
		JButton jButton_Division = new JButton("/");
		jButton_Division.addActionListener(ctl);

		jPanel_South.add(jButton_Plus);
		jPanel_South.add(jButton_Minus);
		jPanel_South.add(jButton_Multiply);
		jPanel_South.add(jButton_Division);

		this.add(jPanel_South, BorderLayout.CENTER);
		this.add(jPanel_Center, BorderLayout.NORTH);

	}

	public void getValueForm() {
		if (this.jTextField_first.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập value");
		} else {
			try {
				double valueOne = Double.valueOf(this.jTextField_first.getText());
				this.calculatorModel.setValueOne(valueOne);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Nhập sai định dạng valueOne");
			}
		}
		if (this.jTextField_second.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập value");
		} else {
			try {
				double valueTwo = Double.valueOf(this.jTextField_second.getText());
				this.calculatorModel.setValueTwo(valueTwo);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Nhập sai định dạng valueTwo");
			}
		}
	}

	public void sumResult() {
		this.getValueForm();
		this.calculatorModel.addition();
		this.jTextField_result.setText(this.calculatorModel.getResult() + "");
	}

	public void minusResult() {
		this.getValueForm();
		this.calculatorModel.subtraction();
		this.jTextField_result.setText(this.calculatorModel.getResult() + "");
	}

	public void multiplyResult() {
		this.getValueForm();
		this.calculatorModel.multiplication();
		this.jTextField_result.setText(this.calculatorModel.getResult() + "");
	}

	public void divisionResult() {
		this.getValueForm();
		this.calculatorModel.division();
		this.jTextField_result.setText(this.calculatorModel.getResult() + "");
	}
}
