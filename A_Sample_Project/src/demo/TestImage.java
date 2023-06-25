package demo;

import java.awt.EventQueue;

import java.awt.Image;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import lib.XImage;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class TestImage extends JFrame {

	private JPanel contentPane;
	private File file = new File("");
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestImage frame = new TestImage();
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
	public TestImage() {
		ImageCTLTest ctl = new ImageCTLTest(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(ctl);
		lblNewLabel.setBounds(127, 41, 164, 131);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(ctl);
		btnNewButton.setBounds(123, 183, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New");
		btnNewButton_1.addActionListener(ctl);
		btnNewButton_1.setBounds(239, 183, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
	
	public void saveLogo() {
//		boolean a =XImage.saveImage(file.getAbsoluteFile());
//		System.out.println(a);
	}
	
	public void uploadLogo() {
		ImageIcon icon = XImage.readImage("PNG_transparency_demonstration_1.png");
		Image img = XImage.resize(icon.getImage(), 164, 131);
		this.lblNewLabel.setIcon(new ImageIcon(img));
	}
	
	public void imageFrom() {
		JFileChooser fc = new JFileChooser();
		int option = fc.showOpenDialog(this);
		if(option == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			ImageIcon icon = new ImageIcon(file.getPath());
			Image img = lib.XImage.resize(icon.getImage(), 164, 131);
			this.lblNewLabel.setIcon(new ImageIcon(img));
		}
	}
	
	
}
