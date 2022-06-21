package com.ssafy.vue.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.dto.Board;
import com.ssafy.vue.dto.BoardDislike;
import com.ssafy.vue.dto.BoardLike;
import com.ssafy.vue.mapper.BoardCommentMapper;
import com.ssafy.vue.mapper.BoardDislikeMapper;
import com.ssafy.vue.mapper.BoardLikeMapper;
import com.ssafy.vue.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
   
    @Autowired
   private BoardMapper bMapper;
    
    @Autowired
    private BoardCommentMapper bcMapper;
    
    @Autowired
    private BoardLikeMapper blMapper;
    
    @Autowired
    private BoardDislikeMapper bdMapper;

    @Override
   public List<Board> retrieveBoard() {
      return bMapper.selectBoard();
   }
    
     @Override
   public boolean writeBoard(Board board) {
      return bMapper.insertBoard(board) == 1;
   }

   @Override
   public Board detailBoard(int articleno) {
      bMapper.updateHit(articleno);
      return bMapper.selectBoardByNo(articleno);
   }
   
   @Override
   public void updateHit(int articleno) {
      bMapper.updateHit(articleno);
   }


   @Override
   @Transactional
   public boolean updateBoard(Board board, String userid) {
      if(userid.equals("admin")){
         return bMapper.forceUpdateBoard(board) ==1;
      }
      Map<String, Object> updateInfo = new HashMap<>();
      updateInfo.put("board", board);
      updateInfo.put("userid",userid);
      return bMapper.updateBoard(updateInfo) == 1;
   }

   @Override
   @Transactional
   public int deleteBoard(int articleno, String userid) {
	   
	  if (userid.equals("admin")) {
		  return bMapper.forceDeleteBoard(articleno);
	  }
	  Map<String, Object> deleteInfo = new HashMap<>();
      deleteInfo.put("articleno", articleno);
      deleteInfo.put("userid",userid);
      return bMapper.deleteBoard(deleteInfo);
   }

   @Override
   public boolean like(int articleno, String userid) {
      if (blMapper.select(userid, articleno) == 0) {
         blMapper.create(new BoardLike(userid, articleno));
         bMapper.like(articleno);
         return true;
      }
      return false;
   }

   @Override
   public boolean dislike(int articleno, String userid) {
      // userid가 좋아요를 누르지 않았더라면
      if (bdMapper.select(userid, articleno) == 0) {
         bdMapper.create(new BoardDislike(userid, articleno));
         bMapper.dislike(articleno);
         return true;
      }
      return false;
   }
}