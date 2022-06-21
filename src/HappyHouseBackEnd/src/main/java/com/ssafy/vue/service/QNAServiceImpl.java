package com.ssafy.vue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.QNA;
import com.ssafy.vue.mapper.QNACommentMapper;
import com.ssafy.vue.mapper.QNAMapper;

@Service
public class QNAServiceImpl implements QNAService {
	
	@Autowired
	QNAMapper qMapper;
	
	@Autowired
	QNACommentMapper qcMapper;
	
	@Override
	public List<QNA> selectOpenQNA(String userid) {
		return qMapper.selectOpenQNA(userid);
	}

	@Override
	public List<QNA> selectAllQNA() {
		return qMapper.selectAllQNA();
	}
	
	public QNA selectQNAByNo(int articleno) {
      updateHit(articleno);
      return qMapper.selectQNAByNo(articleno);
	}
	
	@Override
	public List<QNA> selectOpenQNAByTitle(String query, String userid) {
		query = "%"+query+"%";
		return qMapper.selectOpenQNAByTitle(query, userid);
	}

	@Override
	public List<QNA> selectAllQNAByTitle(String query) {
		query = "%"+query+"%";
		return qMapper.selectAllQNAByTitle(query);
	}

	@Override
	public List<QNA> selectOpenQNAByUserid(String query) {
		return qMapper.selectOpenQNAByUserid(query);
	}

	@Override
	public List<QNA> selectAllQNAByUserid(String query) {
		return qMapper.selectAllQNAByUserid(query);
	}

	@Override
	public void updateHit(int articleno) {
		qMapper.updateHit(articleno);
	}

	@Override
	public int insertQNA(QNA qna) {
		return qMapper.insertQNA(qna);
	}

	@Override
	public int updateQNA(QNA qna, String userid) {
		if (userid.equals("admin")) {
			return qMapper.forceUpdateQNA(qna);
		}
		Map<String, Object> updateInfo = new HashMap<>();
		updateInfo.put("qna", qna);
		updateInfo.put("userid", userid);
		return qMapper.updateQNA(updateInfo);
	}

	@Override
	public int deleteQNA(int articleno, String userid) {
		if (userid.equals("admin")) {
			System.out.println("userid == admin");
			qMapper.forceDeleteQNA(articleno);
			return 1;
		}
		Map<String,Object> deleteInfo = new HashMap<>();
		deleteInfo.put("articleno",articleno);
		deleteInfo.put("userid",userid);
		if (qMapper.deleteQNA(deleteInfo) == 1) {
			qcMapper.deleteQNACommentByArticleNo(articleno);
			return 1;
		}
		return 0;
	}
}
