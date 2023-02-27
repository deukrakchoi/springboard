/*    */ package com.spring.board.service.impl;
/*    */ 
/*    */ import com.spring.board.dao.BoardDao;
/*    */ import com.spring.board.service.boardService;
/*    */ import com.spring.board.vo.BoardVo;
/*    */ import com.spring.board.vo.PageVo;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class boardServiceImpl
/*    */   implements boardService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   BoardDao boardDao;
/*    */ 
/*    */   public String selectTest()
/*    */     throws Exception
/*    */   {
/* 22 */     return this.boardDao.selectTest();
/*    */   }
/*    */ 
/*    */   public List<BoardVo> SelectBoardList(PageVo pageVo)
/*    */     throws Exception
/*    */   {
/* 29 */     return this.boardDao.selectBoardList(pageVo);
/*    */   }
/*    */ 
/*    */   public int selectBoardCnt()
/*    */     throws Exception
/*    */   {
/* 35 */     return this.boardDao.selectBoardCnt();
/*    */   }
/*    */ 
/*    */   public BoardVo selectBoard(String boardType, int boardNum)
/*    */     throws Exception
/*    */   {
/* 41 */     BoardVo boardVo = new BoardVo();
/*    */ 
/* 43 */     boardVo.setBoardType(boardType);
/* 44 */     boardVo.setBoardNum(boardNum);
/*    */ 
/* 46 */     return this.boardDao.selectBoard(boardVo);
/*    */   }
/*    */ 
/*    */   public int boardInsert(BoardVo boardVo)
/*    */     throws Exception
/*    */   {
/* 52 */     return this.boardDao.boardInsert(boardVo);
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.board.service.impl.boardServiceImpl
 * JD-Core Version:    0.6.2
 */