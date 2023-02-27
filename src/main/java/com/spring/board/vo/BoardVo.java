/*    */ package com.spring.board.vo;
/*    */ 
/*    */ public class BoardVo
/*    */ {
/*    */   private String boardType;
/*    */   private int boardNum;
/*    */   private String boardTitle;
/*    */   private String boardComment;
/*    */   private String creator;
/*    */   private String modifier;
/*    */   private int totalCnt;
/*    */ 
/*    */   public int getTotalCnt()
/*    */   {
/* 15 */     return this.totalCnt;
/*    */   }
/*    */   public void setTotalCnt(int totalCnt) {
/* 18 */     this.totalCnt = totalCnt;
/*    */   }
/*    */   public int getBoardNum() {
/* 21 */     return this.boardNum;
/*    */   }
/*    */   public void setBoardNum(int boardNum) {
/* 24 */     this.boardNum = boardNum;
/*    */   }
/*    */   public String getBoardType() {
/* 27 */     return this.boardType;
/*    */   }
/*    */   public void setBoardType(String boardType) {
/* 30 */     this.boardType = boardType;
/*    */   }
/*    */   public String getBoardTitle() {
/* 33 */     return this.boardTitle;
/*    */   }
/*    */   public void setBoardTitle(String boardTitle) {
/* 36 */     this.boardTitle = boardTitle;
/*    */   }
/*    */   public String getBoardComment() {
/* 39 */     return this.boardComment;
/*    */   }
/*    */   public void setBoardComment(String boardComment) {
/* 42 */     this.boardComment = boardComment;
/*    */   }
/*    */   public String getCreator() {
/* 45 */     return this.creator;
/*    */   }
/*    */   public void setCreator(String creator) {
/* 48 */     this.creator = creator;
/*    */   }
/*    */   public String getModifier() {
/* 51 */     return this.modifier;
/*    */   }
/*    */   public void setModifier(String modifier) {
/* 54 */     this.modifier = modifier;
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.board.vo.BoardVo
 * JD-Core Version:    0.6.2
 */