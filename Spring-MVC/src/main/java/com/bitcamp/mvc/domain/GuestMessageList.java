package com.bitcamp.mvc.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
//큰이름
@XmlRootElement(name = "message-list")
public class GuestMessageList {
	//여기가 한 블럭 이름
	@XmlElement(name = "message")
	private List<GuestMessage> messages;

	
	public GuestMessageList() {}


	public GuestMessageList(List<GuestMessage> messages) {
		super();
		this.messages = messages;
	}


	public List<GuestMessage> getMessages() {
		return messages;
	}
	
	
}
