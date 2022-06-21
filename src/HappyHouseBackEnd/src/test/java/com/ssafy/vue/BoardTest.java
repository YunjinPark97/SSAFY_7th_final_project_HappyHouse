package com.ssafy.vue;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.service.BoardCommentService;
import com.ssafy.vue.service.BoardService;

@SpringBootTest
@Transactional
public class BoardTest {

	@Autowired
	BoardService bService;

	@Autowired
	BoardCommentService bcService;
	
//	@Test
//	public void insertTest() {
//		int result = qService.insertQNA(new QNA("ssafy", "안녕하세요안비밀", false));
//		assertEquals(result, 1);
//	}
	
//	@Test
//	public void selectOpenQNATest() {
//		List<QNA> qnas = qService.selectOpenQNA("ssafy");
//		assertEquals(qnas.size(), 20);
//		assertEquals(qnas.get(0).getSubject(), "안녕하세요안비밀");
//	}
	
//	@Test
//	public void selectAllQNA() {
//		List<QNA> qnas = qService.selectAllQNA();
//		assertEquals(qnas.size(), 2);
//	}
//	
//	@Test
//	public void selectQNAByNoTest() {
//		QNA qna = qService.selectQNAByNo(1);
//		assertEquals(qna.getSubject(), "안녕하세요비밀");
//	}
//	
//	@Test
//	public void updateQNA() {
//		int result = qService.updateQNA(new QNA(2, "ssafy", "update", "update", 0, "2022-05-19 14:39:20", true));
//		assertEquals(result, 1);
//	}
	
//	@Test
//	public void deleteBoardTest() {
//		bcService.createBoardComment(new BoardComment(6, "ssafy", "댓글 1"));
//		bcService.createBoardComment(new BoardComment(6, "ssafy", "댓글 2"));
//		bcService.createBoardComment(new BoardComment(6, "ssafy", "댓글 3"));
//		List<BoardComment> comments = bcService.retrieveBoardComment(6);
//		assertEquals(comments.size(), 3);
//		
//		boolean result = bService.deleteBoard(6);
//		assertEquals(result, true);
//		
//		comments = bcService.retrieveBoardComment(12);
//		assertEquals(comments.size(), 0);
//	}
	
//	@Test
//	public void selectOpenQNAByTitleTest() throws Exception {
//		List<QNA> qnas = qService.selectOpenQNAByTitle("녕", "ssafy");
//		for (QNA qna: qnas) {
//			System.out.println(qna.toString());
//		}
//		assertEquals(qnas.size(), 10);
//	}

//	@Test
//	public void selectAllQNAByTitleTest() {
//		List<QNA> qnas = qService.selectAllQNAByTitle("녕");
//		for (QNA qna: qnas) {
//			System.out.println(qna.toString());
//		}
//		assertEquals(qnas.size(), 7);
//	}
//	
//	@Test
//	public void selectOpenQNAByUseriddTest() {
//		List<QNA> qnas = qService.selectOpenQNAByUserid("ssafy");
//		assertEquals(qnas.size(), 8);
//	}
//	
//	@Test
//	public void selectAllQNAByUseriddTest() {
//		List<QNA> qnas = qService.selectAllQNAByUserid("ssafy");
//		assertEquals(qnas.size(), 14);
//	}
	
//	@Test
//	public void likeTest() {
//		boolean result1 = bService.like(bService.detailBoard(6), "ssafy");
//		assertTrue(result1);
//	}
	
}












