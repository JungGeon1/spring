package com.test.nb.domain;





public class NbInfoDto {
	//글주소
	private int idx;
	//작성자아이디.
	private String u_id;
	//글제목
	private String u_title;
	//글내용
	private String u_contents;
	//사진의 이름
	private String u_image;
	//지도 키워드
	private String u_address;
	//조회수
	private int u_readcount;
	//작성날짜
	private String u_date;
	//카테고리
	private String category;
	//포토게시판 갯수
	private int pListCnt;
	//방명록갯수
	private int sListCnt;
	//댓글 갯수
	private int commetCnt;
	
	public NbInfoDto() {
	
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_title() {
		return u_title;
	}

	public void setU_title(String u_title) {
		this.u_title = u_title;
	}

	public String getU_contents() {
		return u_contents;
	}

	public void setU_contents(String u_contents) {
		this.u_contents = u_contents;
	}

	

	public int getU_readcount() {
		return u_readcount;
	}

	public void setU_readcount(int u_readcount) {
		this.u_readcount = u_readcount;
	}

	public String getU_date() {
		return u_date;
	}

	public void setU_date(String u_date) {
		this.u_date = u_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getU_image() {
		return u_image;
	}

	public void setU_image(String u_image) {
		this.u_image = u_image;
	}
	
	public int getpListCnt() {
		return pListCnt;
	}

	public void setpListCnt(int pListCnt) {
		this.pListCnt = pListCnt;
	}

	public int getsListCnt() {
		return sListCnt;
	}

	public void setsListCnt(int sListCnt) {
		this.sListCnt = sListCnt;
	}

	public int getCommetCnt() {
		return commetCnt;
	}

	public void setCommetCnt(int commetCnt) {
		this.commetCnt = commetCnt;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	@Override
	public String toString() {
		return "NbInfo [idx=" + idx + ", u_id=" + u_id + ", u_title=" + u_title + ", u_contents=" + u_contents
				+ ", u_image=" + u_image + ", u_readcount=" + u_readcount + ", u_date=" + u_date+ ", category="
				+ category + "]";
	}
	


	

	

}
