package test;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.tools.Tool;

public class IMGVIEW extends JFrame {

	public IMGVIEW() {
		this.setTitle("View");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("arial", Font.PLAIN, 50);

		// Set icon
		URL url_title = IMGVIEW.class.getResource("phone-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url_title);
		this.setIconImage(img);

		URL url_item = IMGVIEW.class.getResource("phone-icon.png");
		Image img_item = Toolkit.getDefaultToolkit().createImage(url_title);

		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Menu");
		JMenu subMenu = new JMenu("Sub");

		JMenuItem jMenuItem_1 = new JMenuItem("1");
		jMenuItem_1.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(IMGVIEW.class.getResource("battery-icon.png"))));
		JMenuItem jMenuItem_2 = new JMenuItem("2");
		jMenuItem_2.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(IMGVIEW.class.getResource("AD-Andorra-Flag-icon.png"))));
		JMenuItem jMenuItem_3 = new JMenuItem("3");
		jMenuItem_3.setIcon(
				new ImageIcon(Toolkit.getDefaultToolkit().createImage(IMGVIEW.class.getResource("bulb-icon.png"))));
		JMenuItem jMenuItem_4 = new JMenuItem("4");
		jMenuItem_4.setIcon(new ImageIcon(img_item));

		jMenu.add(jMenuItem_1);
		jMenu.add(jMenuItem_2);

		subMenu.add(jMenuItem_3);
		subMenu.add(jMenuItem_4);

		jMenu.add(subMenu);
		jMenuBar.add(jMenu);

		JLabel jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(IMGVIEW.class.getResource("main.jpg"))));

		JButton jButton = new JButton("Test Button");
		jButton.setFont(font);
		jButton.setSize(50, 50);
		jButton.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(IMGVIEW.class.getResource("AD-Andorra-Flag-icon.png"))));

		this.setJMenuBar(jMenuBar);
		this.setLayout(new BorderLayout());
		this.add(jLabel, BorderLayout.CENTER);
		this.add(jButton, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			new IMGVIEW();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
