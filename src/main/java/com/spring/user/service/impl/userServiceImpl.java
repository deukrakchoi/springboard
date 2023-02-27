/*    */ package com.spring.user.service.impl;
/*    */ 
/*    */ import com.spring.user.dao.UserDao;
/*    */ import com.spring.user.service.userService;
/*    */ import com.spring.user.vo.UserVo;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service
/*    */ public class userServiceImpl
/*    */   implements userService
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   UserDao userDao;
/*    */ 
/*    */   public int userInsert(UserVo userVo)
/*    */     throws Exception
/*    */   {
/* 19 */     return this.userDao.userInsert(userVo);
/*    */   }
/*    */ 
/*    */   public int userIdChk(String userId)
/*    */     throws Exception
/*    */   {
/* 25 */     return this.userDao.userIdChk(userId);
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.user.service.impl.userServiceImpl
 * JD-Core Version:    0.6.2
 */