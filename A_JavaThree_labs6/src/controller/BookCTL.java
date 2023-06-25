package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.BookView;

public class BookCTL implements ActionListener {
	private BookView bookView;

	public BookCTL(BookView bookView) {
		this.bookView = bookView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(this.bookView, src);
		if(src.equals("Delete")) {
			this.bookView.deleteBook();
		}else if(src.equals("Search")) {
			this.bookView.clickSearch();
		}else if(src.equals("Exit")) {
			this.bookView.exitForm();
		}
	}

}
