package com.bitcamp.abandonedDog.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.web.multipart.MultipartFile;



@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
	
	@XmlElement(name = "kindCd")
	private String kindCd;
	@XmlElement(name = "sexCd")
	private String sexCd;
	@XmlElement(name = "age")
	private String age;
	@XmlElement(name = "weight")
	private String weight;
	@XmlElement(name = "chargeNm")
	private String chargeNm;
	@XmlElement(name = "officetel")
	private String officetel;
	@XmlElement(name = "specialMark")
	private String specialMark;
	@XmlElement(name = "popfile")
	private String popfile;
	
	
	public String getKindCd() {
		return kindCd;
	}
	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}
	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getChargeNm() {
		return chargeNm;
	}
	public void setChargeNm(String chargeNm) {
		this.chargeNm = chargeNm;
	}
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	public String getSpecialMark() {
		return specialMark;
	}
	public void setSpecialMark(String specialMark) {
		this.specialMark = specialMark;
	}
	public String getPopfile() {
		return popfile;
	}
	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}
	@Override
	public String toString() {
		return "Dogitem [kindCd=" + kindCd + ", sexCd=" + sexCd + ", age=" + age + ", weight=" + weight + ", chargeNm="
				+ chargeNm + ", officetel=" + officetel + ", specialMark=" + specialMark + ", popfile=" + popfile + "]";
	}
	
	
}
