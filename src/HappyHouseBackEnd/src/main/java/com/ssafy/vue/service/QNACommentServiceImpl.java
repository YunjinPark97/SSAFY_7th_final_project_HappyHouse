package com.ssafy.vue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.QNAComment;
import com.ssafy.vue.mapper.QNACommentMapper;

@Service
public class QNACommentServiceImpl implements QNACommentService {
	
	@Autowired
	QNACommentMapper qcMapper;
	
	public int createQNAComment(QNAComment comment) {
		return qcMapper.createQNAComment(comment);
	}
	
	public List<QNAComment> retrieveQNAComment(int articleno) {
		return qcMapper.retrieveQNAComment(articleno);
	}
	
	public int updateQNAComment(QNAComment comment, String userid) {
		if (userid.equals("admin")) {
			return qcMapper.forceUpdateQNAComment(comment);
		}
		Map<String, Object> updateInfo = new HashMap<>();
		updateInfo.put("comment", comment);
		updateInfo.put("userid", userid);
		return qcMapper.updateQNAComment(updateInfo);
	}
	
	public int deleteQNAComment(int commentno, String userid) {
		if (userid.equals("admin")) {
			return qcMapper.forceDeleteQNAComment(commentno);
		}
		Map<String, Object> deleteInfo = new HashMap<>();
		deleteInfo.put("commentno", commentno);
		deleteInfo.put("userid", userid);
		return qcMapper.updateQNAComment(deleteInfo);
	}

	@Override
	public int deleteQNACommentByArticleNo(int articleno) {
		return qcMapper.deleteQNACommentByArticleNo(articleno);
	}
	
}