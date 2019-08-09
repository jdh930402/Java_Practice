package java_20190807;

public class MemberFindDtoDemo {
	public static void main(String[] args) {
		// 1. 객체를 생성한다.
		MemberFindDto mfd1 = new MemberFindDto(1, "asdsad@naver.com", "1234", "2019-08-08", "2019-08-09");
		MemberFindDto mfd2 = new MemberFindDto(2, "qwewq@naver.com", "5678", "2019-08-07", "2019-08-09");

		// 2. 객체의 내용을 출력해본다.
		System.out.println("seq : " + mfd1.getSeq() + "  email : " + mfd1.getEmail() +"  code : "+ mfd1.getCode() + "  sdate : " + mfd1.getSdate() + "  edate : "+ mfd1.getEdate());
		System.out.println("seq : " + mfd2.getSeq() + "  email : " + mfd2.getEmail() +"  code : "+ mfd2.getCode() + "  sdate : " + mfd2.getSdate() + "  edate : "+ mfd2.getEdate());

		// 3. 객체의 내용을 수정해본다.
		mfd1.setSeq(3);
		// 4. 수정된 객체 내용을 출력해본다.
		System.out.println();
		System.out.println("seq : " + mfd1.getSeq() + "  email : " + mfd1.getEmail() +"  code : "+ mfd1.getCode() + "  sdate : " + mfd1.getSdate() + "  edate : "+ mfd1.getEdate());
		System.out.println("seq : " + mfd2.getSeq() + "  email : " + mfd2.getEmail() +"  code : "+ mfd2.getCode() + "  sdate : " + mfd2.getSdate() + "  edate : "+ mfd2.getEdate());
	}
}
