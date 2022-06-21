package com.ssafy.vue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.BoardComment;
import com.ssafy.vue.mapper.BoardCommentMapper;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {
	
	@Autowired
	BoardCommentMapper bcMapper;

	@Override
	public int createBoardComment(BoardComment comment) {
		return bcMapper.createBoardComment(comment);
	}

	@Override
	public int updateBoardComment(BoardComment comment, String userid) {
		if (userid.equals("admin")) {
			return bcMapper.forceUpdateBoardComment(comment);
		}
		Map<String, Object> updateInfo = new HashMap<>();
		updateInfo.put("comment", comment);
		updateInfo.put("userid", userid);
		return bcMapper.updateBoardComment(updateInfo);
	}

	@Override
	public int deleteBoardComment(int commentno, String userid) {
		if (userid.equals("admin")) {
			return bcMapper.forceDeleteBoardComment(commentno);
		}
		
		Map<String, Object> deleteInfo = new HashMap<>();
		deleteInfo.put("commentno", commentno);
		deleteInfo.put("userid", userid);
		return bcMapper.deleteBoardComment(deleteInfo);
	}

	@Override
	public List<BoardComment> retrieveBoardComment(int articleno) {
		return bcMapper.retrieveBoardComment(articleno);
	}
	
	public int deleteBoardCommentByArticleNo(int articleno) {
		return bcMapper.deleteBoardCommentByArticleNo(articleno);
	}

	
}
