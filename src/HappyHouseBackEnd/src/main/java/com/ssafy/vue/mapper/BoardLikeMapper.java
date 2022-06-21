package com.ssafy.vue.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.BoardLike;

@Mapper
public interface BoardLikeMapper {
	public int select(String userid, int articleno);
	public int create(BoardLike boardLike);
}
