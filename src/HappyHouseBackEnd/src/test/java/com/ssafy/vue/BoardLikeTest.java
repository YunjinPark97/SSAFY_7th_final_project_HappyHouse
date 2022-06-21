package com.ssafy.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.dto.BoardLike;
import com.ssafy.vue.mapper.BoardLikeMapper;

@SpringBootTest
@Transactional
public class BoardLikeTest {
	
	@Autowired
	BoardLikeMapper blMapper;
	
	@Test
	public void createTest() {
		int result = blMapper.create(new BoardLike("ssafy", 6));
		assertEquals(result, 1);
	}
	
	@Test
	public void selectTest() {
		int result = blMapper.select("ssafy", 100);
		assertEquals(result, 1);
	}
}
