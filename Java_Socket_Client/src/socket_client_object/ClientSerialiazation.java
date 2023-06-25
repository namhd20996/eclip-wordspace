package socket_client_object;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

import model.Message;
import socket_client.Client;

public class ClientSerialiazation {
	public void connect() {
		try {
			// Tạo Socket connect với Server
			Socket socket = new Socket("localhost", 1996);
			// Gửi yêu cầu đến server
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			Message m = new Message("Object Client", "Body");
			oos.writeObject(m);
			// Nhận kết quả từ Server trả về
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			Message mO = (Message) ois.readObject();
			if(mO != null) {
				System.out.println("Đối tượng trả về: "+mO.getTitle() +" "+mO.getBody());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		ClientSerialiazation c = new ClientSerialiazation();
		c.connect();
	}
}
