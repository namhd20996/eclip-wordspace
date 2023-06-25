package bai1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextAreaView extends JFrame {

	private JPanel contentPane;
	private TextareaModel textareaModel;
	private JTextArea textArea;
	private JTextField txtFpolyJava;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TextAreaView frame = new TextAreaView();
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
	public TextAreaView() {
		MouseListenerText mctl = new MouseListenerText(this);
		this.textareaModel = new TextareaModel();
		TextareaController ctl = new TextareaController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 372);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem jMenuItem_New = new JMenuItem("New");
		jMenuItem_New.addActionListener(ctl);
		jMenuItem_New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		jMenuItem_New.setIcon(new ImageIcon(Toolkit.getDefaultToolkit()
				.createImage(TextAreaView.class.getResource("/img/Files-New-File-icon.png"))));
//		jMenuItem_New.setIcon(new ImageIcon(TextAreaView.class.getResource("/img/Files-New-File-icon.png")));
		mnNewMenu.add(jMenuItem_New);

		JMenuItem jMenuItem_Open = new JMenuItem("Open");
		jMenuItem_Open.addActionListener(ctl);
		jMenuItem_Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		jMenuItem_Open.setIcon(new ImageIcon(TextAreaView.class.getResource("/img/open-file-icon.png")));
		mnNewMenu.add(jMenuItem_Open);

		JMenuItem jMenuItem_Save = new JMenuItem("Save");
		jMenuItem_Save.addActionListener(ctl);
		jMenuItem_Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		jMenuItem_Save.setIcon(new ImageIcon(TextAreaView.class.getResource("/img/Save-icon.png")));
		mnNewMenu.add(jMenuItem_Save);

		JMenu mnNewMenu_1 = new JMenu("Color");
		menuBar.add(mnNewMenu_1);

		JMenuItem jMenuItem_Red = new JMenuItem("Red");
		mnNewMenu_1.add(jMenuItem_Red);
		jMenuItem_Red.addActionListener(ctl);

		JMenuItem jMenuItem_Green = new JMenuItem("Green");
		mnNewMenu_1.add(jMenuItem_Green);
		jMenuItem_Green.addActionListener(ctl);

		JMenuItem jMenuItem_Blue = new JMenuItem("Blue");
		mnNewMenu_1.add(jMenuItem_Blue);
		jMenuItem_Blue.addActionListener(ctl);

		JSeparator separator = new JSeparator();
		mnNewMenu_1.add(separator);

		JMenuItem jMenuItem_TextColor = new JMenuItem("Text color");
		mnNewMenu_1.add(jMenuItem_TextColor);
		jMenuItem_TextColor.addActionListener(ctl);

		JMenu mnNewMenu_2 = new JMenu("System");
		menuBar.add(mnNewMenu_2);

		JMenuItem jMenuItem_About = new JMenuItem("About us");
		mnNewMenu_2.add(jMenuItem_About);
		jMenuItem_About.addActionListener(ctl);

		JMenuItem jMenuItem_Exit = new JMenuItem("Exit");
		mnNewMenu_2.add(jMenuItem_Exit);
		jMenuItem_Exit.addActionListener(ctl);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(10, 0, 229, 28);
		contentPane.add(toolBar);

		JButton btnNew = new JButton("");
		btnNew.addActionListener(ctl);
		btnNew.addMouseListener(mctl);
		btnNew.setActionCommand("N");
		btnNew.setIcon(new ImageIcon(TextAreaView.class.getResource("/img/Files-New-File-icon.png")));
		toolBar.add(btnNew);

		JButton btnAbout = new JButton("");
		btnAbout.addActionListener(ctl);
		btnAbout.addMouseListener(mctl);
		btnAbout.setActionCommand("A");
		btnAbout.setIcon(new ImageIcon(TextAreaView.class.getResource("/img/Person-Male-Light-icon.png")));
		toolBar.add(btnAbout);

		JButton btnExit = new JButton("");
		btnExit.addActionListener(ctl);
		btnExit.addMouseListener(mctl);
		btnExit.setActionCommand("E");
		btnExit.setIcon(new ImageIcon(TextAreaView.class.getResource("/img/ModernXP-02-System-Power-icon.png")));
		toolBar.add(btnExit);

		textArea = new JTextArea();

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(20, 39, 408, 217);
		contentPane.add(scrollPane);

		txtFpolyJava = new JTextField();
		txtFpolyJava.setHorizontalAlignment(SwingConstants.CENTER);
		txtFpolyJava.setText("Fpoly - Java3");
		txtFpolyJava.setBounds(20, 284, 408, 20);
		contentPane.add(txtFpolyJava);
		txtFpolyJava.setBackground(Color.orange);
		txtFpolyJava.setColumns(10);

		URL url_title = TextAreaView.class.getResource("/img/color-catalog-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(url_title);
		this.setIconImage(img);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void openFile() {
		JFileChooser fc = new JFileChooser();
		int value = fc.showOpenDialog(this);
		if (value == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String fileName = file.getName();
			this.textareaModel.setTenFile(file.getAbsolutePath());
			if (fileName.endsWith(".txt")) {
				try {
					List<String> list = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
					String result = "";
					for (String string : list) {
						result += string;
						result += "\n";
					}
					this.textareaModel.setContent(result);
					this.textArea.setText(this.textareaModel.getContent());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public void saveFive(String path) {
		try {
			PrintWriter pw = new PrintWriter(path, "UTF-8");
			String data = this.textArea.getText();
			pw.print(data);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void actionSaveFile() {
		JFileChooser fc = new JFileChooser();
		if (this.textareaModel.getTenFile().length() > 0) {
			this.saveFive(this.textareaModel.getTenFile());
		} else {
			int value = fc.showSaveDialog(this);
			if (value == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				this.saveFive(file.getAbsolutePath());
			}
		}
	}

	public void resetTextArea() {
		this.textArea.setText("");
	}

	public void setColorTextArea(Color color) {
		this.txtFpolyJava.setBackground(color);
	}

	public void setColorTextAreaJfilechooser() {
		Color c = JColorChooser.showDialog(this, "Chọn màu chữ", Color.WHITE);
		this.setColorTextArea(c);
	}

	public void displayAbout() {
		String str = "Program Demo Menu \n" + "Author: Tèo \n" + "Last Update: 22-02-2022 \n" + "Education: Fpoly";
		JOptionPane.showMessageDialog(this, str, "About", JOptionPane.INFORMATION_MESSAGE);
	}

	public void exitForm() {
		int value = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát?", "Exit", JOptionPane.YES_NO_OPTION);
		if (value == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
