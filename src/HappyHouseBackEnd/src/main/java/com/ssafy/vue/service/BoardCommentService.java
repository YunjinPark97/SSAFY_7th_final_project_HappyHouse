package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.BoardComment;

public interface BoardCommentService {
	
	public int createBoardComment(BoardComment comment);
	public List<BoardComment> retrieveBoardComment(int articleno);
	public int updateBoardComment(BoardComment comment, String userid);
	public int deleteBoardComment(int commentno, String userid);
	public int deleteBoardCommentByArticleNo(int articleno); // 글을 삭제하면 실행됨
}
