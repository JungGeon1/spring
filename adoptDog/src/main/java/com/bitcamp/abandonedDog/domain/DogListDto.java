package com.bitcamp.abandonedDog.domain;


import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
public class DogListDto {
	
	
	@XmlElementWrapper(name = "items")
    @XmlElement(name="item")
	private List<Item> dogItem;
	


	public List<Item> getDogItem() {
		System.out.println("발");
		return dogItem;
	}

	public void setDogItem(List<Item> dogItem) {
		this.dogItem = dogItem;
	}
	
	
	
	
	
	
	

}
