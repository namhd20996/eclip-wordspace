package test;

import java.sql.Connection;

import java.util.ArrayList;

import javax.swing.UIManager;

import dao.StudentDAO;
import database.JDBCUtil;
import model.StudentModel;
import view.StudentView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new StudentView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
