package com.test.nb.domain;

public class CommentDto {
	//댓글 번호
	private int n_idx;
	//게시글 번호
	private int u_idx;
	//작성자 아이디
	private String n_id;
	//댓글 내용
	private String n_comment;
	//작성날짜
	private String n_date;
	//댓글 그룹번호
	private int	n_grpno;
	//댓글 순서
	private int n_grpord; 
	//댓글 depth
	private int n_depth;
	
	
	public int getU_idx() {
		return u_idx;
	}
	public void setU_idx(int u_idx) {
		this.u_idx = u_idx;
	}
	public int getN_idx() {
		return n_idx;
	}
	public void setN_idx(int n_idx) {
		this.n_idx = n_idx;
	}
	public String getN_id() {
		return n_id;
	}
	public void setN_id(String n_id) {
		this.n_id = n_id;
	}
	public String getN_comment() {
		return n_comment;
	}
	public void setN_comment(String n_comment) {
		this.n_comment = n_comment;
	}
	public String getN_date() {
		return n_date;
	}
	public void setN_date(String n_date) {
		this.n_date = n_date;
	}
	public int getN_grpno() {
		return n_grpno;
	}
	public void setN_grpno(int n_grpno) {
		this.n_grpno = n_grpno;
	}
	public int getN_grpord() {
		return n_grpord;
	}
	public void setN_grpord(int n_grpord) {
		this.n_grpord = n_grpord;
	}
	public int getN_depth() {
		return n_depth;
	}
	public void setN_depth(int n_depth) {
		this.n_depth = n_depth;
	}
	@Override
	public String toString() {
		return "CommentDto [n_idx=" + n_idx + ", u_idx=" + u_idx + ", n_id=" + n_id + ", n_comment=" + n_comment
				+ ", n_date=" + n_date + ", n_grpno=" + n_grpno + ", n_grpord=" + n_grpord + ", n_depth=" + n_depth
				+ "]";
	}
	
	
	
}
