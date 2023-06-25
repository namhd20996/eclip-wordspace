package bai4;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



public class TextListener implements ActionListener{
	private TextView textView;

	public TextListener(TextView textView) {
		this.textView = textView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Open")) {
			this.textView.actionOpenFile();
		}else if(src.equals("Save")) {
			this.textView.actionSaveFile();
		}
	}
	
	
}
