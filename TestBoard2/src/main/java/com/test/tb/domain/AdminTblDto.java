package com.test.tb.domain;

public class AdminTblDto {
	private int a2_idx;
	private String a2_id;
	private String a2_pw;
	private String a2_date;
	public int getA2_idx() {
		return a2_idx;
	}
	public void setA2_idx(int a2_idx) {
		this.a2_idx = a2_idx;
	}
	public String getA2_id() {
		return a2_id;
	}
	public void setA2_id(String a2_id) {
		this.a2_id = a2_id;
	}
	public String getA2_pw() {
		return a2_pw;
	}
	public void setA2_pw(String a2_pw) {
		this.a2_pw = a2_pw;
	}
	public String getA2_date() {
		return a2_date;
	}
	public void setA2_date(String a2_date) {
		this.a2_date = a2_date;
	}
	@Override
	public String toString() {
		return "AdminTblDto [a2_idx=" + a2_idx + ", a2_id=" + a2_id + ", a2_pw=" + a2_pw + ", a2_date=" + a2_date + "]";
	}
	
	
	
	
}
