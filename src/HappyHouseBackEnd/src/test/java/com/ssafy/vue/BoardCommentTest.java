package com.ssafy.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.vue.dto.BoardComment;
import com.ssafy.vue.service.BoardCommentService;

@SpringBootTest
public class BoardCommentTest {

	@Autowired
	BoardCommentService bService;
	
//	@Test
//	public void insertTest() {
//		int result = bService.createBoardComment(new BoardComment(1, "ssafy", "댓글 1"));
//		assertEquals(result, 1);
//	}
	
//	@Test
//	public void selectTest() {
//		List<BoardComment> comments = bService.retrieveQNAComment(1);
//		assertEquals(comments.size(), 1);
//	}
	
//	@Test
//	public void updateTest() {
//		int result = bService.updateBoardComment(new BoardComment(1, 1, "ssafy", "댓글 2"));
//		assertEquals(result, 1);
//	}
	
//	@Test
//	public void deleteTest() {
//		int result = bService.deleteBoardComment(1);
//		assertEquals(result, 1);
//	}
}
