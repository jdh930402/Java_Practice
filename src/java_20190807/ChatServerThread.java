package java_20190807;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServerThread implements Runnable {
	Socket socket;
	ArrayList<ChatServerThread> threadList;

	public ChatServerThread(Socket socket, ArrayList<ChatServerThread> threadList) {
		this.socket = socket;
		this.threadList = threadList;
	}

	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			boolean isStop = false;

			while (!isStop) {
				String readLine = br.readLine();
				System.out.println(readLine);
				if ((readLine.substring((readLine.indexOf(":")) + 1).equals("exit"))) {
					isStop = true;
				} else {
					bw.write(readLine);
					bw.newLine();
					bw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
