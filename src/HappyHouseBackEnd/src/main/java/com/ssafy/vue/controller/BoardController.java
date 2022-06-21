package com.ssafy.vue.controller;

import java.util.List;

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

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.mapper.BoardLikeMapper;
import com.ssafy.vue.service.BoardService;
import com.ssafy.vue.service.JwtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("BoardController V1")
@RestController
@RequestMapping("/board")
//@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class BoardController {

   private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
   private static final String SUCCESS = "success";
   private static final String FAIL = "fail";

   @Autowired
   private BoardService boardService;
   
   @Autowired
   private BoardLikeMapper blMapper;
   
   @Autowired
   private JwtService jwtService;

   @ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
   @GetMapping
   public ResponseEntity<List<Board>> retrieveBoard() throws Exception {
      logger.debug("retrieveBoard - 호출");
      return new ResponseEntity<List<Board>>(boardService.retrieveBoard(), HttpStatus.OK);
   }

    @ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = Board.class)    
   @GetMapping("{articleno}")
   public ResponseEntity<Board> detailBoard(@PathVariable int articleno) {
      logger.debug("detailBoard - 호출");
      return new ResponseEntity<Board>(boardService.detailBoard(articleno), HttpStatus.OK);
   }

    @ApiOperation(value = "게시판 글등록", notes = "새로운 게시글 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
   @PostMapping
   public ResponseEntity<String> writeBoard(@RequestBody Board board, HttpServletRequest request) throws Exception {
      logger.debug("writeBoard - 호출");
      String token = request.getHeader("access-token");
	   logger.debug("token : {}",token);
	   if(!jwtService.isUsable(token)){
		   return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
	   }
	
	   String userid = jwtService.getUserIdByToken(token);
	
	  logger.debug("userid : {}", userid);
	  if (!board.getUserid().equals(userid)) return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
      if (boardService.writeBoard(board)) {
         return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
      }
      return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
   }

//    @ApiOperation(value = "게시판 글정보 수정", notes = "글번호에 해당하는 게시글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
//   @PutMapping("{articleno}")
//    public ResponseEntity<String> updateBoard(@RequestBody Board board, HttpServletRequest request) throws Exception {
////      logger.debug("updateBoard - 호출");
////
////      String token = request.getHeader("access-token");
////
////      logger.debug("token : {}",token);
////      if(!jwtService.isUsable(token)){
////         return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
////      }
////
////      String userid = jwtService.getUserIdByToken(token);
////
////      logger.debug("userId : {}",userid);
//
//      if (boardService.updateBoard(board, "admin")) {
//         return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//      }
//      return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//   }

   @ApiOperation(value = "게시판 글삭제", notes = "글번호에 해당하는 게시글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
   @DeleteMapping("{articleno}")
    public ResponseEntity<String> deleteBoard(@PathVariable int articleno, HttpServletRequest request) throws Exception {
	   logger.debug("deleteBoard - 호출");

	   String token = request.getHeader("access-token");
	   logger.debug("token : {}",token);
	   if(!jwtService.isUsable(token)){
		   return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
	   }
	
	   String userid = jwtService.getUserIdByToken(token);
	
	   logger.debug("userId : {}", userid);
	   if (boardService.deleteBoard(articleno, userid) == 1) {
		   return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	   }
	   return new ResponseEntity<String>(FAIL, HttpStatus.OK);
   }
    
   @ApiOperation(value = "게시판 글 좋아요", notes = "글번호에 해당하는 게시글에 좋아요를 누른다. 그리고 좋아요 성공 여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
   @PutMapping("{articleno}/like")
    public ResponseEntity<String> likeBoard(@PathVariable int articleno, HttpServletRequest request) throws Exception {
	   logger.debug("likeBoard - 호출");

	   String token = request.getHeader("access-token");
	   logger.debug("token : {}",token);
	   if(!jwtService.isUsable(token)){
		   return new ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED);
	   }
	
	   String userid = jwtService.getUserIdByToken(token);
	   logger.debug("userId : {}", userid);
      if (blMapper.select(userid, articleno) == 0 && boardService.like(articleno, userid)) {
         return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
      }
      return new ResponseEntity<String>(FAIL, HttpStatus.OK);
   }
}
	/*
	 * 안 쓸 듯.
	 * @ApiOperation(value = "게시판 글 싫어요", notes =
	 * "글번호에 해당하는 게시글에 싫어요를 누른다. 그리고 싫어요 성공 여부에 따라 'success' 또는 'fail' 문자열을 반환한다.",
	 * response = String.class)
	 * 
	 * @GetMapping("{articleno}/dislike") public ResponseEntity<String>
	 * dislikeBoard(@PathVariable int articleno, HttpServletRequest request) throws
	 * Exception { logger.debug("dislikeBoard - 호출");
	 * 
	 * String token = request.getHeader("access-token");
	 * logger.debug("token : {}",token);
	 * 
	 * //발행된 토큰이 존재하지 않는다면 if(!jwtService.isUsable(token)){ return new
	 * ResponseEntity<String>(FAIL, HttpStatus.UNAUTHORIZED); }
	 * 
	 * String userid = jwtService.getUserIdByToken(token);
	 * 
	 * logger.debug("userId : {}", userid); if (blMapper.select(userid, articleno)
	 * == 0 && boardService.dislike(articleno, userid)) { return new
	 * ResponseEntity<String>(SUCCESS, HttpStatus.OK); } return new
	 * ResponseEntity<String>(FAIL, HttpStatus.OK); }
	 */
