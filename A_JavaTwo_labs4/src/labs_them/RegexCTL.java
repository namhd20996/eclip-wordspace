package labs_them;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegexCTL implements ActionListener{
	private RegexView regexView;
	
	
	public RegexCTL(RegexView regexView) {
		this.regexView = regexView;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Login")) {
			this.regexView.checkForm();
		}
	}

}
