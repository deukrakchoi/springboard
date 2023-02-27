/*    */ package com.spring.board.dao.impl;
/*    */ 
/*    */ import com.spring.board.dao.BoardDao;
/*    */ import com.spring.board.vo.BoardVo;
/*    */ import com.spring.board.vo.PageVo;
/*    */ import java.util.List;
/*    */ import org.apache.ibatis.session.SqlSession;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class BoardDaoImpl
/*    */   implements BoardDao
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SqlSession sqlSession;
/*    */ 
/*    */   public String selectTest()
/*    */     throws Exception
/*    */   {
/* 23 */     String a = (String)this.sqlSession.selectOne("board.boardList");
/*    */ 
/* 25 */     return a;
/*    */   }
/*    */ 
/*    */   public List<BoardVo> selectBoardList(PageVo pageVo)
/*    */     throws Exception
/*    */   {
/* 33 */     return this.sqlSession.selectList("board.boardList", pageVo);
/*    */   }
/*    */ 
/*    */   public int selectBoardCnt()
/*    */     throws Exception
/*    */   {
/* 39 */     return ((Integer)this.sqlSession.selectOne("board.boardTotal")).intValue();
/*    */   }
/*    */ 
/*    */   public BoardVo selectBoard(BoardVo boardVo)
/*    */     throws Exception
/*    */   {
/* 45 */     return (BoardVo)this.sqlSession.selectOne("board.boardView", boardVo);
/*    */   }
/*    */ 
/*    */   public int boardInsert(BoardVo boardVo)
/*    */     throws Exception
/*    */   {
/* 51 */     return this.sqlSession.insert("board.boardInsert", boardVo);
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.board.dao.impl.BoardDaoImpl
 * JD-Core Version:    0.6.2
 */