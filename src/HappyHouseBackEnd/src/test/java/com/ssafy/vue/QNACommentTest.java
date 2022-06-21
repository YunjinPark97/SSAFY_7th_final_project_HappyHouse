package com.ssafy.vue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.vue.dto.QNAComment;
import com.ssafy.vue.service.QNACommentService;

@SpringBootTest
public class QNACommentTest {

	@Autowired
	QNACommentService qService;
	
//	@Test
//	public void insertTest() {
//		int result = qService.createQNAComment(new QNAComment(12, "ssafy", "댓글 1"));
//		assertEquals(result, 1);
//	}
	
//	@Test
//	public void selectTest() {
//		List<QNAComment> comments = qService.retrieveQNAComment(12);
//		assertEquals(comments.size(), 1);
//	}
	
//	@Test
//	public void updateTest() {
//		int result = qService.updateQNAComment(new QNAComment(12, "ssafy", "댓글 2"));
//		assertEquals(result, 1);
//	}
	
//	@Test
//	public void deleteTest() {
//		int result = qService.deleteQNAComment(1);
//		assertEquals(result, 1);
//	}
}
