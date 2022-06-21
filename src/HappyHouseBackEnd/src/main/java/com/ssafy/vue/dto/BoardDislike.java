package com.ssafy.vue.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "싫어요 정보", description = "싫어요 번호, 아이디, 글번호를 가진 Domain Class")
public class BoardDislike {
	
	private int dislikeno;
	private String userid;
	private int articleno;
	
	
	public BoardDislike(String userid, int articleno) {
		this.userid = userid;
		this.articleno = articleno;
	}
	
	public int getDislikeno() {
		return dislikeno;
	}
	public void setDislikeno(int dislikeno) {
		this.dislikeno = dislikeno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getArticleno() {
		return articleno;
	}
	public void setArticleno(int articleno) {
		this.articleno = articleno;
	}
	
	
}
