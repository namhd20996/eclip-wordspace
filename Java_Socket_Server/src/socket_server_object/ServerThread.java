package socket_server_object;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Message;

public class ServerThread extends Thread {
	private Socket socket;
	

	public ServerThread(Socket socket) {
		this.socket = socket;
	}


	@Override
	public void run() {
		try {
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
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
