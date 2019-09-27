package com.test.nb.domain;

public class ViewPageDataDto {
	private String category;
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
