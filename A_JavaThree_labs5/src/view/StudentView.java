package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.StudentCTL;
import dao.StudentDAO;
import database.JDBCUtil;
import model.Data;
import model.ListStudentModel;
import model.StudentModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.util.ArrayList;

public class StudentView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MSV;
	private JTextField textField_HoTen;
	private JTextField textField_Email;
	private JTextField textField_SDT;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JTextArea textArea;
	private ListStudentModel listStudentModel;
	private int index;
	private ButtonGroup buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		this.listStudentModel = new ListStudentModel();
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(StudentView.class.getResource("/img/color-catalog-icon.png")));
		StudentCTL ctl = new StudentCTL(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý User");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(107, 11, 166, 23);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã sinh viên");
		lblNewLabel_1.setBounds(10, 39, 89, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Họ tên");
		lblNewLabel_2.setBounds(10, 76, 48, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(10, 110, 48, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Số điện thoại");
		lblNewLabel_4.setBounds(10, 144, 89, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Giới tính");
		lblNewLabel_5.setBounds(10, 184, 48, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Địa chỉ");
		lblNewLabel_6.setBounds(10, 223, 48, 14);
		contentPane.add(lblNewLabel_6);

		textField_MSV = new JTextField();
		textField_MSV.setBounds(82, 36, 96, 20);
		contentPane.add(textField_MSV);
		textField_MSV.setColumns(10);

		textField_HoTen = new JTextField();
		textField_HoTen.setColumns(10);
		textField_HoTen.setBounds(82, 73, 96, 20);
		contentPane.add(textField_HoTen);

		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(82, 107, 96, 20);
		contentPane.add(textField_Email);

		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(82, 141, 96, 20);
		contentPane.add(textField_SDT);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(82, 180, 48, 23);
		contentPane.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(139, 180, 57, 23);
		contentPane.add(rdoNu);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNu);
		buttonGroup.add(rdoNam);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(294, 35, 89, 23);
		btnAdd.addActionListener(ctl);
		btnAdd.setIcon(new ImageIcon(StudentView.class.getResource("/img/Folder-Add-icon.png")));
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(StudentView.class.getResource("/img/File-Delete-icon.png")));
		btnDelete.setBounds(294, 72, 89, 23);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(ctl);
		btnUpdate.setIcon(new ImageIcon(StudentView.class.getResource("/img/Edit-Document-icon.png")));
		btnUpdate.setBounds(294, 106, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(ctl);
		btnSave.setIcon(new ImageIcon(StudentView.class.getResource("/img/Save-icon.png")));
		btnSave.setBounds(294, 140, 89, 23);
		contentPane.add(btnSave);

		JButton btnFirst = new JButton();
		btnFirst.setBounds(82, 305, 63, 33);
		btnFirst.addActionListener(ctl);
		btnFirst.setActionCommand("F");
		btnFirst.setIcon(new ImageIcon(StudentView.class.getResource("/img/Button-6-next-iconT.png")));
		contentPane.add(btnFirst);

		JButton btnBack = new JButton();
		btnBack.setBounds(166, 305, 57, 33);
		btnBack.addActionListener(ctl);
		btnBack.setActionCommand("B");
		btnBack.setIcon(new ImageIcon(StudentView.class.getResource("/img/Button-5-forward-iconT.png")));
		contentPane.add(btnBack);

		JButton btnNext = new JButton();
		btnNext.setBounds(241, 305, 57, 33);
		btnNext.addActionListener(ctl);
		btnNext.setActionCommand("N");
		btnNext.setIcon(new ImageIcon(StudentView.class.getResource("/img/Button-5-forward-icon.png")));
		contentPane.add(btnNext);

		JButton btnLast = new JButton();
		btnLast.setBounds(326, 305, 57, 33);
		btnLast.addActionListener(ctl);
		btnLast.setActionCommand("L");
		btnLast.setIcon(new ImageIcon(StudentView.class.getResource("/img/Button-6-next-icon.png")));
		contentPane.add(btnLast);

		textArea = new JTextArea();

		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(82, 223, 301, 73);
		contentPane.add(scrollPane);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(ctl);
		btnReset.setIcon(new ImageIcon(StudentView.class.getResource("/img/Clear-icon.png")));
		btnReset.setBounds(294, 174, 89, 23);
		contentPane.add(btnReset);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(ctl);
		btnFind.setIcon(new ImageIcon(StudentView.class.getResource("/img/Search-icon.png")));
		btnFind.setBounds(294, 198, 89, 23);
		contentPane.add(btnFind);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public boolean checkForm() {
		if (this.textField_MSV.getText().equals("")) {
			return false;
		} else {
			String maSV = this.textField_MSV.getText();
			if (!Data.isID(maSV)) {
				return false;
			}
			if (this.listStudentModel.kiemTraTonTai(maSV)) {
				return false;
			}

		}

		if (this.textField_HoTen.getText().equals("")) {
			return false;
		} else {
			String hoTen = this.textField_HoTen.getText();
			if (!Data.isHoTen(hoTen)) {
				return false;
			}
		}

		if (this.textField_Email.getText().equals("")) {
			return false;
		} else {
			String email = this.textField_Email.getText();
			if (!Data.isEmail(email)) {
				return false;
			}
		}

		if (this.textField_SDT.getText().equals("")) {
			return false;
		}

		if (this.textArea.getText().equals("")) {
			return false;
		}

		return true;
	}

	public void resetForm() {
		this.textField_MSV.setText("");
		this.textField_HoTen.setText("");
		this.textField_Email.setText("");
		this.textField_SDT.setText("");
		this.buttonGroup.clearSelection();
		this.textArea.setText("");
		this.textField_MSV.requestFocus();
	}
	
	public void findStudent() {
		try {
			int count = 0;
			String maSV = this.textField_MSV.getText();
			ArrayList<StudentModel> list = this.listStudentModel.getListStudents();
			for(int i =0; i < list.size(); i ++) {
				System.out.println(list.get(i).getMaSV());
				if(maSV.equals(list.get(i).getMaSV())) {
					this.displayForm(i);
					count++;
				}
			}
			if(count == 0) {
				JOptionPane.showMessageDialog(this, "Find fail");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public StudentModel getValueForm() {
		if (this.checkForm()) {
			String maSV = this.textField_MSV.getText();
			String hoTen = this.textField_HoTen.getText();
			String email = this.textField_Email.getText();
			String soDT = this.textField_SDT.getText();
			boolean gioiTinh = true;
			if (this.rdoNam.isSelected()) {
				gioiTinh = true;
			} else if (this.rdoNu.isSelected()) {
				gioiTinh = false;
			}
			String diaChi = this.textArea.getText();
			StudentModel st = new StudentModel(maSV, hoTen, email, soDT, gioiTinh, diaChi);
//			StudentDAO.getInstane().insert(st);
			return st;
		}
		return null;
	}

	public void insertTable() {
		StudentModel st = this.getValueForm();
		StudentDAO.getInstane().insert(st);
		this.insertListStudents();
	}

	public void deleteTable() {
		StudentModel st = this.getValueForm();
		StudentDAO.getInstane().delete(st);
		this.insertListStudents();
	}

	public void updateTable() {
		StudentModel st = this.getValueForm();
		StudentDAO.getInstane().update(st);
		this.insertListStudents();
	}

	public void insertListStudents() {
		this.listStudentModel.setListStudents(StudentDAO.getInstane().selectAll());
		ArrayList<StudentModel> listModel = this.listStudentModel.getListStudents();
		for (StudentModel studentModel : listModel) {
			System.out.println(studentModel);
		}
	}

	public void displayForm(int index) {
		StudentModel st = this.listStudentModel.getListStudents().get(index);
		this.textField_MSV.setText(st.getMaSV());
		this.textField_HoTen.setText(st.getHoTen());
		this.textField_Email.setText(st.getEmail());
		this.textField_SDT.setText(st.getSoDT());
		if (st.isGioiTinh()) {
			this.rdoNam.setSelected(true);
		} else {
			this.rdoNu.setSelected(true);
		}
		this.textArea.setText(st.getDiaChi());
	}

	public void firstElement() {
		index = 0;
		this.displayForm(index);
	}

	public void lastElement() {
		index = this.listStudentModel.getListStudents().size() - 1;
		this.displayForm(index);
	}

	public void nextElement() {
		index++;
		if (index < this.listStudentModel.getListStudents().size()) {
			this.displayForm(index);
		} else if (index > this.listStudentModel.getListStudents().size()) {
			index = this.listStudentModel.getListStudents().size() - 1;
			this.displayForm(index);
		}
	}

	public void previousElement() {
		index--;
		if (index < 0) {
			index = 0;
			this.displayForm(index);
		} else {
			this.displayForm(index);
		}
	}
}
