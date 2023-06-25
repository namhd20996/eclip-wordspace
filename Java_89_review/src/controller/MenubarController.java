package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;

import view.MenuExamleView;

public class MenubarController implements ActionListener {
	private MenuExamleView menuExamleView;

	public MenubarController(MenuExamleView menuExamleView) {
		this.menuExamleView = menuExamleView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equalsIgnoreCase("Open")) {
			this.menuExamleView.updateLabel(src);
		}else if(src.equalsIgnoreCase("Exit")) {
			System.exit(0);
		}else if(src.equalsIgnoreCase("Toolbar")) {
			// getSource lấy ra đối tượng vừa được enter hay click chuột ép kiểu về button
			// getModel() lấy ra đối tượng hiện tại
			// AbstractButton là lớp trong java có thể ép kiểu tất cả các nút trong java về lớp này
			AbstractButton checkBox = (AbstractButton) e.getSource();
			System.out.println(checkBox);
			boolean check = checkBox.getModel().isSelected();
			if(check) {
				this.menuExamleView.endabledToolbar();
			}else {
				this.menuExamleView.disableToolbar();
			}
		}else {
			this.menuExamleView.updateLabel("Bạn đã nhấn nút: "+src);
		}
	}

}
