package com.ssafy.vue.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.BoardComment;

@Mapper
public interface BoardCommentMapper {
	
	public int createBoardComment(BoardComment comment);
	public List<BoardComment> retrieveBoardComment(int articleno);
	
	public int updateBoardComment(Map<String, Object> updateInfo);
	public int forceUpdateBoardComment(BoardComment comment);
	public int deleteBoardComment(Map<String, Object> deleteInfo);
	public int forceDeleteBoardComment(int commentno);

	public int deleteBoardCommentByArticleNo(int articleno); // 글이 삭제될 때만 실행
	
}
