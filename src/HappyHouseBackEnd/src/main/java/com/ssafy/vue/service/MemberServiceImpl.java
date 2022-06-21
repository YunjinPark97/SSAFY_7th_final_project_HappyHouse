package com.ssafy.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.dto.MemberDto;
import com.ssafy.vue.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		if(memberDto.getUserid() == null || memberDto.getUserpwd() == null)
			return null;
		return memberMapper.login(memberDto);
	}

	@Override
	public MemberDto userInfo(String userid) throws Exception {
		return memberMapper.userInfo(userid);
	}

	@Override
	public boolean insert(MemberDto memberDto) throws Exception {
		return memberMapper.insert(memberDto) == 1;
	}

	@Override
	public boolean update(MemberDto memberDto) throws Exception {
		return memberMapper.update(memberDto) == 1;
	}

	@Override
	public boolean delete(String userid) throws Exception {
		return memberMapper.delete(userid) == 1;
	}

	@Override
	public List<MemberDto> selectAll() throws Exception {
		return memberMapper.selectAll();
	}

}
