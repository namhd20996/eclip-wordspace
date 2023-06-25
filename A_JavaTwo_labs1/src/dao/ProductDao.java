package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import labs_01.Product;

public class ProductDao implements DAOInterface<Product>{

	public static ProductDao getInstane() {
		return new ProductDao();
	}
	
	@Override
	public int insert(Product t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "INSERT INTO sanpham (`product_Name`, `product_Price`)"
					+ "VALUES " + "(?, ?)";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getName());
			pst.setDouble(2, t.getPrice());
			result = pst.executeUpdate();
			System.out.println("Row"+ result);
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int update(Product t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "UPDATE sanpham\r\n"
					+ "SET product_Price = product_Price + 10\r\n"
					+ "WHERE product_Name = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getName());
			result = pst.executeUpdate();
			System.out.println(sql);
			System.out.println(result);
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int delete(Product t) {
		int result = 0;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "DELETE FROM sanpham WHERE product_Name = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getName());
			result = pst.executeUpdate();
			System.out.println("Row "+ result);
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sanpham";
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String name = rs.getString("product_Name");
				double price = rs.getDouble("product_Price");
				Product p = new Product(name, price);
				list.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Product selectByID(Product t) {
		Product result = null;
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sanpham WHERE product_Name = ?";
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, t.getName());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("product_Name");
				double price = rs.getDouble("product_Price");
				result = new Product(name, price);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public ArrayList<Product> selectByCondition(String condition) {
		ArrayList<Product> ds = new ArrayList<Product>();
		try {
			Connection connection = JDBCUtil.getConnection();
			String sql = "SELECT * FROM sanpham WHERE " + condition;
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				String name = rs.getString("product_Name");
				double price = rs.getDouble("product_Price");
				Product p = new Product(name, price);
				ds.add(p);
			}
			JDBCUtil.closeConnection(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
}
