package com.spring.board.dao;

import com.spring.board.vo.BoardVo;
import com.spring.board.vo.PageVo;
import java.util.List;

public abstract interface BoardDao
{
  public abstract String selectTest()
    throws Exception;

  public abstract List<BoardVo> selectBoardList(PageVo paramPageVo)
    throws Exception;

  public abstract BoardVo selectBoard(BoardVo paramBoardVo)
    throws Exception;

  public abstract int selectBoardCnt()
    throws Exception;

  public abstract int boardInsert(BoardVo paramBoardVo)
    throws Exception;
}

/* Location:           C:\workspace\springBoard\src\main\ImportedClasses\
 * Qualified Name:     com.spring.board.dao.BoardDao
 * JD-Core Version:    0.6.2
 */