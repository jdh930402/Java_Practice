package java_20190807;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ChatClientThread implements Runnable {

	private BufferedReader br;
	public ChatClientThread(BufferedReader br) {
		this.br = br;
	}

	@Override
	public void run() {
		String readLine;
		try {
			readLine = br.readLine();
			System.out.println(readLine);
			System.out.print("채팅을 입력하세요>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
