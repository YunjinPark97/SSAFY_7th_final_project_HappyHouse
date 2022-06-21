package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.MemberDto;

public interface MemberService {

	public boolean insert(MemberDto memberDto) throws Exception; // C
	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception; // R
	public boolean delete(String userid) throws Exception; // D
	// TODO?
	
	public List<MemberDto> selectAll() throws Exception;
	public boolean update(MemberDto memberDto) throws Exception; // U
}
