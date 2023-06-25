package layout;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Component;

public class MainArr extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainArr frame = new MainArr();
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
	public MainArr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.setBounds(new Rectangle(0, 0, 100, 200));
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(10, 11, 598, 411);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
//		
//		ProductInfor panel_1 = new ProductInfor();
//		panel_1.setBounds(24, 22, 217, 217);
//		panel.add(panel_1);
		
//		ProductInfor productInfor = new ProductInfor();
//		
//		GridBagConstraints gbc_productInfor = new GridBagConstraints();
//		gbc_productInfor.fill = GridBagConstraints.BOTH;
//		gbc_productInfor.gridx = 0;
//		gbc_productInfor.gridy = 0;
//		panel.add(productInfor, gbc_productInfor);
	

		ProductInfor pro[] = { new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor(),
				new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor(),
				new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor(),
				new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor(),
				new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor(), new ProductInfor() };

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 20, 20);
		int x = 0;
		int y = 0;
		for (int i = 0; i < pro.length; i++) {
//			pro[i].setBounds(0, 0, 217, 217);
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = x;
			gbc.gridy = y;
//			gbc.gridwidth = 1;
//			gbc.gridheight = 1;
			gbl_panel.setConstraints(pro[i], gbc);
			panel.add(pro[i], gbc);
			x++;
			if (x == 4) {
				x = 0;
				y++;
			}
		}

	}
}
