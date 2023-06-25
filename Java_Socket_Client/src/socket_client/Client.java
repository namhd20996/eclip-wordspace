package socket_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	public void connect() {
		try {
			// Kết nối tới Server với Port 1996
			Socket socket = new Socket("localhost", 1996);
			System.out.println("Client...");
			// sending
			PrintStream ps = new PrintStream(socket.getOutputStream());
			ps.println("Xin Chào!");

			// Đợi server trả lời
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String respone = br.readLine();
			if (respone != null) {
				System.out.println("Trả lời của server: " + respone);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		Client c = new Client();
		c.connect();
	}
}
