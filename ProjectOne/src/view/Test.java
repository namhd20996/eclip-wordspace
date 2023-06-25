package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.Color;

public class Test extends JPanel {
	private String pname;
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
//		lblNewLabel_1.setText(""+price);
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
//		textField.setText("CC"+ pname);
	}

	/**
	 * Create the panel.
	 */
	public Test() {
		
		setLayout(null);
		setBounds(0, 0, 223, 276);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 0));
		panel.setBounds(0, 0, 223, 276);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(72, 127, 48, 14);
		panel.add(lblNewLabel);

	}
}
