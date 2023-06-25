package test;

import java.util.ArrayList;

import dao.ProductDao;
import labs_01.Product;

public class ProductTest {
	public static void main(String[] args) {
//		Product p = new Product("B", 1000);
//		ArrayList<Product> list = ProductDao.getInstane().selectAll();
//		for (Product product : list) {
//			product.xuat();
//		}
		ArrayList<Product> list = ProductDao.getInstane().selectByCondition("product_Price >50");
		for (Product product : list) {
			product.xuat();
		}
		
	}
}
