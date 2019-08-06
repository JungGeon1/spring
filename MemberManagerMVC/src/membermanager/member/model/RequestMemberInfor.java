package membermanager.member.model;

public class RequestMemberInfor {
	
	private String uId;
	private String uPW;
	private String uName;
	private String uPhoto;
	
	public RequestMemberInfor() {}
	
	public RequestMemberInfor(String uId, String uPW, String uName, String uPhoto) {
		this.uId = uId;
		this.uPW = uPW;
		this.uName = uName;
		this.uPhoto = uPhoto;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPW() {
		return uPW;
	}

	public void setuPW(String uPW) {
		this.uPW = uPW;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	@Override
	public String toString() {
		return "RequestMemberInfor [uId=" + uId + ", uPW=" + uPW + ", uName=" + uName + ", uPhoto=" + uPhoto + "]";
	}
	
	public MemberInfo toMemberInfo() {
		return new MemberInfo(uId, uPW, uName, uPhoto);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
