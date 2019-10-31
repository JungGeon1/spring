package com.test.tb.domain;

public class AdminTblDto {
	private int a_idx;
	private String a_id;
	private String a_pw;
	private String a_date;
	public int getA_idx() {
		return a_idx;
	}
	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
	}
	public String getA_pw() {
		return a_pw;
	}
	public void setA_pw(String a_pw) {
		this.a_pw = a_pw;
	}
	public String getA_date() {
		return a_date;
	}
	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	@Override
	public String toString() {
		return "AdminTblDto [a_idx=" + a_idx + ", a_id=" + a_id + ", a_pw=" + a_pw + ", a_date=" + a_date + "]";
	}
	
	
	
}
