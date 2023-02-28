package com.spring.user.dao.impl;
 
import com.spring.user.dao.UserDao;
import com.spring.user.vo.UserVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

		 @Autowired
		 private SqlSession sqlSession;
		 
		 public int userInsert(UserVo userVo) throws Exception{
			 return sqlSession.insert("user.userInsert", userVo);
		 }
		 
		 public int userIdChk(String userId) throws Exception{
			 return sqlSession.selectOne("user.userIdChk", userId);
		 }
			
		@Override
		public List<UserVo> phoneOption() throws Exception {
			List<UserVo> userVo = new ArrayList<UserVo>();
			userVo = sqlSession.selectList("user.phoneOption");
			//System.out.println("userVo==1111111"+userVo);
			return userVo;
		}
		
		@Override
		public UserVo userLogin(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.userLogin", map);
		}
}