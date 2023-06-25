package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

import controller.MyColorController;
import model.MycolorModel;

public class MyColorView extends JFrame{
	private MycolorModel model;
	private JLabel jLabel;
	
	public MyColorView() {
		this.model = new MycolorModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Color");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new FontUIResource("arial", Font.BOLD, 20);
		Font font_text = new FontUIResource("arial", Font.BOLD, 100);
		MyColorController ac = new MyColorController(this);
		
		JPanel jPanel_center = new JPanel();
		jPanel_center.setLayout(new BorderLayout());
		jLabel = new JLabel("--Text--");
		jLabel.setFont(font_text);
		jPanel_center.add(jLabel);
		
		JPanel jPanel_footer = new JPanel();
		jPanel_footer.setLayout(new GridLayout(2,3));
		
		JButton jButton_red = new JButton("Red text");
		jButton_red.setFont(font);
		jButton_red.setForeground(Color.RED);
		jButton_red.addActionListener(ac);
		
		JButton jButton_blue = new JButton("Blue text");
		jButton_blue.setFont(font);
		jButton_blue.setForeground(Color.BLUE);
		jButton_blue.addActionListener(ac);
		
		JButton jButton_yellow = new JButton("Yellow text");
		jButton_yellow.setFont(font);
		jButton_yellow.setForeground(Color.YELLOW);
		jButton_yellow.addActionListener(ac);
		JButton jButton_backround_red = new JButton("Background red");
		jButton_backround_red.setFont(font);
		jButton_backround_red.setBackground(Color.RED);
		jButton_backround_red.setOpaque(true);
		jButton_backround_red.addActionListener(ac);
		
		JButton jButton_backround_blue = new JButton("Background blue");
		jButton_backround_blue.setFont(font);
		jButton_backround_blue.setBackground(Color.BLUE);
		jButton_backround_blue.setOpaque(true);
		jButton_backround_blue.addActionListener(ac);
		
		JButton jButton_backround_yellow = new JButton("Background yellow");
		jButton_backround_yellow.setFont(font);
		jButton_backround_yellow.setBackground(Color.YELLOW);
		jButton_backround_yellow.setOpaque(true);	
		jButton_backround_yellow.addActionListener(ac);
		
		jPanel_footer.add(jButton_red);
		jPanel_footer.add(jButton_blue);
		jPanel_footer.add(jButton_yellow);
		jPanel_footer.add(jButton_backround_red);
		jPanel_footer.add(jButton_backround_blue);
		jPanel_footer.add(jButton_backround_yellow);
		
		this.setLayout(new BorderLayout());
		this.add(jPanel_center, BorderLayout.CENTER);
		this.add(jPanel_footer, BorderLayout.SOUTH);
	}

	public void changeTo_color(Color color) {
		this.jLabel.setForeground(color);
	}
	
	public void changeBackground_color(Color color) {
		this.jLabel.setBackground(color);
		this.jLabel.setOpaque(true);
	}
	
}
