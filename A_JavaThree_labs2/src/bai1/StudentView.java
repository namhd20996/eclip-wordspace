package bai1;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.border.TitledBorder;


import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Panel;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import javax.swing.JTree;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea;
	private JCheckBox check_Reading;
	private JCheckBox chckSinging;
	private JCheckBox chcDansing;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JComboBox comboBox;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentView() {
		this.setTitle("Student");
		StudentController studentController = new StudentController(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 34, 48, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Address");
		lblNewLabel_1.setBounds(10, 77, 48, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Sex:");
		lblNewLabel_2.setBounds(10, 215, 48, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Qualification:");
		lblNewLabel_3.setBounds(284, 34, 75, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Hobby:");
		lblNewLabel_4.setBounds(284, 77, 48, 14);
		contentPane.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(77, 31, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textArea = new JTextArea();
		textArea.setBounds(77, 78, 197, 115);
		contentPane.add(textArea);

		 buttonGroup = new ButtonGroup();

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(82, 211, 55, 23);
		contentPane.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(82, 244, 82, 23);
		contentPane.add(rdbtnFemale);

		buttonGroup.add(rdbtnMale);
		buttonGroup.add(rdbtnFemale);

		String[] arr = new String[] { "", "Graduate", "Student" };
		comboBox = new JComboBox(arr);
		comboBox.setBounds(369, 30, 93, 22);
		contentPane.add(comboBox);

		check_Reading = new JCheckBox("Reading");
		check_Reading.setBounds(363, 89, 75, 23);
		contentPane.add(check_Reading);

		chckSinging = new JCheckBox("Singing");
		chckSinging.setBounds(363, 120, 75, 23);
		contentPane.add(chckSinging);
		chcDansing = new JCheckBox("Dansing");
		chcDansing.setBounds(363, 154, 93, 23);
		contentPane.add(chcDansing);

		JButton btnValidate = new JButton("Validate");
		btnValidate.setBounds(134, 300, 89, 23);
		contentPane.add(btnValidate);
		btnValidate.addActionListener(studentController);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(studentController);
		btnReset.setBounds(267, 300, 89, 23);
		contentPane.add(btnReset);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(UIManager.getBorder("Spinner.border"));
		horizontalBox.setBounds(355, 77, 107, 116);
		contentPane.add(horizontalBox);

		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		horizontalBox_1.setBounds(75, 213, 98, 54);
		contentPane.add(horizontalBox_1);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void resetForm() {
		this.textField.setText("");
		this.textArea.setText("");
		this.buttonGroup.clearSelection();
		this.comboBox.setSelectedIndex(-1);
		this.check_Reading.setSelected(false);
		this.chcDansing.setSelected(false);
		this.chckSinging.setSelected(false);
	}

	public boolean check() {
		if (this.textField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập Name");
			return false;
		}
		if (this.textArea.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Chưa nhập Address");
			return false;
		}
		if (!this.rdbtnMale.isSelected() && !this.rdbtnFemale.isSelected()) {
			JOptionPane.showMessageDialog(this, "Chưa Click Sex");
			return false;
		}

		if (this.comboBox.getSelectedIndex() <= 0) {
			JOptionPane.showMessageDialog(this, "Chưa click chọn Qualificaution");
			return false;
		}

		if (!this.check_Reading.isSelected() && !this.chckSinging.isSelected() && !this.chcDansing.isSelected()) {
			JOptionPane.showMessageDialog(this, "Chưa click chọn Hobby");
			return false;
		}
		return true;
	}

	public void validateTest() {
		if (this.check()) {
			String str = "";
			str = "Name: " + this.textField.getText() + "\n";
			str = str + "Address: " + this.textArea.getText() + "\n";
			if (this.rdbtnMale.isSelected()) {
				str = str + "Sex: Male\n";
			} else if (this.rdbtnMale.isSelected()) {
				str = str + "Sex: Female\n";
			}
			str = str + "Qualificaution: "+ this.comboBox.getSelectedItem().toString()+"\n";
			if(this.check_Reading.isSelected()) {
				str = str +"Hobby: Reading\n";
			}
			if(this.chckSinging.isSelected()) {
				str = str +"Hobby: Singing\n";
			}
			if(this.chcDansing.isSelected()) {
				str = str +"Hobby: Dansing\n";
			}
			JOptionPane.showMessageDialog(this, str);
		}
	}
}
