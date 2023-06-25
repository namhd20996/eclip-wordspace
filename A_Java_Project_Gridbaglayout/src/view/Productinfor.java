package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Productinfor extends JPanel {
	private JTextField txtProduct;
	private JTextField txtPrice;
	private String pName;
	private String price;
	private Icon image;
	private JLabel lbl_IMG;

	public Icon getImage() {
		return image;
	}

	public void setImage(Icon image) {
		this.image = image;
		lbl_IMG.setIcon(image);
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
		txtPrice.setText("Price " + price);
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
		txtProduct.setText("Product name: " + pName);
	}

	/**
	 * Create the panel.
	 */
	public Productinfor() {
		setLayout(null);

		 lbl_IMG = new JLabel("New label");
		lbl_IMG.setBounds(10, 11, 238, 193);
		add(lbl_IMG);

		txtProduct = new JTextField();
		txtProduct.setText("Product name:");
		txtProduct.setBounds(10, 215, 238, 20);
		add(txtProduct);
		txtProduct.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setText("Price:");
		txtPrice.setColumns(10);
		txtPrice.setBounds(10, 246, 238, 20);
		add(txtPrice);

		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnBuy, "Product name: "+pName +"Price: "+price);
			}
		});
		btnBuy.setBounds(159, 277, 89, 23);
		add(btnBuy);

	}
}
