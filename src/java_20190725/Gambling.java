package java_20190725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Gambling {
	ArrayList<Person> list;

	public Gambling() {
		list = new ArrayList<Person>();
	}

	private String console(String msg) throws IOException {
		System.out.print(msg);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		return bf.readLine();
	}

	private void setPlayer(int playerNum) throws IOException {
		for (int i = 0; i < playerNum; i++) {
			String player = console("player의 이름을 입력하세요>");
			Person person = new Person(player);
			list.add(person);
		}
	}

	private ArrayList<Person> rndNumber() throws IOException {
		console("");
		for (int i = 0; i < list.size(); i++) {
			Random rnd = new Random();
			Person p = list.get(i);
			int rndNumber = rnd.nextInt(3) + 1;
			System.out.print(p.getPlayer() + "의 차례입니다. : " + rndNumber);
			System.out.println();
			p.setNumber1(rndNumber);
		}
		console("");
		for (int i = 0; i < list.size(); i++) {
			Random rnd = new Random();
			Person p = list.get(i);
			int rndNumber = rnd.nextInt(3) + 1;
			System.out.print(p.getPlayer() + "의 차례입니다. : " + rndNumber);
			System.out.println();
			p.setNumber2(rndNumber);
		}
		console("");
		for (int i = 0; i < list.size(); i++) {
			Random rnd = new Random();
			Person p = list.get(i);
			int rndNumber = rnd.nextInt(3) + 1;
			System.out.print(p.getPlayer() + "의 차례입니다. : " + rndNumber);
			System.out.println();
			p.setNumber3(rndNumber);
		}
		return list;
	}

	private void compareNumber(ArrayList<Person> list) {
		boolean isExisted = false;
		String playerName = null;
		for (Person person : list) {
			isExisted = false;
			if (person.getNumber1() == person.getNumber2() && person.getNumber2() == person.getNumber3()) {
				isExisted = true;
				playerName = person.getPlayer();
				break;
			}
		}
		if (isExisted) {
			System.out.println( playerName + "의 승리입니다.");
			Gambling gambling = new Gambling();
			try {
				gambling.menu();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
		System.out.println("승자가 없으므로 재시작합니다.");
		}
	}

	private void menu() throws IOException {
		int playerNum = Integer.parseInt(console("플레이어 수을 입력하세요>"));
		setPlayer(playerNum);
	}

	public static void main(String[] args) {
		Gambling gambling = new Gambling();
		try {
			gambling.menu();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			try {
				ArrayList<Person> p = gambling.rndNumber();
				gambling.compareNumber(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
