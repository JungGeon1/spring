package com.bitcamp.rc;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "memberInfos")
public class ListViewDataXml {
	
	@XmlElementWrapper(name = "memberInfo-list")
	@XmlElement(name="memberInfo")
	private List<MemberInfoXml> memberList;
	@XmlElement(name="totalCount")
	private int totalCount ;
	@XmlElement(name="no")
	private int no;
	@XmlElement(name="currentPageNumber")
	private int currentPageNumber;
	@XmlElement(name="pageTotalCount")
	private int pageTotalCount;

	public List<MemberInfoXml> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<MemberInfoXml> memberList) {
		this.memberList = memberList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	
	
	
	
	
	
	
	
	

}
