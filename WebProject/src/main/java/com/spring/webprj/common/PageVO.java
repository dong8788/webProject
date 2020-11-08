package com.spring.webprj.common;

public class PageVO {
	
	public PageVO() {
		this.page = 1;
		this.countPerPage = 10;
	}
	
	//클라이언트가 전달한 페이지 번호를 데이터 베이스의 Limit절에 맞는 숫자로 변환하는 메서드
	public int getPageStart() {
		return (this.page -1) * this.countPerPage;
	}
	
	private int page;//사용자가 요청한 페이지 번호
	private int countPerPage;//한페이지당 들어갈 게시물의 수
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	public int getCountPerPage() {
		return countPerPage;
	}
	public void setCountPerPage(int countPerPage) {
		if(countPerPage <=0 || countPerPage > 30) {
			this.countPerPage = 10;
			return;
		}
		this.countPerPage = countPerPage;
	}

	@Override
	public String toString() {
		return "PageVO [page=" + page + ", countPerPage=" + countPerPage + "]";
	}
	
}
