package labs1_bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class CalculatorController implements ActionListener{
	private CalculatorView clCalculatorView;
	
	public CalculatorController(CalculatorView clCalculatorView) {
		this.clCalculatorView = clCalculatorView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(clCalculatorView, src);
		if(src.equals("+")) {
			this.clCalculatorView.sumResult();
		}else if(src.equals("-")) {
			this.clCalculatorView.minusResult();
		}else if(src.equals("*")) {
			this.clCalculatorView.multiplyResult();
		}else if(src.equals("/")) {
			this.clCalculatorView.divisionResult();
		}
	}

}
