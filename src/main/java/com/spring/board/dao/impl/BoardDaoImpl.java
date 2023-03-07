package com.spring.board.dao.impl;
 
import com.spring.board.dao.BoardDao;
import com.spring.board.vo.BoardVo;
import com.spring.board.vo.CodeVo;
import com.spring.board.vo.PageVo;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

	@Repository
	public class BoardDaoImpl implements BoardDao{

		@Autowired
		private SqlSession sqlSession;
		
		public String selectTest() throws Exception{
			String a = sqlSession.selectOne("board.boardList");
			return a;
		}
		
		public List<BoardVo> selectBoardList(PageVo pageVo) throws Exception{
			return sqlSession.selectList("board.boardList", pageVo);
		}
   
		public int selectBoardCnt(PageVo pageVo) throws Exception{
			return sqlSession.selectOne("board.boardTotal", pageVo);
		}

		public BoardVo selectBoard(BoardVo boardVo) throws Exception{
			return sqlSession.selectOne("board.boardView", boardVo);
		}
		
		public int boardInsert(BoardVo boardVo) throws Exception{
			return sqlSession.insert("board.boardInsert", boardVo);
		}
		
		@Override
		public List<CodeVo> selectCode() throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.selectList("board.selectCode");
		}
		
		@Override
		public int boardDelete(BoardVo boardVo) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.delete("board.boardDelete", boardVo);
		}
		
		@Override
		public int boardUpdate(BoardVo boardVo) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.update("board.boardUpdate", boardVo);
		}
		
		@Override
		public int boardViewCnt(BoardVo boardVo) throws Exception {
			// TODO Auto-generated method stub
			return sqlSession.update("board.boardViewCnt", boardVo);
		}
}
