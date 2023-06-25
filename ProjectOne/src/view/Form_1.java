package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class Form_1 extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form_1 frame = new Form_1();
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
	public Form_1() {
		setBounds(191, 76, 897, 589);
		setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 64));
		panel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1.setBounds(0, 0, 202, 221);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phòng 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 94, 24);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Trả");
		btnNewButton.setBounds(10, 46, 49, 23);
		panel_1.add(btnNewButton);
		
		JButton btnXem = new JButton("Xem");
		btnXem.setBounds(69, 46, 55, 23);
		panel_1.add(btnXem);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(134, 46, 63, 23);
		panel_1.add(btnSa);
		
		JButton btnChnhSa = new JButton("Chỉnh sửa");
		btnChnhSa.setBounds(10, 192, 94, 23);
		panel_1.add(btnChnhSa);
		
		JButton btnNewButton_1_1 = new JButton("Xóa");
		btnNewButton_1_1.setBounds(133, 192, 64, 23);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Hoàng Duy Nam");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 104, 201, 24);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Hoàng Duy Nam");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 144, 201, 24);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_1.setBackground(new Color(255, 128, 64));
		panel_1_1.setBounds(212, 0, 202, 221);
		panel.add(panel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phòng 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 11, 94, 24);
		panel_1_1.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Trả");
		btnNewButton_1.setBounds(10, 46, 49, 23);
		panel_1_1.add(btnNewButton_1);
		
		JButton btnXem_1 = new JButton("Xem");
		btnXem_1.setBounds(69, 46, 55, 23);
		panel_1_1.add(btnXem_1);
		
		JButton btnSa_1 = new JButton("Sửa");
		btnSa_1.setBounds(134, 46, 63, 23);
		panel_1_1.add(btnSa_1);
		
		JButton btnChnhSa_1 = new JButton("Chỉnh sửa");
		btnChnhSa_1.setBounds(10, 192, 94, 23);
		panel_1_1.add(btnChnhSa_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Xóa");
		btnNewButton_1_1_1.setBounds(133, 192, 64, 23);
		panel_1_1.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hoàng Duy Nam");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(10, 104, 201, 24);
		panel_1_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hoàng Duy Nam");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setBounds(10, 144, 201, 24);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_2.setBackground(new Color(255, 0, 0));
		panel_1_2.setBounds(424, 0, 202, 221);
		panel.add(panel_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phòng 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 11, 94, 24);
		panel_1_2.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Trả");
		btnNewButton_2.setBounds(10, 46, 49, 23);
		panel_1_2.add(btnNewButton_2);
		
		JButton btnXem_2 = new JButton("Xem");
		btnXem_2.setBounds(69, 46, 55, 23);
		panel_1_2.add(btnXem_2);
		
		JButton btnSa_2 = new JButton("Sửa");
		btnSa_2.setBounds(134, 46, 63, 23);
		panel_1_2.add(btnSa_2);
		
		JButton btnChnhSa_2 = new JButton("Chỉnh sửa");
		btnChnhSa_2.setBounds(10, 192, 94, 23);
		panel_1_2.add(btnChnhSa_2);
		
		JButton btnNewButton_1_1_2 = new JButton("Xóa");
		btnNewButton_1_1_2.setBounds(133, 192, 64, 23);
		panel_1_2.add(btnNewButton_1_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Hoàng Duy Nam");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(10, 104, 201, 24);
		panel_1_2.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Hoàng Duy Nam");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setBounds(10, 144, 201, 24);
		panel_1_2.add(lblNewLabel_1_1_2);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setLayout(null);
		panel_1_3.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1_3.setBackground(new Color(0, 255, 0));
		panel_1_3.setBounds(636, 0, 202, 221);
		panel.add(panel_1_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phòng 1");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 11, 94, 24);
		panel_1_3.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("Trả");
		btnNewButton_3.setBounds(10, 46, 49, 23);
		panel_1_3.add(btnNewButton_3);
		
		JButton btnXem_3 = new JButton("Xem");
		btnXem_3.setBounds(69, 46, 55, 23);
		panel_1_3.add(btnXem_3);
		
		JButton btnSa_3 = new JButton("Sửa");
		btnSa_3.setBounds(134, 46, 63, 23);
		panel_1_3.add(btnSa_3);
		
		JButton btnChnhSa_3 = new JButton("Chỉnh sửa");
		btnChnhSa_3.setBounds(10, 192, 94, 23);
		panel_1_3.add(btnChnhSa_3);
		
		JButton btnNewButton_1_1_3 = new JButton("Xóa");
		btnNewButton_1_1_3.setBounds(133, 192, 64, 23);
		panel_1_3.add(btnNewButton_1_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Hoàng Duy Nam");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(10, 104, 201, 24);
		panel_1_3.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Hoàng Duy Nam");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setBounds(10, 144, 201, 24);
		panel_1_3.add(lblNewLabel_1_1_3);
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);
	}
}
