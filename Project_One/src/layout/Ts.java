package layout;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.Insets;

public class Ts extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Ts frame = new Ts();
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
	public Ts() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 30, 515, 319);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
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
			pro[i].setSize(200, 200);
//			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridx = x;
			gbc.gridy = y;
//			gbc.gridwidth = 1;
//			gbc.gridheight = 1;
			panel.add(pro[i], gbc);
			x++;
			if (x == 4) {
				x = 0;
				y++;
			}
		}
	}
}
