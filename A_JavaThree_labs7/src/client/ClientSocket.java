package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
	public void connect() {
		try {
			Scanner sc = new Scanner(System.in);
			Socket socket = new Socket("localhost", 8888);
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			while(true) {
				System.out.print("Nhập vào số thứ 1: ");
				outputStream.writeDouble(sc.nextDouble());
				System.out.print("Nhập vào số thứ 2: ");
				outputStream.writeDouble(sc.nextDouble());
				outputStream.flush();
				double sum = inputStream.readDouble();
				System.out.println("Tổng 2 số là: "+sum);
				System.out.println("Bạn muốn tiếp tục? Y/N");
				String chooser = sc.next();
				if(chooser.equalsIgnoreCase("N")) {
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		ClientSocket c = new ClientSocket();
		c.connect();
	}
}
