package lib;

import java.awt.Color;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Data;

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
		if (textField.getText().equals("")) {
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
}
