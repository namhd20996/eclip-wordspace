package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.SearchView;

public class SearchController implements ActionListener{
	private SearchView searchView;

	public SearchController(SearchView searchView) {
		this.searchView = searchView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Kết quả")) {
			this.searchView.search();
		}
	}
	
	
}
