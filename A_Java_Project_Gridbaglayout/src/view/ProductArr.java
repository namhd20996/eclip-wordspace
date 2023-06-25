package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ProductArr extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductArr frame = new ProductArr();
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
	public ProductArr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 637);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 792, 591);
		contentPane.add(scrollPane);
		
		JPanel pnlProduct = new JPanel();
		scrollPane.setViewportView(pnlProduct);
		GridBagLayout gbl_pnlProduct = new GridBagLayout();
		gbl_pnlProduct.columnWidths = new int[]{260, 260, 0};
		gbl_pnlProduct.rowHeights = new int[]{306, 0};
		gbl_pnlProduct.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlProduct.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlProduct.setLayout(gbl_pnlProduct);
		
		Productinfor panel_1 = new Productinfor();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		pnlProduct.add(panel_1, gbc_panel_1);
		
		Productinfor panel = new Productinfor();
		panel.setBounds(0, 0, 255, 306);
		panel_1.add(panel);
	}
}
