package com.bitcamp.rc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class DogRestResponse {

	//@XmlElement(name="header")
	//private DogResponseHeader header;
	@XmlElement(name="body")
	private DogResponseBody body;

//	public DogResponseHeader getHeader() {
//		return header;
//	}
//
//	public void setHeader(DogResponseHeader header) {
//		this.header = header;
//	}

	public DogResponseBody getBody() {
		return body;
	}

	public void setBody(DogResponseBody body) {
		this.body = body;
	}

}
