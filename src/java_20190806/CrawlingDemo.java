package java_20190806;

public class CrawlingDemo {
	public static void main(String[] args) {
		String year = "2011";
		
		Crawling crawling = new Crawling();
		System.out.println(crawling.getKleagueRank(year, "kleague_"+year));
	}
}
