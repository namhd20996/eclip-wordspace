package labs_them;

import java.util.Scanner;

public class ExceptionLab {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int[] m = { 0, 2, 3 };
			int i, k;
			System.out.print("Nhập i ? ");
			i = Integer.parseInt(sc.nextLine());
			k = m[i];
			int x;
			x = -1 / (2 * k);
			System.out.println("x = " + x);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi định dạng số");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Lỗi index arr");
		}

	}
}
