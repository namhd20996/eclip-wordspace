package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.SinhVienModel;
import model.XFile;

public class Main {
	public static void main(String[] args) {
//		ArrayList<SinhVienModel> ds = new ArrayList<>();
//		SinhVienModel sv = new SinhVienModel("Nam1", 5, "CNTT");
//		SinhVienModel sv1 = new SinhVienModel("Nam1", 5, "CNTT");
//		SinhVienModel sv2 = new SinhVienModel("Nam1", 5, "CNTT");
//		ds.add(sv1);
//		ds.add(sv2);
//		ds.add(sv);
//		XFile.writeObject("D:\\New folder\\text1.data", ds);

		ArrayList<SinhVienModel> list = (ArrayList<SinhVienModel>) XFile.readObject("D:\\\\New folder\\\\text1.data");
		for (SinhVienModel sinhVienModel : list) {
			System.out.println(sinhVienModel);
		}
	}
}
