package java_20190807;

public class MemberFindDto {
	private int seq;
	private String email;
	private String code;
	private String sdate;
	private String edate;

	// 생성자 만들기
	public MemberFindDto(int seq, String email, String code, String sdate, String edate) {
		this.seq = seq;
		this.email = email;
		this.code = code;
		this.sdate = sdate;
		this.edate = edate;
	}

	// seq에 대한 setter만들기
	// seq에 대한 getter만들기
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

}
