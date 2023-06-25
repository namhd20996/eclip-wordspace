package socket_server_object;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import model.Message;
import socket_server.Server;

public class ServerSerialiazationReview {
	public void serve() {
		try {
			// Tạo Port cho client connect
			ServerSocket server = new ServerSocket(1996);
			int count = 0;
			while (true) {
				System.out.println("Client: " + count++);
				// Lấy socket từ client
				Socket socket = server.accept();
				// Nhận dữ liệu từ client
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Message m = (Message) ois.readObject();
				// Xử lý kết quả trả về cho client
				if (m != null) {
					System.out.println("Đối tượng từ client gửi lên: " + m.getTitle() + " " + m.getBody());
					// Gửi trả kết quả lại cho client
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					Message mO = new Message("Object Server", "Body");
					oos.writeObject(mO);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		ServerSerialiazationReview server = new ServerSerialiazationReview();
		server.serve();
	}
}
