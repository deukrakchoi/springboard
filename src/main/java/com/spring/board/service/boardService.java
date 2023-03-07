package com.spring.board.service;

import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;
import com.spring.board.vo.PageVo;

import java.util.List;

public abstract interface boardService
{
  public String selectTest() throws Exception;

  public List<BoardVo> SelectBoardList(PageVo paramPageVo) throws Exception;

  public BoardVo selectBoard(String paramString, int paramInt) throws Exception;

  public int selectBoardCnt(PageVo pageVo) throws Exception;

  public int boardInsert(BoardVo paramBoardVo) throws Exception;

  public List<CodeVo> selectCode() throws Exception;

  public int boardDelete(BoardVo boardVo) throws Exception;

  public int boardUpdate(BoardVo boardVo) throws Exception;

  public int boardViewCnt(BoardVo boardVo) throws Exception;

}
