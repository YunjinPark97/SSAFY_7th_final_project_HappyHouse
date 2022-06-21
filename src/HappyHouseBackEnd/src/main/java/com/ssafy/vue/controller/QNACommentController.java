package com.ssafy.vue.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.QNAComment;
import com.ssafy.vue.service.JwtService;
import com.ssafy.vue.service.QNACommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("QNACommentController V1")
@RestController
@RequestMapping("/qnacomment")
public class QNACommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private QNACommentService qcService;
	
	@Autowired
	private JwtService jwtService;
	
	// select: 글 상세보기할때만
	// 댓글달기는 ajax? 느낌으로 구현되어야할 거 같은데...
	
	@ApiOperation(value = "Q&A 댓글 등록", notes = "새로운 Q&A 댓글을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createQNAComment(@RequestBody QNAComment comment) {
		logger.debug("createQNAComment - 호출");
		if (qcService.createQNAComment(comment) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "Q&A 댓글 수정", notes = "댓글 번호에 해당하는 댓글를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> updateQNA(@RequestBody QNAComment comment) throws Exception {
		logger.debug("updateQNAComment - 호출");
//		String token = request.getHeader("access-token");
//
//		logger.debug("token : {}",token);
//		if(!jwtService.isUsable(token)){
//			return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
//		}
//
//		String userid = jwtService.getUserIdByToken(token);
//		logger.debug("userId : {}",userid);
		if (qcService.updateQNAComment(comment, "admin") == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "Q&A 댓글 삭제", notes = "댓글을 삭제한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{commentno}")
	public ResponseEntity<String> deleteQNA(@PathVariable int commentno) throws Exception {
		logger.debug("deleteQNAComment - 호출");
//		String token = request.getHeader("access-token");
//
//		logger.debug("token : {}",token);
//		if(!jwtService.isUsable(token)){
//			return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
//		}
//
//		String userid = jwtService.getUserIdByToken(token);
//		logger.debug("userId : {}",userid);
		if (qcService.deleteQNAComment(commentno, "admin") == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
