package com.spring.webprj.common;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageCreator {
	
	//페이지 번호와 한페이지당 들어갈 게시물 수를 갖고 있는 객체인 PageVO를 생성
	private PageVO paging;
	private int articleTotalCount;//게시판의 총 게시물 수 
	private int beginPage;// 시작 페이지 번호
	private int endPage; // 끝 페이지 번호
	private boolean prev; //이전 버튼 활성화 여부
	private boolean next; // 다음버튼 활성화 여부
	
	//한화면에 보여질 페이지 버튼 개수
	private final int displayPageNum = 10;//외부에서 변경이 불가능하게 final로 지정
	
	//URI 파라미터를 쉽게 만들어주는 유틸 메서드를 선언
	public String makeURI(int page) {
		UriComponents ucp = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("countPerPage", paging.getCountPerPage())
				.queryParam("keyword", ((SearchVO)paging).getKeyword())
				.queryParam("condition", ((SearchVO)paging).getCondition()).build();
		return ucp.toUriString();
	}
	
	//페이징 알고리즘을 수행할 메서드 선언
	private void calcDataOfPage() {
		//보정 전 끝 페이지 구하기
		endPage = (int) Math.ceil(paging.getPage() / (double)displayPageNum) * displayPageNum;
		//시작 페이지 번호
		beginPage = (endPage - displayPageNum)+1;
		
		//현재 시작페이지가 1이라면 이전버튼 활성화 여부를 false로 지정
		prev = (beginPage == 1)? false : true;
		
		//마지막 페이지인지 여부 확인 후 다음 버튼 비활성화
		next = (articleTotalCount <= (endPage*paging.getCountPerPage()))? false:true;
		
		//재보정 여부 판단하기
		if(!isNext()) {
			// 끝페이지 재보정하기
			endPage = (int) Math.ceil(articleTotalCount / (double)paging.getCountPerPage());
		}
		
	}
	
	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getArticleTotalCount() {
		return articleTotalCount;
	}

	public void setArticleTotalCount(int articleTotalCount) {
		this.articleTotalCount = articleTotalCount;
		calcDataOfPage();
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	@Override
	public String toString() {
		return "PageCreator [paging=" + paging + ", articleTotalCount=" + articleTotalCount + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum
				+ "]";
	}
	
	
	
	
	
	
}
