package com.ssafy.vue.service;

import java.util.List;

import com.ssafy.vue.dto.Board;

public interface BoardService {
   public List<Board> retrieveBoard();
   public Board detailBoard(int articleno);
   public void updateHit(int articleno);
   public boolean writeBoard(Board board);
   public boolean updateBoard(Board board, String userid);
   public int deleteBoard(int articleno, String userid);
   public boolean like(int articleno, String userid);
   public boolean dislike(int articleno, String userid);
}