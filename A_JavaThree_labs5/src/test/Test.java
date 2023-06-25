package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.UIManager;

import dao.StudentDAO;
import database.JDBCUtil;
import model.StudentModel;
import view.StudentView;

public class Test {
	public static void main(String[] args) {
//		StudentModel st = new StudentModel("Ps03", "Duy Nama", "nam@gmail.com", "0968997434", true, "Bàu bàng");
//		StudentDAO.getInstane().insert(st);
//		StudentDAO.getInstane().update(st);
//		StudentDAO.getInstane().delete(st);
		
//		for(int i =0; i< 100; i++) {
//			StudentModel st = new StudentModel("Ps03"+i, "Duy Nama", "nam@gmail.com", "0968997434", true, "Bàu bàng");
//			StudentDAO.getInstane().insert(st);
//		}
		
//		ArrayList<StudentModel> list = StudentDAO.getInstane().selectAll();
//		for (StudentModel studentModel : list) {
//			System.out.println(studentModel);
//		}
//		StudentModel a = new StudentModel();
//		a.setMaSV("Ps03");
//		StudentModel st = StudentDAO.getInstane().selectByID(a);
//		System.out.println(a);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new StudentView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
