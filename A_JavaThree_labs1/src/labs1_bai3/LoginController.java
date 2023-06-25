package labs1_bai3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener{
	private LoginView loginView;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Sign up")) {
			this.loginView.getForm();
		}else if(src.equals("Cancel")) {
			this.loginView.outForm();
		}
	}

}
