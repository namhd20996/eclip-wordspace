package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import model.BookModel;

public class BookDao implements DAOInterface<BookModel> {

	public static BookDao getInstance() {
		return new BookDao();
	}

	@Override
	public int insert(BookModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "insert into books (id, title, price) values \n" + "(?, ?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getId());
			pst.setString(2, t.getTitle());
			pst.setDouble(3, t.getPrice());
			result = pst.executeUpdate();
			System.out.println("Đã nhập " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(BookModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "update books \n" + "set title = ?, price = ?\n" + "where id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getTitle());
			pst.setDouble(2, t.getPrice());
			pst.setString(3, t.getId());
			result = pst.executeUpdate();
			System.out.println("Đã cập nhập " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(BookModel t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "delete from books where id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getId());
			result = pst.executeUpdate();
			System.out.println("Đã xóa " + result + " dòng");
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<BookModel> selectAll() {
		ArrayList<BookModel> list = new ArrayList<BookModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from books";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				BookModel b = new BookModel(id, title, price);
				list.add(b);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public BookModel selectByID(BookModel t) {
		BookModel b = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from books where id = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getId());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				b = new BookModel(id, title, price);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return b;
	}

	@Override
	public ArrayList<BookModel> selectByCondition(String condition) {
		ArrayList<BookModel> list = new ArrayList<BookModel>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "select * from books where " + condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String title = rs.getString("title");
				double price = rs.getDouble("price");
				BookModel b = new BookModel(id, title, price);
				list.add(b);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

}
