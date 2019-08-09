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
	BufferedReader br;
	BufferedWriter bw;

	public ChatServerThread(Socket socket, ArrayList<ChatServerThread> threadList) {
		this.socket = socket;
		this.threadList = threadList;
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			boolean isStop = false;

			while (!isStop) {
				String readLine = br.readLine();
				System.out.println(readLine);
				if ((readLine.substring((readLine.indexOf(":")) + 1).equals("exit"))) {
					isStop = true;
					threadList.remove(this);
				} else {
					message(readLine);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			threadList.remove(this);
		} finally {
			try {
				if (br != null)
					br.close();
				if (bw != null)
					bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void message(String msg) {
		for (ChatServerThread cst : threadList) {
			cst.sendMessage(msg);
		}
	}

	private void sendMessage(String msg) {
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
