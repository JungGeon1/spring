package com.test.tb.domain;

public class BoardTblDto {
	private int b2_idx;
	private String b2_title;
	private String b2_contents;
	private String b2_id;
	private String b2_date;
	private int b2_grpno;
	private int b2_grpord;
	private int b2_depth;
	//답글 달 시에만 사용
	private int o_no;
	//수정시에만 사용
	private String b2_pw;
	//달린댓글수
	private int b2_commentCnt;
	//달린 답글수
	private int b2_rBoard;
	public int getB2_idx() {
		return b2_idx;
	}
	public void setB2_idx(int b2_idx) {
		this.b2_idx = b2_idx;
	}
	public String getB2_title() {
		return b2_title;
	}
	public void setB2_title(String b2_title) {
		this.b2_title = b2_title;
	}
	public String getB2_contents() {
		return b2_contents;
	}
	public void setB2_contents(String b2_contents) {
		this.b2_contents = b2_contents;
	}
	public String getB2_id() {
		return b2_id;
	}
	public void setB2_id(String b2_id) {
		this.b2_id = b2_id;
	}
	public String getB2_date() {
		return b2_date;
	}
	public void setB2_date(String b2_date) {
		this.b2_date = b2_date;
	}
	public int getB2_grpno() {
		return b2_grpno;
	}
	public void setB2_grpno(int b2_grpno) {
		this.b2_grpno = b2_grpno;
	}
	public int getB2_grpord() {
		return b2_grpord;
	}
	public void setB2_grpord(int b2_grpord) {
		this.b2_grpord = b2_grpord;
	}
	public int getB2_depth() {
		return b2_depth;
	}
	public void setB2_depth(int b2_depth) {
		this.b2_depth = b2_depth;
	}
	public int getO_no() {
		return o_no;
	}
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	public String getB2_pw() {
		return b2_pw;
	}
	public void setB2_pw(String b2_pw) {
		this.b2_pw = b2_pw;
	}
	public int getB2_commentCnt() {
		return b2_commentCnt;
	}
	public void setB2_commentCnt(int b2_commentCnt) {
		this.b2_commentCnt = b2_commentCnt;
	}
	public int getB2_rBoard() {
		return b2_rBoard;
	}
	public void setB2_rBoard(int b2_rBoard) {
		this.b2_rBoard = b2_rBoard;
	}
	@Override
	public String toString() {
		return "BoardTblDto [b2_idx=" + b2_idx + ", b2_title=" + b2_title + ", b2_contents=" + b2_contents + ", b2_id="
				+ b2_id + ", b2_date=" + b2_date + ", b2_grpno=" + b2_grpno + ", b2_grpord=" + b2_grpord + ", b2_depth="
				+ b2_depth + ", o_no=" + o_no + ", b2_pw=" + b2_pw + ", b2_commentCnt=" + b2_commentCnt + ", b2_rBoard="
				+ b2_rBoard + "]";
	} 
	
	
	
	
	
}
