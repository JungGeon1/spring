package com.test.nb.domain;

public class NbAdminBoardDto {
	//공지글 번호
	private int adminBoard_idx;
	//관리자 아이디
	private String adminBoard_id;
	//공지글제목
	private String adminBoard_title;
	//공지글내용
	private String adminBoard_content;
	//공지날짜
	private String adminBoard_date;
	//첨부파일
	private String adminBoard_file;
	//관리자이메일
	private String adminBoard_email;
	//공지글 조회수
	private int adminBoard_views;
	//공지글 번호 뽑기
	private int listIdx;
	public int getAdminBoard_idx() {
		return adminBoard_idx;
	}
	public void setAdminBoard_idx(int adminBoard_idx) {
		this.adminBoard_idx = adminBoard_idx;
	}
	public String getAdminBoard_id() {
		return adminBoard_id;
	}
	public void setAdminBoard_id(String adminBoard_id) {
		this.adminBoard_id = adminBoard_id;
	}
	public String getAdminBoard_title() {
		return adminBoard_title;
	}
	public void setAdminBoard_title(String adminBoard_title) {
		this.adminBoard_title = adminBoard_title;
	}
	public String getAdminBoard_content() {
		return adminBoard_content;
	}
	public void setAdminBoard_content(String adminBoard_content) {
		this.adminBoard_content = adminBoard_content;
	}
	public String getAdminBoard_date() {
		return adminBoard_date;
	}
	public void setAdminBoard_date(String adminBoard_date) {
		this.adminBoard_date = adminBoard_date;
	}
	public String getAdminBoard_file() {
		return adminBoard_file;
	}
	public void setAdminBoard_file(String adminBoard_file) {
		this.adminBoard_file = adminBoard_file;
	}
	public String getAdminBoard_email() {
		return adminBoard_email;
	}
	public void setAdminBoard_email(String adminBoard_email) {
		this.adminBoard_email = adminBoard_email;
	}
	public int getAdminBoard_views() {
		return adminBoard_views;
	}
	public void setAdminBoard_views(int adminBoard_views) {
		this.adminBoard_views = adminBoard_views;
	}
	public int getListIdx() {
		return listIdx;
	}
	public void setListIdx(int listIdx) {
		this.listIdx = listIdx;
	}
	@Override
	public String toString() {
		return "NbAdminBoardDto [adminBoard_idx=" + adminBoard_idx + ", adminBoard_id=" + adminBoard_id
				+ ", adminBoard_title=" + adminBoard_title + ", adminBoard_content=" + adminBoard_content
				+ ", adminBoard_date=" + adminBoard_date + ", adminBoard_file=" + adminBoard_file
				+ ", adminBoard_email=" + adminBoard_email + ", adminBoard_views=" + adminBoard_views + ", listIdx="
				+ listIdx + "]";
	} 
	
	
}
