package socket_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void serve() {
		try {
			System.out.println("Server đang chạy...");
			// Tạo port cho client kết nối
			ServerSocket server = new ServerSocket(1996);
			// Socket mà client connect tới server sẽ được lưu
			Socket socket = server.accept();

			// Nhận dữ liệu từ client
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String request = br.readLine();
			if (request != null) {
				System.out.println("Yêu cầu từ client: " + request);
				// Xử lí: select database, tính toán gì đó..
				// Trả lời cho client đã kết nối thành công hay chưa

				PrintStream ps = new PrintStream(socket.getOutputStream());
				ps.println(request.toLowerCase() +"cc");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.serve();
	}
}
