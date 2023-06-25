package bai3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ShowMessageController implements ActionListener {
	private ShowMessageView showMessageView;

	public ShowMessageController(ShowMessageView showMessageView) {
		this.showMessageView = showMessageView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Message Dialog")) {
			JOptionPane.showMessageDialog(this.showMessageView, "Please input your name");
		} else if (src.equals("Input Dialog")) {
			String name = JOptionPane.showInputDialog(this.showMessageView, "Your name");
			if (name != null) {
				JOptionPane.showMessageDialog(this.showMessageView, "Name: " + name);
			}
		} else if (src.equals("Confirm Dialog")) {
			int ret = JOptionPane.showConfirmDialog(this.showMessageView, "Are you sure?", "Confirm",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (ret == JOptionPane.YES_OPTION) {
				// Xử lý trường hợp người dùng chọn Yes
			} else {
				// Xử lý trường hợp người dùng chọn No
			}
		} else if (src.equals("Option Dialog")) {
			int messageType = JOptionPane.QUESTION_MESSAGE;

			String[] options = { "Java", "C++", "VB", "PHP", "Perl" };
			int code = JOptionPane.showOptionDialog(this.showMessageView, "What langueage do you prefer",
					"Option Dialog", 0, messageType, null, options, "PHP");
			JOptionPane.showMessageDialog(showMessageView, "Answer: " + code);
		}else if(src.equals("IT18103")) {
			 Object[] options = {"Yes, please","No way!"};
		        int n = JOptionPane.showOptionDialog(this.showMessageView,"Would you like green eggs and ham?", 
		                "A Silly Question", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,
		        new ImageIcon(getClass().getResource("/IMG_JavaIcon/Student-3-icon24.png")), ///null, do not use a custom Icon
		        options,  //the titles of buttons
		        options[0]); 
		}
	}

}
