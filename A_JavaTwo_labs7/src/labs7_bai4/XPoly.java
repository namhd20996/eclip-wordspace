package labs7_bai4;

public class XPoly {
	@Deprecated
	public static boolean isCardNumber(String number) {
		int n = Integer.valueOf(number);
		int total = 0;
		while(n>0) {
			int a = n %10; // 12345 %10 dư 5 lấy 5 + vào a
			total +=a;
			n = n / 10; // 12345 / 10 nó sẽ lấy phần nguyên còn lại là 1234
		}
		return total % 2 ==0;
	}
}
