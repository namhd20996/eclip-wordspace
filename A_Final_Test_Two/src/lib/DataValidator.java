package lib;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DataValidator {
	public static void validateEmpty(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			textField.setBackground(Color.white);
		}
	}

	public static void validateIsID(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			if (!Data.isID(textField.getText().trim())) {
				sb.append("Sai định dạng mã sinh viên").append("\n");
				textField.setBackground(Color.orange);
			} else {
				textField.setBackground(Color.white);
			}
		}
	}

	public static void validateIsHoTen(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			if (!Data.isHoTen(textField.getText().trim())) {
				sb.append("Sai định dạng họ tên").append("\n");
				textField.setBackground(Color.orange);
			} else {
				textField.setBackground(Color.white);
			}
		}
	}

	public static void validateIsEmail(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().trim().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			if (!Data.isEmail(textField.getText().trim())) {
				sb.append("Sai định dạng email").append("\n");
				textField.setBackground(Color.orange);
			} else {
				textField.setBackground(Color.white);
			}
		}
	}

	public static void validateIsSDT(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			if (!Data.isSDT(textField.getText().trim())) {
				sb.append("Sai định dạng số điện thoại").append("\n");
				textField.setBackground(Color.orange);
			} else {
				textField.setBackground(Color.white);
			}
		}
	}

	public static void validateIsDiem(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			try {
				double a = Double.valueOf(textField.getText());
				if (a < 0 || a > 10) {
					sb.append("Điểm >=0 || Điểm <=10").append("\n");
					textField.setBackground(Color.orange);
				} else {
					textField.setBackground(Color.white);
				}
			} catch (Exception e) {
				sb.append("Sai định dạng số").append("\n");
				textField.setBackground(Color.orange);
			}
		}
	}

	public static void validateEmpty(JPasswordField jPasswordField, StringBuilder sb, String errorMessage) {
		String passWord = new String(jPasswordField.getPassword());
		if (passWord.equals("")) {
			sb.append(errorMessage).append("\n");
			jPasswordField.setBackground(Color.orange);
			jPasswordField.requestFocus();
		} else {
			jPasswordField.setBackground(Color.white);
		}
	}

	public static void validateChecked(ButtonGroup but, StringBuilder sb, String errorMessage) {
		if (but.getSelection() == null) {
			sb.append(errorMessage).append("\n");
		}
	}

	public static void validateConfirmPass(JPasswordField jPasswordField, JPasswordField jPasswordFieldOne,
			StringBuilder sb, String errorMessage) {
		String passWord = new String(jPasswordField.getPassword());
		String passWordOne = new String(jPasswordFieldOne.getPassword());
		if (!passWord.equals(passWordOne)) {
			sb.append(errorMessage).append("\n");
			jPasswordField.setBackground(Color.orange);
			jPasswordFieldOne.setBackground(Color.orange);
		} else {
//			jPasswordField.setBackground(Color.white);
//			jPasswordFieldOne.setBackground(Color.white);
		}
	}

	public static void validateBirtDay(JTextField jTextField, StringBuilder sb, String errorMessage) {
		String str = jTextField.getText().trim();
		if (str.equals("")) {
			sb.append(errorMessage).append("\n");
			jTextField.setBackground(Color.orange);
		} else {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date date = sdf.parse(str);
				jTextField.setBackground(Color.white);
			} catch (Exception e) {
				sb.append("Sai định dạng ngày sinh dd/MM/yyyy").append("\n");
				jTextField.setBackground(Color.orange);
			}
		}
	}

	public static void validateCombobox(JComboBox comboBox, StringBuilder sb, String errorMessage) {
		if (comboBox.getSelectedIndex() == 0) {
			sb.append(errorMessage).append("\n");
		}
	}
}
