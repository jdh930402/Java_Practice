
package java_20190725;

import java.util.ArrayList;

public class Person {
	private String player;
	private int number1;
	private int number2;
	private int number3;

	public Person(String player) {

		this.player = player;
	}

	public String getPlayer() {
		return player;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	public int getNumber3() {
		return number3;
	}

	public void setNumber3(int number3) {
		this.number3 = number3;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "player=" + player +"의 숫자는 " + number1 + number2 + number3 + "입니다.";
	}
}
