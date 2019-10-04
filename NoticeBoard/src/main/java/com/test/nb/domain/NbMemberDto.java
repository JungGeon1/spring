package com.test.nb.domain;

import java.util.Random;

public class NbMemberDto {
	//회원의 등록번호
	private int nbm_idx;
	//회원이름
	private String nbm_name;
	//회원 이메일
	private String nbm_id;
	//회원비밀번호
	private String nbm_pw; 
	//회원 주소
	private String nbm_address;
	//가입날짜
	private String nbm_date;
	//인증을 위한 인증코드
	private String nbm_code;
	//메일 인증여부 N Y
	private String nbm_verify;
	//우편번호
	private String postcode;
	//주소
	private String address;
	//상세주소
	private String detailAddress;
	
	public NbMemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNbm_idx() {
		return nbm_idx;
	}
	public void setNbm_idx(int nbm_idx) {
		this.nbm_idx = nbm_idx;
	}
	public String getNbm_name() {
		return nbm_name;
	}
	public void setNbm_name(String nbm_name) {
		this.nbm_name = nbm_name;
	}
	public String getNbm_id() {
		return nbm_id;
	}
	public void setNbm_id(String nbm_id) {
		this.nbm_id = nbm_id;
	}
	public String getNbm_pw() {
		return nbm_pw;
	}
	public void setNbm_pw(String nbm_pw) {
		this.nbm_pw = nbm_pw;
	}
	
	public String getNbm_address() {
		return nbm_address;
	}
	public void setNbm_address() {
		this.nbm_address =this.getAddress()+" "+this.getDetailAddress();
		RandomString();
	}
	public String getNbm_date() {
		return nbm_date;
	}
	public void setNbm_date(String nbm_date) {
		this.nbm_date = nbm_date;
	}
	public String getNbm_code() {
		return nbm_code;
	}
	public void setNbm_code(String nbm_code) {
		this.nbm_code = nbm_code;
	}
	public String getNbm_verify() {
		return nbm_verify;
	}
	public void setNbm_verify(String nbm_verify) {
		this.nbm_verify = nbm_verify;
	}
	
	
	
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	@Override
	public String toString() {
		return "NbMemberDto [nbm_idx=" + nbm_idx + ", nbm_name=" + nbm_name + ", nbm_id=" + nbm_id + ", nbm_pw="
				+ nbm_pw + ", nbm_address=" + nbm_address + ", nbm_date=" + nbm_date + ", nbm_code=" + nbm_code
				+ ", nbm_verify=" + nbm_verify + ", postcode=" + postcode + ", address=" + address + ", detailAddress="
				+ detailAddress + "]";
	}
	// 비밀번호 체크 확인
	
		public boolean pwChk(String pw) {
			return nbm_pw != null && nbm_pw.trim().length()>0 && nbm_pw.equals(pw);
		}
		
		//난수만들기
		private void RandomString() {
			
			
			Random r = new Random(System.nanoTime());
			StringBuffer sb = new StringBuffer();
			
			for(int i=0 ; i<20 ; i++ ) {
				if(r.nextBoolean()) {
					sb.append(r.nextInt(10));
					
				} else {
					sb.append((char)(r.nextInt(26)+97));
				}
			}
			
			System.out.println("난수 코드 생성 : " + sb) ;
			
			setNbm_code(sb.toString());
			
				
		}
	
	

}
