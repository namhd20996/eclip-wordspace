package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BookCTL;
import dao.BookDao;
import model.BookModel;
import model.ListBookModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;

public class BookView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private ListBookModel listBookModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					BookView frame = new BookView();
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
	public BookView() {
		this.listBookModel = new ListBookModel();
		BookCTL bookCTL = new BookCTL(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage(BookView.class.getResource("/img/color-catalog-icon.png")));
		this.setTitle("Book Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 23, 303, 71);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(20, 29, 48, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(54, 26, 239, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(bookCTL);
		btnSearch.setIcon(new ImageIcon(BookView.class.getResource("/img/Search-icon.png")));
		btnSearch.setBounds(311, 48, 89, 23);
		contentPane.add(btnSearch);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(bookCTL);
		btnExit.setIcon(new ImageIcon(BookView.class.getResource("/img/ModernXP-02-System-Power-icon.png")));
		btnExit.setBounds(396, 48, 89, 23);
		contentPane.add(btnExit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(bookCTL);
		btnDelete.setIcon(new ImageIcon(BookView.class.getResource("/img/File-Delete-icon.png")));
		btnDelete.setBounds(396, 267, 89, 23);
		contentPane.add(btnDelete);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Title", "Price" }));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 127, 475, 128);
		contentPane.add(scrollPane);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void loadDataListBook() {
		if (this.listBookModel.getIndex().equals("")) {
			this.listBookModel.setListBooks(BookDao.getInstance().selectAll());
			ArrayList<BookModel> list = this.listBookModel.getListBooks();
			for (BookModel bookModel : list) {
				this.insertTable(bookModel);
			}
			this.listBookModel.setIndex("Search");
		} else {
			this.loadMoreData();
//			this.listBookModel.setIndex("");
		}
	}

	public void clickSearch() {
		if (this.textField.getText().equals("")) {
			this.loadDataListBook();
		} else {
			this.findBook();
		}
	}

	public void loadMoreData() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int rowCount = model_table.getRowCount();
			if (rowCount == 0) {
				break;
			} else {
				model_table.removeRow(0);
			}
		}
		for (BookModel b : this.listBookModel.getListBooks()) {
			this.insertTable(b);
		}
	}

	public void findBook() {
		this.loadMoreData();
		int count = 0;
		String titleFind = this.textField.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int rowCount = model_table.getRowCount();
		Set<String> listDelete = new TreeSet<String>();
		if (titleFind.length() > 0) {
			for (int i = 0; i < rowCount; i++) {
				String titleTable = model_table.getValueAt(i, 1) + "";
				if (!titleTable.equals(titleFind)) {
					listDelete.add(titleTable);
				}
			}
		}

		for (String idCanXoa : listDelete) {
			rowCount = model_table.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				String idTrongTable = model_table.getValueAt(i, 1) + "";
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i);
						count++;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					break;
				}
			}
		}

	}

	public void insertTable(BookModel b) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { b.getId(), b.getTitle(), b.getPrice() });
	}

	public BookModel getBookOnClick() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		String id = model_table.getValueAt(i_row, 0) + "";
		String title = model_table.getValueAt(i_row, 1) + "";
		double price = Double.valueOf(model_table.getValueAt(i_row, 2) + "");
		BookModel b = new BookModel(id, title, price);
		return b;
	}

	public void deleteBook() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		BookModel b = this.getBookOnClick();
		int select = JOptionPane.showConfirmDialog(this, "Do you want to delete", "Delete", JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			this.listBookModel.delete(b);
			model_table.removeRow(i_row);
			BookDao.getInstance().delete(b);
		}
	}

	public void exitForm() {
		int select = JOptionPane.showConfirmDialog(this, "Do you want to Exit?", "Exit", JOptionPane.YES_NO_OPTION);
		if (select == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
