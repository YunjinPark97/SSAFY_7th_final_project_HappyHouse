package com.ssafy.vue.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import com.ssafy.vue.dto.QNAComment;

@Mapper
public interface QNACommentMapper {
	
	public int createQNAComment(QNAComment comment);
	public List<QNAComment> retrieveQNAComment(int articleno);
	
	public int updateQNAComment(Map<String, Object> updateInfo);
	public int forceUpdateQNAComment(QNAComment comment);
	public int deleteQNAComment(Map<String, Object> deleteInfo);
	public int forceDeleteQNAComment(int commentno);
	
	public int deleteQNACommentByArticleNo(int articleno); // 글이 삭제될 때만 실행
}
