/*    */ package com.spring.user.dao.impl;
/*    */ 
/*    */ import com.spring.user.dao.UserDao;
/*    */ import com.spring.user.vo.UserVo;
/*    */ import org.apache.ibatis.session.SqlSession;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Repository;
/*    */ 
/*    */ @Repository
/*    */ public class UserDaoImpl
/*    */   implements UserDao
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private SqlSession sqlSession;
/*    */ 
/*    */   public int userInsert(UserVo userVo)
/*    */     throws Exception
/*    */   {
/* 22 */     return this.sqlSession.insert("user.userInsert", userVo);
/*    */   }
/*    */ 
/*    */   public int userIdChk(String userId)
/*    */     throws Exception
/*    */   {
/* 28 */     return ((Integer)this.sqlSession.selectOne("user.userIdChk", userId)).intValue();
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.user.dao.impl.UserDaoImpl
 * JD-Core Version:    0.6.2
 */