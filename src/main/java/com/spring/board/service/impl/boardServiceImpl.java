package com.spring.board.service.impl;

import com.spring.board.dao.BoardDao;
import com.spring.board.service.boardService;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;
import com.spring.board.vo.PageVo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class boardServiceImpl implements boardService{

	@Autowired
	BoardDao boardDao;

	public String selectTest() throws Exception{
		return boardDao.selectTest();
	}
 
	public List<BoardVo> SelectBoardList(PageVo pageVo) throws Exception{
		return boardDao.selectBoardList(pageVo);
	}
 
	public int selectBoardCnt(PageVo pageVo) throws Exception{
		return boardDao.selectBoardCnt(pageVo);
	}
 
	public BoardVo selectBoard(String boardType, int boardNum) throws Exception{
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBoardType(boardType);
		boardVo.setBoardNum(boardNum);
 
		return boardDao.selectBoard(boardVo);
	}
 
	public int boardInsert(BoardVo boardVo) throws Exception{
		
		return boardDao.boardInsert(boardVo);
	}

	@Override
	public List<CodeVo> selectCode() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.selectCode();
	}
	
	@Override
	public int boardDelete(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.boardDelete(boardVo);
	}
	
	@Override
	public int boardUpdate(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		
		return boardDao.boardUpdate(boardVo);
	}
	
	@Override
	public int boardViewCnt(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.boardViewCnt(boardVo);
	}
	
}
