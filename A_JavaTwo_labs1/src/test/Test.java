package test;

import java.util.Scanner;

import labs_01.ListProduct;

public class Test {
	public static void main(String[] args) {
		ListProduct p = new ListProduct();
		Scanner sc = new Scanner(System.in);
		String flag;
		int luaChon = 0;
		do {
			System.out.println("1. Nhập\n" + "2. Xuất\n" + "0. Out");
			luaChon = sc.nextInt();
			switch (luaChon) {
			case 0:
				System.out.println("Nhập Y/N để out.");
				flag = sc.next();
				if (flag.equalsIgnoreCase("Y"))
					System.exit(0);
				break;
			case 1:
				p.insert();
				break;
			case 2:
				p.output();
				break;
			}
		} while (true);
	}
}
