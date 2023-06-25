package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

import controller.SearchController;
import model.SeacrhModel;

public class SearchView extends JFrame {
	private SeacrhModel seacrhModel;
	private JTextArea jTextArea;
	private JLabel jLabel_tuKhoa;
	private JButton jButton;
	private JLabel jLabel_total;
	private JTextField jTextField_tuKhoa;

	public SearchView() {
		this.seacrhModel = new SeacrhModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		this.setTitle("Search");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Font font = new FontUIResource("arial", Font.PLAIN, 40);
		SearchController sc = new SearchController(this);
		JLabel jLabel_vanBan = new JLabel("Văn Bản");
		
		
		
		jLabel_vanBan.setFont(font);
		jLabel_tuKhoa = new JLabel("Từ khóa");
		jLabel_tuKhoa.setFont(font);
		jButton = new JButton("Kết quả");
		jButton.setFont(font);
		jButton.addActionListener(sc);
		jLabel_total = new JLabel("");

		jTextField_tuKhoa = new JTextField();
		jTextArea = new JTextArea();
		jTextArea.setFont(font);
//		JScrollPane jScrollPane = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane jScrollPane = new JScrollPane(jTextArea);

		JPanel jPanel_footer = new JPanel();
		jPanel_footer.setLayout(new GridLayout(2, 2));
		jPanel_footer.add(jLabel_tuKhoa);
		jPanel_footer.add(jTextField_tuKhoa);
		jPanel_footer.add(jButton);
		jPanel_footer.add(jLabel_total);

		this.setLayout(new BorderLayout());
		this.add(jLabel_vanBan, BorderLayout.NORTH);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanel_footer, BorderLayout.SOUTH);
	}

	public void search() {
		String tuKhoa = this.jTextField_tuKhoa.getText();
		this.seacrhModel.setTuKhoa(tuKhoa);
		String vanBan = this.jTextArea.getText();
		this.seacrhModel.setVanBan(vanBan);
		this.seacrhModel.search();
		jLabel_total.setText(this.seacrhModel.getKetQua());
	}
}
