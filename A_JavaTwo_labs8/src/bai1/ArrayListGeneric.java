package bai1;

import java.util.ArrayList;

public class ArrayListGeneric {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(1);
		list.add(1.0);
		list.add(true);
		list.add("Hello!");
		
		System.out.println(list.toString());
	}
}
