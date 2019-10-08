package com.test.nb.domain;

public class MainImgClickCommentDto {
	//가입기간
	private int memberdate;
	//작성한 총 포토보드의수
	private int totalPhotoBoard;
	//작성한 방명록의 수
	private int totalGuestBook;
	//작성한 댓글의 수
	private int totalComment;
	//업로드한 사진의 수 
	private int totalUpPhoto;
	//모든 글의 누적 조회수 
	private int totalViews;
	
	public int getMemberdate() {
		return memberdate;
	}
	public void setMemberdate(int memberdate) {
		this.memberdate = memberdate;
	}
	public int getTotalPhotoBoard() {
		return totalPhotoBoard;
	}
	public void setTotalPhotoBoard(int totalPhotoBoard) {
		this.totalPhotoBoard = totalPhotoBoard;
	}
	public int getTotalGuestBook() {
		return totalGuestBook;
	}
	public void setTotalGuestBook(int totalGuestBook) {
		this.totalGuestBook = totalGuestBook;
	}
	public int getTotalComment() {
		return totalComment;
	}
	public void setTotalComment(int totalComment) {
		this.totalComment = totalComment;
	}
	public int getTotalUpPhoto() {
		return totalUpPhoto;
	}
	public void setTotalUpPhoto(int totalUpPhoto) {
		this.totalUpPhoto = totalUpPhoto;
	}
	public int getTotalViews() {
		return totalViews;
	}
	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}
	@Override
	public String toString() {
		return "MainImgClickCommentDto [memberdate=" + memberdate + ", totalPhotoBoard=" + totalPhotoBoard
				+ ", totalGuestBook=" + totalGuestBook + ", totalComment=" + totalComment + ", totalUpPhoto="
				+ totalUpPhoto + ", totalViews=" + totalViews + "]";
	}
	
	
	
	
}
