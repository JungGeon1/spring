package com.bitcamp.abandonedDog.domain;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class DogResponse {
	
	@XmlElement(name="header")
	private Map<String,String> header;
	@XmlElement(name="body")
	private DogListDto body;
	
	public Map<String, String> getHeader() {
		return header;
	}
	public void setHeader(Map<String, String> header) {
		this.header = header;
	}
	public DogListDto getBody() {
		
		return body;
	}
	public void setBody(DogListDto body) {
		
		this.body = body;
	}

	

}
