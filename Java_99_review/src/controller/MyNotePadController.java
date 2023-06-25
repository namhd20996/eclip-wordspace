package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.MyNotePadView;

public class MyNotePadController implements ActionListener {
	private MyNotePadView myNotePadView;

	public MyNotePadController(MyNotePadView myNotePadView) {
		this.myNotePadView = myNotePadView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if (src.equals("Open")) {
			int returnVal = fc.showOpenDialog(this.myNotePadView);
			// APPROVE_OPTION chọn được file
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				String fileName = file.getName();
				this.myNotePadView.model.setFileName(file.getAbsolutePath());
				this.myNotePadView.lblNewLabel.setText(this.myNotePadView.model.getFileName());
				if (fileName.endsWith(".txt")) {
					try {
						List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
						String result = "";
						for (String line : allText) {
							result += line;
							result += "\n";
						}
						this.myNotePadView.model.setContent(result);
						this.myNotePadView.textArea.setText(this.myNotePadView.model.getContent());
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}

		} else if (src.equals("Save")) {
			if (this.myNotePadView.model.getFileName().length() > 0) {
				save(this.myNotePadView.model.getFileName());
			} else {
				int returnVal = fc.showSaveDialog(this.myNotePadView);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					save(file.getAbsolutePath());
				}
			}

		}

	}

	public void save(String fileName) {
		try {
			PrintWriter pw = new PrintWriter(fileName, "UTF-8");
			String data = this.myNotePadView.textArea.getText();
			pw.print(data);
			pw.flush();
			pw.close();
		} catch (Exception e2) {  
			// TODO: handle exception
		}
	}

}
