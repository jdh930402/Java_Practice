package java_20190725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Gambling {
	ArrayList<Person> list;
	public Gambling() {
		list = new ArrayList<Person>();
	}
	
	public String console(String msg) throws IOException {
		System.out.print(msg);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		return bf.readLine();
	}

	public void setPlayer(int playerNum) throws IOException {
		for (int i = 0; i < playerNum; i++) {
			String player = console("player의 이름을 입력하세요>");
			Person person = new Person(player);
			list.add(person);
		}
		for(Person person : list) {
			System.out.println(person);
		}
	}

	public void menu() throws IOException {
		int playerNum = Integer.parseInt(console("플레이어 수을 입력하세요>"));
		setPlayer(playerNum);
	}

	public static void main(String[] args) {
		Gambling gambling = new Gambling();
		try {
			gambling.menu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
