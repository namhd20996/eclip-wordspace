package labs_01;

import java.util.ArrayList;
import java.util.Scanner;

public class ListProduct {
	private ArrayList<Product> ds;

	public ListProduct() {
		this.ds = new ArrayList<Product>();
	}

	public ListProduct(ArrayList<Product> ds) {
		this.ds = ds;
	}

	public ArrayList<Product> getDs() {
		return ds;
	}

	public void setDs(ArrayList<Product> ds) {
		this.ds = ds;
	}

	public void insert() {
		Scanner sc = new Scanner(System.in);
		String flag;
		int luaChon;
		System.out.println("Nhập vào loại Sp có thuế hay không?" + "1. Không thuế \n" + "2. Có thuế.");
		luaChon = sc.nextInt();
		if (luaChon == 1) {
			do {
				Product pd = new NoTaxProduct();
				pd.nhap();
				this.ds.add(pd);
				System.out.println("Nhập vào Y/N để tiếp tục: ");
				flag = sc.next();
				if (!flag.equalsIgnoreCase("Y")) {
					break;
				}
			} while (true);
		} else if(luaChon == 2){
			do {
				Product pd = new Product();
				pd.nhap();
				this.ds.add(pd);
				System.out.println("Nhập vào Y/N để tiếp tục: ");
				flag = sc.next();
				if (!flag.equalsIgnoreCase("Y")) {
					break;
				}
			} while (true);
		}
	}

	public void output() {
		for (Product product : ds) {
			product.xuat();
		}
	}
}
