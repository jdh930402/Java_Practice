package java_20190807;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
	private String id;
	private String ip;
	private int port;
	private Socket socket;
	private BufferedWriter bw = null;
	private BufferedReader br = null;

	public ChatClient(String id, String ip, int port) {
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

	public String console(String str) {
		System.out.print(str);
		br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		try {
			readLine = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readLine;
	}

	public void run() {

		while (true) {
			try {
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				bw.write(console(id + ":" ));
				bw.newLine();
				bw.flush();

				String readLine = br.readLine();
				System.out.println(readLine);

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
	}

	public static void main(String[] args) {
		new ChatClient("id","192.168.0.24", 3000);
	}

}
