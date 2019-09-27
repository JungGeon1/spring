package com.test.nb.domain;

import org.springframework.web.multipart.MultipartFile;

public class InsertInfoDto {
	private int idx;
	private String u_id;
	private String u_title;
	private String u_contents;
	private MultipartFile u_image;
	private String category;
	public InsertInfoDto() {
		super();
		// TODO Auto-generated constructor stub
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
	public MultipartFile getU_image() {
		return u_image;
	}
	public void setU_image(MultipartFile u_image) {
		this.u_image = u_image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "InsertInfoDto [idx=" + idx + ", u_id=" + u_id + ", u_title=" + u_title + ", u_contents=" + u_contents
				+ ", u_image=" + u_image + ", category=" + category + "]";
	}
	public NbInfoDto toNbInfo() {
		
		NbInfoDto nbInfo= new NbInfoDto();
		nbInfo.setIdx(idx);
		nbInfo.setU_id(u_id);
		nbInfo.setU_title(u_title);
		nbInfo.setU_contents(u_contents);
		nbInfo.setCategory(category);
		return nbInfo;
	}
	
	
}
