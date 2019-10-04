package com.test.nb.domain;

import org.springframework.web.multipart.MultipartFile;
// 처음 바인딩받는용 따로만든이유는 멀티파트타입으로 DB에 저장할수 없기에 후에 다른 Dto에로 전달
public class InsertInfoDto {
	//게시글번호
	private int idx;
	//작성자 아이디
	private String u_id;
	//글제목
	private String u_title;
	//글내용
	private String u_contents;
	//글사진
	private MultipartFile u_image;
	//카테고리
	private String category;
	//지도키워드
	private String u_address;
	public InsertInfoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
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
	//DB에 저장하기위해 파일전달
	public NbInfoDto toNbInfo() {
		
		NbInfoDto nbInfo= new NbInfoDto();
		nbInfo.setIdx(idx);
		nbInfo.setU_id(u_id);
		nbInfo.setU_title(u_title);
		nbInfo.setU_contents(u_contents);
		nbInfo.setCategory(category);
		nbInfo.setU_address(u_address);
		return nbInfo;
	}
	
	
}
