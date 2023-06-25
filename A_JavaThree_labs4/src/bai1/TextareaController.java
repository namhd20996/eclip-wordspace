package bai1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class TextareaController implements ActionListener{
	private TextAreaView textAreaView;

	public TextareaController(TextAreaView textAreaView) {
		this.textAreaView = textAreaView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(textAreaView, src);
		if(src.equals("Open")) {
			this.textAreaView.openFile();
		}else if(src.equals("Save")) {
			this.textAreaView.actionSaveFile();
		}else if(src.equals("New")) {
			this.textAreaView.resetTextArea();
		}else if(src.equals("Red")) {
			this.textAreaView.setColorTextArea(Color.red);
		}else if(src.equals("Green")) {
			this.textAreaView.setColorTextArea(Color.green);
		}else if(src.equals("Blue")) {
			this.textAreaView.setColorTextArea(Color.blue);
		}else if(src.equals("Text color")) {
			this.textAreaView.setColorTextAreaJfilechooser();
		}else if(src.equals("About us")) {
			this.textAreaView.displayAbout();
		}else if(src.equals("Exit")) {
			this.textAreaView.exitForm();
		}else if(src.equals("T")){
			this.textAreaView.resetTextArea();
		}else if(src.equals("A")){
			this.textAreaView.displayAbout();
		}else if(src.equals("E")){
			this.textAreaView.exitForm();
		}
	}
	
	
}
