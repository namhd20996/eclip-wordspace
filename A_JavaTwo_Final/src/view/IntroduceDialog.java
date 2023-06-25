package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.QLNVController;
import model.ImageHelper;

import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

public class IntroduceDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroduceDialog dialog = new IntroduceDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JLabel lblNewLabel_3;

	/**
	 * Create the dialog.
	 */
	public IntroduceDialog() {
//		this.setTitle("Introduce");
		QLNVController ctl = new QLNVController(this);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(IntroduceDialog.class.getResource("/IMG_JavaIcon/Information-icon48.png")));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(IntroduceDialog.class.getResource("/IMG_JavaIcon/graduate-icon96.png")));
		lblNewLabel.setBounds(10, 49, 142, 150);
		getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Introduce", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 418, 243);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Họ tên: Hoàng Duy Nam");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(161, 22, 247, 34);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Lớp: IT18103");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(161, 67, 256, 34);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Giảng viên: Thầy Thái Anh Vỹ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(161, 120, 256, 34);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_2 = new JLabel("Phần mềm: Version 1.0");
		lblNewLabel_1_2.setBounds(161, 168, 256, 34);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(ctl);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.setIcon(new ImageIcon(IntroduceDialog.class.getResource("/IMG_JavaIcon/tick-icon-Ok-24.png")));
		btnOk.setBounds(319, 192, 89, 40);
		panel.add(btnOk);

//
//		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JavaIcon/imager_14_53459_700.jpg"));
//		Image img = ImageHelper.resize(icon.getImage(), 438, 265);
//		ImageIcon resizeImage = new ImageIcon(img);
//		this.lblNewLabel_4.setIcon(resizeImage);
//		this.setLocationRelativeTo(null);
		this.setLocationRelativeTo(null);
	}

	public void closeIntroduceDialog() {
		this.dispose();
	}
}
