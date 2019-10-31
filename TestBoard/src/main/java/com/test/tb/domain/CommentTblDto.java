package com.test.tb.domain;

public class CommentTblDto {
	private int c_idx;
	private int c_bIdx;
	private String c_comment;
	private String c_id;
	private String c_date;
	private int c_grpno;
	private int c_grpord;
	private int c_depth;
	//답글 작성시 사용
	private int o_no;
	//수정시에만 사용
	private String c_pw;
	
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public int getC_bIdx() {
		return c_bIdx;
	}
	public void setC_bIdx(int c_bIdx) {
		this.c_bIdx = c_bIdx;
	}
	public String getC_comment() {
		return c_comment;
	}
	public void setC_comment(String c_comment) {
		this.c_comment = c_comment;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	public int getC_grpno() {
		return c_grpno;
	}
	public void setC_grpno(int c_grpno) {
		this.c_grpno = c_grpno;
	}
	public int getC_grpord() {
		return c_grpord;
	}
	public void setC_grpord(int c_grpord) {
		this.c_grpord = c_grpord;
	}
	public int getC_depth() {
		return c_depth;
	}
	public void setC_depth(int c_depth) {
		this.c_depth = c_depth;
	}
	public int getO_no() {
		return o_no;
	}
	public void setO_no(int o_no) {
		this.o_no = o_no;
	}
	public String getC_pw() {
		return c_pw;
	}
	public void setC_pw(String c_pw) {
		this.c_pw = c_pw;
	}
	@Override
	public String toString() {
		return "CommentTblDto [c_idx=" + c_idx + ", c_bIdx=" + c_bIdx + ", c_comment=" + c_comment + ", c_id=" + c_id
				+ ", c_date=" + c_date + ", c_grpno=" + c_grpno + ", c_grpord=" + c_grpord + ", c_depth=" + c_depth
				+ ", o_no=" + o_no + ", c_pw=" + c_pw + ", getC_idx()=" + getC_idx() + ", getC_bIdx()=" + getC_bIdx()
				+ ", getC_comment()=" + getC_comment() + ", getC_id()=" + getC_id() + ", getC_date()=" + getC_date()
				+ ", getC_grpno()=" + getC_grpno() + ", getC_grpord()=" + getC_grpord() + ", getC_depth()="
				+ getC_depth() + ", getO_no()=" + getO_no() + ", getC_pw()=" + getC_pw() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
}
