package java_20190809;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Generator {

	public TreeSet<Integer> getGenerator() {
		TreeSet<Integer> generator = new TreeSet<Integer>();
		int totalCount = 0;

		for (int i = 1; i <= 4999; i++) {
			int sum = 0; // 자리수들의 합
			totalCount = 0; // 자기 자신과 자리수들의 합
			String str = String.valueOf(i);

			if (str.length() == 1) {
				for (int j = 0; j < str.length(); j++) {
					sum += Integer.parseInt(String.valueOf(str.charAt(j)));
				}
				totalCount = i + sum;
				generator.add(totalCount);
			}

			if (str.length() == 2) {
				for (int j = 0; j < str.length(); j++) {
					sum += Integer.parseInt(String.valueOf(str.charAt(j)));
				}
				totalCount = i + sum;
				generator.add(totalCount);
			}
			if (str.length() == 3) {
				for (int j = 0; j < str.length(); j++) {
					sum += Integer.parseInt(String.valueOf(str.charAt(j)));
				}
				totalCount = i + sum;
				generator.add(totalCount);
			}
			if (str.length() == 4) {
				for (int j = 0; j < str.length(); j++) {
					sum += Integer.parseInt(String.valueOf(str.charAt(j)));
				}
				totalCount = i + sum;
				generator.add(totalCount);
			}
		}
		return generator;
	}

	public static void main(String[] args) {

		Generator g = new Generator();
		Iterator iter = g.getGenerator().iterator();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		boolean isSuccess = false;
		int number = 0;

		while (iter.hasNext()) {
			int num = (int) iter.next();
			list1.add(num);
		}
		
		for(int i=0 ; i<list1.size() ; i++) {
			for(int j=1 ; j<5000 ; j++) {
				if(list1.get(i) != j) {
					number = j;
					isSuccess = true;
				}
			}			
			list2.add(number);
		}		
		System.out.println(list2);	
	}
}
