package model;

import java.util.ArrayList;

public class ListBookModel {
	private ArrayList<BookModel> listBooks;
	private String index;

	public ListBookModel() {
		this.listBooks = new ArrayList<BookModel>();
		this.index = "";
	}

	public ListBookModel(ArrayList<BookModel> listBooks) {
		this.listBooks = listBooks;
	}

	public ArrayList<BookModel> getListBooks() {
		return listBooks;
	}

	public void setListBooks(ArrayList<BookModel> listBooks) {
		this.listBooks = listBooks;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public void insert(BookModel b) {
		this.listBooks.add(b);
	}

	public void delete(BookModel b) {
		this.listBooks.remove(b);
	}

	public void update(int index, BookModel b) {
		this.listBooks.set(index, b);
	}

	public boolean checkExists(BookModel b) {
		for (BookModel bookModel : listBooks) {
			if (b.getId().equals(bookModel.getId())) {
				return true;
			}
		}
		return false;
	}

}
