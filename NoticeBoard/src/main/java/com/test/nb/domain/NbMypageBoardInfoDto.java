package com.test.nb.domain;

public class NbMypageBoardInfoDto {
	//총 게시글의 갯수
	private int totalBoardCnt;
	//스크롤 게시글의 갯수
	private int scrollBoardCnt;
	// 페이지 게시글의 갯수
	private int pageBoardCnt;
	//작성한 총 댓글의 갯수
	private int selectTotalCmCnt;
	public int getTotalBoardCnt() {
		return totalBoardCnt;
	}
	public void setTotalBoardCnt(int totalBoardCnt) {
		this.totalBoardCnt = totalBoardCnt;
	}
	public int getScrollBoardCnt() {
		return scrollBoardCnt;
	}
	public void setScrollBoardCnt(int scrollBoardCnt) {
		this.scrollBoardCnt = scrollBoardCnt;
	}
	public int getPageBoardCnt() {
		return pageBoardCnt;
	}
	public void setPageBoardCnt(int pageBoardCnt) {
		this.pageBoardCnt = pageBoardCnt;
	}
	public int getSelectTotalCmCnt() {
		return selectTotalCmCnt;
	}
	public void setSelectTotalCmCnt(int selectTotalCmCnt) {
		this.selectTotalCmCnt = selectTotalCmCnt;
	}
	@Override
	public String toString() {
		return "BoardInfoDto [totalBoardCnt=" + totalBoardCnt + ", scrollBoardCnt=" + scrollBoardCnt + ", pageBoardCnt="
				+ pageBoardCnt + ", selectTotalCmCnt=" + selectTotalCmCnt + "]";
	}
	
	
	

}
