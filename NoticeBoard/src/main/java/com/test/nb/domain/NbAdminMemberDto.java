package com.test.nb.domain;

public class NbAdminMemberDto {
	
	private int admin_idx;
	private String admin_id;
	private String admin_pw;
	private String admin_name;
	private String admin_date;
	private int admin_rank;
	public int getAdmin_idx() {
		return admin_idx;
	}
	public void setAdmin_idx(int admin_idx) {
		this.admin_idx = admin_idx;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getAdmin_date() {
		return admin_date;
	}
	public void setAdmin_date(String admin_date) {
		this.admin_date = admin_date;
	}
	public int getAdmin_rank() {
		return admin_rank;
	}
	public void setAdmin_rank(int admin_rank) {
		this.admin_rank = admin_rank;
	}
	@Override
	public String toString() {
		return "NbAdminMemberDto [admin_idx=" + admin_idx + ", admin_id=" + admin_id + ", admin_pw=" + admin_pw
				+ ", admin_name=" + admin_name + ", admin_date=" + admin_date + ", admin_rank=" + admin_rank
				+ ", getAdmin_idx()=" + getAdmin_idx() + ", getAdmin_id()=" + getAdmin_id() + ", getAdmin_pw()="
				+ getAdmin_pw() + ", getAdmin_name()=" + getAdmin_name() + ", getAdmin_date()=" + getAdmin_date()
				+ ", getAdmin_rank()=" + getAdmin_rank() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
