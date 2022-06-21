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

import com.ssafy.vue.dto.BoardComment;
import com.ssafy.vue.dto.QNAComment;
import com.ssafy.vue.service.BoardCommentService;
import com.ssafy.vue.service.JwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("QNACommentController V1")
@RestController
@RequestMapping("/boardcomment")
public class BoardCommentController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private BoardCommentService bcService;
	
	@Autowired
	private JwtService jwtService;
		
	@ApiOperation(value = "네고왕 댓글 등록", notes = "새로운 네고왕 댓글을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createBoardComment(@RequestBody BoardComment comment) {
		logger.debug("createBoardComment - 호출");
		if (bcService.createBoardComment(comment) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
	// 댓글 select가 없는 이유: detailBoard할 때 같이 나온다.
	
    @ApiOperation(value = "네고왕 댓글 수정", notes = "댓글 번호에 해당하는 댓글를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> updateQNA(@RequestBody BoardComment comment) throws Exception {
		logger.debug("updateBoardComment - 호출");
//		String token = request.getHeader("access-token");
//
//		logger.debug("token : {}",token);
//		if(!jwtService.isUsable(token)){
//			return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
//		}
//
//		String userid = jwtService.getUserIdByToken(token);
//
//		logger.debug("userId : {}",userid);
//		
		if (bcService.updateBoardComment(comment, "admin") == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "네고왕 댓글 삭제", notes = "댓글을 삭제한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{commentno}")
	public ResponseEntity<String> deleteBoard(@PathVariable int commentno) throws Exception {
		logger.debug("deleteBoardComment - 호출");
//		String token = request.getHeader("access-token");
//
//		logger.debug("token : {}",token);
//		if(!jwtService.isUsable(token)){
//			return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
//		}
//
//		String userid = jwtService.getUserIdByToken(token);
//
//		logger.debug("userId : {}",userid);
		if (bcService.deleteBoardComment(commentno, "admin") == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
