package com.test.nb.domain;

public class SearchParamDto {

	//타입 ,ail, date, title
	private String stype;
	//검색어
	private String keyword;
	public String getStype() {
		return stype;
	}
	public void setStype(String stype) {
		this.stype = stype;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "SearchParam [stype=" + stype + ", keyword=" + keyword + "]";
	}
	
	
}
