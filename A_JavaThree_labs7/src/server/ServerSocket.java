package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ServerSocket {
	public void serve() {
		try {
			java.net.ServerSocket server = new java.net.ServerSocket(8888);
			Socket socket = server.accept();
			DataInputStream inputStream = new DataInputStream(socket.getInputStream());
			DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
			while (true) {
				double numberOne = inputStream.readDouble();
				double numberTwo = inputStream.readDouble();
				System.out.println("2 số nhận được từ client: "+numberOne +" "+ numberTwo);
				double sum = numberOne + numberTwo;
				outputStream.writeDouble(sum);
				outputStream.flush();
				System.out.println("Tổng là: "+sum);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		ServerSocket s = new ServerSocket();
		s.serve();
	}
}
