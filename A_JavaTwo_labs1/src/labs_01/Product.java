package labs_01;

import java.util.Scanner;

public class Product {
	private String name;
	private double price;

	public Product() {

	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getImportTax() {
		double vat = 0;
		vat = this.getPrice() * 0.1;
		return vat;
	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập vào tên sản phẩm");
		this.name = sc.nextLine();
		System.out.println("Nhập vào giá sản phẩm.");
		this.price = sc.nextDouble();
	}

	public void xuat() {
		System.out.printf("Tên sản phẩm: %s - Giá sản phẩm: %s - Thuế: %.2f \n", this.getName(), this.price,
				this.getImportTax());
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}

}
