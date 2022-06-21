package com.ssafy.vue.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.dto.BoardDislike;

@Mapper
public interface BoardDislikeMapper {
	public int select(String userid, int articleno);
	public int create(BoardDislike boardDislike);
}
