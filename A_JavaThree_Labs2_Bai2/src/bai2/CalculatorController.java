package bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bai2.CalculatorView;

public class CalculatorController implements ActionListener{
	private CalculatorView calculatorView;
	
	public CalculatorController(CalculatorView calculatorView) {
		this.calculatorView = calculatorView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(this.calculatorView, src);
		this.calculatorView.setValueForm(src);
	}

}
