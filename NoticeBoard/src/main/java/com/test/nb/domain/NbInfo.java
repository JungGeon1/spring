package com.test.nb.domain;

import java.sql.Date;

public class NbInfo {
	private int idx;
	private String u_id;
	private String u_title;
	private String u_contents;
	private String u_image;
	private int u_readcount;
	private Date u_date;
	private String category;

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

	public String getU_image() {
		return u_image;
	}

	public void setU_image(String u_image) {
		this.u_image = u_image;
	}

	public int getU_readcount() {
		return u_readcount;
	}

	public void setU_readcount(int u_readcount) {
		this.u_readcount = u_readcount;
	}

	public Date getU_date() {
		return u_date;
	}

	public void setU_date(Date u_date) {
		this.u_date = u_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "NbInfo [idx=" + idx + ", u_id=" + u_id + ", u_title=" + u_title + ", u_contents=" + u_contents
				+ ", u_image=" + u_image + ", u_readcount=" + u_readcount + ", u_date=" + u_date + ", category="
				+ category + "]";
	}

}
