package review;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class ImageReview extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private byte[] arrIMG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageReview frame = new ImageReview();
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
	public ImageReview() {
		CTLReview ctl = new CTLReview(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(118, 28, 161, 131);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(ctl);
		btnNewButton.setBounds(105, 184, 89, 23);
		contentPane.add(btnNewButton);
	}

	public void disPlayImage() {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Image File (*.jpg)";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".jpg");
				}
			}
		});
		if (fc.showOpenDialog(this) == JFileChooser.CANCEL_OPTION) {
			return;
		}
		
		File file = fc.getSelectedFile();
		try {
			ImageIcon icon = new ImageIcon(file.getPath());
			Image img = ImageHelper.resize(icon.getImage(), 161, 131);
			ImageIcon resizeIcon = new ImageIcon(img);
			this.lblNewLabel.setIcon(resizeIcon);
			arrIMG = ImageHelper.toByteArray(img, "jpg");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
