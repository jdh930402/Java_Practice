package java_20190806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CrawlingDemo {

	public static String console(String str) {
		System.out.print(str);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String readLine = null;
		try {
			readLine = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readLine;
	}

	public static void main(String[] args) {
		while (true) {
			String year = console("년도를 입력하세요>");
			Crawling crawling = new Crawling();
			System.out.println(crawling.getKleagueRank(year, "kleague_" + year));
		}
	}
}
