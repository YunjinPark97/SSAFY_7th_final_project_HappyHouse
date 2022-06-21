package com.ssafy.vue.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "좋아요 정보", description = "좋아요 번호, 아이디, 글번호를 가진 Domain Class")
public class BoardLike {
	
	private int likeno;
	private String userid;
	private int articleno;
	
	
	public BoardLike(String userid, int articleno) {
		this.userid = userid;
		this.articleno = articleno;
	}
	
	public int getLikeno() {
		return likeno;
	}
	public void setLikeno(int likeno) {
		this.likeno = likeno;
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
