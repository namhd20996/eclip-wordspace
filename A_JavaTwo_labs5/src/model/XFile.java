package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class XFile {
	public static byte[] read(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			// Lấy số lượng còn lại có thể đọc từ luồng đầu vào
			int n = fis.available();
			byte[] data = new byte[n];
			fis.read(data);
			fis.close();
			return data;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void write(String path, byte[] data) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Object readObject(String path) {
		try {
			File file = new File(path);
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			Object object = ois.readObject();
			ois.close();
			return object;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void writeObject(String path, Object object) {
		try {
			File file = new File(path);
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(object);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
