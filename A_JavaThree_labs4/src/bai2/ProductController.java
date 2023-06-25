package bai2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class ProductController implements ActionListener, MouseListener{
	private ProductView productView;
	
	public ProductController(ProductView productView) {
		this.productView = productView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JOptionPane.showMessageDialog(productView, src);
		if(src.equals("Reset")) {
			this.productView.resetForm();
		}else if(src.equals("Add")) {
			this.productView.getValueForm();
		}else if(src.equals("Delete")) {
			this.productView.deleteProduct();
		}else if(src.equals("Update")) {
			this.productView.getValueForm();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.productView.updateForm();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
