package test;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.UIManager;

import dao.BookDao;
import database.JDBCUtil;
import model.BookModel;
import view.BookView;

public class BookMain {
	public static void main(String[] args) {
//		for(int i =0; i<100; i++) {
//			BookModel b = new BookModel(""+i, "Teo"+i, 10);
//			BookDao.getInstance().insert(b);
//		}
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new BookView();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
