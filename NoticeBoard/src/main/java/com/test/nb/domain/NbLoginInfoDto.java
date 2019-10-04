package com.test.nb.domain;

public class NbLoginInfoDto {
	//로그인 아이디
	private String nbm_id;
	//로그인 비밀번호
	private String nbm_pw;
	
	public NbLoginInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NbLoginInfoDto(String nbm_id, String nbm_pw) {
		this.nbm_id = nbm_id;
		this.nbm_pw = nbm_pw;
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
	@Override
	public String toString() {
		return "NbLoginInfoDto [nbm_id=" + nbm_id + ", nbm_pw=" + nbm_pw + "]";
	}

	
	
}
