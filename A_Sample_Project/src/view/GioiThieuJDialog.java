package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import lib.XImage;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import controller.GioiThieuJDialogCTL;
import javax.swing.SwingConstants;

public class GioiThieuJDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GioiThieuJDialog dialog = new GioiThieuJDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JLabel lblNewLabel;

	/**
	 * Create the dialog.
	 */
	public GioiThieuJDialog() {
		GioiThieuJDialogCTL gioiThieuJDialogCTL = new GioiThieuJDialogCTL(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GioiThieuJDialog.class.getResource("/IMG_JPG/logo-truong-fpt_043152255.png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 759, 533);
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.addMouseListener(gioiThieuJDialogCTL);
//		lblNewLabel.setIcon(new ImageIcon(GioiThieuJDialog.class.getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg")));
		lblNewLabel.setBounds(10, 11, 727, 317);
		getContentPane().add(lblNewLabel);

		ImageIcon icon = new ImageIcon(getClass().getResource("/IMG_JPG/logo-fpt-inkythuatso-1-01-01-14-33-35.jpg"));
		Image img = XImage.resize(icon.getImage(), 600, 300);
		this.lblNewLabel.setIcon(new ImageIcon(img));

		JTextArea txtrPolyproLD = new JTextArea();
		txtrPolyproLD.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrPolyproLD.setEditable(false);
		txtrPolyproLD.setText(
				"Polypro là dự án mẫu . Mục tiêu chính là huấn luyện sinh viên qui trình thực hiện dự án\r\n\r\nMục tiêu của dự án này là để rèn luyện kỹ năng IO (CDIO) tức không yêu cầu sinh viên phải\r\nthu thập phân tích mà chỉ thực hiện và vẫn hành một phần mềm chuẩn bị cho các dự án sau \r\nnày .Các kỹ năng CD (trong CDIO) sẽ được huấn luyện ở dự án 1 và dự án 2.\r\n\r\nYêu cầu về môi trường:\r\n1. Hệ điều hành bất kỳ\r\n2. JDK 1.8 trở lên\r\n3. SQL Server 2008 trở lên \r\n");
		txtrPolyproLD.setBounds(10, 339, 727, 183);
		getContentPane().add(txtrPolyproLD);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
	}

	public void closeForm() {
		this.dispose();
	}
}
