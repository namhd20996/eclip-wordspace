package labs_them;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TaikhoanNganhang tk = new TaikhoanNganhang();
		tk.nhapTaiKhoan(sc);
		tk.guiTien(sc);
		tk.rutTien(sc);
		tk.xuatTaiKhoan();
	}
}
