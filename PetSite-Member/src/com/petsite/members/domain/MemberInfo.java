package com.petsite.members.domain;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MemberInfo {
	
	private String id;
	private String pw;
	private String name;
	private String address;
	private String detailAddress;
	private MultipartFile pic;
	private String pic_name;
	private String regDate;
	
	@JsonIgnore
	private String code;
	private char verify;
	
	// 생성자
	public MemberInfo() {
		this.code = getRandom();
		this.regDate = time();
	}
	
	// 아이디로 생성자 만들기
	public MemberInfo(String id) {
		this.id = id;
		this.code = getRandom();
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public char getVerify() {
		return verify;
	}

	public void setVerify(char verify) {
		this.verify = verify;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MultipartFile getPic() {
		return pic;
	}

	public void setPic(MultipartFile pic) {
		this.pic = pic;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberInfo [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", pic=" + pic
				+ ", regDate=" + regDate + "]";
	}

	public String getPic_name() {
		return this.pic_name;
	}

	public void setPic_name(String pic_name) {
		this.pic_name = pic_name;
	}
	
	// 시간 포맷
	public String time() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		return format.format(date);
	}
	
	// 난수 생성
	public String getRandom() {
		Random rand = new Random(System.nanoTime());
		StringBuffer sb = new StringBuffer();
		
		//총 20문자 길이의 난수 생성
		for(int i=0; i<20; i++) {
			if(rand.nextBoolean()) {
				sb.append(rand.nextInt(10));
			} else {
				sb.append((char)(rand.nextInt(26)+97));
			}
		}
		return sb.toString();
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	// 기본주소 + 상세주소
	public String addAddress() {
		return this.address + " " + this.detailAddress;
	}
	
}
