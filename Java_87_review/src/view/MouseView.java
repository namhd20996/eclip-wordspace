package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MouseController;
import model.MouseModel;

public class MouseView extends JFrame {
	private MouseModel model;
	private JPanel jPanel_mouse;
	private JLabel jLabel_x;
	private JLabel jLabel_y;
	private JLabel jLabel_position;
	private JLabel jLabel_count;
	private JLabel jLabel_count_value;
	private JLabel jLabel_empty_1;
	private JLabel jLabel_checkIn;
	private JLabel jLabel_checkIn_value;
	private JLabel jLabel_empty_2;

	public MouseView() {
		this.model = new MouseModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Mouse");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		MouseController mouseController = new MouseController(this);	
		Font font = new Font("arial", Font.ITALIC, 20);
		jPanel_mouse = new JPanel();
		jPanel_mouse.setBackground(Color.PINK);
		jPanel_mouse.addMouseListener(mouseController);
		jPanel_mouse.addMouseMotionListener(mouseController);

		JPanel jPanel_info = new JPanel();
		jPanel_info.setLayout(new GridLayout(3, 3));

		jLabel_position = new JLabel("Position: ");
		jLabel_position.setFont(font);
		jLabel_x = new JLabel("X = ");
		jLabel_x.setFont(font);
		jLabel_y = new JLabel("Y = ");
		jLabel_y.setFont(font);
		jLabel_count = new JLabel("Number of click: ");
		jLabel_count.setFont(font);
		jLabel_count_value = new JLabel();
		jLabel_count_value.setFont(font);
		jLabel_empty_1 = new JLabel();
		jLabel_checkIn = new JLabel("Mouse is in commponet: ");
		jLabel_checkIn.setFont(font);
		jLabel_checkIn_value = new JLabel("No");
		jLabel_checkIn_value.setFont(font);
		jLabel_empty_2 = new JLabel();

		jPanel_info.add(jLabel_position);
		jPanel_info.add(jLabel_x);
		jPanel_info.add(jLabel_y);
		jPanel_info.add(jLabel_count);
		jPanel_info.add(jLabel_count_value);
		jPanel_info.add(jLabel_empty_1);
		jPanel_info.add(jLabel_checkIn);
		jPanel_info.add(jLabel_checkIn_value);
		jPanel_info.add(jLabel_empty_2);

		this.setLayout(new BorderLayout());
		this.add(jPanel_mouse, BorderLayout.CENTER);
		this.add(jPanel_info, BorderLayout.SOUTH);

	}
	
	public void Click() {
		this.model.addClick();
		this.jLabel_count_value.setText(this.model.getCount()+"");
	}
	
	public void enter() {
		this.model.enter();
		this.jLabel_checkIn_value.setText(this.model.getCheckIn());
	}
	
	public void exit() {
		this.model.exit();
		this.jLabel_checkIn_value.setText(this.model.getCheckIn());
	}

	public void updateView(int x, int y) {
		this.model.setX(x);
		this.model.setY(y);
		this.jLabel_x.setText(this.model.getX()+"");
		this.jLabel_y.setText(this.model.getY()+"");
	}
}
