/*    */ package com.spring.board.controller;
/*    */ 
/*    */ import com.spring.board.HomeController;
/*    */ import com.spring.board.service.boardService;
/*    */ import com.spring.board.vo.BoardVo;
/*    */ import com.spring.board.vo.PageVo;
/*    */ import com.spring.common.CommonUtil;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.ui.Model;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ @Controller
/*    */ public class BoardController
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   boardService boardService;
/* 35 */   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
/*    */ 
/*    */   @RequestMapping(value={"/board/boardList.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String boardList(Locale locale, Model model, PageVo pageVo) throws Exception
/*    */   {
/* 40 */     List boardList = new ArrayList();
/*    */ 
/* 42 */     int page = 1;
/* 43 */     int totalCnt = 0;
/*    */ 
/* 45 */     if (pageVo.getPageNo() == 0) {
/* 46 */       pageVo.setPageNo(page);
/*    */     }
/*    */ 
/* 49 */     boardList = this.boardService.SelectBoardList(pageVo);
/* 50 */     totalCnt = this.boardService.selectBoardCnt();
/*    */ 
/* 52 */     model.addAttribute("boardList", boardList);
/* 53 */     model.addAttribute("totalCnt", Integer.valueOf(totalCnt));
/* 54 */     model.addAttribute("pageNo", Integer.valueOf(page));
/*    */ 
/* 56 */     return "board/boardList";
/*    */   }
/*    */ 
/*    */   @RequestMapping(value={"/board/{boardType}/{boardNum}/boardView.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String boardView(Locale locale, Model model, @PathVariable("boardType") String boardType, @PathVariable("boardNum") int boardNum)
/*    */     throws Exception
/*    */   {
/* 64 */     BoardVo boardVo = new BoardVo();
/*    */ 
/* 67 */     boardVo = this.boardService.selectBoard(boardType, boardNum);
/*    */ 
/* 69 */     model.addAttribute("boardType", boardType);
/* 70 */     model.addAttribute("boardNum", Integer.valueOf(boardNum));
/* 71 */     model.addAttribute("board", boardVo);
/*    */ 
/* 73 */     return "board/boardView";
/*    */   }
/*    */ 
/*    */   @RequestMapping(value={"/board/boardWrite.do"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String boardWrite(Locale locale, Model model)
/*    */     throws Exception
/*    */   {
/* 80 */     return "board/boardWrite";
/*    */   }
/*    */ 
/*    */   @RequestMapping(value={"/board/boardWriteAction.do"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @ResponseBody
/*    */   public String boardWriteAction(Locale locale, BoardVo boardVo) throws Exception {
/* 87 */     HashMap result = new HashMap();
/* 88 */     CommonUtil commonUtil = new CommonUtil();
/*    */ 
/* 90 */     int resultCnt = this.boardService.boardInsert(boardVo);
/*    */ 
/* 92 */     result.put("success", resultCnt > 0 ? "Y" : "N");
/* 93 */     String callbackMsg = CommonUtil.getJsonCallBackString(" ", result);
/*    */ 
/* 95 */     System.out.println("callbackMsg::" + callbackMsg);
/*    */ 
/* 97 */     return callbackMsg;
/*    */   }
/*    */ }

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.board.controller.BoardController
 * JD-Core Version:    0.6.2
 */