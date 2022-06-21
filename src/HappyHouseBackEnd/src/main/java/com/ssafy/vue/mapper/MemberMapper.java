package com.ssafy.vue.mapper;

import java.util.List;

import com.ssafy.vue.dto.MemberDto;


public interface MemberMapper {

	public int insert(MemberDto memberDto) throws Exception; // C
	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception; // R
	public List<MemberDto> selectAll() throws Exception;
	public int update(MemberDto memberDto) throws Exception; // U
	public int delete(String userid) throws Exception; // D

}