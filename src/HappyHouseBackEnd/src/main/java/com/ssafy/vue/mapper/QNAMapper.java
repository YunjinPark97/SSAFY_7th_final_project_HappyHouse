package com.ssafy.vue.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.QNA;

@Mapper
public interface QNAMapper {
	public List<QNA> selectOpenQNA(String userid); // 공개글만
	public List<QNA> selectAllQNA(); // 비밀글도
	public QNA selectQNAByNo(int articleno);
	public List<QNA> selectOpenQNAByTitle(String query, String userid);
	public List<QNA> selectAllQNAByTitle(String query);
	public List<QNA> selectOpenQNAByUserid(String query);
	public List<QNA> selectAllQNAByUserid(String query);
	public void updateHit(int articleno);
	public int insertQNA(QNA qna);
	
	public int updateQNA(Map<String, Object> updateInfo);
	public int forceUpdateQNA(QNA qna);
	public int deleteQNA(Map<String, Object> deleteInfo);
	public int forceDeleteQNA(int articleno);
}


