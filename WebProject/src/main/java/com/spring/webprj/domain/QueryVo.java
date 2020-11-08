package com.spring.webprj.domain;

import java.sql.Date;

public class QueryVo {

	private int querySeq;
	private String open;
	private int prodId;
	private String cusId;
	private String title;
	private String content;
	private Date regDate;
	private String reply;
	
	public QueryVo() {}
	
	public QueryVo(String open, String title, String content) {
		super();
		this.open=open;
		this.title=title;
		this.content=content;
	}
	
	public int getQuerySeq() {
		return querySeq;
	}
	public void setQuerySeq(int querySeq) {
		this.querySeq = querySeq;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getCusId() {
		return cusId;
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
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}

	@Override
	public String toString() {
		return "QueryVo [querySeq=" + querySeq + ", open=" + open + ", prodId=" + prodId + ", cusId=" + cusId
				+ ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", reply=" + reply + "]";
	}
	
		
}
