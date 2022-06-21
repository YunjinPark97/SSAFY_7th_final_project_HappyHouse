package com.ssafy.vue.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Q&A (질문답변 게시판)", description = "글번호, 제목, 내용, 작성자아이디, 조회수, 작성일, 비밀글 여부를 가진 Domain Class")
public class QNA {
	@ApiModelProperty(value = "글번호")
	private int articleno;
	@ApiModelProperty(value = "작성자아이디")
	private String userid;
	@ApiModelProperty(value = "제목")
	private String subject;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "조회수")
	private int hit;
	@ApiModelProperty(value = "작성일")
	private String regtime;
	@ApiModelProperty(value = "비밀글 여부")
	private boolean secret; 
	
//	public QNA(String userid, String subject, boolean secret) {
//		this.userid = userid;
//		this.subject = subject;
//		this.secret = secret;
//	}
//	
//	public QNA(int articleno, String userid, String subject, String content, int hit, String regtime, boolean secret) {
//		this.articleno = articleno;
//		this.userid = userid;
//		this.subject = subject;
//		this.content = content;
//		this.hit = hit;
//		this.regtime = regtime;
//		this.secret = secret;
//	}

	@Override
	public String toString() {
		return "QNA [articleno=" + articleno + ", userid=" + userid + ", subject=" + subject + ", content=" + content
				+ ", hit=" + hit + ", regtime=" + regtime + ", secret=" + secret + "]";
	}

	public int getArticleno() {
		return articleno;
	}
	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
	public boolean getSecret() {
		return secret;
	}
	public void setSecret(boolean secret) {
		this.secret = secret;
	}
}
