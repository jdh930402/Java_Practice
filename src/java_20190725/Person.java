package java_20190725;

import java.util.ArrayList;

public class Person {
	private String player;

	public Person(String player) {

		this.player = player;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "player=" + player;
	}
}
