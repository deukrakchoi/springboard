/*    */ package com.spring.user.controller;
/*    */ 
/*    */ import com.spring.board.HomeController;
/*    */ import com.spring.common.CommonUtil;
/*    */ import com.spring.user.service.userService;
/*    */ import com.spring.user.vo.UserVo;
/*    */ import java.io.PrintStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Locale;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class UserController
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   userService userService;
/* 26 */   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
/*    */ 
/*    */   @RequestMapping(value={"/user/userJoin.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String userJoin(Locale locale, Model model)
/*    */     throws Exception
/*    */   {
/* 32 */     System.out.println("회원가입 페이지입니다.");
/*    */ 
/* 34 */     return "user/userJoin";
/*    */   }
/*    */ 
/*    */   @RequestMapping(value={"/user/userJoinAction.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @ResponseBody
/*    */   public String userJoinAction(Locale locale, UserVo userdVo) throws Exception {
/* 41 */     HashMap rslt = new HashMap();
/* 42 */     CommonUtil commonUtil = new CommonUtil();
/*    */ 
/* 44 */     int rsltCnt = this.userService.userInsert(userdVo);
/*    */ 
/* 46 */     rslt.put("success", rsltCnt > 0 ? "Y" : "N");
/* 47 */     String callbackMsg = CommonUtil.getJsonCallBackString(" ", rslt);
/*    */ 
/* 49 */     System.out.println("callbackMsg :: " + callbackMsg);
/*    */ 
/* 51 */     return callbackMsg;
/*    */   }
/*    */ 
/*    */   @RequestMapping(value={"/user/userIdChk.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @ResponseBody
/*    */   public boolean userIdChk(String userId) throws Exception {
/* 58 */     boolean status = true;
/* 59 */     int checkNum = this.userService.userIdChk(userId);
/* 60 */     System.out.println(checkNum);
/*    */ 
/* 62 */     if (checkNum == 1) {
/* 63 */       System.out.println("중복된 아이디 입니다.");
/* 64 */       status = false;
/*    */     } else {
/* 66 */       System.out.println("사용가능한 아이디 입니다.");
/* 67 */       status = true;
/*    */     }
/* 69 */     return status;
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.user.controller.UserController
 * JD-Core Version:    0.6.2
 */