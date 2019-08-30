package com.bitcamp.rc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

	@XmlElement(name = "kindCd")
	private String kindCd;
	@XmlElement(name = "popfile")
	private String popfile;

	public String getKindCd() {
		return kindCd;
	}

	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}

	public String getPopfile() {
		return popfile;
	}

	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}

	@Override
	public String toString() {
		return "Item [kindCd=" + kindCd + ", popfile=" + popfile + "]";
	}

}
