package com.test.nb.domain;

import org.springframework.web.multipart.MultipartFile;

public class NbAdminBoardInsetInfoDto {
	
	//관리자 아이디
	private String adminBoard_id;
	//공지글제목
	private String adminBoard_title;
	//공지글내용
	private String adminBoard_content;
	//첨부파일
	private MultipartFile adminBoard_file;
	//관리자이메일
	private String adminBoard_email;
	
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
	public MultipartFile getAdminBoard_file() {
		return adminBoard_file;
	}
	public void setAdminBoard_file(MultipartFile adminBoard_file) {
		this.adminBoard_file = adminBoard_file;
	}
	public String getAdminBoard_email() {
		return adminBoard_email;
	}
	public void setAdminBoard_email(String adminBoard_email) {
		this.adminBoard_email = adminBoard_email;
	}
	
	@Override
	public String toString() {
		return "NbAdminBoardInsetInfoDto [adminBoard_id=" + adminBoard_id + ", adminBoard_title=" + adminBoard_title
				+ ", adminBoard_content=" + adminBoard_content + ", adminBoard_file=" + adminBoard_file
				+ ", adminBoard_email=" + adminBoard_email + ", adminBoard_views=" 
				+ ", getAdminBoard_id()=" + getAdminBoard_id() + ", getAdminBoard_title()=" + getAdminBoard_title()
				+ ", getAdminBoard_content()=" + getAdminBoard_content() + ", getAdminBoard_file()="
				+ getAdminBoard_file() + ", getAdminBoard_email()=" + getAdminBoard_email() + ", getAdminBoard_views()="
				+  ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	//DB에 저장하기위해 파일전달
	public NbAdminBoardDto toBoardDto() {
		NbAdminBoardDto boardDto= new NbAdminBoardDto();
		
		boardDto.setAdminBoard_id(adminBoard_id);
		boardDto.setAdminBoard_title(adminBoard_title);
		boardDto.setAdminBoard_content(adminBoard_content);
		boardDto.setAdminBoard_email(adminBoard_email);
		
		return boardDto;
	}
	
}
