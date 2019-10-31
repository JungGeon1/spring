package com.test.tb.domain;

public class BoardTblDto {
	private int b_idx;
	private String b_title;
	private String b_contents;
	private String b_id;
	private String b_date;
	private int b_grpno;
	private int b_grpord;
	private int b_depth;
	//답글 달 시에만 사용
	private int o_no;
	//수정시에만 사용
	private String b_pw;
	//달린댓글수
	private int b_commentCnt;
	//달린 답글수
	private int b_rBoard; 
	
	
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_contents() {
		return b_contents;
	}
	public void setB_contents(String b_contents) {
		this.b_contents = b_contents;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public int getB_grpno() {
		return b_grpno;
	}
	public void setB_grpno(int b_grpno) {
		this.b_grpno = b_grpno;
	}
	public int getB_grpord() {
		return b_grpord;
	}
	public void setB_grpord(int b_grpord) {
		this.b_grpord = b_grpord;
	}
	public int getB_depth() {
		return b_depth;
	}
	public void setB_depth(int b_depth) {
		this.b_depth = b_depth;
	}
	public int getO_no() {
		return o_no;
	}
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	public String getB_pw() {
		return b_pw;
	}
	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}
	
	public int getB_commentCnt() {
		return b_commentCnt;
	}
	public void setB_commentCnt(int b_commentCnt) {
		this.b_commentCnt = b_commentCnt;
	}
	public int getB_rBoard() {
		return b_rBoard;
	}
	public void setB_rBoard(int b_rBoard) {
		this.b_rBoard = b_rBoard;
	}
	@Override
	public String toString() {
		return "BoardTblDto [b_idx=" + b_idx + ", b_title=" + b_title + ", b_contents=" + b_contents + ", b_id=" + b_id
				+ ", b_date=" + b_date + ", b_grpno=" + b_grpno + ", b_grpord=" + b_grpord + ", b_depth=" + b_depth
				+ ", o_no=" + o_no + ", getB_idx()=" + getB_idx() + ", getB_title()=" + getB_title()
				+ ", getB_contents()=" + getB_contents() + ", getB_id()=" + getB_id() + ", getB_date()=" + getB_date()
				+ ", getB_grpno()=" + getB_grpno() + ", getB_grpord()=" + getB_grpord() + ", getB_depth()="
				+ getB_depth() + ", getO_no()=" + getO_no() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
