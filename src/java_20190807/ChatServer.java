package java_20190807;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	ServerSocket server = null;
	ArrayList<ChatServerThread> threadList = new ArrayList<ChatServerThread>();

	public ChatServer(int port) {
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		System.out.println("클라이언트의 접속을 대기중입니다.");
		while (true) {
			try {
				Socket socket = server.accept();
				String ip = socket.getInetAddress().getHostAddress();
				System.out.println("클라이언트가 접속하였습니다.[" + ip + "]");

				ChatServerThread serverThread = new ChatServerThread(socket, threadList);
				threadList.add(serverThread);
				Thread thread = new Thread(serverThread);
				thread.start();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new ChatServer(3000).run();
	}

}
