package labs1_bai3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {
	private LoginModel loginModel;
	private JTextField jTextField_Password;
	private JTextField jTextField_Confirm;
	private JTextField jTextField_User;

	public LoginView() {
		this.loginModel = new LoginModel();
		this.init();
		this.setVisible(true);
	}

	private void init() {
		LoginController loginController = new LoginController(this);
		this.setTitle("Sign Up Form");
		this.setSize(300, 150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		JPanel jPanel_North = new JPanel();
		jPanel_North.setLayout(new GridLayout(3, 2));

		JLabel jLabel_User = new JLabel("Username");
		jTextField_User = new JTextField();
		JLabel jLabel_Password = new JLabel("Password");
		jTextField_Password = new JPasswordField();
		JLabel jLabel_Confirm = new JLabel("Confirm");
		jTextField_Confirm = new JPasswordField();

		jPanel_North.add(jLabel_User);
		jPanel_North.add(jTextField_User);
		jPanel_North.add(jLabel_Password);
		jPanel_North.add(jTextField_Password);
		jPanel_North.add(jLabel_Confirm);
		jPanel_North.add(jTextField_Confirm);

		JPanel jPanel_South = new JPanel();
		jPanel_South.setLayout(new FlowLayout());

		JButton jButton_Sign = new JButton("Sign up");
		jButton_Sign.addActionListener(loginController);
		JButton jButton_Cancel = new JButton("Cancel");
		jButton_Cancel.addActionListener(loginController);

		jPanel_South.add(jButton_Sign);
		jPanel_South.add(jButton_Cancel);

		this.add(jPanel_North, BorderLayout.NORTH);
		this.add(jPanel_South, BorderLayout.SOUTH);
	}

	public void getForm() {
		if(this.jTextField_User.getText().length()<=0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập value");
		}
		
		if (this.jTextField_Password.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập value");
		} else {
			try {
				String passWord = this.jTextField_Password.getText();
				this.loginModel.setPassWord(passWord);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Sai định dạng");
			}
		}

		if (this.jTextField_Confirm.getText().length() <= 0) {
			JOptionPane.showMessageDialog(this, "Chưa nhập value");
		} else {
			try {
				String confirm = this.jTextField_Confirm.getText();
				this.loginModel.setConfirm(confirm);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Sai định dạng");
			}
		}

		if (this.loginModel.getPassWord().equals(this.loginModel.getConfirm())) {
			JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
		} else {
			JOptionPane.showMessageDialog(this, "Đăng nhập thất bại");
		}
	}

	public void outForm() {
		int select = JOptionPane.showConfirmDialog(this, 
				"Bạn muốn thoát", 
				"Exit", 
				JOptionPane.YES_NO_OPTION);
		if(select == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
