package com.test.nb.domain;

public class ViewPageDataDto {
	//카테코리 page, scroll
	private String category;
	//넘겨받은 뷰페이지의 글번호
	private int idx;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "ViewPageData [category=" + category + ", idx=" + idx + "]";
	}

}
