package java_20190723;

public class Calendar {

	
	private boolean isLeafYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	private int getLastDay(int year, int month) {
		int[] monthArray = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (isLeafYear(year)) {
			monthArray[1] = 29;
		}
		return monthArray[month - 1];
	}

	private int getCount(int year, int month, int day) {
		int preYear = year - 1;
		int preMonth = month - 1;
		int totalCount = 0;
		getLastDay(year, month);
		totalCount = preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);

		// 2019년도 11월까지 합 구하기
		for (int i = 0; i < preMonth; i++) {
			totalCount += getLastDay(year,i+1);
		}

		totalCount += day;
		return totalCount;
	}

	public void print(int year, int month, int day) {
		String[] date = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"}; 
		int totalCount = getCount(year, month, day);
		int dayOfWeek = totalCount % 7;
		System.out.printf("%d년 %d월 %d일은 %s입니다.\n", year, month, day, date[dayOfWeek]);
	}

	public void print(int year, int month) {
		int totalCount = getCount(year,month,1);
		int dayOfWeek = totalCount % 7;
		String[] date = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"}; 
		for(int i=0 ; i<date.length ; i++) {
			System.out.print(date[i]+"\t");
		}
		System.out.println();
		for(int i=0 ; i < dayOfWeek ; i++) {
			System.out.print("\t");
		}
		for(int i=0 ; i< getLastDay(year,month); i++) {
			System.out.print( (i+1)+ "\t");
			if(dayOfWeek%7 == 6) {
				System.out.println();
			}
			dayOfWeek++;
		}
		System.out.println();
	}

	public void print(int year) {
		for(int i=0 ; i<12; i++) {
		print(year,i+1);
		}
		System.out.println();
	}
}
