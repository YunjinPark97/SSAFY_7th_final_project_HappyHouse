package com.ssafy.vue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.dto.QNA;
import com.ssafy.vue.dto.QNAComment;
import com.ssafy.vue.service.JwtService;
import com.ssafy.vue.service.QNACommentService;
import com.ssafy.vue.service.QNAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("QNAController V1")
@RestController
@RequestMapping("/qna")
public class QNAController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private QNAService qService;
	
	@Autowired
	private QNACommentService qcService;
	
	@Autowired
	private JwtService jwtService;

    @ApiOperation(value = "Q&A 게시판 글 목록", notes = "Q&A 게시판 글의 정보를 반환한다.", response = List.class)
	@GetMapping
	// userid: 현재 로그인해있는 userid
	public ResponseEntity<List<QNA>> selectQNA() throws Exception {
		logger.debug("selectQNA - 호출");
		// userid가 "admin"이라면 모든 글 조회, 아니라면 공개 글 + 본인 아이디로 쓴 모든 글 조회
		return new ResponseEntity<List<QNA>>(qService.selectAllQNA(), HttpStatus.OK);
	}
    
    @ApiOperation(value = "Q&A 글보기", notes = "글번호에 해당하는 Q&A 글의 정보를 반환한다.", response = Map.class)    
	@GetMapping("{articleno}")
	public ResponseEntity<QNA> selectQNAByNo(@PathVariable int articleno) {
		logger.debug("selectQNAbyNo - 호출");
		// ???: 해당 articleno에 해당하는 댓글도 불러오기, 맞나?	
//		Map<QNA, List<QNAComment>> resultMap = new HashMap<>();
//		resultMap.put(qService.selectQNAByNo(articleno), qcService.retrieveQNAComment(articleno));
//		return new ResponseEntity<Map<QNA, List<QNAComment>>>(resultMap, HttpStatus.OK);
		QNA result = qService.selectQNAByNo(articleno);
		return new ResponseEntity<QNA>(result, HttpStatus.OK);
	}
    
//    @ApiOperation(value = "Q&A 게시판 글 목록", notes = "Q&A 게시판 글의 정보를 반환한다.", response = List.class)
//	@GetMapping("/title/{query}")
//	// userid: 현재 로그인해있는 userid
//	// query: 검색문
//	public ResponseEntity<List<QNA>> selectQNAByTitle(@PathVariable String query, @RequestBody String userid) throws Exception {
//		logger.debug("selectQNAByTitle - 호출");
//		// userid가 "admin"이라면 모든 글 조회, 아니라면 공개 글 + 본인 아이디로 쓴 모든 글 조회
//		if (userid.equals("admin")) {
//			return new ResponseEntity<List<QNA>>(qService.selectAllQNAByTitle(query), HttpStatus.OK);
//		}
//		return new ResponseEntity<List<QNA>>(qService.selectOpenQNAByTitle(query, userid), HttpStatus.OK);
//	}
//    
//    @ApiOperation(value = "Q&A 게시판 글 목록", notes = "Q&A 게시판 글의 정보를 반환한다.", response = List.class)
//	@GetMapping("/userid/{query}")
//	// userid: 현재 로그인해있는 userid
//	// query: 검색문
//	public ResponseEntity<List<QNA>> selectQNAByUserid(@PathVariable String query, @RequestBody String userid) throws Exception {
//		logger.debug("selectQNAByTitle - 호출");
//		// userid가 "admin"이거나 검색한 아이디가 현재 로그인해있는 userid라면 모든 글 조회, 아니라면 해당 queryid로 검색한 공개글만 조회
//		if (userid.equals("admin") || query.equals(userid)) {
//			return new ResponseEntity<List<QNA>>(qService.selectAllQNAByUserid(query), HttpStatus.OK);
//		}
//		return new ResponseEntity<List<QNA>>(qService.selectOpenQNAByUserid(query), HttpStatus.OK);
//	}
    
    @ApiOperation(value = "Q&A 글 등록", notes = "새로운 Q&A 글을 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertQNA(@RequestBody QNA qna, HttpServletRequest request) throws Exception {
		logger.debug("insertQNA - 호출");
		String token = request.getHeader("access-token");
		   logger.debug("token : {}",token);
		   if(!jwtService.isUsable(token)){
			   return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
		   }
		
		   String userid = jwtService.getUserIdByToken(token);
		
		  logger.debug("userid : {}", userid);
		  if (!qna.getUserid().equals(userid)) return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		if (qService.insertQNA(qna) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "Q&A 글 수정", notes = "Q&A 글 번호에 해당하는 Q&A를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{articleno}")
	public ResponseEntity<String> updateQNA(@RequestBody QNA qna, HttpServletRequest request) throws Exception {
		logger.debug("updateQNA - 호출");
		
//		
		String token = request.getHeader("access-token");
		logger.debug("token : {}",token);
		if(!jwtService.isUsable(token)){
			return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		String userid = jwtService.getUserIdByToken(token);
		logger.debug("userId : {}",userid);
		
		  if (!qna.getUserid().equals(userid)) return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
		if (qService.updateQNA(qna, userid) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "Q&A 글 삭제", notes = "Q&A 글을 삭제한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{articleno}")
	public ResponseEntity<String> deleteQNA(@PathVariable int articleno, HttpServletRequest request) throws Exception {
		logger.debug("deleteQNA - 호출");
//		
		String token = request.getHeader("access-token");

		logger.debug("token : {}",token);
		if(!jwtService.isUsable(token)){
			return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
		}

		String userid = jwtService.getUserIdByToken(token);

		logger.debug("userId : {}",userid);
		if (qService.deleteQNA(articleno, userid) == 1) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
}
