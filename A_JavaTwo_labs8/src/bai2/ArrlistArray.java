package bai2;

import java.util.ArrayList;

public class ArrlistArray {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(i);
		}

		for (int i = 0; i < 10; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
}
