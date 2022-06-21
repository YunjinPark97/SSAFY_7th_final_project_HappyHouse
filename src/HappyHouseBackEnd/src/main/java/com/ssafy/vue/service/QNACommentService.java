package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.QNAComment;

public interface QNACommentService {
	public int createQNAComment(QNAComment comment);
	public List<QNAComment> retrieveQNAComment(int articleno);
	public int updateQNAComment(QNAComment comment, String userid);
	public int deleteQNAComment(int commentno, String userid);
	public int deleteQNACommentByArticleNo(int articleno);
}
