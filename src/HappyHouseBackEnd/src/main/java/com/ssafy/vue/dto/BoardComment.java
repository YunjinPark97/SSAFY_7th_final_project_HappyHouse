package com.ssafy.vue.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardComment (네고왕 게시글의 댓글)", description = "댓글번호, 글번호, 작성자아이디, 내용, 작성일을 가진 Domain Class")
public class BoardComment {
	@ApiModelProperty(value = "댓글번호")
	private int commentno;
	@ApiModelProperty(value = "글번호")
	private int articleno;
	@ApiModelProperty(value = "작성자아이디")
	private String userid;
	@ApiModelProperty(value = "내용")
	private String content;
	@ApiModelProperty(value = "작성일")
	private String regtime;
	
	
	public BoardComment(int articleno, String userid, String content) {
		this.articleno = articleno;
		this.userid = userid;
		this.content = content;
	}
	
	// 주석처리하기
//	public BoardComment(int commentno, int articleno, String userid, String content) {
//		this.commentno = commentno;
//		this.articleno = articleno;
//		this.userid = userid;
//		this.content = content;
//	}

	public int getCommentno() {
		return commentno;
	}
	public void setCommentno(int commentno) {
		this.commentno = commentno;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
}
