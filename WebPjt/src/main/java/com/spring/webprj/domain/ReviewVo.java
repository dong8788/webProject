package com.spring.webprj.domain;

import java.util.Date;

public class ReviewVo {

	private int reviewSeq;
	private String prodId;
	private String cusId;
	private int score;
	private String title;
	private String content;
	private Date regDate;
	
	public int getReviewSeq() {
		return reviewSeq;
	}
	public void setReviewSeq(int reviewSeq) {
		this.reviewSeq = reviewSeq;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getCusId() {
		return cusId;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "ReviewVo [reviewSeq=" + reviewSeq + ", prodId=" + prodId + ", cusId=" + cusId + ", title=" + title
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}
	
		
	
}
