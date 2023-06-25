package labs1_bai1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import labs1_bai1.ViewSwing;

public class ControllerView implements ActionListener{
	private ViewSwing viewSwing;
	
	public ControllerView(ViewSwing viewSwing) {
		this.viewSwing = viewSwing;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(viewSwing, src);
		if(src.equals("Apple")) {
			this.viewSwing.setLabelA();
		}else if(src.equals("Mango")) {
			this.viewSwing.setLabelB();
		}else if(src.equals("Peer")) {
			this.viewSwing.setLabelC();
		}
	}

}
