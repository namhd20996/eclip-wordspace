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

	public static void validateIsMaNguoiHoc(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			if (!Data.isMaNguoiHoc(textField.getText().trim())) {
				sb.append("Sai định dạng mã sinh viên").append("\n");
				textField.setBackground(Color.orange);
			} else {
				textField.setBackground(Color.white);
			}
		}
	}

	public static void validateIsMaChuyenDe(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			if (!Data.isMaChuyenDe(textField.getText().trim())) {
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
				sb.append("Sai định dạng").append("\n");
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
				if (a < -1 || a > 10) {
					sb.append("Điểm >=-1 || Điểm <=10").append("\n");
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

	public static void validateIsHocPhi(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			try {
				double a = Double.valueOf(textField.getText());
				if (a < 0) {
					sb.append("Học phí >= 0").append("\n");
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

	public static void validateIsThoiLuong(JTextField textField, StringBuilder sb, String errorMessage) {
		if (textField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			textField.setBackground(Color.orange);
			textField.requestFocus();
		} else {
			try {
				int a = Integer.valueOf(textField.getText());
				if (a < 0) {
					sb.append("Thời lượng >= 0").append("\n");
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

	public static void validatePassword(JPasswordField jPasswordField, StringBuilder sb, String errorMessage) {
		String passWord = new String(jPasswordField.getPassword());
		if (passWord.equals("")) {
			sb.append(errorMessage).append("\n");
			jPasswordField.setBackground(Color.orange);
			jPasswordField.requestFocus();
		} else {
			if (!Data.isPassword(passWord)) {
				sb.append("Sai định dạng").append("\n");
				jPasswordField.setBackground(Color.orange);
				jPasswordField.requestFocus();
			} else {
				jPasswordField.setBackground(Color.white);
			}
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

	public static void validateYear(JTextField jTextField, StringBuilder sb, String errorMessage) {
		String str = jTextField.getText().trim();
		if (str.equals("")) {
			sb.append(errorMessage).append("\n");
			jTextField.setBackground(Color.orange);
		} else {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date date = sdf.parse(str);
				Date dateNow = new Date();
				if (dateNow.getYear() - date.getYear() < 16) {
					sb.append("Ngày sinh >= 16 năm").append("\n");
					jTextField.setBackground(Color.orange);
				} else {
					jTextField.setBackground(Color.white);
				}
			} catch (Exception e) {
				sb.append("Sai định dạng ngày sinh dd/MM/yyyy").append("\n");
				jTextField.setBackground(Color.orange);
			}
		}
	}

	public static void validateDateNow(JTextField jTextField, StringBuilder sb, String errorMessage) {
		String str = jTextField.getText().trim();
		if (str.equals("")) {
			sb.append(errorMessage).append("\n");
			jTextField.setBackground(Color.orange);
		} else {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date date = sdf.parse(str);
			} catch (Exception e) {
				sb.append("Sai định dạng ngày dd/MM/yyyy").append("\n");
				jTextField.setBackground(Color.orange);
			}
		}
	}

	public static void validateDay(JTextField jTextField, JTextField jTextField2, StringBuilder sb,
			String errorMessage) {
		String str = jTextField.getText().trim();
		String str2 = jTextField2.getText().trim();
		if (str.equals("")) {
//			sb.append(errorMessage).append("\n");
//			jTextField.setBackground(Color.orange);
		} else {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date date = sdf.parse(str);
				Date date2 = sdf.parse(str2);
				if (date2.compareTo(date) < 0 || date2.compareTo(date) == 0) {
					sb.append("Ngày KG > Ngày Tạo").append("\n");
					jTextField.setBackground(Color.orange);
					jTextField2.setBackground(Color.orange);
				} else {
					jTextField.setBackground(Color.white);
					jTextField2.setBackground(Color.white);
				}
			} catch (Exception e) {

			}
		}
	}

	public static void validateCombobox(JComboBox comboBox, StringBuilder sb, String errorMessage) {
		if (comboBox.getSelectedIndex() == -1 || comboBox.getSelectedIndex() == 0) {
			sb.append(errorMessage).append("\n");
		}
	}

	public static void validateNumber(JTextField jTextField, StringBuilder sb, String errorMessage) {
		if (jTextField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			jTextField.setBackground(Color.orange);
			jTextField.requestFocus();
		} else {
			jTextField.setBackground(Color.white);
		}
	}

	public static void validateSoCCCD(JTextField jTextField, StringBuilder sb, String errorMessage) {
		if (jTextField.getText().equals("")) {
			sb.append(errorMessage).append("\n");
			jTextField.setBackground(Color.orange);
			jTextField.requestFocus();
		} else {
			if (!Data.isSoCCCCD(jTextField.getText())) {
				sb.append("Số căn cước không đúng định dạng").append("\n");
				jTextField.setBackground(Color.orange);
				jTextField.requestFocus();
			} else {
				jTextField.setBackground(Color.white);
			}
		}
	}
}
