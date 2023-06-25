package model;

import java.util.ArrayList;

public class QLBookModel {
	private ArrayList<BookModel> list;
	private String tenFile;

	public QLBookModel() {
		this.list = new ArrayList<>();
		this.tenFile = "";
	}

	public QLBookModel(ArrayList<BookModel> list) {
		super();
		this.list = list;
	}

	public ArrayList<BookModel> getList() {
		return list;
	}

	public void setList(ArrayList<BookModel> list) {
		this.list = list;
	}

	public void insert(BookModel b) {
		this.list.add(b);
	}

	public void delete(BookModel b) {
		this.list.remove(b);
	}

	public void update(int i, BookModel b) {
		this.list.set(i, b);
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}

	public boolean kiemTraTonTai(BookModel b) {
		for (BookModel bookModel : list) {
			if (bookModel.getMaSach().equals(b.getMaSach())) {
				return true;
			}
		}
		return false;
	}

}
