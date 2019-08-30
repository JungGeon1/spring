package com.bitcamp.rc;

import java.util.Date;
import java.util.Random;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
	2019.08.20
	verify 컬럼 추가, 	code 추가
	verify : 인증 여부 코드
	code : 난수 코드
*/
// usebean Class
@XmlRootElement(name="memberInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberInfoXml {

	// 각 변수의 저근 제어지시자는 private
	@XmlElement(name = "idx")
	private int idx;
	@XmlElement(name = "uId")
	private String uId;	
	@XmlElement(name = "uName")
	private String uName;
	@XmlElement(name = "uPhoto")
	private String uPhoto;
	@XmlElement(name = "regDate")
	private Date regDate;

	// default 생성자 필수
	public MemberInfoXml() {
	}


	// 변수들의 Getter/Setter 시작

	public String getuId() {
		return uId;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhoto() {
		return uPhoto;
	}

	public void setuPhoto(String uPhoto) {
		this.uPhoto = uPhoto;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	@Override
	public String toString() {
		return "MemberInfoXml [idx=" + idx + ", uId=" + uId + ", uName=" + uName + ", uPhoto=" + uPhoto + ", regDate="
				+ regDate + "]";
	}


	

}
