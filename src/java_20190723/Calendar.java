package java_20190723;

public class Calendar {
	private String[] date = { "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" };
	private int totalCount = 0;
	private int dayOfWeek = 0;

	//윤년을 판단하고 한달에 몇일인지 판단하는 메서드
	private int getLastDay(int year, int month) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		boolean isLeafYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		if (isLeafYear) {
			monthArray[1] = 29;
		}
		return monthArray[month - 1];
	}

	//총 일수를 구하는 메서드
	private int getCount(int year, int month, int day) {
		int preYear = year - 1;
		int preMonth = month - 1;
		getLastDay(year, month);
		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		// 2019년도 11월까지 합 구하기
		for (int i = 0; i < preMonth; i++) {
			totalCount += getLastDay(year, i + 1);
		}

		totalCount += day;
		return totalCount;
	}

	//요일을 판단하는 메서드
	public int dayOfWeek(int totalCount) {
		return totalCount % 7;
	}
	
	public void print(int year, int month, int day) {
		totalCount = getCount(year, month, day);
		dayOfWeek = dayOfWeek(totalCount);
		System.out.printf("%d년 %d월 %d일은 %s입니다.\n", year, month, day, date[dayOfWeek]);
	}


	public void print(int year, int month) {
		totalCount = getCount(year, month, 1);
		dayOfWeek = dayOfWeek(totalCount);
		for (int i = 0; i < date.length; i++) {
			System.out.print(date[i] + "\t");
		}
		System.out.println();
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print("\t");
		}
		for (int i = 0; i < getLastDay(year, month); i++) {
			System.out.print((i + 1) + "\t");
			if (dayOfWeek % 7 == 6) {
				System.out.println();
			}
			dayOfWeek++;
		}
		System.out.println();
	}

	public void print(int year) {
		for (int i = 0; i < 12; i++) {
			print(year, i + 1);
		}
		System.out.println();
	}
}