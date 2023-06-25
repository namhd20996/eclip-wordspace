package view;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TextListener;
import model.TextModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class TextView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_FileName;
	private TextModel textModel;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextView frame = new TextView();
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
	public TextView() {
		this.textModel = new TextModel();
		TextListener ts = new TextListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Filename");
		lblNewLabel.setBounds(24, 42, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Content");
		lblNewLabel_1.setBounds(24, 81, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_FileName = new JTextField();
		textField_FileName.setBounds(82, 39, 346, 20);
		contentPane.add(textField_FileName);
		textField_FileName.setColumns(10);
		
		 textArea = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(24, 106, 404, 126);
		contentPane.add(scrollPane);
		
		JButton btnNewButton_save = new JButton("Save");
		btnNewButton_save.setBounds(205, 243, 89, 23);
		contentPane.add(btnNewButton_save);
		btnNewButton_save.addActionListener(ts);
		
		JButton btn_Open = new JButton("Open");
		btn_Open.setBounds(339, 243, 89, 23);
		contentPane.add(btn_Open);
		btn_Open.addActionListener(ts);
		this.setTitle("File");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void actionOpenFile() {
		JFileChooser fc = new JFileChooser();
		int val = fc.showOpenDialog(this);
		if(val == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String fileName = file.getName();
			this.textModel.setFileName(file.getAbsolutePath());
			if(fileName.endsWith(".txt")) {
				try {
					List<String> list = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
					String result = "";
					for (String string : list) {
						result += string;
						result += "\n";
					}
					this.textModel.setContent(result);
					this.textArea.setText(this.textModel.getContent());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	public void actionSaveFile() {
		JFileChooser fc = new JFileChooser();
		if(this.textModel.getFileName().length()>0) {
			this.saveFile(this.textModel.getFileName());
		}else {
			int val = fc.showSaveDialog(this);
			if(val == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				this.saveFile(file.getAbsolutePath());
			}
		}
	}
	
	public void saveFile(String path) {
		try {
			PrintWriter pw = new PrintWriter(path, "UTF8");
			String data = this.textArea.getText();
			pw.print(data);
			pw.flush();
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
