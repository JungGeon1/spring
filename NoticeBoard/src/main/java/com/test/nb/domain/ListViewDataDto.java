package com.test.nb.domain;

public class ListViewDataDto {
	//찾고자 하는 리스트의 시작 주소
	private int startIdx;
	//찾고자 하는 리스트의 마지막주소
	private int lastIdx;
	//찾고자하는 게시판의 종류
	private String category;

	public ListViewDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getStartIdx() {
		return startIdx;
	}
	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}
	public int getLastIdx() {
		return lastIdx;
	}
	public void setLastIdx(int lastIdx) {
		this.lastIdx = lastIdx;
	}


	


}
