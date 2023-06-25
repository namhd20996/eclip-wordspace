

import java.util.StringTokenizer;

public class StringTokenizer_Study {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("techvidvan, article, on, StringTokenizer", ",", true);
//		StringTokenizer st = new StringTokenizer("techvidvan, article, on, StringTokenizer", ",", false);
//		StringTokenizer st = new StringTokenizer("techvidvan, article, on, StringTokenizer", ",");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
