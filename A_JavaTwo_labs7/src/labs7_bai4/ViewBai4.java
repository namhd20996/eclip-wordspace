package labs7_bai4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;

public class ViewBai4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ViewBai4 frame = new ViewBai4();
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
	public ViewBai4() {
		ControllerBai4 ctl = new ControllerBai4(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 116);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Credit Card");
		lblNewLabel.setBounds(21, 26, 66, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(129, 23, 246, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setBounds(286, 54, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(ctl);
		
		this.setTitle("Annotation");
		this.setLocationRelativeTo(null);
	}

	public void checkForm() {
		try {
			if(XPoly.isCardNumber(this.textField.getText())) {
				JOptionPane.showMessageDialog(this, "Hợp lệ");
			}else {
				JOptionPane.showMessageDialog(this, "Không Hợp lệ");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Sai định dạng");
		}
	}
}
