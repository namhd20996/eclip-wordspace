package bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bai2.CalculatorView;

public class CalculatorController implements ActionListener {
	private CalculatorView calculatorView;

	public CalculatorController(CalculatorView calculatorView) {
		this.calculatorView = calculatorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(this.calculatorView, src);
		if (src.equals("1") || src.equals("2") || src.equals("3") || src.equals("4") || src.equals("5")
				|| src.equals("6") || src.equals("7") || src.equals("8") || src.equals("9")) {
			this.calculatorView.setValueForm(src);
		} else if (src.equals("+/-")) {
			this.calculatorView.daoDau();
		} else if (src.equals("+")) {
			this.calculatorView.CongTruNhanChia(src);
		} else if (src.equals("-")) {
			this.calculatorView.CongTruNhanChia(src);
		} else if (src.equals("*")) {
			this.calculatorView.CongTruNhanChia(src);
		} else if (src.equals("/")) {
			this.calculatorView.CongTruNhanChia(src);
		} else if (src.equals("=")) {
			this.calculatorView.tinhToan();
		}else if (src.equals("C")) {
			this.calculatorView.clearForm();
		}else if (src.equals("sqrt")) {
			this.calculatorView.toanTuSQRT(src);
		}else if (src.equals("%")) {
			this.calculatorView.toanTuSQRT(src);
		}else if (src.equals("1/x")) {
			this.calculatorView.toanTuSQRT(src);
		}
	}

}
