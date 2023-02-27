/*    */ package com.spring.board;
/*    */ 
/*    */ import java.text.DateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.Locale;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ public class HomeController
/*    */ {
/* 20 */   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
/*    */ 
/*    */   @RequestMapping(value={"/index.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String home(Locale locale, Model model)
/*    */   {
/* 27 */     logger.info("Welcome home! The client locale is {}.", locale);
/*    */ 
/* 29 */     Date date = new Date();
/* 30 */     DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 1, locale);
/*    */ 
/* 32 */     String formattedDate = dateFormat.format(date);
/*    */ 
/* 34 */     model.addAttribute("serverTime", formattedDate);
/*    */ 
/* 36 */     return "home";
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.board.HomeController
 * JD-Core Version:    0.6.2
 */