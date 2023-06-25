package view_bai1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Bai_01_2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Bai_01_2 frame = new Bai_01_2();
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
	public Bai_01_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staff List");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(61, 11, 77, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Load");
		btnNewButton.setBounds(247, 231, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnStore = new JButton("Store");
		btnStore.setBounds(346, 231, 89, 23);
		contentPane.add(btnStore);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "FullName", "Country", "Gender", "Status"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(10, 84, 425, 133);
		contentPane.add(scrollPane);

		DefaultTableModel model_table = (DefaultTableModel) table_1.getModel();
		model_table.addRow(new Object[] { "NV01", "Nguyễn Nghiệm", "Việt Nam", "Male", "Married",
				});
		model_table.addRow(new Object[] { "NV01", "Nguyễn Nghiệm", "Việt Nam", "Male", "Married",
		});
		model_table.addRow(new Object[] { "NV01", "Nguyễn Nghiệm", "Việt Nam", "Male", "Married",
		});
		model_table.addRow(new Object[] { "NV01", "Nguyễn Nghiệm", "Việt Nam", "Male", "Married",
		});
		table_1.setRowHeight(30);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
