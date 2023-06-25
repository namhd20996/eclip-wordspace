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

public class ServerSerialiazation {
	public void serve() {
		try {
			// Tạo Port cho client connect
			ServerSocket server = new ServerSocket(1996);
			int count = 0;
			while (true) {
				System.out.println("Client: " + count++);
				// Lấy socket từ client
				Socket socket = server.accept();
				new ServerThread(socket).start();
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		ServerSerialiazation server = new ServerSerialiazation();
		server.serve();
	}
}
