package com.spring.board.controller;

import com.spring.board.HomeController;
import com.spring.board.service.boardService;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;
import com.spring.board.vo.PageVo;
import com.spring.common.CommonUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class BoardController{

	@Autowired
	boardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//페이징....
	@RequestMapping(value="/board/boardList.do", method = RequestMethod.GET)
	public String boardList(HttpServletRequest request,Locale locale, Model model, PageVo pageVo) throws Exception{
		
		//리스트 페이지의 체크박스 검색 구현을 위함
		List<CodeVo> codeList = new ArrayList();
		List<BoardVo> boardList = new ArrayList();
	
		int page = 1;
		int totalCnt = 0;
		
		if (pageVo.getPageNo() == 0) {
			pageVo.setPageNo(page);
		}
		
		boardList = boardService.SelectBoardList(pageVo);
		totalCnt = boardService.selectBoardCnt(pageVo);
		codeList = boardService.selectCode();
		
		pageVo.setPageNo(pageVo.getPageNo());
		pageVo.setTotalCount(totalCnt);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("totalCnt", totalCnt);
		model.addAttribute("pageNo", pageVo.getPageNo());
		model.addAttribute("codeList", codeList);
		model.addAttribute("pageVo", pageVo);
		
		//출력확인
		System.out.println("Start :" + pageVo.getStartPage() + "  " + "End :" + pageVo.getEndPage());
		System.out.println("pageNo : " + pageVo.getPageNo());
		System.out.println("tempEndPage : " + pageVo.getTempEndPage());

		return "board/boardList";
		
	}
	
	//////
	@RequestMapping(value="/board/boardListAction.do", method = RequestMethod.POST)
	@ResponseBody
	public Object boardSelect(HttpServletRequest request, Locale locale
							, Model model, PageVo pageVo
							, @RequestParam(value="codeList[]") List<String> codeList) throws Exception{
		
		System.out.println("여기 들어왔니???");
		for(String coList : codeList) {
			System.out.println(coList);
		}
		//System.out.println("codeId :::::::::" + codeList);
		
		Map<String, Object> retVal = new HashMap<String, Object>();
		
		retVal.put("code", "ok");
		retVal.put("message", "성공");
		
		return retVal;
	}
	
	//리스트
	@RequestMapping(value="/board/boardList2.do", method = RequestMethod.GET)
	public String boardList2(Locale locale, Model model, PageVo pageVo) throws Exception{
		
		//리스트 페이지의 체크박스 검색 구현을 위함
		List<CodeVo> codeList = new ArrayList();
		List<BoardVo> boardList = new ArrayList();
	
		int page = 1;
		int totalCnt = 0;

		if (pageVo.getPageNo() == 0) {
			pageVo.setPageNo(page);
		}
 
		boardList = this.boardService.SelectBoardList(pageVo);
		totalCnt = this.boardService.selectBoardCnt(pageVo);
		codeList = boardService.selectCode();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("totalCnt", Integer.valueOf(totalCnt));
		model.addAttribute("pageNo", Integer.valueOf(page));
		model.addAttribute("codeList", codeList);

		return "board/boardList2";
	}
	
	//상세보기
	@RequestMapping(value="/board/{boardType}/{boardNum}/boardView.do", method = RequestMethod.GET)
	public String boardView(Locale locale, Model model
							, @PathVariable("boardType") String boardType
							, @PathVariable("boardNum") int boardNum)  throws Exception{

		BoardVo boardVo = new BoardVo();
 
		boardVo = boardService.selectBoard(boardType, boardNum);
		boardService.boardViewCnt(boardVo);  //조회수

		model.addAttribute("boardType", boardType);
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("board", boardVo);
		
		System.out.println("출력확인!!");
		System.out.println("boardType : " + boardType);
		System.out.println("boardNum : " + boardNum);
		System.out.println("View Cnt : " + boardVo.getViewCnt());

		return "board/boardView";
	}

	//작성
	@RequestMapping(value="/board/boardWrite.do", method = RequestMethod.GET)
	public String boardWrite(Locale locale, Model model) throws Exception{
		System.out.println("작성페이지 입니다.");
		
		List<CodeVo> codeList = new ArrayList();
		
		codeList = boardService.selectCode();
		logger.info("codeList {} ", codeList);
		
		model.addAttribute("codeList", codeList);
		
		return "board/boardWrite";
	}
	
	@RequestMapping(value="/board/boardWriteAction.do",method = RequestMethod.POST)
	@ResponseBody
	public String boardWriteAction(Locale locale, BoardVo boardVo) throws Exception {
		HashMap result = new HashMap();
		CommonUtil commonUtil = new CommonUtil();

		int resultCnt = this.boardService.boardInsert(boardVo);

		result.put("success", resultCnt > 0 ? "Y" : "N");
		String callbackMsg = CommonUtil.getJsonCallBackString(" ", result);

		System.out.println("callbackMsg::" + callbackMsg);
 
		return callbackMsg;
	}
	
	//삭제
	@RequestMapping(value="/board/boardDeleteAction.do",method = RequestMethod.POST)
	@ResponseBody
	public String boardDeleteAction(Locale locale, BoardVo boardVo) throws Exception {
		
		HashMap<String, String> rslt = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		
		int rsltCnt = boardService.boardDelete(boardVo);
		
		//삭제 성공 시 1을 반환, 실패 시 0
		rslt.put("success", (rsltCnt > 0) ?"Y":"N");
		rslt.put("boardType", boardVo.getBoardType());
		rslt.put("boardNum", String.valueOf(boardVo.getBoardNum()));  //정수를 숫자형으로
		
		String cbMsg = commonUtil.getJsonCallBackString(" ", rslt);
		System.out.println("msg : " + cbMsg);
		
		return cbMsg;
	}
	
	//업데이트
	@RequestMapping(value="/board/{boardType}/{boardNum}/boardUpdate.do", method = RequestMethod.GET)
	public String boardUpdate(Locale locale, Model model
							, @PathVariable("boardType") String boardType
							, @PathVariable("boardNum") int boardNum)  throws Exception{

		BoardVo boardVo = new BoardVo();
 
		boardVo = boardService.selectBoard(boardType, boardNum);

		model.addAttribute("boardType", boardType);
		model.addAttribute("boardNum", boardNum);
		model.addAttribute("board", boardVo);

		return "board/boardUpdate";
	}
	
	//업데이트 POST
	@RequestMapping(value="/board/boardUpdateAction.do",  method = RequestMethod.POST)
	@ResponseBody
	public String boardUpdateAction(Locale locale, Model model, BoardVo boardVo) throws Exception {
		
		HashMap<String, String> result = new HashMap<String, String>();
		CommonUtil commonUtil = new CommonUtil();
		
		int resultCount = boardService.boardUpdate(boardVo);
		
		//삭제 성공 시 1을 반환, 실패 시 0
		result.put("success", (resultCount > 0) ?"Y":"N");
		result.put("boardType", boardVo.getBoardType());
		result.put("boardNum", String.valueOf(boardVo.getBoardNum()));  //정수를 숫자형으로
		
		String cbackMsg = commonUtil.getJsonCallBackString(" ", result);
		System.out.println("cbackMsg :: " + cbackMsg);
		
		return cbackMsg;
	}
	
}