package com.ssafy.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.vue.dto.MemberDto;
import com.ssafy.vue.mapper.MemberMapper;

@SpringBootTest
//@Transactional
public class UserTest {
	
	@Autowired
	MemberMapper mMapper;
	
//	@Test
//	public void insertTest() throws Exception { 
//		MemberDto memberDto = new MemberDto("test", "test", "test", "test", "2022-05-19 14:39:20");
//		int result = mMapper.insert(memberDto);
//		assertEquals(result, 1);
//	}
	
//	@Test
//	public void userInfoTest() throws Exception { 
//		MemberDto memberDto = mMapper.userInfo("admin");
//		System.out.println(memberDto.getJoindate());
//		assertEquals(memberDto.getUsername(), "관리자");
//	}
	
//	@Test
//	public void updateTest() throws Exception {
//		int result = mMapper.update(new MemberDto("test", "test1", "test1", "test1", "2022-05-19 14:39:20"));
//		assertEquals(1, 1);
//	}
//	
//	@Test
//	public void deleteTest() throws Exception {
//		int result = mMapper.delete("test");
//		assertEquals(1, 1);
//	}
	
//	@Test
//	public void selectAllTest() throws Exception {
//		List<MemberDto> members = mMapper.selectAll();
//		for (MemberDto member: members) {
//			System.out.println(member);
//		}
//	}
	
	
}
