package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.QNA;

public interface QNAService {
	public List<QNA> selectOpenQNA(String userid); // 공개글만
	public List<QNA> selectAllQNA(); // 비밀글도
	public QNA selectQNAByNo(int articleno); // 보이는 글만 누르기에, validation 체크할 필요가 없음.
	public List<QNA> selectOpenQNAByTitle(String query, String userid);
	public List<QNA> selectAllQNAByTitle(String query);
	public List<QNA> selectOpenQNAByUserid(String query);
	public List<QNA> selectAllQNAByUserid(String query);
	public void updateHit(int articleno);
	public int insertQNA(QNA qna);
	public int updateQNA(QNA qna, String userid);
	public int deleteQNA(int articleno, String userid);
}
