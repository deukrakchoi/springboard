package com.spring.board.dao;

import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;
import com.spring.board.vo.PageVo;

import java.util.List;

public abstract interface BoardDao
{
	public String selectTest() throws Exception;
	
	public List<BoardVo> selectBoardList(PageVo PageVo) throws Exception;
	
	public BoardVo selectBoard(BoardVo BoardVo) throws Exception;

	public int selectBoardCnt(PageVo pageVo) throws Exception;

	public int boardInsert(BoardVo BoardVo) throws Exception;

	public List<CodeVo> selectCode() throws Exception;

	public int boardDelete(BoardVo boardVo) throws Exception;

	public int boardUpdate(BoardVo boardVo) throws Exception;

	public int boardViewCnt(BoardVo boardVo) throws Exception;
}