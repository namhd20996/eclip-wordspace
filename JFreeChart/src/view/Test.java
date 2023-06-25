package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 panel = new JPanel();
		panel.setBounds(10, 225, 533, 175);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(52, 38, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(52, 78, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(52, 113, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(124, 35, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(124, 75, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(124, 110, 96, 20);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(124, 179, 96, 23);
		contentPane.add(btnNewButton);
	}
	
	public void displayNone() {
		try {
			int n1 = Integer.valueOf(textField.getText());
			int n2 = Integer.valueOf(textField_1.getText());
			int n3 = Integer.valueOf(textField_2.getText());
			
			DefaultCategoryDataset datos = new DefaultCategoryDataset();
			datos.setValue(n1, "Hello", "Hi");
			datos.setValue(n2, "Hello1", "Hi1");
			datos.setValue(n3, "Hello2", "Hi2");
			
			JFreeChart g = ChartFactory.createBarChart3D(
					"Test",
					"Test1",
					"Test3",
					datos,
					PlotOrientation.VERTICAL,
					true,
					true,
					false
					
					);
			ChartPanel panel1 = new ChartPanel(g);
			panel1.setMouseWheelEnabled(true);
			panel1.setPreferredSize(new Dimension(200, 100));
			
			panel.setLayout(new BorderLayout());
			panel.add(panel1, BorderLayout.NORTH);
			
			pack();
			repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
