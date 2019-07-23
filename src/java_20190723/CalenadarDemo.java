package java_20190723;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalenadarDemo {

	public static String console() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		return bf.readLine();
	}

	public static void main(String[] args) throws IOException {
		Calendar cal = new Calendar();
		int year, month, day;
		while (true) {
			System.out.print("날짜를 입력하세요>");
			String readLine;
			try {
				readLine = console();
				String[] data = readLine.split("-");
				switch(data.length) {
				case 1:
					year = Integer.parseInt(data[0]);
					cal.print(year);
					break;
				case 2:
					year = Integer.parseInt(data[0]);
					month = Integer.parseInt(data[1]);
					cal.print(year, month);
					break;
				case 3: 
					year = Integer.parseInt(data[0]);
					month = Integer.parseInt(data[1]);
					day = Integer.parseInt(data[2]);
					cal.print(year, month, day);
					break;
					default :
						System.out.println("재입력하세요.");
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				System.out.println("재입력하세요.");
			}
		}
	}
}
