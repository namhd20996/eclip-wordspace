package test;

import java.io.FileOutputStream;

import model.XFile;

public class Test {
	public static void main(String[] args) {
		byte[] data = XFile.read("D:\\file1.txt");
		
//		byte[] a = {1,2,3,4,5};
		
		XFile.write("D:\\file4.txt", data);
		
		
	}
}
