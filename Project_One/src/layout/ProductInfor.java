package layout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

public class ProductInfor extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProductInfor() {
		setBackground(new Color(255, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 209, 209);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 115, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(151, 119, 48, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(88, 5, 48, 14);
		add(lblNewLabel);

	}

}
