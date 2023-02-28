package com.spring.board.service;

import com.spring.board.vo.BoardVo;
import com.spring.board.vo.PageVo;
import java.util.List;

public abstract interface boardService
{
  public abstract String selectTest() throws Exception;

  public abstract List<BoardVo> SelectBoardList(PageVo paramPageVo) throws Exception;

  public abstract BoardVo selectBoard(String paramString, int paramInt) throws Exception;

  public abstract int selectBoardCnt() throws Exception;

  public abstract int boardInsert(BoardVo paramBoardVo) throws Exception;
}

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.board.service.boardService
 * JD-Core Version:    0.6.2
 */