/*    */ package com.spring.common;
/*    */ 
/*    */ import com.spring.board.HomeController;
/*    */ import java.io.IOException;
/*    */ import org.codehaus.jackson.JsonProcessingException;
/*    */ import org.codehaus.jackson.map.ObjectMapper;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ public class CommonUtil
/*    */ {
/* 14 */   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
/*    */ 
/*    */   public static String getJsonCallBackString(String callback, Object obj)
/*    */     throws IOException
/*    */   {
/* 26 */     StringBuffer sb = new StringBuffer();
/*    */ 
/* 29 */     sb.append(toJson(obj));
/*    */ 
/* 32 */     return sb.toString();
/*    */   }
/*    */ 
/*    */   public static String toJson(Object obj)
/*    */     throws IOException
/*    */   {
/* 43 */     String rtnStr = "";
/*    */ 
/* 45 */     ObjectMapper objectMapper = new ObjectMapper();
/*    */     try
/*    */     {
/* 51 */       rtnStr = objectMapper.writeValueAsString(obj);
/*    */     } catch (JsonProcessingException e) {
/* 53 */       logger.debug("toJson parsing Error", e);
/*    */     }
/* 55 */     return rtnStr;
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.common.CommonUtil
 * JD-Core Version:    0.6.2
 */