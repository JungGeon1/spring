package com.bitcamp.abandonedDog.domain;

import java.util.Date;

public class Doginfo {
	private int a_idx;
	//회워아이디
	private String m_id ;
	//신청날짜
	private String a_date;
	//신청내용
	private String a_text;
	//신청제목
	private String a_title;
	//유기번호
	private String a_desertionNo;
	
	
	
	
	
	public Doginfo(String m_id, String a_date, String a_text, String a_title, String a_desertionNo) {
		this.m_id = m_id;
		this.a_date =  a_date;
		this.a_text = a_text;
		this.a_title = a_title;
		this.a_desertionNo = a_desertionNo;
	}
	public Doginfo() {
		
		
		// TODO Auto-generated constructor stub
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getA_date() {
		return a_date;
	}
	public void setA_date(String a_date) {
		this.a_date = a_date;
	}
	public String getA_text() {
		return a_text;
	}
	public void setA_text(String a_text) {
		this.a_text = a_text;
	}
	public String getA_title() {
		return a_title;
	}
	public void setA_title(String a_title) {
		this.a_title = a_title;
	}
	public String getA_desertionNo() {
		return a_desertionNo;
	}
	public void setA_desertionNo(String a_desertionNo) {
		this.a_desertionNo = a_desertionNo;
	}
	
	public int getA_idx() {
		return a_idx;
	}
	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}
	@Override
	public String toString() {
		return "Doginfo [a_idx=" + a_idx + ", m_id=" + m_id + ", a_date=" + a_date + ", a_text=" + a_text + ", a_title="
				+ a_title + ", a_desertionNo=" + a_desertionNo + "]";
	}
	
	
	
	

	

}
