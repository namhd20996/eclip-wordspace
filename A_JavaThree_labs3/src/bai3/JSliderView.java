package bai3;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class JSliderView extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JSlider slider;
	private JTextField textField;
	private JButton btnNewButton;
	private JLabel lblFontSize;
	private int a;
	private Font font;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					JSliderView frame = new JSliderView();
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
	public JSliderView() {
		JSliderController ctl = new JSliderController(this);
		JSliderControllerA ctlOne = new JSliderControllerA(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		slider = new JSlider();
		slider.setSnapToTicks(true);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(2);
		slider.setValue(0);
		slider.setBounds(10, 27, 418, 49);
		slider.addChangeListener(ctl);
		contentPane.add(slider);

		lblNewLabel = new JLabel("Giá trị hiện tại:");
		lblNewLabel.setBounds(10, 123, 126, 25);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(101, 125, 49, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Set value");
		btnNewButton.setBounds(160, 124, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(ctlOne);

		lblFontSize = new JLabel("Font Size");
		lblFontSize.setForeground(new Color(0, 0, 255));
		lblFontSize.setBounds(279, 123, 126, 25);
		contentPane.add(lblFontSize);
		this.setTitle("JSlider");
		this.setLocationRelativeTo(null);
	}

	public void changeSlider() {
		a = this.slider.getValue();
		this.textField.setText("" + a);
		font = new Font("arial", Font.ITALIC, a);
		this.lblFontSize.setFont(font);
	}

	public void changeFont() {
		int value = Integer.valueOf(this.textField.getText());
		this.slider.setValue(value);
		font = new Font("arial", Font.ITALIC, value);
		this.lblFontSize.setFont(font);
	}
}
