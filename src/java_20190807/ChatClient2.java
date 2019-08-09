package java_20190807;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient2 {
	private String id;
	private String ip;
	private int port;
	private Socket socket;
	private BufferedWriter bw = null;
	private BufferedReader br = null;
	private BufferedReader input = null;

	public ChatClient2(String id, String ip, int port) {
		this.id = id;
		this.ip = ip;
		this.port = port;

		try {
			socket = new Socket(ip, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {

		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			input = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("채팅을 입력하세요>");

			while (true) {
				String keybord = input.readLine();
				bw.write("[" + id + "]:" + keybord);
				bw.newLine();
				bw.flush();
				
				ChatClientThread cct= new ChatClientThread(br);
				Thread thread = new Thread(cct);
				thread.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("서버가 닫혀있습니다.");
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ChatClient2("바가지", "192.168.0.24", 3000).run();
	}

}
