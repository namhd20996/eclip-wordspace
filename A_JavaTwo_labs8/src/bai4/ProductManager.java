package bai4;

import bai3.Product;

public class ProductManager {
	public static void main(String[] args) {
		Product p1 = new Product("iPhone9", 1000.0);
		Product p2 = new Product("Samsung Start", 3000.0);
		ProductDao dao = new ProductDao();
		dao.add(p1);
		dao.add(p2);
		dao.load("D:\\Test\\t.data");
		
		Product p = dao.find("iPhone9");
		System.out.println(">Name: " + p.getName());
		System.out.println(">Price: " + p.getPrice());

	}
}
